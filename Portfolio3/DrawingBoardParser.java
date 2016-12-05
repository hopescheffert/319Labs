// Generated from DrawingBoard.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DrawingBoardParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, COMMANDNAME=2, SHAPE=3, INT=4, WS=5;
	public static final int
		RULE_start = 0, RULE_command = 1, RULE_commandname = 2, RULE_shape = 3, 
		RULE_param1 = 4, RULE_param2 = 5, RULE_param3 = 6, RULE_param4 = 7;
	public static final String[] ruleNames = {
		"start", "command", "commandname", "shape", "param1", "param2", "param3", 
		"param4"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'draw'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "COMMANDNAME", "SHAPE", "INT", "WS"
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
	public String getGrammarFileName() { return "DrawingBoard.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    String name = "";
	    String shape = "";
	    Integer p1 = 0;
	    Integer p2 = 0;
	    Integer p3 = 0;
	    Integer p4 = 0;

	public DrawingBoardParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				{
				setState(16);
				command();
				setState(17);
				match(T__0);
				}

				            String s = "{'command':'" + name + "','shape' :'"+ shape +"','param1':" + p1 +",'param2':"+p2+",'param3':"+ p3 +",'param4':" + p4 +"}";
				            System.out.println(s.replaceAll("'", "\"") + "*");
				            name = "";
				            shape = "";
				            p1 = 0;
				            p2 = 0;
				            p3 = 0;
				            p4 = 0;
				            
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMANDNAME );
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

	public static class CommandContext extends ParserRuleContext {
		public CommandnameContext commandname() {
			return getRuleContext(CommandnameContext.class,0);
		}
		public ShapeContext shape() {
			return getRuleContext(ShapeContext.class,0);
		}
		public Param1Context param1() {
			return getRuleContext(Param1Context.class,0);
		}
		public Param2Context param2() {
			return getRuleContext(Param2Context.class,0);
		}
		public Param3Context param3() {
			return getRuleContext(Param3Context.class,0);
		}
		public Param4Context param4() {
			return getRuleContext(Param4Context.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			commandname();
			setState(26);
			shape();
			setState(27);
			param1();
			setState(28);
			param2();
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(29);
				param3();
				}
				break;
			}
			setState(33);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(32);
				param4();
				}
			}

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

	public static class CommandnameContext extends ParserRuleContext {
		public Token COMMANDNAME;
		public TerminalNode COMMANDNAME() { return getToken(DrawingBoardParser.COMMANDNAME, 0); }
		public CommandnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).enterCommandname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).exitCommandname(this);
		}
	}

	public final CommandnameContext commandname() throws RecognitionException {
		CommandnameContext _localctx = new CommandnameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_commandname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			((CommandnameContext)_localctx).COMMANDNAME = match(COMMANDNAME);

			                    name = (((CommandnameContext)_localctx).COMMANDNAME!=null?((CommandnameContext)_localctx).COMMANDNAME.getText():null);
			                
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

	public static class ShapeContext extends ParserRuleContext {
		public Token SHAPE;
		public TerminalNode SHAPE() { return getToken(DrawingBoardParser.SHAPE, 0); }
		public ShapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).enterShape(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).exitShape(this);
		}
	}

	public final ShapeContext shape() throws RecognitionException {
		ShapeContext _localctx = new ShapeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_shape);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			((ShapeContext)_localctx).SHAPE = match(SHAPE);

			                    shape = (((ShapeContext)_localctx).SHAPE!=null?((ShapeContext)_localctx).SHAPE.getText():null);
			                
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

	public static class Param1Context extends ParserRuleContext {
		public Token INT;
		public TerminalNode INT() { return getToken(DrawingBoardParser.INT, 0); }
		public Param1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).enterParam1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).exitParam1(this);
		}
	}

	public final Param1Context param1() throws RecognitionException {
		Param1Context _localctx = new Param1Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_param1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			((Param1Context)_localctx).INT = match(INT);

			            p1 = (((Param1Context)_localctx).INT!=null?Integer.valueOf(((Param1Context)_localctx).INT.getText()):0);
			        
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

	public static class Param2Context extends ParserRuleContext {
		public Token INT;
		public TerminalNode INT() { return getToken(DrawingBoardParser.INT, 0); }
		public Param2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).enterParam2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).exitParam2(this);
		}
	}

	public final Param2Context param2() throws RecognitionException {
		Param2Context _localctx = new Param2Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_param2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			((Param2Context)_localctx).INT = match(INT);

			            p2 = (((Param2Context)_localctx).INT!=null?Integer.valueOf(((Param2Context)_localctx).INT.getText()):0);
			        
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

	public static class Param3Context extends ParserRuleContext {
		public Token INT;
		public TerminalNode INT() { return getToken(DrawingBoardParser.INT, 0); }
		public Param3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).enterParam3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).exitParam3(this);
		}
	}

	public final Param3Context param3() throws RecognitionException {
		Param3Context _localctx = new Param3Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_param3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			((Param3Context)_localctx).INT = match(INT);

			            p3 = (((Param3Context)_localctx).INT!=null?Integer.valueOf(((Param3Context)_localctx).INT.getText()):0);
			        
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

	public static class Param4Context extends ParserRuleContext {
		public Token INT;
		public TerminalNode INT() { return getToken(DrawingBoardParser.INT, 0); }
		public Param4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param4; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).enterParam4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).exitParam4(this);
		}
	}

	public final Param4Context param4() throws RecognitionException {
		Param4Context _localctx = new Param4Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_param4);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			((Param4Context)_localctx).INT = match(INT);

			            p4 = (((Param4Context)_localctx).INT!=null?Integer.valueOf(((Param4Context)_localctx).INT.getText()):0);
			        
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\78\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\6\2\30\n\2\r\2\16\2\31\3\3\3\3\3\3\3\3\3\3\5\3!\n\3\3\3\5\3$\n\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\2\2\n\2\4\6\b\n\f\16\20\2\2\62\2\27\3\2\2\2\4\33\3\2\2\2\6%\3\2\2\2"+
		"\b(\3\2\2\2\n+\3\2\2\2\f.\3\2\2\2\16\61\3\2\2\2\20\64\3\2\2\2\22\23\5"+
		"\4\3\2\23\24\7\3\2\2\24\25\3\2\2\2\25\26\b\2\1\2\26\30\3\2\2\2\27\22\3"+
		"\2\2\2\30\31\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2\33\34\5"+
		"\6\4\2\34\35\5\b\5\2\35\36\5\n\6\2\36 \5\f\7\2\37!\5\16\b\2 \37\3\2\2"+
		"\2 !\3\2\2\2!#\3\2\2\2\"$\5\20\t\2#\"\3\2\2\2#$\3\2\2\2$\5\3\2\2\2%&\7"+
		"\4\2\2&\'\b\4\1\2\'\7\3\2\2\2()\7\5\2\2)*\b\5\1\2*\t\3\2\2\2+,\7\6\2\2"+
		",-\b\6\1\2-\13\3\2\2\2./\7\6\2\2/\60\b\7\1\2\60\r\3\2\2\2\61\62\7\6\2"+
		"\2\62\63\b\b\1\2\63\17\3\2\2\2\64\65\7\6\2\2\65\66\b\t\1\2\66\21\3\2\2"+
		"\2\5\31 #";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}