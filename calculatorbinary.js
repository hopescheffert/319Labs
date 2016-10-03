// CALCULATORBINARY.JS

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
        button1 : {id: "button1", type: "button", value: 1, onclick:""},
        button0 : {id: "button0", type: "button", value: 0, onclick:""},
        buttonnot : {id: "buttonnot", type: "button", value:"~", onclick:""},
        //row 2
        buttonplus : {id: "buttonplus", type: "button", value: "+", onclick:""},
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
        {//if it's an operand: add it to the calcDisplay and expression
        if((that.value != "C") && (that.value != "MC") && (that.value != "MR") &&
        (that.value != "M-") && (that.value != "M+") && (that.value != "="))
        {
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
                //clear operands & operators arrays & expr string
                Calc.Model.operands = [];
                Calc.Model.operators = [];
                Calc.Model.expr = "";
                break;

                case "MC":
                Calc.Model.memory = 0;
                break;

                case "MR":
                calcDisplay.value = Number(Calc.Model.memory);
                break;

                case "M-":
                Calc.Model.memory = Number(Calc.Model.memory - calcDisplay.value);
                break;

                case "M+":
                Calc.Model.memory = Number(Calc.Model.memory + calcDisplay.value);
                break;

                case "=":
                //TODO if repeated presses, will just show result of last operation

                //send to parseExpression to get operators and operands
                Calc.Controller.parseExpression(Calc.Model.expr);
                //set the calcDisplay to the result of operation
                calcDisplay.value = Calc.Controller.equals(Calc.Model.operands, Calc.Model.operators);
                break;

                //default: add the value to the calcDisplay
                default: val = that.value;
                calcDisplay.value += val + " ";

                //put the value into the array of operators
                Calc.Model.operators.push(that.value);
            }
        }

    },
    //parse the expression given for the operands and operators
    //*modifies expr so after this function is called expr is an empty string
    parseExpression : function(expr)
    {
        //get operators
        for(var j = 0; j < expr.length; j ++)
        {
            if((expr.charAt(j) == '+') || (expr.charAt(j) == '-') || (expr.charAt(j) == '*') || (expr.charAt(j) == '/')
                || (expr.charAt(j) == '~') || (expr.charAt(j) == '<<') || (expr.charAt(j) == '>>') || (expr.charAt(j) == '&')
                || (expr.charAt(j) == '|'))
            {
                Calc.Model.operators.push(expr.charAt(j));
            }
        }
        //get operands
        var i = 0;
        while(expr.length > 0)
        {
            console.log("expr is " + expr);
            //get first number from expr string
            var oplength = parseInt(expr).toString().length;
            var op = parseInt(expr, 2);
            console.log("op is " + op);
            if(!(isNaN(op)))
            {
                Calc.Model.operands.push(op);
                //shorten expr string
                expr = expr.substring(oplength);
                i++;
            }
            else
            {
                //skip this character (it's an operator)
                expr = expr.substring(i);
                i = 0;
            }
            console.log("i is " + i +" and expr is " + expr);
        }

    },
    //evaluates expr
    equals : function(operands, operators)
    {

        console.log("operands in equals: " + operands);
        console.log("operators in equals: " + operators);

        var result;
        switch(operators[0])
        {
            case "+":
            result = ((operands[0] + operands[1]) >>> 0).toString(2);
            break;

            case "-":
            result = ((operands[0] + operands[1]) >>> 0).toString(2);
            break;

            case "*":
            result = ((operands[0] * operands[1]) >>> 0).toString(2);
            break;

            case "/":
            result = ((operands[0] / operands[1]) >>> 0).toString(2);
            break;

            case "~":
            result = (~ operands[0]).toString(2);
            break;

            case "<<":
            result = (operands[0] << 1).toString(2);
            break;

            case ">>":
            result = (operands[0] >> 1).toString(2);
            break;

            case "&":
            result = (operands[0] & 1).toString(2);
            break;

            case "|":
            result = (operands[0] | 1).toString(2);
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
