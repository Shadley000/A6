var servletURL = "A6Servlet"

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

$(document).ready(function () {
    $("#button_login").click(clickLogin);
    $("#button_logout").click(clickLogout);
    $("#button_UniqueAlarms").click(clickUniqueAlarms);
    $("#button_AlarmRate").click(clickAlarmRate);
});

