<?php 

// THE PURPOSE OF THIS FILE IS JUST TO SEE HOW A CLASS IS DEFINED
// AND HOW TO CREATE AND USE OBJECTS
// This class has constants, static variable, instance variable
// instance method, and a constructor.
//

// OBJECTS

class Test {
  // In java final int A_BIG_NUMBER = 1111;
  const A_BIG_NUMBER = 11111;
  private $name; // also protected, public (default)
  static $i = 0;

  function __construct($name) {
    $this->name = $name;
    echo Test::$i;
    self::$i += 1;
  }

  // $this-> is how we refer to instance variables and methods inside
  // instance methods.
  // self:: is how we refer to static variables and methods
  // from inside instance methods
  public function getName() {
    return $this->name." ".self::A_BIG_NUMBER;
  }

  static function getI() {
    return self::$i;
  }

}

$myObj = new Test("Timothy");

// object-> is how we refer to instance methods and variables from
// outside the class definition.
// object:: is how we refer to static methods and variables from
// outside the class definition.
echo $myObj::$i. "  " .$myObj->getName();echo "<br>"; 

echo "<hr><br>";

echo $myObj::getI();

?>

