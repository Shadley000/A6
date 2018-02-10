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
        <script src="javascript/navcontrol.js"> </script>
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
                <li >Installation <SELECT name='installation' id='select_installation'></SELECT></li>
                <DIV id='reportButtons' hidden>
                <li ><button id='button_AlarmPivotPage' >Pivot Table</button></li>
                <li ><button id='button_AlarmHistoryPage' >Alarm History</button></li>
                </DIV>
                <li ><button id='button_logout' >Logout</button></li>
            </ul>
        </div>
        <div id="div_report"><h2>Report Section</h2></div>
        <div id="div_footer"><P>footer</p></div>
        <div id="div_hidden" hidden></div>

    </body>
</html>