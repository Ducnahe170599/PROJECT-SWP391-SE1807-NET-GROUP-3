<%-- 
    Document   : addSubject
    Created on : May 20, 2024, 9:32:05 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Subject</title>
    </head>

    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #e9ecef;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 40px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h1 {
            margin-bottom: 20px;
            font-size: 2em;
            color: #333;
        }

        .tabs {
            display: flex;
            margin-bottom: 20px;
        }

        .tab-link {
            background-color: #f8f9fa;
            border: 1px solid #dee2e6;
            padding: 10px 20px;
            margin-right: 10px;
            cursor: pointer;
            font-size: 16px;
            border-radius: 4px;
            transition: background-color 0.3s, border-color 0.3s;
        }

        .tab-link:hover,
        .tab-link.active {
            background-color: #007bff;
            color: #ffffff;
            border-color: #007bff;
        }

        .tab-content {
            display: none;
        }

        .tab-content.active {
            display: block;
        }

        form {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
        }

        label {
            margin: 10px 0 5px;
            font-weight: 500;
            color: #555;
        }

        input[type="text"],
        input[type="date"],
        select,
        textarea {
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
            box-sizing: border-box;
            font-size: 14px;
        }

        input[type="file"] {
            padding: 5px;
        }

        textarea {
            resize: vertical;
            height: 100px;
        }

        button {
            padding: 10px 20px;
            margin-top: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        button[type="submit"] {
            background-color: #28a745;
            color: white;
        }

        button[type="submit"]:hover {
            background-color: #218838;
        }

        button[type="button"] {
            background-color: #6c757d;
            color: white;
            margin-left: 10px;
        }

        button[type="button"]:hover {
            background-color: #5a6268;
        }
    </style>
    <body>
        <h2>Add New Subject</h2>
        <form action="addSubject" method="post">
            <label for="subjectName">Subject Name:</label><br>
            <input type="text" id="subjectName" name="subjectName"><br><br>
            <label for="description">Description:</label><br>
            <textarea id="description" name="description"></textarea><br><br>
            <label for="image">Image URL:</label><br>
            <input type="text" id="image" name="image"><br><br>
            <label for="lessonId">Lesson ID:</label><br>
            <input type="number" id="lessonId" name="lessonId"><br><br>
            <label for="packageId">Package ID:</label><br>
            <input type="number" id="packageId" name="packageId"><br><br>
            <label for="categoryId">Category ID:</label><br>
            <input type="number" id="categoryId" name="categoryId"><br><br>
            <label for="userId">User ID:</label><br>
            <input type="number" id="userId" name="userId" required><br><br>
            <label for="ratingId">Rating ID:</label><br>
            <input type="number" id="ratingId" name="ratingId"><br><br>
            <label for="createdAt">Created At:</label><br>
            <input type="date" id="createdAt" name="createdAt"><br><br>
            <input type="submit" value="Add Subject">
        </form>
    </body>
</html>
