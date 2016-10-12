// MATCH.JS
// Shows 8 buttons. You click one. Now, you try and find a match in
// one of the remaining buttons. Like memory match.
//

// Note Match here is an object that consists of several objects.
//
var Match = {

    Model : {
        oldVal : undefined
    },

    View: {
        button1 : {id: "button1", type: "button", value: "", onclick:""},
        button2 : {id: "button2", type: "button", value: "", onclick:""},
        button3 : {id: "button3", type: "button", value: "", onclick:""},
        button4 : {id: "button4", type: "button", value: "", onclick:""},
        button5 : {id: "button5", type: "button", value: "", onclick:""},
        button6 : {id: "button6", type: "button", value: "", onclick:""},
        button7 : {id: "button7", type: "button", value: "", onclick:""},
        button8 : {id: "button8", type: "button", value: "", onclick:""},
        label : {id: "label", type: "label", value: "Click a Cell", onclick:""},
    },

    Controller: {
        buttonHandler : function(that) {
            if (Match.Model.oldVal == undefined) {
                that.style.color = "blue";
                Match.oldVal = that.value;
                console.log("Made it visible");
                document.getElementById("label").value = "Click a blank cell";
            }
            else if (that.value == Match.oldVal) {
                document.getElementById("label").value = "Found Match";
                that.style.color = "blue";
                Match.Model.oldVal = undefined;
            }
            else {
                document.getElementById("label").value = "Not Matched";
            }

        }

    },

    run : function() {
        Match.assignButtonValues();
        Match.attachHandlers();
        console.log(Match.displayAll());
        return Match.displayAll();
    },

    displayAll : function() {
        var s;
        s = "<table id=\"myTable\" border=2>"
        s += "<tr><td>";
        s += Match.displayElement(Match.View.button1);
        s += "</td><td>";
        s += Match.displayElement(Match.View.button2);
        s += "</td><td>";
        s += Match.displayElement(Match.View.button3);
        s += "</td><td>";
        s += Match.displayElement(Match.View.button4);
        s += "</td></tr>";
        s += "<tr><td>";
        s += Match.displayElement(Match.View.button5);
        s += "</td><td>";
        s += Match.displayElement(Match.View.button6);
        s += "</td><td>";
        s += Match.displayElement(Match.View.button7);
        s += "</td><td>";
        s += Match.displayElement(Match.View.button8);
        s += "</td></tr>";
        s += "<tr><td colspan=\"4\">" + Match.displayElement(Match.View.label) + "</td></tr>";
        s += "</table>";
        return s;
    },

    displayElement : function (element) {
        var s = "<input ";
        s += " id=\"" + element.id + "\"";
        s += " type=\"" + element.type + "\"";
        s += " value= \"" + element.value + "\"";
        s += " onclick= \"" + element.onclick + "\"";
        if (element.type == "button") {
            s += " style=\"color:white\"";
        }
        s += ">";
        return s;

    },

    assignButtonValues: function () {
        // loop over buttons
        var arrValues = [];
        // store 8 random values between 1 and 4 (some repeats)
        for (var i = 0; i < 9; i++) {
            arrValues.push(Math.floor(Math.random() * 4) + 1);
        }
        for (var i = 1; i <= 8; i++) {
            Match.View["button" + i].value = arrValues[i-1];
        }
        // May be the case that some values are repeated!

    },

    attachHandlers : function() {
        for (var i = 1; i <= 8; i++) {
            Match.View["button" + i].onclick ="Match.Controller.buttonHandler(this)";
        }
    },


} // end of Match;
