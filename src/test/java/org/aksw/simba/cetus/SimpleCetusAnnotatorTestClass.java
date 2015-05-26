package org.aksw.simba.cetus;

import java.util.Arrays;

import org.aksw.gerbil.transfer.nif.Document;
import org.aksw.gerbil.transfer.nif.Marking;
import org.aksw.gerbil.transfer.nif.data.DocumentImpl;
import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.simba.cetus.annotator.CetusAnnotator;
import org.aksw.simba.cetus.annotator.CetusSurfaceFormExtractor;
import org.aksw.simba.cetus.yago.YagoBasedTypeSearcher;
import org.junit.Ignore;

@Ignore
public class SimpleCetusAnnotatorTestClass {

    public static void main(String[] args) {
	CetusAnnotator annotator = new CetusAnnotator(
		CetusSurfaceFormExtractor.create(),
		YagoBasedTypeSearcher.create());
	Document document = annotator
		.performTypeExtraction(new DocumentImpl(
			"Brian Banner is a fictional villain from the Marvel Comics Universe created by Bill Mantlo and Mike Mignola and first appearing in print in late 1985.",
			Arrays.asList((Marking) new NamedEntity(0, 12,
				"http://dbpedia.org/resource/Brian_Banner"))));
	System.out.println(document);
    }
}
