<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html lang="en">
<head>
    <title>Users</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
    <script type="text/javascript"  src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

    <script>
        $(document).ready(function(){
            $('#userTable').dataTable();
        });
    </script>

    <script>
        function httpPost(theUrl)
        {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open( "POST", theUrl, false ); // false for synchronous request
            xmlHttp.send( null );
        }

    </script>

</head>

<body>
<div class="container" style="margin-top: 20px">
    <%--table table-striped--%>
    <table id="userTable" class="table table-bordered">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>IsAdmin</th>
            <th>Date of creation</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.admin}</td>
                <td>${user.created}</td>
                <td align="center">
                    <spring:url value="/users/${user.id}/delete" var="deleteUrl" />
                    <button type="button" class="btn btn-primary" onclick="updateUser">Update</button>
                    <button class="btn btn-danger"
                            onclick="">Delete
                        <a href="<c:url value='/users/${user.id}/delete'/>"/>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>