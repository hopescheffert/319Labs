lexer grammar E5_Romans;
// 1. Only allows I, V, X, and L. NOT C, M etc
// 2. watch @lexer::members how it is used to set some variable
// 3. cannot put action in fragment
// 4. note how actions (or java commands) can be put after each lexical
//    match
// 5. This does not work properly... still a work in progress...
// using lex (unix tool) - this was easy!
// harder in antlr apparently!

@lexer::members {
  int total = 0;
}

fragment ONE: 'I' ;
fragment FOUR: 'IV' ;
fragment FIVE: 'V' ;
fragment NINE: 'IX' ;
fragment TEN: 'X'	;
fragment FORTY: 'XL' ;
fragment FIFTY: 'L' ;

fragment ROMAN_BASE: ONE | FOUR | FIVE | NINE | TEN | FORTY | FIFTY;

ROMAN: ( ROMAN_BASE ) {  
          if (getText().equals("I")) total += 1;
          else if (getText().equals("IV")) total += 4;
          else if (getText().equals("V")) total += 5;
          else if (getText().equals("IX")) total += 9;
          else if (getText().equals("X")) total += 10;
          else if (getText().equals("XL")) total += 40;
          else if (getText().equals("L")) total += 50;
          System.out.print("["+getText()+"]");
       } ;

WS:  [ \t]+ ; 

NEWLINE: '\n' {
      System.out.println("\n" + total);
      total = 0;
    };

