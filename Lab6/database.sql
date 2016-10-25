CREATE TABLE users
(
userName varchar(255),
password varchar(255),
email varchar(255),
phone varchar(10),
librarian TINYINT,
firstName varchar(255),
lastName varchar(255)
);

CREATE TABLE books
(
bookID INT(10),
bookTitle varchar(255),
author varchar(25),
availability TINYINT
);

CREATE TABLE loanHistory
(
userName varchar(255),
bookID INT(10),
dueDate DATE,
returnedDate DATE
);

CREATE TABLE shelves
(
shelfID INT(10),
shelfName varchar(255),
bookID INT(10)
);

