<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" action="do?command=CreateAd" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Создание объявления</legend>

            <!-- Textarea -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Описание</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="description" name="description">test description</textarea>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="address">Адрес</label>
                <div class="col-md-4">
                    <input id="address" name="address" type="text" value="test address" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Select Multiple -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="rooms">Число комнат</label>
                <div class="col-md-4">
                    <select id="rooms" name="rooms" class="form-control" multiple="multiple">
                        <option value="1">Однокомнатная</option>
                        <option value="2" selected>Двухкомнатная</option>
                        <option value="3">Трехкомнатная</option>
                    </select>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="floor">Этаж</label>
                <div class="col-md-4">
                    <input id="floor" name="floor" type="text" value="3" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="floors">Этажность</label>
                <div class="col-md-4">
                    <input id="floors" name="floors" type="text" value="5" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Цена</label>
                <div class="col-md-4">
                    <input id="price" name="price" value="66666" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="area">Площадь</label>
                <div class="col-md-4">
                    <input id="area" name="area" type="text" value="55" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-primary">Создать объявление</button>
                </div>
            </div>

        </fieldset>
    </form>


</div>
</body>
</html>
