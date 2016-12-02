grammar DrawingBoard;

//http://www.w3schools.com/html/html_googlemaps.asp


@members{
    String name = "";
    String shape = "";
    Integer x = 0;
    Integer y = 0;
    Integer r = 0;
}

//PARSE RULES
start: ((command ';') {
            //System.out.println(name  + " " + shape + " " + x + " " + y + " " + r);
            String s = "{'command': '" + name + "', 'shape' : '"+ shape +"', 'paramx': " + x +", 'paramy': "+y+", 'paramr': "+ r +"}*";
            System.out.println(s.replaceAll("'", "\""));
            name = "";
            String shape = "";
            Integer x = 0;
            Integer y = 0;
            Integer r = 0;
            }
        )+ ;

command: commandname shape paramx paramy? paramr? ;

commandname: COMMANDNAME
                {
                    name = $COMMANDNAME.text;
                    //System.out.println("command name: " + name);
                };
shape: SHAPE
                {
                    shape = $SHAPE.text;
                    //System.out.println("command shape: " + shape);
                };
paramx: INT
        {
            x = $INT.int;
            //System.out.println("shape x: " + x);

        };
paramy: INT
        {
            y = $INT.int;
            //System.out.println("shape y: " + y);

        };
paramr: INT
        {
            r = $INT.int;
            //System.out.println("shape radius: " + r);

        };

//LEXER RULES
COMMANDNAME: 'draw'  | 'fill' ;
//circle
SHAPE: 'circle' | 'rectangle' ;

INT: [0-9]+;
WS: [ \r\t\n]+ {skip();} ;
