grammar RPN;

//http://stackoverflow.com/questions/26896668/antlr4-rpn-calc-final-result-on-stack-missing

@header
{
    import java.util.Stack;
}

@members {
    int val = 0;
    int a = 0;
    int b = 0;
    int c = 0;

    Stack<int> stack = new Stack<int>();

}

start
 	 : (expr ';' {System.out.println("value = " + val); val=0;} )+
 	 ;

expr
   : INT
        {
            a = $INT.int;
            System.out.println("a = " + a);
            stack.push(a);
        }
     INT
        {
            b = $INT.int;
            System.out.println("b = " + b);
            stack.push(b);
        }
     '+'
     {
        val = stack.pop() + stack.pop();
        stack.push(val);
     }
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
     '%' {val = a % b;}
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
     }
     //**********TODO a and b can't be ints?
     |
     INT {a = $INT.int; System.out.println("a = " + a);}
     INT {b = $INT.int; System.out.println("b = " + b);}
     '&&'
     {
        if(a && b)
        {
            val = 1;
        }
        else val = 0;
     }
     |
     INT {a = $INT.int; System.out.println("a = " + a);}
     INT {b = $INT.int; System.out.println("b = " + b);}
     '||'
     {
        if(a || b)
        {
            val = 1;
        }
        else val = 0;
     }


     ;


//LEXER RULES
INT : [0-9]+  ;
WS : [ \r\t\n]+ {skip();} ;

//works

start
 	 : ((num | op)+ ';' {System.out.println("value = " + stack.pop()); val=0;} )+
 	 ;

num
   : INT
        {
            a = $INT.int;
            stack.push(a);
            System.out.println("stack is " + stack);
        };
op
    : '+'
     {
        val = stack.pop() + stack.pop();
        stack.push(val);
        System.out.println("after evaluation stack is " + stack);
     };





     //doesn't work
     start
      	 : (expr ';' {System.out.println("value = " + stack.pop()); val=0;} )+
      	 ;

     expr returns [int value]
         @after
         {
             System.out.println("after: " + $value);
         }
        :
        INT
         {
             $value = $INT.int;
             stack.push($value);
             System.out.println("it was an int: stack is " + stack);
         }
         | a=expr '+' b=expr
         {
              $value = $a.value + $b.value;
              stack.pop();
              stack.pop();
              stack.push($value);
              System.out.println("it was an addition: stack is " + stack);
         }
         ;
