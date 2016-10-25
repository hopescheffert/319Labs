$(document).ready(function(){
	
	//When you hover over the change color button the color of part 1 buttons changes to Red
	$("#changeColor").hover(function(){
		console.log($("button.p1").backgroundColor);
		if($("button.p1").css("background-color") == "rgb(255, 0, 0)"){
			$("button.p1").css("background-color", "BLACK");
		} else {
			$("button.p1").css("background-color", "RED");
		}
	})
	
	//When you click the round corners button the corners of all the buttons in part one will be rounded.
	$("#roundCorners").click(function(){
		if($("button.p1").css("border-radius") == "25px"){
			$("button.p1").css("border-radius", "0px");
		} else {
			$("button.p1").css("border-radius", "25px");
		}
	})
	
	
	// when you click the font size button the font gets large
	$("#fontSize").click(function(){
		if($("p.p1").css("font-size") == "25px"){
			$("p.p1").css("font-size", "16px");
		} else {
			$("p.p1").css("font-size", "25px");
		}
	})
	
	// when you click the add shadow button the text gets shadow
	$("#addShadow").click(function(){
		if($("p.p1").css("text-shadow") == "none"){
			$("p.p1").css("text-shadow", "#aaa 2px 2px 2px");
		} else {
			$("p.p1").css("text-shadow", "none");
		}
	})
	
	// when you click the rotate button the first section rotates 180 degrees
	$("#rotate").click(function(){
		if($("#part1.p1").css("transform") == "none"){
			$("#part1.p1").css("transform", "rotate(180deg)");
		} else {
			$("#part1.p1").css("transform", "none");
		}
	})
	
	
	//Part 2
	//When you click this butotn the paragraph fades
	$("#toggleFade").click(function(){
		$("p.p2").fadeToggle();
	})
	
	//when you click this button the paragraph slides away
	$("#toggleSlide").click(function(){
		$("p.p2").slideToggle();
	})
	
	//When you double click this button the paragraph increases then decreases in size.
	$("#animate").dblclick(function(){
		$("p.p2").animate({
			fontSize : "50px"
		}, 2000, function(){
			$("p.p2").animate({
			fontSize : "16px"
		}, 2000, function(){}
		);}
		);
	})
	
	//When you click this butotn the paragraph moves to the right
	$("#move").click(function(){
		$("p.p2").animate({
			left : "+=50"
		}, 1000, function(){}
		);
	})
	
	//When this button is clicked all of the elements but this button will be hidden.
	$("#hide").click(function(){
		if($(this).html() == "Hide All"){
			$(this).siblings().hide();
			$(this).html("Show All");
		} else {
			$(this).siblings().show();
			$(this).html("Hide All");
		}
	})
	
});