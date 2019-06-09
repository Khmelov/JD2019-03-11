<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body style="background-image:url(images/fon2.jpg)">
<div class="container" align="center">
    <%@ include file="include/menu.jsp" %>
    <br>
    <form class="form-horizontal" align="center" action="do?command=Login" method="post">
        <fieldset align="center">

            <!-- Form Name -->
            <legend align="center">Авторизация</legend>

            <!-- Text input-->
            <div class="form-group" align="center">
                <label class="col-md-4 control-label" for="login" align="left">Логин</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" value="testUser" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block"> (введите ваш логин) </span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group" align="center">
                <label class="col-md-4 control-label" for="password" align="left">Пароль</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" value="testpassword" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block"> (введите ваш пароль) </span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group" align="center">
                <label class="col-md-4 control-label" for="signup"></label>
                <div class="col-md-4">
                    <button id="signup" name="signup" class="btn btn-primary">Вход</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>

