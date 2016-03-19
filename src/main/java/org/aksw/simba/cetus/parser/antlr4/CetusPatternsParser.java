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
		RULE_type_with_dt = 8, RULE_type = 9, RULE_nr = 10, RULE_cc_word = 11, 
		RULE_past_verb = 12;
	public static final String[] ruleNames = {
		"sentence", "entity_type_part", "type_after_entity_pattern", "is_a_pattern", 
		"is_a_type_of_pattern", "is_a_type_of_type_pattern", "is_a_type_of_both_types_pattern", 
		"type_in_front_of_entity", "type_with_dt", "type", "nr", "cc_word", "past_verb"
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
			setState(32);
			switch (_input.LA(1)) {
			case ENTITY:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				entity_type_part();
				setState(27);
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
				setState(29);
				type_in_front_of_entity();
				setState(30);
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
		public List<Past_verbContext> past_verb() {
			return getRuleContexts(Past_verbContext.class);
		}
		public Past_verbContext past_verb(int i) {
			return getRuleContext(Past_verbContext.class,i);
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
			setState(219);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(ENTITY);
				setState(36);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(35);
					match(COMMA);
					}
				}

				setState(38);
				type_after_entity_pattern();
				setState(40);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(39);
					match(COMMA);
					}
				}

				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
					{
					setState(54);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						setState(42);
						match(WORD);
						}
						break;
					case 2:
						{
						setState(43);
						cc_word();
						}
						break;
					case 3:
						{
						setState(44);
						match(OF);
						}
						break;
					case 4:
						{
						setState(45);
						match(ADJECTIVE);
						}
						break;
					case 5:
						{
						setState(46);
						match(DETERMINER);
						}
						break;
					case 6:
						{
						setState(47);
						match(NUMBER);
						}
						break;
					case 7:
						{
						setState(48);
						match(NOUN);
						}
						break;
					case 8:
						{
						setState(49);
						match(FOREIGN);
						}
						break;
					case 9:
						{
						setState(50);
						match(ADVERB);
						}
						break;
					case 10:
						{
						setState(51);
						match(FORM_OF_BE);
						}
						break;
					case 11:
						{
						setState(52);
						match(VERB);
						}
						break;
					case 12:
						{
						setState(53);
						past_verb();
						}
						break;
					}
					}
					setState(58);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(ENTITY);
				setState(60);
				match(COMMA);
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(72);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(61);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case BOTH:
					case CC:
						{
						setState(62);
						cc_word();
						}
						break;
					case OF:
						{
						setState(63);
						match(OF);
						}
						break;
					case ADJECTIVE:
						{
						setState(64);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(65);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(66);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(67);
						match(NOUN);
						}
						break;
					case FOREIGN:
						{
						setState(68);
						match(FOREIGN);
						}
						break;
					case ADVERB:
						{
						setState(69);
						match(ADVERB);
						}
						break;
					case VERB:
						{
						setState(70);
						match(VERB);
						}
						break;
					case FORM_OF_BE:
						{
						setState(71);
						past_verb();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(74); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0) );
				setState(76);
				match(COMMA);
				setState(77);
				type_after_entity_pattern();
				setState(79);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(78);
					match(COMMA);
					}
				}

				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
					{
					setState(93);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						setState(81);
						match(WORD);
						}
						break;
					case 2:
						{
						setState(82);
						cc_word();
						}
						break;
					case 3:
						{
						setState(83);
						match(OF);
						}
						break;
					case 4:
						{
						setState(84);
						match(ADJECTIVE);
						}
						break;
					case 5:
						{
						setState(85);
						match(DETERMINER);
						}
						break;
					case 6:
						{
						setState(86);
						match(NUMBER);
						}
						break;
					case 7:
						{
						setState(87);
						match(NOUN);
						}
						break;
					case 8:
						{
						setState(88);
						match(FOREIGN);
						}
						break;
					case 9:
						{
						setState(89);
						match(ADVERB);
						}
						break;
					case 10:
						{
						setState(90);
						match(FORM_OF_BE);
						}
						break;
					case 11:
						{
						setState(91);
						match(VERB);
						}
						break;
					case 12:
						{
						setState(92);
						past_verb();
						}
						break;
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				match(ENTITY);
				setState(99);
				cc_word();
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(110);
						switch (_input.LA(1)) {
						case WORD:
							{
							setState(100);
							match(WORD);
							}
							break;
						case AND:
						case OR:
						case BOTH:
						case CC:
							{
							setState(101);
							cc_word();
							}
							break;
						case OF:
							{
							setState(102);
							match(OF);
							}
							break;
						case ADJECTIVE:
							{
							setState(103);
							match(ADJECTIVE);
							}
							break;
						case DETERMINER:
							{
							setState(104);
							match(DETERMINER);
							}
							break;
						case NUMBER:
							{
							setState(105);
							match(NUMBER);
							}
							break;
						case NOUN:
							{
							setState(106);
							match(NOUN);
							}
							break;
						case FOREIGN:
							{
							setState(107);
							match(FOREIGN);
							}
							break;
						case ADVERB:
							{
							setState(108);
							match(ADVERB);
							}
							break;
						case FORM_OF_BE:
							{
							setState(109);
							past_verb();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(114);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(115);
				type_after_entity_pattern();
				setState(117);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(116);
					match(COMMA);
					}
				}

				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
					{
					setState(131);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						setState(119);
						match(WORD);
						}
						break;
					case 2:
						{
						setState(120);
						cc_word();
						}
						break;
					case 3:
						{
						setState(121);
						match(OF);
						}
						break;
					case 4:
						{
						setState(122);
						match(ADJECTIVE);
						}
						break;
					case 5:
						{
						setState(123);
						match(DETERMINER);
						}
						break;
					case 6:
						{
						setState(124);
						match(NUMBER);
						}
						break;
					case 7:
						{
						setState(125);
						match(NOUN);
						}
						break;
					case 8:
						{
						setState(126);
						match(FOREIGN);
						}
						break;
					case 9:
						{
						setState(127);
						match(ADVERB);
						}
						break;
					case 10:
						{
						setState(128);
						match(FORM_OF_BE);
						}
						break;
					case 11:
						{
						setState(129);
						match(VERB);
						}
						break;
					case 12:
						{
						setState(130);
						past_verb();
						}
						break;
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				match(ENTITY);
				setState(137);
				cc_word();
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
					{
					setState(148);
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
						past_verb();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(153);
				match(COMMA);
				setState(166); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(166);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						setState(154);
						match(WORD);
						}
						break;
					case 2:
						{
						setState(155);
						cc_word();
						}
						break;
					case 3:
						{
						setState(156);
						match(OF);
						}
						break;
					case 4:
						{
						setState(157);
						match(FORM_OF_BE);
						}
						break;
					case 5:
						{
						setState(158);
						match(ADJECTIVE);
						}
						break;
					case 6:
						{
						setState(159);
						match(DETERMINER);
						}
						break;
					case 7:
						{
						setState(160);
						match(NUMBER);
						}
						break;
					case 8:
						{
						setState(161);
						match(NOUN);
						}
						break;
					case 9:
						{
						setState(162);
						match(VERB);
						}
						break;
					case 10:
						{
						setState(163);
						match(FOREIGN);
						}
						break;
					case 11:
						{
						setState(164);
						match(ADVERB);
						}
						break;
					case 12:
						{
						setState(165);
						past_verb();
						}
						break;
					}
					}
					setState(168); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0) );
				setState(170);
				match(COMMA);
				setState(171);
				type_after_entity_pattern();
				setState(173);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(172);
					match(COMMA);
					}
				}

				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
					{
					setState(187);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						setState(175);
						match(WORD);
						}
						break;
					case 2:
						{
						setState(176);
						cc_word();
						}
						break;
					case 3:
						{
						setState(177);
						match(OF);
						}
						break;
					case 4:
						{
						setState(178);
						match(ADJECTIVE);
						}
						break;
					case 5:
						{
						setState(179);
						match(DETERMINER);
						}
						break;
					case 6:
						{
						setState(180);
						match(NUMBER);
						}
						break;
					case 7:
						{
						setState(181);
						match(NOUN);
						}
						break;
					case 8:
						{
						setState(182);
						match(FOREIGN);
						}
						break;
					case 9:
						{
						setState(183);
						match(ADVERB);
						}
						break;
					case 10:
						{
						setState(184);
						match(FORM_OF_BE);
						}
						break;
					case 11:
						{
						setState(185);
						match(VERB);
						}
						break;
					case 12:
						{
						setState(186);
						past_verb();
						}
						break;
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(192);
				match(ENTITY);
				setState(194);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(193);
					match(COMMA);
					}
				}

				setState(196);
				type_after_entity_pattern();
				setState(215); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(197);
					match(COMMA);
					setState(212);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << BOTH) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
						{
						setState(210);
						switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
						case 1:
							{
							setState(198);
							match(WORD);
							}
							break;
						case 2:
							{
							setState(199);
							cc_word();
							}
							break;
						case 3:
							{
							setState(200);
							match(OF);
							}
							break;
						case 4:
							{
							setState(201);
							match(ADJECTIVE);
							}
							break;
						case 5:
							{
							setState(202);
							match(DETERMINER);
							}
							break;
						case 6:
							{
							setState(203);
							match(NUMBER);
							}
							break;
						case 7:
							{
							setState(204);
							match(NOUN);
							}
							break;
						case 8:
							{
							setState(205);
							match(FOREIGN);
							}
							break;
						case 9:
							{
							setState(206);
							match(ADVERB);
							}
							break;
						case 10:
							{
							setState(207);
							match(FORM_OF_BE);
							}
							break;
						case 11:
							{
							setState(208);
							match(VERB);
							}
							break;
						case 12:
							{
							setState(209);
							past_verb();
							}
							break;
						}
						}
						setState(214);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(217); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
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
			setState(230);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				is_a_type_of_type_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				is_a_type_of_both_types_pattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
				is_a_type_of_pattern();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				is_a_pattern();
				setState(225);
				cc_word();
				setState(226);
				is_a_pattern();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(228);
				is_a_pattern();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(229);
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
			setState(232);
			match(FORM_OF_BE);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(233);
					match(ADVERB);
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(239);
			type_with_dt();
			setState(249);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(244);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						{
						setState(240);
						match(COMMA);
						setState(241);
						match(AND);
						}
						}
						break;
					case 2:
						{
						setState(242);
						match(AND);
						}
						break;
					case 3:
						{
						setState(243);
						match(COMMA);
						}
						break;
					}
					setState(246);
					type_with_dt();
					}
					} 
				}
				setState(251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
			setState(252);
			match(FORM_OF_BE);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADVERB) {
				{
				{
				setState(253);
				match(ADVERB);
				}
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(260);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(259);
				nr();
				}
			}

			setState(262);
			match(OF);
			setState(263);
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
			setState(265);
			match(FORM_OF_BE);
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(266);
					match(ADVERB);
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			setState(272);
			type_with_dt();
			setState(273);
			match(OF);
			setState(274);
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
			setState(276);
			match(FORM_OF_BE);
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(277);
					match(ADVERB);
					}
					} 
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(283);
			type_with_dt();
			setState(284);
			match(OF);
			setState(285);
			match(BOTH);
			setState(286);
			type_with_dt();
			setState(287);
			match(AND);
			setState(288);
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
			setState(290);
			type_with_dt();
			setState(292);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OF) | (1L << COMMA) | (1L << COLON))) != 0)) {
				{
				setState(291);
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
			setState(295);
			_la = _input.LA(1);
			if (_la==DETERMINER) {
				{
				setState(294);
				match(DETERMINER);
				}
			}

			setState(298);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(297);
				nr();
				}
			}

			setState(300);
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
			setState(337);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) {
					{
					{
					setState(302);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(307);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(309);
				_la = _input.LA(1);
				if (_la==FOREIGN) {
					{
					setState(308);
					match(FOREIGN);
					}
				}

				setState(312); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(311);
					match(NOUN);
					}
					}
					setState(314); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NOUN );
				setState(318); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(316);
						match(ADJECTIVE);
						setState(317);
						match(NOUN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(320); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) {
					{
					{
					setState(322);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(327);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(329);
				_la = _input.LA(1);
				if (_la==FOREIGN) {
					{
					setState(328);
					match(FOREIGN);
					}
				}

				setState(332); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(331);
						match(NOUN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(334); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(336);
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
			setState(339);
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
			setState(341);
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

	public static class Past_verbContext extends ParserRuleContext {
		public TerminalNode FORM_OF_BE() { return getToken(CetusPatternsParser.FORM_OF_BE, 0); }
		public TerminalNode VERB() { return getToken(CetusPatternsParser.VERB, 0); }
		public Past_verbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_past_verb; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitPast_verb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Past_verbContext past_verb() throws RecognitionException {
		Past_verbContext _localctx = new Past_verbContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_past_verb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(FORM_OF_BE);
			setState(344);
			match(VERB);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26\u015d\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\5\2#\n\2\3\3\3"+
		"\3\5\3\'\n\3\3\3\3\3\5\3+\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\39\n\3\f\3\16\3<\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\6\3K\n\3\r\3\16\3L\3\3\3\3\3\3\5\3R\n\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3`\n\3\f\3\16\3c\13\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3q\n\3\f\3\16\3t\13\3\3\3\3\3\5\3"+
		"x\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u0086\n\3\f"+
		"\3\16\3\u0089\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3"+
		"\u0097\n\3\f\3\16\3\u009a\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\6\3\u00a9\n\3\r\3\16\3\u00aa\3\3\3\3\3\3\5\3\u00b0\n\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\u00be\n\3\f\3\16\3"+
		"\u00c1\13\3\3\3\3\3\5\3\u00c5\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\7\3\u00d5\n\3\f\3\16\3\u00d8\13\3\6\3\u00da\n\3\r"+
		"\3\16\3\u00db\5\3\u00de\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00e9"+
		"\n\4\3\5\3\5\7\5\u00ed\n\5\f\5\16\5\u00f0\13\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"\u00f7\n\5\3\5\7\5\u00fa\n\5\f\5\16\5\u00fd\13\5\3\6\3\6\7\6\u0101\n\6"+
		"\f\6\16\6\u0104\13\6\3\6\5\6\u0107\n\6\3\6\3\6\3\6\3\7\3\7\7\7\u010e\n"+
		"\7\f\7\16\7\u0111\13\7\3\7\3\7\3\7\3\7\3\b\3\b\7\b\u0119\n\b\f\b\16\b"+
		"\u011c\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\5\t\u0127\n\t\3\n\5\n"+
		"\u012a\n\n\3\n\5\n\u012d\n\n\3\n\3\n\3\13\7\13\u0132\n\13\f\13\16\13\u0135"+
		"\13\13\3\13\5\13\u0138\n\13\3\13\6\13\u013b\n\13\r\13\16\13\u013c\3\13"+
		"\3\13\6\13\u0141\n\13\r\13\16\13\u0142\3\13\7\13\u0146\n\13\f\13\16\13"+
		"\u0149\13\13\3\13\5\13\u014c\n\13\3\13\6\13\u014f\n\13\r\13\16\13\u0150"+
		"\3\13\5\13\u0154\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\2\2\17\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\2\5\4\2\b\b\22\23\4\2\n\n\16\17\3\2\4\7\u01db"+
		"\2\"\3\2\2\2\4\u00dd\3\2\2\2\6\u00e8\3\2\2\2\b\u00ea\3\2\2\2\n\u00fe\3"+
		"\2\2\2\f\u010b\3\2\2\2\16\u0116\3\2\2\2\20\u0124\3\2\2\2\22\u0129\3\2"+
		"\2\2\24\u0153\3\2\2\2\26\u0155\3\2\2\2\30\u0157\3\2\2\2\32\u0159\3\2\2"+
		"\2\34\35\5\4\3\2\35\36\7\21\2\2\36#\3\2\2\2\37 \5\20\t\2 !\7\3\2\2!#\3"+
		"\2\2\2\"\34\3\2\2\2\"\37\3\2\2\2#\3\3\2\2\2$&\7\3\2\2%\'\7\22\2\2&%\3"+
		"\2\2\2&\'\3\2\2\2\'(\3\2\2\2(*\5\6\4\2)+\7\22\2\2*)\3\2\2\2*+\3\2\2\2"+
		"+:\3\2\2\2,9\7\25\2\2-9\5\30\r\2.9\7\b\2\2/9\7\n\2\2\609\7\13\2\2\619"+
		"\7\f\2\2\629\7\r\2\2\639\7\20\2\2\649\7\17\2\2\659\7\t\2\2\669\7\16\2"+
		"\2\679\5\32\16\28,\3\2\2\28-\3\2\2\28.\3\2\2\28/\3\2\2\28\60\3\2\2\28"+
		"\61\3\2\2\28\62\3\2\2\28\63\3\2\2\28\64\3\2\2\28\65\3\2\2\28\66\3\2\2"+
		"\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\u00de\3\2\2\2<:\3\2\2\2"+
		"=>\7\3\2\2>J\7\22\2\2?K\7\25\2\2@K\5\30\r\2AK\7\b\2\2BK\7\n\2\2CK\7\13"+
		"\2\2DK\7\f\2\2EK\7\r\2\2FK\7\20\2\2GK\7\17\2\2HK\7\16\2\2IK\5\32\16\2"+
		"J?\3\2\2\2J@\3\2\2\2JA\3\2\2\2JB\3\2\2\2JC\3\2\2\2JD\3\2\2\2JE\3\2\2\2"+
		"JF\3\2\2\2JG\3\2\2\2JH\3\2\2\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2"+
		"MN\3\2\2\2NO\7\22\2\2OQ\5\6\4\2PR\7\22\2\2QP\3\2\2\2QR\3\2\2\2Ra\3\2\2"+
		"\2S`\7\25\2\2T`\5\30\r\2U`\7\b\2\2V`\7\n\2\2W`\7\13\2\2X`\7\f\2\2Y`\7"+
		"\r\2\2Z`\7\20\2\2[`\7\17\2\2\\`\7\t\2\2]`\7\16\2\2^`\5\32\16\2_S\3\2\2"+
		"\2_T\3\2\2\2_U\3\2\2\2_V\3\2\2\2_W\3\2\2\2_X\3\2\2\2_Y\3\2\2\2_Z\3\2\2"+
		"\2_[\3\2\2\2_\\\3\2\2\2_]\3\2\2\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2"+
		"\2\2b\u00de\3\2\2\2ca\3\2\2\2de\7\3\2\2er\5\30\r\2fq\7\25\2\2gq\5\30\r"+
		"\2hq\7\b\2\2iq\7\n\2\2jq\7\13\2\2kq\7\f\2\2lq\7\r\2\2mq\7\20\2\2nq\7\17"+
		"\2\2oq\5\32\16\2pf\3\2\2\2pg\3\2\2\2ph\3\2\2\2pi\3\2\2\2pj\3\2\2\2pk\3"+
		"\2\2\2pl\3\2\2\2pm\3\2\2\2pn\3\2\2\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3"+
		"\2\2\2su\3\2\2\2tr\3\2\2\2uw\5\6\4\2vx\7\22\2\2wv\3\2\2\2wx\3\2\2\2x\u0087"+
		"\3\2\2\2y\u0086\7\25\2\2z\u0086\5\30\r\2{\u0086\7\b\2\2|\u0086\7\n\2\2"+
		"}\u0086\7\13\2\2~\u0086\7\f\2\2\177\u0086\7\r\2\2\u0080\u0086\7\20\2\2"+
		"\u0081\u0086\7\17\2\2\u0082\u0086\7\t\2\2\u0083\u0086\7\16\2\2\u0084\u0086"+
		"\5\32\16\2\u0085y\3\2\2\2\u0085z\3\2\2\2\u0085{\3\2\2\2\u0085|\3\2\2\2"+
		"\u0085}\3\2\2\2\u0085~\3\2\2\2\u0085\177\3\2\2\2\u0085\u0080\3\2\2\2\u0085"+
		"\u0081\3\2\2\2\u0085\u0082\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2"+
		"\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u00de\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\3\2\2\u008b\u0098\5\30"+
		"\r\2\u008c\u0097\7\25\2\2\u008d\u0097\5\30\r\2\u008e\u0097\7\b\2\2\u008f"+
		"\u0097\7\n\2\2\u0090\u0097\7\13\2\2\u0091\u0097\7\f\2\2\u0092\u0097\7"+
		"\r\2\2\u0093\u0097\7\20\2\2\u0094\u0097\7\17\2\2\u0095\u0097\5\32\16\2"+
		"\u0096\u008c\3\2\2\2\u0096\u008d\3\2\2\2\u0096\u008e\3\2\2\2\u0096\u008f"+
		"\3\2\2\2\u0096\u0090\3\2\2\2\u0096\u0091\3\2\2\2\u0096\u0092\3\2\2\2\u0096"+
		"\u0093\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009b\u00a8\7\22\2\2\u009c\u00a9\7\25\2\2\u009d\u00a9\5"+
		"\30\r\2\u009e\u00a9\7\b\2\2\u009f\u00a9\7\t\2\2\u00a0\u00a9\7\n\2\2\u00a1"+
		"\u00a9\7\13\2\2\u00a2\u00a9\7\f\2\2\u00a3\u00a9\7\r\2\2\u00a4\u00a9\7"+
		"\16\2\2\u00a5\u00a9\7\20\2\2\u00a6\u00a9\7\17\2\2\u00a7\u00a9\5\32\16"+
		"\2\u00a8\u009c\3\2\2\2\u00a8\u009d\3\2\2\2\u00a8\u009e\3\2\2\2\u00a8\u009f"+
		"\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a1\3\2\2\2\u00a8\u00a2\3\2\2\2\u00a8"+
		"\u00a3\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a8\u00a6\3\2"+
		"\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\7\22\2\2\u00ad\u00af\5"+
		"\6\4\2\u00ae\u00b0\7\22\2\2\u00af\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00bf\3\2\2\2\u00b1\u00be\7\25\2\2\u00b2\u00be\5\30\r\2\u00b3\u00be\7"+
		"\b\2\2\u00b4\u00be\7\n\2\2\u00b5\u00be\7\13\2\2\u00b6\u00be\7\f\2\2\u00b7"+
		"\u00be\7\r\2\2\u00b8\u00be\7\20\2\2\u00b9\u00be\7\17\2\2\u00ba\u00be\7"+
		"\t\2\2\u00bb\u00be\7\16\2\2\u00bc\u00be\5\32\16\2\u00bd\u00b1\3\2\2\2"+
		"\u00bd\u00b2\3\2\2\2\u00bd\u00b3\3\2\2\2\u00bd\u00b4\3\2\2\2\u00bd\u00b5"+
		"\3\2\2\2\u00bd\u00b6\3\2\2\2\u00bd\u00b7\3\2\2\2\u00bd\u00b8\3\2\2\2\u00bd"+
		"\u00b9\3\2\2\2\u00bd\u00ba\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00bc\3\2"+
		"\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00de\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c4\7\3\2\2\u00c3\u00c5\7\22"+
		"\2\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00d9\5\6\4\2\u00c7\u00d6\7\22\2\2\u00c8\u00d5\7\25\2\2\u00c9\u00d5\5"+
		"\30\r\2\u00ca\u00d5\7\b\2\2\u00cb\u00d5\7\n\2\2\u00cc\u00d5\7\13\2\2\u00cd"+
		"\u00d5\7\f\2\2\u00ce\u00d5\7\r\2\2\u00cf\u00d5\7\20\2\2\u00d0\u00d5\7"+
		"\17\2\2\u00d1\u00d5\7\t\2\2\u00d2\u00d5\7\16\2\2\u00d3\u00d5\5\32\16\2"+
		"\u00d4\u00c8\3\2\2\2\u00d4\u00c9\3\2\2\2\u00d4\u00ca\3\2\2\2\u00d4\u00cb"+
		"\3\2\2\2\u00d4\u00cc\3\2\2\2\u00d4\u00cd\3\2\2\2\u00d4\u00ce\3\2\2\2\u00d4"+
		"\u00cf\3\2\2\2\u00d4\u00d0\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00c7\3\2"+
		"\2\2\u00da\u00db\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00de\3\2\2\2\u00dd$\3\2\2\2\u00dd=\3\2\2\2\u00ddd\3\2\2\2\u00dd\u008a"+
		"\3\2\2\2\u00dd\u00c2\3\2\2\2\u00de\5\3\2\2\2\u00df\u00e9\5\f\7\2\u00e0"+
		"\u00e9\5\16\b\2\u00e1\u00e9\5\n\6\2\u00e2\u00e3\5\b\5\2\u00e3\u00e4\5"+
		"\30\r\2\u00e4\u00e5\5\b\5\2\u00e5\u00e9\3\2\2\2\u00e6\u00e9\5\b\5\2\u00e7"+
		"\u00e9\5\22\n\2\u00e8\u00df\3\2\2\2\u00e8\u00e0\3\2\2\2\u00e8\u00e1\3"+
		"\2\2\2\u00e8\u00e2\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9"+
		"\7\3\2\2\2\u00ea\u00ee\7\t\2\2\u00eb\u00ed\7\17\2\2\u00ec\u00eb\3\2\2"+
		"\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1"+
		"\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00fb\5\22\n\2\u00f2\u00f3\7\22\2\2"+
		"\u00f3\u00f7\7\4\2\2\u00f4\u00f7\7\4\2\2\u00f5\u00f7\7\22\2\2\u00f6\u00f2"+
		"\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\u00fa\5\22\n\2\u00f9\u00f6\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3"+
		"\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\t\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0102"+
		"\7\t\2\2\u00ff\u0101\7\17\2\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2"+
		"\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102"+
		"\3\2\2\2\u0105\u0107\5\26\f\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2"+
		"\u0107\u0108\3\2\2\2\u0108\u0109\7\b\2\2\u0109\u010a\5\22\n\2\u010a\13"+
		"\3\2\2\2\u010b\u010f\7\t\2\2\u010c\u010e\7\17\2\2\u010d\u010c\3\2\2\2"+
		"\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112"+
		"\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\5\22\n\2\u0113\u0114\7\b\2\2"+
		"\u0114\u0115\5\22\n\2\u0115\r\3\2\2\2\u0116\u011a\7\t\2\2\u0117\u0119"+
		"\7\17\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2"+
		"\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e"+
		"\5\22\n\2\u011e\u011f\7\b\2\2\u011f\u0120\7\6\2\2\u0120\u0121\5\22\n\2"+
		"\u0121\u0122\7\4\2\2\u0122\u0123\5\22\n\2\u0123\17\3\2\2\2\u0124\u0126"+
		"\5\22\n\2\u0125\u0127\t\2\2\2\u0126\u0125\3\2\2\2\u0126\u0127\3\2\2\2"+
		"\u0127\21\3\2\2\2\u0128\u012a\7\13\2\2\u0129\u0128\3\2\2\2\u0129\u012a"+
		"\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u012d\5\26\f\2\u012c\u012b\3\2\2\2"+
		"\u012c\u012d\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\5\24\13\2\u012f\23"+
		"\3\2\2\2\u0130\u0132\t\3\2\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2"+
		"\2\2\u0136\u0138\7\20\2\2\u0137\u0136\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"\u013a\3\2\2\2\u0139\u013b\7\r\2\2\u013a\u0139\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u0140\3\2\2\2\u013e"+
		"\u013f\7\n\2\2\u013f\u0141\7\r\2\2\u0140\u013e\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0154\3\2\2\2\u0144"+
		"\u0146\t\3\2\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2"+
		"\2\2\u0147\u0148\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u014a"+
		"\u014c\7\20\2\2\u014b\u014a\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014e\3"+
		"\2\2\2\u014d\u014f\7\r\2\2\u014e\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0154\7\n"+
		"\2\2\u0153\u0133\3\2\2\2\u0153\u0147\3\2\2\2\u0153\u0152\3\2\2\2\u0154"+
		"\25\3\2\2\2\u0155\u0156\7\f\2\2\u0156\27\3\2\2\2\u0157\u0158\t\4\2\2\u0158"+
		"\31\3\2\2\2\u0159\u015a\7\t\2\2\u015a\u015b\7\16\2\2\u015b\33\3\2\2\2"+
		"\60\"&*8:JLQ_aprw\u0085\u0087\u0096\u0098\u00a8\u00aa\u00af\u00bd\u00bf"+
		"\u00c4\u00d4\u00d6\u00db\u00dd\u00e8\u00ee\u00f6\u00fb\u0102\u0106\u010f"+
		"\u011a\u0126\u0129\u012c\u0133\u0137\u013c\u0142\u0147\u014b\u0150\u0153";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}