<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vn.fpt.edu.beans.Registration" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.fpt.edu.dal.RegistrationsDAO" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrations</title>
</head>
<body>
<h2>Registrations</h2>
<table border="1">
<tr>
    <th>RegisterID</th>
    <th>UserID</th>
    <th>SubjectID</th>
    <th>PackageID</th>
    <th>Total Cost</th>
    <th>Status</th>
    <th>Valid From</th>
    <th>Valid To</th>
    <th>Created At</th>
</tr>
<%
    RegistrationsDAO registrationsDAO = new RegistrationsDAO();
    try {
        List<Registration> registrations = registrationsDAO.getAllRegistrations();
        for (Registration registration : registrations) {
%>
            <tr>
                <td><%= registration.getRegisterID() %></td>
                <td><%= registration.getUserID() %></td>
                <td><%= registration.getSubjectID() %></td>
                <td><%= registration.getPackageID() %></td>
                <td><%= registration.getTotalCost() %></td>
                <td><%= registration.getStatus() %></td>
                <td><%= registration.getValidFrom() %></td>
                <td><%= registration.getValidTo() %></td>
                <td><%= registration.getCreatedAt() %></td>
            </tr>
<%
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
</table>
</body>
</html>