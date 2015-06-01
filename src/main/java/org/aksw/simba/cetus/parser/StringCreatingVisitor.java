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
