<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body style="background-image:url(images/fon2.jpg)">
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <br>
    <form class="form-horizontal" align="center" action="do?command=Logout" method="post">
        <fieldset>
            <!-- Form Name -->
            <legend>Выход</legend>

            <!-- Button (Double) -->
            <div class="form-group" align="center">
                <label class="col-md-4 control-label" for="logouta">Вы уверены что хотите выйти?</label>
                <div class="col-md-8">
                    <button id="logouta" name="logouta" class="btn btn-success">Да</button>
                    <button id="logoutd" name="logoutd" class="btn btn-danger">Нет</button>
                </div>
            </div>

        </fieldset>
    </form>
    <p align="center"><img src="images/logout.jpg"></p>
</div>
</body>
</html>
