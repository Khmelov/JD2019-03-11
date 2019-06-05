<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <div class="row">
        <div class="col-md-1">Фото</div>
        <div class="col-md-1">Цена</div>
        <div class="col-md-2">Марка</div>
        <div class="col-md-2">Модель</div>
        <div class="col-md-2">Описание</div>
        <div class="col-md-1">Год</div>
        <div class="col-md-1">Объем</div>
    </div>

    <c:forEach items="${cars}" var="car">
        <div class="row">
        <br>
            <div class="col-md-1"><img src="images/img${car.id}" height="50"> </div>
            <div class="col-md-1">${car.price}</div>
            <div class="col-md-2">${car.brand}</div>
            <div class="col-md-2">${car.model}</div>
            <div class="col-md-2">${car.description}</div>
            <div class="col-md-1">${car.year}</div>
            <div class="col-md-1">${car.engine}</div>
        </div>
    </c:forEach>

    <hr>
    <my:paginator count="${carsSize}" step="5" urlprefix="?start="/>

</div>
</body>
</html>