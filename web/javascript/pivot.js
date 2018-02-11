var globalPivotVars = {
    restURL: "http://localhost:51931/InstallationsREST/webapi",
    tableRows: null,
    tableWidth: 0
};

function buildRow(alarmType, histogram) {
    var row = {
        system: "alarmType.system",
        subSystem: "alarmType.subSystem",
        messageType: "alarmType.messageType",
        alarmPriority: "alarmType.alarmPriority",
        tagName: "alarmType.tagName",
        description: "alarmType.description",
        histogram: []
    };
    row.system = alarmType.system;
    row.subSystem = alarmType.subSystem;
    row.messageType = alarmType.messageType;
    row.alarmPriority = alarmType.alarmPriority;
    row.tagName = alarmType.tagName;
    row.description = alarmType.description;
    row.histogram = histogram;
    if (row.histogram.length > globalPivotVars.tableWidth)
        globalPivotVars.tableWidth = row.histogram.length;
    return row;
}
function loadPivot() {
    console.log("loadPivot");
    if (selectedInstallationID != null) {
        var url = globalPivotVars.restURL + "/installations/" + selectedInstallationID + "/pivot?from=" + $("#pivotStartDate").val() + "&to=" + $("#pivotEndDate").val();
        $.get(url, function (data, status) {
            if (status === "success") {
                globalPivotVars.tableWidth = 0;
                globalPivotVars.tableRows = [];
                for (var key in data) {
                    globalPivotVars.tableRows.push(buildRow(alarmDefinitions[key], data[key]))
                }
            } else {
                globalPivotVars.tableWidth = 0;
                globalPivotVars.tableRows = null;
                console.log("loadPivot() failed");
            }
            displayPivot();
        });
    } else
        console.log("loadPivot() selectedInstallationID != undefined");
}
function displayPivot() {
    console.log("displayPivot");
    var text = "";
    if (globalPivotVars.tableRows != null) {
        text += "<TABLE>";
        text += "<TR>";
        text += "<TH>system</TH>";
        text += "<TH>subSystem</TH>";
        text += "<TH>messageType</TH>";
        text += "<TH>alarmPriority</TH>";
        text += "<TH>tagName</TH>";
        text += "<TH>description</TH>";
        for (col = 0; col < globalPivotVars.tableWidth; col++) {
            text += "<TH>Date " + col + "</TH>";
        }
        text += "</TR>";

        for (i = 0; i < globalPivotVars.tableRows.length; i++) {
            var row = globalPivotVars.tableRows[i];
            text += "<TD>" + row.system + "</TD>";
            text += "<TD>" + row.subSystem + "</TD>";
            text += "<TD>" + row.messageType + "</TD>";
            text += "<TD>" + row.alarmPriority + "</TD>";
            text += "<TD>" + row.tagName + "</TD>";
            text += "<TD>" + row.description + "</TD>";
            var histogram = row.histogram;
            if (histogram != null) {
                for (column = 0; column < histogram.length; column++) {
                    text += "<TD>";
                    text += histogram[column];
                    text += "</TD>";
                }
            }
            text += "</TR>";
        }
        text += "</TABLE>";
    } else {
        text += "No Alarm Pivot Loaded";
    }
    $("#alarmPivotTable").html(text);
}
function displayPivotPage() {
    console.log("displayPivotPage");
    var text = "<h1>Pivot</h1>";
    text += "<ul>";
    text += "<li >Start Date <input type='text' name='pivotStartDate' id ='pivotStartDate' value='2018-01-01' /></li>";
    text += "<li >End Date <input type='text' name='pivotEndDate' id ='pivotEndDate' value='2018-01-31' /></li>";
    text += "<li ><button id='button_loadAlarmPivot' >Load</button></li>";
    text += "<li  id='alarmPivotTable'></li>";

    $("#div_report").html(text);
    $("#button_loadAlarmPivot").click(loadPivot);
}

$(document).ready(function () {
    $("#button_AlarmPivotPage").click(displayPivotPage);    
});
