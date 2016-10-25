
function Book(t, s, a){
	this.title = t;
	this.shelf = s;
	this.available = a;
}

Book.prototype.showAvailable = function(){
	if(this.available == true){
		alert("The book " + this.title + " is available.");
	} else {
		alert("The book " + this.title + " is unavailable.");
	}
	console.log(this);
}

function Shelf(){
	var book1 = new Book("Book1", this, Math.random() > .5);
	var book2 = new Book("Book2", this, Math.random() > .5);
	var book3 = new Book("Book3", this, Math.random() > .5);
	var book4 = new Book("Book4", this, Math.random() > .5);
	var book5 = new Book("Book5", this, Math.random() > .5);
	var book6 = new Book("Book6", this, Math.random() > .5);
	var book7 = new Book("Book7", this, Math.random() > .5);
	this.books = [book1, book2, book3, book4, book5, book6, book7];
}

function Library(){
	var shelf1 = new Shelf();
	var shelf2 = new Shelf();
	this.shelves = [shelf1, shelf2];
}

Library.prototype.showLibrary = function(){
	var body = document.getElementsByTagName('body')[0];
	var tbl = document.createElement('table');
    tbl.style.width = '100%';
    tbl.setAttribute('border', '1');
	var tbdy = document.createElement('tbody');
	for(var i = 0; i < this.shelves.length; i++){
		var tr = document.createElement('tr');
		var first = document.createElement('td');
		first.appendChild(document.createTextNode("Shelf " + (i+1)));
		tr.appendChild(first);
		for(var j = 0; j < this.shelves[i].books.length; j++){
			var td = document.createElement('td');
			td.appendChild(document.createTextNode(this.shelves[i].books[j].title))
			if(this.shelves[i].books[j].available){
				tr.appendChild(td);
			}
		}
		tbdy.appendChild(tr);
	}
	tbl.appendChild(tbdy);
	body.appendChild(tbl);
}

function checkBook(book, library){
	var hasBook = false;
	console.log(library);
	for(var i = 0; i < 2; i++){
		for(var j = 0; j < 7; j++){
			console.log("test");
			if(library.shelves[i].books[j].title == book && library.shelves[i].books[j].available == true){
				alert(book + " is available at shelf " + (i + 1));
				return;
			}
		}
	}
	alert(book + " is unavailable.");
}

function createPage(){
	var library = new Library();
	library.showLibrary();
	document.getElementById("book1").onclick = function(){checkBook("Book1", library)};
	document.getElementById("book2").onclick = function(){checkBook("Book2", library)};
	document.getElementById("book3").onclick = function(){checkBook("Book3", library)};
	document.getElementById("book4").onclick = function(){checkBook("Book4", library)};
	document.getElementById("book5").onclick = function(){checkBook("Book5", library)};
	document.getElementById("book6").onclick = function(){checkBook("Book6", library)};
	document.getElementById("book7").onclick = function(){checkBook("Book7", library)};
	
}
