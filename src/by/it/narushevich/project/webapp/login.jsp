<%@ page contentType="text/html;
    charset=UTF-8"
    language="java"
    pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="j_security_check" method="post">
<fieldset>

<!-- Form Name -->
<legend>Авторизация пользователя</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Логин</label>
  <div class="col-md-4">
  <input id="login" name="j_username" value="testUser" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">any symbols [a-zA-Z0-9._], length from 8 to 15</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="j_password" value="testPassword" type="password" placeholder="" class="form-control input-md" required="">
      <span class="help-block">min length 8 symbols</span>
      </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="login"></label>
  <div class="col-md-4">
    <button id="login" name="login" class="btn btn-primary">Зарегистрировать</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>

