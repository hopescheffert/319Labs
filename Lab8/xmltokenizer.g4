lexer grammar xmltokenizer;

//NOTE: test/check on http://www.regexpal.com/

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


//DATE: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!works online ([0][1-9]|[1][0-9]|[2][0-9]|[3][0-1]){1}[/]+([0][1-9]|[1][0-2]){1}[/]+(([2][0]{1}[0-9]{1}[0-9]{1})|[2][1][0][0])){1}
// format dd/mm/yyyy
//day in between 1-31
//month in between 1-12
//year between 2000-2100
//NOTE that you can ignore issues such as leap years, feb, 30 day months, 31 day months etc.
//Thus, for example 2/30/2000 will be considered valid.

fragment DIGIT: [0-9];
//works
YEAR: ([2][0]{1}DIGIT{1}DIGIT{1})|([2][1][0][0]) ;
//works
MONTH: ([0][1-9]|[1][0-2]) ;
//works
DAY: ([0][1-9]|[1]DIGIT|[2]DIGIT|[3][0-1]) ;
//******************************************************************TODO error: http://www.antlr.org/api/JavaTool/org/antlr/v4/tool/ErrorType.html
DATE: DAY[/]+MONTH[/]+YEAR
{
    System.out.println("**DATE** " + getText());
};

DATEELEMENT: ('<date>' | '<DATE>') DATE ('</date>' | '</DATE>')
{
    System.out.println("****DATEELEMENT FOUND**** " + getText());
};


//PHONE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!works online: [(]?[0-9]{3}[)]?([ -.])+[0-9]{3}\1[0-9]{4}
// 123-123-1234
// (123) 123-1234
// 123 123 1234
// 123.123.1234
//**************************************************************TODO how to escape this?

PHONE: [(]?[0-9]{3}[)]?([ -.])+[0-9]{3}\1[0-9]{4}
{
    System.out.println("**PHONE** " + getText());
};

PHONEELEMENT: ('<phone>' | '<PHONE>') PHONE ('</phone>' | '</PHONE>')
{
    System.out.println("****PHONEELEMENT FOUND****" + getText());
};

//CREDIT CARD
//Visa: All Visa card numbers start with a 4. New cards have 16 digits. Old cards have 13.
//MasterCard: All MasterCard numbers start with the numbers 51 through 55. All have 16 digits.
//American Express: American Express card numbers start with 34 or 37 and have 15 dig- its.
//Diners Club: Diners Club card numbers begin with 300 through 305, 36 or 38. All have 14 digits.
//There are Diners Club cards that begin with 5 and have 16 digits. These are a joint
//venture between Diners Club and MasterCard, and should be processed like a Master- Card.
//Discover: Discover card numbers begin with 6011 or 65. All have 16 digits.
//JCB: JCB cards beginning with 2131 or 1800 have 15 digits. JCB cards beginning with 35 have 16 digits.

//new visa
VISA: [4]DIGIT{15}
{
    System.out.println("**VISA CREDIT CARD**" + getText());
};




//skip whitespace
WS: [ \r\n\t]+ {skip();} ;
