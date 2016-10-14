<?php
// inLogout.php
// - destroy the session
// - re-­‐direct the page to login.html



session_start();
session_destroy();

header('Location: login.html');
exit;

//echo "<h1> session has been destroyed</h1><br>";

?>
