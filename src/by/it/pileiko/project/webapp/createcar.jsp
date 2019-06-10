<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <form class="form-horizontal" action="do?command=CreateCar" method="post" enctype="multipart/form-data">
        <fieldset>

            <!-- Form Name -->
            <legend>Создание нового объявления</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="brand">Марка автомобиля</label>
                <div class="col-md-4">
                    <input id="brand" name="brand" type="text" value="testBrand" placeholder="" class="form-control input-md" required="">
                </div>
            </div>

          <!-- Text input-->
             <div class="form-group">
                 <label class="col-md-4 control-label" for="model">Модель автомобиля</label>
                 <div class="col-md-4">
                 <input id="model" name="model" type="text" value="testModel" placeholder="" class="form-control input-md" required="">
              </div>
              </div>

          <!-- Text input-->
             <div class="form-group">
                 <label class="col-md-4 control-label" for="engine">Объем двигателя</label>
                 <div class="col-md-4">
                 <input id="engine" name="engine" type="text" value="2000" placeholder="" class="form-control input-md" required="">
              </div>
              </div>

          <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Цена</label>
                <div class="col-md-4">
                    <input id="price" name="price" value="5500" type="text" placeholder="" class="form-control input-md" required="">

                </div>
            </div>

            <!-- Select Multiple -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="year">Год выпуска</label>
                <div class="col-md-4">
                    <select id="year" name="year" class="form-control" multiple="multiple">
                        <option value="1990">1990</option>
                        <option value="1995">1995</option>
                        <option value="2000">2000</option>
                        <option value="2005" selected>2005</option>
                        <option value="2010" selected>Новый век</option>
                        <option value="2015">Б/у немного</option>
                        <option value="2019">Новая</option>
                    </select>
                </div>
            </div>

            <!-- Textarea -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Описание</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="description" name="description">test description</textarea>
                </div>
            </div>

            <!-- File Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="photo">Фото</label>
                <div class="col-md-4">
                    <input id="photo" name="photo" class="input-file" type="file">
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
