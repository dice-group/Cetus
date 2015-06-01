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
