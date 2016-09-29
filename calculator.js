// CALCULATOR.JS

var Calc =
{

    Model :
    {

    },


    View :
    {
        textRow : {id: "textRow", type: "text", value: "", onclick:""},

        button7 : {id: "button7", type: "button", value: 7, onclick:""},
        button8 : {id: "button8", type: "button", value: 8, onclick:""},
        button9 : {id: "button9", type: "button", value: 9, onclick:""},
        buttonplus : {id: "buttonplus", type: "button", value: "+", onclick:""},

        button4 : {id: "button4", type: "button", value: 4, onclick:""},
        button5 : {id: "button5", type: "button", value: 5, onclick:""},
        button6 : {id: "button6", type: "button", value: 6, onclick:""},
        buttonminus : {id: "buttonminus", type: "button", value: "-", onclick:""},


        button1 : {id: "button1", type: "button", value: 1, onclick:""},
        button2 : {id: "button2", type: "button", value: 2, onclick:""},
        button3 : {id: "button3", type: "button", value: 3, onclick:""},
        buttonmult : {id: "buttonmult", type: "button", value: "*", onclick:""},

        button0 : {id: "button0", type: "button", value: 0, onclick:""},
        buttondot : {id: "buttondot", type: "button", value: ".", onclick:""},
        buttonequals : {id: "buttonequals", type: "button", value: "=", onclick:""},
        buttondiv : {id: "buttondiv", type: "button", value: "/", onclick:""},


        buttonC : {id: "buttonC", type: "button", value: "C", onclick:""},
        buttonMR : {id: "buttonMR", type: "button", value: "MR", onclick:""},
        buttonMminus : {id: "buttonMminus", type: "button", value: "M-", onclick:""},
        buttonMplus : {id: "buttonMplus", type: "button", value: "M+", onclick:""},

        buttonMC : {id: "buttonMC", type: "button", value: "MC", onclick:""}

    },

    Controller :
    {
        buttonHandler : function(that)
        {
            console.log("that.value is " + that.value);
            var val;
            if(isNaN(that))
            {
                switch(that.value)
                {
                    case: "C"
                        val = "";
                        break;
                    case: "MC"
                        //TODO val =
                        break;
                    case: "MR"
                        //TODO val =
                        break;
                    case: "M-"
                        //TODO val =
                        break;
                    case: "M+"
                        //TODO val =
                        break;
                }
            }

            //otherwise it's a number button
            textRow.value += that.value;

        },
    },

    run : function()
    {
        Calc.attachHandlers();
        console.log(Calc.display());
        return Calc.display();
    },


    displayElement : function (element)
    {
        var s = "<input ";
        s += " id=\"" + element.id + "\"";
        s += " type=\"" + element.type + "\"";
        s += " value= \"" + element.value + "\"";
        s += " onclick= \"" + element.onclick + "\"";
        s += ">";
        return s;

    },

    display : function()
    {
        var s;
        s = "<table id=\"myTable\" border=2>"
        s += "<tr><td>" + Calc.displayElement(Calc.View.textRow) + "</td></tr>";
        s += "<tr><td>";
        s += Calc.displayElement(Calc.View.button7);
        s += Calc.displayElement(Calc.View.button8);
        s += Calc.displayElement(Calc.View.button9);
        s += Calc.displayElement(Calc.View.buttonplus);
        s += "<tr><td>"
        s += Calc.displayElement(Calc.View.button4);
        s += Calc.displayElement(Calc.View.button5);
        s += Calc.displayElement(Calc.View.button6);
        s += Calc.displayElement(Calc.View.buttonminus);
        s += "<tr><td>"
        s += Calc.displayElement(Calc.View.button1);
        s += Calc.displayElement(Calc.View.button2);
        s += Calc.displayElement(Calc.View.button3);
        s += Calc.displayElement(Calc.View.buttonmult);
        s += "<tr><td>"
        s += Calc.displayElement(Calc.View.button0);
        s += Calc.displayElement(Calc.View.buttondot);
        s += Calc.displayElement(Calc.View.buttonequals);
        s += Calc.displayElement(Calc.View.buttondiv);
        s += "<tr><td>"
        s += Calc.displayElement(Calc.View.buttonC);
        s += Calc.displayElement(Calc.View.buttonMR);
        s += Calc.displayElement(Calc.View.buttonMminus);
        s += Calc.displayElement(Calc.View.buttonMplus);
        s += "<tr><td>"
        s += Calc.displayElement(Calc.View.buttonMC);
        s += "</tr></td></table>";
        return s;
    },

    attachHandlers : function()
    {
        //TODO ATTACH HANDLER FOR EACH BUTTON HANDLER
        for(var i = 0; i <=9; i++)
        {
            Calc.View["button" + i].onclick = "Calc.Controller.buttonHandler(this)";
        }
        Calc.View.buttonC.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonplus.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttondiv.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttondot.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonmult.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonminus.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonequals.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonMC.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonMR.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonMplus.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonMminus.onclick = "Calc.Controller.buttonHandler(this)";

    },






} // end of Calc;
