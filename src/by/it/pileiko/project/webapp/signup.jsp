<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <form class="form-horizontal" action="do?command=SignUp" method="post">
        <fieldset>
            <!-- Form Name -->
            <legend>Регистрация(Sign Up)</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="testUser" type="text" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">Используйте только цифры и буквы латинского алфавита</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" value="test@mail.by" type="text" placeholder="login@postserver.com" class="form-control input-md" required="">
                    <span class="help-block">Ваш e-mail</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Пароль</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="12345678" type="password" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">минимум 8 символов </span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signup"></label>
                <div class="col-md-4">
                    <button id="signup" name="signup" class="btn btn-success">Вход</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>


