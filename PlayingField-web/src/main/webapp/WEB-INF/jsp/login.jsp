<%-- 
    Document   : login
    Created on : May 24, 2014, 11:52:11 AM
    Author     : Aklil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    
    <body>
        <h1>Login Page</h1>
        <form:form method="post" commandName="loginUser">
            <table border="1" align ="center">
                <tr>
                    <td>User Name</td>
                    <td><form:input path="userName"/></td>
                </tr> 
                <tr>
                    <td>Password</td>
                    <td><form:input path="password"/></td>
                </tr> 
                <tr>
                    <td><input type="submit" value="Login"/></td>
                </tr> 
                 <tr>
                     <td><a href="registration.htm">New User Registration</a></td>
                </tr> 
            </table>    
            
        </form:form>
    </body>
    
</html>
