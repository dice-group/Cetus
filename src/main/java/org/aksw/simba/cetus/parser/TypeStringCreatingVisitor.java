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
