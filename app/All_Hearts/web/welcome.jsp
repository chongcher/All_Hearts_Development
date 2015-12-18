<%-- 
    Document   : welcome
    Created on : Dec 13, 2015, 7:35:51 AM
    Author     : ccchia.2014
--%>

<%@page import="java.util.HashMap"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% User user = (User)session.getAttribute("user"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Hearts Adventure and Training</title>
    </head>
    <body>
        <h1>Welcome <%= user.getUsername() %></h1>
        <table>
            <%  
                HashMap<String,String> permissions = user.getPermissions();
                for(String key: permissions.keySet()){
                    String servletName = permissions.get(key);
                    if(servletName != null && !servletName.equals("")){%>
                    <tr>
                        <td><button action=<%= key %><%= servletName %></button></td>
                    </tr>
                    <%}
                }
            %>            
            <tr>
                <td></td>
            </tr>
        </table>
    </body>
</html>
