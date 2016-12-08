// Generated from DrawingBoard.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DrawingBoardLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, COMMANDNAME=2, COLOR=3, SHAPE=4, ID=5, INT=6, DEGREE=7, WS=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "COMMANDNAME", "COLOR", "SHAPE", "ID", "INT", "DEGREE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "COMMANDNAME", "COLOR", "SHAPE", "ID", "INT", "DEGREE", "WS"
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


	    String name = "";
	    String p0 = "";
	    String p1 = "";
	    Integer p2 = 0;
	    Integer p3 = 0;
	    Integer p4 = 0;


	public DrawingBoardLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DrawingBoard.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 7:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n\u008b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\62\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4W\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5w\n\5\3\6\6\6z\n\6\r\6\16"+
		"\6{\3\7\6\7\177\n\7\r\7\16\7\u0080\3\b\3\b\3\t\6\t\u0086\n\t\r\t\16\t"+
		"\u0087\3\t\3\t\2\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2\6\4\2C\\c"+
		"|\3\2\62;\4\2\62\6588\5\2\13\f\17\17\"\"\u009b\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\3\23\3\2\2\2\5\61\3\2\2\2\7V\3\2\2\2\tv\3\2\2\2\13y\3\2\2\2\r~"+
		"\3\2\2\2\17\u0082\3\2\2\2\21\u0085\3\2\2\2\23\24\7=\2\2\24\4\3\2\2\2\25"+
		"\26\7f\2\2\26\27\7t\2\2\27\30\7c\2\2\30\62\7y\2\2\31\32\7h\2\2\32\33\7"+
		"k\2\2\33\34\7n\2\2\34\62\7n\2\2\35\36\7t\2\2\36\37\7q\2\2\37 \7v\2\2 "+
		"!\7c\2\2!\"\7v\2\2\"\62\7g\2\2#$\7o\2\2$%\7q\2\2%&\7x\2\2&\62\7g\2\2\'"+
		"(\7u\2\2()\7j\2\2)*\7t\2\2*+\7k\2\2+,\7p\2\2,\62\7m\2\2-.\7i\2\2./\7t"+
		"\2\2/\60\7q\2\2\60\62\7y\2\2\61\25\3\2\2\2\61\31\3\2\2\2\61\35\3\2\2\2"+
		"\61#\3\2\2\2\61\'\3\2\2\2\61-\3\2\2\2\62\6\3\2\2\2\63\64\7t\2\2\64\65"+
		"\7g\2\2\65W\7f\2\2\66\67\7i\2\2\678\7t\2\289\7g\2\29:\7g\2\2:W\7p\2\2"+
		";<\7d\2\2<=\7n\2\2=>\7w\2\2>W\7g\2\2?@\7{\2\2@A\7g\2\2AB\7n\2\2BC\7n\2"+
		"\2CD\7q\2\2DW\7y\2\2EF\7d\2\2FG\7n\2\2GH\7c\2\2HI\7e\2\2IW\7m\2\2JK\7"+
		"r\2\2KL\7w\2\2LM\7t\2\2MN\7r\2\2NO\7n\2\2OW\7g\2\2PQ\7q\2\2QR\7t\2\2R"+
		"S\7c\2\2ST\7p\2\2TU\7i\2\2UW\7g\2\2V\63\3\2\2\2V\66\3\2\2\2V;\3\2\2\2"+
		"V?\3\2\2\2VE\3\2\2\2VJ\3\2\2\2VP\3\2\2\2W\b\3\2\2\2XY\7e\2\2YZ\7k\2\2"+
		"Z[\7t\2\2[\\\7e\2\2\\]\7n\2\2]^\7g\2\2^w\7\"\2\2_`\7t\2\2`a\7g\2\2ab\7"+
		"e\2\2bc\7v\2\2cd\7c\2\2de\7p\2\2ef\7i\2\2fg\7n\2\2gh\7g\2\2hw\7\"\2\2"+
		"ij\7g\2\2jk\7n\2\2kl\7n\2\2lm\7k\2\2mn\7r\2\2no\7u\2\2op\7g\2\2pw\7\""+
		"\2\2qr\7n\2\2rs\7k\2\2st\7p\2\2tu\7g\2\2uw\7\"\2\2vX\3\2\2\2v_\3\2\2\2"+
		"vi\3\2\2\2vq\3\2\2\2w\n\3\2\2\2xz\t\2\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2"+
		"\2{|\3\2\2\2|\f\3\2\2\2}\177\t\3\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\16\3\2\2\2\u0082\u0083\t\4\2\2\u0083"+
		"\20\3\2\2\2\u0084\u0086\t\5\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2"+
		"\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a"+
		"\b\t\2\2\u008a\22\3\2\2\2\t\2\61Vv{\u0080\u0087\3\3\t\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}