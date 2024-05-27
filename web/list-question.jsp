<%-- 
    Document   : Show
    Created on : 21 thg 5, 2024, 01:39:18
    Author     : minh1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Manage Questions List</title>
        <!-- Include CSS libraries (e.g., Bootstrap) -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Manage Questions List </h1>
            <!-- Thanh công cụ lọc và tìm kiếm -->
            <div class="row">
                <div class="col-md-2">
                    <select id="subject-filter" class="form-control">
                        <option value="">Subject</option>
                        <!-- Các tùy chọn môn học -->
                    </select>
                </div>
                <div class="col-md-2">
                    <select id="lesson-filter" class="form-control">
                        <option value="">Lesson</option>
                        <!-- Các tùy chọn bài học -->
                    </select>
                </div>


                <div class="col-md-2">
                    <input type="text" id="search-content" class="form-control" placeholder="Search">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-2">

                    <button  id="filter-button" class="btn btn-primary">Filter</button>
                </div>
            </div>


           
            <a href="Add.jsp" class="btn btn-primary">Import Questions</a>

            <!-- Bảng danh sách câu hỏi -->
            <table class="table mt-3">
                <tr>
                    <th>QuestionID</th>
                    <th>QuestionDetail</th>
                    <th>QuizId</th>

                </tr>
                <c:forEach items="${listS}" var="o">
                    <tr>
                        <td>${o.getQuestionID()}</td>
                        <td>${o.getQuestionDetail()}</td>
                        <td>${o.getQuizId()}</td>

                        <td>
                            <a href="#">Update</a>
                            <a href="delete?qid=${o.getQuestionID()}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <c:forEach begin="1" end="${endP}" var="i">
                <span style="margin-right: 10px;">
                    <a href="load?index=${i}">${i}</a>
                </span>
            </c:forEach>
            <!-- Nút nhập câu hỏi -->


            <!-- Pop-up nhập câu hỏi (sử dụng Bootstrap modal) -->

        </div>

        <!-- Include JS libraries (e.g., jQuery, Bootstrap JS) -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

        <script>
            // JavaScript để xử lý lọc, tìm kiếm, và quản lý danh sách câu hỏi
            document.getElementById('filter-button').addEventListener('click', function () {
                // Lấy giá trị từ các trường lọc
                var subject = document.getElementById('subject-filter').value;
                var lesson = document.getElementById('lesson-filter').value;
                var dimension = document.getElementById('dimension-filter').value;
                var level = document.getElementById('level-filter').value;
                var status = document.getElementById('status-filter').value;
                var searchContent = document.getElementById('search-content').value;

                // Thực hiện lọc và cập nhật danh sách câu hỏi
                // (Cần thêm logic gọi API hoặc lọc dữ liệu từ danh sách hiện tại)
            });

            // Xử lý hiển thị pop-up nhập câu hỏi
            document.getElementById('import-question-button').addEventListener('click', function () {
                $('#importQuestionModal').modal('show');
            });
        </script>
    </body>
</html>
