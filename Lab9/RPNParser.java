// Generated from RPN.g4 by ANTLR 4.5.3

    import java.util.Stack;

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
		T__9=10, T__10=11, T__11=12, INT=13, WS=14;
	public static final int
		RULE_start = 0, RULE_num = 1, RULE_op = 2;
	public static final String[] ruleNames = {
		"start", "num", "op"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'>'", 
		"'<'", "'>='", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "INT", "WS"
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

	    Stack<Integer> stack = new Stack<Integer>();


	public RPNParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<NumContext> num() {
			return getRuleContexts(NumContext.class);
		}
		public NumContext num(int i) {
			return getRuleContext(NumContext.class,i);
		}
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
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
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(8);
					switch (_input.LA(1)) {
					case INT:
						{
						setState(6);
						num();
						}
						break;
					case T__1:
					case T__2:
					case T__3:
					case T__4:
					case T__5:
					case T__6:
					case T__7:
					case T__8:
					case T__9:
					case T__10:
					case T__11:
						{
						setState(7);
						op();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(10); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << INT))) != 0) );
				setState(12);
				match(T__0);
				System.out.println("value = " + stack.pop()); val=0;
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << INT))) != 0) );
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

	public static class NumContext extends ParserRuleContext {
		public Token INT;
		public TerminalNode INT() { return getToken(RPNParser.INT, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).exitNum(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			((NumContext)_localctx).INT = match(INT);

			            a = (((NumContext)_localctx).INT!=null?Integer.valueOf(((NumContext)_localctx).INT.getText()):0);
			            stack.push(a);
			            System.out.println("stack is " + stack);
			        
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

	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).exitOp(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_op);
		try {
			setState(44);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				match(T__1);

				        val = stack.pop() + stack.pop();
				        stack.push(val);
				        System.out.println("after + evaluation stack is " + stack);
				     
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				match(T__2);

				         a = stack.pop();
				         val = stack.pop() - a;
				         stack.push(val);
				         System.out.println("after - evaluation stack is " + stack);
				      
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				match(T__3);

				          val = stack.pop() * stack.pop();
				          stack.push(val);
				          System.out.println("after * evaluation stack is " + stack);
				       
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(28);
				match(T__4);

				            a = stack.pop();
				            val = stack.pop() / a;
				            stack.push(val);
				           System.out.println("after / evaluation stack is " + stack);
				        
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(30);
				match(T__5);

				            a = stack.pop();
				            val = stack.pop() % a;
				            stack.push(val);
				            System.out.println("after % evaluation stack is " + stack);
				         
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 6);
				{
				setState(32);
				match(T__6);

				            b = stack.pop();
				            a = stack.pop();
				            if(a == b)
				            {
				                val = 1;
				            }
				            else
				            {
				                val = 0;
				            }
				            stack.push(val);
				            System.out.println("after == evaluation stack is " + stack);

				         
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 7);
				{
				setState(34);
				match(T__7);

				            b = stack.pop();
				            a = stack.pop();
				            if(a != b)
				            {
				                val = 1;
				            }
				            else
				            {
				                val = 0;
				            }
				            stack.push(val);
				            System.out.println("after != evaluation stack is " + stack);

				         
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 8);
				{
				setState(36);
				match(T__8);

				            b = stack.pop();
				            a = stack.pop();
				            if(a > b)
				            {
				                val = 1;
				            }
				            else
				            {
				                val = 0;
				            }
				            stack.push(val);
				            System.out.println("after > evaluation stack is " + stack);

				         
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 9);
				{
				setState(38);
				match(T__9);

				            b = stack.pop();
				            a = stack.pop();
				            if(a < b)
				            {
				                val = 1;
				            }
				            else
				            {
				                val = 0;
				            }
				            stack.push(val);
				            System.out.println("after < evaluation stack is " + stack);

				         
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 10);
				{
				setState(40);
				match(T__10);

				            b = stack.pop();
				            a = stack.pop();
				            if(a >= b)
				            {
				                val = 1;
				            }
				            else
				            {
				                val = 0;
				            }
				            stack.push(val);
				            System.out.println("after >= evaluation stack is " + stack);

				         
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 11);
				{
				setState(42);
				match(T__11);

				            b = stack.pop();
				            a = stack.pop();
				            if(a <= b)
				            {
				                val = 1;
				            }
				            else
				            {
				                val = 0;
				            }
				            stack.push(val);
				            System.out.println("after <= evaluation stack is " + stack);

				         
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20\61\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\6\2\13\n\2\r\2\16\2\f\3\2\3\2\3\2\6\2\22\n\2\r\2"+
		"\16\2\23\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4/\n\4\3\4\2\2\5\2\4\6\2\2:\2"+
		"\21\3\2\2\2\4\25\3\2\2\2\6.\3\2\2\2\b\13\5\4\3\2\t\13\5\6\4\2\n\b\3\2"+
		"\2\2\n\t\3\2\2\2\13\f\3\2\2\2\f\n\3\2\2\2\f\r\3\2\2\2\r\16\3\2\2\2\16"+
		"\17\7\3\2\2\17\20\b\2\1\2\20\22\3\2\2\2\21\n\3\2\2\2\22\23\3\2\2\2\23"+
		"\21\3\2\2\2\23\24\3\2\2\2\24\3\3\2\2\2\25\26\7\17\2\2\26\27\b\3\1\2\27"+
		"\5\3\2\2\2\30\31\7\4\2\2\31/\b\4\1\2\32\33\7\5\2\2\33/\b\4\1\2\34\35\7"+
		"\6\2\2\35/\b\4\1\2\36\37\7\7\2\2\37/\b\4\1\2 !\7\b\2\2!/\b\4\1\2\"#\7"+
		"\t\2\2#/\b\4\1\2$%\7\n\2\2%/\b\4\1\2&\'\7\13\2\2\'/\b\4\1\2()\7\f\2\2"+
		")/\b\4\1\2*+\7\r\2\2+/\b\4\1\2,-\7\16\2\2-/\b\4\1\2.\30\3\2\2\2.\32\3"+
		"\2\2\2.\34\3\2\2\2.\36\3\2\2\2. \3\2\2\2.\"\3\2\2\2.$\3\2\2\2.&\3\2\2"+
		"\2.(\3\2\2\2.*\3\2\2\2.,\3\2\2\2/\7\3\2\2\2\6\n\f\23.";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}