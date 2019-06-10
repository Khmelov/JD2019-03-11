<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

<br>
<p>Вы действительно хотите выйти?</p>
<br>
    <form class="form-horizontal" action="do?command=Logout" method="post">
        <fieldset>
            <!-- Form Name -->
            <legend>Выход</legend>

            <!-- Button  -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logouta">Выйти из профиля?</label>
                <div class="col-md-8">
                    <button id="logoutY" name="logoutY" class="btn btn-success">Да</button>
                    <button id="logoutN" name="logoutN" class="btn btn-danger">Нет</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>

