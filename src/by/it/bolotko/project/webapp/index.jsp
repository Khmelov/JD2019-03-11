<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <h4> Все автомобили: </h4>
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
            <div class="col-md-2"><h6>${car.car_type}</h6></div>
            <div class="col-md-1"><h6>${car.fuel_type}</h6></div>
            <div class="col-md-2"><h6>${car.mark}</h6></div>
            <div class="col-md-2"><h6>${car.model}</h6></div>
            <div class="col-md-1"><h6>${car.price}</h6></div>
            <div class="col-md-1"><h6>${car.year_of_issue}</h6></div>
            <div class="col-md-1">
                <button id="details" name="details" class="btn btn-default"><h6>подробности</h6></button>
            </div>
        </div>
    </c:forEach>

    <hr>
    <my:paginator count="${carsSize}" step="10" urlprefix="?start="/>

</div>
</body>
</html>