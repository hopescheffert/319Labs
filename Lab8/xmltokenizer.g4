lexer grammar xmltokenizer;

//NOTE: test on http://www.regexpal.com/


//EMAIL:
//localpart@domainpart (example: simanta.mitra@abc-def.org)
//local part:
    //uppercase lowercase letters
    //digits 0-9
    //-_~!$&'()*+,;=:
    // '.' as long as not first or last and does not appear consecutively
//domain part:
    //letters, digits, hyphens, dots


fragment LOCALPART: [a-zA-Z0-9-_~!$&'()*+,;=:]+([.][a-zA-Z0-9-_~!$&'()*+,;=:]+)? ;
//NOTE: do we need to check for these? ('.com' | '.edu' | '.org')+?
fragment DOMAINPART: [a-zA-Z0-9-.]+? ;

EMAIL: LOCALPART+ '@' DOMAINPART+
{
    System.out.println("**EMAIL** " + getText());
};

EMAILELEMENT: ('<email>' | '<EMAIL>') EMAIL ('</email>' | '</EMAIL>')
{
    System.out.println("****EMAILELEMENT FOUND**** " + getText());
};


//DATE:  this works online ([0][1-9]|[1][0-9]|[2][0-9]|[3][0-1]){1}[/]+([0][1-9]|[1][0-2]){1}[/]+(([2][0]{1}[0-9]{1}[0-9]{1})|[2][1][0][0])){1}
// format dd/mm/yyyy
//day in between 1-31
//month in between 1-12
//year between 2000-2100
//NOTE that you can ignore issues such as leap years, feb, 30 day months, 31 day months etc.
//Thus, for example 2/30/2000 will be considered valid.

fragment DIGIT: [0-9];
//works
fragment MONTH: ([0][1-9]|[1][0-2]) ;
//works
fragment DAY: ([0][1-9]|[1]DIGIT|[2]DIGIT|[3][0-1]) ;
//works
fragment YEAR: (([2][0]{1}DIGIT{1}DIGIT{1})|[2][1][0][0]) ;

//
DATE: DAY[/]+MONTH[/]+YEAR
{
    System.out.println("**DATE** " + getText());
};

DATEELEMENT: ('<date>' | '<DATE>') DATE ('</date>' | '</DATE>')
{
    System.out.println("****DATEELEMENT FOUND**** " + getText());
};

//skip whitespace?
WS: [ \r\n\t]+ {skip();} ;
