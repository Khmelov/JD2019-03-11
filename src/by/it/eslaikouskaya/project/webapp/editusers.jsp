<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h2>Редактирование пользователей</h2>
    <div class="row">
        <div class=col-md-3>Логин</div>
        <div class=col-md-2>Пароль</div>
        <div class=col-md-2>Email</div>
        <div class=col-md-2>Роль</div>
    </div>
    <c:forEach items="${users}" var="user">
        <form class="form-horizontal-${user.ID}" action="do?command=EditUsers" method="post">
            <div class="row">
                <input id="ID" name="ID" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${user.ID}">

                <div class="col-md-3">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
                           required="" value="${user.login}">

                </div>

                <div class="col-md-2">
                    <input id="password" name="password" type="text" placeholder="" class="form-control input-md"
                           required="" value="${user.password}">

                </div>

                <div class="col-md-2">
                    <input id="email" name="email" type="text" placeholder="" class="form-control input-md"
                           required="" value="${user.email}">
                </div>

                <div class="col-md-2">
                    <select id="roles_ID" name="roles_ID" class="form-control">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.ID}" ${user.roles_ID==role.ID?"selected":""}>${role.role}</option>
                        </c:forEach>
                    </select>
                </div>

                <!-- Button (Double) -->
                <div class="col-md-3">
                    <button id="update" name="update" class="btn btn-light">Обновить</button>
                    <button id="delete" name="delete" class="btn btn-dark">Удалить</button>
                </div>
            </div>
        </form>
    </c:forEach>


</div>
</body>
</html>