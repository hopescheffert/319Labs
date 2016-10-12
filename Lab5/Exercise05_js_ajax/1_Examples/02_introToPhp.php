<?php 

// THIS IS A SIMPLE INTRODUCTION TO PHP
// Here we learn about
// a) variables and their types
// b) arrays and associative arrays
// c) functions and local and global variables
// d) objects
// TODO: You are to go through the below exercises and make sure
// you understand them.

// VARIABLES
$sName = "Hello there";
$bStatus = false;
$iId = 24;

// ARRAYS
$aNames = array("Sam","Pam","Tom");
$aNames[1000] = "Jerry";
foreach ($aNames as $value) {
  echo $value; echo "<br>";
}
echo count($aNames);echo "<br>";
echo "<hr><br>";

// ASSOCIATIVE ARRAYS (note use of =>)
$aScores = array("Sam" => 10, "Pam" => 20, "Tom" => 30);
foreach ($aScores as $key=>$value) {
  echo $key." has ".$value; echo "<br>";
}
var_dump($aScores);
echo "<hr><br>";

// FUNCTIONS
function testScope() {

  $x = 10; // this is a local variable
  echo "inside testScope ".$x; echo "<BR>";

  global $x; // accessing global $x now!
  echo "inside testScope ".$x; echo "<BR>";
  $x = 1000;

  return 3.14;
}

// GLOBAL VARIABLES
$x = 100;
echo $x; echo "<BR>";

$y = testScope();

echo "x is ".$x; echo "<BR>";
echo "y is ".$y; echo "<BR>";
echo "<hr><br>";

// OBJECTS
class Test {
  const A_BIG_NUMBER = 11111;
  private $name;
  static $i = 0;

  function __construct($name) {
    $this->name = $name;
    self::$i += 1;
  }

  public function getName() {
    return $this->name." ".self::A_BIG_NUMBER;
  }

}

$myObj = new Test("Timothy");
echo $myObj->getName();echo "<br>"; 

// We will do objects again later.

echo "<hr><br>";

?>

