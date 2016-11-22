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
		OP1=8, OP2=9, OP3=10, OP4=11, PHONE=12, PHONEELEMENT=13, VISA=14, MASTERCARD=15, 
		AMERICANEXP=16, DINERSCLUB=17, DISCOVER=18, JCB=19, CREDITCARD=20, CREDITCARDELEMENT=21, 
		WS=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LOCALPART", "DOMAINPART", "EMAIL", "EMAILELEMENT", "DIGIT", "YEAR", "MONTH", 
		"DAY", "DATE", "DATEELEMENT", "THREENUMS", "OP1", "OP2", "OP3", "OP4", 
		"PHONE", "PHONEELEMENT", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", 
		"SIXTEEN", "VISA", "MASTERCARD", "AMERICANEXP", "DINERSCLUB", "DISCOVER", 
		"JCB", "CREDITCARD", "CREDITCARDELEMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EMAIL", "EMAILELEMENT", "YEAR", "MONTH", "DAY", "DATE", "DATEELEMENT", 
		"OP1", "OP2", "OP3", "OP4", "PHONE", "PHONEELEMENT", "VISA", "MASTERCARD", 
		"AMERICANEXP", "DINERSCLUB", "DISCOVER", "JCB", "CREDITCARD", "CREDITCARDELEMENT", 
		"WS"
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
		case 31:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void EMAILELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			    System.out.println("****EMAILELEMENT FOUND**** " + getText());

			break;
		}
	}
	private void DATEELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

			    System.out.println("****DATEELEMENT FOUND**** " + getText());

			break;
		}
	}
	private void PHONEELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:

			    System.out.println("****PHONEELEMENT FOUND****" + getText());

			break;
		}
	}
	private void CREDITCARDELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:

			    System.out.println("****CREDITCARDELEMENT FOUND****" + getText());

			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u01ed\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\3\2\6\2E\n\2\r\2\16\2F\3\2\3\2\6\2K\n\2\r\2\16\2L\5\2O\n\2\3\3"+
		"\6\3R\n\3\r\3\16\3S\3\4\6\4W\n\4\r\4\16\4X\3\4\3\4\6\4]\n\4\r\4\16\4^"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5o\n\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0082"+
		"\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0091\n\7"+
		"\3\b\3\b\3\b\3\b\5\b\u0097\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a1"+
		"\n\t\3\n\3\n\6\n\u00a5\n\n\r\n\16\n\u00a6\3\n\3\n\6\n\u00ab\n\n\r\n\16"+
		"\n\u00ac\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00bd\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00ce\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\5\21\u00f8\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0108\n\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u011b\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u013e\n\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u0154\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33"+
		"\u015e\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0186"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0192\n\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\5\36\u01a4\n\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u01ac\n"+
		"\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \5 \u01c6\n \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u01e3\n \3 \3 \3!\6!\u01e8\n!\r!\16"+
		"!\u01e9\3!\3!\3S\2\"\3\2\5\2\7\3\t\4\13\2\r\5\17\6\21\7\23\b\25\t\27\2"+
		"\31\n\33\13\35\f\37\r!\16#\17%\2\'\2)\2+\2-\2/\2\61\20\63\21\65\22\67"+
		"\239\24;\25=\26?\27A\30\3\2\r\13\2##&&(/\62=??C\\aac|\u0080\u0080\3\2"+
		"\60\60\6\2/\60\62;C\\c|\3\2\62;\3\2\63;\3\2\62\64\3\2\62\63\3\2\61\61"+
		"\3\2\"\"\3\2//\5\2\13\f\17\17\"\"\u0210\2\7\3\2\2\2\2\t\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3D\3\2\2\2\5Q\3\2\2\2\7V\3\2\2\2\tn\3"+
		"\2\2\2\13\u0085\3\2\2\2\r\u0090\3\2\2\2\17\u0096\3\2\2\2\21\u00a0\3\2"+
		"\2\2\23\u00a2\3\2\2\2\25\u00bc\3\2\2\2\27\u00d1\3\2\2\2\31\u00d5\3\2\2"+
		"\2\33\u00dc\3\2\2\2\35\u00e3\3\2\2\2\37\u00ea\3\2\2\2!\u00f7\3\2\2\2#"+
		"\u0107\3\2\2\2%\u011e\3\2\2\2\'\u012a\3\2\2\2)\u012d\3\2\2\2+\u0130\3"+
		"\2\2\2-\u0133\3\2\2\2/\u0136\3\2\2\2\61\u013d\3\2\2\2\63\u0153\3\2\2\2"+
		"\65\u015d\3\2\2\2\67\u0185\3\2\2\29\u0191\3\2\2\2;\u01a3\3\2\2\2=\u01ab"+
		"\3\2\2\2?\u01c5\3\2\2\2A\u01e7\3\2\2\2CE\t\2\2\2DC\3\2\2\2EF\3\2\2\2F"+
		"D\3\2\2\2FG\3\2\2\2GN\3\2\2\2HJ\t\3\2\2IK\t\2\2\2JI\3\2\2\2KL\3\2\2\2"+
		"LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NH\3\2\2\2NO\3\2\2\2O\4\3\2\2\2PR\t\4\2"+
		"\2QP\3\2\2\2RS\3\2\2\2ST\3\2\2\2SQ\3\2\2\2T\6\3\2\2\2UW\5\3\2\2VU\3\2"+
		"\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z\\\7B\2\2[]\5\5\3\2\\[\3"+
		"\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\b\3\2\2\2`a\7>\2\2ab\7g\2\2bc\7"+
		"o\2\2cd\7c\2\2de\7k\2\2ef\7n\2\2fo\7@\2\2gh\7>\2\2hi\7G\2\2ij\7O\2\2j"+
		"k\7C\2\2kl\7K\2\2lm\7N\2\2mo\7@\2\2n`\3\2\2\2ng\3\2\2\2op\3\2\2\2p\u0081"+
		"\5\7\4\2qr\7>\2\2rs\7\61\2\2st\7g\2\2tu\7o\2\2uv\7c\2\2vw\7k\2\2wx\7n"+
		"\2\2x\u0082\7@\2\2yz\7>\2\2z{\7\61\2\2{|\7G\2\2|}\7O\2\2}~\7C\2\2~\177"+
		"\7K\2\2\177\u0080\7N\2\2\u0080\u0082\7@\2\2\u0081q\3\2\2\2\u0081y\3\2"+
		"\2\2\u0082\u0083\3\2\2\2\u0083\u0084\b\5\2\2\u0084\n\3\2\2\2\u0085\u0086"+
		"\t\5\2\2\u0086\f\3\2\2\2\u0087\u0088\7\64\2\2\u0088\u0089\7\62\2\2\u0089"+
		"\u008a\5\13\6\2\u008a\u008b\5\13\6\2\u008b\u0091\3\2\2\2\u008c\u008d\7"+
		"\64\2\2\u008d\u008e\7\63\2\2\u008e\u008f\7\62\2\2\u008f\u0091\7\62\2\2"+
		"\u0090\u0087\3\2\2\2\u0090\u008c\3\2\2\2\u0091\16\3\2\2\2\u0092\u0093"+
		"\7\62\2\2\u0093\u0097\t\6\2\2\u0094\u0095\7\63\2\2\u0095\u0097\t\7\2\2"+
		"\u0096\u0092\3\2\2\2\u0096\u0094\3\2\2\2\u0097\20\3\2\2\2\u0098\u0099"+
		"\7\62\2\2\u0099\u00a1\t\6\2\2\u009a\u009b\7\63\2\2\u009b\u00a1\5\13\6"+
		"\2\u009c\u009d\7\64\2\2\u009d\u00a1\5\13\6\2\u009e\u009f\7\65\2\2\u009f"+
		"\u00a1\t\b\2\2\u00a0\u0098\3\2\2\2\u00a0\u009a\3\2\2\2\u00a0\u009c\3\2"+
		"\2\2\u00a0\u009e\3\2\2\2\u00a1\22\3\2\2\2\u00a2\u00a4\5\21\t\2\u00a3\u00a5"+
		"\t\t\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\5\17\b\2\u00a9\u00ab\t"+
		"\t\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\5\r\7\2\u00af\24\3\2\2"+
		"\2\u00b0\u00b1\7>\2\2\u00b1\u00b2\7f\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4"+
		"\7v\2\2\u00b4\u00b5\7g\2\2\u00b5\u00bd\7@\2\2\u00b6\u00b7\7>\2\2\u00b7"+
		"\u00b8\7F\2\2\u00b8\u00b9\7C\2\2\u00b9\u00ba\7V\2\2\u00ba\u00bb\7G\2\2"+
		"\u00bb\u00bd\7@\2\2\u00bc\u00b0\3\2\2\2\u00bc\u00b6\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00cd\5\23\n\2\u00bf\u00c0\7>\2\2\u00c0\u00c1\7\61\2\2"+
		"\u00c1\u00c2\7f\2\2\u00c2\u00c3\7c\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5"+
		"\7g\2\2\u00c5\u00ce\7@\2\2\u00c6\u00c7\7>\2\2\u00c7\u00c8\7\61\2\2\u00c8"+
		"\u00c9\7F\2\2\u00c9\u00ca\7C\2\2\u00ca\u00cb\7V\2\2\u00cb\u00cc\7G\2\2"+
		"\u00cc\u00ce\7@\2\2\u00cd\u00bf\3\2\2\2\u00cd\u00c6\3\2\2\2\u00ce\u00cf"+
		"\3\2\2\2\u00cf\u00d0\b\13\3\2\u00d0\26\3\2\2\2\u00d1\u00d2\5\13\6\2\u00d2"+
		"\u00d3\5\13\6\2\u00d3\u00d4\5\13\6\2\u00d4\30\3\2\2\2\u00d5\u00d6\5\27"+
		"\f\2\u00d6\u00d7\t\n\2\2\u00d7\u00d8\5\27\f\2\u00d8\u00d9\t\n\2\2\u00d9"+
		"\u00da\5\27\f\2\u00da\u00db\5\13\6\2\u00db\32\3\2\2\2\u00dc\u00dd\5\27"+
		"\f\2\u00dd\u00de\t\3\2\2\u00de\u00df\5\27\f\2\u00df\u00e0\t\3\2\2\u00e0"+
		"\u00e1\5\27\f\2\u00e1\u00e2\5\13\6\2\u00e2\34\3\2\2\2\u00e3\u00e4\5\27"+
		"\f\2\u00e4\u00e5\t\13\2\2\u00e5\u00e6\5\27\f\2\u00e6\u00e7\t\13\2\2\u00e7"+
		"\u00e8\5\27\f\2\u00e8\u00e9\5\13\6\2\u00e9\36\3\2\2\2\u00ea\u00eb\7*\2"+
		"\2\u00eb\u00ec\5\27\f\2\u00ec\u00ed\7+\2\2\u00ed\u00ee\t\n\2\2\u00ee\u00ef"+
		"\5\27\f\2\u00ef\u00f0\t\13\2\2\u00f0\u00f1\5\27\f\2\u00f1\u00f2\5\13\6"+
		"\2\u00f2 \3\2\2\2\u00f3\u00f8\5\31\r\2\u00f4\u00f8\5\33\16\2\u00f5\u00f8"+
		"\5\35\17\2\u00f6\u00f8\5\37\20\2\u00f7\u00f3\3\2\2\2\u00f7\u00f4\3\2\2"+
		"\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8\"\3\2\2\2\u00f9\u00fa"+
		"\7>\2\2\u00fa\u00fb\7r\2\2\u00fb\u00fc\7j\2\2\u00fc\u00fd\7q\2\2\u00fd"+
		"\u00fe\7p\2\2\u00fe\u00ff\7g\2\2\u00ff\u0108\7@\2\2\u0100\u0101\7>\2\2"+
		"\u0101\u0102\7R\2\2\u0102\u0103\7J\2\2\u0103\u0104\7Q\2\2\u0104\u0105"+
		"\7P\2\2\u0105\u0106\7G\2\2\u0106\u0108\7@\2\2\u0107\u00f9\3\2\2\2\u0107"+
		"\u0100\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u011a\5!\21\2\u010a\u010b\7>"+
		"\2\2\u010b\u010c\7\61\2\2\u010c\u010d\7r\2\2\u010d\u010e\7j\2\2\u010e"+
		"\u010f\7q\2\2\u010f\u0110\7p\2\2\u0110\u0111\7g\2\2\u0111\u011b\7@\2\2"+
		"\u0112\u0113\7>\2\2\u0113\u0114\7\61\2\2\u0114\u0115\7R\2\2\u0115\u0116"+
		"\7J\2\2\u0116\u0117\7Q\2\2\u0117\u0118\7P\2\2\u0118\u0119\7G\2\2\u0119"+
		"\u011b\7@\2\2\u011a\u010a\3\2\2\2\u011a\u0112\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c\u011d\b\22\4\2\u011d$\3\2\2\2\u011e\u011f\5\13\6\2\u011f\u0120"+
		"\5\13\6\2\u0120\u0121\5\13\6\2\u0121\u0122\5\13\6\2\u0122\u0123\5\13\6"+
		"\2\u0123\u0124\5\13\6\2\u0124\u0125\5\13\6\2\u0125\u0126\5\13\6\2\u0126"+
		"\u0127\5\13\6\2\u0127\u0128\5\13\6\2\u0128\u0129\5\13\6\2\u0129&\3\2\2"+
		"\2\u012a\u012b\5%\23\2\u012b\u012c\5\13\6\2\u012c(\3\2\2\2\u012d\u012e"+
		"\5\'\24\2\u012e\u012f\5\13\6\2\u012f*\3\2\2\2\u0130\u0131\5)\25\2\u0131"+
		"\u0132\5\13\6\2\u0132,\3\2\2\2\u0133\u0134\5+\26\2\u0134\u0135\5\13\6"+
		"\2\u0135.\3\2\2\2\u0136\u0137\5-\27\2\u0137\u0138\5\13\6\2\u0138\60\3"+
		"\2\2\2\u0139\u013a\7\66\2\2\u013a\u013e\5-\27\2\u013b\u013c\7\66\2\2\u013c"+
		"\u013e\5\'\24\2\u013d\u0139\3\2\2\2\u013d\u013b\3\2\2\2\u013e\62\3\2\2"+
		"\2\u013f\u0140\7\67\2\2\u0140\u0141\7\63\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\u0154\5+\26\2\u0143\u0144\7\67\2\2\u0144\u0145\7\64\2\2\u0145\u0146\3"+
		"\2\2\2\u0146\u0154\5+\26\2\u0147\u0148\7\67\2\2\u0148\u0149\7\65\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u0154\5+\26\2\u014b\u014c\7\67\2\2\u014c\u014d\7"+
		"\66\2\2\u014d\u014e\3\2\2\2\u014e\u0154\5+\26\2\u014f\u0150\7\67\2\2\u0150"+
		"\u0151\7\67\2\2\u0151\u0152\3\2\2\2\u0152\u0154\5+\26\2\u0153\u013f\3"+
		"\2\2\2\u0153\u0143\3\2\2\2\u0153\u0147\3\2\2\2\u0153\u014b\3\2\2\2\u0153"+
		"\u014f\3\2\2\2\u0154\64\3\2\2\2\u0155\u0156\7\65\2\2\u0156\u0157\7\66"+
		"\2\2\u0157\u0158\3\2\2\2\u0158\u015e\5)\25\2\u0159\u015a\7\65\2\2\u015a"+
		"\u015b\79\2\2\u015b\u015c\3\2\2\2\u015c\u015e\5)\25\2\u015d\u0155\3\2"+
		"\2\2\u015d\u0159\3\2\2\2\u015e\66\3\2\2\2\u015f\u0160\7\65\2\2\u0160\u0161"+
		"\7\62\2\2\u0161\u0162\7\62\2\2\u0162\u0163\3\2\2\2\u0163\u0186\5%\23\2"+
		"\u0164\u0165\7\65\2\2\u0165\u0166\7\62\2\2\u0166\u0167\7\63\2\2\u0167"+
		"\u0168\3\2\2\2\u0168\u0186\5%\23\2\u0169\u016a\7\65\2\2\u016a\u016b\7"+
		"\62\2\2\u016b\u016c\7\64\2\2\u016c\u016d\3\2\2\2\u016d\u0186\5%\23\2\u016e"+
		"\u016f\7\65\2\2\u016f\u0170\7\62\2\2\u0170\u0171\7\65\2\2\u0171\u0172"+
		"\3\2\2\2\u0172\u0186\5%\23\2\u0173\u0174\7\65\2\2\u0174\u0175\7\62\2\2"+
		"\u0175\u0176\7\66\2\2\u0176\u0177\3\2\2\2\u0177\u0186\5%\23\2\u0178\u0179"+
		"\7\65\2\2\u0179\u017a\7\62\2\2\u017a\u017b\7\67\2\2\u017b\u017c\3\2\2"+
		"\2\u017c\u0186\5%\23\2\u017d\u017e\7\65\2\2\u017e\u017f\78\2\2\u017f\u0180"+
		"\3\2\2\2\u0180\u0186\5\'\24\2\u0181\u0182\7\65\2\2\u0182\u0183\7:\2\2"+
		"\u0183\u0184\3\2\2\2\u0184\u0186\5\'\24\2\u0185\u015f\3\2\2\2\u0185\u0164"+
		"\3\2\2\2\u0185\u0169\3\2\2\2\u0185\u016e\3\2\2\2\u0185\u0173\3\2\2\2\u0185"+
		"\u0178\3\2\2\2\u0185\u017d\3\2\2\2\u0185\u0181\3\2\2\2\u01868\3\2\2\2"+
		"\u0187\u0188\78\2\2\u0188\u0189\7\62\2\2\u0189\u018a\7\63\2\2\u018a\u018b"+
		"\7\63\2\2\u018b\u018c\3\2\2\2\u018c\u0192\5\'\24\2\u018d\u018e\78\2\2"+
		"\u018e\u018f\7\67\2\2\u018f\u0190\3\2\2\2\u0190\u0192\5+\26\2\u0191\u0187"+
		"\3\2\2\2\u0191\u018d\3\2\2\2\u0192:\3\2\2\2\u0193\u0194\7\64\2\2\u0194"+
		"\u0195\7\63\2\2\u0195\u0196\7\65\2\2\u0196\u0197\7\63\2\2\u0197\u0198"+
		"\3\2\2\2\u0198\u01a4\5%\23\2\u0199\u019a\7\63\2\2\u019a\u019b\7:\2\2\u019b"+
		"\u019c\7\62\2\2\u019c\u019d\7\62\2\2\u019d\u019e\3\2\2\2\u019e\u01a4\5"+
		"%\23\2\u019f\u01a0\7\65\2\2\u01a0\u01a1\7\67\2\2\u01a1\u01a2\3\2\2\2\u01a2"+
		"\u01a4\5+\26\2\u01a3\u0193\3\2\2\2\u01a3\u0199\3\2\2\2\u01a3\u019f\3\2"+
		"\2\2\u01a4<\3\2\2\2\u01a5\u01ac\5\61\31\2\u01a6\u01ac\5\63\32\2\u01a7"+
		"\u01ac\5\65\33\2\u01a8\u01ac\5\67\34\2\u01a9\u01ac\59\35\2\u01aa\u01ac"+
		"\5;\36\2\u01ab\u01a5\3\2\2\2\u01ab\u01a6\3\2\2\2\u01ab\u01a7\3\2\2\2\u01ab"+
		"\u01a8\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01aa\3\2\2\2\u01ac>\3\2\2\2"+
		"\u01ad\u01ae\7>\2\2\u01ae\u01af\7e\2\2\u01af\u01b0\7t\2\2\u01b0\u01b1"+
		"\7g\2\2\u01b1\u01b2\7f\2\2\u01b2\u01b3\7k\2\2\u01b3\u01b4\7v\2\2\u01b4"+
		"\u01b5\7e\2\2\u01b5\u01b6\7c\2\2\u01b6\u01b7\7t\2\2\u01b7\u01b8\7f\2\2"+
		"\u01b8\u01c6\7@\2\2\u01b9\u01ba\7>\2\2\u01ba\u01bb\7E\2\2\u01bb\u01bc"+
		"\7T\2\2\u01bc\u01bd\7G\2\2\u01bd\u01be\7F\2\2\u01be\u01bf\7K\2\2\u01bf"+
		"\u01c0\7V\2\2\u01c0\u01c1\7E\2\2\u01c1\u01c2\7C\2\2\u01c2\u01c3\7T\2\2"+
		"\u01c3\u01c4\7F\2\2\u01c4\u01c6\7@\2\2\u01c5\u01ad\3\2\2\2\u01c5\u01b9"+
		"\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01e2\5=\37\2\u01c8\u01c9\7>\2\2\u01c9"+
		"\u01ca\7\61\2\2\u01ca\u01cb\7e\2\2\u01cb\u01cc\7t\2\2\u01cc\u01cd\7g\2"+
		"\2\u01cd\u01ce\7f\2\2\u01ce\u01cf\7k\2\2\u01cf\u01d0\7v\2\2\u01d0\u01d1"+
		"\7e\2\2\u01d1\u01d2\7c\2\2\u01d2\u01d3\7t\2\2\u01d3\u01d4\7f\2\2\u01d4"+
		"\u01e3\7@\2\2\u01d5\u01d6\7>\2\2\u01d6\u01d7\7\61\2\2\u01d7\u01d8\7E\2"+
		"\2\u01d8\u01d9\7T\2\2\u01d9\u01da\7G\2\2\u01da\u01db\7F\2\2\u01db\u01dc"+
		"\7K\2\2\u01dc\u01dd\7V\2\2\u01dd\u01de\7E\2\2\u01de\u01df\7C\2\2\u01df"+
		"\u01e0\7T\2\2\u01e0\u01e1\7F\2\2\u01e1\u01e3\7@\2\2\u01e2\u01c8\3\2\2"+
		"\2\u01e2\u01d5\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\b \5\2\u01e5@\3"+
		"\2\2\2\u01e6\u01e8\t\f\2\2\u01e7\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9"+
		"\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\b!"+
		"\6\2\u01ecB\3\2\2\2\37\2FLNSX^n\u0081\u0090\u0096\u00a0\u00a6\u00ac\u00bc"+
		"\u00cd\u00f7\u0107\u011a\u013d\u0153\u015d\u0185\u0191\u01a3\u01ab\u01c5"+
		"\u01e2\u01e9\7\3\5\2\3\13\3\3\22\4\3 \5\3!\6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}