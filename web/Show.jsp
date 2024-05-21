<%-- 
    Document   : Show
    Created on : 21 thg 5, 2024, 01:39:18
    Author     : minh1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<!------ Include the above in your HEAD tag ---------->

<html>
    <form >


     
      <table border="1px solid black">
                <tr>
                    <th>QzQuestionID</th>
                    <th>QuestionDetail</th>
                    <th>QuizId</th>
                   
                </tr>
                <c:forEach items="${listS}" var="o">
                <tr>
                    <td>${o.getQzQuestionID()}</td>
                    <td>${o.getQuestionDetail()}</td>
                    <td>${o.getQuizId()}</td>
                    
                    <td>
                        <a href="#">update</a>
                        <a href="delete?qid=${o.getQzQuestionID()}">delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
<a href="Add.jsp">Create </a>   
</form>
</html>
