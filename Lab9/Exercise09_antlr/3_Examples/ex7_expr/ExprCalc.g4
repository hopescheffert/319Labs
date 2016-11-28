
grammar ExprCalc;		


// PARSER RULES
start:	(expr {System.out.println("******* ANSWER = "+$expr.value);} NEWLINE)* EOF ;
expr returns [long value]
    @after {
       System.out.println("after: " + $value);
    }
    :	
      a=expr '*' b=expr  {$value = $a.value * $b.value;}
    | a=expr '/' b=expr  {$value = $a.value / $b.value;}
    | a=expr '+' b=expr  {$value = $a.value + $b.value;}
    | a=expr '-' b=expr  {$value = $a.value - $b.value;}
    |	INT {$value = Integer.parseInt($INT.text);}
    |	'(' a=expr {$value = $a.value;} ')'
    ;

// LEXER RULES
NEWLINE : ['\r''\n']+ ;
INT     : [0-9]+ ;
WS      : [' ' '\t']+ {skip();};
