<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <title>Users</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

    <script>
        $(document).ready(function () {
            $('#userTable').dataTable();
        });
    </script>

</head>

<body>

<div class="container" style="margin-top: 20px">
    <p>${exception}</p>
    <%--table table-striped--%>
    <div align="right">
        <p><a href="/users/create" class="btn btn-primary" role="button">Create User</a></p>

    </div>
    <table id="userTable" class="table table-bordered">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>IsAdmin</th>
            <th>Date of creation <br>
            hh:mm:ss dd-MM-yyyy</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.isAdmin}</td>
                <td><fmt:formatDate pattern="HH:mm:ss dd-MM-yyyy" type="both" value="${user.created}"/></td>
                <td align="center">
                    <a href="/users/edit/${user.id}" class="btn btn-primary" role="button">Update</a>
                    <a href="/users/remove/${user.id}" class="btn btn btn-danger" role="button">Delete</a>
                </td>
            </tr>


        </c:forEach>
    </table>
</div>


</body>
</html>