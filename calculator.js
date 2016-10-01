// CALCULATOR.JS

var Calc =
{

    Model :
    {
        //arrays for operators and operands
        operators : [],
        operands : [],
        expr: "",
        memory: 0
    },


    View :
    {
        //row 0
        calcDisplay : {id: "calcDisplay", type: "text", value: "", onclick:""},
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
            if((that.value != "C") && (that.value != "MC") && (that.value != "MR") &&
            (that.value != "M-") && (that.value != "M+") && (that.value != "="))
            {
                //Calc.Model.expr.push(that.value);
                Calc.Model.expr += that.value;
                calcDisplay.value += that.value;
            }
            else
            {
                //special buttons
                switch(that.value)
                {
                    case "C":
                    calcDisplay.value = "";
                    //clear operands & operators arrays
                    Calc.Model.operands = [];
                    Calc.Model.operators = [];
                    break;

                    case "MC":
                    //TODO clears memory value
                    Calc.Model.memory = 0;
                    break;

                    case "MR":
                    //TODO shows memory value on screen
                    calcDisplay.value = Number(Calc.Model.memory);
                    break;

                    case "M-":
                    //TODO whatever is on screen gets subtracted from memory
                    Calc.Model.memory = Number(Calc.Model.memory - calcDisplay.value);
                    break;

                    case "M+":
                    //TODO whatever is on screen gets added to memory
                    Calc.Model.memory = Number(Calc.Model.memory + calcDisplay.value);
                    break;

                    case "=":
                    //TODO if repeated presses, will just show
                    //result of last operation
                    //set the calcDisplay to the result of operation
                    console.log("calling equals");
                    Calc.Controller.parseExpression(Calc.Model.expr);
                    calcDisplay.value = Calc.Controller.equals(Calc.Model.operands, Calc.Model.operators);
                    break;

                    //default: add the value to the calcDisplay
                    default: val = that.value;
                    calcDisplay.value += val;

                    //put the value into the array of operators
                    //operators.push(that.value);
                    Calc.Model.operators.push(that.value);
                }
            }

        },
        parseExpression : function(expr)
        {
            //get operators
            for(var j = 0; j < expr.length; j ++)
            {
                if((expr.charAt(j) == '+') || (expr.charAt(j) == '-') || (expr.charAt(j) == '*') || (expr.charAt(j) == '/'))
                {
                    Calc.Model.operators.push(expr.charAt(j));
                }
            }
            //get operands
            console.log("expression " + expr);

            for(var i = 0; i < expr.length; i++)
            {
                var op = parseFloat(expr);
                Calc.Model.operands.push(parseFloat(expr));
                expr = expr.substring(op.toString().length);
            }

            //console.log("in parseExpression operators: " + Calc.Model.operators);
            console.log("in parseExpression operands: [" + Calc.Model.operands + "]");

        },


        //     //if that.value is a number or there is a dot, it's an operand
        //     if(!isNaN(that.value) || that.value == ".")
        //     {
        //         //otherwise it's a number button aka an operand
        //         calcDisplay.value += that.value;
        //         if(that.value == ".")
        //         {
        //             Calc.Model.operands.push(".");
        //         }
        //         else
        //         {
        //             //put the value into the array of operands
        //             //Calc.Model.operands.push(Number(that.value));
        //             Calc.Model.operands.push(that.value);
        //         }
        //
        //         console.log("operands "+ Calc.Model.operands.toString());
        //     }
        //     else
        //     {
        //         //special buttons
        //         switch(that.value)
        //         {
        //             case "C":
        //             calcDisplay.value = "";
        //             //clear operands & operators arrays
        //             Calc.Model.operands = [];
        //             Calc.Model.operators = [];
        //             break;
        //
        //             case "MC":
        //             //TODO clears memory value
        //             Calc.Model.memory = 0;
        //             break;
        //
        //             case "MR":
        //             //TODO shows memory value on screen
        //             calcDisplay.value = Number(Calc.Model.memory);
        //             break;
        //
        //             case "M-":
        //             //TODO whatever is on screen gets subtracted from memory
        //             Calc.Model.memory = Number(Calc.Model.memory - calcDisplay.value);
        //             break;
        //
        //             case "M+":
        //             //TODO whatever is on screen gets added to memory
        //             Calc.Model.memory = Number(Calc.Model.memory + calcDisplay.value);
        //             break;
        //
        //             case "=":
        //             //TODO if repeated presses, will just show
        //             //result of last operation
        //             //set the calcDisplay to the result of operation
        //             calcDisplay.value = Calc.Controller.equals(Calc.Model.operands, Calc.Model.operators);
        //             break;
        //
        //             //default: add the value to the calcDisplay
        //             default: val = that.value;
        //             calcDisplay.value += val;
        //
        //             //put the value into the array of operators
        //             //operators.push(that.value);
        //             Calc.Model.operators.push(that.value);
        //         }
        //
        //     }
        //
        //  },


        equals : function(operands, operators)
        {

            console.log("operands in equals starts as: " + operands);
            console.log("operators in equals starts as: " + operators);

            var i = operands.indexOf("."); //returns index where it finds "."
            console.log("i is "+ i);
            while(i != -1) //there is a dot
            {
                if(operands[i - 1] == undefined && operands[i + 2] != undefined) //this is a leading .
                {
                    //operands[i] = operands[i] + ".";
                    operands.push(operands[i] +  operands[i + 1]);
                    operands.shift();
                    operands.shift();
                    console.log("operands when before isn't there but after is: " + operands);

                }
                else if(operands[i - 1] != undefined && operands[i + 1] != undefined) //append to # before and after . form 1.5
                {
                    //operands[i] = (operands[i - 1] + "." + operands[i + 1]);

                    operands.push((operands[i - 1] + "." + operands[i + 1]));
                    operands.shift();
                    operands.shift();
                    operands.shift();

                    console.log("operands when both before and after are there: " + operands);

                }
                else if(operands[i - 1] != undefined && operands[i + 1] == undefined)
                {
                    //operands[i] = operands[i - 1] + "." + operands[i];
                    operands.push(operands[i - 1] + "." + operands[i]);

                    operands.shift();
                    operands.shift();
                    //operands.shift();
                    console.log("operands when before is there but no after: " + operands);

                }
                i = operands.indexOf(".",i); //check for another decimal
                console.log("now i is " + i);
                console.log("operands after if statements/before next while: " + operands);


            }

            var result;
            switch(operators[0])
            {
                case "+":
                result = (Number(operands[0]) + Number(operands[1]));
                break;

                case "-":
                result = (Number(operands[0]) - Number(operands[1]));
                break;

                case "*":
                result = (Number(operands[0]) * Number(operands[1]));
                break;

                case "/":
                result = (Number(operands[0]) / Number(operands[1]));
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
