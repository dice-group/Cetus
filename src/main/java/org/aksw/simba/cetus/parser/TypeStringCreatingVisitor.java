package org.aksw.simba.cetus.parser;

import java.util.ArrayList;
import java.util.List;

import org.aksw.simba.cetus.parser.antlr4.CetusPatternsBaseVisitor;
import org.aksw.simba.cetus.parser.antlr4.CetusPatternsParser.TypeContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

public class TypeStringCreatingVisitor extends
	CetusPatternsBaseVisitor<List<String>> {

    private StringCreatingVisitor stringVisitor = new StringCreatingVisitor();

    public List<String> visitChildren(RuleNode node) {
	List<String> result = defaultResult();
	List<String> childResult;
	ParseTree child;
	int n = node.getChildCount();
	for (int i = 0; i < n; i++) {
	    if (!shouldVisitNextChild(node, result)) {
		break;
	    }

	    child = node.getChild(i);
	    childResult = child.accept(this);
	    if (childResult != null) {
		if (result != null) {
		    result.addAll(childResult);
		} else {
		    result = childResult;
		}
	    }
	}
	return result;
    }

    @Override
    public List<String> visitType(TypeContext ctx) {
	List<String> result = new ArrayList<String>(1);
	String ctxResult = stringVisitor.visit(ctx);
	if (ctxResult != null) {
	    result.add(ctxResult);
	}
	return result;
    }
}
