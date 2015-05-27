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
		ENTITY=1, AND=2, OR=3, CC=4, OF=5, FORM_OF_BE=6, ADJECTIVE=7, DETERMINER=8, 
		NUMBER=9, NOUN=10, VERB=11, ADVERB=12, FOREIGN=13, POINT=14, COMMA=15, 
		COLON=16, WORD=17, WHITESPACE=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ENTITY", "AND", "OR", "CC", "OF", "FORM_OF_BE", "ADJECTIVE", "DETERMINER", 
		"NUMBER", "NOUN", "VERB", "ADVERB", "FOREIGN", "POINT", "COMMA", "COLON", 
		"WORD", "WHITESPACE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u011c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\6\5"+
		"F\n\5\r\5\16\5G\3\5\3\5\6\5L\n\5\r\5\16\5M\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\6\7^\n\7\r\7\16\7_\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7j\n\7\3\b\6\bm\n\b\r\b\16\bn\3\b\3\b\6\bs\n\b\r\b\16\bt"+
		"\3\b\3\b\3\b\3\b\3\b\5\b|\n\b\3\t\6\t\177\n\t\r\t\16\t\u0080\3\t\3\t\6"+
		"\t\u0085\n\t\r\t\16\t\u0086\3\t\3\t\3\t\3\t\3\n\6\n\u008e\n\n\r\n\16\n"+
		"\u008f\3\n\3\n\6\n\u0094\n\n\r\n\16\n\u0095\3\n\3\n\3\n\3\n\3\13\6\13"+
		"\u009d\n\13\r\13\16\13\u009e\3\13\3\13\6\13\u00a3\n\13\r\13\16\13\u00a4"+
		"\3\13\3\13\3\13\3\13\3\13\7\13\u00ac\n\13\f\13\16\13\u00af\13\13\3\f\6"+
		"\f\u00b2\n\f\r\f\16\f\u00b3\3\f\3\f\6\f\u00b8\n\f\r\f\16\f\u00b9\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u00c1\n\f\3\r\6\r\u00c4\n\r\r\r\16\r\u00c5\3\r\3\r"+
		"\6\r\u00ca\n\r\r\r\16\r\u00cb\3\r\3\r\3\r\3\r\3\r\5\r\u00d3\n\r\3\16\6"+
		"\16\u00d6\n\16\r\16\16\16\u00d7\3\16\3\16\6\16\u00dc\n\16\r\16\16\16\u00dd"+
		"\3\16\3\16\3\16\3\16\6\16\u00e4\n\16\r\16\16\16\u00e5\3\16\3\16\6\16\u00ea"+
		"\n\16\r\16\16\16\u00eb\3\16\3\16\3\16\5\16\u00f1\n\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\6\22\u0106\n\22\r\22\16\22\u0107\3\22\3\22\6\22\u010c\n\22\r"+
		"\22\16\22\u010d\3\22\3\22\6\22\u0112\n\22\r\22\16\22\u0113\3\23\6\23\u0117"+
		"\n\23\r\23\16\23\u0118\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\4\5\2\13"+
		"\f\17\17\"\"\3\2TU\u0138\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5\60\3\2\2\2\7;\3\2"+
		"\2\2\tE\3\2\2\2\13S\3\2\2\2\r]\3\2\2\2\17l\3\2\2\2\21~\3\2\2\2\23\u008d"+
		"\3\2\2\2\25\u009c\3\2\2\2\27\u00b1\3\2\2\2\31\u00c3\3\2\2\2\33\u00f0\3"+
		"\2\2\2\35\u00f2\3\2\2\2\37\u00f8\3\2\2\2!\u00fe\3\2\2\2#\u0105\3\2\2\2"+
		"%\u0116\3\2\2\2\'(\7&\2\2()\7G\2\2)*\7P\2\2*+\7V\2\2+,\7K\2\2,-\7V\2\2"+
		"-.\7[\2\2./\7&\2\2/\4\3\2\2\2\60\61\7c\2\2\61\62\7p\2\2\62\63\7f\2\2\63"+
		"\64\7a\2\2\64\65\7c\2\2\65\66\7p\2\2\66\67\7f\2\2\678\7a\2\289\7E\2\2"+
		"9:\7E\2\2:\6\3\2\2\2;<\7q\2\2<=\7t\2\2=>\7a\2\2>?\7q\2\2?@\7t\2\2@A\7"+
		"a\2\2AB\7E\2\2BC\7E\2\2C\b\3\2\2\2DF\n\2\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2"+
		"\2\2GH\3\2\2\2HI\3\2\2\2IK\7a\2\2JL\n\2\2\2KJ\3\2\2\2LM\3\2\2\2MK\3\2"+
		"\2\2MN\3\2\2\2NO\3\2\2\2OP\7a\2\2PQ\7E\2\2QR\7E\2\2R\n\3\2\2\2ST\7q\2"+
		"\2TU\7h\2\2UV\7a\2\2VW\7q\2\2WX\7h\2\2XY\7a\2\2YZ\7K\2\2Z[\7P\2\2[\f\3"+
		"\2\2\2\\^\n\2\2\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`a\3\2\2\2a"+
		"b\7a\2\2bc\7d\2\2cd\7g\2\2de\7a\2\2ef\7X\2\2fg\7D\2\2gi\3\2\2\2hj\n\2"+
		"\2\2ih\3\2\2\2ij\3\2\2\2j\16\3\2\2\2km\n\2\2\2lk\3\2\2\2mn\3\2\2\2nl\3"+
		"\2\2\2no\3\2\2\2op\3\2\2\2pr\7a\2\2qs\n\2\2\2rq\3\2\2\2st\3\2\2\2tr\3"+
		"\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7a\2\2wx\7L\2\2xy\7L\2\2y{\3\2\2\2z|\t\3"+
		"\2\2{z\3\2\2\2{|\3\2\2\2|\20\3\2\2\2}\177\n\2\2\2~}\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0084\7a\2\2\u0083\u0085\n\2\2\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0089\7a\2\2\u0089\u008a\7F\2\2\u008a\u008b\7V\2\2\u008b\22\3\2\2\2\u008c"+
		"\u008e\n\2\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\7a\2\2\u0092"+
		"\u0094\n\2\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\7a\2\2\u0098"+
		"\u0099\7E\2\2\u0099\u009a\7F\2\2\u009a\24\3\2\2\2\u009b\u009d\n\2\2\2"+
		"\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\7a\2\2\u00a1\u00a3\n\2\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7a\2\2\u00a7\u00a8\7P\2\2\u00a8\u00a9"+
		"\7P\2\2\u00a9\u00ad\3\2\2\2\u00aa\u00ac\n\2\2\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\26\3\2\2"+
		"\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\n\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3"+
		"\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b7\7a\2\2\u00b6\u00b8\n\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00bc\7a\2\2\u00bc\u00bd\7X\2\2\u00bd\u00be\7D\2\2\u00be\u00c0\3\2\2"+
		"\2\u00bf\u00c1\n\2\2\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\30"+
		"\3\2\2\2\u00c2\u00c4\n\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\7a"+
		"\2\2\u00c8\u00ca\n\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\7a"+
		"\2\2\u00ce\u00cf\7T\2\2\u00cf\u00d0\7D\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00d3"+
		"\n\2\2\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\32\3\2\2\2\u00d4"+
		"\u00d6\n\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\7a\2\2\u00da"+
		"\u00dc\n\2\2\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2"+
		"\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\7a\2\2\u00e0"+
		"\u00e1\7H\2\2\u00e1\u00f1\7Y\2\2\u00e2\u00e4\n\2\2\2\u00e3\u00e2\3\2\2"+
		"\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7"+
		"\3\2\2\2\u00e7\u00e9\7a\2\2\u00e8\u00ea\n\2\2\2\u00e9\u00e8\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\u00ee\7a\2\2\u00ee\u00ef\7H\2\2\u00ef\u00f1\7Y\2\2\u00f0\u00d5"+
		"\3\2\2\2\u00f0\u00e3\3\2\2\2\u00f1\34\3\2\2\2\u00f2\u00f3\7\60\2\2\u00f3"+
		"\u00f4\7a\2\2\u00f4\u00f5\7\60\2\2\u00f5\u00f6\7a\2\2\u00f6\u00f7\7\60"+
		"\2\2\u00f7\36\3\2\2\2\u00f8\u00f9\7.\2\2\u00f9\u00fa\7a\2\2\u00fa\u00fb"+
		"\7.\2\2\u00fb\u00fc\7a\2\2\u00fc\u00fd\7.\2\2\u00fd \3\2\2\2\u00fe\u00ff"+
		"\7<\2\2\u00ff\u0100\7a\2\2\u0100\u0101\7<\2\2\u0101\u0102\7a\2\2\u0102"+
		"\u0103\7<\2\2\u0103\"\3\2\2\2\u0104\u0106\n\2\2\2\u0105\u0104\3\2\2\2"+
		"\u0106\u0107\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109"+
		"\3\2\2\2\u0109\u010b\7a\2\2\u010a\u010c\n\2\2\2\u010b\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2"+
		"\2\2\u010f\u0111\7a\2\2\u0110\u0112\n\2\2\2\u0111\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114$\3\2\2\2"+
		"\u0115\u0117\t\2\2\2\u0116\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0116"+
		"\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\b\23\2\2"+
		"\u011b&\3\2\2\2 \2GM_int{\u0080\u0086\u008f\u0095\u009e\u00a4\u00ad\u00b3"+
		"\u00b9\u00c0\u00c5\u00cb\u00d2\u00d7\u00dd\u00e5\u00eb\u00f0\u0107\u010d"+
		"\u0113\u0118\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}