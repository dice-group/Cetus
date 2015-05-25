package org.aksw.simba.cetus.web;

import javax.annotation.PostConstruct;

import org.aksw.gerbil.transfer.nif.Document;
import org.aksw.gerbil.transfer.nif.TurtleNIFDocumentCreator;
import org.aksw.gerbil.transfer.nif.TurtleNIFDocumentParser;
import org.aksw.simba.cetus.annotator.CetusAnnotator;
import org.aksw.simba.cetus.annotator.CetusSurfaceFormExtractor;
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

    private CetusAnnotator yagoBasedAnnotator;

    private TurtleNIFDocumentParser parser = new TurtleNIFDocumentParser();
    private TurtleNIFDocumentCreator creator = new TurtleNIFDocumentCreator();

    @PostConstruct
    public void init() {
        yagoBasedAnnotator = new CetusAnnotator(extractor, yagoBasedSearcher);
    }

    @RequestMapping("/yago")
    public @ResponseBody
    String config(@RequestBody String data) {
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

}
