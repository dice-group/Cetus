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
