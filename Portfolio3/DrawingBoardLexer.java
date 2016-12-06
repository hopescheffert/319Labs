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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n}\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3$\n\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4I\n\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5i\n\5\3\6\6\6l\n\6"+
		"\r\6\16\6m\3\7\6\7q\n\7\r\7\16\7r\3\b\3\b\3\t\6\tx\n\t\r\t\16\ty\3\t\3"+
		"\t\2\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2\6\4\2C\\c|\3\2\62;\4\2"+
		"\62\6588\5\2\13\f\17\17\"\"\u008a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3"+
		"\2\2\2\5#\3\2\2\2\7H\3\2\2\2\th\3\2\2\2\13k\3\2\2\2\rp\3\2\2\2\17t\3\2"+
		"\2\2\21w\3\2\2\2\23\24\7=\2\2\24\4\3\2\2\2\25\26\7f\2\2\26\27\7t\2\2\27"+
		"\30\7c\2\2\30$\7y\2\2\31\32\7h\2\2\32\33\7k\2\2\33\34\7n\2\2\34$\7n\2"+
		"\2\35\36\7t\2\2\36\37\7q\2\2\37 \7v\2\2 !\7c\2\2!\"\7v\2\2\"$\7g\2\2#"+
		"\25\3\2\2\2#\31\3\2\2\2#\35\3\2\2\2$\6\3\2\2\2%&\7t\2\2&\'\7g\2\2\'I\7"+
		"f\2\2()\7i\2\2)*\7t\2\2*+\7g\2\2+,\7g\2\2,I\7p\2\2-.\7d\2\2./\7n\2\2/"+
		"\60\7w\2\2\60I\7g\2\2\61\62\7{\2\2\62\63\7g\2\2\63\64\7n\2\2\64\65\7n"+
		"\2\2\65\66\7q\2\2\66I\7y\2\2\678\7d\2\289\7n\2\29:\7c\2\2:;\7e\2\2;I\7"+
		"m\2\2<=\7r\2\2=>\7w\2\2>?\7t\2\2?@\7r\2\2@A\7n\2\2AI\7g\2\2BC\7q\2\2C"+
		"D\7t\2\2DE\7c\2\2EF\7p\2\2FG\7i\2\2GI\7g\2\2H%\3\2\2\2H(\3\2\2\2H-\3\2"+
		"\2\2H\61\3\2\2\2H\67\3\2\2\2H<\3\2\2\2HB\3\2\2\2I\b\3\2\2\2JK\7e\2\2K"+
		"L\7k\2\2LM\7t\2\2MN\7e\2\2NO\7n\2\2OP\7g\2\2Pi\7\"\2\2QR\7t\2\2RS\7g\2"+
		"\2ST\7e\2\2TU\7v\2\2UV\7c\2\2VW\7p\2\2WX\7i\2\2XY\7n\2\2YZ\7g\2\2Zi\7"+
		"\"\2\2[\\\7g\2\2\\]\7n\2\2]^\7n\2\2^_\7k\2\2_`\7r\2\2`a\7u\2\2ab\7g\2"+
		"\2bi\7\"\2\2cd\7n\2\2de\7k\2\2ef\7p\2\2fg\7g\2\2gi\7\"\2\2hJ\3\2\2\2h"+
		"Q\3\2\2\2h[\3\2\2\2hc\3\2\2\2i\n\3\2\2\2jl\t\2\2\2kj\3\2\2\2lm\3\2\2\2"+
		"mk\3\2\2\2mn\3\2\2\2n\f\3\2\2\2oq\t\3\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2"+
		"\2rs\3\2\2\2s\16\3\2\2\2tu\t\4\2\2u\20\3\2\2\2vx\t\5\2\2wv\3\2\2\2xy\3"+
		"\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\b\t\2\2|\22\3\2\2\2\t\2#Hhmry\3"+
		"\3\t\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}