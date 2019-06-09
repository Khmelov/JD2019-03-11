<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<br>

<h4>Мои данные</h4>

    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend></legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="login">Логин</label>
              <div class="col-md-5">
              <input id="login" name="login" value="${user.login}" type="text" placeholder="" class="form-control input-md" required="">
              <span class="help-block">английские буквы, цифры, . и _, длина от 5 до 15</span>
              </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="password">Пароль</label>
              <div class="col-md-5">
                <input id="password" name="password" value="${user.password}" type="password" placeholder="" class="form-control input-md" required="">
                  <span class="help-block">длина 5 до 15 символов</span>
                  </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="email">Электронная почта</label>
              <div class="col-md-5">
                <input id="email" name="email" value="${user.email}" type="text" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">Ваш e-mail</span>
                  </div>
            </div>


            <!-- Button -->
            <div class="form-group">
                <div class="col-md-10">
                    <button id="updateAc" name="updateAc" class="btn btn-success">Изменить данные</button>
                    <button id="deleteAc" name="deleteAc" class="btn btn-danger">Удалить аккаунт</button>
                    <button id="createTag" name="createTag" class="btn btn-primary">Добавить в коллекцию</button>
                </div>
            </div>

        </fieldset>
    </form>

<h3>Коллекция</h3>

<div class="row">
        <div class="col-md-2 text-center">Картинка</div>
        <div class="col-md-2 text-center">Торговая марка</div>
        <div class="col-md-2 text-center">Текст</div>
        <div class="col-md-1 text-center">Материал</div>
        <div class="col-md-2 text-center">Размер, мм х мм</div>
        <div class="col-md-2 text-center">Дата получения</div>
        <div class="col-md-1 text-center">Номер в каталоге</div>
    </div>
<hr>
    <c:forEach items="${usersTeatags}" var="teatag">
        <div class="row">
            <div class="col-md-2"><img src="pictures/${teatag.numInCatalog}.jpg" height="70 px"></div>
            <div class="col-md-2">${teatag.trademark}</div>
            <div class="col-md-2">${teatag.subtitle}</div>
            <div class="col-md-1">${teatag.material}</div>
            <div class="col-md-2 text-center">${teatag.width} х ${teatag.height}</div>
            <div class="col-md-2 text-center">${teatag.inCollectionSince}</div>
            <div class="col-md-1">${teatag.numInCatalog}</div>
        </div>
        <hr>
    </c:forEach>
    <br>
    <br>

</div>
</body>
</html>