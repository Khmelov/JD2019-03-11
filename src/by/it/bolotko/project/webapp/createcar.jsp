<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=CreateCar" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Создание объявления</legend>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="car_type">Тип автомобиля</label>
                <div class="col-md-4">
                    <select id="car_type" name="car_type" class="form-control">
                        <option value="passenger">легковой автомобиль</option>
                        <option value="truck">грузовой автомобиль</option>
                    </select>
                    <span class="help-block"> выберие тип автомобиля </span>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="fuel_type">Тип топлива</label>
                <div class="col-md-4">
                    <select id="fuel_type" name="fuel_type" class="form-control">
                        <option value="petrol">бензин</option>
                        <option value="diesel">дизель</option>
                        <option value="electricity">электричество</option>
                    </select>
                    <span class="help-block"> выберите тип топлива </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="mark">Марка</label>
                <div class="col-md-4">
                    <input id="mark" name="mark" type="text" value="Audi" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> введите марку автомобиля (например: Audi) </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="model">Модель</label>
                <div class="col-md-4">
                    <input id="model" name="model" type="text" value="Q3" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> введите модель автомобиля </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Цена</label>
                <div class="col-md-4">
                    <input id="price" name="price" type="text" value="34500" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> введите стоимость автомобиля </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="year_of_issue">Год выпуска</label>
                <div class="col-md-4">
                    <input id="year_of_issue" name="year_of_issue" type="text" value="2012" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> введите год выпуска автомобиля (например: 1997)</span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signup"></label>
                <div class="col-md-4">
                    <button id="signup" name="signup" class="btn btn-success">Sign Up</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
