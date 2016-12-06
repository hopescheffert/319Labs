grammar DrawingBoard;

//http://www.w3schools.com/html/html_googlemaps.asp


@members{
    String name = "";
    String p0 = "";
    String p1 = "";
    Integer p2 = 0;
    Integer p3 = 0;
    Integer p4 = 0;
}

//PARSE RULES
start: ((command ';')
        {
            String s = "{'command':'" + name + "','param0' :'"+ p0 +"','param1':'" + p1 +"','param2':"+p2+",'param3':"+ p3 +",'param4':" + p4 +"}";
            System.out.println(s.replaceAll("'", "\"") + "*");
            name = "";
            p0 = "";
            p1 = "";
            p2 = 0;
            p3 = 0;
            p4 = 0;
            }
        )+ ;

command: commandname param0 param1? param2? param3? param4?;

commandname: COMMANDNAME
        {
            name = $COMMANDNAME.text;
        };
param0: SHAPE ID
        {
            p0 = $SHAPE.text + $ID.text;
        };
param1: INT
        {
            p1 = $INT.text;
        }
        | COLOR
        {
            p1 = $COLOR.text;
        }
        | DEGREE
        {
            p1 = $DEGREE.text;
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
COMMANDNAME: 'draw' | 'fill' | 'rotate';
COLOR: 'red' | 'green' | 'blue' | 'yellow' | 'black' | 'purple' | 'orange';
SHAPE: 'circle ' | 'rectangle ' | 'ellipse ' | 'line ';
ID: ('a'..'z'|'A'..'Z')+ ;
INT: [0-9]+ ;
DEGREE: [0-360] ;
WS: [ \r\t\n]+ {skip();} ;
