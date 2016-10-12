//code.js

$(document).ready(function ()
{
    //manipulating CSS style 5 different ways:

    //1 bold text
    $("#d1").click(function()
    {
        $(this).css("font-weight", "bolder");
    });

    //2 changing font size

    $("#p2").click(function()
    {
        $(this).css("font-size", 20);
    });

    //3 changing color to blue
    $("#p3").click(function()
    {
        $(this).css("color", "blue");
    });

    //4 changing background-color to pink
    $("#p4").click(function()
    {
        $(this).css("background-color", "pink");
    });

    //5 border
    $("#p5").click(function()
    {
        $(this).css({"border-color": "#FF0000",
        "border-width":"4px",
        "border-style":"solid"});
    });

    //5 different jQuery effects

    //1 show()/hide()
    $("#p6").click(function()
    {
        $(this).hide();
    });

    //2 animate()
    $("#button1").click(function()
    {
        $("#d1").animate({left: '250px'});

    });

    //3 fade out
    $("#button2").click(function()
    {
        $("#p2").fadeOut(2000);

    });

    //4 callback alert
    $("#button3").click(function()
    {
        $("#p3").hide("slow", function()
        {
            alert("used callback to show this alert");
        });

    });

    //5 chaining effects
    $("#button4").click(function()
    {
        $("#p4").slideUp(2000).slideDown(2000);

    });

    //5 different jQuery events
    //1 double click
    $("#button5").dblclick(function()
    {
        $(this).hide();

    });

    //2 mouse enter
    $("#p1").mouseenter(function()
    {
        $(this).css("color", "red");

    });

    //3 mouse leave
    $("#p1").mouseleave(function()
    {
        $(this).css("color", "green");

    });

    //4 focus
    $("#p5").focus(function()
    {
        $(this).css("background-color", "#cccccc");
    });

    //5 on() method for events
    $("#button6").on(
        {
            mouseenter: function()
            {
                $(this).css("background-color", "yellow");
            },
            mouseleave: function()
            {
                $(this).css("background-color", "orange");
            },
            click: function()
            {
                alert("used 'on' for all of these events");
            }
        });
});
