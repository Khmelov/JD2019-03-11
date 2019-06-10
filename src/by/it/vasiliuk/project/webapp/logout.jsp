<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=Logout" method="post">
        <fieldset>
            <!-- Form Name -->
            <legend>Logout</legend>

            <!-- Button (Double) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logouta">Do u want to quit?</label>
                <div class="col-md-8">
                    <button id="logouta" name="logouta" class="btn btn-success">Yes</button>
                    <button id="logoutd" name="logoutd" class="btn btn-danger">No</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
