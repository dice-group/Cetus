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
		NOUN=8, VERB=9, ADVERB=10, FOREIGN=11, POINT=12, COMMA=13, COLON=14, WORD=15, 
		WHITESPACE=16;
	public static final int
		RULE_sentence = 0, RULE_type_after_entity_pattern = 1, RULE_is_a_pattern = 2, 
		RULE_is_a_type_of_pattern = 3, RULE_type_in_front_of_entity = 4, RULE_type_with_dt = 5, 
		RULE_type = 6, RULE_nr = 7;
	public static final String[] ruleNames = {
		"sentence", "type_after_entity_pattern", "is_a_pattern", "is_a_type_of_pattern", 
		"type_in_front_of_entity", "type_with_dt", "type", "nr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'$ENTITY$'", "'and_and_CC'", "'of_of_IN'", null, null, null, null, 
		null, null, null, null, "'._._.'", "',_,_,'", "':_:_:'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ENTITY", "AND", "OF", "FORM_OF_BE", "ADJECTIVE", "DETERMINER", 
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
			setState(53);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(16);
					match(WORD);
					}
					}
					setState(21);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(22);
				match(ENTITY);
				setState(30);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(23);
					match(COMMA);
					setState(25); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(24);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						}
						setState(27); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OF) | (1L << FORM_OF_BE) | (1L << ADJECTIVE) | (1L << DETERMINER) | (1L << NUMBER) | (1L << NOUN) | (1L << VERB) | (1L << ADVERB) | (1L << FOREIGN) | (1L << WORD))) != 0) );
					setState(29);
					match(COMMA);
					}
					break;
				}
				setState(32);
				type_after_entity_pattern();
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << POINT) | (1L << COMMA) | (1L << COLON) | (1L << WORD))) != 0)) {
					{
					{
					setState(33);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << POINT) | (1L << COMMA) | (1L << COLON) | (1L << WORD))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(38);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(39);
					match(WORD);
					}
					}
					setState(44);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(45);
				type_in_front_of_entity();
				setState(46);
				match(ENTITY);
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(47);
					match(WORD);
					}
					}
					setState(52);
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
			setState(58);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				is_a_type_of_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				is_a_pattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
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
			setState(61);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(60);
				match(COMMA);
				}
			}

			setState(63);
			match(FORM_OF_BE);
			setState(64);
			type_with_dt();
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(70);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						{
						setState(66);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(65);
							match(COMMA);
							}
						}

						setState(68);
						match(AND);
						}
						}
						break;
					case 2:
						{
						setState(69);
						match(COMMA);
						}
						break;
					}
					setState(72);
					type_with_dt();
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
			setState(79);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(78);
				match(COMMA);
				}
			}

			setState(81);
			match(FORM_OF_BE);
			setState(82);
			type_with_dt();
			setState(83);
			match(OF);
			setState(84);
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
			setState(86);
			type_with_dt();
			setState(88);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OF) | (1L << COMMA) | (1L << COLON))) != 0)) {
				{
				setState(87);
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
			setState(91);
			_la = _input.LA(1);
			if (_la==DETERMINER) {
				{
				setState(90);
				match(DETERMINER);
				}
			}

			setState(94);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(93);
				nr();
				}
			}

			setState(96);
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
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) {
				{
				{
				setState(98);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADJECTIVE) | (1L << VERB) | (1L << ADVERB))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
			_la = _input.LA(1);
			if (_la==FOREIGN) {
				{
				setState(104);
				match(FOREIGN);
				}
			}

			setState(108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(107);
				match(NOUN);
				}
				}
				setState(110); 
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
			setState(112);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\22u\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\3\2\3\2\6\2\34\n\2\r\2\16\2\35\3\2\5\2!\n\2\3\2\3\2"+
		"\7\2%\n\2\f\2\16\2(\13\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\3\2\3\2\7\2\63"+
		"\n\2\f\2\16\2\66\13\2\5\28\n\2\3\3\3\3\3\3\5\3=\n\3\3\4\5\4@\n\4\3\4\3"+
		"\4\3\4\5\4E\n\4\3\4\3\4\5\4I\n\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\5\5\5R"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\5\6[\n\6\3\7\5\7^\n\7\3\7\5\7a\n\7\3"+
		"\7\3\7\3\b\7\bf\n\b\f\b\16\bi\13\b\3\b\5\bl\n\b\3\b\6\bo\n\b\r\b\16\b"+
		"p\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\6\4\2\4\r\21\21\3\2\16\21\4\2"+
		"\5\5\17\20\4\2\7\7\13\f\u0080\2\67\3\2\2\2\4<\3\2\2\2\6?\3\2\2\2\bQ\3"+
		"\2\2\2\nX\3\2\2\2\f]\3\2\2\2\16g\3\2\2\2\20r\3\2\2\2\22\24\7\21\2\2\23"+
		"\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27"+
		"\25\3\2\2\2\30 \7\3\2\2\31\33\7\17\2\2\32\34\t\2\2\2\33\32\3\2\2\2\34"+
		"\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\37\3\2\2\2\37!\7\17\2\2 \31"+
		"\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"&\5\4\3\2#%\t\3\2\2$#\3\2\2\2%(\3\2\2\2"+
		"&$\3\2\2\2&\'\3\2\2\2\'8\3\2\2\2(&\3\2\2\2)+\7\21\2\2*)\3\2\2\2+.\3\2"+
		"\2\2,*\3\2\2\2,-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\5\n\6\2\60\64\7\3\2\2"+
		"\61\63\7\21\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2"+
		"\2\658\3\2\2\2\66\64\3\2\2\2\67\25\3\2\2\2\67,\3\2\2\28\3\3\2\2\29=\5"+
		"\b\5\2:=\5\6\4\2;=\5\f\7\2<9\3\2\2\2<:\3\2\2\2<;\3\2\2\2=\5\3\2\2\2>@"+
		"\7\17\2\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\6\2\2BM\5\f\7\2CE\7\17\2\2"+
		"DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2FI\7\4\2\2GI\7\17\2\2HD\3\2\2\2HG\3\2\2"+
		"\2IJ\3\2\2\2JL\5\f\7\2KH\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\7\3\2"+
		"\2\2OM\3\2\2\2PR\7\17\2\2QP\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7\6\2\2TU\5"+
		"\f\7\2UV\7\5\2\2VW\5\f\7\2W\t\3\2\2\2XZ\5\f\7\2Y[\t\4\2\2ZY\3\2\2\2Z["+
		"\3\2\2\2[\13\3\2\2\2\\^\7\b\2\2]\\\3\2\2\2]^\3\2\2\2^`\3\2\2\2_a\5\20"+
		"\t\2`_\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc\5\16\b\2c\r\3\2\2\2df\t\5\2\2ed\3"+
		"\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hk\3\2\2\2ig\3\2\2\2jl\7\r\2\2kj\3"+
		"\2\2\2kl\3\2\2\2ln\3\2\2\2mo\7\n\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3"+
		"\2\2\2q\17\3\2\2\2rs\7\t\2\2s\21\3\2\2\2\25\25\35 &,\64\67<?DHMQZ]`gk"+
		"p";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}