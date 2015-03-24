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
		ENTITY=1, AND=2, OF=3, FORM_OF_BE=4, ADJECTIVE=5, DETERMINER=6, NUMBER=7, 
		CARDINAL_NUMBER=8, NOUN=9, VERB=10, ADVERB=11, FOREIGN=12, POINT=13, COMMA=14, 
		COLON=15, WORD=16, WHITESPACE=17;
	public static final int
		RULE_sentence = 0, RULE_type_after_entity_pattern = 1, RULE_direct_following_type_pattern = 2, 
		RULE_is_a_pattern = 3, RULE_is_a_type_of_pattern = 4, RULE_type_in_front_of_entity = 5, 
		RULE_type_with_dt = 6, RULE_type = 7, RULE_nr_or_crd = 8;
	public static final String[] ruleNames = {
		"sentence", "type_after_entity_pattern", "direct_following_type_pattern", 
		"is_a_pattern", "is_a_type_of_pattern", "type_in_front_of_entity", "type_with_dt", 
		"type", "nr_or_crd"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'$ENTITY$'", "'and_and_cc'", "'of_of_pp-f'", null, null, null, 
		null, null, null, null, null, null, "'._._.'", "',_,_,'", "':_:_:'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ENTITY", "AND", "OF", "FORM_OF_BE", "ADJECTIVE", "DETERMINER", 
		"NUMBER", "CARDINAL_NUMBER", "NOUN", "VERB", "ADVERB", "FOREIGN", "POINT", 
		"COMMA", "COLON", "WORD", "WHITESPACE"
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
		public List<TerminalNode> AND() { return getTokens(CetusPatternsParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CetusPatternsParser.AND, i);
		}
		public List<TerminalNode> OF() { return getTokens(CetusPatternsParser.OF); }
		public TerminalNode OF(int i) {
			return getToken(CetusPatternsParser.OF, i);
		}
		public List<TerminalNode> FORM_OF_BE() { return getTokens(CetusPatternsParser.FORM_OF_BE); }
		public TerminalNode FORM_OF_BE(int i) {
			return getToken(CetusPatternsParser.FORM_OF_BE, i);
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
		public List<TerminalNode> CARDINAL_NUMBER() { return getTokens(CetusPatternsParser.CARDINAL_NUMBER); }
		public TerminalNode CARDINAL_NUMBER(int i) {
			return getToken(CetusPatternsParser.CARDINAL_NUMBER, i);
		}
		public List<TerminalNode> NOUN() { return getTokens(CetusPatternsParser.NOUN); }
		public TerminalNode NOUN(int i) {
			return getToken(CetusPatternsParser.NOUN, i);
		}
		public List<TerminalNode> VERB() { return getTokens(CetusPatternsParser.VERB); }
		public TerminalNode VERB(int i) {
			return getToken(CetusPatternsParser.VERB, i);
		}
		public List<TerminalNode> FOREIGN() { return getTokens(CetusPatternsParser.FOREIGN); }
		public TerminalNode FOREIGN(int i) {
			return getToken(CetusPatternsParser.FOREIGN, i);
		}
		public List<TerminalNode> ADVERB() { return getTokens(CetusPatternsParser.ADVERB); }
		public TerminalNode ADVERB(int i) {
			return getToken(CetusPatternsParser.ADVERB, i);
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
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(18);
					match(WORD);
					}
					}
					setState(23);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(24);
				match(ENTITY);
				setState(32);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(25);
					match(COMMA);
					setState(27); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(26);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << CARDINAL_NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						}
						setState(29); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << CARDINAL_NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0) );
					setState(31);
					match(COMMA);
					}
				}

				setState(34);
				type_after_entity_pattern();
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << POINT) | (1L << COMMA) | (1L << COLON) | (1L << WORD))) != 0)) {
					{
					{
					setState(35);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << POINT) | (1L << COMMA) | (1L << COLON) | (1L << WORD))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(41);
					match(WORD);
					}
					}
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(47);
				type_in_front_of_entity();
				setState(48);
				match(ENTITY);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(49);
					match(WORD);
					}
					}
					setState(54);
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
		public Direct_following_type_patternContext direct_following_type_pattern() {
			return getRuleContext(Direct_following_type_patternContext.class,0);
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
			setState(60);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				is_a_type_of_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				is_a_pattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				direct_following_type_pattern();
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

	public static class Direct_following_type_patternContext extends ParserRuleContext {
		public Type_with_dtContext type_with_dt() {
			return getRuleContext(Type_with_dtContext.class,0);
		}
		public Direct_following_type_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_direct_following_type_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitDirect_following_type_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Direct_following_type_patternContext direct_following_type_pattern() throws RecognitionException {
		Direct_following_type_patternContext _localctx = new Direct_following_type_patternContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_direct_following_type_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
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
		enterRule(_localctx, 6, RULE_is_a_pattern);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(FORM_OF_BE);
			setState(65);
			type_with_dt();
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(71);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						{
						setState(67);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(66);
							match(COMMA);
							}
						}

						setState(69);
						match(AND);
						}
						}
						break;
					case 2:
						{
						setState(70);
						match(COMMA);
						}
						break;
					}
					setState(73);
					type_with_dt();
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(FORM_OF_BE);
			setState(80);
			type_with_dt();
			setState(81);
			match(OF);
			setState(82);
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
		enterRule(_localctx, 10, RULE_type_in_front_of_entity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			type_with_dt();
			setState(86);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OF) | (1L << COMMA) | (1L << COLON))) != 0)) {
				{
				setState(85);
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
		public Nr_or_crdContext nr_or_crd() {
			return getRuleContext(Nr_or_crdContext.class,0);
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
		enterRule(_localctx, 12, RULE_type_with_dt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if (_la==DETERMINER) {
				{
				setState(88);
				match(DETERMINER);
				}
			}

			setState(92);
			_la = _input.LA(1);
			if (_la==NUMBER || _la==CARDINAL_NUMBER) {
				{
				setState(91);
				nr_or_crd();
				}
			}

			setState(94);
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
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) {
				{
				{
				setState(96);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			_la = _input.LA(1);
			if (_la==FOREIGN) {
				{
				setState(102);
				match(FOREIGN);
				}
			}

			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(105);
				match(NOUN);
				}
				}
				setState(108); 
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

	public static class Nr_or_crdContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(CetusPatternsParser.NUMBER, 0); }
		public TerminalNode CARDINAL_NUMBER() { return getToken(CetusPatternsParser.CARDINAL_NUMBER, 0); }
		public Nr_or_crdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nr_or_crd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CetusPatternsVisitor ) return ((CetusPatternsVisitor<? extends T>)visitor).visitNr_or_crd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nr_or_crdContext nr_or_crd() throws RecognitionException {
		Nr_or_crdContext _localctx = new Nr_or_crdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_nr_or_crd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==CARDINAL_NUMBER) ) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23s\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\3\2\3\2\6\2\36\n\2\r\2\16\2\37\3\2\5\2#\n\2"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\7\2-\n\2\f\2\16\2\60\13\2\3\2\3"+
		"\2\3\2\7\2\65\n\2\f\2\16\28\13\2\5\2:\n\2\3\3\3\3\3\3\5\3?\n\3\3\4\3\4"+
		"\3\5\3\5\3\5\5\5F\n\5\3\5\3\5\5\5J\n\5\3\5\7\5M\n\5\f\5\16\5P\13\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\5\7Y\n\7\3\b\5\b\\\n\b\3\b\5\b_\n\b\3\b\3\b\3"+
		"\t\7\td\n\t\f\t\16\tg\13\t\3\t\5\tj\n\t\3\t\6\tm\n\t\r\t\16\tn\3\n\3\n"+
		"\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\7\4\2\4\16\22\22\3\2\17\22\4\2\5\5"+
		"\20\21\4\2\7\7\f\r\3\2\t\n{\29\3\2\2\2\4>\3\2\2\2\6@\3\2\2\2\bB\3\2\2"+
		"\2\nQ\3\2\2\2\fV\3\2\2\2\16[\3\2\2\2\20e\3\2\2\2\22p\3\2\2\2\24\26\7\22"+
		"\2\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2"+
		"\2\2\31\27\3\2\2\2\32\"\7\3\2\2\33\35\7\20\2\2\34\36\t\2\2\2\35\34\3\2"+
		"\2\2\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!#\7\20\2\2\"\33"+
		"\3\2\2\2\"#\3\2\2\2#$\3\2\2\2$(\5\4\3\2%\'\t\3\2\2&%\3\2\2\2\'*\3\2\2"+
		"\2(&\3\2\2\2()\3\2\2\2):\3\2\2\2*(\3\2\2\2+-\7\22\2\2,+\3\2\2\2-\60\3"+
		"\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\5\f\7\2\62\66"+
		"\7\3\2\2\63\65\7\22\2\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67"+
		"\3\2\2\2\67:\3\2\2\28\66\3\2\2\29\27\3\2\2\29.\3\2\2\2:\3\3\2\2\2;?\5"+
		"\n\6\2<?\5\b\5\2=?\5\6\4\2>;\3\2\2\2><\3\2\2\2>=\3\2\2\2?\5\3\2\2\2@A"+
		"\5\16\b\2A\7\3\2\2\2BC\7\6\2\2CN\5\16\b\2DF\7\20\2\2ED\3\2\2\2EF\3\2\2"+
		"\2FG\3\2\2\2GJ\7\4\2\2HJ\7\20\2\2IE\3\2\2\2IH\3\2\2\2JK\3\2\2\2KM\5\16"+
		"\b\2LI\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\t\3\2\2\2PN\3\2\2\2QR\7"+
		"\6\2\2RS\5\16\b\2ST\7\5\2\2TU\5\16\b\2U\13\3\2\2\2VX\5\16\b\2WY\t\4\2"+
		"\2XW\3\2\2\2XY\3\2\2\2Y\r\3\2\2\2Z\\\7\b\2\2[Z\3\2\2\2[\\\3\2\2\2\\^\3"+
		"\2\2\2]_\5\22\n\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\5\20\t\2a\17\3\2\2\2"+
		"bd\t\5\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fi\3\2\2\2ge\3\2\2\2"+
		"hj\7\16\2\2ih\3\2\2\2ij\3\2\2\2jl\3\2\2\2km\7\13\2\2lk\3\2\2\2mn\3\2\2"+
		"\2nl\3\2\2\2no\3\2\2\2o\21\3\2\2\2pq\t\6\2\2q\23\3\2\2\2\23\27\37\"(."+
		"\669>EINX[^ein";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}