// Generated from DrawingBoard.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DrawingBoardParser}.
 */
public interface DrawingBoardListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DrawingBoardParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(DrawingBoardParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DrawingBoardParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(DrawingBoardParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DrawingBoardParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(DrawingBoardParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link DrawingBoardParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(DrawingBoardParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link DrawingBoardParser#commandname}.
	 * @param ctx the parse tree
	 */
	void enterCommandname(DrawingBoardParser.CommandnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DrawingBoardParser#commandname}.
	 * @param ctx the parse tree
	 */
	void exitCommandname(DrawingBoardParser.CommandnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DrawingBoardParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShape(DrawingBoardParser.ShapeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DrawingBoardParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShape(DrawingBoardParser.ShapeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DrawingBoardParser#paramx}.
	 * @param ctx the parse tree
	 */
	void enterParamx(DrawingBoardParser.ParamxContext ctx);
	/**
	 * Exit a parse tree produced by {@link DrawingBoardParser#paramx}.
	 * @param ctx the parse tree
	 */
	void exitParamx(DrawingBoardParser.ParamxContext ctx);
	/**
	 * Enter a parse tree produced by {@link DrawingBoardParser#paramy}.
	 * @param ctx the parse tree
	 */
	void enterParamy(DrawingBoardParser.ParamyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DrawingBoardParser#paramy}.
	 * @param ctx the parse tree
	 */
	void exitParamy(DrawingBoardParser.ParamyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DrawingBoardParser#paramr}.
	 * @param ctx the parse tree
	 */
	void enterParamr(DrawingBoardParser.ParamrContext ctx);
	/**
	 * Exit a parse tree produced by {@link DrawingBoardParser#paramr}.
	 * @param ctx the parse tree
	 */
	void exitParamr(DrawingBoardParser.ParamrContext ctx);
}