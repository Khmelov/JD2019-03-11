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


            <!-- Button (Double) -->
            <div class="form-group">
                <div class="col-md-8">
                    <button id="update" name="update" class="btn btn-success">Изменить</button>
                    <button id="logout" name="logout" class="btn btn-danger">Выйти</button>
                </div>
            </div>

        </fieldset>
    </form>

    <h4>Мои покупки</h4>

    <div class="row">
        <div class="col-md-4">Материал</div>
        <div class="col-md-2">Количество</div>
        <div class="col-md-2">Изменить</div>
    </div>

    <c:forEach items="${purchases}" var="purchase">
        <div class="row">
        <c:forEach items="${materials}" var="material">
            <c:if test="${material.ID==purchase.materials_ID}">
                <div class="col-md-4" >${material.name}</div>
            </c:if>
        </c:forEach>
            <div class="col-md-2">${purchase.number}</div>
            <div class="col-md-2">
            <button type="delete" name="delete" class="btn btn-light">удалить</button>
            </div>
        </div>
    </c:forEach>
    <!-- Button -->
    <div class="form-group">
    <div class="col-md-4">
        <button id="send" name="send" class="btn btn-success">Заказать</button>
    </div>
    </div>
    <h3>${sent}</h3>
<br><hr>
</div>
</body>
</html>


