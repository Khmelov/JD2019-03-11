<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h2>Редактирование объявлений</h2>
    <div class="row">
        <div class="col-md-2">Тип автомобиля</div>
        <div class="col-md-1">Тип топлива</div>
        <div class="col-md-1">Марка автомобиля</div>
        <div class="col-md-1">Модель автомобиля</div>
        <div class="col-md-2">Цена</div>
        <div class="col-md-1">Год выпуска</div>
        <div class="col-md-1">Пользователь</div>
    </div>
    <c:forEach items="${cars}" var="car">
        <form class="form-horizontal-${car.id}" action="do?command=EditCars" method="post">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${car.id}">

                <div class="col-md-2">
                    <input id="car_type" name="car_type" type="text" placeholder="" class="form-control input-md"
                           required="" value="${car.car_type}">
                </div>

                <div class="col-md-1">
                    <input id="fuel_type" name="fuel_type" type="text" placeholder="" class="form-control input-md"
                           required="" value="${car.fuel_type}">
                </div>

                <div class="col-md-1">
                    <input id="mark" name="mark" type="text" placeholder="" class="form-control input-md"
                           required="" value="${car.mark}">
                </div>

                <div class="col-md-1">
                    <input id="model" name="model" type="text" placeholder="" class="form-control input-md"
                           required="" value="${car.model}">
                </div>

                <div class="col-md-2">
                    <input id="price" name="price" type="text" placeholder="" class="form-control input-md"
                           required="" value="${car.price}">
                </div>

                <div class="col-md-1">
                    <input id="year_of_issue" name="year_of_issue" type="text" placeholder=""
                           class="form-control input-md"
                           required="" value="${car.year_of_issue}">
                </div>

                <div class="col-md-1">
                    <input id="users_id" name="users_id" type="text" placeholder="" class="form-control input-md"
                           required="" value="${car.users_id}">
                </div>

<%--                <input id="users_id" name="users_id" type="hidden" placeholder="" class="form-control input-md"--%>
<%--                       required="" value="${car.users_id}">--%>

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
    <my:paginator count="${carsSize}" step="10" urlprefix="do?command=editcars&start="/>
    <hr>
</div>
</body>
</html>