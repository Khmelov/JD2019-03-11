<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body style="background-image:url(images/fon2.jpg)">
<div class="container" style="background-color:whitesmoke">
    <%@ include file="include/menu.jsp" %>
    <br>
    <h3 align="center" style="color:#284755">управление пользователями</h3>
    <br>
    <div class="row">
        <div class=col-md-2 align="center" style="color:#284755; font-size:16px"><b>Логин</b></div>
        <div class=col-md-3 align="center" style="color:#284755; font-size:16px"><b>Email</b></div>
        <div class=col-md-2 align="center" style="color:#284755; font-size:16px"><b>Телефон</b></div>
        <div class=col-md-2 align="center" style="color:#284755; font-size:16px"><b>Роль</b></div>
    </div>
    <c:forEach items="${users}" var="user">
        <form class="form-horizontal-${user.id}" action="do?command=EditUsers" method="post">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${user.id}">

                <div class="col-md-2">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
                           required="" value="${user.login}">
                </div>

                <input id="password" name="password" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${user.password}">

                <div class="col-md-3">
                    <input id="email" name="email" type="text" placeholder="" class="form-control input-md"
                           required="" value="${user.email}">
                </div>

                <div class="col-md-2">
                    <input id="phone" name="phone" type="text" placeholder="" class="form-control input-md"
                           required="" value="${user.phone}">
                </div>

                <div class="col-md-2">
                    <select id="roles_id" name="roles_id" class="form-control">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.id}" ${user.roles_id==role.id?"selected":""}>${role.role}</option>
                        </c:forEach>
                    </select>
                </div>

                <!-- Button (Double) -->
                <div class="col-md-3">
                    <button id="update" name="update" class="btn btn-success">Обновить</button>
                    <button id="delete" name="delete" class="btn btn-danger">Удалить</button>
                </div>
            </div>
        </form>
    </c:forEach>

    <br><br><br>
    <hr>
    <my:paginator count="${usersSize}" step="10" urlprefix="do?command=editusers&start="/>
    <hr>
    <br>
</div>
</body>
</html>