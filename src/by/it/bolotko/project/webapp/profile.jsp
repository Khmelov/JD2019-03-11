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
                    <input id="login" name="login" type="text" value="${user.login}" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">[a-z],[A-Z],[0-9], минимум 4 символа (например: Aleksei)</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" value="${user.email}" placeholder="login@mail.com" class="form-control input-md" required="">
                    <span class="help-block"> введите ваш e-mail </span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Пароль</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" value="${user.password}" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> минимум 4 символа </span>
                </div>
            </div>

            <!-- Phone input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="phone">Телефон</label>
                <div class="col-md-4">
                    <input id="phone" name="phone" type="text" value="${user.phone}" placeholder="" class="form-control input-md" required="">
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

    <br><br><br><hr>
</div>
</body>
</html>
