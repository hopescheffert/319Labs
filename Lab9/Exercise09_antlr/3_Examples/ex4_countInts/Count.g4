/**
 * This is more advanced example.
 * Here some code block that is executed AFTER a parse rule has been
 * matched is shown. (i.e. the @after rule)
 * Also, note the @members rule
 *
 * This matches an INT or INT followed by , INT zero or more times.
 * After every match, we have code blocks incrementing counter
 *
 */
grammar Count;
 	 
@members {  
 	int count = 0;
}
 	 
// PARSE RULE
start
 	@after {System.out.println("Total ints Count is " + count);}
 	 :  INT {count++; }  ( ',' INT    {count++;} )*
 	 ;
 	 
// LEXER RULE
INT : [0-9]+ ;
WS : [ \r\t\n]+ {skip();} ; 
