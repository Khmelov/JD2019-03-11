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
            <div class="col-md-3">Наименование</div>
            <div class="col-md-4">Класс</div>
            <div class="col-md-1">Цена</div>
            <div class="col-md-1">Кол-во</div>
            <div class="col-md-3">Изменить</div>
        </div>

    <c:forEach items="${purchases}" var="purchase">
    <form class="form-horizontal-${purchase.ID}" action="do?command=Profile" method="post">
        <div class="row">
        <input id="purchase.ID" name="purchase.ID" type="hidden" placeholder="" class="form-control input-md" required="" value="${purchase.ID}">
        <c:forEach items="${materials}" var="material">
            <c:if test="${material.ID==purchase.materials_ID}">
                <input id="material.ID" name="material.ID" type="hidden" placeholder="" class="form-control input-md" required="" value="${material.ID}">
                <div class="col-md-3" >${material.name}</div>
                <c:forEach items="${grades}" var="grade">
                     <c:if test="${material.grades_ID==grade.ID}">
                          <div class="col-md-4">${grade.grade}</div>
                     </c:if>
                </c:forEach>
            <div class="col-md-1">${material.price}</div>
            <div class="col-md-1">
                <input id="number" name="number" type="text" placeholder="" value="${purchase.number}" class="form-control input-md">
            </div>
            </c:if>
            </c:forEach>
            <div class="col-md-3">
                <button id="change" name="change" class="btn btn-success">Обновить</button>
                <button id="delete" name="delete" class="btn btn-danger">Удалить</button>
            </div>
        </div>
    </form>
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


