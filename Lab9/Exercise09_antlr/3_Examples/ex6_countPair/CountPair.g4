/**
 * This is more advanced example.
 * Here some code block that is executed AFTER a parse rule has been
 * matched is shown. (i.e. the @after rule)
 * Also, note the @members rule
 *
 * This matches int tuples
 * After every match, we have code blocks incrementing counter
 *
 * CREATE YOUR OWN CountPair.in file!
 */
grammar CountPair;
 	 
@members {
 	int count = 0;
}
 	 
// PARSE RULE
start 
 	@after {System.out.println("Total pair Count is " + count);}
 	 :  pair +
 	 ;

pair 
 	@after {count++;
    System.out.println("Found pair: ");  }
     : '(' 
       word {System.out.print("found word: " + $word.text);}   
       ':'
       integer {System.out.println(" found number:" + $integer.text);} 
       ')'
     ;

word : WORD; 

integer : INT;
 	 
// LEXER RULE
WORD: [a-z]+;
INT : [0-9]+ ;
WS : [ \r\t\n]+ {skip();} ; 

