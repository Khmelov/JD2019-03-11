<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body style="background-image:url(images/fon2.jpg)">
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <br>

    <p align="center" style="color:#284755; font-size:30px"><b><i>Все объявления:</i></b></p>

    <div class="row">
        <%--        <div class="col-md-2">Фото</div> --%>
        <div class="col-md-2" align="center" style="color:#284755; font-size:16px"><b><i>Тип автомобиля:</i></b></div>
        <div class="col-md-1" align="center" style="color:#284755; font-size:16px"><b><i>Тип топлива:</i></b></div>
        <div class="col-md-2" align="center" style="color:#284755; font-size:16px"><b><i>Марка автомобиля:</i></b></div>
        <div class="col-md-2" align="center" style="color:#284755; font-size:16px"><b><i>Модель автомобиля:</i></b></div>
        <div class="col-md-1" align="center" style="color:#284755; font-size:16px"><b><i>Цена (USD):</i></b></div>
        <div class="col-md-1" align="center" style="color:#284755; font-size:16px"><b><i>Год выпуска:</i></b></div>
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
            <div class="col-md-1" >
                <button id="details"  name="details" class="btn btn-default" style="color:#284755; font-size:17px; text-decoration:underline"><b><i>подробности</i></b></button>
            </div>
        </div>
    </c:forEach>

    <hr>
    <my:paginator count="${carsSize}" step="10" urlprefix="?start="/>

    <hr>
    <p align="center"><img src="images/auto.jpg"></p>

</div>
</body>
</html>