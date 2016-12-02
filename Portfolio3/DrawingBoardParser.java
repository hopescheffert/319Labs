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
		RULE_paramx = 4, RULE_paramy = 5, RULE_paramr = 6;
	public static final String[] ruleNames = {
		"start", "command", "commandname", "shape", "paramx", "paramy", "paramr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'"
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
	    Integer x = 0;
	    Integer y = 0;
	    Integer r = 0;

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
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				{
				setState(14);
				command();
				setState(15);
				match(T__0);
				}

				            //System.out.println(name  + " " + shape + " " + x + " " + y + " " + r);
				            String s = "{'command': '" + name + "', 'shape' : '"+ shape +"', 'paramx': " + x +", 'paramy': "+y+", 'paramr': "+ r +"}*";
				            System.out.println(s.replaceAll("'", "\""));
				            name = "";
				            String shape = "";
				            Integer x = 0;
				            Integer y = 0;
				            Integer r = 0;
				            
				}
				}
				setState(21); 
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
		public ParamxContext paramx() {
			return getRuleContext(ParamxContext.class,0);
		}
		public ParamyContext paramy() {
			return getRuleContext(ParamyContext.class,0);
		}
		public ParamrContext paramr() {
			return getRuleContext(ParamrContext.class,0);
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
			setState(23);
			commandname();
			setState(24);
			shape();
			setState(25);
			paramx();
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(26);
				paramy();
				}
				break;
			}
			setState(30);
			_la = _input.LA(1);
			if (_la==INT) {
				{
				setState(29);
				paramr();
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
			setState(32);
			((CommandnameContext)_localctx).COMMANDNAME = match(COMMANDNAME);

			                    name = (((CommandnameContext)_localctx).COMMANDNAME!=null?((CommandnameContext)_localctx).COMMANDNAME.getText():null);
			                    //System.out.println("command name: " + name);
			                
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
			setState(35);
			((ShapeContext)_localctx).SHAPE = match(SHAPE);

			                    shape = (((ShapeContext)_localctx).SHAPE!=null?((ShapeContext)_localctx).SHAPE.getText():null);
			                    //System.out.println("command shape: " + shape);
			                
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

	public static class ParamxContext extends ParserRuleContext {
		public Token INT;
		public TerminalNode INT() { return getToken(DrawingBoardParser.INT, 0); }
		public ParamxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramx; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).enterParamx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).exitParamx(this);
		}
	}

	public final ParamxContext paramx() throws RecognitionException {
		ParamxContext _localctx = new ParamxContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_paramx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			((ParamxContext)_localctx).INT = match(INT);

			            x = (((ParamxContext)_localctx).INT!=null?Integer.valueOf(((ParamxContext)_localctx).INT.getText()):0);
			            //System.out.println("shape x: " + x);

			        
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

	public static class ParamyContext extends ParserRuleContext {
		public Token INT;
		public TerminalNode INT() { return getToken(DrawingBoardParser.INT, 0); }
		public ParamyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).enterParamy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).exitParamy(this);
		}
	}

	public final ParamyContext paramy() throws RecognitionException {
		ParamyContext _localctx = new ParamyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_paramy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			((ParamyContext)_localctx).INT = match(INT);

			            y = (((ParamyContext)_localctx).INT!=null?Integer.valueOf(((ParamyContext)_localctx).INT.getText()):0);
			            //System.out.println("shape y: " + y);

			        
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

	public static class ParamrContext extends ParserRuleContext {
		public Token INT;
		public TerminalNode INT() { return getToken(DrawingBoardParser.INT, 0); }
		public ParamrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).enterParamr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DrawingBoardListener ) ((DrawingBoardListener)listener).exitParamr(this);
		}
	}

	public final ParamrContext paramr() throws RecognitionException {
		ParamrContext _localctx = new ParamrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_paramr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			((ParamrContext)_localctx).INT = match(INT);

			            r = (((ParamrContext)_localctx).INT!=null?Integer.valueOf(((ParamrContext)_localctx).INT.getText()):0);
			            //System.out.println("shape radius: " + r);

			        
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\7\62\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\6\2\26"+
		"\n\2\r\2\16\2\27\3\3\3\3\3\3\3\3\5\3\36\n\3\3\3\5\3!\n\3\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\2\2\t\2\4\6\b\n\f\16"+
		"\2\2-\2\25\3\2\2\2\4\31\3\2\2\2\6\"\3\2\2\2\b%\3\2\2\2\n(\3\2\2\2\f+\3"+
		"\2\2\2\16.\3\2\2\2\20\21\5\4\3\2\21\22\7\3\2\2\22\23\3\2\2\2\23\24\b\2"+
		"\1\2\24\26\3\2\2\2\25\20\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2\2\27\30\3\2"+
		"\2\2\30\3\3\2\2\2\31\32\5\6\4\2\32\33\5\b\5\2\33\35\5\n\6\2\34\36\5\f"+
		"\7\2\35\34\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37!\5\16\b\2 \37\3\2\2\2"+
		" !\3\2\2\2!\5\3\2\2\2\"#\7\4\2\2#$\b\4\1\2$\7\3\2\2\2%&\7\5\2\2&\'\b\5"+
		"\1\2\'\t\3\2\2\2()\7\6\2\2)*\b\6\1\2*\13\3\2\2\2+,\7\6\2\2,-\b\7\1\2-"+
		"\r\3\2\2\2./\7\6\2\2/\60\b\b\1\2\60\17\3\2\2\2\5\27\35 ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}