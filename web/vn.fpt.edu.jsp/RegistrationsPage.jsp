    


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registrations Page</title>
    </head>
    <body>

        <table class="table table-hover container" border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>email</th>
                    <th>registration time</th>
                    <th>subject</th>
                    <th>package</th>
                    <th>total cost</th>
                    <th>status</th>
                    <th>valid from</th>
                    <th>valid to</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="o">
                    <tr>
                        <td>${o.UserID}</td>
                        <td>${o.Email}</td>
                        <td>${o.CategoryID}</td>
                        <td>${o.PackageID}</td>
                        <td>${o.total_cost}</td>          
                        <td>${o.valid_from}</td>
                        <td>${o.valid_to}</td>
                        <td>${o.create_at}</td>
                        <td>
                            <c:choose>
                                <c:when test="${o.status == 0}">
                                    <span style="color: red;">Waiting...</span>
                                </c:when>
                                <c:when test="${o.status == 1}">
                                    <span style="color: green;">Success</span>
                                </c:when>
                            </c:choose>
                        </td>

                    </tr></c:forEach>
            </tbody>
        </table>
    </body>
</html>
