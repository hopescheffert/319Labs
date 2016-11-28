import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.LexerInterpreter;
import org.antlr.v4.runtime.ParserInterpreter;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.LexerGrammar;

public class TestGrammer {
  public static void main(String[] args) throws IOException{
    if(args.length < 3) {
      System.out.println("usage: java TestGrammer infile grammerfile start\n");
      return;
    }
    String inputFile = args[0];
    String inputGrammerFile = args[1];
    String inputStart = args[2];
    ParseTree t = parse(args[0], args[1], args[2]);
    
  }

  public static ParseTree parse(String fileName,
                              String combinedGrammarFileName,
                              String startRule)
    throws IOException
  {
    final Grammar g = Grammar.load(combinedGrammarFileName);
    LexerInterpreter lexEngine = g.createLexerInterpreter(new ANTLRFileStream(fileName));
    CommonTokenStream tokens = new CommonTokenStream(lexEngine);
    ParserInterpreter parser = g.createParserInterpreter(tokens);
    ParseTree t = parser.parse(g.getRule(startRule).index);
    System.out.println("parse tree: "+t.toStringTree(parser));
    return t;

  }
}
