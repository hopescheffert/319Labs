grammar RPN;
 	 
@header{
	import java.util.Stack;
}
	 
@members {
 	int val = 0;
	int a = 0;
	int b = 0;
  Stack<Integer> stack = new Stack<Integer>();
}
 	 
start
 	 : (WS* (number|operator|bool)+ WS* ';' {val = stack.pop(); if(val == 1){System.out.println("true;");}else if(val == 0){System.out.println("false;");}else{ System.out.println(val+";");}} )+
 	 ;
	 
operator
	: '+' {val = stack.pop() + stack.pop(); stack.push(val);}
	| '-' {a = stack.pop(); b = stack.pop(); val = b - a; stack.push(val);}
	| '/' {a = stack.pop(); b = stack.pop(); val = b / a; stack.push(val);}
	| '*' {val = stack.pop() * stack.pop(); stack.push(val);}
	| '%' {a = stack.pop(); b = stack.pop(); val = b % a; stack.push(val);}
	| '<' {if(stack.pop() >= stack.pop())
		{ stack.push(1);} 
		else {stack.push(0);}}
	| '<=' {if(stack.pop() > stack.pop())
		{ stack.push(1);}
		else {stack.push(0);}}
	| '==' {if(stack.pop() == stack.pop())
		{ stack.push(1);} 
		else {stack.push(0);}}
	| '!=' {if(stack.pop() != stack.pop()){ stack.push(1);} else {stack.push(0);}}
	| '>=' {if(stack.pop() < stack.pop()){ stack.push(1);} else {stack.push(0);}}
	| '>' {if(stack.pop() <= stack.pop()){ stack.push(1);} else {stack.push(0);}}
	| '&&' {if(stack.pop() + stack.pop() == 2){stack.push(1);} else {stack.push(0);}}
	| '||' {if(stack.pop() + stack.pop() >= 1){stack.push(1);} else {stack.push(0);}}
	| '!' {if(stack.pop() + stack.pop() == 0){stack.push(1);} else {stack.push(0);}}
	;
	
number
	: INT {stack.push($INT.int);} ;
	
bool:
	true1 | false0;
	
true1
	: 'true' {stack.push(1);} ;

false0
	: 'false' {stack.push(0);} ;


INT : [0-9]+  ;
WS : [ \r\t\n]+ -> skip ;
