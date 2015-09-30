/**
 * This file is part of Cetus.
 *
 * Cetus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cetus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Cetus.  If not, see <http://www.gnu.org/licenses/>.
 */
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
