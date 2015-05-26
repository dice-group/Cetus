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
			"Avex Group Holdings Inc., listed in the Tokyo Stock Exchange as 7860 and abbreviated as AGHD, is the holding company for a group of entertainment-related subsidiaries based in Japan.",
			Arrays.asList((Marking) new NamedEntity(0, 24,
				"http://dbpedia.org/resource/AVEX"))));
	System.out.println(document);
    }
}
