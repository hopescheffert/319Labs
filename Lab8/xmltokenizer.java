// Generated from xmltokenizer.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class xmltokenizer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EMAIL=1, EMAILELEMENT=2, DATE=3, DATEELEMENT=4, WS=5;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LOCALPART", "DOMAINPART", "EMAIL", "EMAILELEMENT", "DIGIT", "MONTH",
		"DAY", "YEAR", "DATE", "DATEELEMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EMAIL", "EMAILELEMENT", "DATE", "DATEELEMENT", "WS"
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


	public xmltokenizer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "xmltokenizer.g4"; }

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
		case 2:
			EMAIL_action((RuleContext)_localctx, actionIndex);
			break;
		case 3:
			EMAILELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 7:
			YEAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 8:
			DATE_action((RuleContext)_localctx, actionIndex);
			break;
		case 9:
			DATEELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 10:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void EMAIL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			    System.out.println("**EMAIL** " + getText());

			break;
		}
	}
	private void EMAILELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

			    System.out.println("****EMAILELEMENT FOUND**** " + getText());

			break;
		}
	}
	private void YEAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			1
			break;
		case 3:
			1
			break;
		case 4:
			1
			break;
		}
	}
	private void DATE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:

			    System.out.println("**DATE** " + getText());

			break;
		}
	}
	private void DATEELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:

			    System.out.println("****DATEELEMENT FOUND**** " + getText());

			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\7\u00b4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\6\2\33\n\2\r\2\16\2\34\3\2\3\2\6\2!\n\2\r\2\16\2\"\5"+
		"\2%\n\2\3\3\6\3(\n\3\r\3\16\3)\3\4\6\4-\n\4\r\4\16\4.\3\4\3\4\6\4\63\n"+
		"\4\r\4\16\4\64\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5G\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5Z\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7d\n\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bn\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\t|\n\t\3\n\3\n\6\n\u0080\n\n\r\n\16\n\u0081\3\n\3\n"+
		"\6\n\u0086\n\n\r\n\16\n\u0087\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0099\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00aa\n\13\3\13"+
		"\3\13\3\f\6\f\u00af\n\f\r\f\16\f\u00b0\3\f\3\f\3)\2\r\3\2\5\2\7\3\t\4"+
		"\13\2\r\2\17\2\21\2\23\5\25\6\27\7\3\2\17\13\2##&&(/\62=??C\\aac|\u0080"+
		"\u0080\3\2\60\60\6\2/\60\62;C\\c|\3\2\62;\3\2\62\62\3\2\63;\3\2\63\63"+
		"\3\2\62\64\3\2\64\64\3\2\65\65\3\2\62\63\3\2\61\61\5\2\13\f\17\17\"\""+
		"\u00bf\2\7\3\2\2\2\2\t\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\3\32\3\2\2\2\5\'\3\2\2\2\7,\3\2\2\2\tF\3\2\2\2\13]\3\2\2\2\rc\3\2\2\2"+
		"\17m\3\2\2\2\21{\3\2\2\2\23}\3\2\2\2\25\u0098\3\2\2\2\27\u00ae\3\2\2\2"+
		"\31\33\t\2\2\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2"+
		"\35$\3\2\2\2\36 \t\3\2\2\37!\t\2\2\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2\2"+
		"\"#\3\2\2\2#%\3\2\2\2$\36\3\2\2\2$%\3\2\2\2%\4\3\2\2\2&(\t\4\2\2\'&\3"+
		"\2\2\2()\3\2\2\2)*\3\2\2\2)\'\3\2\2\2*\6\3\2\2\2+-\5\3\2\2,+\3\2\2\2-"+
		".\3\2\2\2.,\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\62\7B\2\2\61\63\5\5\3\2\62"+
		"\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66"+
		"\67\b\4\2\2\67\b\3\2\2\289\7>\2\29:\7g\2\2:;\7o\2\2;<\7c\2\2<=\7k\2\2"+
		"=>\7n\2\2>G\7@\2\2?@\7>\2\2@A\7G\2\2AB\7O\2\2BC\7C\2\2CD\7K\2\2DE\7N\2"+
		"\2EG\7@\2\2F8\3\2\2\2F?\3\2\2\2GH\3\2\2\2HY\5\7\4\2IJ\7>\2\2JK\7\61\2"+
		"\2KL\7g\2\2LM\7o\2\2MN\7c\2\2NO\7k\2\2OP\7n\2\2PZ\7@\2\2QR\7>\2\2RS\7"+
		"\61\2\2ST\7G\2\2TU\7O\2\2UV\7C\2\2VW\7K\2\2WX\7N\2\2XZ\7@\2\2YI\3\2\2"+
		"\2YQ\3\2\2\2Z[\3\2\2\2[\\\b\5\3\2\\\n\3\2\2\2]^\t\5\2\2^\f\3\2\2\2_`\t"+
		"\6\2\2`d\t\7\2\2ab\t\b\2\2bd\t\t\2\2c_\3\2\2\2ca\3\2\2\2d\16\3\2\2\2e"+
		"f\t\6\2\2fn\t\7\2\2gh\t\b\2\2hn\5\13\6\2ij\t\n\2\2jn\5\13\6\2kl\t\13\2"+
		"\2ln\t\f\2\2me\3\2\2\2mg\3\2\2\2mi\3\2\2\2mk\3\2\2\2n\20\3\2\2\2op\t\n"+
		"\2\2pq\t\6\2\2qr\b\t\4\2rs\5\13\6\2st\b\t\5\2tu\5\13\6\2uv\b\t\6\2v|\3"+
		"\2\2\2wx\t\n\2\2xy\t\b\2\2yz\t\6\2\2z|\t\6\2\2{o\3\2\2\2{w\3\2\2\2|\22"+
		"\3\2\2\2}\177\5\17\b\2~\u0080\t\r\2\2\177~\3\2\2\2\u0080\u0081\3\2\2\2"+
		"\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085"+
		"\5\r\7\2\u0084\u0086\t\r\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\5\21"+
		"\t\2\u008a\u008b\b\n\7\2\u008b\24\3\2\2\2\u008c\u008d\7>\2\2\u008d\u008e"+
		"\7f\2\2\u008e\u008f\7c\2\2\u008f\u0090\7v\2\2\u0090\u0091\7g\2\2\u0091"+
		"\u0099\7@\2\2\u0092\u0093\7>\2\2\u0093\u0094\7F\2\2\u0094\u0095\7C\2\2"+
		"\u0095\u0096\7V\2\2\u0096\u0097\7G\2\2\u0097\u0099\7@\2\2\u0098\u008c"+
		"\3\2\2\2\u0098\u0092\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u00a9\5\23\n\2"+
		"\u009b\u009c\7>\2\2\u009c\u009d\7\61\2\2\u009d\u009e\7f\2\2\u009e\u009f"+
		"\7c\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7g\2\2\u00a1\u00aa\7@\2\2\u00a2"+
		"\u00a3\7>\2\2\u00a3\u00a4\7\61\2\2\u00a4\u00a5\7F\2\2\u00a5\u00a6\7C\2"+
		"\2\u00a6\u00a7\7V\2\2\u00a7\u00a8\7G\2\2\u00a8\u00aa\7@\2\2\u00a9\u009b"+
		"\3\2\2\2\u00a9\u00a2\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\b\13\b\2"+
		"\u00ac\26\3\2\2\2\u00ad\u00af\t\16\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b3\b\f\t\2\u00b3\30\3\2\2\2\23\2\34\"$).\64FYcm{\u0081\u0087\u0098"+
		"\u00a9\u00b0\n\3\4\2\3\5\3\3\t\4\3\t\5\3\t\6\3\n\7\3\13\b\3\f\t";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
