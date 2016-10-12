
/*************************************************
 document ready: when all elements in the Document object model 
 is created; the document.ready event is generated. 
 *************************************************/

$(document).ready( function () {
function clickme() {
    alert("Whats up from clickme");
}


    // write your code here
    $($('p').get(0)).text("DOM elements are ready to be manipulated");


/*************************************************
 Accessing via the id attribute
 *************************************************/

$('#clickb').click(function(){
    clickme();
});


$('#updatepreb').click(function(){
    updatepre();
    //myupdatepre(0);    // uncomment myupdatepre and review the changes
});

/*************************************************
 Accessing using tags
 *************************************************/

function updatepre() {
    $('pre').css('background', 'red');         // $('pre') returns an array of html elements encapsulated in jQuery
    // document.getElementsByTagName('pre');   // directly using javascript 
}

function myupdatepre(i) {
    var x = $('pre').get(i);
    $(x).css('background', 'lightblue');       // using encapsulation in jQuery
    // x.style.backgroundColor = "lightblue";  // directly using Javascript object accessibility
}

/*************************************************
 Accessing using class and more mouse events
 *************************************************/

$('.myclass').mouseover(function(){
    $(this).css({'color': 'red', 'font-weight': 'bold'});
});

$('.myclass').mouseout(function(){
    $(this).css({'color': 'black', 'font-weight': 'normal'});
});

/*** hover is a combination of mouseover and mouseout actions
     it takes two function as handlers for both the actions 
$('.myclass').hover(function(){
    $(this).css({'color': 'red', 'font-weight': 'bold'});
}, 
		   function(){
    $(this).css({'color': 'black', 'font-weight': 'normal'});
});
*/

});
