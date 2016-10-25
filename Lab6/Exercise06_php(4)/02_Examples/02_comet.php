<?php

$i = 0;
while ($i < 10) {
  sleep(1);
  echo "The current value of i is ".$i. " <br>";
  $i = $i + 1;
  ob_flush(); // high level buffer flush to lower level buffer
  flush(); // flushes lower level buffer to send to client
}

?>
