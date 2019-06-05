<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body style="background-image:url(images/fon2.jpg)">
<div class="container" style="background-color:whitesmoke">
    <%@ include file="include/menu.jsp" %>
    <br>
    <h4 align="center"> Пользователи: </h4>
    <br>
    <div class="row">
        <div class=col-md-2><h6>Логин:</h6></div>
        <div class=col-md-3><h6>Email:</h6></div>
        <div class=col-md-2><h6>Телефон:</h6></div>
        <div class=col-md-2><h6>Роль:</h6></div>
    </div>

    <c:forEach items="${users}" var="user">
        <div class="row">
            <div class=col-md-2><h6>${user.login}</h6></div>
            <div class=col-md-3><h6>${user.email}</h6></div>
            <div class=col-md-2><h6>${user.phone}</h6></div>
            <div class=col-md-2><h6>${user.roles_id}</h6></div>
        </div>
    </c:forEach>

    <br>
    <h4 align="center"> Автомобили: </h4>
    <br>
    <div class="row">
<%--        <div class="col-md-2">Фото</div> --%>
        <div class="col-md-2"><h6>Тип автомобиля:</h6></div>
        <div class="col-md-1"><h6>Тип топлива:</h6></div>
        <div class="col-md-2"><h6>Марка автомобиля:</h6></div>
        <div class="col-md-2"><h6>Модель автомобиля:</h6></div>
        <div class="col-md-1"><h6>Цена (USD):</h6></div>
        <div class="col-md-1"><h6>Год выпуска:</h6></div>
    </div>

    <c:forEach items="${cars}" var="car">
        <div class="row">
<%--            <div class="col-md-2"><img src="images/img${car.id}" height="90"> </div>--%>
            <div class="col-md-2" align="center"><h6>${car.car_type}</h6></div>
            <div class="col-md-1" align="center"><h6>${car.fuel_type}</h6></div>
            <div class="col-md-2" align="center"><h6>${car.mark}</h6></div>
            <div class="col-md-2" align="center"><h6>${car.model}</h6></div>
            <div class="col-md-1" align="center"><h6>${car.price}</h6></div>
            <div class="col-md-1" align="center"><h6>${car.year_of_issue}</h6></div>
            <div class="col-md-1">
                <button id="details" name="details" class="btn btn-default" style="text-decoration:underline"><h6>подробности</h6></button>
            </div>
        </div>
    </c:forEach>
    <br><br>
</div>
</body>
</html>