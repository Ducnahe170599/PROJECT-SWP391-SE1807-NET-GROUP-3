<%-- 
    Document   : quiz-list
    Created on : May 21, 2024, 11:51:54 AM
    Author     : Datnt
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Subject List</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
                padding: 10px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
            .action-links a {
                color: blue;
                text-decoration: none;
                margin-right: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Quiz List</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Content</th>
                    <th>Description</th>
                    <th>Image</th>
                    <th>Category</th>
                    <th>Duration</th>
                    <th>Rating</th>
                    <th>Level</th>
                    <th>Created At</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${QUIZS}" var="quiz">
                    <tr>
                        <td>${quiz.quizId}</td>
                        <td>${quiz.quizContent}</td>
                        <td>${quiz.quizDescription}</td>
                        <td><img src="path_to_image" alt="Physics" style="width:50px;height:50px;"></td>
                        <td>...</td>     
                        <td>${quiz.duration}</td>
                        <th>Rating</th>
                        <th>Level</th>
                         <th>2020-04-20</th>
                          <td class="action-links">
                            <a href="editSubject?id=1">Edit</a>
                            <a href="deleteSubject?id=1">Delete</a>
                        </td>
                        </c:forEach>

                </tr>
            </tbody>
        </table>
        <a href="quiz?action=add">Add new Quiz</a>
    </body>
</html>
