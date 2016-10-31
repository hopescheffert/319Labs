<?php
include("databaseconnection");
session_start();
session_destroy();

//mysqli_close($conn);



header("Location: Library.php");
?>
