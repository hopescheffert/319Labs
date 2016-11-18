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
		EMAIL=1, EMAILELEMENT=2, YEAR=3, MONTH=4, DAY=5, DATE=6, DATEELEMENT=7, 
		PHONE=8, PHONEELEMENT=9, WS=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LOCALPART", "DOMAINPART", "EMAIL", "EMAILELEMENT", "DIGIT", "YEAR", "MONTH", 
		"DAY", "DATE", "DATEELEMENT", "PHONE", "PHONEELEMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EMAIL", "EMAILELEMENT", "YEAR", "MONTH", "DAY", "DATE", "DATEELEMENT", 
		"PHONE", "PHONEELEMENT", "WS"
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
		case 5:
			YEAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 8:
			DATE_action((RuleContext)_localctx, actionIndex);
			break;
		case 9:
			DATEELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 10:
			PHONE_action((RuleContext)_localctx, actionIndex);
			break;
		case 11:
			PHONEELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 12:
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
	private void PHONE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			3
			break;
		case 8:
			3
			break;
		case 9:
			4
			break;
		case 10:

			    System.out.println("**PHONE** " + getText());

			break;
		}
	}
	private void PHONEELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:

			    System.out.println("****PHONEELEMENT FOUND****" + getText());

			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\f\u00f5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\6\2\37\n\2\r\2\16\2 \3\2\3\2\6\2%"+
		"\n\2\r\2\16\2&\5\2)\n\2\3\3\6\3,\n\3\r\3\16\3-\3\4\6\4\61\n\4\r\4\16\4"+
		"\62\3\4\3\4\6\4\67\n\4\r\4\16\48\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5K\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5^\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7p\n\7\3\b\3\b\3\b\3\b\5\bv\n"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0080\n\t\3\n\3\n\6\n\u0084\n\n"+
		"\r\n\16\n\u0085\3\n\3\n\6\n\u008a\n\n\r\n\16\n\u008b\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009d\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00ae\n\13\3\13\3\13\3\f\5\f\u00b3\n\f\3\f\3\f\3\f\5\f\u00b8"+
		"\n\f\3\f\6\f\u00bb\n\f\r\f\16\f\u00bc\3\f\3\f\3\f\6\f\u00c2\n\f\r\f\16"+
		"\f\u00c3\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u00d8\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u00eb\n\r\3\r\3\r\3\16\6\16\u00f0\n\16\r\16"+
		"\16\16\u00f1\3\16\3\16\3-\2\17\3\2\5\2\7\3\t\4\13\2\r\5\17\6\21\7\23\b"+
		"\25\t\27\n\31\13\33\f\3\2\22\13\2##&&(/\62=??C\\aac|\u0080\u0080\3\2\60"+
		"\60\6\2/\60\62;C\\c|\3\2\62;\3\2\64\64\3\2\62\62\3\2\63\63\3\2\63;\3\2"+
		"\62\64\3\2\65\65\3\2\62\63\3\2\61\61\3\2**\3\2++\3\2\"\60\5\2\13\f\17"+
		"\17\"\"\u0109\2\7\3\2\2\2\2\t\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\3\36\3\2\2\2\5+\3\2\2\2\7\60\3\2\2\2\tJ\3\2\2\2\13a\3\2\2\2\ro\3\2"+
		"\2\2\17u\3\2\2\2\21\177\3\2\2\2\23\u0081\3\2\2\2\25\u009c\3\2\2\2\27\u00b2"+
		"\3\2\2\2\31\u00d7\3\2\2\2\33\u00ef\3\2\2\2\35\37\t\2\2\2\36\35\3\2\2\2"+
		"\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!(\3\2\2\2\"$\t\3\2\2#%\t\2\2\2$#\3"+
		"\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(\"\3\2\2\2()\3\2\2\2"+
		")\4\3\2\2\2*,\t\4\2\2+*\3\2\2\2,-\3\2\2\2-.\3\2\2\2-+\3\2\2\2.\6\3\2\2"+
		"\2/\61\5\3\2\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63"+
		"\64\3\2\2\2\64\66\7B\2\2\65\67\5\5\3\2\66\65\3\2\2\2\678\3\2\2\28\66\3"+
		"\2\2\289\3\2\2\29:\3\2\2\2:;\b\4\2\2;\b\3\2\2\2<=\7>\2\2=>\7g\2\2>?\7"+
		"o\2\2?@\7c\2\2@A\7k\2\2AB\7n\2\2BK\7@\2\2CD\7>\2\2DE\7G\2\2EF\7O\2\2F"+
		"G\7C\2\2GH\7K\2\2HI\7N\2\2IK\7@\2\2J<\3\2\2\2JC\3\2\2\2KL\3\2\2\2L]\5"+
		"\7\4\2MN\7>\2\2NO\7\61\2\2OP\7g\2\2PQ\7o\2\2QR\7c\2\2RS\7k\2\2ST\7n\2"+
		"\2T^\7@\2\2UV\7>\2\2VW\7\61\2\2WX\7G\2\2XY\7O\2\2YZ\7C\2\2Z[\7K\2\2[\\"+
		"\7N\2\2\\^\7@\2\2]M\3\2\2\2]U\3\2\2\2^_\3\2\2\2_`\b\5\3\2`\n\3\2\2\2a"+
		"b\t\5\2\2b\f\3\2\2\2cd\t\6\2\2de\t\7\2\2ef\b\7\4\2fg\5\13\6\2gh\b\7\5"+
		"\2hi\5\13\6\2ij\b\7\6\2jp\3\2\2\2kl\t\6\2\2lm\t\b\2\2mn\t\7\2\2np\t\7"+
		"\2\2oc\3\2\2\2ok\3\2\2\2p\16\3\2\2\2qr\t\7\2\2rv\t\t\2\2st\t\b\2\2tv\t"+
		"\n\2\2uq\3\2\2\2us\3\2\2\2v\20\3\2\2\2wx\t\7\2\2x\u0080\t\t\2\2yz\t\b"+
		"\2\2z\u0080\5\13\6\2{|\t\6\2\2|\u0080\5\13\6\2}~\t\13\2\2~\u0080\t\f\2"+
		"\2\177w\3\2\2\2\177y\3\2\2\2\177{\3\2\2\2\177}\3\2\2\2\u0080\22\3\2\2"+
		"\2\u0081\u0083\5\21\t\2\u0082\u0084\t\r\2\2\u0083\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u0089\5\17\b\2\u0088\u008a\t\r\2\2\u0089\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008e\5\r\7\2\u008e\u008f\b\n\7\2\u008f\24\3\2\2\2\u0090\u0091"+
		"\7>\2\2\u0091\u0092\7f\2\2\u0092\u0093\7c\2\2\u0093\u0094\7v\2\2\u0094"+
		"\u0095\7g\2\2\u0095\u009d\7@\2\2\u0096\u0097\7>\2\2\u0097\u0098\7F\2\2"+
		"\u0098\u0099\7C\2\2\u0099\u009a\7V\2\2\u009a\u009b\7G\2\2\u009b\u009d"+
		"\7@\2\2\u009c\u0090\3\2\2\2\u009c\u0096\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u00ad\5\23\n\2\u009f\u00a0\7>\2\2\u00a0\u00a1\7\61\2\2\u00a1\u00a2\7"+
		"f\2\2\u00a2\u00a3\7c\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7g\2\2\u00a5\u00ae"+
		"\7@\2\2\u00a6\u00a7\7>\2\2\u00a7\u00a8\7\61\2\2\u00a8\u00a9\7F\2\2\u00a9"+
		"\u00aa\7C\2\2\u00aa\u00ab\7V\2\2\u00ab\u00ac\7G\2\2\u00ac\u00ae\7@\2\2"+
		"\u00ad\u009f\3\2\2\2\u00ad\u00a6\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0"+
		"\b\13\b\2\u00b0\26\3\2\2\2\u00b1\u00b3\t\16\2\2\u00b2\u00b1\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\t\5\2\2\u00b5\u00b7\b\f"+
		"\t\2\u00b6\u00b8\t\17\2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00ba\3\2\2\2\u00b9\u00bb\t\20\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00bc\3"+
		"\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bf\t\5\2\2\u00bf\u00c1\b\f\n\2\u00c0\u00c2\t\20\2\2\u00c1\u00c0\3"+
		"\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\t\5\2\2\u00c6\u00c7\b\f\13\2\u00c7\u00c8\b"+
		"\f\f\2\u00c8\30\3\2\2\2\u00c9\u00ca\7>\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc"+
		"\7j\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf\7g\2\2\u00cf"+
		"\u00d8\7@\2\2\u00d0\u00d1\7>\2\2\u00d1\u00d2\7R\2\2\u00d2\u00d3\7J\2\2"+
		"\u00d3\u00d4\7Q\2\2\u00d4\u00d5\7P\2\2\u00d5\u00d6\7G\2\2\u00d6\u00d8"+
		"\7@\2\2\u00d7\u00c9\3\2\2\2\u00d7\u00d0\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00ea\5\27\f\2\u00da\u00db\7>\2\2\u00db\u00dc\7\61\2\2\u00dc\u00dd\7"+
		"r\2\2\u00dd\u00de\7j\2\2\u00de\u00df\7q\2\2\u00df\u00e0\7p\2\2\u00e0\u00e1"+
		"\7g\2\2\u00e1\u00eb\7@\2\2\u00e2\u00e3\7>\2\2\u00e3\u00e4\7\61\2\2\u00e4"+
		"\u00e5\7R\2\2\u00e5\u00e6\7J\2\2\u00e6\u00e7\7Q\2\2\u00e7\u00e8\7P\2\2"+
		"\u00e8\u00e9\7G\2\2\u00e9\u00eb\7@\2\2\u00ea\u00da\3\2\2\2\u00ea\u00e2"+
		"\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\b\r\r\2\u00ed\32\3\2\2\2\u00ee"+
		"\u00f0\t\21\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3"+
		"\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\b\16\16\2\u00f4"+
		"\34\3\2\2\2\31\2 &(-\628J]ou\177\u0085\u008b\u009c\u00ad\u00b2\u00b7\u00bc"+
		"\u00c3\u00d7\u00ea\u00f1\17\3\4\2\3\5\3\3\7\4\3\7\5\3\7\6\3\n\7\3\13\b"+
		"\3\f\t\3\f\n\3\f\13\3\f\f\3\r\r\3\16\16";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}