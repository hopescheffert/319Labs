<?php
// THIS IS JUST A SIMPLE EXAMPLE TO SHOW CONNECTION TO A DATABASE
// YOU WILL NEED TO FILL THE PROPER CREDENTIALS FOR THE
// USERNAME, PASSWORD, AND DATABASESERVER names
// TODO: TRY USING THE CREDENTIALS SUPPLIED LATER IN THE EXERCISE

$username = "root";
$password = "abcdef";
$dbServer = "127.0.0.1"; 
$dbName   = "PlayingWithMySQL";

// --------------------------------------
// --- PART-1 --- CONNECT TO DATABASE ---
// --------------------------------------
// USE OO MYSQL IMPROVED 

// Create connection
$conn = new mysqli($dbServer, $username, $password, $dbName);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} else {
  echo "Connected successfully<br>";
}

echo $mysqli->host_info . "<br>";


// --------------------------------------
// --- PART-2 --- INSERT DATA -----------
// --------------------------------------
$sql = "INSERT INTO userDetails (userID, userDetails) VALUES ('abc', 'john@example.com')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully<br>";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}


// --------------------------------------
// --- PART-3 --- GET DATA --------------
// --------------------------------------
$sql = "SELECT * FROM userDetails";

$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "userID: " . $row["userID"]. "  userDetails: " . $row["userDetails"]. "<br>";
    }
} else {
    echo "0 results";
}



// --------------------------------------
// --- PART-4 --- CLOSE -----------------
// --------------------------------------
$conn->close();

?>
