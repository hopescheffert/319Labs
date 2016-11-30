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
	 * Enter a parse tree produced by {@link RPNParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(RPNParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPNParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(RPNParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RPNParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(RPNParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPNParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(RPNParser.OperatorContext ctx);
}