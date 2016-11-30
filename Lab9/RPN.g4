grammar RPN;

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
    ((operand | operator)+ ';' {System.out.println("answer = " + stack.pop()); val=0;})+ ;

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
              if(stack.size() >= 2)
              {
                val = (Integer)stack.pop() + (Integer)stack.pop();
                stack.push(val);
              }
              else System.out.println("***We found an extra character, but we will ignore that***");
            }
             | '-'
              {
                if(stack.size() >= 2)
                {
                    a = (Integer) stack.pop();
                    val = (Integer) stack.pop() - a;
                    stack.push(val);
                }
                else System.out.println("***We found an extra character, but we will ignore that***");
              }
              | '*'
               {
                 if(stack.size() >= 2)
                 {
                    val = (Integer) stack.pop() * (Integer) stack.pop();
                    stack.push(val);
                 }
                 else System.out.println("***We found an extra character, but we will ignore that***");
               }
               | '/'
               {
                 if(stack.size() >= 2)
                 {
                     a = (Integer) stack.pop();
                     val = (Integer) stack.pop() / a;
                     stack.push(val);
                 }
                 else System.out.println("***We found an extra character, but we will ignore that***");
               }
                | '%'
                 {
                   if(stack.size() >= 2)
                   {
                      a = (Integer) stack.pop();
                      val = (Integer) stack.pop() % a;
                      stack.push(val);
                   }
                   else System.out.println("***We found an extra character, but we will ignore that***");
                 }

                 //RELATIONAL OPERATIONS

                 | '=='
                 {
                   if(stack.size() >= 2)
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
                   else System.out.println("***We found an extra character, but we will ignore that***");
                 }

                 | '!='
                 {
                   if(stack.size() >= 2)
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
                   else System.out.println("***We found an extra character, but we will ignore that***");
                 }
                 | '>'
                 {
                   if(stack.size() >= 2)
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
                   else System.out.println("***We found an extra character, but we will ignore that***");
                 }
                 | '<'

                 {
                   if(stack.size() >= 2)
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
                   else System.out.println("***We found an extra character, but we will ignore that***");
                 }
                 | '>='
                 {
                   if(stack.size() >= 2)
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
                   else System.out.println("***We found an extra character, but we will ignore that***");
                 }
                 | '<='
                 {
                   if(stack.size() >= 2)
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
                   else System.out.println("***We found an extra character, but we will ignore that***");
                 }
                 //LOGICAL OPERATIONS

                 | '||'
                 {
                   if(stack.size() >= 2)
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
                   else System.out.println("***We found an extra character, but we will ignore that***");
                 }

                 | '&&'
                 {
                   if(stack.size() >= 2)
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
                   else System.out.println("***We found an extra character, but we will ignore that***");
                 }
                 | '!'
                 {
                   if(stack.size() >= 2)
                   {
                      boolean temp = (Boolean) stack.pop();
                      stack.push(!temp);
                   }
                   else System.out.println("***We found an extra character, but we will ignore that***");
                 };




//LEXER RULES
INT : [0-9]+ ;
BOOLEAN : ('true') | ('false') | ('TRUE') | ('FALSE') ;
WS : [ \r\t\n]+ {skip();} ;
