<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registrations</title>
    <style>
        /* Thêm CSS để tùy chỉnh giao diện */
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h1>Registrations</h1>
    <input type="text" id="search" placeholder="Search by Subject">
    <table id="registrationsTable">
        <thead>
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
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <!-- Data sẽ được thêm vào đây bởi JavaScript -->
        </tbody>
    </table>

    <script>
        // Fetch data từ servlet và hiển thị trên bảng
        function fetchData() {
            fetch('registrations')
                .then(response => response.json())
                .then(data => {
                    const tableBody = document.querySelector('#registrationsTable tbody');
                    tableBody.innerHTML = '';
                    data.forEach(registration => {
                        const row = document.createElement('tr');
                        row.innerHTML = `
                            <td>${registration.RegisterID}</td>
                            <td>${registration.UserID}</td>
                            <td>${registration.SubjectID}</td>
                            <td>${registration.PackageID}</td>
                            <td>${registration.total_cost}</td>
                            <td>${registration.status}</td>
                            <td>${registration.valid_from}</td>
                            <td>${registration.valid_to}</td>
                            <td>${registration.create_at}</td>
                            <td><button onclick="deleteRegistration(${registration.RegisterID})">Delete</button></td>
                        `;
                        tableBody.appendChild(row);
                    });
                });
        }

        // Gọi hàm fetchData khi tải trang
        window.onload = fetchData;

        // Hàm xóa đăng ký
        function deleteRegistration(registerID) {
            if (confirm('Are you sure you want to delete this registration?')) {
                fetch(`deleteRegistration?registerID=${registerID}`, {
                    method: 'DELETE'
                }).then(response => {
                    if (response.ok) {
                        alert('Registration deleted successfully');
                        fetchData();
                    } else {
                        alert('Failed to delete registration');
                    }
                });
            }
        }

        // Tìm kiếm
        document.getElementById('search').addEventListener('input', function () {
            const filter = this.value.toUpperCase();
            const rows = document.querySelectorAll('#registrationsTable tbody tr');
            rows.forEach(row => {
                const subjectID = row.cells[2].textContent;
                if (subjectID.toUpperCase().indexOf(filter) > -1) {
                    row.style.display = '';
                } else {
                    row.style.display = 'none';
                }
            });
        });
    </script>
</body>
</html>
