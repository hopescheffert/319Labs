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
		T__0=1, COMMANDNAME=2, COLOR=3, SHAPE=4, INT=5, DEGREE=6, WS=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "COMMANDNAME", "COLOR", "SHAPE", "INT", "DEGREE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "COMMANDNAME", "COLOR", "SHAPE", "INT", "DEGREE", "WS"
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
	    //String shape = "";
	    //String color = "";
	    String p0 = "";
	    Integer p1 = 0;
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
		case 6:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\tr\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4G\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5c\n\5\3\6\6\6f\n\6\r\6\16\6g\3\7\3\7\3\b\6"+
		"\bm\n\b\r\b\16\bn\3\b\3\b\2\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\5\3"+
		"\2\62;\4\2\62\6588\5\2\13\f\17\17\"\"~\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5"+
		"!\3\2\2\2\7F\3\2\2\2\tb\3\2\2\2\13e\3\2\2\2\ri\3\2\2\2\17l\3\2\2\2\21"+
		"\22\7=\2\2\22\4\3\2\2\2\23\24\7f\2\2\24\25\7t\2\2\25\26\7c\2\2\26\"\7"+
		"y\2\2\27\30\7h\2\2\30\31\7k\2\2\31\32\7n\2\2\32\"\7n\2\2\33\34\7t\2\2"+
		"\34\35\7q\2\2\35\36\7v\2\2\36\37\7c\2\2\37 \7v\2\2 \"\7g\2\2!\23\3\2\2"+
		"\2!\27\3\2\2\2!\33\3\2\2\2\"\6\3\2\2\2#$\7t\2\2$%\7g\2\2%G\7f\2\2&\'\7"+
		"i\2\2\'(\7t\2\2()\7g\2\2)*\7g\2\2*G\7p\2\2+,\7d\2\2,-\7n\2\2-.\7w\2\2"+
		".G\7g\2\2/\60\7{\2\2\60\61\7g\2\2\61\62\7n\2\2\62\63\7n\2\2\63\64\7q\2"+
		"\2\64G\7y\2\2\65\66\7d\2\2\66\67\7n\2\2\678\7c\2\289\7e\2\29G\7m\2\2:"+
		";\7r\2\2;<\7w\2\2<=\7t\2\2=>\7r\2\2>?\7n\2\2?G\7g\2\2@A\7q\2\2AB\7t\2"+
		"\2BC\7c\2\2CD\7p\2\2DE\7i\2\2EG\7g\2\2F#\3\2\2\2F&\3\2\2\2F+\3\2\2\2F"+
		"/\3\2\2\2F\65\3\2\2\2F:\3\2\2\2F@\3\2\2\2G\b\3\2\2\2HI\7e\2\2IJ\7k\2\2"+
		"JK\7t\2\2KL\7e\2\2LM\7n\2\2Mc\7g\2\2NO\7t\2\2OP\7g\2\2PQ\7e\2\2QR\7v\2"+
		"\2RS\7c\2\2ST\7p\2\2TU\7i\2\2UV\7n\2\2Vc\7g\2\2WX\7g\2\2XY\7n\2\2YZ\7"+
		"n\2\2Z[\7k\2\2[\\\7r\2\2\\]\7u\2\2]c\7g\2\2^_\7n\2\2_`\7k\2\2`a\7p\2\2"+
		"ac\7g\2\2bH\3\2\2\2bN\3\2\2\2bW\3\2\2\2b^\3\2\2\2c\n\3\2\2\2df\t\2\2\2"+
		"ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\f\3\2\2\2ij\t\3\2\2j\16\3\2"+
		"\2\2km\t\4\2\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2op\3\2\2\2pq\b\b"+
		"\2\2q\20\3\2\2\2\b\2!Fbgn\3\3\b\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}