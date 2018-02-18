var globalHistoryVars = {
    alarmHistory: null,
    restURL: "/installationrest/webapi"
};

function loadAlarmHistory() {
    console.log("loadAlarmHistory");
    if (selectedInstallationID != null) {
        var url = globalHistoryVars.restURL + "/installations/" + selectedInstallationID + "/history"
                + "?from=" + $("#historyStartDate").val() + "&time=" + $("#historyStartTime").val();
        $.get(url, function (data, status) {
            if (status === "success") {
                globalHistoryVars.alarmHistory = data;
                displayAlarmHistory();
            } else {
                globalHistoryVars.alarmHistory = null;
                console.log("loadAlarmHistory() failed");
            }
        });
    } else
        console.log("loadAlarmHistory() selectedInstallationID != undefined");
}
function displayAlarmHistory() {
    console.log("displayAlarmHistory");
    var text = "";
    if (globalHistoryVars.alarmHistory != null) {
        text += "<TABLE>";
        text += "<TR>";
        text += "<TH>Time</TH>";
        text += "<TH>Status</TH>";
        if (alarmDefinitions != null) {
            text += "<TH>System</TH><TH>SubSystem</TH><TH>Type</TH><TH>Priority</TH><TH>TagName</TH><TH>Description</TH>";
        } else {
            text += "<TH>Alarm ID</TH>";
        }
        text += "</TR>";

        for (row = 0; row < globalHistoryVars.alarmHistory.length; row++) {
            var alarmData = globalHistoryVars.alarmHistory[row];
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
        text += "</TABLE>";
    } else {
        text += "Nothing Loaded";
    }
    $("#alarmHistoryTable").html(text);
}
function displayAlarmHistoryPage() {
    console.log("displayAlarmHistoryPage");
    var text = "<h1>History</h1>";
    text += "<ul>";
    text += "<li >Start Date <input type='text' name='historyStartDate' id ='historyStartDate' value='2018-01-01' /></li>";
    text += "<li >Time <input type='text' name='historyStartTime' id ='historyStartTime' value='00:00:00' /></li>";
    text += "<li ><button id='button_loadHistory' >Load</button></li>";
    text += "<li id='alarmHistoryTable'>Nothing Loaded</li>";
    text += "</UL>";
    $("#div_report").html(text);
    $("#button_loadHistory").click(loadAlarmHistory);
}


$(document).ready(function () {
    $("#button_AlarmHistoryPage").click(displayAlarmHistoryPage);
});


