<%-- 
    Document   : update-subject
    Created on : May 21, 2024, 2:36:09 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Subject</title>
    </head>
    <body>
        <form action="update-account" method="POST">
            <c:set value="${requestScope.account}" var="a"/>
            <div class="w-50 h-75 m-lg-3">
                <div class="form-group p-lg-3">
                    <input type="number" name="id" class="form-control" readonly value="${a.id}"/>
                </div>
                <div class="form-group p-lg-3">
                    <input type="text" name="username" class="form-control" readonly value="${a.username}" placeholder="Username"/>
                </div>
                <div class="form-group p-lg-3">
                    <input type="password" name="password" class="form-control" readonly value="${a.password}" placeholder="Password"/>
                </div>
                <div class="form-group p-lg-3">
                    <input type="text" name="displayName" class="form-control" readonly value="${a.displayName}" placeholder="Full Name" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="text" name="address" class="form-control" readonly value="${a.address}" placeholder="Address" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="email" name="email" class="form-control" readonly value="${a.email}" placeholder="Email" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="number" name="phone" class="form-control" readonly value="${a.phone}" placeholder="Phone" />
                </div>
                <div class="form-group p-lg-3">
                    <select name="role" class="form-control">
                        <option value="2" ${a.role == 2 ? 'selected' : ''}>User</option>
                        <option value="1" ${a.role == 1 ? 'selected' : ''}>Admin</option>
                    </select>
                </div>
                <div class="form-group tm-d-flex p-lg-3">
                    <input type="submit" class="btn btn-primary w-100" value="CHANGE">
                </div>
            </div>
        </form>
    </body>
</html>
