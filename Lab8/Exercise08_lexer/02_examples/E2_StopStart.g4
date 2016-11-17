// This is a more complicated example!

lexer grammar E2_StopStart;

COMMAND: 'stop' { System.out.println("Stop command received");} 
     | 'start' 
         { System.out.println("Start command received"); }
     | .+? {System.out.println("other text read: "+getText()); } ;


// 1. note ; is used at END of entire rule.
// 2. note how the different commands were matched!
// 3. note how I matched every thing else
