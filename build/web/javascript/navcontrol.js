var servletURL = "A6Servlet";
var restURL = "http://localhost:51931/InstallationsREST/webapi";

//global data
var selectedInstallationID = null;
var installations = null;
var alarmDefinitions = null;



function loadInstallations() {
    console.log("loadInstallations");
    var url = restURL + "/installations";
    alarmDefinitions = null;
    pivotTableRows = null;
    pivotTableWidth = 0;
    history = null;
    $.get(url, function (data, status) {
        if (status === "success")
        {
            installations = data;
            displayInstallations();
        } else
        {
            installations = null;
            console.log("loadInstallations() failed");
        }
    });
}
function displayInstallations() {
    console.log("displayInstallations");
    var text = "";
    if (installations != null) {
        for (var key in installations) {
            var installation = installations[key];
            var id = installation.id;
            var nname = installation.nname;
            text += "<OPTION value ='" + key + "' ";
            if (selectedInstallationID == null) {
                selectedInstallationID = id;
            }
            if (selectedInstallationID == id) {
                text += "selected";
            }
            text += " >" + installations[key] + "</OPTION>";
        }
    } else {
        text += "<option value='0'>Error</option>";
    }

    $("#select_installation").html(text);
    loadAlarmDefinitions();
}

function loadAlarmDefinitions() {
    console.log("loadAlarmDefinitions");
    if (selectedInstallationID != null) {
        var url = restURL + "/installations/" + selectedInstallationID + "/alarmTypes";
        $.get(url, function (data, status) {
            if (status === "success") {
                alarmDefinitions = data;
            } else {
                alarmDefinitions = null;
                console.log("loadAlarmDefinitions() failed");
            }
        });
    } else
        console.log("loadAlarmDefinitions() selectedInstallationID != undefined");
}
function displayAlarmDefinitions() {
    console.log("displayAlarmDefinitions");
    var text = "<h1>Alarm Definitions</h1>";

    if (selectedInstallationID != null) {
        text += "<TABLE>";
        text += "<TR>";
        text += "<TH>System</TH><TH>SubSystem</TH><TH>messageType</TH><TH>alarmPriority</TH><TH>id</TH><TH>tagName</TH><TH>description</TH></TR>";
        for (var key in alarmDefinitions) {
            var alarmType = alarmDefinitions[key];
            text += "<TR>";
            text += "<TD>" + alarmType.system + "</TD>";
            text += "<TD>" + alarmType.subSystem + "</TD>";
            text += "<TD>" + alarmType.messageType + "</TD>";
            text += "<TD>" + alarmType.alarmPriority + "</TD>";
            text += "<TD>" + alarmType.id + "</TD>";
            text += "<TD>" + alarmType.tagName + "</TD>";
            text += "<TD>" + alarmType.description + "</TD>";
            text += "</TR>";
        }
        text += "</TABLE>";
    } else {
        text += "<P>Error, no Alarm Definitions Loaded</P>";
    }
    $("#div_report").html(text);
}

function displayLogin(data, status) {
    if (data.a6athentication == true) {
        $("#loggedout").hide();
        $("#loggedin").show();
        $("#div_report").html("<h1>Welcome</h1>");
    }
    $("#div_report").html(data);
    loadInstallations();
}
function displayLogout(data, status) {
    $("#loggedout").show();
    $("#loggedin").hide();
    $("#password").val("");
    $("#div_report").html("<h1>Please login</h1>");

    $("#div_report").html(data);
}
function clickLogin() {
    var data = {
        "reportname": "login",
        "user": $("#user").val(),
        "password": $("#password").val()
    };
    $.post(servletURL, data, displayLogin);
}
function clickLogout() {
    var data = {
        "reportname": "logout",
        "user": $("#user").val(),
        "password": $("#password").val()
    };
    $.post(servletURL, data, displayLogout);
}


function selectInstallation() {
    console.log("selectInstallation");
    selectedInstallationID = $("#select_installation").val();
    loadAlarmDefinitions();

    $("#reportButtons").show();
}

$(document).ready(function () {
    $("#button_login").click(clickLogin);
    $("#button_logout").click(clickLogout);
    $("#button_LoadAlarmDefinitions").click(displayAlarmDefinitions);
    $("#select_installation").on("change", selectInstallation);
});

