// Generated from HelloWorld.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloWorldParser}.
 */
public interface HelloWorldListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloWorldParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(HelloWorldParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloWorldParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(HelloWorldParser.StartContext ctx);
}