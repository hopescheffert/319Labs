/**
 * Another expression parser. In this case, it parses LOGICAL
 * expressions such as (abc && def).
 * Do note what syntax errors happen for the given input in 
 * SimpleBoolean.in
 */
grammar SimpleBoolean;

// LEXER RULES
//the grammar must contain at least one lexer rule
LPAREN : '(' ;
RPAREN : ')' ;
AND : '&&';
OR : '||';
NOT : '!';
NAME : ('a'..'z' | '0'..'9')+; 
WS : ( ' ' | '\t' | '\r' | '\n' )+   {skip();};

// PARSER RULES

//start rule
start : (andexpression ';')+ ;
andexpression : orexpression (AND orexpression)*;
orexpression : notexpression (OR notexpression)*;
notexpression : NOT atom | atom;
atom : NAME | LPAREN andexpression RPAREN;
