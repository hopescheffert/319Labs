// THINGS TO NOTE:
// READ ALL THE SIX COMMENTS!
// 1. name of grammer and name of file matches.
// 2. lexer rule name is in capitals (if starts in lowercase, it is
//    considered to be parser rule.

lexer grammar E1_Hello;  // 3. do not forget semicolons!

HELLO: 'hello' {System.out.println("matching HELLO rule:" + getText());}
; 
// 4. note that you can put java code in { } 
// 5. getText() gives you the token that was just found!

WS: [ \r\t\n]+ {System.out.println("matching WS rule");skip();};
// 6. skip() is used to ignore the token and go on to reading the next
// token.
