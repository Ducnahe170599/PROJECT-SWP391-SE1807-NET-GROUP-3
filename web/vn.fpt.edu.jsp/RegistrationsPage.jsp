<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registrations</title>
    <style>
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
            <!-- Data will be added here by JavaScript -->
        </tbody>
    </table>

    <script>
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

        window.onload = fetchData;

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
