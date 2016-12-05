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
	 * Enter a parse tree produced by {@link DrawingBoardParser#param1}.
	 * @param ctx the parse tree
	 */
	void enterParam1(DrawingBoardParser.Param1Context ctx);
	/**
	 * Exit a parse tree produced by {@link DrawingBoardParser#param1}.
	 * @param ctx the parse tree
	 */
	void exitParam1(DrawingBoardParser.Param1Context ctx);
	/**
	 * Enter a parse tree produced by {@link DrawingBoardParser#param2}.
	 * @param ctx the parse tree
	 */
	void enterParam2(DrawingBoardParser.Param2Context ctx);
	/**
	 * Exit a parse tree produced by {@link DrawingBoardParser#param2}.
	 * @param ctx the parse tree
	 */
	void exitParam2(DrawingBoardParser.Param2Context ctx);
	/**
	 * Enter a parse tree produced by {@link DrawingBoardParser#param3}.
	 * @param ctx the parse tree
	 */
	void enterParam3(DrawingBoardParser.Param3Context ctx);
	/**
	 * Exit a parse tree produced by {@link DrawingBoardParser#param3}.
	 * @param ctx the parse tree
	 */
	void exitParam3(DrawingBoardParser.Param3Context ctx);
	/**
	 * Enter a parse tree produced by {@link DrawingBoardParser#param4}.
	 * @param ctx the parse tree
	 */
	void enterParam4(DrawingBoardParser.Param4Context ctx);
	/**
	 * Exit a parse tree produced by {@link DrawingBoardParser#param4}.
	 * @param ctx the parse tree
	 */
	void exitParam4(DrawingBoardParser.Param4Context ctx);
}