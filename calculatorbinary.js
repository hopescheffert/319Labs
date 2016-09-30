// CALCULATORBINARY.JS

var Calc =
{

    Model :
    {
        //arrays for operators and operands
        operators : [],
        operands : [],
        memory: 0
    },


    View :
    {
        //row 0
        calcDisplay : {id: "calcDisplay", type: "text", value: "", onclick:""},
        //row 1
        button1 : {id: "button1", type: "button", value: 1, onclick:""},
        button0 : {id: "button0", type: "button", value: 0, onclick:""},
        buttonnot : {id: "buttonnot", type: "button", value:"~", onclick:""},
        //row 2
        buttonplus : {id: "buttonplus", type: "button", value: "+", onclick:""},
        buttonmod : {id: "buttonmod", type: "button", value: "%", onclick:""},
        buttonshiftleft : {id: "buttonshiftleft", type: "button", value: "<<", onclick:""},
        //row 3
        buttonshiftright : {id: "buttonshiftright", type: "button", value: ">>", onclick:""},
        buttonminus : {id: "buttonminus", type: "button", value: "-", onclick:""},
        buttonand : {id: "buttonand", type: "button", value: "&", onclick:""},
        //row 4
        buttonor : {id: "buttonor", type: "button", value: "|", onclick:""},
        buttonmult : {id: "buttonmult", type: "button", value: "*", onclick:""},
        buttondiv : {id: "buttondiv", type: "button", value: "/", onclick:""},
        //row 5
        buttonMR : {id: "buttonMR", type: "button", value: "MR", onclick:""},
        buttonMminus : {id: "buttonMminus", type: "button", value: "M-", onclick:""},
        buttonMplus : {id: "buttonMplus", type: "button", value: "M+", onclick:""},
        //row 6
        buttonC : {id: "buttonC", type: "button", value: "C", onclick:""},
        buttonMC : {id: "buttonMC", type: "button", value: "MC", onclick:""},
        buttonequals : {id: "buttonequals", type: "button", value: "=", onclick:""}
    },

    Controller :
    {

        buttonHandler : function(that)
        {

            //special buttons
            switch(that.value)
            {
                case "C":
                calcDisplay.value = "";
                break;

                case "MC":
                //TODO clears memory value
                Calc.Model.memory = 0;
                break;

                case "MR":
                //TODO shows memory value on screen
                calcDisplay.value = Calc.Model.memory;
                break;

                case "M-":
                //TODO whatever is on screen gets subtracted from memory
                Calc.Model.memory = Calc.Model.memory - (calcDisplay.value);
                break;

                case "M+":
                //TODO whatever is on screen gets added to memory
                Calc.Model.memory = Calc.Model.memory + (calcDisplay.value);
                break;

                case "=":
                //TODO if repeated presses, will just show
                //result of last operation
                console.log("operands before calling equals " + Calc.Model.operands);
                //set the calcDisplay to the result of operation
                calcDisplay.value = Calc.Controller.equals(Calc.Model.operands, Calc.Model.operators);
                break;


                //default: add the value to the calcDisplay
                default: val = that.value;
                calcDisplay.value += val;

                //put the value into the array of operators
                //operators.push(that.value);
                Calc.Model.operators.push(that.value);
            }

        },


        equals : function(operands, operators)
        {

            console.log("operands in equals: " + operands);
            console.log("operators in equals: " + operators);
            var result;
            switch(operators[0])
            {
                case "+":
                result = (operands[0] + operands[1]);
                break;

                case "-":
                result = (operands[0] - operands[1]);
                break;

                case "*":
                result = (operands[0] * operands[1]);
                break;

                case "/":
                result = (operands[0] / operands[1]);
                break;

                case "~":
                //TODO result =
                break;

                case "%":
                //TODO result =
                break;

                case "<<":
                //TODO result =
                break;

                case ">>":
                //TODO result =
                break;

                case "&":
                //TODO result =
                break;

                case "|":
                //TODO result =
                break;


            }
            Calc.Model.operators.shift(operands[0]);
            Calc.Model.operands.shift(operands[0]);
            Calc.Model.operands.shift(operands[1]);
            return result;
        }


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
        s += "<tr><td>" + Calc.displayElement(Calc.View.calcDisplay) + "</td></tr>";
        s += "<tr><td>";
        s += Calc.displayElement(Calc.View.button1);
        s += Calc.displayElement(Calc.View.button0);
        s += Calc.displayElement(Calc.View.buttonnot);
        s += "<tr><td>"
        s += Calc.displayElement(Calc.View.buttonplus);
        s += Calc.displayElement(Calc.View.buttonmod);
        s += Calc.displayElement(Calc.View.buttonshiftleft);
        s += "<tr><td>"
        s += Calc.displayElement(Calc.View.buttonshiftright);
        s += Calc.displayElement(Calc.View.buttonminus);
        s += Calc.displayElement(Calc.View.buttonand);
        s += "<tr><td>"
        s += Calc.displayElement(Calc.View.buttonor);
        s += Calc.displayElement(Calc.View.buttonmult);
        s += Calc.displayElement(Calc.View.buttondiv);
        s += "<tr><td>"
        s += Calc.displayElement(Calc.View.buttonMR);
        s += Calc.displayElement(Calc.View.buttonMminus);
        s += Calc.displayElement(Calc.View.buttonMplus);
        s += "<tr><td>"
        s += Calc.displayElement(Calc.View.buttonC);
        s += Calc.displayElement(Calc.View.buttonMC);
        s += Calc.displayElement(Calc.View.buttonequals);
        s += "</tr></td></table>";
        return s;
    },

    attachHandlers : function()
    {
        //ATTACH HANDLER FOR EACH BUTTON
        Calc.View.button0.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.button1.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonC.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonnot.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttondiv.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonmod.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonmult.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonminus.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonplus.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonequals.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonMC.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonMR.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonMplus.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonMminus.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonand.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonor.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonshiftleft.onclick = "Calc.Controller.buttonHandler(this)";
        Calc.View.buttonshiftright.onclick = "Calc.Controller.buttonHandler(this)";

    },



} // end of Calc;
