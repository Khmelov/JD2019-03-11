<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h2>Редактирование пользователей</h2>
    <div class="row">
        <div class=col-md-2>Login</div>
        <div class=col-md-2>Password</div>
        <div class=col-md-2>Email</div>
        <div class=col-md-2>Phone</div>
        <div class=col-md-2>Role</div>
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

                <div class="col-md-1">
                    <input id="password" name="password" type="password" placeholder="" class="form-control input-md"
                           required="" value="${user.password}">

                </div>

                <div class="col-md-2">
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
                    <button id="update" name="update" class="btn btn-success">Refresh</button>
                    <button id="delete" name="delete" class="btn btn-danger">Delete</button>
                </div>
            </div>
        </form>
    </c:forEach>


</div>
</body>
</html>