<?php
session_start();
?>
<html>
<body>

<?php
  // WE ARE COMING HERE AFTER HAVING DESTROYED THE PREVIOUS SESSION
  echo "<h1>AFTER destroying previous session</h1>";
  var_dump($_SESSION);

?>

</body>
</html>
