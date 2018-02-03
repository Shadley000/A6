<%-- 
    Document   : index.jsp
    Created on : Jan 28, 2018, 7:45:19 AM
    Author     : shadl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>A6 Alarm Manager</title>
        <link rel="stylesheet" href="styles.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="navcontrol.js"> </script>
    </head>
    <body>

        <div id="div_header"><h1>A6 Alarm Manager</h1>
        </div>
        <div id="div_nav"><h2>Navigation</h2>
            <ul id="loggedout">
                <li >User <input type='text' id ='user' value='guest' /></li>
                <li >Password<input type='password' id ='password' value='password' /></li>
                <li ><button id='button_login'>Login</button></li>
            </ul>

            <ul id="loggedin" hidden>
                <li >Start Date <input type='text' name="startDate" id ='startdate' value='01/01/2018' /></li>
                <li >End Date <input type='text' name="endDate" id ='enddate' value='01/10/2018' /></li>
                <li ><button id='button_UniqueAlarms'>Unique Alarms Report</button></li>
                <li ><button id='button_AlarmRate'>Alarm Rate</button></li>
                <li ><button id='button_TestRest'>Test Rest</button></li>
                <li ><button id='button_Pivot' >Pivot</button></li>
                <li ><button id='button_logout' >Logout</button></li>
            </ul>
        </div>
        <div id="div_report"><h2>Report Section</h2></div>
        <div id="div_footer"><P>footer</p></div>
        <div id="div_hidden" hidden></div>

    </body>
</html>