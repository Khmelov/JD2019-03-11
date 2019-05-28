<%@ page contentType="text/html;
    charset=UTF-8"
    language="java"
    pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>

<form class="form-horizontal" action="do?command=Login" method="post">
<fieldset>

<!-- Form Name -->
<legend>Авторизация пользователя</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Логин</label>
  <div class="col-md-4">
  <input id="login" name="login" value="testUser" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">русские и английские буквы, цифры, . и _, длина 8 до 15</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" value="testPassword" type="password" placeholder="" class="form-control input-md" required="">
      <span class="help-block">минимальная длина 8 символов</span>
      </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="login"></label>
  <div class="col-md-4">
    <button id="login" name="login" class="btn btn-primary">Войти</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>

