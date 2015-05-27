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
		ENTITY=1, AND=2, OR=3, CC=4, OF=5, FORM_OF_BE=6, ADJECTIVE=7, DETERMINER=8, 
		NUMBER=9, NOUN=10, VERB=11, ADVERB=12, FOREIGN=13, POINT=14, COMMA=15, 
		COLON=16, WORD=17, WHITESPACE=18;
	public static final int
		RULE_sentence = 0, RULE_type_after_entity_pattern = 1, RULE_is_a_pattern = 2, 
		RULE_is_a_type_of_pattern = 3, RULE_type_in_front_of_entity = 4, RULE_type_with_dt = 5, 
		RULE_type = 6, RULE_nr = 7, RULE_cc_word = 8;
	public static final String[] ruleNames = {
		"sentence", "type_after_entity_pattern", "is_a_pattern", "is_a_type_of_pattern", 
		"type_in_front_of_entity", "type_with_dt", "type", "nr", "cc_word"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'$ENTITY$'", "'and_and_CC'", "'or_or_CC'", null, "'of_of_IN'", 
		null, null, null, null, null, null, null, null, "'._._.'", "',_,_,'", 
		"':_:_:'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ENTITY", "AND", "OR", "CC", "OF", "FORM_OF_BE", "ADJECTIVE", "DETERMINER", 
		"NUMBER", "NOUN", "VERB", "ADVERB", "FOREIGN", "POINT", "COMMA", "COLON", 
		"WORD", "WHITESPACE"
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
		public TerminalNode ENTITY() { return getToken(CetusPatternsParser.ENTITY, 0); }
		public Type_after_entity_patternContext type_after_entity_pattern() {
			return getRuleContext(Type_after_entity_patternContext.class,0);
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
		public List<TerminalNode> COMMA() { return getTokens(CetusPatternsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CetusPatternsParser.COMMA, i);
		}
		public List<TerminalNode> POINT() { return getTokens(CetusPatternsParser.POINT); }
		public TerminalNode POINT(int i) {
			return getToken(CetusPatternsParser.POINT, i);
		}
		public List<TerminalNode> COLON() { return getTokens(CetusPatternsParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(CetusPatternsParser.COLON, i);
		}
		public List<TerminalNode> FORM_OF_BE() { return getTokens(CetusPatternsParser.FORM_OF_BE); }
		public TerminalNode FORM_OF_BE(int i) {
			return getToken(CetusPatternsParser.FORM_OF_BE, i);
		}
		public List<TerminalNode> VERB() { return getTokens(CetusPatternsParser.VERB); }
		public TerminalNode VERB(int i) {
			return getToken(CetusPatternsParser.VERB, i);
		}
		public Type_in_front_of_entityContext type_in_front_of_entity() {
			return getRuleContext(Type_in_front_of_entityContext.class,0);
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
			setState(90);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << CC) | (1L << OF) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) {
					{
					setState(27);
					switch (_input.LA(1)) {
					case WORD:
						{
						setState(18);
						match(WORD);
						}
						break;
					case AND:
					case OR:
					case CC:
						{
						setState(19);
						cc_word();
						}
						break;
					case OF:
						{
						setState(20);
						match(OF);
						}
						break;
					case ADJECTIVE:
						{
						setState(21);
						match(ADJECTIVE);
						}
						break;
					case DETERMINER:
						{
						setState(22);
						match(DETERMINER);
						}
						break;
					case NUMBER:
						{
						setState(23);
						match(NUMBER);
						}
						break;
					case NOUN:
						{
						setState(24);
						match(NOUN);
						}
						break;
					case FOREIGN:
						{
						setState(25);
						match(FOREIGN);
						}
						break;
					case ADVERB:
						{
						setState(26);
						match(ADVERB);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(32);
				match(ENTITY);
				setState(48);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << CC))) != 0)) {
					{
					setState(33);
					cc_word();
					setState(45);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							setState(43);
							switch (_input.LA(1)) {
							case WORD:
								{
								setState(34);
								match(WORD);
								}
								break;
							case AND:
							case OR:
							case CC:
								{
								setState(35);
								cc_word();
								}
								break;
							case OF:
								{
								setState(36);
								match(OF);
								}
								break;
							case ADJECTIVE:
								{
								setState(37);
								match(ADJECTIVE);
								}
								break;
							case DETERMINER:
								{
								setState(38);
								match(DETERMINER);
								}
								break;
							case NUMBER:
								{
								setState(39);
								match(NUMBER);
								}
								break;
							case NOUN:
								{
								setState(40);
								match(NOUN);
								}
								break;
							case FOREIGN:
								{
								setState(41);
								match(FOREIGN);
								}
								break;
							case ADVERB:
								{
								setState(42);
								match(ADVERB);
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							} 
						}
						setState(47);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
					}
					}
				}

				setState(67);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(50);
					match(COMMA);
					setState(62); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(62);
						switch (_input.LA(1)) {
						case WORD:
							{
							setState(51);
							match(WORD);
							}
							break;
						case AND:
						case OR:
						case CC:
							{
							setState(52);
							cc_word();
							}
							break;
						case OF:
							{
							setState(53);
							match(OF);
							}
							break;
						case FORM_OF_BE:
							{
							setState(54);
							match(FORM_OF_BE);
							}
							break;
						case ADJECTIVE:
							{
							setState(55);
							match(ADJECTIVE);
							}
							break;
						case DETERMINER:
							{
							setState(56);
							match(DETERMINER);
							}
							break;
						case NUMBER:
							{
							setState(57);
							match(NUMBER);
							}
							break;
						case NOUN:
							{
							setState(58);
							match(NOUN);
							}
							break;
						case VERB:
							{
							setState(59);
							match(VERB);
							}
							break;
						case FOREIGN:
							{
							setState(60);
							match(FOREIGN);
							}
							break;
						case ADVERB:
							{
							setState(61);
							match(ADVERB);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(64); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << CC) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0) );
					setState(66);
					match(COMMA);
					}
					break;
				}
				setState(69);
				type_after_entity_pattern();
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << POINT) | (1L << COMMA) | (1L << COLON) | (1L << WORD))) != 0)) {
					{
					{
					setState(70);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << POINT) | (1L << COMMA) | (1L << COLON) | (1L << WORD))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(76);
					match(WORD);
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(82);
				type_in_front_of_entity();
				setState(83);
				match(ENTITY);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(84);
					match(WORD);
					}
					}
					setState(89);
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
		public Is_a_type_of_patternContext is_a_type_of_pattern() {
			return getRuleContext(Is_a_type_of_patternContext.class,0);
		}
		public Is_a_patternContext is_a_pattern() {
			return getRuleContext(Is_a_patternContext.class,0);
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
		enterRule(_localctx, 2, RULE_type_after_entity_pattern);
		try {
			setState(95);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				is_a_type_of_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				is_a_pattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
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
		public List<TerminalNode> COMMA() { return getTokens(CetusPatternsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CetusPatternsParser.COMMA, i);
		}
		public List<TerminalNode> AND() { return getTokens(CetusPatternsParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CetusPatternsParser.AND, i);
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
		enterRule(_localctx, 4, RULE_is_a_pattern);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(97);
				match(COMMA);
				}
			}

			setState(100);
			match(FORM_OF_BE);
			setState(101);
			type_with_dt();
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(107);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						{
						setState(103);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(102);
							match(COMMA);
							}
						}

						setState(105);
						match(AND);
						}
						}
						break;
					case 2:
						{
						setState(106);
						match(COMMA);
						}
						break;
					}
					setState(109);
					type_with_dt();
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		public List<Type_with_dtContext> type_with_dt() {
			return getRuleContexts(Type_with_dtContext.class);
		}
		public Type_with_dtContext type_with_dt(int i) {
			return getRuleContext(Type_with_dtContext.class,i);
		}
		public TerminalNode OF() { return getToken(CetusPatternsParser.OF, 0); }
		public TerminalNode COMMA() { return getToken(CetusPatternsParser.COMMA, 0); }
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
		enterRule(_localctx, 6, RULE_is_a_type_of_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(115);
				match(COMMA);
				}
			}

			setState(118);
			match(FORM_OF_BE);
			setState(119);
			type_with_dt();
			setState(120);
			match(OF);
			setState(121);
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
		enterRule(_localctx, 8, RULE_type_in_front_of_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			type_with_dt();
			setState(125);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OF) | (1L << COMMA) | (1L << COLON))) != 0)) {
				{
				setState(124);
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
		enterRule(_localctx, 10, RULE_type_with_dt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if (_la==DETERMINER) {
				{
				setState(127);
				match(DETERMINER);
				}
			}

			setState(131);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(130);
				nr();
				}
			}

			setState(133);
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
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) {
				{
				{
				setState(135);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			_la = _input.LA(1);
			if (_la==FOREIGN) {
				{
				setState(141);
				match(FOREIGN);
				}
			}

			setState(145); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(144);
				match(NOUN);
				}
				}
				setState(147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NOUN );
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
		enterRule(_localctx, 14, RULE_nr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
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
		enterRule(_localctx, 16, RULE_cc_word);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << CC))) != 0)) ) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\24\u009c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2.\n\2\f\2\16\2\61\13\2\5\2\63\n\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\6\2A\n\2\r\2\16\2B\3\2"+
		"\5\2F\n\2\3\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\2\7\2P\n\2\f\2\16\2S\13\2"+
		"\3\2\3\2\3\2\7\2X\n\2\f\2\16\2[\13\2\5\2]\n\2\3\3\3\3\3\3\5\3b\n\3\3\4"+
		"\5\4e\n\4\3\4\3\4\3\4\5\4j\n\4\3\4\3\4\5\4n\n\4\3\4\7\4q\n\4\f\4\16\4"+
		"t\13\4\3\5\5\5w\n\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\5\6\u0080\n\6\3\7\5\7"+
		"\u0083\n\7\3\7\5\7\u0086\n\7\3\7\3\7\3\b\7\b\u008b\n\b\f\b\16\b\u008e"+
		"\13\b\3\b\5\b\u0091\n\b\3\b\6\b\u0094\n\b\r\b\16\b\u0095\3\t\3\t\3\n\3"+
		"\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\6\3\2\20\23\4\2\7\7\21\22\4\2\t\t"+
		"\r\16\3\2\4\6\u00c2\2\\\3\2\2\2\4a\3\2\2\2\6d\3\2\2\2\bv\3\2\2\2\n}\3"+
		"\2\2\2\f\u0082\3\2\2\2\16\u008c\3\2\2\2\20\u0097\3\2\2\2\22\u0099\3\2"+
		"\2\2\24\36\7\23\2\2\25\36\5\22\n\2\26\36\7\7\2\2\27\36\7\t\2\2\30\36\7"+
		"\n\2\2\31\36\7\13\2\2\32\36\7\f\2\2\33\36\7\17\2\2\34\36\7\16\2\2\35\24"+
		"\3\2\2\2\35\25\3\2\2\2\35\26\3\2\2\2\35\27\3\2\2\2\35\30\3\2\2\2\35\31"+
		"\3\2\2\2\35\32\3\2\2\2\35\33\3\2\2\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3"+
		"\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"\62\7\3\2\2#/\5\22\n\2$.\7"+
		"\23\2\2%.\5\22\n\2&.\7\7\2\2\'.\7\t\2\2(.\7\n\2\2).\7\13\2\2*.\7\f\2\2"+
		"+.\7\17\2\2,.\7\16\2\2-$\3\2\2\2-%\3\2\2\2-&\3\2\2\2-\'\3\2\2\2-(\3\2"+
		"\2\2-)\3\2\2\2-*\3\2\2\2-+\3\2\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60"+
		"\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\62#\3\2\2\2\62\63\3\2\2\2\63E\3\2\2"+
		"\2\64@\7\21\2\2\65A\7\23\2\2\66A\5\22\n\2\67A\7\7\2\28A\7\b\2\29A\7\t"+
		"\2\2:A\7\n\2\2;A\7\13\2\2<A\7\f\2\2=A\7\r\2\2>A\7\17\2\2?A\7\16\2\2@\65"+
		"\3\2\2\2@\66\3\2\2\2@\67\3\2\2\2@8\3\2\2\2@9\3\2\2\2@:\3\2\2\2@;\3\2\2"+
		"\2@<\3\2\2\2@=\3\2\2\2@>\3\2\2\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2"+
		"\2CD\3\2\2\2DF\7\21\2\2E\64\3\2\2\2EF\3\2\2\2FG\3\2\2\2GK\5\4\3\2HJ\t"+
		"\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L]\3\2\2\2MK\3\2\2\2NP\7"+
		"\23\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU"+
		"\5\n\6\2UY\7\3\2\2VX\7\23\2\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2"+
		"Z]\3\2\2\2[Y\3\2\2\2\\\37\3\2\2\2\\Q\3\2\2\2]\3\3\2\2\2^b\5\b\5\2_b\5"+
		"\6\4\2`b\5\f\7\2a^\3\2\2\2a_\3\2\2\2a`\3\2\2\2b\5\3\2\2\2ce\7\21\2\2d"+
		"c\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\7\b\2\2gr\5\f\7\2hj\7\21\2\2ih\3\2\2\2"+
		"ij\3\2\2\2jk\3\2\2\2kn\7\4\2\2ln\7\21\2\2mi\3\2\2\2ml\3\2\2\2no\3\2\2"+
		"\2oq\5\f\7\2pm\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\7\3\2\2\2tr\3\2"+
		"\2\2uw\7\21\2\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7\b\2\2yz\5\f\7\2z{\7"+
		"\7\2\2{|\5\f\7\2|\t\3\2\2\2}\177\5\f\7\2~\u0080\t\3\2\2\177~\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080\13\3\2\2\2\u0081\u0083\7\n\2\2\u0082\u0081\3\2\2"+
		"\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0086\5\20\t\2\u0085"+
		"\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\5\16"+
		"\b\2\u0088\r\3\2\2\2\u0089\u008b\t\4\2\2\u008a\u0089\3\2\2\2\u008b\u008e"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008f\u0091\7\17\2\2\u0090\u008f\3\2\2\2\u0090\u0091\3"+
		"\2\2\2\u0091\u0093\3\2\2\2\u0092\u0094\7\f\2\2\u0093\u0092\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\17\3\2\2"+
		"\2\u0097\u0098\7\13\2\2\u0098\21\3\2\2\2\u0099\u009a\t\5\2\2\u009a\23"+
		"\3\2\2\2\32\35\37-/\62@BEKQY\\adimrv\177\u0082\u0085\u008c\u0090\u0095";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}