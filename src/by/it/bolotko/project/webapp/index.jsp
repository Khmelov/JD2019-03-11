<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <h2>База данных автомобилей</h2>
    <div class="row">
        <div class="col-md-2">Тип автомобиля</div>
        <div class="col-md-1">Тип топлива</div>
        <div class="col-md-2">Марка автомобиля</div>
        <div class="col-md-2">Модель автомобиля</div>
        <div class="col-md-1">Цена</div>
        <div class="col-md-1">Год выпуска</div>
    </div>

    <c:forEach items="${cars}" var="car">
        <div class="row">
            <div class="col-md-2">${car.car_type}</div>
            <div class="col-md-1">${car.fuel_type}</div>
            <div class="col-md-2">${car.mark}</div>
            <div class="col-md-2">${car.model}</div>
            <div class="col-md-1">${car.price}</div>
            <div class="col-md-1">${car.year_of_issue}</div>
        </div>
    </c:forEach>

</div>
</body>
</html>