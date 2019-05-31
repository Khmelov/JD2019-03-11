<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=Login" method="post">
<fieldset>

<!-- Form Name -->
<legend>Login</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Логин</label>
  <div class="col-md-4">
  <input id="Login" name="Login" value="khlystunova" type="text" placeholder="khlystunova" class="form-control input-md" required="">
  <span class="help-block">your login</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Password">Пароль</label>
  <div class="col-md-4">
    <input id="Password" name="Password" value="lisa21031997" type="password" placeholder="qwerty" class="form-control input-md" required="">
    <span class="help-block">enter a password of at least 8 characters</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <div class="col-md-4">
    <button id="Log in" name="Log in" class="btn btn-success">log in</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>

