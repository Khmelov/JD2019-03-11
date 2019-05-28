<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=Logout" method="post">
        <fieldset>
            <!-- Form Name -->
            <legend>Logout</legend>

            <!-- Button (Double) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logouta">Are you sure you want to logout?</label>
                <div class="col-md-8">
                    <button id="logouta" value="agree" name="logouta" class="btn btn-success">Agree</button>
                    <button id="logoutd" value="disagree" name="logoutd" class="btn btn-danger">Disagree</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
