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
		OP1=8, OP2=9, OP3=10, OP4=11, PHONE=12, PHONEELEMENT=13, XML1=14, XML2=15, 
		XML3=16, XML4=17, XML5=18, XML6=19, XML7=20, XML8=21, XMLSTRING=22, VISA=23, 
		MASTERCARD=24, AMERICANEXP=25, DINERSCLUB=26, DISCOVER=27, JCB=28, CREDITCARD=29, 
		CREDITCARDELEMENT=30, ELEMENTNAME=31, ELEMENTSTRING=32, CUSTOM=33, WS=34;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LOCALPART", "DOMAINPART", "EMAIL", "EMAILELEMENT", "DIGIT", "YEAR", "MONTH", 
		"DAY", "DATE", "DATEELEMENT", "THREENUMS", "OP1", "OP2", "OP3", "OP4", 
		"PHONE", "PHONEELEMENT", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", 
		"SIXTEEN", "XML1", "XML2", "XML3", "XML4", "XML5", "XML6", "XML7", "XML8", 
		"XMLSTRING", "VISA", "MASTERCARD", "AMERICANEXP", "DINERSCLUB", "DISCOVER", 
		"JCB", "CREDITCARD", "CREDITCARDELEMENT", "ELEMENTNAME", "ELEMENTSTRING", 
		"CUSTOM", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "'XML'", "'xML'", "'xmL'", "'xml'", "'XMl'", "'Xml'", "'XmL'", 
		"'xMl'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EMAIL", "EMAILELEMENT", "YEAR", "MONTH", "DAY", "DATE", "DATEELEMENT", 
		"OP1", "OP2", "OP3", "OP4", "PHONE", "PHONEELEMENT", "XML1", "XML2", "XML3", 
		"XML4", "XML5", "XML6", "XML7", "XML8", "XMLSTRING", "VISA", "MASTERCARD", 
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
		case 39:
			CREDITCARDELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 42:
			CUSTOM_action((RuleContext)_localctx, actionIndex);
			break;
		case 43:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2$\u0248\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\6\2]\n\2\r\2\16\2^\3\2\3\2\6\2c\n\2\r\2\16\2d\5\2g\n\2"+
		"\3\3\6\3j\n\3\r\3\16\3k\3\4\6\4o\n\4\r\4\16\4p\3\4\3\4\6\4u\n\4\r\4\16"+
		"\4v\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0087"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5\u009a\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5"+
		"\7\u00a9\n\7\3\b\3\b\3\b\3\b\5\b\u00af\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\5\t\u00b9\n\t\3\n\3\n\6\n\u00bd\n\n\r\n\16\n\u00be\3\n\3\n\6\n\u00c3"+
		"\n\n\r\n\16\n\u00c4\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u00d5\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00e6\n\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u0110\n\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0120\n\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u0133\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\5!"+
		"\u017a\n!\3\"\3\"\3\"\3\"\5\"\u0180\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0196\n#\3$\3$\3$\3$\3$\3$\3$\3$\5$"+
		"\u01a0\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u01c8\n%\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u01d4\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01e6\n\'\3(\3(\3(\3(\3(\3(\5("+
		"\u01ee\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\5)\u0208\n)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0225\n)\3)\3)\3*\6*\u022a\n*"+
		"\r*\16*\u022b\3*\3*\3+\6+\u0231\n+\r+\16+\u0232\3,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3-\6-\u0243\n-\r-\16-\u0244\3-\3-\3k\2.\3\2\5\2\7\3\t"+
		"\4\13\2\r\5\17\6\21\7\23\b\25\t\27\2\31\n\33\13\35\f\37\r!\16#\17%\2\'"+
		"\2)\2+\2-\2/\2\61\20\63\21\65\22\67\239\24;\25=\26?\27A\30C\31E\32G\33"+
		"I\34K\35M\36O\37Q S!U\"W#Y$\3\2\20\13\2##&&(/\62=??C\\aac|\u0080\u0080"+
		"\3\2\60\60\6\2/\60\62;C\\c|\3\2\62;\3\2\63;\3\2\62\64\3\2\62\63\3\2\61"+
		"\61\3\2\"\"\3\2//\n\2\"\"))\60\60C\\aac|~~\u0080\u0080\5\2/\60\62;C|\13"+
		"\2\"#&&(/\62=??C\\aac|\u0080\u0080\5\2\13\f\17\17\"\"\u0274\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3\\\3\2\2\2\5i\3\2\2\2\7n\3"+
		"\2\2\2\t\u0086\3\2\2\2\13\u009d\3\2\2\2\r\u00a8\3\2\2\2\17\u00ae\3\2\2"+
		"\2\21\u00b8\3\2\2\2\23\u00ba\3\2\2\2\25\u00d4\3\2\2\2\27\u00e9\3\2\2\2"+
		"\31\u00ed\3\2\2\2\33\u00f4\3\2\2\2\35\u00fb\3\2\2\2\37\u0102\3\2\2\2!"+
		"\u010f\3\2\2\2#\u011f\3\2\2\2%\u0136\3\2\2\2\'\u0142\3\2\2\2)\u0145\3"+
		"\2\2\2+\u0148\3\2\2\2-\u014b\3\2\2\2/\u014e\3\2\2\2\61\u0151\3\2\2\2\63"+
		"\u0155\3\2\2\2\65\u0159\3\2\2\2\67\u015d\3\2\2\29\u0161\3\2\2\2;\u0165"+
		"\3\2\2\2=\u0169\3\2\2\2?\u016d\3\2\2\2A\u0179\3\2\2\2C\u017f\3\2\2\2E"+
		"\u0195\3\2\2\2G\u019f\3\2\2\2I\u01c7\3\2\2\2K\u01d3\3\2\2\2M\u01e5\3\2"+
		"\2\2O\u01ed\3\2\2\2Q\u0207\3\2\2\2S\u0229\3\2\2\2U\u0230\3\2\2\2W\u0234"+
		"\3\2\2\2Y\u0242\3\2\2\2[]\t\2\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3"+
		"\2\2\2_f\3\2\2\2`b\t\3\2\2ac\t\2\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3"+
		"\2\2\2eg\3\2\2\2f`\3\2\2\2fg\3\2\2\2g\4\3\2\2\2hj\t\4\2\2ih\3\2\2\2jk"+
		"\3\2\2\2kl\3\2\2\2ki\3\2\2\2l\6\3\2\2\2mo\5\3\2\2nm\3\2\2\2op\3\2\2\2"+
		"pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2rt\7B\2\2su\5\5\3\2ts\3\2\2\2uv\3\2\2\2"+
		"vt\3\2\2\2vw\3\2\2\2w\b\3\2\2\2xy\7>\2\2yz\7g\2\2z{\7o\2\2{|\7c\2\2|}"+
		"\7k\2\2}~\7n\2\2~\u0087\7@\2\2\177\u0080\7>\2\2\u0080\u0081\7G\2\2\u0081"+
		"\u0082\7O\2\2\u0082\u0083\7C\2\2\u0083\u0084\7K\2\2\u0084\u0085\7N\2\2"+
		"\u0085\u0087\7@\2\2\u0086x\3\2\2\2\u0086\177\3\2\2\2\u0087\u0088\3\2\2"+
		"\2\u0088\u0099\5\7\4\2\u0089\u008a\7>\2\2\u008a\u008b\7\61\2\2\u008b\u008c"+
		"\7g\2\2\u008c\u008d\7o\2\2\u008d\u008e\7c\2\2\u008e\u008f\7k\2\2\u008f"+
		"\u0090\7n\2\2\u0090\u009a\7@\2\2\u0091\u0092\7>\2\2\u0092\u0093\7\61\2"+
		"\2\u0093\u0094\7G\2\2\u0094\u0095\7O\2\2\u0095\u0096\7C\2\2\u0096\u0097"+
		"\7K\2\2\u0097\u0098\7N\2\2\u0098\u009a\7@\2\2\u0099\u0089\3\2\2\2\u0099"+
		"\u0091\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\b\5\2\2\u009c\n\3\2\2\2"+
		"\u009d\u009e\t\5\2\2\u009e\f\3\2\2\2\u009f\u00a0\7\64\2\2\u00a0\u00a1"+
		"\7\62\2\2\u00a1\u00a2\5\13\6\2\u00a2\u00a3\5\13\6\2\u00a3\u00a9\3\2\2"+
		"\2\u00a4\u00a5\7\64\2\2\u00a5\u00a6\7\63\2\2\u00a6\u00a7\7\62\2\2\u00a7"+
		"\u00a9\7\62\2\2\u00a8\u009f\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a9\16\3\2\2"+
		"\2\u00aa\u00ab\7\62\2\2\u00ab\u00af\t\6\2\2\u00ac\u00ad\7\63\2\2\u00ad"+
		"\u00af\t\7\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\20\3\2\2"+
		"\2\u00b0\u00b1\7\62\2\2\u00b1\u00b9\t\6\2\2\u00b2\u00b3\7\63\2\2\u00b3"+
		"\u00b9\5\13\6\2\u00b4\u00b5\7\64\2\2\u00b5\u00b9\5\13\6\2\u00b6\u00b7"+
		"\7\65\2\2\u00b7\u00b9\t\b\2\2\u00b8\u00b0\3\2\2\2\u00b8\u00b2\3\2\2\2"+
		"\u00b8\u00b4\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\22\3\2\2\2\u00ba\u00bc"+
		"\5\21\t\2\u00bb\u00bd\t\t\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2"+
		"\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2"+
		"\5\17\b\2\u00c1\u00c3\t\t\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2"+
		"\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7"+
		"\5\r\7\2\u00c7\24\3\2\2\2\u00c8\u00c9\7>\2\2\u00c9\u00ca\7f\2\2\u00ca"+
		"\u00cb\7c\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7g\2\2\u00cd\u00d5\7@\2\2"+
		"\u00ce\u00cf\7>\2\2\u00cf\u00d0\7F\2\2\u00d0\u00d1\7C\2\2\u00d1\u00d2"+
		"\7V\2\2\u00d2\u00d3\7G\2\2\u00d3\u00d5\7@\2\2\u00d4\u00c8\3\2\2\2\u00d4"+
		"\u00ce\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00e5\5\23\n\2\u00d7\u00d8\7"+
		">\2\2\u00d8\u00d9\7\61\2\2\u00d9\u00da\7f\2\2\u00da\u00db\7c\2\2\u00db"+
		"\u00dc\7v\2\2\u00dc\u00dd\7g\2\2\u00dd\u00e6\7@\2\2\u00de\u00df\7>\2\2"+
		"\u00df\u00e0\7\61\2\2\u00e0\u00e1\7F\2\2\u00e1\u00e2\7C\2\2\u00e2\u00e3"+
		"\7V\2\2\u00e3\u00e4\7G\2\2\u00e4\u00e6\7@\2\2\u00e5\u00d7\3\2\2\2\u00e5"+
		"\u00de\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\b\13\3\2\u00e8\26\3\2\2"+
		"\2\u00e9\u00ea\5\13\6\2\u00ea\u00eb\5\13\6\2\u00eb\u00ec\5\13\6\2\u00ec"+
		"\30\3\2\2\2\u00ed\u00ee\5\27\f\2\u00ee\u00ef\t\n\2\2\u00ef\u00f0\5\27"+
		"\f\2\u00f0\u00f1\t\n\2\2\u00f1\u00f2\5\27\f\2\u00f2\u00f3\5\13\6\2\u00f3"+
		"\32\3\2\2\2\u00f4\u00f5\5\27\f\2\u00f5\u00f6\t\3\2\2\u00f6\u00f7\5\27"+
		"\f\2\u00f7\u00f8\t\3\2\2\u00f8\u00f9\5\27\f\2\u00f9\u00fa\5\13\6\2\u00fa"+
		"\34\3\2\2\2\u00fb\u00fc\5\27\f\2\u00fc\u00fd\t\13\2\2\u00fd\u00fe\5\27"+
		"\f\2\u00fe\u00ff\t\13\2\2\u00ff\u0100\5\27\f\2\u0100\u0101\5\13\6\2\u0101"+
		"\36\3\2\2\2\u0102\u0103\7*\2\2\u0103\u0104\5\27\f\2\u0104\u0105\7+\2\2"+
		"\u0105\u0106\t\n\2\2\u0106\u0107\5\27\f\2\u0107\u0108\t\13\2\2\u0108\u0109"+
		"\5\27\f\2\u0109\u010a\5\13\6\2\u010a \3\2\2\2\u010b\u0110\5\31\r\2\u010c"+
		"\u0110\5\33\16\2\u010d\u0110\5\35\17\2\u010e\u0110\5\37\20\2\u010f\u010b"+
		"\3\2\2\2\u010f\u010c\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2\2\2\u0110"+
		"\"\3\2\2\2\u0111\u0112\7>\2\2\u0112\u0113\7r\2\2\u0113\u0114\7j\2\2\u0114"+
		"\u0115\7q\2\2\u0115\u0116\7p\2\2\u0116\u0117\7g\2\2\u0117\u0120\7@\2\2"+
		"\u0118\u0119\7>\2\2\u0119\u011a\7R\2\2\u011a\u011b\7J\2\2\u011b\u011c"+
		"\7Q\2\2\u011c\u011d\7P\2\2\u011d\u011e\7G\2\2\u011e\u0120\7@\2\2\u011f"+
		"\u0111\3\2\2\2\u011f\u0118\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0132\5!"+
		"\21\2\u0122\u0123\7>\2\2\u0123\u0124\7\61\2\2\u0124\u0125\7r\2\2\u0125"+
		"\u0126\7j\2\2\u0126\u0127\7q\2\2\u0127\u0128\7p\2\2\u0128\u0129\7g\2\2"+
		"\u0129\u0133\7@\2\2\u012a\u012b\7>\2\2\u012b\u012c\7\61\2\2\u012c\u012d"+
		"\7R\2\2\u012d\u012e\7J\2\2\u012e\u012f\7Q\2\2\u012f\u0130\7P\2\2\u0130"+
		"\u0131\7G\2\2\u0131\u0133\7@\2\2\u0132\u0122\3\2\2\2\u0132\u012a\3\2\2"+
		"\2\u0133\u0134\3\2\2\2\u0134\u0135\b\22\4\2\u0135$\3\2\2\2\u0136\u0137"+
		"\5\13\6\2\u0137\u0138\5\13\6\2\u0138\u0139\5\13\6\2\u0139\u013a\5\13\6"+
		"\2\u013a\u013b\5\13\6\2\u013b\u013c\5\13\6\2\u013c\u013d\5\13\6\2\u013d"+
		"\u013e\5\13\6\2\u013e\u013f\5\13\6\2\u013f\u0140\5\13\6\2\u0140\u0141"+
		"\5\13\6\2\u0141&\3\2\2\2\u0142\u0143\5%\23\2\u0143\u0144\5\13\6\2\u0144"+
		"(\3\2\2\2\u0145\u0146\5\'\24\2\u0146\u0147\5\13\6\2\u0147*\3\2\2\2\u0148"+
		"\u0149\5)\25\2\u0149\u014a\5\13\6\2\u014a,\3\2\2\2\u014b\u014c\5+\26\2"+
		"\u014c\u014d\5\13\6\2\u014d.\3\2\2\2\u014e\u014f\5-\27\2\u014f\u0150\5"+
		"\13\6\2\u0150\60\3\2\2\2\u0151\u0152\7Z\2\2\u0152\u0153\7O\2\2\u0153\u0154"+
		"\7N\2\2\u0154\62\3\2\2\2\u0155\u0156\7z\2\2\u0156\u0157\7O\2\2\u0157\u0158"+
		"\7N\2\2\u0158\64\3\2\2\2\u0159\u015a\7z\2\2\u015a\u015b\7o\2\2\u015b\u015c"+
		"\7N\2\2\u015c\66\3\2\2\2\u015d\u015e\7z\2\2\u015e\u015f\7o\2\2\u015f\u0160"+
		"\7n\2\2\u01608\3\2\2\2\u0161\u0162\7Z\2\2\u0162\u0163\7O\2\2\u0163\u0164"+
		"\7n\2\2\u0164:\3\2\2\2\u0165\u0166\7Z\2\2\u0166\u0167\7o\2\2\u0167\u0168"+
		"\7n\2\2\u0168<\3\2\2\2\u0169\u016a\7Z\2\2\u016a\u016b\7o\2\2\u016b\u016c"+
		"\7N\2\2\u016c>\3\2\2\2\u016d\u016e\7z\2\2\u016e\u016f\7O\2\2\u016f\u0170"+
		"\7n\2\2\u0170@\3\2\2\2\u0171\u017a\5\61\31\2\u0172\u017a\5\63\32\2\u0173"+
		"\u017a\5\65\33\2\u0174\u017a\5\67\34\2\u0175\u017a\59\35\2\u0176\u017a"+
		"\5;\36\2\u0177\u017a\5=\37\2\u0178\u017a\5? \2\u0179\u0171\3\2\2\2\u0179"+
		"\u0172\3\2\2\2\u0179\u0173\3\2\2\2\u0179\u0174\3\2\2\2\u0179\u0175\3\2"+
		"\2\2\u0179\u0176\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u0178\3\2\2\2\u017a"+
		"B\3\2\2\2\u017b\u017c\7\66\2\2\u017c\u0180\5-\27\2\u017d\u017e\7\66\2"+
		"\2\u017e\u0180\5\'\24\2\u017f\u017b\3\2\2\2\u017f\u017d\3\2\2\2\u0180"+
		"D\3\2\2\2\u0181\u0182\7\67\2\2\u0182\u0183\7\63\2\2\u0183\u0184\3\2\2"+
		"\2\u0184\u0196\5+\26\2\u0185\u0186\7\67\2\2\u0186\u0187\7\64\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u0196\5+\26\2\u0189\u018a\7\67\2\2\u018a\u018b\7"+
		"\65\2\2\u018b\u018c\3\2\2\2\u018c\u0196\5+\26\2\u018d\u018e\7\67\2\2\u018e"+
		"\u018f\7\66\2\2\u018f\u0190\3\2\2\2\u0190\u0196\5+\26\2\u0191\u0192\7"+
		"\67\2\2\u0192\u0193\7\67\2\2\u0193\u0194\3\2\2\2\u0194\u0196\5+\26\2\u0195"+
		"\u0181\3\2\2\2\u0195\u0185\3\2\2\2\u0195\u0189\3\2\2\2\u0195\u018d\3\2"+
		"\2\2\u0195\u0191\3\2\2\2\u0196F\3\2\2\2\u0197\u0198\7\65\2\2\u0198\u0199"+
		"\7\66\2\2\u0199\u019a\3\2\2\2\u019a\u01a0\5)\25\2\u019b\u019c\7\65\2\2"+
		"\u019c\u019d\79\2\2\u019d\u019e\3\2\2\2\u019e\u01a0\5)\25\2\u019f\u0197"+
		"\3\2\2\2\u019f\u019b\3\2\2\2\u01a0H\3\2\2\2\u01a1\u01a2\7\65\2\2\u01a2"+
		"\u01a3\7\62\2\2\u01a3\u01a4\7\62\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01c8\5"+
		"%\23\2\u01a6\u01a7\7\65\2\2\u01a7\u01a8\7\62\2\2\u01a8\u01a9\7\63\2\2"+
		"\u01a9\u01aa\3\2\2\2\u01aa\u01c8\5%\23\2\u01ab\u01ac\7\65\2\2\u01ac\u01ad"+
		"\7\62\2\2\u01ad\u01ae\7\64\2\2\u01ae\u01af\3\2\2\2\u01af\u01c8\5%\23\2"+
		"\u01b0\u01b1\7\65\2\2\u01b1\u01b2\7\62\2\2\u01b2\u01b3\7\65\2\2\u01b3"+
		"\u01b4\3\2\2\2\u01b4\u01c8\5%\23\2\u01b5\u01b6\7\65\2\2\u01b6\u01b7\7"+
		"\62\2\2\u01b7\u01b8\7\66\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01c8\5%\23\2\u01ba"+
		"\u01bb\7\65\2\2\u01bb\u01bc\7\62\2\2\u01bc\u01bd\7\67\2\2\u01bd\u01be"+
		"\3\2\2\2\u01be\u01c8\5%\23\2\u01bf\u01c0\7\65\2\2\u01c0\u01c1\78\2\2\u01c1"+
		"\u01c2\3\2\2\2\u01c2\u01c8\5\'\24\2\u01c3\u01c4\7\65\2\2\u01c4\u01c5\7"+
		":\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c8\5\'\24\2\u01c7\u01a1\3\2\2\2\u01c7"+
		"\u01a6\3\2\2\2\u01c7\u01ab\3\2\2\2\u01c7\u01b0\3\2\2\2\u01c7\u01b5\3\2"+
		"\2\2\u01c7\u01ba\3\2\2\2\u01c7\u01bf\3\2\2\2\u01c7\u01c3\3\2\2\2\u01c8"+
		"J\3\2\2\2\u01c9\u01ca\78\2\2\u01ca\u01cb\7\62\2\2\u01cb\u01cc\7\63\2\2"+
		"\u01cc\u01cd\7\63\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d4\5\'\24\2\u01cf\u01d0"+
		"\78\2\2\u01d0\u01d1\7\67\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d4\5+\26\2\u01d3"+
		"\u01c9\3\2\2\2\u01d3\u01cf\3\2\2\2\u01d4L\3\2\2\2\u01d5\u01d6\7\64\2\2"+
		"\u01d6\u01d7\7\63\2\2\u01d7\u01d8\7\65\2\2\u01d8\u01d9\7\63\2\2\u01d9"+
		"\u01da\3\2\2\2\u01da\u01e6\5%\23\2\u01db\u01dc\7\63\2\2\u01dc\u01dd\7"+
		":\2\2\u01dd\u01de\7\62\2\2\u01de\u01df\7\62\2\2\u01df\u01e0\3\2\2\2\u01e0"+
		"\u01e6\5%\23\2\u01e1\u01e2\7\65\2\2\u01e2\u01e3\7\67\2\2\u01e3\u01e4\3"+
		"\2\2\2\u01e4\u01e6\5+\26\2\u01e5\u01d5\3\2\2\2\u01e5\u01db\3\2\2\2\u01e5"+
		"\u01e1\3\2\2\2\u01e6N\3\2\2\2\u01e7\u01ee\5C\"\2\u01e8\u01ee\5E#\2\u01e9"+
		"\u01ee\5G$\2\u01ea\u01ee\5I%\2\u01eb\u01ee\5K&\2\u01ec\u01ee\5M\'\2\u01ed"+
		"\u01e7\3\2\2\2\u01ed\u01e8\3\2\2\2\u01ed\u01e9\3\2\2\2\u01ed\u01ea\3\2"+
		"\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ec\3\2\2\2\u01eeP\3\2\2\2\u01ef\u01f0"+
		"\7>\2\2\u01f0\u01f1\7e\2\2\u01f1\u01f2\7t\2\2\u01f2\u01f3\7g\2\2\u01f3"+
		"\u01f4\7f\2\2\u01f4\u01f5\7k\2\2\u01f5\u01f6\7v\2\2\u01f6\u01f7\7e\2\2"+
		"\u01f7\u01f8\7c\2\2\u01f8\u01f9\7t\2\2\u01f9\u01fa\7f\2\2\u01fa\u0208"+
		"\7@\2\2\u01fb\u01fc\7>\2\2\u01fc\u01fd\7E\2\2\u01fd\u01fe\7T\2\2\u01fe"+
		"\u01ff\7G\2\2\u01ff\u0200\7F\2\2\u0200\u0201\7K\2\2\u0201\u0202\7V\2\2"+
		"\u0202\u0203\7E\2\2\u0203\u0204\7C\2\2\u0204\u0205\7T\2\2\u0205\u0206"+
		"\7F\2\2\u0206\u0208\7@\2\2\u0207\u01ef\3\2\2\2\u0207\u01fb\3\2\2\2\u0208"+
		"\u0209\3\2\2\2\u0209\u0224\5O(\2\u020a\u020b\7>\2\2\u020b\u020c\7\61\2"+
		"\2\u020c\u020d\7e\2\2\u020d\u020e\7t\2\2\u020e\u020f\7g\2\2\u020f\u0210"+
		"\7f\2\2\u0210\u0211\7k\2\2\u0211\u0212\7v\2\2\u0212\u0213\7e\2\2\u0213"+
		"\u0214\7c\2\2\u0214\u0215\7t\2\2\u0215\u0216\7f\2\2\u0216\u0225\7@\2\2"+
		"\u0217\u0218\7>\2\2\u0218\u0219\7\61\2\2\u0219\u021a\7E\2\2\u021a\u021b"+
		"\7T\2\2\u021b\u021c\7G\2\2\u021c\u021d\7F\2\2\u021d\u021e\7K\2\2\u021e"+
		"\u021f\7V\2\2\u021f\u0220\7E\2\2\u0220\u0221\7C\2\2\u0221\u0222\7T\2\2"+
		"\u0222\u0223\7F\2\2\u0223\u0225\7@\2\2\u0224\u020a\3\2\2\2\u0224\u0217"+
		"\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0227\b)\5\2\u0227R\3\2\2\2\u0228\u022a"+
		"\t\f\2\2\u0229\u0228\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u0229\3\2\2\2\u022b"+
		"\u022c\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022e\t\r\2\2\u022eT\3\2\2\2"+
		"\u022f\u0231\t\16\2\2\u0230\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0230"+
		"\3\2\2\2\u0232\u0233\3\2\2\2\u0233V\3\2\2\2\u0234\u0235\7>\2\2\u0235\u0236"+
		"\5S*\2\u0236\u0237\7@\2\2\u0237\u0238\3\2\2\2\u0238\u0239\5U+\2\u0239"+
		"\u023a\7>\2\2\u023a\u023b\7\61\2\2\u023b\u023c\3\2\2\2\u023c\u023d\5S"+
		"*\2\u023d\u023e\7@\2\2\u023e\u023f\3\2\2\2\u023f\u0240\b,\6\2\u0240X\3"+
		"\2\2\2\u0241\u0243\t\17\2\2\u0242\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244"+
		"\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0247\b-"+
		"\7\2\u0247Z\3\2\2\2\"\2^dfkpv\u0086\u0099\u00a8\u00ae\u00b8\u00be\u00c4"+
		"\u00d4\u00e5\u010f\u011f\u0132\u0179\u017f\u0195\u019f\u01c7\u01d3\u01e5"+
		"\u01ed\u0207\u0224\u022b\u0232\u0244\b\3\5\2\3\13\3\3\22\4\3)\5\3,\6\3"+
		"-\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}