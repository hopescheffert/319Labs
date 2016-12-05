grammar DrawingBoard;

//http://www.w3schools.com/html/html_googlemaps.asp


@members{
    String name = "";
    String shape = "";
    Integer p1 = 0;
    Integer p2 = 0;
    Integer p3 = 0;
    Integer p4 = 0;
}

//PARSE RULES
start: ((command ';')
        {
            String s = "{'command':'" + name + "','shape' :'"+ shape +"','param1':" + p1 +",'param2':"+p2+",'param3':"+ p3 +",'param4':" + p4 +"}";
            System.out.println(s.replaceAll("'", "\"") + "*");
            name = "";
            shape = "";
            p1 = 0;
            p2 = 0;
            p3 = 0;
            p4 = 0;
            }
        )+ ;

command: commandname shape param1 param2 param3? param4?;

commandname: COMMANDNAME
                {
                    name = $COMMANDNAME.text;
                };
shape: SHAPE
                {
                    shape = $SHAPE.text;
                };
param1: INT
        {
            p1 = $INT.int;
        };
param2: INT
        {
            p2 = $INT.int;
        };
param3: INT
        {
            p3 = $INT.int;
        };
param4: INT
        {
            p4 = $INT.int;
        };

//LEXER RULES
COMMANDNAME: 'draw' ;
SHAPE: 'circle' | 'rectangle' | 'ellipse' | 'line' ;
INT: [0-9]+;
WS: [ \r\t\n]+ {skip();} ;
