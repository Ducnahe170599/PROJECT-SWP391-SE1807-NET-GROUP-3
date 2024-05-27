<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Content</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"], textarea, input[type="number"] {
            width: 300px;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .container {
            width: 400px;
            margin: auto;
            padding-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add New Content</h1>
        <form action="quiz" method="post">
            <input type="hidden" name="action" value="add"/>
            <label for="content">Content:</label>
            <input type="text" id="content" name="content" required>

            <label for="description">Description:</label>
            <textarea id="description" name="description" required></textarea>

            <label for="duration">Duration (in minutes):</label>
            <input type="number" id="duration" name="duration" required min="1">

            <input type="submit" value="Submit">
        </form>
        <a href="quiz?action=view">Tro ve trang list</a>
    </div>
</body>
</html>