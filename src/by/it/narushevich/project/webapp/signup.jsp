
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>

<form class="form-horizontal" action="do?command=SignUp" method="post">
<fieldset>

<!-- Form Name -->
<legend>Sing Up</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" value="testUser" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">any simbols [a-zA-Z]</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">E-mail</label>
  <div class="col-md-4">
    <input id="email" name="email" value="user@tut.by" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">your e-mail</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
  <input id="password" name="password" value="testPassword" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">min length 8 symbols</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="sign-up"></label>
  <div class="col-md-4">
    <button id="sign-up" name="sign-up" class="btn btn-primary">Sign Up</button>
  </div>
</div>

</fieldset>
</form>


</div>
</body>
</html>




