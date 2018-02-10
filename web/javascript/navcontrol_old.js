var servletURL = "A6Servlet";

function displayLogin(data, status) {
    if (data.a6athentication == true)
    {
        $("#loggedout").hide();
        $("#loggedin").show();
        $("#div_report").html("<h1>Welcome</h1>");
    }
    $("#div_report").html(data);
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

//global data
var installations;
var alarmDefinitions;
var pivotTable;
var history;

function clickLoadInstallations() {

    var url = "http://localhost:51931/InstallationsREST/webapi/installations";
    $.get(url, function (data, status) {
        installations = data;
        var text = "<h1>clickLoadInstallations</h1>";
        text += "<TABLE>";
        text += "<TR><TH>ID</TH><TH>Name</TH></TR>";
        for (var key in data) {
            var installation = data[key];
            var id = installation.id;
            var nname = installation.nname
            text += "<TR><TH>" + key + "</TH><TD>" + data[key] + "</TD></TR>";
        }
        text += "</TABLE>";
        $("#div_report").html(text);
    });
}

function clickLoadAlarmDefinitions() {
    var url = "http://localhost:51931/InstallationsREST/webapi/installations/2/alarmTypes";

    $.get(url, function (data, status) {
        alarmDefinitions = data;
        var text = "<h1>clickLoadInstallations</h1>";
        text += "<TABLE>";
        text += "<TR>";
        text += "<TH>System</TH><TH>SubSystem</TH><TH>messageType</TH><TH>alarmPriority</TH><TH>id</TH><TH>tagName</TH><TH>description</TH></TR>";
        for (var key in data) {
            var alarmType = data[key];
            text += "<TR>";
            // text += "<TD>"+alarmType.idInstallation+"</TD>";
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
        $("#div_report").html(text);
    });
}

function clickLoadPivot() {

    var url = "http://localhost:51931/InstallationsREST/webapi/installations/2/pivot";
    url += "?from=" + $("#startdate").val() + "&to=" + $("#enddate").val();

    $.get(url, function (data, status) {

        pivotTable = data;
        var text = "<h1>Test Pivot</h1>";
        text += "<TABLE>";
        text += "<TR><TH>Alarm ID</TH><TH>Date 1</TH><TH>Date 2</TH></TR>";
       
        for (var key in data) {
            var alarmTypeHistogram = data[key];
            text += "<TR><TH>" +  alarmTypeHistogram.alarmTypeId + "</TH>";
            text += "<TD>TODO this is incorrect, date set out of order</TD>"
            for (var date in alarmTypeHistogram.histogram)
            {
                var count = alarmTypeHistogram.histogram[date];
                text += "<TD>"+count+"</TD>"
            }
            text += "</TR>";
        }
        
        text += "</TABLE>";
        $("#div_report").html(text);
    });
}

function clickLoadAlarmHistory() {
    var url = "http://localhost:51931/InstallationsREST/webapi/installations/2/history";
    url += "?from=" + $("#startdate").val() + "&to=" + $("#enddate").val();

    $.get(url, function (data, status) {

        history = data;
        var text = "<h1>Test History</h1>";
        text += "<TABLE>";
        for (var key in data) {
            var alarmData = data[key];
           /* alarmData.id;
            alarmData.idInstallation;
            alarmData.idAlarmFile;
            alarmData.idAlarmType;
            alarmData.alarmStatus;
            alarmData.alarmTime;
            */
            
            
            if (alarmDefinitions !== undefined)
            {
                var alarmType = alarmDefinitions[alarmData.idAlarmType];
                
                text += "<TR>"
                text += "<TH>" + alarmData.alarmTime + "</TH>";
                text += "<TD>" + alarmData.idAlarmType + "</TD>";
                text += "<TD>" + alarmType.system + "</TD>";
                text += "<TD>" + alarmType.subSystem + "</TD>";
                text += "<TD>" + alarmType.messageType + "</TD>";
                text += "<TD>" + alarmType.alarmPriority + "</TD>";
                text += "<TD>" + alarmType.tagName + "</TD>";
                text += "<TD>" + alarmType.description + "</TD>";
                text += "<TD>" + alarmData.alarmStatus + "</TD>";
                text += "</TR>";
                
            }
            else
            {
                text += "<TR><TH>" + alarmData.alarmTime + "</TH><TD>" + alarmData.idAlarmType + "</TD><TD>" + alarmData.alarmStatus + "</TD></TR>";
            }
        }
        text += "</TABLE>";
        $("#div_report").html(text);
    });
}

function clickAlarmRateByHour() {

}

$(document).ready(function () {
    $("#button_login").click(clickLogin);
    $("#button_logout").click(clickLogout);
    $("#button_LoadInstallations").click(clickLoadInstallations);
    $("#button_LoadAlarmDefinitions").click(clickLoadAlarmDefinitions);
    $("#button_LoadPivot").click(clickLoadPivot);
    $("#button_LoadAlarmHistory").click(clickLoadAlarmHistory);
    $("#button_LoadAlarmRateByHour").click(clickAlarmRateByHour);
});

