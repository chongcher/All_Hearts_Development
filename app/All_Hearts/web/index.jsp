<%-- 
    Document   : index
    Created on : Dec 12, 2015, 2:52:06 PM
    Author     : ccchia.2014
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Hearts</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <!-- no point encrypting, attackers will just sniff the hash anyway-->
                    <!-- use https://letsencrypt.org/ to secure connection-->
                    <td>Password</td>
                    <td><input type="password" name="password"></td>
                </tr>
            </table>
            <button type="submit" onclick="">Login</button>
        </form>
    </body>
</html>