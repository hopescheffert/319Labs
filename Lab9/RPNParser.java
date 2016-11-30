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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, INT=16, BOOLEAN=17, 
		WS=18;
	public static final int
		RULE_start = 0, RULE_operand = 1, RULE_operator = 2;
	public static final String[] ruleNames = {
		"start", "operand", "operator"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'>'", 
		"'<'", "'>='", "'<='", "'||'", "'&&'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "INT", "BOOLEAN", "WS"
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
	    boolean bool = false;
	    Stack stack = new Stack();

	public RPNParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
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
					case BOOLEAN:
						{
						setState(6);
						operand();
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
					case T__12:
					case T__13:
					case T__14:
						{
						setState(7);
						operator();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(10); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << INT) | (1L << BOOLEAN))) != 0) );
				setState(12);
				match(T__0);
				System.out.println("answer = " + stack.pop()); val=0;
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << INT) | (1L << BOOLEAN))) != 0) );
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

	public static class OperandContext extends ParserRuleContext {
		public Token INT;
		public Token BOOLEAN;
		public TerminalNode INT() { return getToken(RPNParser.INT, 0); }
		public TerminalNode BOOLEAN() { return getToken(RPNParser.BOOLEAN, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).exitOperand(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_operand);
		try {
			setState(23);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				((OperandContext)_localctx).INT = match(INT);

				            a = (((OperandContext)_localctx).INT!=null?Integer.valueOf(((OperandContext)_localctx).INT.getText()):0);
				            stack.push(a);
				        
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				((OperandContext)_localctx).BOOLEAN = match(BOOLEAN);

				            boolean b;
				            if((((OperandContext)_localctx).BOOLEAN!=null?((OperandContext)_localctx).BOOLEAN.getText():null).equals("true"))
				            {
				                b = true;
				            }
				            else b = false;

				            stack.push(b);
				        
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

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_operator);
		try {
			setState(53);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				match(T__1);

				              if(stack.size() >= 2)
				              {
				                val = (Integer)stack.pop() + (Integer)stack.pop();
				                stack.push(val);
				              }
				              else System.out.println("***We found an extra character, but we will ignore that***");
				            
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				match(T__2);

				                if(stack.size() >= 2)
				                {
				                    a = (Integer) stack.pop();
				                    val = (Integer) stack.pop() - a;
				                    stack.push(val);
				                }
				                else System.out.println("***We found an extra character, but we will ignore that***");
				              
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				match(T__3);

				                 if(stack.size() >= 2)
				                 {
				                    val = (Integer) stack.pop() * (Integer) stack.pop();
				                    stack.push(val);
				                 }
				                 else System.out.println("***We found an extra character, but we will ignore that***");
				               
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(31);
				match(T__4);

				                 if(stack.size() >= 2)
				                 {
				                     a = (Integer) stack.pop();
				                     val = (Integer) stack.pop() / a;
				                     stack.push(val);
				                 }
				                 else System.out.println("***We found an extra character, but we will ignore that***");
				               
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(33);
				match(T__5);

				                   if(stack.size() >= 2)
				                   {
				                      a = (Integer) stack.pop();
				                      val = (Integer) stack.pop() % a;
				                      stack.push(val);
				                   }
				                   else System.out.println("***We found an extra character, but we will ignore that***");
				                 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 6);
				{
				setState(35);
				match(T__6);

				                   if(stack.size() >= 2)
				                   {
				                      b = (Integer) stack.pop();
				                      a = (Integer) stack.pop();
				                      if(a == b)
				                      {
				                          bool = true;
				                      }
				                      else
				                      {
				                          bool = false;
				                      }
				                      stack.push(bool);
				                   }
				                   else System.out.println("***We found an extra character, but we will ignore that***");
				                 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 7);
				{
				setState(37);
				match(T__7);

				                   if(stack.size() >= 2)
				                   {
				                      b = (Integer) stack.pop();
				                      a = (Integer) stack.pop();
				                      if(a != b)
				                      {
				                          bool = true;
				                      }
				                      else
				                      {
				                          bool = false;
				                      }
				                      stack.push(bool);
				                   }
				                   else System.out.println("***We found an extra character, but we will ignore that***");
				                 
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 8);
				{
				setState(39);
				match(T__8);

				                   if(stack.size() >= 2)
				                   {
				                      b = (Integer) stack.pop();
				                      a = (Integer) stack.pop();
				                      if(a > b)
				                      {
				                          bool = true;
				                      }
				                      else
				                      {
				                          bool = false;
				                      }
				                      stack.push(bool);
				                   }
				                   else System.out.println("***We found an extra character, but we will ignore that***");
				                 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 9);
				{
				setState(41);
				match(T__9);

				                   if(stack.size() >= 2)
				                   {
				                      b = (Integer) stack.pop();
				                      a = (Integer) stack.pop();
				                      if(a < b)
				                      {
				                          bool = true;
				                      }
				                      else
				                      {
				                          bool = false;
				                      }
				                      stack.push(bool);
				                   }
				                   else System.out.println("***We found an extra character, but we will ignore that***");
				                 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 10);
				{
				setState(43);
				match(T__10);

				                   if(stack.size() >= 2)
				                   {
				                      b = (Integer) stack.pop();
				                      a = (Integer) stack.pop();
				                      if(a >= b)
				                      {
				                          bool = true;
				                      }
				                      else
				                      {
				                          bool = false;
				                      }
				                      stack.push(bool);
				                   }
				                   else System.out.println("***We found an extra character, but we will ignore that***");
				                 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 11);
				{
				setState(45);
				match(T__11);

				                   if(stack.size() >= 2)
				                   {
				                      b = (Integer) stack.pop();
				                      a = (Integer) stack.pop();
				                      if(a <= b)
				                      {
				                          bool = true;
				                      }
				                      else
				                      {
				                          bool = false;
				                      }
				                      stack.push(bool);
				                   }
				                   else System.out.println("***We found an extra character, but we will ignore that***");
				                 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 12);
				{
				setState(47);
				match(T__12);

				                   if(stack.size() >= 2)
				                   {
				                      boolean tempb = (Boolean) stack.pop();
				                      boolean tempa = (Boolean) stack.pop();
				                      if(tempa || tempb)
				                      {
				                          bool = true;
				                      }
				                      else
				                      {
				                          bool = false;
				                      }
				                      stack.push(bool);
				                   }
				                   else System.out.println("***We found an extra character, but we will ignore that***");
				                 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 13);
				{
				setState(49);
				match(T__13);

				                   if(stack.size() >= 2)
				                   {
				                      boolean tempb = (Boolean) stack.pop();
				                      boolean tempa = (Boolean) stack.pop();
				                      if(tempa && tempb)
				                      {
				                          bool = true;
				                      }
				                      else
				                      {
				                          bool = false;
				                      }
				                      stack.push(bool);
				                   }
				                   else System.out.println("***We found an extra character, but we will ignore that***");
				                 
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 14);
				{
				setState(51);
				match(T__14);

				                   if(stack.size() >= 2)
				                   {
				                      boolean temp = (Boolean) stack.pop();
				                      stack.push(!temp);
				                   }
				                   else System.out.println("***We found an extra character, but we will ignore that***");
				                 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\24:\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\6\2\13\n\2\r\2\16\2\f\3\2\3\2\3\2\6\2\22\n\2\r\2\16"+
		"\2\23\3\3\3\3\3\3\3\3\5\3\32\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\48\n\4\3\4\2\2\5\2\4\6\2\2G\2\21\3\2\2\2\4\31\3\2\2\2\6\67\3\2"+
		"\2\2\b\13\5\4\3\2\t\13\5\6\4\2\n\b\3\2\2\2\n\t\3\2\2\2\13\f\3\2\2\2\f"+
		"\n\3\2\2\2\f\r\3\2\2\2\r\16\3\2\2\2\16\17\7\3\2\2\17\20\b\2\1\2\20\22"+
		"\3\2\2\2\21\n\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\3\3"+
		"\2\2\2\25\26\7\22\2\2\26\32\b\3\1\2\27\30\7\23\2\2\30\32\b\3\1\2\31\25"+
		"\3\2\2\2\31\27\3\2\2\2\32\5\3\2\2\2\33\34\7\4\2\2\348\b\4\1\2\35\36\7"+
		"\5\2\2\368\b\4\1\2\37 \7\6\2\2 8\b\4\1\2!\"\7\7\2\2\"8\b\4\1\2#$\7\b\2"+
		"\2$8\b\4\1\2%&\7\t\2\2&8\b\4\1\2\'(\7\n\2\2(8\b\4\1\2)*\7\13\2\2*8\b\4"+
		"\1\2+,\7\f\2\2,8\b\4\1\2-.\7\r\2\2.8\b\4\1\2/\60\7\16\2\2\608\b\4\1\2"+
		"\61\62\7\17\2\2\628\b\4\1\2\63\64\7\20\2\2\648\b\4\1\2\65\66\7\21\2\2"+
		"\668\b\4\1\2\67\33\3\2\2\2\67\35\3\2\2\2\67\37\3\2\2\2\67!\3\2\2\2\67"+
		"#\3\2\2\2\67%\3\2\2\2\67\'\3\2\2\2\67)\3\2\2\2\67+\3\2\2\2\67-\3\2\2\2"+
		"\67/\3\2\2\2\67\61\3\2\2\2\67\63\3\2\2\2\67\65\3\2\2\28\7\3\2\2\2\7\n"+
		"\f\23\31\67";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}