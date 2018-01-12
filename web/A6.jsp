<%-- 
    Document   : A5
    Created on : Jan 8, 2018, 11:00:25 PM
    Author     : shadl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A5</title>
         <script src="displayReport.js"></script>
         <script src="login.js"></script>
    </head>
    <body>
        
        <div id="header">
            <h1>A5</h1>
        </div>
        <div id="nav">
            <UL>
                <li>User <input id="user" name="User" type="text"> </li>
                <li>Password <input id="password" name="Password" type="password"></li>
                <li><button type="button" onclick="login()">Login</button> </li>
                <li>navigation</ii>
                <li><button type="button" onclick="loadReport()">Report</button> </li>
                
                <li>
                    <form name="inputform" action="somewhere" method="post">
    <input type="hidden" value="person" name="user">
    <input type="hidden" value="password" name="pwd">
    <input type="hidden" value="place" name="organization">
    <input type="hidden" value="key" name="requiredkey">
</form>
                </li>
            </UL>
        </div>
        <div id="report">
                <h1>reports</h1>
        </div>
        
        </body>
</html>
