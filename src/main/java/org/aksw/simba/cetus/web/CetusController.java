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
package org.aksw.simba.cetus.web;

import javax.annotation.PostConstruct;

import org.aksw.gerbil.transfer.nif.Document;
import org.aksw.gerbil.transfer.nif.TurtleNIFDocumentCreator;
import org.aksw.gerbil.transfer.nif.TurtleNIFDocumentParser;
import org.aksw.simba.cetus.annotator.CetusAnnotator;
import org.aksw.simba.cetus.annotator.CetusSurfaceFormExtractor;
import org.aksw.simba.cetus.fox.FoxBasedTypeSearcher;
import org.aksw.simba.cetus.yago.YagoBasedTypeSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CetusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CetusController.class);

    @Autowired
    private CetusSurfaceFormExtractor extractor;

    @Autowired
    private YagoBasedTypeSearcher yagoBasedSearcher;

    @Autowired
    private FoxBasedTypeSearcher foxBasedTypeSearcher;

    private CetusAnnotator yagoBasedAnnotator;
    private CetusAnnotator foxBasedAnnotator;

    private TurtleNIFDocumentParser parser = new TurtleNIFDocumentParser();
    private TurtleNIFDocumentCreator creator = new TurtleNIFDocumentCreator();

    @PostConstruct
    public void init() {
        yagoBasedAnnotator = new CetusAnnotator(extractor, yagoBasedSearcher);
        foxBasedAnnotator = new CetusAnnotator(extractor, foxBasedTypeSearcher);
    }

    @RequestMapping("/yago")
    public @ResponseBody
    String yago(@RequestBody String data) {
        Document document = null;
        try {
            document = parser.getDocumentFromNIFString(data);
        } catch (Exception e) {
            LOGGER.error("Exception while parsing NIF string.", e);
            throw new IllegalArgumentException("Couldn't parse the given NIF document.");
        }
        document = yagoBasedAnnotator.performTypeExtraction(document);
        return creator.getDocumentAsNIFString(document);
    }

    @RequestMapping("/fox")
    public @ResponseBody
    String fox(@RequestBody String data) {
        Document document = null;
        try {
            document = parser.getDocumentFromNIFString(data);
        } catch (Exception e) {
            LOGGER.error("Exception while parsing NIF string.", e);
            throw new IllegalArgumentException("Couldn't parse the given NIF document.");
        }
        document = foxBasedAnnotator.performTypeExtraction(document);
        return creator.getDocumentAsNIFString(document);
    }

}
