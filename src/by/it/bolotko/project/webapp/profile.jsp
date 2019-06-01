<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Мои данные</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Логин</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" value="${user.login}" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block">[a-z],[A-Z],[0-9], минимум 4 символа (например: Aleksei)</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" value="${user.email}" placeholder="login@mail.com"
                           class="form-control input-md" required="">
                    <span class="help-block"> введите ваш e-mail </span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Пароль</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" value="${user.password}" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block"> минимум 4 символа </span>
                </div>
            </div>

            <!-- Phone input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="phone">Телефон</label>
                <div class="col-md-4">
                    <input id="phone" name="phone" type="text" value="${user.phone}" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block"> введите ваш телефон </span>
                </div>
            </div>


            <!-- Button (Double) -->
            <div class="form-group">
                <div class="col-md-8">
                    <button id="update" name="update" class="btn btn-success">Изменить</button>
                    <button id="logout" name="logout" class="btn btn-danger">Выйти</button>
                </div>
            </div>

        </fieldset>
    </form>


    <h4>Мои объявления</h4>

    <div class="row">
        <div class="col-md-2">Тип автомобиля</div>
        <div class="col-md-2">Тип топлива</div>
        <div class="col-md-1">Марка автомобиля</div>
        <div class="col-md-1">Модель автомобиля</div>
        <div class="col-md-2">Цена</div>
        <div class="col-md-1">Год выпуска</div>
    </div>

    <c:forEach items="${cars}" var="car">
        <form class="form-horizontal-${car.id}" action="do?command=Profile" method="post">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${car.id}">

                <div class="col-md-2">
                    <input id="car_type" name="car_type" type="text" placeholder="" class="form-control input-md"
                           required="" value="${car.car_type}">
                </div>

                <div class="col-md-2">
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

                <input id="users_id" name="users_id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${car.users_id}">

                <!-- Button -->
                <div class="col-md-3">
                    <button id="edit" name="edit" class="btn btn-warning">Изменить</button>
                    <button id="deletecar" name="deletecar" class="btn btn-danger">Удалить</button>
                </div>
            </div>
        </form>
    </c:forEach>

    <br><br><br>
    <hr>
    <my:paginator count="${carsSize}" step="5" urlprefix="do?command=profile&start="/>
    <hr>
</div>
</body>
</html>
