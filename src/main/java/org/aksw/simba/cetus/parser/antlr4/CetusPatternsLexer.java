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
		ENTITY=1, AND=2, OR=3, BOTH=4, CC=5, OF=6, FORM_OF_BE=7, ADJECTIVE=8, 
		DETERMINER=9, NUMBER=10, NOUN=11, VERB=12, ADVERB=13, FOREIGN=14, POINT=15, 
		COMMA=16, COLON=17, WORD=18, WHITESPACE=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ENTITY", "AND", "OR", "BOTH", "CC", "OF", "FORM_OF_BE", "ADJECTIVE", 
		"DETERMINER", "NUMBER", "NOUN", "VERB", "ADVERB", "FOREIGN", "POINT", 
		"COMMA", "COLON", "WORD", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'$ENTITY$'", "'and_and_CC'", "'or_or_CC'", "'both_both_CC'", null, 
		"'of_of_IN'", null, null, null, null, null, null, null, null, "'._._.'", 
		"',_,_,'", "':_:_:'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ENTITY", "AND", "OR", "BOTH", "CC", "OF", "FORM_OF_BE", "ADJECTIVE", 
		"DETERMINER", "NUMBER", "NOUN", "VERB", "ADVERB", "FOREIGN", "POINT", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u012b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\6\6U\n\6\r"+
		"\6\16\6V\3\6\3\6\6\6[\n\6\r\6\16\6\\\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\6\bm\n\b\r\b\16\bn\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\by\n\b\3\t\6\t|\n\t\r\t\16\t}\3\t\3\t\6\t\u0082\n\t\r\t\16\t\u0083"+
		"\3\t\3\t\3\t\3\t\3\t\5\t\u008b\n\t\3\n\6\n\u008e\n\n\r\n\16\n\u008f\3"+
		"\n\3\n\6\n\u0094\n\n\r\n\16\n\u0095\3\n\3\n\3\n\3\n\3\13\6\13\u009d\n"+
		"\13\r\13\16\13\u009e\3\13\3\13\6\13\u00a3\n\13\r\13\16\13\u00a4\3\13\3"+
		"\13\3\13\3\13\3\f\6\f\u00ac\n\f\r\f\16\f\u00ad\3\f\3\f\6\f\u00b2\n\f\r"+
		"\f\16\f\u00b3\3\f\3\f\3\f\3\f\3\f\7\f\u00bb\n\f\f\f\16\f\u00be\13\f\3"+
		"\r\6\r\u00c1\n\r\r\r\16\r\u00c2\3\r\3\r\6\r\u00c7\n\r\r\r\16\r\u00c8\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u00d0\n\r\3\16\6\16\u00d3\n\16\r\16\16\16\u00d4"+
		"\3\16\3\16\6\16\u00d9\n\16\r\16\16\16\u00da\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u00e2\n\16\3\17\6\17\u00e5\n\17\r\17\16\17\u00e6\3\17\3\17\6\17\u00eb"+
		"\n\17\r\17\16\17\u00ec\3\17\3\17\3\17\3\17\6\17\u00f3\n\17\r\17\16\17"+
		"\u00f4\3\17\3\17\6\17\u00f9\n\17\r\17\16\17\u00fa\3\17\3\17\3\17\5\17"+
		"\u0100\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\6\23\u0115\n\23\r\23\16\23\u0116\3"+
		"\23\3\23\6\23\u011b\n\23\r\23\16\23\u011c\3\23\3\23\6\23\u0121\n\23\r"+
		"\23\16\23\u0122\3\24\6\24\u0126\n\24\r\24\16\24\u0127\3\24\3\24\2\2\25"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25\3\2\4\5\2\13\f\17\17\"\"\3\2TU\u0147\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\3)\3\2\2\2\5\62\3\2\2\2\7=\3\2\2\2\tF\3\2\2\2\13T\3\2"+
		"\2\2\rb\3\2\2\2\17l\3\2\2\2\21{\3\2\2\2\23\u008d\3\2\2\2\25\u009c\3\2"+
		"\2\2\27\u00ab\3\2\2\2\31\u00c0\3\2\2\2\33\u00d2\3\2\2\2\35\u00ff\3\2\2"+
		"\2\37\u0101\3\2\2\2!\u0107\3\2\2\2#\u010d\3\2\2\2%\u0114\3\2\2\2\'\u0125"+
		"\3\2\2\2)*\7&\2\2*+\7G\2\2+,\7P\2\2,-\7V\2\2-.\7K\2\2./\7V\2\2/\60\7["+
		"\2\2\60\61\7&\2\2\61\4\3\2\2\2\62\63\7c\2\2\63\64\7p\2\2\64\65\7f\2\2"+
		"\65\66\7a\2\2\66\67\7c\2\2\678\7p\2\289\7f\2\29:\7a\2\2:;\7E\2\2;<\7E"+
		"\2\2<\6\3\2\2\2=>\7q\2\2>?\7t\2\2?@\7a\2\2@A\7q\2\2AB\7t\2\2BC\7a\2\2"+
		"CD\7E\2\2DE\7E\2\2E\b\3\2\2\2FG\7d\2\2GH\7q\2\2HI\7v\2\2IJ\7j\2\2JK\7"+
		"a\2\2KL\7d\2\2LM\7q\2\2MN\7v\2\2NO\7j\2\2OP\7a\2\2PQ\7E\2\2QR\7E\2\2R"+
		"\n\3\2\2\2SU\n\2\2\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2\2"+
		"XZ\7a\2\2Y[\n\2\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2"+
		"\2^_\7a\2\2_`\7E\2\2`a\7E\2\2a\f\3\2\2\2bc\7q\2\2cd\7h\2\2de\7a\2\2ef"+
		"\7q\2\2fg\7h\2\2gh\7a\2\2hi\7K\2\2ij\7P\2\2j\16\3\2\2\2km\n\2\2\2lk\3"+
		"\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7a\2\2qr\7d\2\2rs\7g"+
		"\2\2st\7a\2\2tu\7X\2\2uv\7D\2\2vx\3\2\2\2wy\n\2\2\2xw\3\2\2\2xy\3\2\2"+
		"\2y\20\3\2\2\2z|\n\2\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\177"+
		"\3\2\2\2\177\u0081\7a\2\2\u0080\u0082\n\2\2\2\u0081\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0086\7a\2\2\u0086\u0087\7L\2\2\u0087\u0088\7L\2\2\u0088\u008a"+
		"\3\2\2\2\u0089\u008b\t\3\2\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\22\3\2\2\2\u008c\u008e\n\2\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2"+
		"\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093"+
		"\7a\2\2\u0092\u0094\n\2\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\7a"+
		"\2\2\u0098\u0099\7F\2\2\u0099\u009a\7V\2\2\u009a\24\3\2\2\2\u009b\u009d"+
		"\n\2\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\7a\2\2\u00a1\u00a3\n\2"+
		"\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7a\2\2\u00a7\u00a8\7E\2"+
		"\2\u00a8\u00a9\7F\2\2\u00a9\26\3\2\2\2\u00aa\u00ac\n\2\2\2\u00ab\u00aa"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b1\7a\2\2\u00b0\u00b2\n\2\2\2\u00b1\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b6\7a\2\2\u00b6\u00b7\7P\2\2\u00b7\u00b8\7P\2"+
		"\2\u00b8\u00bc\3\2\2\2\u00b9\u00bb\n\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\30\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00bf\u00c1\n\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c6\7a\2\2\u00c5\u00c7\n\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cb\7a\2\2\u00cb\u00cc\7X\2\2\u00cc\u00cd\7D\2\2\u00cd\u00cf\3\2\2"+
		"\2\u00ce\u00d0\n\2\2\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\32"+
		"\3\2\2\2\u00d1\u00d3\n\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\7a"+
		"\2\2\u00d7\u00d9\n\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7a"+
		"\2\2\u00dd\u00de\7T\2\2\u00de\u00df\7D\2\2\u00df\u00e1\3\2\2\2\u00e0\u00e2"+
		"\n\2\2\2\u00e1\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\34\3\2\2\2\u00e3"+
		"\u00e5\n\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\7a\2\2\u00e9"+
		"\u00eb\n\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2"+
		"\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7a\2\2\u00ef"+
		"\u00f0\7H\2\2\u00f0\u0100\7Y\2\2\u00f1\u00f3\n\2\2\2\u00f2\u00f1\3\2\2"+
		"\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6"+
		"\3\2\2\2\u00f6\u00f8\7a\2\2\u00f7\u00f9\n\2\2\2\u00f8\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2"+
		"\2\2\u00fc\u00fd\7a\2\2\u00fd\u00fe\7H\2\2\u00fe\u0100\7Y\2\2\u00ff\u00e4"+
		"\3\2\2\2\u00ff\u00f2\3\2\2\2\u0100\36\3\2\2\2\u0101\u0102\7\60\2\2\u0102"+
		"\u0103\7a\2\2\u0103\u0104\7\60\2\2\u0104\u0105\7a\2\2\u0105\u0106\7\60"+
		"\2\2\u0106 \3\2\2\2\u0107\u0108\7.\2\2\u0108\u0109\7a\2\2\u0109\u010a"+
		"\7.\2\2\u010a\u010b\7a\2\2\u010b\u010c\7.\2\2\u010c\"\3\2\2\2\u010d\u010e"+
		"\7<\2\2\u010e\u010f\7a\2\2\u010f\u0110\7<\2\2\u0110\u0111\7a\2\2\u0111"+
		"\u0112\7<\2\2\u0112$\3\2\2\2\u0113\u0115\n\2\2\2\u0114\u0113\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u011a\7a\2\2\u0119\u011b\n\2\2\2\u011a\u0119\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2"+
		"\2\2\u011e\u0120\7a\2\2\u011f\u0121\n\2\2\2\u0120\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123&\3\2\2\2"+
		"\u0124\u0126\t\2\2\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\b\24\2\2"+
		"\u012a(\3\2\2\2 \2V\\nx}\u0083\u008a\u008f\u0095\u009e\u00a4\u00ad\u00b3"+
		"\u00bc\u00c2\u00c8\u00cf\u00d4\u00da\u00e1\u00e6\u00ec\u00f4\u00fa\u00ff"+
		"\u0116\u011c\u0122\u0127\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}