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
                    <span class="help-block">any symbols [a-z0-9]</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" value="${user.email}" type="text" placeholder="login@postserver.com" class="form-control input-md" required="">
                    <span class="help-block">Your e-mail</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="${user.password}" type="password" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">min length 8 symols</span>
                </div>
            </div>


            <!-- Button (Double) -->
            <div class="form-group">
                <div class="col-md-8">
                    <button id="update" name="update" class="btn btn-success">Изменить</button>
                    <button id="logout" name="logout" class="btn btn-danger">Выйти</button>
                </div>
            </div>
        </fieldset>

    </form>

    <h4>Мои модификации</h4>

    <div class="row">
        <div class="col-md-2">Название игры</div>
        <div class="col-md-2">Категория модификации</div>
        <div class="col-md-2">Название</div>
        <div class="col-md-3">Описание</div>
        <div class="col-md-1">Размер (Мб)</div>
        <div class="col-md-1">Ссылка</div>
    </div>

    <c:forEach var="mod" items="${modsAll}">
        <div class="row">
            <div class="col-md-2">${mod.game}</div>
            <div class="col-md-2">${mod.group}</div>
            <div class="col-md-2">${mod.name}</div>
            <div class="col-md-3">${mod.description}</div>
            <div class="col-md-1">${mod.size}</div>
            <div class="col-md-1">${mod.link}</div>
        </div>
    </c:forEach>
</div>
</body>
</html>
