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
        ANTLRInputStream is = new ANTLRInputStream(sentence);
        CetusPatternsLexer lexer = new CetusPatternsLexer(is);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CetusPatternsParser parser = new CetusPatternsParser(tokenStream);
        parser.removeErrorListeners();
        // parser.addErrorListener(errorListener);
        SentenceContext context = parser.sentence();
        TypeStringCreatingVisitor visitor = new TypeStringCreatingVisitor();
        if (context != null) {
            return visitor.visit(context);
        } else {
            return new ArrayList<String>(0);
        }
    }
}
