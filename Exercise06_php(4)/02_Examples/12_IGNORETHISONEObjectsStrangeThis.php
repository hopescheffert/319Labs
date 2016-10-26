<?php 

// THE PURPOSE OF THIS FILE IS JUST TO SHOW YOU THAT THE 
// $this in PHP BEHAVES SOMETIMES IN UNEXPECTED WAYS.
// THE LESSON IS USE IT PROPERLY.

class ABC  {

  public function getName() {
    echo "this is of class ". get_class($this)."<br>";
  }

}

echo '<hr>ABC::getName()<br>';
ABC::getName(); 
// SEE HOW WE ACCESSED AN INSTANCE METHOD IN A STATIC WAY!
// prints error message - but still prints class


$obj1 = new ABC(); 
echo '<hr>Now for $obj1->getName<br>';
$obj1->getName(); // prints class (THIS IS NORMAL WAY)

echo '<hr>$obj1::getName()<br>';
$obj1::getName();  
echo "<hr><br>";
// AGAIN WE ACCESSED THE INSTANCE METHOD IN A STATIC WAY!
// prints error message - but still prints class



class DEF {
  public function getName() {
    ABC::getName();
  }
}

echo '<hr>DEF::getName()<br>';
DEF::getName(); // since we call ABC's method 
// AGAIN WE ACCESSED AN INSTANCE METHOD IN A STATIC WAY!
// prints error message - but still prints class

echo '<hr>$obj2->getName()<br>';
$obj2 = new DEF();
$obj2->getName(); 
// HERE $this is obj2!!!!! even inside our ABC's getName method
// note DEF is defined! note we print DEF as this!!!

echo '<hr>$obj2::getName()<br>';
$obj2::getName();  // again this is not defined!
// AGAIN WE ACCESSED AN INSTANCE METHOD IN A STATIC WAY!
// prints error message - but still prints class

echo "<hr><br>";

// HERE WE SHOW HOW WE CAN CREATE AN OBJECT GIVEN THE CLASS NAME IN 
// A STRING!
$obj3 = 'ABC'; 
$obj4 = new $obj3(); // this works too!
$obj4->getName();

?>

