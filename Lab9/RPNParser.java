// Generated from RPN.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RPNParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, INT=12, WS=13;
	public static final int
		RULE_start = 0, RULE_expr = 1;
	public static final String[] ruleNames = {
		"start", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", "'>='", "'<='", 
		"'=='", "'!='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"INT", "WS"
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

	@Override
	public String getGrammarFileName() { return "RPN.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    int val = 0;
	    int a = 0;
	    int b = 0;
	    int c = 0;

	public RPNParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(4);
				expr();
				setState(5);
				match(T__0);
				System.out.println("value = " + val); val=0;
				}
				}
				setState(10); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Token INT;
		public List<TerminalNode> INT() { return getTokens(RPNParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(RPNParser.INT, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				((ExprContext)_localctx).INT = match(INT);
				a = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("a = " + a);
				setState(14);
				((ExprContext)_localctx).INT = match(INT);
				b = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("b = " + b);
				setState(16);
				match(T__1);
				val = a + b;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				((ExprContext)_localctx).INT = match(INT);
				a = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("a = " + a);
				setState(20);
				((ExprContext)_localctx).INT = match(INT);
				b = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("b = " + b);
				setState(22);
				match(T__2);
				val = a - b;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
				((ExprContext)_localctx).INT = match(INT);
				a = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("a = " + a);
				setState(26);
				((ExprContext)_localctx).INT = match(INT);
				b = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("b = " + b);
				setState(28);
				match(T__3);
				val = a * b;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(30);
				((ExprContext)_localctx).INT = match(INT);
				a = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("a = " + a);
				setState(32);
				((ExprContext)_localctx).INT = match(INT);
				b = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("b = " + b);
				setState(34);
				match(T__4);
				val = a / b;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				((ExprContext)_localctx).INT = match(INT);
				a = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("a = " + a);
				setState(38);
				((ExprContext)_localctx).INT = match(INT);
				b = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("b = " + b);
				setState(40);
				match(T__5);

				        if(a > b)
				        {
				            val = 1;
				        }
				        else val = 0;
				     
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(42);
				((ExprContext)_localctx).INT = match(INT);
				a = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("a = " + a);
				setState(44);
				((ExprContext)_localctx).INT = match(INT);
				b = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("b = " + b);
				setState(46);
				match(T__6);

				        if(a < b)
				        {
				            val = 1;
				        }
				        else val = 0;
				     
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(48);
				((ExprContext)_localctx).INT = match(INT);
				a = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("a = " + a);
				setState(50);
				((ExprContext)_localctx).INT = match(INT);
				b = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("b = " + b);
				setState(52);
				match(T__7);

				        if(a >= b)
				        {
				            val = 1;
				        }
				        else val = 0;
				     
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(54);
				((ExprContext)_localctx).INT = match(INT);
				a = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("a = " + a);
				setState(56);
				((ExprContext)_localctx).INT = match(INT);
				b = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("b = " + b);
				setState(58);
				match(T__8);

				        if(a <= b)
				        {
				            val = 1;
				        }
				        else val = 0;
				     
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(60);
				((ExprContext)_localctx).INT = match(INT);
				a = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("a = " + a);
				setState(62);
				((ExprContext)_localctx).INT = match(INT);
				b = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("b = " + b);
				setState(64);
				match(T__9);

				        if(a == b)
				        {
				            val = 1;
				        }
				        else val = 0;
				     
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(66);
				((ExprContext)_localctx).INT = match(INT);
				a = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("a = " + a);
				setState(68);
				((ExprContext)_localctx).INT = match(INT);
				b = (((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0); System.out.println("b = " + b);
				setState(70);
				match(T__10);

				        if(a != b)
				        {
				            val = 1;
				        }
				        else val = 0;
				     
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17M\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\2\6\2\13\n\2\r\2\16\2\f\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3K\n\3\3\3\2\2\4\2\4\2\2T\2\n\3\2\2\2\4J\3\2\2\2\6\7\5\4\3\2\7\b\7"+
		"\3\2\2\b\t\b\2\1\2\t\13\3\2\2\2\n\6\3\2\2\2\13\f\3\2\2\2\f\n\3\2\2\2\f"+
		"\r\3\2\2\2\r\3\3\2\2\2\16\17\7\16\2\2\17\20\b\3\1\2\20\21\7\16\2\2\21"+
		"\22\b\3\1\2\22\23\7\4\2\2\23K\b\3\1\2\24\25\7\16\2\2\25\26\b\3\1\2\26"+
		"\27\7\16\2\2\27\30\b\3\1\2\30\31\7\5\2\2\31K\b\3\1\2\32\33\7\16\2\2\33"+
		"\34\b\3\1\2\34\35\7\16\2\2\35\36\b\3\1\2\36\37\7\6\2\2\37K\b\3\1\2 !\7"+
		"\16\2\2!\"\b\3\1\2\"#\7\16\2\2#$\b\3\1\2$%\7\7\2\2%K\b\3\1\2&\'\7\16\2"+
		"\2\'(\b\3\1\2()\7\16\2\2)*\b\3\1\2*+\7\b\2\2+K\b\3\1\2,-\7\16\2\2-.\b"+
		"\3\1\2./\7\16\2\2/\60\b\3\1\2\60\61\7\t\2\2\61K\b\3\1\2\62\63\7\16\2\2"+
		"\63\64\b\3\1\2\64\65\7\16\2\2\65\66\b\3\1\2\66\67\7\n\2\2\67K\b\3\1\2"+
		"89\7\16\2\29:\b\3\1\2:;\7\16\2\2;<\b\3\1\2<=\7\13\2\2=K\b\3\1\2>?\7\16"+
		"\2\2?@\b\3\1\2@A\7\16\2\2AB\b\3\1\2BC\7\f\2\2CK\b\3\1\2DE\7\16\2\2EF\b"+
		"\3\1\2FG\7\16\2\2GH\b\3\1\2HI\7\r\2\2IK\b\3\1\2J\16\3\2\2\2J\24\3\2\2"+
		"\2J\32\3\2\2\2J \3\2\2\2J&\3\2\2\2J,\3\2\2\2J\62\3\2\2\2J8\3\2\2\2J>\3"+
		"\2\2\2JD\3\2\2\2K\5\3\2\2\2\4\fJ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}