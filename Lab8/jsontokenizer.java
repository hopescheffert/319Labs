// Generated from jsontokenizer.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class jsontokenizer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EMAIL=1, EMAILELEMENT=2, YEAR=3, MONTH=4, DAY=5, DATE=6, DATEELEMENT=7, 
		OP1=8, OP2=9, OP3=10, OP4=11, PHONE=12, PHONEELEMENT=13, VISA=14, MASTERCARD=15, 
		AMERICANEXP=16, DINERSCLUB=17, DISCOVER=18, JCB=19, CREDITCARD=20, CREDITCARDELEMENT=21, 
		ELEMENTNAME=22, ELEMENTSTRING=23, CUSTOM=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LOCALPART", "DOMAINPART", "EMAIL", "EMAILELEMENT", "DIGIT", "YEAR", "MONTH", 
		"DAY", "DATE", "DATEELEMENT", "THREENUMS", "OP1", "OP2", "OP3", "OP4", 
		"PHONE", "PHONEELEMENT", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", 
		"SIXTEEN", "VISA", "MASTERCARD", "AMERICANEXP", "DINERSCLUB", "DISCOVER", 
		"JCB", "CREDITCARD", "CREDITCARDELEMENT", "ELEMENTNAME", "ELEMENTSTRING", 
		"CUSTOM", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EMAIL", "EMAILELEMENT", "YEAR", "MONTH", "DAY", "DATE", "DATEELEMENT", 
		"OP1", "OP2", "OP3", "OP4", "PHONE", "PHONEELEMENT", "VISA", "MASTERCARD", 
		"AMERICANEXP", "DINERSCLUB", "DISCOVER", "JCB", "CREDITCARD", "CREDITCARDELEMENT", 
		"ELEMENTNAME", "ELEMENTSTRING", "CUSTOM", "WS"
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


	public jsontokenizer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "jsontokenizer.g4"; }

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
		case 3:
			EMAILELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 9:
			DATEELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 16:
			PHONEELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 30:
			CREDITCARDELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 33:
			CUSTOM_action((RuleContext)_localctx, actionIndex);
			break;
		case 34:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void EMAILELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			    System.out.println("****EMAIL ELEMENT FOUND**** " + getText());

			break;
		}
	}
	private void DATEELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

			    System.out.println("****DATE ELEMENT FOUND**** " + getText());

			break;
		}
	}
	private void PHONEELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:

			    System.out.println("****PHONE ELEMENT FOUND****" + getText());

			break;
		}
	}
	private void CREDITCARDELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:

			    System.out.println("****CREDIT CARD ELEMENT FOUND****" + getText());

			break;
		}
	}
	private void CUSTOM_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:

			    System.out.println("***CUSTOM ELEMENT FOUND****" + getText());

			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u01d7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\3\2\6\2K\n\2\r\2\16\2L\3\2\3\2\6\2Q\n\2\r"+
		"\2\16\2R\5\2U\n\2\3\3\6\3X\n\3\r\3\16\3Y\3\4\6\4]\n\4\r\4\16\4^\3\4\3"+
		"\4\6\4c\n\4\r\4\16\4d\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5w\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u008b\n\7\3\b\3\b\3\b\3\b\5\b\u0091\n"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u009b\n\t\3\n\3\n\6\n\u009f\n\n"+
		"\r\n\16\n\u00a0\3\n\3\n\6\n\u00a5\n\n\r\n\16\n\u00a6\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b9"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\5\21\u00e8\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00fa\n\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u0122\n\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\5\32\u0138\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0142"+
		"\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u016a\n\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0176\n\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u0188\n\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0190\n\37\3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \5 \u01ac\n \3 \3 \3 \3 \3 \3 \3 \3!\6!\u01b6\n!\r!\16!\u01b7\3"+
		"!\3!\3\"\6\"\u01bd\n\"\r\"\16\"\u01be\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01ca"+
		"\n#\3#\5#\u01cd\n#\3#\3#\3$\6$\u01d2\n$\r$\16$\u01d3\3$\3$\3Y\2%\3\2\5"+
		"\2\7\3\t\4\13\2\r\5\17\6\21\7\23\b\25\t\27\2\31\n\33\13\35\f\37\r!\16"+
		"#\17%\2\'\2)\2+\2-\2/\2\61\20\63\21\65\22\67\239\24;\25=\26?\27A\30C\31"+
		"E\32G\33\3\2\20\13\2##&&(/\62=??C\\aac|\u0080\u0080\3\2\60\60\6\2/\60"+
		"\62;C\\c|\3\2\62;\3\2\63;\3\2\62\64\3\2\62\63\3\2\61\61\3\2\"\"\3\2//"+
		"\t\2\"\")+C\\aac|~~\u0080\u0080\5\2/\60\62;C|\13\2\"#&&(/\62=??C\\aac"+
		"|\u0080\u0080\7\2\13\f\17\17\"\"}}\177\177\u01fa\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\3J\3\2\2\2\5W\3\2\2\2\7\\\3\2\2\2\tv\3\2\2\2\13\177\3\2\2\2\r\u008a\3"+
		"\2\2\2\17\u0090\3\2\2\2\21\u009a\3\2\2\2\23\u009c\3\2\2\2\25\u00b8\3\2"+
		"\2\2\27\u00c1\3\2\2\2\31\u00c5\3\2\2\2\33\u00cc\3\2\2\2\35\u00d3\3\2\2"+
		"\2\37\u00da\3\2\2\2!\u00e7\3\2\2\2#\u00f9\3\2\2\2%\u0102\3\2\2\2\'\u010e"+
		"\3\2\2\2)\u0111\3\2\2\2+\u0114\3\2\2\2-\u0117\3\2\2\2/\u011a\3\2\2\2\61"+
		"\u0121\3\2\2\2\63\u0137\3\2\2\2\65\u0141\3\2\2\2\67\u0169\3\2\2\29\u0175"+
		"\3\2\2\2;\u0187\3\2\2\2=\u018f\3\2\2\2?\u01ab\3\2\2\2A\u01b5\3\2\2\2C"+
		"\u01bc\3\2\2\2E\u01c0\3\2\2\2G\u01d1\3\2\2\2IK\t\2\2\2JI\3\2\2\2KL\3\2"+
		"\2\2LJ\3\2\2\2LM\3\2\2\2MT\3\2\2\2NP\t\3\2\2OQ\t\2\2\2PO\3\2\2\2QR\3\2"+
		"\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TN\3\2\2\2TU\3\2\2\2U\4\3\2\2\2VX\t"+
		"\4\2\2WV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2YW\3\2\2\2Z\6\3\2\2\2[]\5\3\2\2\\"+
		"[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`b\7B\2\2ac\5\5\3\2"+
		"ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2e\b\3\2\2\2fg\7$\2\2gh\7G\2\2"+
		"hi\7O\2\2ij\7C\2\2jk\7K\2\2kl\7N\2\2lm\7$\2\2mw\7<\2\2no\7$\2\2op\7g\2"+
		"\2pq\7o\2\2qr\7c\2\2rs\7k\2\2st\7n\2\2tu\7$\2\2uw\7<\2\2vf\3\2\2\2vn\3"+
		"\2\2\2wx\3\2\2\2xy\7$\2\2yz\5\7\4\2z{\7$\2\2{|\7.\2\2|}\3\2\2\2}~\b\5"+
		"\2\2~\n\3\2\2\2\177\u0080\t\5\2\2\u0080\f\3\2\2\2\u0081\u0082\7\64\2\2"+
		"\u0082\u0083\7\62\2\2\u0083\u0084\5\13\6\2\u0084\u0085\5\13\6\2\u0085"+
		"\u008b\3\2\2\2\u0086\u0087\7\64\2\2\u0087\u0088\7\63\2\2\u0088\u0089\7"+
		"\62\2\2\u0089\u008b\7\62\2\2\u008a\u0081\3\2\2\2\u008a\u0086\3\2\2\2\u008b"+
		"\16\3\2\2\2\u008c\u008d\7\62\2\2\u008d\u0091\t\6\2\2\u008e\u008f\7\63"+
		"\2\2\u008f\u0091\t\7\2\2\u0090\u008c\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\20\3\2\2\2\u0092\u0093\7\62\2\2\u0093\u009b\t\6\2\2\u0094\u0095\7\63"+
		"\2\2\u0095\u009b\5\13\6\2\u0096\u0097\7\64\2\2\u0097\u009b\5\13\6\2\u0098"+
		"\u0099\7\65\2\2\u0099\u009b\t\b\2\2\u009a\u0092\3\2\2\2\u009a\u0094\3"+
		"\2\2\2\u009a\u0096\3\2\2\2\u009a\u0098\3\2\2\2\u009b\22\3\2\2\2\u009c"+
		"\u009e\5\21\t\2\u009d\u009f\t\t\2\2\u009e\u009d\3\2\2\2\u009f\u00a0\3"+
		"\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a4\5\17\b\2\u00a3\u00a5\t\t\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3"+
		"\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a9\5\r\7\2\u00a9\24\3\2\2\2\u00aa\u00ab\7$\2\2\u00ab\u00ac\7F\2\2"+
		"\u00ac\u00ad\7C\2\2\u00ad\u00ae\7V\2\2\u00ae\u00af\7G\2\2\u00af\u00b0"+
		"\7$\2\2\u00b0\u00b9\7<\2\2\u00b1\u00b2\7$\2\2\u00b2\u00b3\7f\2\2\u00b3"+
		"\u00b4\7c\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7$\2\2"+
		"\u00b7\u00b9\7<\2\2\u00b8\u00aa\3\2\2\2\u00b8\u00b1\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\u00bb\7$\2\2\u00bb\u00bc\5\23\n\2\u00bc\u00bd\7$\2\2\u00bd"+
		"\u00be\7.\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\b\13\3\2\u00c0\26\3\2\2"+
		"\2\u00c1\u00c2\5\13\6\2\u00c2\u00c3\5\13\6\2\u00c3\u00c4\5\13\6\2\u00c4"+
		"\30\3\2\2\2\u00c5\u00c6\5\27\f\2\u00c6\u00c7\t\n\2\2\u00c7\u00c8\5\27"+
		"\f\2\u00c8\u00c9\t\n\2\2\u00c9\u00ca\5\27\f\2\u00ca\u00cb\5\13\6\2\u00cb"+
		"\32\3\2\2\2\u00cc\u00cd\5\27\f\2\u00cd\u00ce\t\3\2\2\u00ce\u00cf\5\27"+
		"\f\2\u00cf\u00d0\t\3\2\2\u00d0\u00d1\5\27\f\2\u00d1\u00d2\5\13\6\2\u00d2"+
		"\34\3\2\2\2\u00d3\u00d4\5\27\f\2\u00d4\u00d5\t\13\2\2\u00d5\u00d6\5\27"+
		"\f\2\u00d6\u00d7\t\13\2\2\u00d7\u00d8\5\27\f\2\u00d8\u00d9\5\13\6\2\u00d9"+
		"\36\3\2\2\2\u00da\u00db\7*\2\2\u00db\u00dc\5\27\f\2\u00dc\u00dd\7+\2\2"+
		"\u00dd\u00de\t\n\2\2\u00de\u00df\5\27\f\2\u00df\u00e0\t\13\2\2\u00e0\u00e1"+
		"\5\27\f\2\u00e1\u00e2\5\13\6\2\u00e2 \3\2\2\2\u00e3\u00e8\5\31\r\2\u00e4"+
		"\u00e8\5\33\16\2\u00e5\u00e8\5\35\17\2\u00e6\u00e8\5\37\20\2\u00e7\u00e3"+
		"\3\2\2\2\u00e7\u00e4\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8"+
		"\"\3\2\2\2\u00e9\u00ea\7$\2\2\u00ea\u00eb\7R\2\2\u00eb\u00ec\7J\2\2\u00ec"+
		"\u00ed\7Q\2\2\u00ed\u00ee\7P\2\2\u00ee\u00ef\7G\2\2\u00ef\u00f0\7$\2\2"+
		"\u00f0\u00fa\7<\2\2\u00f1\u00f2\7$\2\2\u00f2\u00f3\7r\2\2\u00f3\u00f4"+
		"\7j\2\2\u00f4\u00f5\7q\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f7\7g\2\2\u00f7"+
		"\u00f8\7$\2\2\u00f8\u00fa\7<\2\2\u00f9\u00e9\3\2\2\2\u00f9\u00f1\3\2\2"+
		"\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\7$\2\2\u00fc\u00fd\5!\21\2\u00fd\u00fe"+
		"\7$\2\2\u00fe\u00ff\7.\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\b\22\4\2\u0101"+
		"$\3\2\2\2\u0102\u0103\5\13\6\2\u0103\u0104\5\13\6\2\u0104\u0105\5\13\6"+
		"\2\u0105\u0106\5\13\6\2\u0106\u0107\5\13\6\2\u0107\u0108\5\13\6\2\u0108"+
		"\u0109\5\13\6\2\u0109\u010a\5\13\6\2\u010a\u010b\5\13\6\2\u010b\u010c"+
		"\5\13\6\2\u010c\u010d\5\13\6\2\u010d&\3\2\2\2\u010e\u010f\5%\23\2\u010f"+
		"\u0110\5\13\6\2\u0110(\3\2\2\2\u0111\u0112\5\'\24\2\u0112\u0113\5\13\6"+
		"\2\u0113*\3\2\2\2\u0114\u0115\5)\25\2\u0115\u0116\5\13\6\2\u0116,\3\2"+
		"\2\2\u0117\u0118\5+\26\2\u0118\u0119\5\13\6\2\u0119.\3\2\2\2\u011a\u011b"+
		"\5-\27\2\u011b\u011c\5\13\6\2\u011c\60\3\2\2\2\u011d\u011e\7\66\2\2\u011e"+
		"\u0122\5-\27\2\u011f\u0120\7\66\2\2\u0120\u0122\5\'\24\2\u0121\u011d\3"+
		"\2\2\2\u0121\u011f\3\2\2\2\u0122\62\3\2\2\2\u0123\u0124\7\67\2\2\u0124"+
		"\u0125\7\63\2\2\u0125\u0126\3\2\2\2\u0126\u0138\5+\26\2\u0127\u0128\7"+
		"\67\2\2\u0128\u0129\7\64\2\2\u0129\u012a\3\2\2\2\u012a\u0138\5+\26\2\u012b"+
		"\u012c\7\67\2\2\u012c\u012d\7\65\2\2\u012d\u012e\3\2\2\2\u012e\u0138\5"+
		"+\26\2\u012f\u0130\7\67\2\2\u0130\u0131\7\66\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0138\5+\26\2\u0133\u0134\7\67\2\2\u0134\u0135\7\67\2\2\u0135\u0136\3"+
		"\2\2\2\u0136\u0138\5+\26\2\u0137\u0123\3\2\2\2\u0137\u0127\3\2\2\2\u0137"+
		"\u012b\3\2\2\2\u0137\u012f\3\2\2\2\u0137\u0133\3\2\2\2\u0138\64\3\2\2"+
		"\2\u0139\u013a\7\65\2\2\u013a\u013b\7\66\2\2\u013b\u013c\3\2\2\2\u013c"+
		"\u0142\5)\25\2\u013d\u013e\7\65\2\2\u013e\u013f\79\2\2\u013f\u0140\3\2"+
		"\2\2\u0140\u0142\5)\25\2\u0141\u0139\3\2\2\2\u0141\u013d\3\2\2\2\u0142"+
		"\66\3\2\2\2\u0143\u0144\7\65\2\2\u0144\u0145\7\62\2\2\u0145\u0146\7\62"+
		"\2\2\u0146\u0147\3\2\2\2\u0147\u016a\5%\23\2\u0148\u0149\7\65\2\2\u0149"+
		"\u014a\7\62\2\2\u014a\u014b\7\63\2\2\u014b\u014c\3\2\2\2\u014c\u016a\5"+
		"%\23\2\u014d\u014e\7\65\2\2\u014e\u014f\7\62\2\2\u014f\u0150\7\64\2\2"+
		"\u0150\u0151\3\2\2\2\u0151\u016a\5%\23\2\u0152\u0153\7\65\2\2\u0153\u0154"+
		"\7\62\2\2\u0154\u0155\7\65\2\2\u0155\u0156\3\2\2\2\u0156\u016a\5%\23\2"+
		"\u0157\u0158\7\65\2\2\u0158\u0159\7\62\2\2\u0159\u015a\7\66\2\2\u015a"+
		"\u015b\3\2\2\2\u015b\u016a\5%\23\2\u015c\u015d\7\65\2\2\u015d\u015e\7"+
		"\62\2\2\u015e\u015f\7\67\2\2\u015f\u0160\3\2\2\2\u0160\u016a\5%\23\2\u0161"+
		"\u0162\7\65\2\2\u0162\u0163\78\2\2\u0163\u0164\3\2\2\2\u0164\u016a\5\'"+
		"\24\2\u0165\u0166\7\65\2\2\u0166\u0167\7:\2\2\u0167\u0168\3\2\2\2\u0168"+
		"\u016a\5\'\24\2\u0169\u0143\3\2\2\2\u0169\u0148\3\2\2\2\u0169\u014d\3"+
		"\2\2\2\u0169\u0152\3\2\2\2\u0169\u0157\3\2\2\2\u0169\u015c\3\2\2\2\u0169"+
		"\u0161\3\2\2\2\u0169\u0165\3\2\2\2\u016a8\3\2\2\2\u016b\u016c\78\2\2\u016c"+
		"\u016d\7\62\2\2\u016d\u016e\7\63\2\2\u016e\u016f\7\63\2\2\u016f\u0170"+
		"\3\2\2\2\u0170\u0176\5\'\24\2\u0171\u0172\78\2\2\u0172\u0173\7\67\2\2"+
		"\u0173\u0174\3\2\2\2\u0174\u0176\5+\26\2\u0175\u016b\3\2\2\2\u0175\u0171"+
		"\3\2\2\2\u0176:\3\2\2\2\u0177\u0178\7\64\2\2\u0178\u0179\7\63\2\2\u0179"+
		"\u017a\7\65\2\2\u017a\u017b\7\63\2\2\u017b\u017c\3\2\2\2\u017c\u0188\5"+
		"%\23\2\u017d\u017e\7\63\2\2\u017e\u017f\7:\2\2\u017f\u0180\7\62\2\2\u0180"+
		"\u0181\7\62\2\2\u0181\u0182\3\2\2\2\u0182\u0188\5%\23\2\u0183\u0184\7"+
		"\65\2\2\u0184\u0185\7\67\2\2\u0185\u0186\3\2\2\2\u0186\u0188\5+\26\2\u0187"+
		"\u0177\3\2\2\2\u0187\u017d\3\2\2\2\u0187\u0183\3\2\2\2\u0188<\3\2\2\2"+
		"\u0189\u0190\5\61\31\2\u018a\u0190\5\63\32\2\u018b\u0190\5\65\33\2\u018c"+
		"\u0190\5\67\34\2\u018d\u0190\59\35\2\u018e\u0190\5;\36\2\u018f\u0189\3"+
		"\2\2\2\u018f\u018a\3\2\2\2\u018f\u018b\3\2\2\2\u018f\u018c\3\2\2\2\u018f"+
		"\u018d\3\2\2\2\u018f\u018e\3\2\2\2\u0190>\3\2\2\2\u0191\u0192\7$\2\2\u0192"+
		"\u0193\7E\2\2\u0193\u0194\7T\2\2\u0194\u0195\7G\2\2\u0195\u0196\7F\2\2"+
		"\u0196\u0197\7K\2\2\u0197\u0198\7V\2\2\u0198\u0199\7E\2\2\u0199\u019a"+
		"\7C\2\2\u019a\u019b\7T\2\2\u019b\u019c\7F\2\2\u019c\u019d\7$\2\2\u019d"+
		"\u01ac\7<\2\2\u019e\u019f\7$\2\2\u019f\u01a0\7e\2\2\u01a0\u01a1\7t\2\2"+
		"\u01a1\u01a2\7g\2\2\u01a2\u01a3\7f\2\2\u01a3\u01a4\7k\2\2\u01a4\u01a5"+
		"\7v\2\2\u01a5\u01a6\7e\2\2\u01a6\u01a7\7c\2\2\u01a7\u01a8\7t\2\2\u01a8"+
		"\u01a9\7f\2\2\u01a9\u01aa\7$\2\2\u01aa\u01ac\7<\2\2\u01ab\u0191\3\2\2"+
		"\2\u01ab\u019e\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae\7$\2\2\u01ae\u01af"+
		"\5=\37\2\u01af\u01b0\7$\2\2\u01b0\u01b1\7.\2\2\u01b1\u01b2\3\2\2\2\u01b2"+
		"\u01b3\b \5\2\u01b3@\3\2\2\2\u01b4\u01b6\t\f\2\2\u01b5\u01b4\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\3\2"+
		"\2\2\u01b9\u01ba\t\r\2\2\u01baB\3\2\2\2\u01bb\u01bd\t\16\2\2\u01bc\u01bb"+
		"\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf"+
		"D\3\2\2\2\u01c0\u01c1\7$\2\2\u01c1\u01c2\5A!\2\u01c2\u01c3\7$\2\2\u01c3"+
		"\u01c4\7<\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\7$\2\2\u01c6\u01c7\5C\""+
		"\2\u01c7\u01c9\7$\2\2\u01c8\u01ca\7.\2\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca"+
		"\3\2\2\2\u01ca\u01cc\3\2\2\2\u01cb\u01cd\7\177\2\2\u01cc\u01cb\3\2\2\2"+
		"\u01cc\u01cd\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\b#\6\2\u01cfF\3\2"+
		"\2\2\u01d0\u01d2\t\17\2\2\u01d1\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3"+
		"\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\b$"+
		"\7\2\u01d6H\3\2\2\2\37\2LRTY^dv\u008a\u0090\u009a\u00a0\u00a6\u00b8\u00e7"+
		"\u00f9\u0121\u0137\u0141\u0169\u0175\u0187\u018f\u01ab\u01b7\u01be\u01c9"+
		"\u01cc\u01d3\b\3\5\2\3\13\3\3\22\4\3 \5\3#\6\3$\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}