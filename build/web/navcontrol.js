var servletURL = "A6Servlet";
var restTestURL = "RestServlet";
var pivotURL = "webapi/pivot";

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

function clickUniqueAlarms() {

    var data = {
        "reportname": "uniquealarms",
        "startdate": $("#startdate").val(),
        "enddate": $("#enddate").val()
    };
    $.post(servletURL, data, function (data, status) {
        $("#div_report").html("<h1>Unique Alarms Report</h1><P>" + data.reportname + "</P>");
    });
}

function clickAlarmRate() {

    var data = {
        reportname: "alarmrate",
        startdate: $("#startdate").val(),
        enddate: $("#enddate").val()
    };
    $.post(servletURL, data, function (data, status) {

        $("#div_report").html("<h1>Alarms Rate Report</h1><P>" + data.reportname + "</P>");
    });
}

function clickTestRest() {

    var data = {
        reportname: "testrest",
        startdate: $("#startdate").val(),
        enddate: $("#enddate").val()
    };
    $.post(restTestURL, data, function (data, status) {

        var text = "<h1>Test Rest</h1>";
        text += "<TABLE>";
        for (var key in data) {
            var value = data[key];
            text += "<TR><TH>" + key + "</TH><TD>" + value + "</TD></TR>";
        }
        text += "</TABLE>";
        $("#div_report").html(text);
    });
}

function clickPivot() {

    var data = {
        reportname: "pivot",
        startdate: $("#startdate").val(),
        enddate: $("#enddate").val()
    };
    $.get(pivotURL, data, function (data, status) {

        var text = "<h1>Test Pivot</h1>";
        text += "<TABLE>";
        for (var key in data) {
            var value = data[key];
            text += "<TR><TH>" + key + "</TH><TD>" + value + "</TD></TR>";
        }
        text += "</TABLE>";
        $("#div_report").html(text);
    });
}

$(document).ready(function () {
    $("#button_login").click(clickLogin);
    $("#button_logout").click(clickLogout);
    $("#button_UniqueAlarms").click(clickUniqueAlarms);
    $("#button_AlarmRate").click(clickAlarmRate);
    $("#button_TestRest").click(clickTestRest);
    $("#button_Pivot").click(clickPivot);
});

