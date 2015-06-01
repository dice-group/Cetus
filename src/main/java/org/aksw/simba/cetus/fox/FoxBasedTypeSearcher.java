/**
 * The MIT License
 * Copyright (c) 2015 Agile Knowledge Engineering and Semantic Web (AKSW) (usbeck@informatik.uni-leipzig.de)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.aksw.simba.cetus.fox;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashSet;
import java.util.List;

import org.aksw.gerbil.transfer.nif.Document;
import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.gerbil.transfer.nif.data.TypedNamedEntity;
import org.aksw.simba.cetus.annotator.CetusTypeSearcher;
import org.aksw.simba.cetus.datatypes.ExtendedTypedNamedEntity;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoxBasedTypeSearcher implements CetusTypeSearcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoxBasedTypeSearcher.class);

    private static final String FOX_SERVICE = "http://139.18.2.164:4444/call/ner/entities";

    private static final String PERSON_TYPE_URI = "scmsann:PERSON";
    private static final String LOCATION_TYPE_URI = "scmsann:LOCATION";
    private static final String ORGANIZATION_TYPE_URI = "scmsann:ORGANIZATION";

    private static final String DOLCE_PERSON_TYPE_URI = "http://www.ontologydesignpatterns.org/ont/dul/DUL.owl#Person";
    private static final String DOLCE_LOCATION_TYPE_URI = "http://www.ontologydesignpatterns.org/ont/d0.owl#Location";
    private static final String DOLCE_ORGANIZATION_TYPE_URI = "http://www.ontologydesignpatterns.org/ont/dul/DUL.owl#Organization";

    @Override
    public TypedNamedEntity getAllTypes(Document document, NamedEntity ne, List<ExtendedTypedNamedEntity> surfaceForms) {
        TypedNamedEntity tne = new TypedNamedEntity(ne.getStartPosition(), ne.getLength(), ne.getUris(),
                new HashSet<String>());
        for(ExtendedTypedNamedEntity surfaceForm : surfaceForms) {
            tne.getTypes().addAll(surfaceForm.getUris());
        }

        try {
            // request FOX
            Response response = Request
                    .Post(FOX_SERVICE)
                    .addHeader("Content-type", "application/json")
                    .addHeader("Accept-Charset", "UTF-8")
                    .body(new StringEntity(new JSONObject().put("input", document.getText()).put("type", "text")
                            .put("task", "ner").put("output", "JSON-LD").toString(), ContentType.APPLICATION_JSON))
                    .execute();

            HttpResponse httpResponse = response.returnResponse();
            HttpEntity entry = httpResponse.getEntity();

            String content = IOUtils.toString(entry.getContent(), "UTF-8");
            EntityUtils.consume(entry);

            // parse results
            JSONObject outObj = new JSONObject(content);
            if (outObj.has("@graph")) {

                JSONArray graph = outObj.getJSONArray("@graph");
                for (int i = 0; i < graph.length(); i++) {
                    parseType(graph.getJSONObject(i), tne, surfaceForms);
                }
            } else {
                parseType(outObj, tne, surfaceForms);
            }
        } catch (Exception e) {
            LOGGER.error("Got an exception while communicating with the FOX web service.", e);
        }
        return tne;
    }

    protected void parseType(JSONObject entity, TypedNamedEntity ne, List<ExtendedTypedNamedEntity> surfaceForms)
            throws Exception {
        try {

            if (entity != null && entity.has("means") && entity.has("beginIndex") && entity.has("ann:body")) {

                String uri = entity.getString("means");
                String body = entity.getString("ann:body");
                Object begin = entity.get("beginIndex");
                Object typeObject = entity.get("@type");
                String types[];
                if (typeObject instanceof JSONArray) {
                    JSONArray typeArray = (JSONArray) typeObject;
                    types = new String[typeArray.length()];
                    for (int i = 0; i < types.length; ++i) {
                        types[i] = typeArray.getString(i);
                    }
                } else {
                    types = new String[] { typeObject.toString() };
                }
                URLDecoder.decode(uri, "UTF-8");
                if (begin instanceof JSONArray) {
                    // for all indices
                    for (int i = 0; i < ((JSONArray) begin).length(); ++i) {
                        addTypeIfOverlapping(ne, Integer.valueOf(((JSONArray) begin).getString(i)), body.length(),
                                types);
                    }
                } else if (begin instanceof String) {
                    addTypeIfOverlapping(ne, Integer.valueOf((String) begin), body.length(), types);
                } else if (LOGGER.isDebugEnabled())
                    LOGGER.debug("Couldn't find index");
            }
        } catch (Exception e) {
            LOGGER.error("Got an Exception while parsing the response of FOX.", e);
            throw new Exception("Got an Exception while parsing the response of FOX.", e);
        }
    }

    private void addTypeIfOverlapping(TypedNamedEntity ne, int begin, int length, String[] types) {
        int neStart = ne.getStartPosition();
        int neEnd = neStart + ne.getLength();
        int end = begin + length;
        // FIXME We should also check the overlapping with extracted type
        // strings
        if (((neStart <= begin) && (neEnd > begin)) || ((neStart < end) && (neEnd >= end))
                || ((neStart <= begin) && (neEnd >= end)) || ((neStart < end) && (neEnd > begin))) {
            for (int i = 0; i < types.length; ++i) {
                switch (types[i]) {
                case PERSON_TYPE_URI: {
                    ne.getTypes().add(DOLCE_PERSON_TYPE_URI);
                    break;
                }
                case LOCATION_TYPE_URI: {
                    ne.getTypes().add(DOLCE_LOCATION_TYPE_URI);
                    break;
                }
                case ORGANIZATION_TYPE_URI: {
                    ne.getTypes().add(DOLCE_ORGANIZATION_TYPE_URI);
                    break;
                }
                }
            }
        }
    }

    public static void main(String[] args) throws UnsupportedCharsetException, ClientProtocolException, JSONException,
            IOException {
        Response response = Request
                .Post(FOX_SERVICE)
                .addHeader("Content-type", "application/json")
                .addHeader("Accept-Charset", "UTF-8")
                .body(new StringEntity(
                        new JSONObject()
                                .put("input",
                                        "Brian Banner is a fictional villain from the Marvel Comics Universe created by Bill Mantlo and Mike Mignola and first appearing in print in late 1985.")
                                .put("type", "text").put("task", "ner").put("output", "JSON-LD").toString(),
                        ContentType.APPLICATION_JSON)).execute();

        HttpResponse httpResponse = response.returnResponse();
        HttpEntity entry = httpResponse.getEntity();

        String content = IOUtils.toString(entry.getContent(), "UTF-8");
        System.out.println(content);
    }

}
