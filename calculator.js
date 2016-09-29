// CALCULATOR.JS

var Calc =
{

    Model :
    {
        //arrays for operators and operands
        operators : [],
        operands : [],
        memory: undefined
    },


    View :
    {
        //row 0
        textRow : {id: "textRow", type: "text", value: "", onclick:""},
        //row 1
        button7 : {id: "button7", type: "button", value: 7, onclick:""},
        button8 : {id: "button8", type: "button", value: 8, onclick:""},
        button9 : {id: "button9", type: "button", value: 9, onclick:""},
        buttonplus : {id: "buttonplus", type: "button", value: "+", onclick:""},
        //row 2
        button4 : {id: "button4", type: "button", value: 4, onclick:""},
        button5 : {id: "button5", type: "button", value: 5, onclick:""},
        button6 : {id: "button6", type: "button", value: 6, onclick:""},
        buttonminus : {id: "buttonminus", type: "button", value: "-", onclick:""},
        //row 3
        button1 : {id: "button1", type: "button", value: 1, onclick:""},
        button2 : {id: "button2", type: "button", value: 2, onclick:""},
        button3 : {id: "button3", type: "button", value: 3, onclick:""},
        buttonmult : {id: "buttonmult", type: "button", value: "*", onclick:""},
        //row 4
        button0 : {id: "button0", type: "button", value: 0, onclick:""},
        buttondot : {id: "buttondot", type: "button", value: ".", onclick:""},
        buttonequals : {id: "buttonequals", type: "button", value: "=", onclick:""},
        buttondiv : {id: "buttondiv", type: "button", value: "/", onclick:""},
        //row 4
        buttonC : {id: "buttonC", type: "button", value: "C", onclick:""},
        buttonMR : {id: "buttonMR", type: "button", value: "MR", onclick:""},
        buttonMminus : {id: "buttonMminus", type: "button", value: "M-", onclick:""},
        buttonMplus : {id: "buttonMplus", type: "button", value: "M+", onclick:""},
        //row 6
        buttonMC : {id: "buttonMC", type: "button", value: "MC", onclick:""}

    },

    Controller :
    {

        buttonHandler : function(that)
        {

            //used in switch statement
            var val;
            //if that.value is a number it's an operand
            if(!isNaN(that.value))
            {
                //otherwise it's a number button aka an operand
                textRow.value += that.value;
                //put the value into the array of operands
                Calc.operands.push(that.value);
                console.log("operands "+ Calc.operands.toString());
            }
            else
            {
                //special buttons
                switch(that.value)
                {
                    case "C":
                    textRow.value = "";
                    break;

                    case "MC":
                    //TODO clears memory value
                    break;

                    case "MR":
                    //TODO shows memory value on scrren
                    break;

                    case "M-":
                    //TODO whatever is on screen gets subtracted from memory
                    break;

                    case "M+":
                    //TODO whatever is on screen gets added to memory
                    break;

                    case "=":
                    //TODO shows result of an operation...if repeated presses, will just show
                    //result of last operation
                    textRow.value = Calc.Controller.equals(operands, operators);
                    break;

                    case ".": //not an operator
                    textRow.value += that.value;
                    break;

                    //default
                    default: val = that.value;
                    textRow.value += val;

                    //put the value into the array of operators
                    operators.push(that.value);
                    console.log("operators " + operators.toString());
                }

            }

        },
        equals : function(operands, operators)
        {
            // for(var i = 0; i < operators.length; i++)
            // {
            console.log("operands " + operands);
            console.log("operators " + operators);

            if(operators[0] == "+")
            {
                console.log("result "+ operands[0] + operands[1]);
                return operands[0] + operands[1];
            }
            // switch(operators[i])
            // {
            //     case "+":
            //     return function()
            //     {
            //         return operands[0] + operands[1];
            //     }
            //     break;
            //     case "-"
            //     return function()
            //     {
            //         return operands[0] - operands[1];
            //     }
            //     break;
            //     case "*":
            //     return function()
            //     {
            //         return operands[0] * operands[1];
            //     }
            //     break;
            //     case "/":
            //     return function()
            //     {
            //         return operands[0] / operands[1];
            //     }
            //     break;

        }
    //return operands[0] + operators + operands[1];

},

run : function()
{

    Calc.attachHandlers();
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
    //ATTACH HANDLER FOR EACH BUTTON
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
