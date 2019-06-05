<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body style="background-image:url(images/fon2.jpg)">
<div class="container" style="background-color:whitesmoke">
    <%@ include file="include/menu.jsp" %>
    <br>
    <h3 align="center" style="color:#284755">редактирование объявлений</h3>
    <br>
    <div class="row">
        <div class="col-md-2" align="center" style="color:#284755; font-size:16px"><b>Тип автомобиля</b></div>
        <div class="col-md-1" align="center" style="color:#284755; font-size:16px"><b>Тип топлива</b></div>
        <div class="col-md-1" align="center" style="color:#284755; font-size:16px"><b>Марка</b></div>
        <div class="col-md-1" align="center" style="color:#284755; font-size:16px"><b>Модель</b></div>
        <div class="col-md-2" align="center" style="color:#284755; font-size:16px"><b>Цена</b></div>
        <div class="col-md-1" align="center" style="color:#284755; font-size:16px"><b>Год выпуска</b></div>
        <div class="col-md-1" align="center" style="color:#284755; font-size:16px"><b>Пользователь</b></div>
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
    <br>
</div>
</body>
</html>