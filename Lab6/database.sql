CREATE TABLE users
(
    userName varchar(255),
    password varchar(255),
    email varchar(255),
    phone varchar(10),
    librarian TINYINT,
    firstName varchar(255),
    lastName varchar(255),
    primary key (userName)
);

CREATE TABLE books
(
    bookID INT(10),
    bookTitle varchar(255),
    author varchar(25),
    availability TINYINT,
    primary key (bookID)
);

CREATE TABLE loanHistory
(
    userName varchar(255),
    bookID INT(10),
    dueDate DATE,
    returnedDate DATE,
    primary key (userName)
);

CREATE TABLE shelves
(
    shelfID INT(10),
    shelfName varchar(255),
    primary key (shelfID)
);

CREATE TABLE shelfBooks
(
    shelfID INT(10),
    bookID INT(10),
    primary key (bookID)
);
