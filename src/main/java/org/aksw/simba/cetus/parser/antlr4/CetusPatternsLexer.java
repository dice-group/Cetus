/**
 * Cetus - Cetus performs Entity Typing Using patternS
 * Copyright © 2015 Data Science Group (DICE) (michael.roeder@uni-paderborn.de)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
		COMMA=16, COLON=17, BRACKETS=18, WORD=19, WHITESPACE=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ENTITY", "AND", "OR", "BOTH", "CC", "OF", "FORM_OF_BE", "ADJECTIVE", 
		"DETERMINER", "NUMBER", "NOUN", "VERB", "ADVERB", "FOREIGN", "POINT", 
		"COMMA", "COLON", "BRACKETS", "WORD", "WHITESPACE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u014a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\6"+
		"\6W\n\6\r\6\16\6X\3\6\3\6\6\6]\n\6\r\6\16\6^\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\6\bo\n\b\r\b\16\bp\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b{\n\b\3\t\6\t~\n\t\r\t\16\t\177\3\t\3\t\6\t\u0084\n\t"+
		"\r\t\16\t\u0085\3\t\3\t\3\t\3\t\3\t\5\t\u008d\n\t\3\n\6\n\u0090\n\n\r"+
		"\n\16\n\u0091\3\n\3\n\6\n\u0096\n\n\r\n\16\n\u0097\3\n\3\n\3\n\3\n\3\13"+
		"\6\13\u009f\n\13\r\13\16\13\u00a0\3\13\3\13\6\13\u00a5\n\13\r\13\16\13"+
		"\u00a6\3\13\3\13\3\13\3\13\3\f\6\f\u00ae\n\f\r\f\16\f\u00af\3\f\3\f\6"+
		"\f\u00b4\n\f\r\f\16\f\u00b5\3\f\3\f\3\f\3\f\3\f\7\f\u00bd\n\f\f\f\16\f"+
		"\u00c0\13\f\3\r\6\r\u00c3\n\r\r\r\16\r\u00c4\3\r\3\r\6\r\u00c9\n\r\r\r"+
		"\16\r\u00ca\3\r\3\r\3\r\3\r\3\r\5\r\u00d2\n\r\3\16\6\16\u00d5\n\16\r\16"+
		"\16\16\u00d6\3\16\3\16\6\16\u00db\n\16\r\16\16\16\u00dc\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00e4\n\16\3\17\6\17\u00e7\n\17\r\17\16\17\u00e8\3\17"+
		"\3\17\6\17\u00ed\n\17\r\17\16\17\u00ee\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u011a\n\23\f\23\16\23\u011d\13"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\6\24\u0134\n\24\r\24\16\24\u0135"+
		"\3\24\3\24\6\24\u013a\n\24\r\24\16\24\u013b\3\24\3\24\6\24\u0140\n\24"+
		"\r\24\16\24\u0141\3\25\6\25\u0145\n\25\r\25\16\25\u0146\3\25\3\25\2\2"+
		"\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26\3\2\5\5\2\13\f\17\17\"\"\3\2TU\3\2//\u0164"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5\64\3\2\2\2\7?\3\2"+
		"\2\2\tH\3\2\2\2\13V\3\2\2\2\rd\3\2\2\2\17n\3\2\2\2\21}\3\2\2\2\23\u008f"+
		"\3\2\2\2\25\u009e\3\2\2\2\27\u00ad\3\2\2\2\31\u00c2\3\2\2\2\33\u00d4\3"+
		"\2\2\2\35\u00e6\3\2\2\2\37\u00f4\3\2\2\2!\u00fa\3\2\2\2#\u0100\3\2\2\2"+
		"%\u0106\3\2\2\2\'\u0133\3\2\2\2)\u0144\3\2\2\2+,\7&\2\2,-\7G\2\2-.\7P"+
		"\2\2./\7V\2\2/\60\7K\2\2\60\61\7V\2\2\61\62\7[\2\2\62\63\7&\2\2\63\4\3"+
		"\2\2\2\64\65\7c\2\2\65\66\7p\2\2\66\67\7f\2\2\678\7a\2\289\7c\2\29:\7"+
		"p\2\2:;\7f\2\2;<\7a\2\2<=\7E\2\2=>\7E\2\2>\6\3\2\2\2?@\7q\2\2@A\7t\2\2"+
		"AB\7a\2\2BC\7q\2\2CD\7t\2\2DE\7a\2\2EF\7E\2\2FG\7E\2\2G\b\3\2\2\2HI\7"+
		"d\2\2IJ\7q\2\2JK\7v\2\2KL\7j\2\2LM\7a\2\2MN\7d\2\2NO\7q\2\2OP\7v\2\2P"+
		"Q\7j\2\2QR\7a\2\2RS\7E\2\2ST\7E\2\2T\n\3\2\2\2UW\n\2\2\2VU\3\2\2\2WX\3"+
		"\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z\\\7a\2\2[]\n\2\2\2\\[\3\2\2\2]^"+
		"\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7a\2\2ab\7E\2\2bc\7E\2\2c\f"+
		"\3\2\2\2de\7q\2\2ef\7h\2\2fg\7a\2\2gh\7q\2\2hi\7h\2\2ij\7a\2\2jk\7K\2"+
		"\2kl\7P\2\2l\16\3\2\2\2mo\n\2\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2"+
		"\2\2qr\3\2\2\2rs\7a\2\2st\7d\2\2tu\7g\2\2uv\7a\2\2vw\7X\2\2wx\7D\2\2x"+
		"z\3\2\2\2y{\n\2\2\2zy\3\2\2\2z{\3\2\2\2{\20\3\2\2\2|~\n\2\2\2}|\3\2\2"+
		"\2~\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0083\7a\2\2\u0082\u0084\n\2\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\7a\2\2\u0088\u0089\7L\2\2\u0089\u008a\7L\2\2\u008a\u008c\3\2\2"+
		"\2\u008b\u008d\t\3\2\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\22"+
		"\3\2\2\2\u008e\u0090\n\2\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\7a"+
		"\2\2\u0094\u0096\n\2\2\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7a"+
		"\2\2\u009a\u009b\7F\2\2\u009b\u009c\7V\2\2\u009c\24\3\2\2\2\u009d\u009f"+
		"\n\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\7a\2\2\u00a3\u00a5\n\2"+
		"\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\7a\2\2\u00a9\u00aa\7E\2"+
		"\2\u00aa\u00ab\7F\2\2\u00ab\26\3\2\2\2\u00ac\u00ae\n\2\2\2\u00ad\u00ac"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b3\7a\2\2\u00b2\u00b4\n\2\2\2\u00b3\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b8\7a\2\2\u00b8\u00b9\7P\2\2\u00b9\u00ba\7P\2"+
		"\2\u00ba\u00be\3\2\2\2\u00bb\u00bd\n\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0"+
		"\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\30\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c1\u00c3\n\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c8\7a\2\2\u00c7\u00c9\n\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\7a\2\2\u00cd\u00ce\7X\2\2\u00ce\u00cf\7D\2\2\u00cf\u00d1\3\2\2"+
		"\2\u00d0\u00d2\n\2\2\2\u00d1\u00d0\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\32"+
		"\3\2\2\2\u00d3\u00d5\n\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\7a"+
		"\2\2\u00d9\u00db\n\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\7a"+
		"\2\2\u00df\u00e0\7T\2\2\u00e0\u00e1\7D\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e4"+
		"\n\2\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\34\3\2\2\2\u00e5"+
		"\u00e7\n\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6\3\2"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\7a\2\2\u00eb"+
		"\u00ed\n\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3\2"+
		"\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\7a\2\2\u00f1"+
		"\u00f2\7H\2\2\u00f2\u00f3\7Y\2\2\u00f3\36\3\2\2\2\u00f4\u00f5\7\60\2\2"+
		"\u00f5\u00f6\7a\2\2\u00f6\u00f7\7\60\2\2\u00f7\u00f8\7a\2\2\u00f8\u00f9"+
		"\7\60\2\2\u00f9 \3\2\2\2\u00fa\u00fb\7.\2\2\u00fb\u00fc\7a\2\2\u00fc\u00fd"+
		"\7.\2\2\u00fd\u00fe\7a\2\2\u00fe\u00ff\7.\2\2\u00ff\"\3\2\2\2\u0100\u0101"+
		"\7<\2\2\u0101\u0102\7a\2\2\u0102\u0103\7<\2\2\u0103\u0104\7a\2\2\u0104"+
		"\u0105\7<\2\2\u0105$\3\2\2\2\u0106\u0107\7/\2\2\u0107\u0108\7N\2\2\u0108"+
		"\u0109\7T\2\2\u0109\u010a\7D\2\2\u010a\u010b\7/\2\2\u010b\u010c\7a\2\2"+
		"\u010c\u010d\7/\2\2\u010d\u010e\7n\2\2\u010e\u010f\7t\2\2\u010f\u0110"+
		"\7d\2\2\u0110\u0111\7/\2\2\u0111\u0112\7a\2\2\u0112\u0113\7/\2\2\u0113"+
		"\u0114\7N\2\2\u0114\u0115\7T\2\2\u0115\u0116\7D\2\2\u0116\u0117\7/\2\2"+
		"\u0117\u011b\3\2\2\2\u0118\u011a\n\4\2\2\u0119\u0118\3\2\2\2\u011a\u011d"+
		"\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011e\u011f\7/\2\2\u011f\u0120\7T\2\2\u0120\u0121\7T\2"+
		"\2\u0121\u0122\7D\2\2\u0122\u0123\7/\2\2\u0123\u0124\7a\2\2\u0124\u0125"+
		"\7/\2\2\u0125\u0126\7t\2\2\u0126\u0127\7t\2\2\u0127\u0128\7d\2\2\u0128"+
		"\u0129\7/\2\2\u0129\u012a\7a\2\2\u012a\u012b\7/\2\2\u012b\u012c\7T\2\2"+
		"\u012c\u012d\7T\2\2\u012d\u012e\7D\2\2\u012e\u012f\7/\2\2\u012f\u0130"+
		"\3\2\2\2\u0130\u0131\b\23\2\2\u0131&\3\2\2\2\u0132\u0134\n\2\2\2\u0133"+
		"\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2"+
		"\2\2\u0136\u0137\3\2\2\2\u0137\u0139\7a\2\2\u0138\u013a\n\2\2\2\u0139"+
		"\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013c\u013d\3\2\2\2\u013d\u013f\7a\2\2\u013e\u0140\n\2\2\2\u013f"+
		"\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142(\3\2\2\2\u0143\u0145\t\2\2\2\u0144\u0143\3\2\2\2\u0145\u0146"+
		"\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148\3\2\2\2\u0148"+
		"\u0149\b\25\2\2\u0149*\3\2\2\2\36\2X^pz\177\u0085\u008c\u0091\u0097\u00a0"+
		"\u00a6\u00af\u00b5\u00be\u00c4\u00ca\u00d1\u00d6\u00dc\u00e3\u00e8\u00ee"+
		"\u011b\u0135\u013b\u0141\u0146\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}