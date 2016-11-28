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
		CASE1=22, CASE2=23, CASE3=24, ELEMENTNAME=25, ELEMENTSTRING=26, CUSTOM=27, 
		WS=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LOCALPART", "DOMAINPART", "EMAIL", "EMAILELEMENT", "DIGIT", "YEAR", "MONTH", 
		"DAY", "DATE", "DATEELEMENT", "THREENUMS", "OP1", "OP2", "OP3", "OP4", 
		"PHONE", "PHONEELEMENT", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", 
		"SIXTEEN", "VISA", "MASTERCARD", "AMERICANEXP", "DINERSCLUB", "DISCOVER", 
		"JCB", "CREDITCARD", "CREDITCARDELEMENT", "CASE1", "CASE2", "CASE3", "ELEMENTNAME", 
		"ELEMENTSTRING", "CUSTOM", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EMAIL", "EMAILELEMENT", "YEAR", "MONTH", "DAY", "DATE", "DATEELEMENT", 
		"OP1", "OP2", "OP3", "OP4", "PHONE", "PHONEELEMENT", "VISA", "MASTERCARD", 
		"AMERICANEXP", "DINERSCLUB", "DISCOVER", "JCB", "CREDITCARD", "CREDITCARDELEMENT", 
		"CASE1", "CASE2", "CASE3", "ELEMENTNAME", "ELEMENTSTRING", "CUSTOM", "WS"
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
		case 36:
			CUSTOM_action((RuleContext)_localctx, actionIndex);
			break;
		case 37:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u0223\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\6\2Q\n\2\r\2\16\2"+
		"R\3\2\3\2\6\2W\n\2\r\2\16\2X\5\2[\n\2\3\3\6\3^\n\3\r\3\16\3_\3\4\6\4c"+
		"\n\4\r\4\16\4d\3\4\3\4\6\4i\n\4\r\4\16\4j\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5{\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u008e\n\5\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u009d\n\7\3\b\3\b\3\b\3\b\5\b\u00a3"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ad\n\t\3\n\3\n\6\n\u00b1\n"+
		"\n\r\n\16\n\u00b2\3\n\3\n\6\n\u00b7\n\n\r\n\16\n\u00b8\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00c9\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00da\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\5\21\u0104\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u0114\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0127\n\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\5\31\u014a\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0160"+
		"\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u016a\n\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0192\n\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u019e\n\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u01b0"+
		"\n\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u01b8\n\37\3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u01d2\n \3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3 \3 \3 \5 \u01ef\n \3 \3 \3!\3!\6!\u01f5\n!\r!\16!\u01f6\3\"\3\"\6\""+
		"\u01fb\n\"\r\"\16\"\u01fc\3#\3#\3#\6#\u0202\n#\r#\16#\u0203\3$\3$\3$\5"+
		"$\u0209\n$\3%\6%\u020c\n%\r%\16%\u020d\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3\'\6\'\u021e\n\'\r\'\16\'\u021f\3\'\3\'\3_\2(\3\2\5\2\7\3\t\4"+
		"\13\2\r\5\17\6\21\7\23\b\25\t\27\2\31\n\33\13\35\f\37\r!\16#\17%\2\'\2"+
		")\2+\2-\2/\2\61\20\63\21\65\22\67\239\24;\25=\26?\27A\30C\31E\32G\33I"+
		"\34K\35M\36\3\2\24\13\2##&&(/\62=??C\\aac|\u0080\u0080\3\2\60\60\6\2/"+
		"\60\62;C\\c|\3\2\62;\3\2\63;\3\2\62\64\3\2\62\63\3\2\61\61\3\2\"\"\3\2"+
		"//\7\2CY[\\aacy{|\5\2/\60\62;C|\4\2ZZzz\t\2/\60\62;CNP\\aacnp|\4\2OOo"+
		"o\t\2/\60\62;CMO\\aacmo|\13\2\"#&&(/\62=??C\\aac|\u0080\u0080\5\2\13\f"+
		"\17\17\"\"\u024c\2\7\3\2\2\2\2\t\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\3P\3\2\2\2\5]\3\2\2\2\7b\3\2\2\2\tz\3\2\2\2\13\u0091\3\2\2\2\r\u009c"+
		"\3\2\2\2\17\u00a2\3\2\2\2\21\u00ac\3\2\2\2\23\u00ae\3\2\2\2\25\u00c8\3"+
		"\2\2\2\27\u00dd\3\2\2\2\31\u00e1\3\2\2\2\33\u00e8\3\2\2\2\35\u00ef\3\2"+
		"\2\2\37\u00f6\3\2\2\2!\u0103\3\2\2\2#\u0113\3\2\2\2%\u012a\3\2\2\2\'\u0136"+
		"\3\2\2\2)\u0139\3\2\2\2+\u013c\3\2\2\2-\u013f\3\2\2\2/\u0142\3\2\2\2\61"+
		"\u0149\3\2\2\2\63\u015f\3\2\2\2\65\u0169\3\2\2\2\67\u0191\3\2\2\29\u019d"+
		"\3\2\2\2;\u01af\3\2\2\2=\u01b7\3\2\2\2?\u01d1\3\2\2\2A\u01f2\3\2\2\2C"+
		"\u01f8\3\2\2\2E\u01fe\3\2\2\2G\u0208\3\2\2\2I\u020b\3\2\2\2K\u020f\3\2"+
		"\2\2M\u021d\3\2\2\2OQ\t\2\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2"+
		"SZ\3\2\2\2TV\t\3\2\2UW\t\2\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2"+
		"Y[\3\2\2\2ZT\3\2\2\2Z[\3\2\2\2[\4\3\2\2\2\\^\t\4\2\2]\\\3\2\2\2^_\3\2"+
		"\2\2_`\3\2\2\2_]\3\2\2\2`\6\3\2\2\2ac\5\3\2\2ba\3\2\2\2cd\3\2\2\2db\3"+
		"\2\2\2de\3\2\2\2ef\3\2\2\2fh\7B\2\2gi\5\5\3\2hg\3\2\2\2ij\3\2\2\2jh\3"+
		"\2\2\2jk\3\2\2\2k\b\3\2\2\2lm\7>\2\2mn\7g\2\2no\7o\2\2op\7c\2\2pq\7k\2"+
		"\2qr\7n\2\2r{\7@\2\2st\7>\2\2tu\7G\2\2uv\7O\2\2vw\7C\2\2wx\7K\2\2xy\7"+
		"N\2\2y{\7@\2\2zl\3\2\2\2zs\3\2\2\2{|\3\2\2\2|\u008d\5\7\4\2}~\7>\2\2~"+
		"\177\7\61\2\2\177\u0080\7g\2\2\u0080\u0081\7o\2\2\u0081\u0082\7c\2\2\u0082"+
		"\u0083\7k\2\2\u0083\u0084\7n\2\2\u0084\u008e\7@\2\2\u0085\u0086\7>\2\2"+
		"\u0086\u0087\7\61\2\2\u0087\u0088\7G\2\2\u0088\u0089\7O\2\2\u0089\u008a"+
		"\7C\2\2\u008a\u008b\7K\2\2\u008b\u008c\7N\2\2\u008c\u008e\7@\2\2\u008d"+
		"}\3\2\2\2\u008d\u0085\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\b\5\2\2"+
		"\u0090\n\3\2\2\2\u0091\u0092\t\5\2\2\u0092\f\3\2\2\2\u0093\u0094\7\64"+
		"\2\2\u0094\u0095\7\62\2\2\u0095\u0096\5\13\6\2\u0096\u0097\5\13\6\2\u0097"+
		"\u009d\3\2\2\2\u0098\u0099\7\64\2\2\u0099\u009a\7\63\2\2\u009a\u009b\7"+
		"\62\2\2\u009b\u009d\7\62\2\2\u009c\u0093\3\2\2\2\u009c\u0098\3\2\2\2\u009d"+
		"\16\3\2\2\2\u009e\u009f\7\62\2\2\u009f\u00a3\t\6\2\2\u00a0\u00a1\7\63"+
		"\2\2\u00a1\u00a3\t\7\2\2\u00a2\u009e\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3"+
		"\20\3\2\2\2\u00a4\u00a5\7\62\2\2\u00a5\u00ad\t\6\2\2\u00a6\u00a7\7\63"+
		"\2\2\u00a7\u00ad\5\13\6\2\u00a8\u00a9\7\64\2\2\u00a9\u00ad\5\13\6\2\u00aa"+
		"\u00ab\7\65\2\2\u00ab\u00ad\t\b\2\2\u00ac\u00a4\3\2\2\2\u00ac\u00a6\3"+
		"\2\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\22\3\2\2\2\u00ae"+
		"\u00b0\5\21\t\2\u00af\u00b1\t\t\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3"+
		"\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b6\5\17\b\2\u00b5\u00b7\t\t\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3"+
		"\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bb\5\r\7\2\u00bb\24\3\2\2\2\u00bc\u00bd\7>\2\2\u00bd\u00be\7f\2\2"+
		"\u00be\u00bf\7c\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c9"+
		"\7@\2\2\u00c2\u00c3\7>\2\2\u00c3\u00c4\7F\2\2\u00c4\u00c5\7C\2\2\u00c5"+
		"\u00c6\7V\2\2\u00c6\u00c7\7G\2\2\u00c7\u00c9\7@\2\2\u00c8\u00bc\3\2\2"+
		"\2\u00c8\u00c2\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00d9\5\23\n\2\u00cb"+
		"\u00cc\7>\2\2\u00cc\u00cd\7\61\2\2\u00cd\u00ce\7f\2\2\u00ce\u00cf\7c\2"+
		"\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7g\2\2\u00d1\u00da\7@\2\2\u00d2\u00d3"+
		"\7>\2\2\u00d3\u00d4\7\61\2\2\u00d4\u00d5\7F\2\2\u00d5\u00d6\7C\2\2\u00d6"+
		"\u00d7\7V\2\2\u00d7\u00d8\7G\2\2\u00d8\u00da\7@\2\2\u00d9\u00cb\3\2\2"+
		"\2\u00d9\u00d2\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b\13\3\2\u00dc"+
		"\26\3\2\2\2\u00dd\u00de\5\13\6\2\u00de\u00df\5\13\6\2\u00df\u00e0\5\13"+
		"\6\2\u00e0\30\3\2\2\2\u00e1\u00e2\5\27\f\2\u00e2\u00e3\t\n\2\2\u00e3\u00e4"+
		"\5\27\f\2\u00e4\u00e5\t\n\2\2\u00e5\u00e6\5\27\f\2\u00e6\u00e7\5\13\6"+
		"\2\u00e7\32\3\2\2\2\u00e8\u00e9\5\27\f\2\u00e9\u00ea\t\3\2\2\u00ea\u00eb"+
		"\5\27\f\2\u00eb\u00ec\t\3\2\2\u00ec\u00ed\5\27\f\2\u00ed\u00ee\5\13\6"+
		"\2\u00ee\34\3\2\2\2\u00ef\u00f0\5\27\f\2\u00f0\u00f1\t\13\2\2\u00f1\u00f2"+
		"\5\27\f\2\u00f2\u00f3\t\13\2\2\u00f3\u00f4\5\27\f\2\u00f4\u00f5\5\13\6"+
		"\2\u00f5\36\3\2\2\2\u00f6\u00f7\7*\2\2\u00f7\u00f8\5\27\f\2\u00f8\u00f9"+
		"\7+\2\2\u00f9\u00fa\t\n\2\2\u00fa\u00fb\5\27\f\2\u00fb\u00fc\t\13\2\2"+
		"\u00fc\u00fd\5\27\f\2\u00fd\u00fe\5\13\6\2\u00fe \3\2\2\2\u00ff\u0104"+
		"\5\31\r\2\u0100\u0104\5\33\16\2\u0101\u0104\5\35\17\2\u0102\u0104\5\37"+
		"\20\2\u0103\u00ff\3\2\2\2\u0103\u0100\3\2\2\2\u0103\u0101\3\2\2\2\u0103"+
		"\u0102\3\2\2\2\u0104\"\3\2\2\2\u0105\u0106\7>\2\2\u0106\u0107\7r\2\2\u0107"+
		"\u0108\7j\2\2\u0108\u0109\7q\2\2\u0109\u010a\7p\2\2\u010a\u010b\7g\2\2"+
		"\u010b\u0114\7@\2\2\u010c\u010d\7>\2\2\u010d\u010e\7R\2\2\u010e\u010f"+
		"\7J\2\2\u010f\u0110\7Q\2\2\u0110\u0111\7P\2\2\u0111\u0112\7G\2\2\u0112"+
		"\u0114\7@\2\2\u0113\u0105\3\2\2\2\u0113\u010c\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u0115\u0126\5!\21\2\u0116\u0117\7>\2\2\u0117\u0118\7\61\2\2\u0118"+
		"\u0119\7r\2\2\u0119\u011a\7j\2\2\u011a\u011b\7q\2\2\u011b\u011c\7p\2\2"+
		"\u011c\u011d\7g\2\2\u011d\u0127\7@\2\2\u011e\u011f\7>\2\2\u011f\u0120"+
		"\7\61\2\2\u0120\u0121\7R\2\2\u0121\u0122\7J\2\2\u0122\u0123\7Q\2\2\u0123"+
		"\u0124\7P\2\2\u0124\u0125\7G\2\2\u0125\u0127\7@\2\2\u0126\u0116\3\2\2"+
		"\2\u0126\u011e\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\b\22\4\2\u0129"+
		"$\3\2\2\2\u012a\u012b\5\13\6\2\u012b\u012c\5\13\6\2\u012c\u012d\5\13\6"+
		"\2\u012d\u012e\5\13\6\2\u012e\u012f\5\13\6\2\u012f\u0130\5\13\6\2\u0130"+
		"\u0131\5\13\6\2\u0131\u0132\5\13\6\2\u0132\u0133\5\13\6\2\u0133\u0134"+
		"\5\13\6\2\u0134\u0135\5\13\6\2\u0135&\3\2\2\2\u0136\u0137\5%\23\2\u0137"+
		"\u0138\5\13\6\2\u0138(\3\2\2\2\u0139\u013a\5\'\24\2\u013a\u013b\5\13\6"+
		"\2\u013b*\3\2\2\2\u013c\u013d\5)\25\2\u013d\u013e\5\13\6\2\u013e,\3\2"+
		"\2\2\u013f\u0140\5+\26\2\u0140\u0141\5\13\6\2\u0141.\3\2\2\2\u0142\u0143"+
		"\5-\27\2\u0143\u0144\5\13\6\2\u0144\60\3\2\2\2\u0145\u0146\7\66\2\2\u0146"+
		"\u014a\5-\27\2\u0147\u0148\7\66\2\2\u0148\u014a\5\'\24\2\u0149\u0145\3"+
		"\2\2\2\u0149\u0147\3\2\2\2\u014a\62\3\2\2\2\u014b\u014c\7\67\2\2\u014c"+
		"\u014d\7\63\2\2\u014d\u014e\3\2\2\2\u014e\u0160\5+\26\2\u014f\u0150\7"+
		"\67\2\2\u0150\u0151\7\64\2\2\u0151\u0152\3\2\2\2\u0152\u0160\5+\26\2\u0153"+
		"\u0154\7\67\2\2\u0154\u0155\7\65\2\2\u0155\u0156\3\2\2\2\u0156\u0160\5"+
		"+\26\2\u0157\u0158\7\67\2\2\u0158\u0159\7\66\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\u0160\5+\26\2\u015b\u015c\7\67\2\2\u015c\u015d\7\67\2\2\u015d\u015e\3"+
		"\2\2\2\u015e\u0160\5+\26\2\u015f\u014b\3\2\2\2\u015f\u014f\3\2\2\2\u015f"+
		"\u0153\3\2\2\2\u015f\u0157\3\2\2\2\u015f\u015b\3\2\2\2\u0160\64\3\2\2"+
		"\2\u0161\u0162\7\65\2\2\u0162\u0163\7\66\2\2\u0163\u0164\3\2\2\2\u0164"+
		"\u016a\5)\25\2\u0165\u0166\7\65\2\2\u0166\u0167\79\2\2\u0167\u0168\3\2"+
		"\2\2\u0168\u016a\5)\25\2\u0169\u0161\3\2\2\2\u0169\u0165\3\2\2\2\u016a"+
		"\66\3\2\2\2\u016b\u016c\7\65\2\2\u016c\u016d\7\62\2\2\u016d\u016e\7\62"+
		"\2\2\u016e\u016f\3\2\2\2\u016f\u0192\5%\23\2\u0170\u0171\7\65\2\2\u0171"+
		"\u0172\7\62\2\2\u0172\u0173\7\63\2\2\u0173\u0174\3\2\2\2\u0174\u0192\5"+
		"%\23\2\u0175\u0176\7\65\2\2\u0176\u0177\7\62\2\2\u0177\u0178\7\64\2\2"+
		"\u0178\u0179\3\2\2\2\u0179\u0192\5%\23\2\u017a\u017b\7\65\2\2\u017b\u017c"+
		"\7\62\2\2\u017c\u017d\7\65\2\2\u017d\u017e\3\2\2\2\u017e\u0192\5%\23\2"+
		"\u017f\u0180\7\65\2\2\u0180\u0181\7\62\2\2\u0181\u0182\7\66\2\2\u0182"+
		"\u0183\3\2\2\2\u0183\u0192\5%\23\2\u0184\u0185\7\65\2\2\u0185\u0186\7"+
		"\62\2\2\u0186\u0187\7\67\2\2\u0187\u0188\3\2\2\2\u0188\u0192\5%\23\2\u0189"+
		"\u018a\7\65\2\2\u018a\u018b\78\2\2\u018b\u018c\3\2\2\2\u018c\u0192\5\'"+
		"\24\2\u018d\u018e\7\65\2\2\u018e\u018f\7:\2\2\u018f\u0190\3\2\2\2\u0190"+
		"\u0192\5\'\24\2\u0191\u016b\3\2\2\2\u0191\u0170\3\2\2\2\u0191\u0175\3"+
		"\2\2\2\u0191\u017a\3\2\2\2\u0191\u017f\3\2\2\2\u0191\u0184\3\2\2\2\u0191"+
		"\u0189\3\2\2\2\u0191\u018d\3\2\2\2\u01928\3\2\2\2\u0193\u0194\78\2\2\u0194"+
		"\u0195\7\62\2\2\u0195\u0196\7\63\2\2\u0196\u0197\7\63\2\2\u0197\u0198"+
		"\3\2\2\2\u0198\u019e\5\'\24\2\u0199\u019a\78\2\2\u019a\u019b\7\67\2\2"+
		"\u019b\u019c\3\2\2\2\u019c\u019e\5+\26\2\u019d\u0193\3\2\2\2\u019d\u0199"+
		"\3\2\2\2\u019e:\3\2\2\2\u019f\u01a0\7\64\2\2\u01a0\u01a1\7\63\2\2\u01a1"+
		"\u01a2\7\65\2\2\u01a2\u01a3\7\63\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01b0\5"+
		"%\23\2\u01a5\u01a6\7\63\2\2\u01a6\u01a7\7:\2\2\u01a7\u01a8\7\62\2\2\u01a8"+
		"\u01a9\7\62\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01b0\5%\23\2\u01ab\u01ac\7"+
		"\65\2\2\u01ac\u01ad\7\67\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b0\5+\26\2\u01af"+
		"\u019f\3\2\2\2\u01af\u01a5\3\2\2\2\u01af\u01ab\3\2\2\2\u01b0<\3\2\2\2"+
		"\u01b1\u01b8\5\61\31\2\u01b2\u01b8\5\63\32\2\u01b3\u01b8\5\65\33\2\u01b4"+
		"\u01b8\5\67\34\2\u01b5\u01b8\59\35\2\u01b6\u01b8\5;\36\2\u01b7\u01b1\3"+
		"\2\2\2\u01b7\u01b2\3\2\2\2\u01b7\u01b3\3\2\2\2\u01b7\u01b4\3\2\2\2\u01b7"+
		"\u01b5\3\2\2\2\u01b7\u01b6\3\2\2\2\u01b8>\3\2\2\2\u01b9\u01ba\7>\2\2\u01ba"+
		"\u01bb\7e\2\2\u01bb\u01bc\7t\2\2\u01bc\u01bd\7g\2\2\u01bd\u01be\7f\2\2"+
		"\u01be\u01bf\7k\2\2\u01bf\u01c0\7v\2\2\u01c0\u01c1\7e\2\2\u01c1\u01c2"+
		"\7c\2\2\u01c2\u01c3\7t\2\2\u01c3\u01c4\7f\2\2\u01c4\u01d2\7@\2\2\u01c5"+
		"\u01c6\7>\2\2\u01c6\u01c7\7E\2\2\u01c7\u01c8\7T\2\2\u01c8\u01c9\7G\2\2"+
		"\u01c9\u01ca\7F\2\2\u01ca\u01cb\7K\2\2\u01cb\u01cc\7V\2\2\u01cc\u01cd"+
		"\7E\2\2\u01cd\u01ce\7C\2\2\u01ce\u01cf\7T\2\2\u01cf\u01d0\7F\2\2\u01d0"+
		"\u01d2\7@\2\2\u01d1\u01b9\3\2\2\2\u01d1\u01c5\3\2\2\2\u01d2\u01d3\3\2"+
		"\2\2\u01d3\u01ee\5=\37\2\u01d4\u01d5\7>\2\2\u01d5\u01d6\7\61\2\2\u01d6"+
		"\u01d7\7e\2\2\u01d7\u01d8\7t\2\2\u01d8\u01d9\7g\2\2\u01d9\u01da\7f\2\2"+
		"\u01da\u01db\7k\2\2\u01db\u01dc\7v\2\2\u01dc\u01dd\7e\2\2\u01dd\u01de"+
		"\7c\2\2\u01de\u01df\7t\2\2\u01df\u01e0\7f\2\2\u01e0\u01ef\7@\2\2\u01e1"+
		"\u01e2\7>\2\2\u01e2\u01e3\7\61\2\2\u01e3\u01e4\7E\2\2\u01e4\u01e5\7T\2"+
		"\2\u01e5\u01e6\7G\2\2\u01e6\u01e7\7F\2\2\u01e7\u01e8\7K\2\2\u01e8\u01e9"+
		"\7V\2\2\u01e9\u01ea\7E\2\2\u01ea\u01eb\7C\2\2\u01eb\u01ec\7T\2\2\u01ec"+
		"\u01ed\7F\2\2\u01ed\u01ef\7@\2\2\u01ee\u01d4\3\2\2\2\u01ee\u01e1\3\2\2"+
		"\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1\b \5\2\u01f1@\3\2\2\2\u01f2\u01f4\t"+
		"\f\2\2\u01f3\u01f5\t\r\2\2\u01f4\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6"+
		"\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7B\3\2\2\2\u01f8\u01fa\t\16\2\2"+
		"\u01f9\u01fb\t\17\2\2\u01fa\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fa"+
		"\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fdD\3\2\2\2\u01fe\u01ff\t\16\2\2\u01ff"+
		"\u0201\t\20\2\2\u0200\u0202\t\21\2\2\u0201\u0200\3\2\2\2\u0202\u0203\3"+
		"\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204F\3\2\2\2\u0205\u0209"+
		"\5A!\2\u0206\u0209\5C\"\2\u0207\u0209\5E#\2\u0208\u0205\3\2\2\2\u0208"+
		"\u0206\3\2\2\2\u0208\u0207\3\2\2\2\u0209H\3\2\2\2\u020a\u020c\t\22\2\2"+
		"\u020b\u020a\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020e"+
		"\3\2\2\2\u020eJ\3\2\2\2\u020f\u0210\7>\2\2\u0210\u0211\5G$\2\u0211\u0212"+
		"\7@\2\2\u0212\u0213\3\2\2\2\u0213\u0214\5I%\2\u0214\u0215\7>\2\2\u0215"+
		"\u0216\7\61\2\2\u0216\u0217\3\2\2\2\u0217\u0218\5G$\2\u0218\u0219\7@\2"+
		"\2\u0219\u021a\3\2\2\2\u021a\u021b\b&\6\2\u021bL\3\2\2\2\u021c\u021e\t"+
		"\23\2\2\u021d\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u021d\3\2\2\2\u021f"+
		"\u0220\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222\b\'\7\2\u0222N\3\2\2\2"+
		"$\2RXZ_djz\u008d\u009c\u00a2\u00ac\u00b2\u00b8\u00c8\u00d9\u0103\u0113"+
		"\u0126\u0149\u015f\u0169\u0191\u019d\u01af\u01b7\u01d1\u01ee\u01f6\u01fc"+
		"\u0203\u0208\u020d\u021f\b\3\5\2\3\13\3\3\22\4\3 \5\3&\6\3\'\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}