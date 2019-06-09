<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Мои данные</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="${user.login}" type="text" placeholder="" class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" value="${user.email}" type="text" placeholder="login@postserver.com" class="form-control input-md" required="">
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="${user.password}" type="text" placeholder="" class="form-control input-md" required="">
                </div>
            </div>


            <div class="form-group">
                <div class="col-md-8">
                    <button id="update" name="update" class="btn btn-success">Изменить</button>
                </div>
            </div>

        </fieldset>
    </form>

    <h3>${success}</h3>

<br><hr>
     <p>+375 (177) 742777  +375 (177) 931777  +375 (29) 6872793  +375 (33) 6740370</p>
</div>
</body>
</html>


