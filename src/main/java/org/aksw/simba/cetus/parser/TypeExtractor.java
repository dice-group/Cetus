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
package org.aksw.simba.cetus.parser;

import java.util.ArrayList;
import java.util.List;

import org.aksw.simba.cetus.parser.antlr4.CetusPatternsLexer;
import org.aksw.simba.cetus.parser.antlr4.CetusPatternsParser;
import org.aksw.simba.cetus.parser.antlr4.CetusPatternsParser.SentenceContext;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class TypeExtractor {

    public static final String ENTITY_MARKING = "$ENTITY$";

    public List<String> extractTypeStrings(String sentence) {
        int pos = sentence.indexOf(ENTITY_MARKING);
        if (pos < 0) {
            return new ArrayList<String>(0);
        }
        String subSentence = sentence.substring(pos);
        List<String> types = extractStrings(subSentence);
        if (pos > 0) {
            subSentence = sentence.substring(0, pos + ENTITY_MARKING.length());
            List<String> types2 = extractStrings(subSentence);
            if (types == null) {
                if (types2 == null) {
                    return new ArrayList<String>(0);
                } else {
                    return types2;
                }
            } else {
                if (types2 != null) {
                    types.addAll(types2);
                }
                return types;
            }
        }
        if (types == null) {
            return new ArrayList<String>(0);
        } else {
            return types;
        }
    }

    protected List<String> extractStrings(String sentence) {
        ANTLRInputStream is = new ANTLRInputStream(sentence);
        CetusPatternsLexer lexer = new CetusPatternsLexer(is);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CetusPatternsParser parser = new CetusPatternsParser(tokenStream);
        parser.removeErrorListeners();
        // parser.addErrorListener(errorListener);
        SentenceContext context = parser.sentence();
        TypeStringCreatingVisitor visitor = new TypeStringCreatingVisitor();
        if (context != null) {
            List<String> result = visitor.visit(context);
            if (result != null) {
                // sometimes an empty string is added. We don't want to have it
                result.remove("");
                return result;
            }
        }
        return new ArrayList<String>(0);
    }
}
