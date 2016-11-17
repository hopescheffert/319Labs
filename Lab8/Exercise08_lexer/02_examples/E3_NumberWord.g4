
lexer grammar E3_NumberWord;

fragment DIGIT: [0123456789];
NUMBER: DIGIT+ { System.out.println("found number: " + getText()); };

WORD: ALPHA ( ALPHA | DIGIT )*
       {
         System.out.println("found word: " + getText()); 
       };
fragment ALPHA: [a-zA-Z] ;
    

// 1. fragment keyword in front on lexical rule means that
//    rule can now be used in OTHER lexical rules! see how
//    NUMBER rule uses the fragment rule DIGIT!
// 2. The placement of fragment rule does not really matter.
//    It could be after the place where it is used.


