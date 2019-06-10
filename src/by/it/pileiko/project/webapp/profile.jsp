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
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" value="${user.login}" type="text" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">Только символы [a-z0-9]</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" value="${user.email}" type="text" placeholder="login@postserver.com" class="form-control input-md" required="">
                    <span class="help-block">Ваш e-mail</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" value="${user.password}" type="password" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">минимум 8 символов</span>
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

<br> <hr>
    <h4>Мои объявления</h4>
<hr>
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
          <hr>
     </c:forEach>

    <hr>
    <my:paginator count="${carsSize}" step="5" urlprefix="do?command=profile&start="/>
    <hr>
</div>
</body>
</html>
