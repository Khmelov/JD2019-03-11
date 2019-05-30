<%@ page contentType="text/html;
    charset=UTF-8"
    language="java"
    pageEncoding="UTF-8" %>
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
                    <button id="update" name="update" class="btn btn-success">Изменить данные</button>
                    <button id="delete" name="delete" class="btn btn-danger">Удалить аккаунт</button>
                    <button id="create" name="create" class="btn btn-primary">Добавить в коллекцию</button>
                </div>
            </div>

        </fieldset>
    </form>

<h3>Коллекция</h3>

<div class="row">
        <div class="col-md-2 text-center">Торговая марка</div>
        <div class="col-md-2 text-center">Подзаголовок</div>
        <div class="col-md-1 text-center">Материал</div>
        <div class="col-md-1 text-center">Ширина, мм</div>
        <div class="col-md-1 text-center">Высота, мм</div>
        <div class="col-md-2 text-center">В коллекции с</div>
        <div class="col-md-2 text-center">Номер в каталоге</div>
        <div class="col-md-1 text-center">Имя пользователя</div>
    </div>
<br>
    <c:forEach items="${usersTeatags}" var="teatag">
        <div class="row">
            <div class="col-md-2">${teatag.trademark}</div>
            <div class="col-md-2">${teatag.subtitle}</div>
            <div class="col-md-1">${teatag.material}</div>
            <div class="col-md-1 text-center">${teatag.width}</div>
            <div class="col-md-1 text-center">${teatag.height}</div>
            <div class="col-md-2 text-center">${teatag.inCollectionSince}</div>
            <div class="col-md-2">${teatag.numInCatalog}</div>
            <div class="col-md-1 text-center">${teatag.userName}</div>
        </div>
    </c:forEach>
    <br><br>

</div>
</body>
</html>