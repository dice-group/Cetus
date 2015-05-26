package org.aksw.simba.cetus.parser;

import org.aksw.simba.cetus.parser.antlr4.CetusPatternsBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class StringCreatingVisitor extends CetusPatternsBaseVisitor<String> {

    public String visitChildren(RuleNode node) {
	int n = node.getChildCount();
	if (n > 1) {
	    StringBuilder result = new StringBuilder();
	    ParseTree child;
	    String childResult;
	    for (int i = 0; i < n; i++) {
		child = node.getChild(i);
		childResult = child.accept(this);
		if (childResult != null) {
		    if (i > 0) {
			result.append(' ');
		    }
		    result.append(childResult);
		}
	    }
	    return result.toString();
	} else {
	    if (n == 1) {
		return node.getChild(0).accept(this);
	    } else {
		return node.getText();
	    }
	}
    }

    public String visitTerminal(TerminalNode node) {
	return node.getText();
    }
}
