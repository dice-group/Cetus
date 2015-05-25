// Generated from CetusPatterns.g4 by ANTLR 4.5
package org.aksw.simba.cetus.parser.antlr4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CetusPatternsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ENTITY=1, AND=2, OF=3, FORM_OF_BE=4, ADJECTIVE=5, DETERMINER=6, NUMBER=7, 
		NOUN=8, VERB=9, ADVERB=10, FOREIGN=11, POINT=12, COMMA=13, COLON=14, WORD=15, 
		WHITESPACE=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ENTITY", "AND", "OF", "FORM_OF_BE", "ADJECTIVE", "DETERMINER", "NUMBER", 
		"NOUN", "VERB", "ADVERB", "FOREIGN", "POINT", "COMMA", "COLON", "WORD", 
		"WHITESPACE"
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


	public CetusPatternsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CetusPatterns.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22\u0100\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\6\5B\n\5\r\5\16\5C\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5N\n\5\3\6\6\6Q\n\6\r\6\16\6R\3\6\3\6\6\6"+
		"W\n\6\r\6\16\6X\3\6\3\6\3\6\3\6\3\6\5\6`\n\6\3\7\6\7c\n\7\r\7\16\7d\3"+
		"\7\3\7\6\7i\n\7\r\7\16\7j\3\7\3\7\3\7\3\7\3\b\6\br\n\b\r\b\16\bs\3\b\3"+
		"\b\6\bx\n\b\r\b\16\by\3\b\3\b\3\b\3\b\3\t\6\t\u0081\n\t\r\t\16\t\u0082"+
		"\3\t\3\t\6\t\u0087\n\t\r\t\16\t\u0088\3\t\3\t\3\t\3\t\3\t\7\t\u0090\n"+
		"\t\f\t\16\t\u0093\13\t\3\n\6\n\u0096\n\n\r\n\16\n\u0097\3\n\3\n\6\n\u009c"+
		"\n\n\r\n\16\n\u009d\3\n\3\n\3\n\3\n\3\n\5\n\u00a5\n\n\3\13\6\13\u00a8"+
		"\n\13\r\13\16\13\u00a9\3\13\3\13\6\13\u00ae\n\13\r\13\16\13\u00af\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00b7\n\13\3\f\6\f\u00ba\n\f\r\f\16\f\u00bb"+
		"\3\f\3\f\6\f\u00c0\n\f\r\f\16\f\u00c1\3\f\3\f\3\f\3\f\6\f\u00c8\n\f\r"+
		"\f\16\f\u00c9\3\f\3\f\6\f\u00ce\n\f\r\f\16\f\u00cf\3\f\3\f\3\f\5\f\u00d5"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\6\20\u00ea\n\20\r\20\16\20\u00eb\3\20\3\20\6\20"+
		"\u00f0\n\20\r\20\16\20\u00f1\3\20\3\20\6\20\u00f6\n\20\r\20\16\20\u00f7"+
		"\3\21\6\21\u00fb\n\21\r\21\16\21\u00fc\3\21\3\21\2\2\22\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22\3\2"+
		"\4\5\2\13\f\17\17\"\"\3\2TU\u011a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5,\3\2\2\2\7\67\3\2\2\2\tA\3\2\2"+
		"\2\13P\3\2\2\2\rb\3\2\2\2\17q\3\2\2\2\21\u0080\3\2\2\2\23\u0095\3\2\2"+
		"\2\25\u00a7\3\2\2\2\27\u00d4\3\2\2\2\31\u00d6\3\2\2\2\33\u00dc\3\2\2\2"+
		"\35\u00e2\3\2\2\2\37\u00e9\3\2\2\2!\u00fa\3\2\2\2#$\7&\2\2$%\7G\2\2%&"+
		"\7P\2\2&\'\7V\2\2\'(\7K\2\2()\7V\2\2)*\7[\2\2*+\7&\2\2+\4\3\2\2\2,-\7"+
		"c\2\2-.\7p\2\2./\7f\2\2/\60\7a\2\2\60\61\7c\2\2\61\62\7p\2\2\62\63\7f"+
		"\2\2\63\64\7a\2\2\64\65\7E\2\2\65\66\7E\2\2\66\6\3\2\2\2\678\7q\2\289"+
		"\7h\2\29:\7a\2\2:;\7q\2\2;<\7h\2\2<=\7a\2\2=>\7K\2\2>?\7P\2\2?\b\3\2\2"+
		"\2@B\n\2\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\7a\2"+
		"\2FG\7d\2\2GH\7g\2\2HI\7a\2\2IJ\7X\2\2JK\7D\2\2KM\3\2\2\2LN\n\2\2\2ML"+
		"\3\2\2\2MN\3\2\2\2N\n\3\2\2\2OQ\n\2\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2"+
		"RS\3\2\2\2ST\3\2\2\2TV\7a\2\2UW\n\2\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2"+
		"XY\3\2\2\2YZ\3\2\2\2Z[\7a\2\2[\\\7L\2\2\\]\7L\2\2]_\3\2\2\2^`\t\3\2\2"+
		"_^\3\2\2\2_`\3\2\2\2`\f\3\2\2\2ac\n\2\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2"+
		"\2de\3\2\2\2ef\3\2\2\2fh\7a\2\2gi\n\2\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2"+
		"\2jk\3\2\2\2kl\3\2\2\2lm\7a\2\2mn\7F\2\2no\7V\2\2o\16\3\2\2\2pr\n\2\2"+
		"\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2uw\7a\2\2vx\n\2\2"+
		"\2wv\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7a\2\2|}\7E\2\2"+
		"}~\7F\2\2~\20\3\2\2\2\177\u0081\n\2\2\2\u0080\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0086\7a\2\2\u0085\u0087\n\2\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\7a\2\2\u008b\u008c\7P\2\2\u008c\u008d\7P\2\2\u008d\u0091\3\2\2"+
		"\2\u008e\u0090\n\2\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\22\3\2\2\2\u0093\u0091\3\2\2\2\u0094"+
		"\u0096\n\2\2\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\7a\2\2\u009a"+
		"\u009c\n\2\2\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\7a\2\2\u00a0"+
		"\u00a1\7X\2\2\u00a1\u00a2\7D\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a5\n\2\2"+
		"\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\24\3\2\2\2\u00a6\u00a8"+
		"\n\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\7a\2\2\u00ac\u00ae\n\2"+
		"\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7a\2\2\u00b2\u00b3\7T\2"+
		"\2\u00b3\u00b4\7D\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b7\n\2\2\2\u00b6\u00b5"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\26\3\2\2\2\u00b8\u00ba\n\2\2\2\u00b9"+
		"\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\7a\2\2\u00be\u00c0\n\2\2\2\u00bf"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7a\2\2\u00c4\u00c5\7H\2\2\u00c5\u00d5"+
		"\7Y\2\2\u00c6\u00c8\n\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\7a"+
		"\2\2\u00cc\u00ce\n\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\7a"+
		"\2\2\u00d2\u00d3\7H\2\2\u00d3\u00d5\7Y\2\2\u00d4\u00b9\3\2\2\2\u00d4\u00c7"+
		"\3\2\2\2\u00d5\30\3\2\2\2\u00d6\u00d7\7\60\2\2\u00d7\u00d8\7a\2\2\u00d8"+
		"\u00d9\7\60\2\2\u00d9\u00da\7a\2\2\u00da\u00db\7\60\2\2\u00db\32\3\2\2"+
		"\2\u00dc\u00dd\7.\2\2\u00dd\u00de\7a\2\2\u00de\u00df\7.\2\2\u00df\u00e0"+
		"\7a\2\2\u00e0\u00e1\7.\2\2\u00e1\34\3\2\2\2\u00e2\u00e3\7<\2\2\u00e3\u00e4"+
		"\7a\2\2\u00e4\u00e5\7<\2\2\u00e5\u00e6\7a\2\2\u00e6\u00e7\7<\2\2\u00e7"+
		"\36\3\2\2\2\u00e8\u00ea\n\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2"+
		"\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef"+
		"\7a\2\2\u00ee\u00f0\n\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f5\7a"+
		"\2\2\u00f4\u00f6\n\2\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8 \3\2\2\2\u00f9\u00fb\t\2\2\2"+
		"\u00fa\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\b\21\2\2\u00ff\"\3\2\2\2\36\2"+
		"CMRX_djsy\u0082\u0088\u0091\u0097\u009d\u00a4\u00a9\u00af\u00b6\u00bb"+
		"\u00c1\u00c9\u00cf\u00d4\u00eb\u00f1\u00f7\u00fc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}