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
package org.aksw.simba.topicmodeling.lang.postagging;

import java.util.List;
import java.util.Properties;

import org.aksw.simba.topicmodeling.lang.Term;
import org.aksw.simba.topicmodeling.utils.doc.TermTokenizedText;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class StanfordTaggerWrapper extends AbstractPosTagger {

    public static StanfordTaggerWrapper create() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        return new StanfordTaggerWrapper(pipeline);
    }

    protected StanfordCoreNLP pipeline;

    public StanfordTaggerWrapper(StanfordCoreNLP pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    protected TermTokenizedText tokenizeText(String text) {
        return tokenizeText(text, null);
    }

    @Override
    protected TermTokenizedText tokenizeText(String text, PosTaggingTermFilter filter) {
        Annotation document = new Annotation(text);
        pipeline.annotate(document);

        List<CoreLabel> tokens = document.get(TokensAnnotation.class);
        TermTokenizedText ttText = new TermTokenizedText();
        List<Term> terms = ttText.getTermTokenizedText();
        Term term;
        int lastEnd = -1;
        for (CoreLabel token : tokens) {
            // We have to make sure that points are not added twice (which can
            // happen if they are interpreted as both - end of a sentence and
            // punctuation of an abbreviation).
            if (!((token.beginPosition() <= lastEnd) && ".".equals(token.get(PartOfSpeechAnnotation.class)))) {
                term = transformToTerm(token);
                if ((filter == null) || (filter.isTermGood(term))) {
                    terms.add(term);
                }
                lastEnd = token.endPosition();
            }
        }
        return ttText;
    }

    private Term transformToTerm(CoreLabel token) {
        String word = token.get(TextAnnotation.class);
        // this is the POS tag of the token
        String pos = token.get(PartOfSpeechAnnotation.class);
        // this is the NER label of the token
        String lemma = token.get(LemmaAnnotation.class);
        return new Term(word, lemma, pos);
    }

}
