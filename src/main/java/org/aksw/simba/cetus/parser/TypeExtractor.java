package org.aksw.simba.cetus.parser;

import java.util.ArrayList;
import java.util.List;

import org.aksw.simba.cetus.parser.antlr4.CetusPatternsLexer;
import org.aksw.simba.cetus.parser.antlr4.CetusPatternsParser;
import org.aksw.simba.cetus.parser.antlr4.CetusPatternsParser.SentenceContext;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class TypeExtractor {

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
