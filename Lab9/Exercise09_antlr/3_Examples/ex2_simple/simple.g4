/**
 * In this example, some action is taken during parsing!
 * The getText() method returns the "token value" that is read
 * by the lexer.
 * The skip() method is used to skip tokens 
 * Observe that the input "." has been used to EXIT the entire
 * parser/lexer!
 */
grammar simple;


// PARSER RULES
start 	:	stat NEWLINE + ;

stat	:	ALPHA  | NUMERIC  | EXIT ;


// LEXER RULES
ALPHA   : ('a'..'z'|'A'..'Z')+
        { System.out.println("Found alpha: "+getText()); }
        ;

NUMERIC : ('0'..'9')+
        { System.out.println("Found numeric: "+getText()); }
        ; 

EXIT    : '.' { System.out.println("EXITING!"); System.exit(0); } ;

NEWLINE:'\r'? '\n' ;

WS  :   (' '|'\t')+ {skip();} ;

