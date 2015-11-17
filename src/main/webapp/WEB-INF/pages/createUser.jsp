<%--
  Created by IntelliJ IDEA.
  User: V
  Date: 12.11.2015
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<form id="form" name="create" class="form-horizontal" action="/create.form" method="post" onsubmit="return validateForm()">
    <fieldset>

        <!-- Form Name -->
        <legend>Create user</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Name">Name</label>

            <div class="col-md-4">
                <input id="Name" name="Name" type="text" maxlength="25" placeholder="placeholder"
                       class="form-control input-md"
                       value="">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Age">Age</label>

            <div class="col-md-4">
                <input id="Age" name="Age" type="number" min="0" placeholder="placeholder" class="form-control input-md"
                       value="">
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="select">Is admin</label>

            <div class="col-md-4">
                <select id="select" name="isAdmin" class="form-control">
                    <option value="true" selected="selected">True</option>
                    <option value="false">False</option>
                </select>
            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="button1id"></label>

            <div class="col-md-8">
                <button type="submit" id="button1id" name="button1id" class="btn btn-success">Create</button>
                <a href="/users" id="button2id" name="button2id" class="btn btn-danger">Cancel</a>
            </div>
        </div>
    </fieldset>

</form>

<script>
    function validateForm() {
        var name = document.forms["create"]["Name"].value;
        var age = document.forms["create"]["Age"].value;
        if (name == null || name == "") {
            alert("Name must be filled out");
            return false;
        }

        if (age == null || age == "") {
            alert("Age must be filled out");
            return false;
        }
    }
</script>


</body>
</html>
