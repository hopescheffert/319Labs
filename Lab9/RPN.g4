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
    boolean bool = false;

    Stack stack = new Stack();

}

start:
    ((operand | operator)+ ';' {System.out.println("answer = " + stack.pop()); val=0;} )+ ;

operand:
    INT
        {
            a = $INT.int;
            stack.push(a);
        }
    | BOOLEAN
        {
            boolean b;
            if($BOOLEAN.text.equals("true"))
            {
                b = true;
            }
            else b = false;

            stack.push(b);
        };
operator:
    //NUMERICAL OPERATIONS
    '+'
     {
        val = (Integer)stack.pop() + (Integer)stack.pop();
        stack.push(val);
     }
     | '-'
      {
         a = (Integer) stack.pop();
         val = (Integer) stack.pop() - a;
         stack.push(val);
      }
      | '*'
       {
          val = (Integer) stack.pop() * (Integer) stack.pop();
          stack.push(val);
       }
       | '/'
        {
            a = (Integer) stack.pop();
            val = (Integer) stack.pop() / a;
            stack.push(val);
        }
        | '%'
         {
            a = (Integer) stack.pop();
            val = (Integer) stack.pop() % a;
            stack.push(val);
         }

         //RELATIONAL OPERATIONS

         | '=='
         {
            b = (Integer) stack.pop();
            a = (Integer) stack.pop();
            if(a == b)
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
            stack.push(bool);
         }
         | '!='
         {
            b = (Integer) stack.pop();
            a = (Integer) stack.pop();
            if(a != b)
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
            stack.push(bool);
         }
         | '>'
         {
            b = (Integer) stack.pop();
            a = (Integer) stack.pop();
            if(a > b)
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
            stack.push(bool);
         }
         | '<'
         {
            b = (Integer) stack.pop();
            a = (Integer) stack.pop();
            if(a < b)
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
            stack.push(bool);
         }
         | '>='
         {
            b = (Integer) stack.pop();
            a = (Integer) stack.pop();
            if(a >= b)
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
            stack.push(bool);
         }
         | '<='
         {
            b = (Integer) stack.pop();
            a = (Integer) stack.pop();
            if(a <= b)
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
            stack.push(bool);
         }

         //LOGICAL OPERATIONS

         | '||'
         {
            boolean tempb = (Boolean) stack.pop();
            boolean tempa = (Boolean) stack.pop();
            if(tempa || tempb)
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
            stack.push(bool);
         }
         | '&&'
         {
            boolean tempb = (Boolean) stack.pop();
            boolean tempa = (Boolean) stack.pop();
            if(tempa && tempb)
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
            stack.push(bool);
         }
         | '!'
         {
            boolean temp = (Boolean) stack.pop();
            stack.push(!temp);
         }

     ;




//LEXER RULES
INT : [0-9]+ ;
BOOLEAN : ('true') | ('false') | ('TRUE') | ('FALSE') ;
WS : [ \r\t\n]+ {skip();} ;
