// Generated from RPN.g4 by ANTLR 4.5.3

    import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RPNParser}.
 */
public interface RPNListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RPNParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(RPNParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPNParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(RPNParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link RPNParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(RPNParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPNParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(RPNParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link RPNParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(RPNParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPNParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(RPNParser.OpContext ctx);
}