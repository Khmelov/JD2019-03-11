<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=Login" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>ваш Login</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="testUser" type="text" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block">Используйте только символы [a-z0-9]</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Пароль</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="12345678" type="password" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block">Минимум 8 символов</span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signup">SignUp</label>
                <div class="col-md-4">
                    <button id="signup" name="signup" class="btn btn-success">Login</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>