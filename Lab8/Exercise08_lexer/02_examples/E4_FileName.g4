lexer grammar E4_FileName;

fragment OKCHAR: [a-zA-Z0-9-.] ;

fragment NAME: OKCHAR+ ;

fragment START:  ('/' NAME) | NAME  ; 

PATH: START ('/' NAME)*
             { System.out.println("File name: " + getText()); }
        ;

WS: [ \r\n\t]+         {skip();} ;   

// 1. Note than on unix o/s ... is a valid filename!
// 2. Note how fragments were used!
