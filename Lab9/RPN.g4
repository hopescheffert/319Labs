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

    Stack<Integer> stack = new Stack<Integer>();

}

start:
    ((num | op)+ ';' {System.out.println("value = " + stack.pop()); val=0;} )+ ;

num:
    INT
        {
            a = $INT.int;
            stack.push(a);
            System.out.println("stack is " + stack);
        };
op:
    '+'
     {
        val = stack.pop() + stack.pop();
        stack.push(val);
        System.out.println("after + evaluation stack is " + stack);
     }
     | '-'
      {
         a = stack.pop();
         val = stack.pop() - a;
         stack.push(val);
         System.out.println("after - evaluation stack is " + stack);
      }
      | '*'
       {
          val = stack.pop() * stack.pop();
          stack.push(val);
          System.out.println("after * evaluation stack is " + stack);
       }
       | '/'
        {
            a = stack.pop();
            val = stack.pop() / a;
            stack.push(val);
           System.out.println("after / evaluation stack is " + stack);
        }
        | '%'
         {
            a = stack.pop();
            val = stack.pop() % a;
            stack.push(val);
            System.out.println("after % evaluation stack is " + stack);
         }
         | '=='
         {
            b = stack.pop();
            a = stack.pop();
            if(a == b)
            {
                val = 1;
            }
            else
            {
                val = 0;
            }
            stack.push(val);
            System.out.println("after == evaluation stack is " + stack);

         }
         | '!='
         {
            b = stack.pop();
            a = stack.pop();
            if(a != b)
            {
                val = 1;
            }
            else
            {
                val = 0;
            }
            stack.push(val);
            System.out.println("after != evaluation stack is " + stack);

         }
         | '>'
         {
            b = stack.pop();
            a = stack.pop();
            if(a > b)
            {
                val = 1;
            }
            else
            {
                val = 0;
            }
            stack.push(val);
            System.out.println("after > evaluation stack is " + stack);

         }
         | '<'
         {
            b = stack.pop();
            a = stack.pop();
            if(a < b)
            {
                val = 1;
            }
            else
            {
                val = 0;
            }
            stack.push(val);
            System.out.println("after < evaluation stack is " + stack);

         }
         | '>='
         {
            b = stack.pop();
            a = stack.pop();
            if(a >= b)
            {
                val = 1;
            }
            else
            {
                val = 0;
            }
            stack.push(val);
            System.out.println("after >= evaluation stack is " + stack);

         }
         | '<='
         {
            b = stack.pop();
            a = stack.pop();
            if(a <= b)
            {
                val = 1;
            }
            else
            {
                val = 0;
            }
            stack.push(val);
            System.out.println("after <= evaluation stack is " + stack);

         }







     ;




//LEXER RULES
INT : [0-9]+  ;
WS : [ \r\t\n]+ {skip();} ;
