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
// Generated from CetusPatterns.g4 by ANTLR 4.5
package org.aksw.simba.cetus.parser.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CetusPatternsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ENTITY=1, AND=2, OR=3, BOTH=4, CC=5, OF=6, FORM_OF_BE=7, ADJECTIVE=8, 
		DETERMINER=9, NUMBER=10, NOUN=11, VERB=12, ADVERB=13, FOREIGN=14, POINT=15, 
		COMMA=16, COLON=17, WORD=18, WHITESPACE=19, CD=20;
	public static final int
		RULE_sentence = 0, RULE_entity_type_part = 1, RULE_type_after_entity_pattern = 2, 
		RULE_is_a_pattern = 3, RULE_is_a_type_of_pattern = 4, RULE_is_a_type_of_type_pattern = 5, 
		RULE_is_a_type_of_both_types_pattern = 6, RULE_type_in_front_of_entity = 7, 
		RULE_type_with_dt = 8, RULE_type = 9, RULE_nr = 10, RULE_cc_word = 11;
	public static final String[] ruleNames = {
		"sentence", "entity_type_part", "type_after_entity_pattern", "is_a_pattern", 
		"is_a_type_of_pattern", "is_a_type_of_type_pattern", "is_a_type_of_both_types_pattern", 
		"type_in_front_of_entity", "type_with_dt", "type", "nr", "cc_word"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'$ENTITY$'", "'and_and_CC'", "'or_or_CC'", "'both_both_CC'", null, 
		"'of_of_IN'", null, null, null, null, null, null, null, null, "'._._.'", 
		"',_,_,'", "':_:_:'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ENTITY", "AND", "OR", "BOTH", "CC", "OF", "FORM_OF_BE", "ADJECTIVE", 
		"DETERMINER", "NUMBER", "NOUN", "VERB", "ADVERB", "FOREIGN", "POINT", 
		"COMMA", "COLON", "WORD", "WHITESPACE", "CD"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CetusPatterns.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CetusPatternsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SentenceContext extends ParserRuleContext {
		public Entity_type_partContext entity_type_part() {
			return getRuleContext(Entity_type_partContext.class,0);
		}
		public TerminalNode POINT() { return getToken(CetusPatternsParser.POINT, 0); }
		public List<TerminalNode> WORD() { return getTokens(CetusPatternsParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(CetusPatternsParser.WORD, i);
		}
		public List<Cc_wordContext> cc_word() {
			return getRuleContexts(Cc_wordContext.class);
		}
		public Cc_wordContext cc_word(int i) {
			return getRuleContext(Cc_wordContext.class,i);
		}
		public List<TerminalNode> OF() { return getTokens(CetusPatternsParser.OF); }
		public TerminalNode OF(int i) {
			return getToken(CetusPatternsParser.OF, i);
		}
		public List<TerminalNode> ADJECTIVE() { return getTokens(CetusPatternsParser.ADJECTIVE); }
		public TerminalNode ADJECTIVE(int i) {
			return getToken(CetusPatternsParser.ADJECTIVE, i);
		}
		public List<TerminalNode> DETERMINER() { return getTokens(CetusPatternsParser.DETERMINER); }
		public TerminalNode DETERMINER(int i) {
			return getToken(CetusPatternsParser.DETERMINER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(CetusPatternsParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(CetusPatternsParser.NUMBER, i);
		}
		public List<TerminalNode> NOUN() { return getTokens(CetusPatternsParser.NOUN); }
		public TerminalNode NOUN(int i) {
			return getToken(CetusPatternsParser.NOUN, i);
		}
		public List<TerminalNode> FOREIGN() { return getTokens(CetusPatternsParser.FOREIGN); }
		public TerminalNode FOREIGN(int i) {
			return getToken(CetusPatternsParser.FOREIGN, i);
		}
		public List<TerminalNode> ADVERB() { return getTokens(CetusPatternsParser.ADVERB); }
		public TerminalNode ADVERB(int i) {
			return getToken(CetusPatternsParser.ADVERB, i);
		}
		public List<TerminalNode> VERB() { return getTokens(CetusPatternsParser.VERB); }
		public TerminalNode VERB(int i) {
			return getToken(CetusPatternsParser.VERB, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CetusPatternsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CetusPatternsParser.COMMA, i);
		}
		public List<TerminalNode> COLON() { return getTokens(CetusPatternsParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(CetusPatternsParser.COLON, i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sentence);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(33);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(24);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case BOTH:
					case CC:
						{
						setState(25);
						cc_word();
						}
						break;
					case OF:
						{
						setState(26);
						match(OF);
						}
						break;
					case ADJECTIVE:
						{
						setState(27);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(28);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(29);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(30);
						match(NOUN);
						}
						break;
					case FOREIGN:
						{
						setState(31);
						match(FOREIGN);
						}
						break;
					case ADVERB:
						{
						setState(32);
						match(ADVERB);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(38);
			entity_type_part();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << COMMA) | (1L << COLON) | (1L << WORD))) != 0)) {
				{
				setState(51);
				switch (_input.LA(1)) {
				case WORD:
					{
					setState(39);
					match(WORD);
					}
					break;
				case AND:
				case OR:
				case BOTH:
				case CC:
					{
					setState(40);
					cc_word();
					}
					break;
				case OF:
					{
					setState(41);
					match(OF);
					}
					break;
				case ADJECTIVE:
					{
					setState(42);
					match(ADJECTIVE);
					}
					break;
				case DETERMINER:
					{
					setState(43);
					match(DETERMINER);
					}
					break;
				case NUMBER:
					{
					setState(44);
					match(NUMBER);
					}
					break;
				case NOUN:
					{
					setState(45);
					match(NOUN);
					}
					break;
				case VERB:
					{
					setState(46);
					match(VERB);
					}
					break;
				case FOREIGN:
					{
					setState(47);
					match(FOREIGN);
					}
					break;
				case ADVERB:
					{
					setState(48);
					match(ADVERB);
					}
					break;
				case COMMA:
					{
					setState(49);
					match(COMMA);
					}
					break;
				case COLON:
					{
					setState(50);
					match(COLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
			match(POINT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Entity_type_partContext extends ParserRuleContext {
		public TerminalNode ENTITY() { return getToken(CetusPatternsParser.ENTITY, 0); }
		public Type_after_entity_patternContext type_after_entity_pattern() {
			return getRuleContext(Type_after_entity_patternContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(CetusPatternsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CetusPatternsParser.COMMA, i);
		}
		public List<TerminalNode> WORD() { return getTokens(CetusPatternsParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(CetusPatternsParser.WORD, i);
		}
		public List<Cc_wordContext> cc_word() {
			return getRuleContexts(Cc_wordContext.class);
		}
		public Cc_wordContext cc_word(int i) {
			return getRuleContext(Cc_wordContext.class,i);
		}
		public List<TerminalNode> OF() { return getTokens(CetusPatternsParser.OF); }
		public TerminalNode OF(int i) {
			return getToken(CetusPatternsParser.OF, i);
		}
		public List<TerminalNode> ADJECTIVE() { return getTokens(CetusPatternsParser.ADJECTIVE); }
		public TerminalNode ADJECTIVE(int i) {
			return getToken(CetusPatternsParser.ADJECTIVE, i);
		}
		public List<TerminalNode> DETERMINER() { return getTokens(CetusPatternsParser.DETERMINER); }
		public TerminalNode DETERMINER(int i) {
			return getToken(CetusPatternsParser.DETERMINER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(CetusPatternsParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(CetusPatternsParser.NUMBER, i);
		}
		public List<TerminalNode> NOUN() { return getTokens(CetusPatternsParser.NOUN); }
		public TerminalNode NOUN(int i) {
			return getToken(CetusPatternsParser.NOUN, i);
		}
		public List<TerminalNode> FOREIGN() { return getTokens(CetusPatternsParser.FOREIGN); }
		public TerminalNode FOREIGN(int i) {
			return getToken(CetusPatternsParser.FOREIGN, i);
		}
		public List<TerminalNode> ADVERB() { return getTokens(CetusPatternsParser.ADVERB); }
		public TerminalNode ADVERB(int i) {
			return getToken(CetusPatternsParser.ADVERB, i);
		}
		public List<TerminalNode> VERB() { return getTokens(CetusPatternsParser.VERB); }
		public TerminalNode VERB(int i) {
			return getToken(CetusPatternsParser.VERB, i);
		}
		public List<TerminalNode> FORM_OF_BE() { return getTokens(CetusPatternsParser.FORM_OF_BE); }
		public TerminalNode FORM_OF_BE(int i) {
			return getToken(CetusPatternsParser.FORM_OF_BE, i);
		}
		public Type_in_front_of_entityContext type_in_front_of_entity() {
			return getRuleContext(Type_in_front_of_entityContext.class,0);
		}
		public Entity_type_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity_type_part; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitEntity_type_part(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Entity_type_partContext entity_type_part() throws RecognitionException {
		Entity_type_partContext _localctx = new Entity_type_partContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_entity_type_part);
		int _la;
		try {
			int _alt;
			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(ENTITY);
				setState(59);
				type_after_entity_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(ENTITY);
				setState(62);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(61);
					match(COMMA);
					}
				}

				setState(64);
				type_after_entity_pattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				match(ENTITY);
				setState(66);
				match(COMMA);
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(77);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(67);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case BOTH:
					case CC:
						{
						setState(68);
						cc_word();
						}
						break;
					case OF:
						{
						setState(69);
						match(OF);
						}
						break;
					case ADJECTIVE:
						{
						setState(70);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(71);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(72);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(73);
						match(NOUN);
						}
						break;
					case FOREIGN:
						{
						setState(74);
						match(FOREIGN);
						}
						break;
					case ADVERB:
						{
						setState(75);
						match(ADVERB);
						}
						break;
					case VERB:
						{
						setState(76);
						match(VERB);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(79); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0) );
				setState(81);
				match(COMMA);
				setState(82);
				type_after_entity_pattern();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				match(ENTITY);
				setState(84);
				cc_word();
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(94);
						switch (_input.LA(1)) {
						case WORD:
							{
							setState(85);
							match(WORD);
							}
							break;
						case AND:
						case OR:
						case BOTH:
						case CC:
							{
							setState(86);
							cc_word();
							}
							break;
						case OF:
							{
							setState(87);
							match(OF);
							}
							break;
						case ADJECTIVE:
							{
							setState(88);
							match(ADJECTIVE);
							}
							break;
						case DETERMINER:
							{
							setState(89);
							match(DETERMINER);
							}
							break;
						case NUMBER:
							{
							setState(90);
							match(NUMBER);
							}
							break;
						case NOUN:
							{
							setState(91);
							match(NOUN);
							}
							break;
						case FOREIGN:
							{
							setState(92);
							match(FOREIGN);
							}
							break;
						case ADVERB:
							{
							setState(93);
							match(ADVERB);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(98);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				setState(99);
				type_after_entity_pattern();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(101);
				match(ENTITY);
				setState(102);
				cc_word();
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
					{
					setState(112);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(103);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case BOTH:
					case CC:
						{
						setState(104);
						cc_word();
						}
						break;
					case OF:
						{
						setState(105);
						match(OF);
						}
						break;
					case ADJECTIVE:
						{
						setState(106);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(107);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(108);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(109);
						match(NOUN);
						}
						break;
					case FOREIGN:
						{
						setState(110);
						match(FOREIGN);
						}
						break;
					case ADVERB:
						{
						setState(111);
						match(ADVERB);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(117);
				match(COMMA);
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(129);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(118);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case BOTH:
					case CC:
						{
						setState(119);
						cc_word();
						}
						break;
					case OF:
						{
						setState(120);
						match(OF);
						}
						break;
					case FORM_OF_BE:
						{
						setState(121);
						match(FORM_OF_BE);
						}
						break;
					case ADJECTIVE:
						{
						setState(122);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(123);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(124);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(125);
						match(NOUN);
						}
						break;
					case VERB:
						{
						setState(126);
						match(VERB);
						}
						break;
					case FOREIGN:
						{
						setState(127);
						match(FOREIGN);
						}
						break;
					case ADVERB:
						{
						setState(128);
						match(ADVERB);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(131); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0) );
				setState(133);
				match(COMMA);
				setState(134);
				type_after_entity_pattern();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(136);
				type_in_front_of_entity();
				setState(137);
				match(ENTITY);
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(149);
						switch (_input.LA(1)) {
						case WORD:
							{
							setState(138);
							match(WORD);
							}
							break;
						case AND:
						case OR:
						case BOTH:
						case CC:
							{
							setState(139);
							cc_word();
							}
							break;
						case OF:
							{
							setState(140);
							match(OF);
							}
							break;
						case ADJECTIVE:
							{
							setState(141);
							match(ADJECTIVE);
							}
							break;
						case DETERMINER:
							{
							setState(142);
							match(DETERMINER);
							}
							break;
						case NUMBER:
							{
							setState(143);
							match(NUMBER);
							}
							break;
						case NOUN:
							{
							setState(144);
							match(NOUN);
							}
							break;
						case FOREIGN:
							{
							setState(145);
							match(FOREIGN);
							}
							break;
						case ADVERB:
							{
							setState(146);
							match(ADVERB);
							}
							break;
						case FORM_OF_BE:
							{
							setState(147);
							match(FORM_OF_BE);
							}
							break;
						case VERB:
							{
							setState(148);
							match(VERB);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(153);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_after_entity_patternContext extends ParserRuleContext {
		public Is_a_type_of_type_patternContext is_a_type_of_type_pattern() {
			return getRuleContext(Is_a_type_of_type_patternContext.class,0);
		}
		public Is_a_type_of_both_types_patternContext is_a_type_of_both_types_pattern() {
			return getRuleContext(Is_a_type_of_both_types_patternContext.class,0);
		}
		public Is_a_type_of_patternContext is_a_type_of_pattern() {
			return getRuleContext(Is_a_type_of_patternContext.class,0);
		}
		public List<Is_a_patternContext> is_a_pattern() {
			return getRuleContexts(Is_a_patternContext.class);
		}
		public Is_a_patternContext is_a_pattern(int i) {
			return getRuleContext(Is_a_patternContext.class,i);
		}
		public List<Cc_wordContext> cc_word() {
			return getRuleContexts(Cc_wordContext.class);
		}
		public Cc_wordContext cc_word(int i) {
			return getRuleContext(Cc_wordContext.class,i);
		}
		public Type_with_dtContext type_with_dt() {
			return getRuleContext(Type_with_dtContext.class,0);
		}
		public List<TerminalNode> WORD() { return getTokens(CetusPatternsParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(CetusPatternsParser.WORD, i);
		}
		public List<TerminalNode> OF() { return getTokens(CetusPatternsParser.OF); }
		public TerminalNode OF(int i) {
			return getToken(CetusPatternsParser.OF, i);
		}
		public List<TerminalNode> ADJECTIVE() { return getTokens(CetusPatternsParser.ADJECTIVE); }
		public TerminalNode ADJECTIVE(int i) {
			return getToken(CetusPatternsParser.ADJECTIVE, i);
		}
		public List<TerminalNode> DETERMINER() { return getTokens(CetusPatternsParser.DETERMINER); }
		public TerminalNode DETERMINER(int i) {
			return getToken(CetusPatternsParser.DETERMINER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(CetusPatternsParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(CetusPatternsParser.NUMBER, i);
		}
		public List<TerminalNode> NOUN() { return getTokens(CetusPatternsParser.NOUN); }
		public TerminalNode NOUN(int i) {
			return getToken(CetusPatternsParser.NOUN, i);
		}
		public List<TerminalNode> FOREIGN() { return getTokens(CetusPatternsParser.FOREIGN); }
		public TerminalNode FOREIGN(int i) {
			return getToken(CetusPatternsParser.FOREIGN, i);
		}
		public List<TerminalNode> ADVERB() { return getTokens(CetusPatternsParser.ADVERB); }
		public TerminalNode ADVERB(int i) {
			return getToken(CetusPatternsParser.ADVERB, i);
		}
		public List<TerminalNode> FORM_OF_BE() { return getTokens(CetusPatternsParser.FORM_OF_BE); }
		public TerminalNode FORM_OF_BE(int i) {
			return getToken(CetusPatternsParser.FORM_OF_BE, i);
		}
		public List<TerminalNode> VERB() { return getTokens(CetusPatternsParser.VERB); }
		public TerminalNode VERB(int i) {
			return getToken(CetusPatternsParser.VERB, i);
		}
		public Type_after_entity_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_after_entity_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitType_after_entity_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_after_entity_patternContext type_after_entity_pattern() throws RecognitionException {
		Type_after_entity_patternContext _localctx = new Type_after_entity_patternContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type_after_entity_pattern);
		try {
			int _alt;
			setState(181);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				is_a_type_of_type_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				is_a_type_of_both_types_pattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				is_a_type_of_pattern();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(159);
				is_a_pattern();
				setState(160);
				cc_word();
				setState(161);
				is_a_pattern();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(163);
				is_a_pattern();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(164);
				type_with_dt();
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(176);
						switch (_input.LA(1)) {
						case WORD:
							{
							setState(165);
							match(WORD);
							}
							break;
						case AND:
						case OR:
						case BOTH:
						case CC:
							{
							setState(166);
							cc_word();
							}
							break;
						case OF:
							{
							setState(167);
							match(OF);
							}
							break;
						case ADJECTIVE:
							{
							setState(168);
							match(ADJECTIVE);
							}
							break;
						case DETERMINER:
							{
							setState(169);
							match(DETERMINER);
							}
							break;
						case NUMBER:
							{
							setState(170);
							match(NUMBER);
							}
							break;
						case NOUN:
							{
							setState(171);
							match(NOUN);
							}
							break;
						case FOREIGN:
							{
							setState(172);
							match(FOREIGN);
							}
							break;
						case ADVERB:
							{
							setState(173);
							match(ADVERB);
							}
							break;
						case FORM_OF_BE:
							{
							setState(174);
							match(FORM_OF_BE);
							}
							break;
						case VERB:
							{
							setState(175);
							match(VERB);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(180);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Is_a_patternContext extends ParserRuleContext {
		public TerminalNode FORM_OF_BE() { return getToken(CetusPatternsParser.FORM_OF_BE, 0); }
		public List<Type_with_dtContext> type_with_dt() {
			return getRuleContexts(Type_with_dtContext.class);
		}
		public Type_with_dtContext type_with_dt(int i) {
			return getRuleContext(Type_with_dtContext.class,i);
		}
		public List<TerminalNode> ADVERB() { return getTokens(CetusPatternsParser.ADVERB); }
		public TerminalNode ADVERB(int i) {
			return getToken(CetusPatternsParser.ADVERB, i);
		}
		public List<TerminalNode> AND() { return getTokens(CetusPatternsParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CetusPatternsParser.AND, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CetusPatternsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CetusPatternsParser.COMMA, i);
		}
		public Is_a_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_a_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitIs_a_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Is_a_patternContext is_a_pattern() throws RecognitionException {
		Is_a_patternContext _localctx = new Is_a_patternContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_is_a_pattern);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(FORM_OF_BE);
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(184);
					match(ADVERB);
					}
					} 
				}
				setState(189);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(190);
			type_with_dt();
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(191);
					_la = _input.LA(1);
					if ( !(_la==AND || _la==COMMA) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(192);
					type_with_dt();
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Is_a_type_of_patternContext extends ParserRuleContext {
		public TerminalNode FORM_OF_BE() { return getToken(CetusPatternsParser.FORM_OF_BE, 0); }
		public TerminalNode OF() { return getToken(CetusPatternsParser.OF, 0); }
		public Type_with_dtContext type_with_dt() {
			return getRuleContext(Type_with_dtContext.class,0);
		}
		public List<TerminalNode> ADVERB() { return getTokens(CetusPatternsParser.ADVERB); }
		public TerminalNode ADVERB(int i) {
			return getToken(CetusPatternsParser.ADVERB, i);
		}
		public NrContext nr() {
			return getRuleContext(NrContext.class,0);
		}
		public Is_a_type_of_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_a_type_of_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitIs_a_type_of_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Is_a_type_of_patternContext is_a_type_of_pattern() throws RecognitionException {
		Is_a_type_of_patternContext _localctx = new Is_a_type_of_patternContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_is_a_type_of_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(FORM_OF_BE);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADVERB) {
				{
				{
				setState(199);
				match(ADVERB);
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(205);
				nr();
				}
			}

			setState(208);
			match(OF);
			setState(209);
			type_with_dt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Is_a_type_of_type_patternContext extends ParserRuleContext {
		public TerminalNode FORM_OF_BE() { return getToken(CetusPatternsParser.FORM_OF_BE, 0); }
		public List<Type_with_dtContext> type_with_dt() {
			return getRuleContexts(Type_with_dtContext.class);
		}
		public Type_with_dtContext type_with_dt(int i) {
			return getRuleContext(Type_with_dtContext.class,i);
		}
		public TerminalNode OF() { return getToken(CetusPatternsParser.OF, 0); }
		public List<TerminalNode> ADVERB() { return getTokens(CetusPatternsParser.ADVERB); }
		public TerminalNode ADVERB(int i) {
			return getToken(CetusPatternsParser.ADVERB, i);
		}
		public Is_a_type_of_type_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_a_type_of_type_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitIs_a_type_of_type_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Is_a_type_of_type_patternContext is_a_type_of_type_pattern() throws RecognitionException {
		Is_a_type_of_type_patternContext _localctx = new Is_a_type_of_type_patternContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_is_a_type_of_type_pattern);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(FORM_OF_BE);
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(212);
					match(ADVERB);
					}
					} 
				}
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(218);
			type_with_dt();
			setState(219);
			match(OF);
			setState(220);
			type_with_dt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Is_a_type_of_both_types_patternContext extends ParserRuleContext {
		public TerminalNode FORM_OF_BE() { return getToken(CetusPatternsParser.FORM_OF_BE, 0); }
		public List<Type_with_dtContext> type_with_dt() {
			return getRuleContexts(Type_with_dtContext.class);
		}
		public Type_with_dtContext type_with_dt(int i) {
			return getRuleContext(Type_with_dtContext.class,i);
		}
		public TerminalNode OF() { return getToken(CetusPatternsParser.OF, 0); }
		public TerminalNode BOTH() { return getToken(CetusPatternsParser.BOTH, 0); }
		public TerminalNode AND() { return getToken(CetusPatternsParser.AND, 0); }
		public List<TerminalNode> ADVERB() { return getTokens(CetusPatternsParser.ADVERB); }
		public TerminalNode ADVERB(int i) {
			return getToken(CetusPatternsParser.ADVERB, i);
		}
		public Is_a_type_of_both_types_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_a_type_of_both_types_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitIs_a_type_of_both_types_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Is_a_type_of_both_types_patternContext is_a_type_of_both_types_pattern() throws RecognitionException {
		Is_a_type_of_both_types_patternContext _localctx = new Is_a_type_of_both_types_patternContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_is_a_type_of_both_types_pattern);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(FORM_OF_BE);
			setState(226);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(223);
					match(ADVERB);
					}
					} 
				}
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(229);
			type_with_dt();
			setState(230);
			match(OF);
			setState(231);
			match(BOTH);
			setState(232);
			type_with_dt();
			setState(233);
			match(AND);
			setState(234);
			type_with_dt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_in_front_of_entityContext extends ParserRuleContext {
		public Type_with_dtContext type_with_dt() {
			return getRuleContext(Type_with_dtContext.class,0);
		}
		public TerminalNode OF() { return getToken(CetusPatternsParser.OF, 0); }
		public TerminalNode COMMA() { return getToken(CetusPatternsParser.COMMA, 0); }
		public TerminalNode COLON() { return getToken(CetusPatternsParser.COLON, 0); }
		public Type_in_front_of_entityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_in_front_of_entity; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitType_in_front_of_entity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_in_front_of_entityContext type_in_front_of_entity() throws RecognitionException {
		Type_in_front_of_entityContext _localctx = new Type_in_front_of_entityContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type_in_front_of_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			type_with_dt();
			setState(238);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OF) | (1L << COMMA) | (1L << COLON))) != 0)) {
				{
				setState(237);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OF) | (1L << COMMA) | (1L << COLON))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_with_dtContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode DETERMINER() { return getToken(CetusPatternsParser.DETERMINER, 0); }
		public NrContext nr() {
			return getRuleContext(NrContext.class,0);
		}
		public Type_with_dtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_with_dt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitType_with_dt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_with_dtContext type_with_dt() throws RecognitionException {
		Type_with_dtContext _localctx = new Type_with_dtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type_with_dt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if (_la==DETERMINER) {
				{
				setState(240);
				match(DETERMINER);
				}
			}

			setState(244);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(243);
				nr();
				}
			}

			setState(246);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode FOREIGN() { return getToken(CetusPatternsParser.FOREIGN, 0); }
		public List<TerminalNode> NOUN() { return getTokens(CetusPatternsParser.NOUN); }
		public TerminalNode NOUN(int i) {
			return getToken(CetusPatternsParser.NOUN, i);
		}
		public List<TerminalNode> ADJECTIVE() { return getTokens(CetusPatternsParser.ADJECTIVE); }
		public TerminalNode ADJECTIVE(int i) {
			return getToken(CetusPatternsParser.ADJECTIVE, i);
		}
		public List<TerminalNode> VERB() { return getTokens(CetusPatternsParser.VERB); }
		public TerminalNode VERB(int i) {
			return getToken(CetusPatternsParser.VERB, i);
		}
		public List<TerminalNode> ADVERB() { return getTokens(CetusPatternsParser.ADVERB); }
		public TerminalNode ADVERB(int i) {
			return getToken(CetusPatternsParser.ADVERB, i);
		}
		public List<TerminalNode> CD() { return getTokens(CetusPatternsParser.CD); }
		public TerminalNode CD(int i) {
			return getToken(CetusPatternsParser.CD, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			int _alt;
			setState(283);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB) | (1L << CD))) != 0)) {
					{
					{
					setState(248);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB) | (1L << CD))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(255);
				_la = _input.LA(1);
				if (_la==FOREIGN) {
					{
					setState(254);
					match(FOREIGN);
					}
				}

				setState(258); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(257);
					match(NOUN);
					}
					}
					setState(260); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NOUN );
				setState(264); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(262);
						match(ADJECTIVE);
						setState(263);
						match(NOUN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(266); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB) | (1L << CD))) != 0)) {
					{
					{
					setState(268);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB) | (1L << CD))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(273);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(275);
				_la = _input.LA(1);
				if (_la==FOREIGN) {
					{
					setState(274);
					match(FOREIGN);
					}
				}

				setState(278); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(277);
						match(NOUN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(280); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(282);
				match(ADJECTIVE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NrContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(CetusPatternsParser.NUMBER, 0); }
		public NrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitNr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NrContext nr() throws RecognitionException {
		NrContext _localctx = new NrContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_nr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cc_wordContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(CetusPatternsParser.AND, 0); }
		public TerminalNode OR() { return getToken(CetusPatternsParser.OR, 0); }
		public TerminalNode BOTH() { return getToken(CetusPatternsParser.BOTH, 0); }
		public TerminalNode CC() { return getToken(CetusPatternsParser.CC, 0); }
		public Cc_wordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cc_word; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitCc_word(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cc_wordContext cc_word() throws RecognitionException {
		Cc_wordContext _localctx = new Cc_wordContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cc_word);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26\u0124\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2$\n\2\f\2"+
		"\16\2\'\13\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\66"+
		"\n\2\f\2\16\29\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3A\n\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3P\n\3\r\3\16\3Q\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3a\n\3\f\3\16\3d\13\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3s\n\3\f\3\16\3v\13\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3\u0084\n\3\r\3\16\3\u0085"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u0098"+
		"\n\3\f\3\16\3\u009b\13\3\5\3\u009d\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u00b3\n\4\f\4\16"+
		"\4\u00b6\13\4\5\4\u00b8\n\4\3\5\3\5\7\5\u00bc\n\5\f\5\16\5\u00bf\13\5"+
		"\3\5\3\5\3\5\7\5\u00c4\n\5\f\5\16\5\u00c7\13\5\3\6\3\6\7\6\u00cb\n\6\f"+
		"\6\16\6\u00ce\13\6\3\6\5\6\u00d1\n\6\3\6\3\6\3\6\3\7\3\7\7\7\u00d8\n\7"+
		"\f\7\16\7\u00db\13\7\3\7\3\7\3\7\3\7\3\b\3\b\7\b\u00e3\n\b\f\b\16\b\u00e6"+
		"\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\5\t\u00f1\n\t\3\n\5\n\u00f4"+
		"\n\n\3\n\5\n\u00f7\n\n\3\n\3\n\3\13\7\13\u00fc\n\13\f\13\16\13\u00ff\13"+
		"\13\3\13\5\13\u0102\n\13\3\13\6\13\u0105\n\13\r\13\16\13\u0106\3\13\3"+
		"\13\6\13\u010b\n\13\r\13\16\13\u010c\3\13\7\13\u0110\n\13\f\13\16\13\u0113"+
		"\13\13\3\13\5\13\u0116\n\13\3\13\6\13\u0119\n\13\r\13\16\13\u011a\3\13"+
		"\5\13\u011e\n\13\3\f\3\f\3\r\3\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\2\6\4\2\4\4\22\22\4\2\b\b\22\23\5\2\n\n\16\17\26\26\3\2\4\7\u0186"+
		"\2%\3\2\2\2\4\u009c\3\2\2\2\6\u00b7\3\2\2\2\b\u00b9\3\2\2\2\n\u00c8\3"+
		"\2\2\2\f\u00d5\3\2\2\2\16\u00e0\3\2\2\2\20\u00ee\3\2\2\2\22\u00f3\3\2"+
		"\2\2\24\u011d\3\2\2\2\26\u011f\3\2\2\2\30\u0121\3\2\2\2\32$\7\24\2\2\33"+
		"$\5\30\r\2\34$\7\b\2\2\35$\7\n\2\2\36$\7\13\2\2\37$\7\f\2\2 $\7\r\2\2"+
		"!$\7\20\2\2\"$\7\17\2\2#\32\3\2\2\2#\33\3\2\2\2#\34\3\2\2\2#\35\3\2\2"+
		"\2#\36\3\2\2\2#\37\3\2\2\2# \3\2\2\2#!\3\2\2\2#\"\3\2\2\2$\'\3\2\2\2%"+
		"#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2\2(\67\5\4\3\2)\66\7\24\2\2*\66"+
		"\5\30\r\2+\66\7\b\2\2,\66\7\n\2\2-\66\7\13\2\2.\66\7\f\2\2/\66\7\r\2\2"+
		"\60\66\7\16\2\2\61\66\7\20\2\2\62\66\7\17\2\2\63\66\7\22\2\2\64\66\7\23"+
		"\2\2\65)\3\2\2\2\65*\3\2\2\2\65+\3\2\2\2\65,\3\2\2\2\65-\3\2\2\2\65.\3"+
		"\2\2\2\65/\3\2\2\2\65\60\3\2\2\2\65\61\3\2\2\2\65\62\3\2\2\2\65\63\3\2"+
		"\2\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67"+
		"\3\2\2\2:;\7\21\2\2;\3\3\2\2\2<=\7\3\2\2=\u009d\5\6\4\2>@\7\3\2\2?A\7"+
		"\22\2\2@?\3\2\2\2@A\3\2\2\2AB\3\2\2\2B\u009d\5\6\4\2CD\7\3\2\2DO\7\22"+
		"\2\2EP\7\24\2\2FP\5\30\r\2GP\7\b\2\2HP\7\n\2\2IP\7\13\2\2JP\7\f\2\2KP"+
		"\7\r\2\2LP\7\20\2\2MP\7\17\2\2NP\7\16\2\2OE\3\2\2\2OF\3\2\2\2OG\3\2\2"+
		"\2OH\3\2\2\2OI\3\2\2\2OJ\3\2\2\2OK\3\2\2\2OL\3\2\2\2OM\3\2\2\2ON\3\2\2"+
		"\2PQ\3\2\2\2QO\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7\22\2\2T\u009d\5\6\4\2U"+
		"V\7\3\2\2Vb\5\30\r\2Wa\7\24\2\2Xa\5\30\r\2Ya\7\b\2\2Za\7\n\2\2[a\7\13"+
		"\2\2\\a\7\f\2\2]a\7\r\2\2^a\7\20\2\2_a\7\17\2\2`W\3\2\2\2`X\3\2\2\2`Y"+
		"\3\2\2\2`Z\3\2\2\2`[\3\2\2\2`\\\3\2\2\2`]\3\2\2\2`^\3\2\2\2`_\3\2\2\2"+
		"ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\5\6\4\2f\u009d\3"+
		"\2\2\2gh\7\3\2\2ht\5\30\r\2is\7\24\2\2js\5\30\r\2ks\7\b\2\2ls\7\n\2\2"+
		"ms\7\13\2\2ns\7\f\2\2os\7\r\2\2ps\7\20\2\2qs\7\17\2\2ri\3\2\2\2rj\3\2"+
		"\2\2rk\3\2\2\2rl\3\2\2\2rm\3\2\2\2rn\3\2\2\2ro\3\2\2\2rp\3\2\2\2rq\3\2"+
		"\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2w\u0083\7\22\2\2"+
		"x\u0084\7\24\2\2y\u0084\5\30\r\2z\u0084\7\b\2\2{\u0084\7\t\2\2|\u0084"+
		"\7\n\2\2}\u0084\7\13\2\2~\u0084\7\f\2\2\177\u0084\7\r\2\2\u0080\u0084"+
		"\7\16\2\2\u0081\u0084\7\20\2\2\u0082\u0084\7\17\2\2\u0083x\3\2\2\2\u0083"+
		"y\3\2\2\2\u0083z\3\2\2\2\u0083{\3\2\2\2\u0083|\3\2\2\2\u0083}\3\2\2\2"+
		"\u0083~\3\2\2\2\u0083\177\3\2\2\2\u0083\u0080\3\2\2\2\u0083\u0081\3\2"+
		"\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\22\2\2\u0088\u0089\5"+
		"\6\4\2\u0089\u009d\3\2\2\2\u008a\u008b\5\20\t\2\u008b\u0099\7\3\2\2\u008c"+
		"\u0098\7\24\2\2\u008d\u0098\5\30\r\2\u008e\u0098\7\b\2\2\u008f\u0098\7"+
		"\n\2\2\u0090\u0098\7\13\2\2\u0091\u0098\7\f\2\2\u0092\u0098\7\r\2\2\u0093"+
		"\u0098\7\20\2\2\u0094\u0098\7\17\2\2\u0095\u0098\7\t\2\2\u0096\u0098\7"+
		"\16\2\2\u0097\u008c\3\2\2\2\u0097\u008d\3\2\2\2\u0097\u008e\3\2\2\2\u0097"+
		"\u008f\3\2\2\2\u0097\u0090\3\2\2\2\u0097\u0091\3\2\2\2\u0097\u0092\3\2"+
		"\2\2\u0097\u0093\3\2\2\2\u0097\u0094\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009c<\3\2\2\2\u009c>\3\2"+
		"\2\2\u009cC\3\2\2\2\u009cU\3\2\2\2\u009cg\3\2\2\2\u009c\u008a\3\2\2\2"+
		"\u009d\5\3\2\2\2\u009e\u00b8\5\f\7\2\u009f\u00b8\5\16\b\2\u00a0\u00b8"+
		"\5\n\6\2\u00a1\u00a2\5\b\5\2\u00a2\u00a3\5\30\r\2\u00a3\u00a4\5\b\5\2"+
		"\u00a4\u00b8\3\2\2\2\u00a5\u00b8\5\b\5\2\u00a6\u00b4\5\22\n\2\u00a7\u00b3"+
		"\7\24\2\2\u00a8\u00b3\5\30\r\2\u00a9\u00b3\7\b\2\2\u00aa\u00b3\7\n\2\2"+
		"\u00ab\u00b3\7\13\2\2\u00ac\u00b3\7\f\2\2\u00ad\u00b3\7\r\2\2\u00ae\u00b3"+
		"\7\20\2\2\u00af\u00b3\7\17\2\2\u00b0\u00b3\7\t\2\2\u00b1\u00b3\7\16\2"+
		"\2\u00b2\u00a7\3\2\2\2\u00b2\u00a8\3\2\2\2\u00b2\u00a9\3\2\2\2\u00b2\u00aa"+
		"\3\2\2\2\u00b2\u00ab\3\2\2\2\u00b2\u00ac\3\2\2\2\u00b2\u00ad\3\2\2\2\u00b2"+
		"\u00ae\3\2\2\2\u00b2\u00af\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2"+
		"\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u009e\3\2\2\2\u00b7\u009f\3\2"+
		"\2\2\u00b7\u00a0\3\2\2\2\u00b7\u00a1\3\2\2\2\u00b7\u00a5\3\2\2\2\u00b7"+
		"\u00a6\3\2\2\2\u00b8\7\3\2\2\2\u00b9\u00bd\7\t\2\2\u00ba\u00bc\7\17\2"+
		"\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c5\5\22\n\2"+
		"\u00c1\u00c2\t\2\2\2\u00c2\u00c4\5\22\n\2\u00c3\u00c1\3\2\2\2\u00c4\u00c7"+
		"\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\t\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00cc\7\t\2\2\u00c9\u00cb\7\17\2\2\u00ca\u00c9\3"+
		"\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\5\26\f\2\u00d0\u00cf\3"+
		"\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\7\b\2\2\u00d3"+
		"\u00d4\5\22\n\2\u00d4\13\3\2\2\2\u00d5\u00d9\7\t\2\2\u00d6\u00d8\7\17"+
		"\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\5\22"+
		"\n\2\u00dd\u00de\7\b\2\2\u00de\u00df\5\22\n\2\u00df\r\3\2\2\2\u00e0\u00e4"+
		"\7\t\2\2\u00e1\u00e3\7\17\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2"+
		"\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4"+
		"\3\2\2\2\u00e7\u00e8\5\22\n\2\u00e8\u00e9\7\b\2\2\u00e9\u00ea\7\6\2\2"+
		"\u00ea\u00eb\5\22\n\2\u00eb\u00ec\7\4\2\2\u00ec\u00ed\5\22\n\2\u00ed\17"+
		"\3\2\2\2\u00ee\u00f0\5\22\n\2\u00ef\u00f1\t\3\2\2\u00f0\u00ef\3\2\2\2"+
		"\u00f0\u00f1\3\2\2\2\u00f1\21\3\2\2\2\u00f2\u00f4\7\13\2\2\u00f3\u00f2"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f7\5\26\f\2"+
		"\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9"+
		"\5\24\13\2\u00f9\23\3\2\2\2\u00fa\u00fc\t\4\2\2\u00fb\u00fa\3\2\2\2\u00fc"+
		"\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0101\3\2"+
		"\2\2\u00ff\u00fd\3\2\2\2\u0100\u0102\7\20\2\2\u0101\u0100\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0105\7\r\2\2\u0104\u0103\3\2"+
		"\2\2\u0105\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u010a\3\2\2\2\u0108\u0109\7\n\2\2\u0109\u010b\7\r\2\2\u010a\u0108\3\2"+
		"\2\2\u010b\u010c\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u011e\3\2\2\2\u010e\u0110\t\4\2\2\u010f\u010e\3\2\2\2\u0110\u0113\3\2"+
		"\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0115\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0114\u0116\7\20\2\2\u0115\u0114\3\2\2\2\u0115\u0116\3"+
		"\2\2\2\u0116\u0118\3\2\2\2\u0117\u0119\7\r\2\2\u0118\u0117\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011e\3\2"+
		"\2\2\u011c\u011e\7\n\2\2\u011d\u00fd\3\2\2\2\u011d\u0111\3\2\2\2\u011d"+
		"\u011c\3\2\2\2\u011e\25\3\2\2\2\u011f\u0120\7\f\2\2\u0120\27\3\2\2\2\u0121"+
		"\u0122\t\5\2\2\u0122\31\3\2\2\2&#%\65\67@OQ`brt\u0083\u0085\u0097\u0099"+
		"\u009c\u00b2\u00b4\u00b7\u00bd\u00c5\u00cc\u00d0\u00d9\u00e4\u00f0\u00f3"+
		"\u00f6\u00fd\u0101\u0106\u010c\u0111\u0115\u011a\u011d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}