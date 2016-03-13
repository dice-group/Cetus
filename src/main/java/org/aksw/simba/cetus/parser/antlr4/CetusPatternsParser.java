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
		COMMA=16, COLON=17, BRACKETS=18, WORD=19, WHITESPACE=20;
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
		"COMMA", "COLON", "BRACKETS", "WORD", "WHITESPACE"
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
		public Type_in_front_of_entityContext type_in_front_of_entity() {
			return getRuleContext(Type_in_front_of_entityContext.class,0);
		}
		public TerminalNode ENTITY() { return getToken(CetusPatternsParser.ENTITY, 0); }
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
		try {
			setState(30);
			switch (_input.LA(1)) {
			case ENTITY:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				entity_type_part();
				setState(25);
				match(POINT);
				}
				break;
			case ADJECTIVE:
			case DETERMINER:
			case NUMBER:
			case NOUN:
			case VERB:
			case ADVERB:
			case FOREIGN:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				type_in_front_of_entity();
				setState(28);
				match(ENTITY);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public List<TerminalNode> FORM_OF_BE() { return getTokens(CetusPatternsParser.FORM_OF_BE); }
		public TerminalNode FORM_OF_BE(int i) {
			return getToken(CetusPatternsParser.FORM_OF_BE, i);
		}
		public List<TerminalNode> VERB() { return getTokens(CetusPatternsParser.VERB); }
		public TerminalNode VERB(int i) {
			return getToken(CetusPatternsParser.VERB, i);
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
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				match(ENTITY);
				setState(34);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(33);
					match(COMMA);
					}
				}

				setState(36);
				type_after_entity_pattern();
				setState(38);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(37);
					match(COMMA);
					}
				}

				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
					{
					setState(51);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(40);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case BOTH:
					case CC:
						{
						setState(41);
						cc_word();
						}
						break;
					case OF:
						{
						setState(42);
						match(OF);
						}
						break;
					case ADJECTIVE:
						{
						setState(43);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(44);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(45);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(46);
						match(NOUN);
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
					case FORM_OF_BE:
						{
						setState(49);
						match(FORM_OF_BE);
						}
						break;
					case VERB:
						{
						setState(50);
						match(VERB);
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
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(ENTITY);
				setState(57);
				match(COMMA);
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(68);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(58);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case BOTH:
					case CC:
						{
						setState(59);
						cc_word();
						}
						break;
					case OF:
						{
						setState(60);
						match(OF);
						}
						break;
					case ADJECTIVE:
						{
						setState(61);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(62);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(63);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(64);
						match(NOUN);
						}
						break;
					case FOREIGN:
						{
						setState(65);
						match(FOREIGN);
						}
						break;
					case ADVERB:
						{
						setState(66);
						match(ADVERB);
						}
						break;
					case VERB:
						{
						setState(67);
						match(VERB);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(70); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0) );
				setState(72);
				match(COMMA);
				setState(73);
				type_after_entity_pattern();
				setState(75);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(74);
					match(COMMA);
					}
				}

				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
					{
					setState(88);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(77);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case BOTH:
					case CC:
						{
						setState(78);
						cc_word();
						}
						break;
					case OF:
						{
						setState(79);
						match(OF);
						}
						break;
					case ADJECTIVE:
						{
						setState(80);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(81);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(82);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(83);
						match(NOUN);
						}
						break;
					case FOREIGN:
						{
						setState(84);
						match(FOREIGN);
						}
						break;
					case ADVERB:
						{
						setState(85);
						match(ADVERB);
						}
						break;
					case FORM_OF_BE:
						{
						setState(86);
						match(FORM_OF_BE);
						}
						break;
					case VERB:
						{
						setState(87);
						match(VERB);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				match(ENTITY);
				setState(94);
				cc_word();
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(104);
						switch (_input.LA(1)) {
						case WORD:
							{
							setState(95);
							match(WORD);
							}
							break;
						case AND:
						case OR:
						case BOTH:
						case CC:
							{
							setState(96);
							cc_word();
							}
							break;
						case OF:
							{
							setState(97);
							match(OF);
							}
							break;
						case ADJECTIVE:
							{
							setState(98);
							match(ADJECTIVE);
							}
							break;
						case DETERMINER:
							{
							setState(99);
							match(DETERMINER);
							}
							break;
						case NUMBER:
							{
							setState(100);
							match(NUMBER);
							}
							break;
						case NOUN:
							{
							setState(101);
							match(NOUN);
							}
							break;
						case FOREIGN:
							{
							setState(102);
							match(FOREIGN);
							}
							break;
						case ADVERB:
							{
							setState(103);
							match(ADVERB);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(108);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(109);
				type_after_entity_pattern();
				setState(111);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(110);
					match(COMMA);
					}
				}

				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
					{
					setState(124);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(113);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case BOTH:
					case CC:
						{
						setState(114);
						cc_word();
						}
						break;
					case OF:
						{
						setState(115);
						match(OF);
						}
						break;
					case ADJECTIVE:
						{
						setState(116);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(117);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(118);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(119);
						match(NOUN);
						}
						break;
					case FOREIGN:
						{
						setState(120);
						match(FOREIGN);
						}
						break;
					case ADVERB:
						{
						setState(121);
						match(ADVERB);
						}
						break;
					case FORM_OF_BE:
						{
						setState(122);
						match(FORM_OF_BE);
						}
						break;
					case VERB:
						{
						setState(123);
						match(VERB);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(129);
				match(ENTITY);
				setState(130);
				cc_word();
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
					{
					setState(140);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(131);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case BOTH:
					case CC:
						{
						setState(132);
						cc_word();
						}
						break;
					case OF:
						{
						setState(133);
						match(OF);
						}
						break;
					case ADJECTIVE:
						{
						setState(134);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(135);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(136);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(137);
						match(NOUN);
						}
						break;
					case FOREIGN:
						{
						setState(138);
						match(FOREIGN);
						}
						break;
					case ADVERB:
						{
						setState(139);
						match(ADVERB);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(145);
				match(COMMA);
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(157);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(146);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case BOTH:
					case CC:
						{
						setState(147);
						cc_word();
						}
						break;
					case OF:
						{
						setState(148);
						match(OF);
						}
						break;
					case FORM_OF_BE:
						{
						setState(149);
						match(FORM_OF_BE);
						}
						break;
					case ADJECTIVE:
						{
						setState(150);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(151);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(152);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(153);
						match(NOUN);
						}
						break;
					case VERB:
						{
						setState(154);
						match(VERB);
						}
						break;
					case FOREIGN:
						{
						setState(155);
						match(FOREIGN);
						}
						break;
					case ADVERB:
						{
						setState(156);
						match(ADVERB);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(159); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0) );
				setState(161);
				match(COMMA);
				setState(162);
				type_after_entity_pattern();
				setState(164);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(163);
					match(COMMA);
					}
				}

				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
					{
					setState(177);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(166);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case BOTH:
					case CC:
						{
						setState(167);
						cc_word();
						}
						break;
					case OF:
						{
						setState(168);
						match(OF);
						}
						break;
					case ADJECTIVE:
						{
						setState(169);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(170);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(171);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(172);
						match(NOUN);
						}
						break;
					case FOREIGN:
						{
						setState(173);
						match(FOREIGN);
						}
						break;
					case ADVERB:
						{
						setState(174);
						match(ADVERB);
						}
						break;
					case FORM_OF_BE:
						{
						setState(175);
						match(FORM_OF_BE);
						}
						break;
					case VERB:
						{
						setState(176);
						match(VERB);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
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
		public Cc_wordContext cc_word() {
			return getRuleContext(Cc_wordContext.class,0);
		}
		public Type_with_dtContext type_with_dt() {
			return getRuleContext(Type_with_dtContext.class,0);
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
			setState(193);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				is_a_type_of_type_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				is_a_type_of_both_types_pattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				is_a_type_of_pattern();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(187);
				is_a_pattern();
				setState(188);
				cc_word();
				setState(189);
				is_a_pattern();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(191);
				is_a_pattern();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(192);
				type_with_dt();
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(FORM_OF_BE);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(196);
					match(ADVERB);
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(202);
			type_with_dt();
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(207);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						{
						setState(203);
						match(COMMA);
						setState(204);
						match(AND);
						}
						}
						break;
					case 2:
						{
						setState(205);
						match(AND);
						}
						break;
					case 3:
						{
						setState(206);
						match(COMMA);
						}
						break;
					}
					setState(209);
					type_with_dt();
					}
					} 
				}
				setState(214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
			setState(215);
			match(FORM_OF_BE);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADVERB) {
				{
				{
				setState(216);
				match(ADVERB);
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(222);
				nr();
				}
			}

			setState(225);
			match(OF);
			setState(226);
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
			setState(228);
			match(FORM_OF_BE);
			setState(232);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(229);
					match(ADVERB);
					}
					} 
				}
				setState(234);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(235);
			type_with_dt();
			setState(236);
			match(OF);
			setState(237);
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
			setState(239);
			match(FORM_OF_BE);
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(240);
					match(ADVERB);
					}
					} 
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(246);
			type_with_dt();
			setState(247);
			match(OF);
			setState(248);
			match(BOTH);
			setState(249);
			type_with_dt();
			setState(250);
			match(AND);
			setState(251);
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
			setState(253);
			type_with_dt();
			setState(255);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OF) | (1L << COMMA) | (1L << COLON))) != 0)) {
				{
				setState(254);
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
			setState(258);
			_la = _input.LA(1);
			if (_la==DETERMINER) {
				{
				setState(257);
				match(DETERMINER);
				}
			}

			setState(261);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(260);
				nr();
				}
			}

			setState(263);
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
			setState(300);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) {
					{
					{
					setState(265);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(270);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(272);
				_la = _input.LA(1);
				if (_la==FOREIGN) {
					{
					setState(271);
					match(FOREIGN);
					}
				}

				setState(275); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(274);
					match(NOUN);
					}
					}
					setState(277); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NOUN );
				setState(281); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(279);
						match(ADJECTIVE);
						setState(280);
						match(NOUN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(283); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) {
					{
					{
					setState(285);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(290);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(292);
				_la = _input.LA(1);
				if (_la==FOREIGN) {
					{
					setState(291);
					match(FOREIGN);
					}
				}

				setState(295); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(294);
						match(NOUN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(297); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
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
			setState(302);
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
			setState(304);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26\u0135\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\5\2!\n\2\3\3\3\3\5\3%\n"+
		"\3\3\3\3\3\5\3)\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\66"+
		"\n\3\f\3\16\39\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6"+
		"\3G\n\3\r\3\16\3H\3\3\3\3\3\3\5\3N\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\7\3[\n\3\f\3\16\3^\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3k\n\3\f\3\16\3n\13\3\3\3\3\3\5\3r\n\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\177\n\3\f\3\16\3\u0082\13\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u008f\n\3\f\3\16\3\u0092\13\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3\u00a0\n\3\r\3\16\3\u00a1"+
		"\3\3\3\3\3\3\5\3\u00a7\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3\u00b4\n\3\f\3\16\3\u00b7\13\3\5\3\u00b9\n\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4\u00c4\n\4\3\5\3\5\7\5\u00c8\n\5\f\5\16\5\u00cb\13\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5\u00d2\n\5\3\5\7\5\u00d5\n\5\f\5\16\5\u00d8\13"+
		"\5\3\6\3\6\7\6\u00dc\n\6\f\6\16\6\u00df\13\6\3\6\5\6\u00e2\n\6\3\6\3\6"+
		"\3\6\3\7\3\7\7\7\u00e9\n\7\f\7\16\7\u00ec\13\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\7\b\u00f4\n\b\f\b\16\b\u00f7\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\5\t\u0102\n\t\3\n\5\n\u0105\n\n\3\n\5\n\u0108\n\n\3\n\3\n\3\13\7\13\u010d"+
		"\n\13\f\13\16\13\u0110\13\13\3\13\5\13\u0113\n\13\3\13\6\13\u0116\n\13"+
		"\r\13\16\13\u0117\3\13\3\13\6\13\u011c\n\13\r\13\16\13\u011d\3\13\7\13"+
		"\u0121\n\13\f\13\16\13\u0124\13\13\3\13\5\13\u0127\n\13\3\13\6\13\u012a"+
		"\n\13\r\13\16\13\u012b\3\13\5\13\u012f\n\13\3\f\3\f\3\r\3\r\3\r\2\2\16"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\2\5\4\2\b\b\22\23\4\2\n\n\16\17\3\2\4\7"+
		"\u019d\2 \3\2\2\2\4\u00b8\3\2\2\2\6\u00c3\3\2\2\2\b\u00c5\3\2\2\2\n\u00d9"+
		"\3\2\2\2\f\u00e6\3\2\2\2\16\u00f1\3\2\2\2\20\u00ff\3\2\2\2\22\u0104\3"+
		"\2\2\2\24\u012e\3\2\2\2\26\u0130\3\2\2\2\30\u0132\3\2\2\2\32\33\5\4\3"+
		"\2\33\34\7\21\2\2\34!\3\2\2\2\35\36\5\20\t\2\36\37\7\3\2\2\37!\3\2\2\2"+
		" \32\3\2\2\2 \35\3\2\2\2!\3\3\2\2\2\"$\7\3\2\2#%\7\22\2\2$#\3\2\2\2$%"+
		"\3\2\2\2%&\3\2\2\2&(\5\6\4\2\')\7\22\2\2(\'\3\2\2\2()\3\2\2\2)\67\3\2"+
		"\2\2*\66\7\25\2\2+\66\5\30\r\2,\66\7\b\2\2-\66\7\n\2\2.\66\7\13\2\2/\66"+
		"\7\f\2\2\60\66\7\r\2\2\61\66\7\20\2\2\62\66\7\17\2\2\63\66\7\t\2\2\64"+
		"\66\7\16\2\2\65*\3\2\2\2\65+\3\2\2\2\65,\3\2\2\2\65-\3\2\2\2\65.\3\2\2"+
		"\2\65/\3\2\2\2\65\60\3\2\2\2\65\61\3\2\2\2\65\62\3\2\2\2\65\63\3\2\2\2"+
		"\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\u00b9\3\2\2\29\67"+
		"\3\2\2\2:;\7\3\2\2;F\7\22\2\2<G\7\25\2\2=G\5\30\r\2>G\7\b\2\2?G\7\n\2"+
		"\2@G\7\13\2\2AG\7\f\2\2BG\7\r\2\2CG\7\20\2\2DG\7\17\2\2EG\7\16\2\2F<\3"+
		"\2\2\2F=\3\2\2\2F>\3\2\2\2F?\3\2\2\2F@\3\2\2\2FA\3\2\2\2FB\3\2\2\2FC\3"+
		"\2\2\2FD\3\2\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7"+
		"\22\2\2KM\5\6\4\2LN\7\22\2\2ML\3\2\2\2MN\3\2\2\2N\\\3\2\2\2O[\7\25\2\2"+
		"P[\5\30\r\2Q[\7\b\2\2R[\7\n\2\2S[\7\13\2\2T[\7\f\2\2U[\7\r\2\2V[\7\20"+
		"\2\2W[\7\17\2\2X[\7\t\2\2Y[\7\16\2\2ZO\3\2\2\2ZP\3\2\2\2ZQ\3\2\2\2ZR\3"+
		"\2\2\2ZS\3\2\2\2ZT\3\2\2\2ZU\3\2\2\2ZV\3\2\2\2ZW\3\2\2\2ZX\3\2\2\2ZY\3"+
		"\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\u00b9\3\2\2\2^\\\3\2\2\2_`\7\3"+
		"\2\2`l\5\30\r\2ak\7\25\2\2bk\5\30\r\2ck\7\b\2\2dk\7\n\2\2ek\7\13\2\2f"+
		"k\7\f\2\2gk\7\r\2\2hk\7\20\2\2ik\7\17\2\2ja\3\2\2\2jb\3\2\2\2jc\3\2\2"+
		"\2jd\3\2\2\2je\3\2\2\2jf\3\2\2\2jg\3\2\2\2jh\3\2\2\2ji\3\2\2\2kn\3\2\2"+
		"\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2oq\5\6\4\2pr\7\22\2\2qp\3\2"+
		"\2\2qr\3\2\2\2r\u0080\3\2\2\2s\177\7\25\2\2t\177\5\30\r\2u\177\7\b\2\2"+
		"v\177\7\n\2\2w\177\7\13\2\2x\177\7\f\2\2y\177\7\r\2\2z\177\7\20\2\2{\177"+
		"\7\17\2\2|\177\7\t\2\2}\177\7\16\2\2~s\3\2\2\2~t\3\2\2\2~u\3\2\2\2~v\3"+
		"\2\2\2~w\3\2\2\2~x\3\2\2\2~y\3\2\2\2~z\3\2\2\2~{\3\2\2\2~|\3\2\2\2~}\3"+
		"\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u00b9"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\3\2\2\u0084\u0090\5\30\r\2"+
		"\u0085\u008f\7\25\2\2\u0086\u008f\5\30\r\2\u0087\u008f\7\b\2\2\u0088\u008f"+
		"\7\n\2\2\u0089\u008f\7\13\2\2\u008a\u008f\7\f\2\2\u008b\u008f\7\r\2\2"+
		"\u008c\u008f\7\20\2\2\u008d\u008f\7\17\2\2\u008e\u0085\3\2\2\2\u008e\u0086"+
		"\3\2\2\2\u008e\u0087\3\2\2\2\u008e\u0088\3\2\2\2\u008e\u0089\3\2\2\2\u008e"+
		"\u008a\3\2\2\2\u008e\u008b\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008d\3\2"+
		"\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u009f\7\22\2\2\u0094\u00a0\7"+
		"\25\2\2\u0095\u00a0\5\30\r\2\u0096\u00a0\7\b\2\2\u0097\u00a0\7\t\2\2\u0098"+
		"\u00a0\7\n\2\2\u0099\u00a0\7\13\2\2\u009a\u00a0\7\f\2\2\u009b\u00a0\7"+
		"\r\2\2\u009c\u00a0\7\16\2\2\u009d\u00a0\7\20\2\2\u009e\u00a0\7\17\2\2"+
		"\u009f\u0094\3\2\2\2\u009f\u0095\3\2\2\2\u009f\u0096\3\2\2\2\u009f\u0097"+
		"\3\2\2\2\u009f\u0098\3\2\2\2\u009f\u0099\3\2\2\2\u009f\u009a\3\2\2\2\u009f"+
		"\u009b\3\2\2\2\u009f\u009c\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\7\22\2\2\u00a4\u00a6\5\6\4\2\u00a5\u00a7\7"+
		"\22\2\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00b5\3\2\2\2\u00a8"+
		"\u00b4\7\25\2\2\u00a9\u00b4\5\30\r\2\u00aa\u00b4\7\b\2\2\u00ab\u00b4\7"+
		"\n\2\2\u00ac\u00b4\7\13\2\2\u00ad\u00b4\7\f\2\2\u00ae\u00b4\7\r\2\2\u00af"+
		"\u00b4\7\20\2\2\u00b0\u00b4\7\17\2\2\u00b1\u00b4\7\t\2\2\u00b2\u00b4\7"+
		"\16\2\2\u00b3\u00a8\3\2\2\2\u00b3\u00a9\3\2\2\2\u00b3\u00aa\3\2\2\2\u00b3"+
		"\u00ab\3\2\2\2\u00b3\u00ac\3\2\2\2\u00b3\u00ad\3\2\2\2\u00b3\u00ae\3\2"+
		"\2\2\u00b3\u00af\3\2\2\2\u00b3\u00b0\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\"\3\2\2\2\u00b8:\3"+
		"\2\2\2\u00b8_\3\2\2\2\u00b8\u0083\3\2\2\2\u00b9\5\3\2\2\2\u00ba\u00c4"+
		"\5\f\7\2\u00bb\u00c4\5\16\b\2\u00bc\u00c4\5\n\6\2\u00bd\u00be\5\b\5\2"+
		"\u00be\u00bf\5\30\r\2\u00bf\u00c0\5\b\5\2\u00c0\u00c4\3\2\2\2\u00c1\u00c4"+
		"\5\b\5\2\u00c2\u00c4\5\22\n\2\u00c3\u00ba\3\2\2\2\u00c3\u00bb\3\2\2\2"+
		"\u00c3\u00bc\3\2\2\2\u00c3\u00bd\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2"+
		"\3\2\2\2\u00c4\7\3\2\2\2\u00c5\u00c9\7\t\2\2\u00c6\u00c8\7\17\2\2\u00c7"+
		"\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00d6\5\22\n\2\u00cd"+
		"\u00ce\7\22\2\2\u00ce\u00d2\7\4\2\2\u00cf\u00d2\7\4\2\2\u00d0\u00d2\7"+
		"\22\2\2\u00d1\u00cd\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d5\5\22\n\2\u00d4\u00d1\3\2\2\2\u00d5\u00d8\3"+
		"\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\t\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d9\u00dd\7\t\2\2\u00da\u00dc\7\17\2\2\u00db\u00da\3\2\2\2"+
		"\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e1"+
		"\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e2\5\26\f\2\u00e1\u00e0\3\2\2\2"+
		"\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7\b\2\2\u00e4\u00e5"+
		"\5\22\n\2\u00e5\13\3\2\2\2\u00e6\u00ea\7\t\2\2\u00e7\u00e9\7\17\2\2\u00e8"+
		"\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\5\22\n\2\u00ee"+
		"\u00ef\7\b\2\2\u00ef\u00f0\5\22\n\2\u00f0\r\3\2\2\2\u00f1\u00f5\7\t\2"+
		"\2\u00f2\u00f4\7\17\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2"+
		"\2\2\u00f8\u00f9\5\22\n\2\u00f9\u00fa\7\b\2\2\u00fa\u00fb\7\6\2\2\u00fb"+
		"\u00fc\5\22\n\2\u00fc\u00fd\7\4\2\2\u00fd\u00fe\5\22\n\2\u00fe\17\3\2"+
		"\2\2\u00ff\u0101\5\22\n\2\u0100\u0102\t\2\2\2\u0101\u0100\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\21\3\2\2\2\u0103\u0105\7\13\2\2\u0104\u0103\3\2\2"+
		"\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0108\5\26\f\2\u0107"+
		"\u0106\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\5\24"+
		"\13\2\u010a\23\3\2\2\2\u010b\u010d\t\3\2\2\u010c\u010b\3\2\2\2\u010d\u0110"+
		"\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0112\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0111\u0113\7\20\2\2\u0112\u0111\3\2\2\2\u0112\u0113\3"+
		"\2\2\2\u0113\u0115\3\2\2\2\u0114\u0116\7\r\2\2\u0115\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011b\3\2"+
		"\2\2\u0119\u011a\7\n\2\2\u011a\u011c\7\r\2\2\u011b\u0119\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u012f\3\2"+
		"\2\2\u011f\u0121\t\3\2\2\u0120\u011f\3\2\2\2\u0121\u0124\3\2\2\2\u0122"+
		"\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2"+
		"\2\2\u0125\u0127\7\20\2\2\u0126\u0125\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0129\3\2\2\2\u0128\u012a\7\r\2\2\u0129\u0128\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012f\3\2\2\2\u012d"+
		"\u012f\7\n\2\2\u012e\u010e\3\2\2\2\u012e\u0122\3\2\2\2\u012e\u012d\3\2"+
		"\2\2\u012f\25\3\2\2\2\u0130\u0131\7\f\2\2\u0131\27\3\2\2\2\u0132\u0133"+
		"\t\4\2\2\u0133\31\3\2\2\2, $(\65\67FHMZ\\jlq~\u0080\u008e\u0090\u009f"+
		"\u00a1\u00a6\u00b3\u00b5\u00b8\u00c3\u00c9\u00d1\u00d6\u00dd\u00e1\u00ea"+
		"\u00f5\u0101\u0104\u0107\u010e\u0112\u0117\u011d\u0122\u0126\u012b\u012e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}