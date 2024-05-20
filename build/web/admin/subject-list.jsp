<%-- 
    Document   : subject-list
    Created on : May 19, 2024, 6:28:45 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Subjects List</title>
        <link rel="stylesheet" href="styles.css">
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }

            .container {
                display: flex;
                flex-direction: column;
                width: 85%;
                margin: 20px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h1 {
                text-align: center;
                margin-bottom: 20px;
            }

            .filters {
                display: flex;
                justify-content: space-between;
                margin-bottom: 20px;
            }

            .filters div,
            .filters form {
                display: flex;
                align-items: center;
            }

            .filters label {
                margin-right: 10px;
            }

            .filters select,
            .filters input {
                padding: 5px;
                margin-right: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            .filters button {
                padding: 5px 10px;
                border: none;
                border-radius: 3px;
                background-color: #4CAF50;
                color: white;
                cursor: pointer;
            }

            .filters button:hover {
                background-color: #45a049;
            }

            .add-new {
                text-align: right;
                margin-bottom: 20px;
            }

            .add-new a {
                padding: 10px 20px;
                background-color: #007BFF;
                color: white;
                text-decoration: none;
                border-radius: 3px;
            }

            .add-new a:hover {
                background-color: #0056b3;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }

            table,
            th,
            td {
                border: 1px solid #ddd;
            }

            th,
            td {
                padding: 12px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
            }

            th,
            td:nth-child(1) {
                text-align: center;
            }

            .pagination {
                text-align: center;
                margin-top: 20px;
            }

            .pagination a {
                color: black;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
                transition: background-color .3s;
                border: 1px solid #ddd;
                margin: 0 4px;
            }

            .pagination a.active {
                background-color: #4CAF50;
                color: white;
                border: 1px solid #4CAF50;
            }

            .pagination a:hover:not(.active) {
                background-color: #ddd;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <h1>Subjects List</h1>
            <div class="filters">
                <form id="searchForm">
                    <label for="search">Search by Name:</label>
                    <input value="${txtSearch}" type="text" id="search" name="txtSearch" placeholder="Subject name">
                    <button type="submit">Search</button>
                </form>
                <div>
                    <label for="categoryFilter">Category:</label>
                    <select class="filterDropdown" id="categoryFilter">
                        <option value="all">All</option>
                        <c:forEach items="${listca}" var="c">
                            <option value="${categoryId}">${c.name}</option>
                        </c:forEach>
                    </select>
                    <label for="packageFilter">Package:</label>
                    <select class="filterDropdown" id="packageFilter">
                        <option value="all">All</option>
                        <c:forEach items="${listp}" var="p">
                            <option value="${packageId}">${p.name}</option>
                        </c:forEach>
                    </select>
                    <button type="submit">Filter</button>
                </div>            
            </div>
            <div class="add-new">
                <a href="new-subject">Add New Subject</a>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Description</th>
                        <th>Number of Lessons</th>
                        <th>Package</th>
                        <th>Owner</th>
                        <th>Rating</th>
                        <th>Image</th>
                        <th>Create At</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody id="courseList">
                    <c:forEach items="${lists}" var="s">
                        <tr>
                            <td>${s.id}</td>
                            <td>${s.name}</td>
                            <td>${s.categoryName}</td>
                            <td>${s.description}</td>
                            <td>${s.numberOfLessons}</td>
                            <td>${s.packageName}</td>
                            <td>${s.userName}</td>
                            <td>${s.rating}</td>
                            <td>${s.image}</td>
                            <td>${s.date}</td>
                            <td>
                                <a href="subject-details.html?id=1">Edit</a>
                                <a href="subject-details.html?id=1">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <!-- Add more sample courses here -->
                </tbody>
            </table>
            <h3 style="color: blue; text-align: center">${mess}</h3>

            <div class="pagination">
                <a href="#">&laquo;</a>
                <c:forEach begin="1" end="${endPage}" var="i">
                    <!--<a href="#" class="active">1</a>-->
                    <a href="#">${i}</a>
                </c:forEach>
                <a href="#">&raquo;</a>
            </div>
        </div>
    </body>
</html>