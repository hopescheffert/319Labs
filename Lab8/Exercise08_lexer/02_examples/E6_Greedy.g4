lexer grammar E6_Greedy;


//COMMENT1: '/*' .* '*/' {System.out.println("comment1: "+getText());};
COMMENT2: '/*' .*? '*/' {System.out.println("comment2: "+getText());};


WS: [ \r\n\t]+         {skip();} ;   
