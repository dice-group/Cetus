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
// Generated from CetusPatterns.g4 by ANTLR 4.5
package org.aksw.simba.cetus.parser.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CetusPatternsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CetusPatternsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CetusPatternsParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(CetusPatternsParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CetusPatternsParser#entity_type_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity_type_part(CetusPatternsParser.Entity_type_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link CetusPatternsParser#type_after_entity_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_after_entity_pattern(CetusPatternsParser.Type_after_entity_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link CetusPatternsParser#is_a_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_a_pattern(CetusPatternsParser.Is_a_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link CetusPatternsParser#is_a_type_of_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_a_type_of_pattern(CetusPatternsParser.Is_a_type_of_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link CetusPatternsParser#is_a_type_of_type_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_a_type_of_type_pattern(CetusPatternsParser.Is_a_type_of_type_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link CetusPatternsParser#is_a_type_of_both_types_pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIs_a_type_of_both_types_pattern(CetusPatternsParser.Is_a_type_of_both_types_patternContext ctx);
	/**
	 * Visit a parse tree produced by {@link CetusPatternsParser#type_in_front_of_entity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_in_front_of_entity(CetusPatternsParser.Type_in_front_of_entityContext ctx);
	/**
	 * Visit a parse tree produced by {@link CetusPatternsParser#type_with_dt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_with_dt(CetusPatternsParser.Type_with_dtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CetusPatternsParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CetusPatternsParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CetusPatternsParser#nr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNr(CetusPatternsParser.NrContext ctx);
	/**
	 * Visit a parse tree produced by {@link CetusPatternsParser#cc_word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCc_word(CetusPatternsParser.Cc_wordContext ctx);
}