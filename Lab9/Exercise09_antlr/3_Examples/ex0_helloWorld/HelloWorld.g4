/**
 * This example will generate a lexer (which tokenises the INPUT)
 * and a parser that accepts any input matching the grammer.
 * It will generate errors if inputs are entered that does not follow
 * the rules (i.e. syntax rules)/
 *
 * This particular grammer accepts ONLY the input string
 * "Hello world!" It rejects everything else.
 */
grammar HelloWorld; // It is important to know the NAME of the grammer



// PARSER RULES
// our grammar accepts only salutation followed by an end symbol
// The LEFT HAND SIDE is lowercase. That is a "variable" in the grammer
// The variable derives the right hand side which are in this case 
// tokens.
start : (SALUTATION ENDSYMBOL)+;

// LEXER RULES
// the grammar must contain at least one lexer rule
// The LEFT HAND SIDE is all CAPITALIZED. These are the token ids.
// The Right hand side is the "regular expression" rules to match tokens
// just like lex
SALUTATION: 'Hello world';   
ENDSYMBOL: '!' ;



