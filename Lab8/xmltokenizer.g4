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
fragment DOMAINPART: [a-zA-Z0-9-.]+? ;

EMAIL: LOCALPART+ '@' DOMAINPART+ ;

EMAILELEMENT: ('<email>' | '<EMAIL>') EMAIL ('</email>' | '</EMAIL>')
{
    System.out.println("****EMAILELEMENT FOUND**** " + getText());
};


//DATE:
//format dd/mm/yyyy
//day in between 1-31
//month in between 1-12
//year between 2000-2100
//NOTE that you can ignore issues such as leap years, feb, 30 day months, 31 day months etc.
//Thus, for example 02/30/2000 will be considered valid.

fragment DIGIT: [0-9];
YEAR: ('2' '0' DIGIT DIGIT) | ('2' '1' '0' '0') ;
//NOTE: ****must have 01 02 03 04...09 instead of 1 2 3...9****
MONTH: ('0'[1-9]|'1'[0-2]) ;
//NOTE: ****must have 01 02 03 04...09 instead of 1 2 3...9****
DAY: ('0'[1-9] | '1' DIGIT | '2' DIGIT |'3' [0-1]) ;

DATE: DAY[/]+MONTH[/]+YEAR ;

DATEELEMENT: ('<date>' | '<DATE>') DATE ('</date>' | '</DATE>')
{
    System.out.println("****DATEELEMENT FOUND**** " + getText());
};


//PHONE
// 123-123-1234
// (123) 123-1234
// 123 123 1234
// 123.123.1234

//THREENUMS: short for DIGIT{3} since lexer doesn't allow {} for repeating
fragment THREENUMS: DIGIT DIGIT DIGIT ;
//123 123 1234 case
OP1: THREENUMS[ ]THREENUMS[ ]THREENUMS DIGIT ;
//123.123.1234 case
OP2: THREENUMS[.]THREENUMS[.]THREENUMS DIGIT ;
//123-123-1234 case
OP3: THREENUMS[-]THREENUMS[-]THREENUMS DIGIT ;
//(123) 123-1234 case
OP4: '('THREENUMS')'[ ]THREENUMS[-]THREENUMS DIGIT ;
//matches either of the four formats from PDF **NOTE that we took this very literally**
PHONE: OP1 | OP2 | OP3 | OP4 ;

PHONEELEMENT: ('<phone>' | '<PHONE>') PHONE ('</phone>' | '</PHONE>')
{
    System.out.println("****PHONEELEMENT FOUND****" + getText());
};

//CREDIT CARD
//Visa: All Visa card numbers start with a 4. New cards have 16 digits. Old cards have 13. ACCEPT BOTH
//MasterCard: All MasterCard numbers start with the numbers 51 through 55. All have 16 digits.
//American Express: American Express card numbers start with 34 or 37 and have 15 dig- its.
//Diners Club: Diners Club card numbers begin with 300 through 305, 36 or 38. All have 14 digits.

//There are Diners Club cards that begin with 5 and have 16 digits. These are a joint
//venture between Diners Club and MasterCard, and should be processed like a Master- Card.

//Discover: Discover card numbers begin with 6011 or 65. All have 16 digits.
//JCB: JCB cards beginning with 2131 or 1800 have 15 digits. JCB cards beginning with 35 have 16 digits.

fragment ELEVEN: DIGIT DIGIT DIGIT DIGIT DIGIT DIGIT DIGIT DIGIT DIGIT DIGIT DIGIT ;
fragment TWELVE: ELEVEN DIGIT ;
fragment THIRTEEN: TWELVE DIGIT ;
fragment FOURTEEN: THIRTEEN DIGIT ;
fragment FIFTEEN: FOURTEEN DIGIT ;
fragment SIXTEEN: FIFTEEN DIGIT ;

VISA: '4'FIFTEEN | '4'TWELVE ;
MASTERCARD: '51'FOURTEEN | '52'FOURTEEN | '53'FOURTEEN | '54'FOURTEEN | '55'FOURTEEN ;
AMERICANEXP: '34'THIRTEEN | '37'THIRTEEN ;
DINERSCLUB: '300'ELEVEN | '301'ELEVEN |'302'ELEVEN | '303'ELEVEN | '304'ELEVEN |'305'ELEVEN | '36'TWELVE | '38'TWELVE ;
DISCOVER: '6011'TWELVE | '65'FOURTEEN ;
JCB: '2131'ELEVEN | '1800'ELEVEN | '35'FOURTEEN ;


CREDITCARD: VISA | MASTERCARD | AMERICANEXP | DINERSCLUB | DISCOVER | JCB;

CREDITCARDELEMENT: ('<creditcard>' | '<CREDITCARD>') CREDITCARD ('</creditcard>' | '</CREDITCARD>')
{
    System.out.println("****CREDITCARDELEMENT FOUND****" + getText());
};


//other elements (not email, date, phone, or credit card)

//element names must start with a letter or underscore
//element names cannot start with letters XML or xml, etc
//element names can contain letters, digits, hyphens, underscores or periods
//element names cannot contain spaces?
//names cannot contain spaces?
//fragment NOTXML: ~('x' | 'X')~('m' | 'M')~('l' | 'L').;
//starts with anything other than x
CASE1:[a-wy-zA-WY-Z_][a-zA-z0-9-_.]+ ;
//starts with x and anything other than m
CASE2: ('X'|'x')[a-ln-zA-LN-Z0-9-_.]+ ;
//starst with xm and has anything other than l
CASE3: ('X'|'x')('M'|'m')[a-km-zA-KM-Z0-9-_.]+ ;
ELEMENTNAME: CASE1 | CASE2 | CASE3 ;

//element strings can consist of the following:
//Uppercase and lowercase Latin letters (a–z, A–Z)
//Digits 0 to 9
//These special characters: -_~!$&'()*+,;=:
//and space
ELEMENTSTRING: [a-zA-Z0-9-_~!$&'()*+,;=: ]+ ;

CUSTOM: ('<' ELEMENTNAME '>') ELEMENTSTRING ('</' ELEMENTNAME '>')
{
    System.out.println("***CUSTOM ELEMENT FOUND****" + getText());
};

//skip whitespace
WS: [ \r\n\t]+ {skip();} ;
