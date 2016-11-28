grammar RPN;

@members {
    int val = 0;
    int a = 0;
    int b = 0;
    int c = 0;
}

start
 	 : (expr ';' {System.out.println("value = " + val); val=0;} )+
 	 ;

expr
   : INT {a = $INT.int; System.out.println("a = " + a);}
     INT {b = $INT.int; System.out.println("b = " + b);}
     '+' {val = a + b;}
     |
     INT {a = $INT.int; System.out.println("a = " + a);}
     INT {b = $INT.int; System.out.println("b = " + b);}
     '-' {val = a - b;}
     |
     INT {a = $INT.int; System.out.println("a = " + a);}
     INT {b = $INT.int; System.out.println("b = " + b);}
     '*' {val = a * b;}
     |
     INT {a = $INT.int; System.out.println("a = " + a);}
     INT {b = $INT.int; System.out.println("b = " + b);}
     '/' {val = a / b;}
     |
     INT {a = $INT.int; System.out.println("a = " + a);}
     INT {b = $INT.int; System.out.println("b = " + b);}
     '>'
     {
        if(a > b)
        {
            val = 1;
        }
        else val = 0;
     }
     //***************TODO what to do for "true" and "false" if val is an int?
     |
     INT {a = $INT.int; System.out.println("a = " + a);}
     INT {b = $INT.int; System.out.println("b = " + b);}
     '<'
     {
        if(a < b)
        {
            val = 1;
        }
        else val = 0;
     }
     |
     INT {a = $INT.int; System.out.println("a = " + a);}
     INT {b = $INT.int; System.out.println("b = " + b);}
     '>='
     {
        if(a >= b)
        {
            val = 1;
        }
        else val = 0;
     }
     |
     INT {a = $INT.int; System.out.println("a = " + a);}
     INT {b = $INT.int; System.out.println("b = " + b);}
     '<='
     {
        if(a <= b)
        {
            val = 1;
        }
        else val = 0;
     }
     |
     INT {a = $INT.int; System.out.println("a = " + a);}
     INT {b = $INT.int; System.out.println("b = " + b);}
     '=='
     {
        if(a == b)
        {
            val = 1;
        }
        else val = 0;
     }
     |
     INT {a = $INT.int; System.out.println("a = " + a);}
     INT {b = $INT.int; System.out.println("b = " + b);}
     '!='
     {
        if(a != b)
        {
            val = 1;
        }
        else val = 0;
     };





//LEXER RULES
INT : [0-9]+  ;
WS : [ \r\t\n]+ {skip();} ;
