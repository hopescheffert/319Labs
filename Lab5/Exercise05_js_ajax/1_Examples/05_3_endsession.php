<?php
?>
<html>
<body>

<?php
  session_start();
  // CHECK THAT SESSION IS ACTIVE
  echo "<h1>BEFORE destroying session</h1>";
  var_dump($_SESSION);

  // destroy the session 
  session_destroy(); 


echo "<a href=\"05_4_newRequest.php\">Click here to go to next page</a>";
echo "<hr><br>";

?>

</body>
</html>
