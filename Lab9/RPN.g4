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

start
 	 : (expr ';' {System.out.println("value = " + stack.pop()); val=0;} )+
 	 ;

expr
   : INT
        {
            a = $INT.int;
            System.out.println("a = " + a);
            stack.push(a);
            System.out.println("stack is " + stack);

        }
     INT
        {
            b = $INT.int;
            System.out.println("b = " + b);
            stack.push(b);
            System.out.println("stack is " + stack);

        }
     '+'
     {
        val = stack.pop() + stack.pop();
        stack.push(val);
        System.out.println("after evaluation stack is " + stack);
     };


//LEXER RULES
INT : [0-9]+  ;
WS : [ \r\t\n]+ {skip();} ;
