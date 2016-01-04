<%-- 
    Document   : employees
    Created on : Jan 1, 2016, 10:17:33 PM
    Author     : Chong Cher
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.EmployeeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees</title>
    </head>
    <body>
    <table border="1">
        <tr>
            <th>Nric</th>
            <th>Name</th>
            <th>Nickname</th>
            <th>Citizenship</th>
            <th>Birthday</th>
            <th>Email</th>
            <th>Contact Number</th>
            <th>MOE Registration</th>
            <th>Fulltime</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%
            ArrayList<ArrayList<String>> employees = EmployeeDAO.getAllEmployees(); //TODO fail gracefully!
            for (ArrayList<String> employee : employees) {
        %>
        <tr>
            <%
                for (String s : employee) {
            %>
            <td><%= s%></td>
            <%
                }
            %>
            <td>edit</td>
            <td>delete</td>
        </tr>
        <%
            }
        %>
    </table>
    
    Add employees
    </body>
</html>
