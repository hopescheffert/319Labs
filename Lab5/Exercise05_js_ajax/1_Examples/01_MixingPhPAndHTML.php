
<HTML>
<HEAD>
</HEAD>
<BODY>

<H1>
<?php
// THE PURPOSE of this file is to show that you can
// mix html and php in one file.
// The PHP interpreter just ignores the HTML part and processes the
// PHP part! THE ENTIRE HTML is sent back to the browser after
// processing is complete
echo "This is the first PHP section";
?>

</H1>
<h2>This is message from outside any PhP section! </h2>
<BR>

<B>
<?php
echo  "This is the second PHP section";
?>
</B>
</BODY>
</HTML>
