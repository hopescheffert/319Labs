<?php
header( "MIME-Version: 1.0 ");
header('Content-type: Multipart/mixed; type="text/html" boundary=END');
echo "what we have here should not matter";
echo "\n--END\n";
echo "Content-Type: text/plain\n";
echo 'Content-location: "n.txt"\n\n';
echo "hello\n\n";
echo "\n--END\n";
echo "Content-Type: text/html\n\n";
echo "<b>Hi this is a test<b><br>";
echo '<script>alert("hi")</script>';
echo "\n--END\n";
echo "Content-Type: text/plain\n";
echo "Content-disposition: inline\n\n";
echo "hello\n\n";
echo "\n--END\n";
echo "Content-Type: text/html\n\n";
echo "<b>Hi this is a test<b><br>";
echo '<script>alert("hi-2")</script>';
echo '<a href="n.txt">Click Here</a>';
echo "--END--\n\n";

?>
