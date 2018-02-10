var servletURL = "A6Servlet";
var restURL = "http://localhost:51931/InstallationsREST/webapi";

//global data
var selectedInstallationID = null;
var installations = null;
var alarmDefinitions = null;
var pivotTable = null;
var alarmHistory = null;

function loadInstallations() {
    console.log("loadInstallations");
    var url = restURL + "/installations";
    alarmDefinitions = null;
    pivotTable = null;
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
    if (installations != null)
    {
        for (var key in installations) {
            var installation = installations[key];
            var id = installation.id;
            var nname = installation.nname;
            text += "<OPTION value ='" + key + "' ";

            if (selectedInstallationID != null && selectedInstallationID == key)
            {
                text += "selected";
            }
            text += " >" + installations[key] + "</OPTION>";
        }
    } else {
        text += "<option value='0'>Error</option>";
    }
    $("#select_installation").html(text);
}

function loadAlarmDefinitions() {

    console.log("loadAlarmDefinitions");
    if (selectedInstallationID != null)
    {
        var url = restURL + "/installations/" + selectedInstallationID + "/alarmTypes";
        $.get(url, function (data, status) {
            if (status === "success")
            {
                alarmDefinitions = data;
            } else
            {
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

    if (selectedInstallationID != null)
    {
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

    } else
    {
        text += "<P>Error, no Alarm Definitions Loaded</P>";
    }
    $("#div_report").html(text);
}

function loadPivot() {
    console.log("loadPivot");
    if (selectedInstallationID != null)
    {
        var url = restURL + "/installations/" + selectedInstallationID + "/pivot?from=" + $("#startdate").val() + "&to=" + $("#enddate").val();
        $.get(url, function (data, status) {
            if (status === "success")
            {
                pivotTable = data;
            } else
            {
                pivotTable = null;
                console.log("loadPivot() failed");
            }
        });
    } else
        console.log("loadPivot() selectedInstallationID != undefined");
}
function displayPivot() {
    console.log("displayPivot");
    var text = "<h1>Pivot</h1>";

    if (pivotTable != null)
    {
        histogramLength = 15;
        text += "<TABLE>";
        text += "<TR>";
        if (alarmDefinitions != null)
        {
            text += "<TH>system</TH>";
            text += "<TH>subSystem</TH>";
            text += "<TH>messageType</TH>";
            text += "<TH>alarmPriority</TH>";
            text += "<TH>tagName</TH>";
            text += "<TH>description</TH>";
        } else {
            text += "<TH>Alarm ID</TH>";
        }
        for (col = 0; col < histogramLength; col++)
        {
            text += "<TH>Date " + col + "</TH>";
        }
        text += "</TR>";

        for (var key in pivotTable) {

            if (alarmDefinitions != null)
            {
                var alarmType = alarmDefinitions[key];
                if (alarmType != null) {
                    text += "<TD>" + alarmType.system + "</TD>";
                    text += "<TD>" + alarmType.subSystem + "</TD>";
                    text += "<TD>" + alarmType.messageType + "</TD>";
                    text += "<TD>" + alarmType.alarmPriority + "</TD>";
                    text += "<TD>" + alarmType.tagName + "</TD>";
                    text += "<TD>" + alarmType.description + "</TD>";
                }
            } else
            {
                text += "<TR><TH>" + key + "</TH>";
            }

            var histogram = pivotTable[key];
            for (i = 0; i < histogram.length; i++)
            {
                text += "<TD>";
                if (histogram[i] > 0)
                    text += histogram[i];
                text += "</TD>";
            }
            text += "</TR>";
        }
        text += "</TABLE>";
    } else
    {
        text += "<P>Error, no Alarm Pivot Loaded</P>";
    }
    $("#div_report").html(text);

}

function displayLogin(data, status) {
    if (data.a6athentication == true)
    {
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

function loadAlarmHistory() {
    console.log("loadAlarmHistory");
    if (selectedInstallationID != null)
    {
        var url = restURL + "/installations/" + selectedInstallationID + "/history"
                + "?from=" + $("#historyStartDate").val() + "&time=" + $("#historyStartTime").val();
        $.get(url, function (data, status) {
            if (status === "success")
            {
                alarmHistory = data;
                displayAlarmHistory();
            } else
            {
                alarmHistory = null;
                console.log("loadAlarmHistory() failed");
            }
        });
    } else
        console.log("loadAlarmHistory() selectedInstallationID != undefined");
}

function displayAlarmHistory() {
    console.log("displayAlarmHistory");
    var text = "<h1>History</h1>";
    text += "<ul>";
    text += "<li >Start Date <input type='text' name='historyStartDate' id ='historyStartDate' value='2018-01-01' /></li>";
    text += "<li >Time <input type='text' name='historyStartTime' id ='historyStartTime' value='00:00:00' /></li>";
    text += "<li ><button id='button_loadHistory' >Load</button></li>";

    if (alarmHistory != null){
        text += "<li><TABLE>";
        text += "<TR>";
        text += "<TH>Time</TH>";
        text += "<TH>Status</TH>";
        if (alarmDefinitions != null) {
            text += "<TH>System</TH><TH>SubSystem</TH><TH>Type</TH><TH>Priority</TH><TH>TagName</TH><TH>Description</TH>";
        } else{
            text += "<TH>Alarm ID</TH>";
        }
        text += "</TR>";

        for (row = 0; row < alarmHistory.length; row++) {
            var alarmData = alarmHistory[row];
            if (alarmData != null) {
                text += "<TR>";
                text += "<TD>" + alarmData.alarmTime + "</TD>";
                text += "<TD>" + alarmData.alarmStatus + "</TD>";
                if (alarmDefinitions != null) {
                    var alarmType = alarmDefinitions[alarmData.idAlarmType];
                    if (alarmType != null) {
                        text += "<TD>" + alarmType.system + "</TD>";
                        text += "<TD>" + alarmType.subSystem + "</TD>";
                        text += "<TD>" + alarmType.messageType + "</TD>";
                        text += "<TD>" + alarmType.alarmPriority + "</TD>";
                        text += "<TD>" + alarmType.tagName + "</TD>";
                        text += "<TD>" + alarmType.description + "</TD>";
                    }
                } else {
                    text += "<TD>" + alarmData.idAlarmType + "</TD>";
                }
                text += "</TR>";
            }
        }
        text += "</TABLE><li>";
    } else {
        text += "<li>Nothing Loaded</li>";
    }
    text += "</UL>";
    $("#div_report").html(text);
    $("#button_loadHistory").click(loadAlarmHistory);
}

function selectInstallation() {
    console.log("selectInstallation");
    selectedInstallationID = $("#select_installation").val();
    loadAlarmDefinitions();
    loadPivot();
    $("#reportButtons").show();
}

$(document).ready(function () {


    $("#button_login").click(clickLogin);
    $("#button_logout").click(clickLogout);
    $("#button_LoadAlarmDefinitions").click(displayAlarmDefinitions);
    $("#button_LoadPivot").click(displayPivot);
    $("#button_AlarmHistoryPage").click(displayAlarmHistory);
    $("#select_installation").on("change", selectInstallation);
});

