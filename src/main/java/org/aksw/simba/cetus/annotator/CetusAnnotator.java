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
package org.aksw.simba.cetus.annotator;

import java.util.List;
import java.util.Map;

import org.aksw.gerbil.transfer.nif.Document;
import org.aksw.gerbil.transfer.nif.data.DocumentImpl;
import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.simba.cetus.datatypes.ExtendedTypedNamedEntity;

public class CetusAnnotator {

    private CetusSurfaceFormExtractor surfaceFormExtractor;
    private CetusTypeSearcher typeSearcher;

    public CetusAnnotator(CetusSurfaceFormExtractor surfaceFormExtractor, CetusTypeSearcher typeSearcher) {
        this.surfaceFormExtractor = surfaceFormExtractor;
        this.typeSearcher = typeSearcher;
    }

    public Document performTypeExtraction(Document document) {
        // extract the surface forms
        // List<List<NamedEntity>> types =
        // surfaceFormExtractor.extractTypeSurfaceForms(document);
        // TypingInfoImpl typingInfo = new TypingInfoImpl();
        // // TODO find a type for every type surface form that has been found
        // List<NamedEntity> typesFound = linkTypes(types, typingInfo);
        // return new TypeExtractionResult(typesFound, typingInfo);
        Map<NamedEntity, List<ExtendedTypedNamedEntity>> extractedTypes = surfaceFormExtractor
                .extractTypeSurfaceForms(document);
        Document resultDoc = new DocumentImpl(document.getText(), document.getDocumentURI());
        List<ExtendedTypedNamedEntity> surfaceForms;
        for (NamedEntity ne : extractedTypes.keySet()) {
            surfaceForms = extractedTypes.get(ne);
            resultDoc.addMarking(typeSearcher.getAllTypes(document, ne, surfaceForms));
            resultDoc.getMarkings().addAll(surfaceForms);
        }
        return resultDoc;
    }
}
