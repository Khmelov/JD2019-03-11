<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <h2> Все автомобили: </h2>
    <div class="row">
        <div class="col-md-2">Фото</div>
        <div class="col-md-2">Тип автомобиля</div>
        <div class="col-md-1">Тип топлива</div>
        <div class="col-md-2">Марка автомобиля</div>
        <div class="col-md-2">Модель автомобиля</div>
        <div class="col-md-1">Цена (USD)</div>
        <div class="col-md-1">Год выпуска</div>
    </div>

    <c:forEach items="${cars}" var="car">
        <div class="row">
            <div class="col-md-2"><img src="images/img${car.id}" height="90"> </div>
            <div class="col-md-2">${car.car_type}</div>
            <div class="col-md-1">${car.fuel_type}</div>
            <div class="col-md-2">${car.mark}</div>
            <div class="col-md-2">${car.model}</div>
            <div class="col-md-1">${car.price}</div>
            <div class="col-md-1">${car.year_of_issue}</div>
            <div class="col-md-1">
                <button id="details" name="details" class="btn btn-default">подробности</button>
            </div>
        </div>
    </c:forEach>

    <hr>
    <my:paginator count="${carsSize}" step="10" urlprefix="?start="/>

</div>
</body>
</html>