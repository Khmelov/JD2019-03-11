<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Login</label>
  <div class="col-md-4">
  <input id="Login" name="Login" value="testUser" type="text" placeholder="placeholder" class="form-control input-md">
  <span class="help-block">your login</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Email">Email</label>
  <div class="col-md-4">
  <input id="Email" name="Email" value="test@mail.com" type="text" placeholder="placeholder" class="form-control input-md">
  <span class="help-block">help</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Password">Password </label>
  <div class="col-md-4">
    <input id="Password" name="Password" value="qwerty" type="password" placeholder="" class="form-control input-md">
    <span class="help-block">help</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signup"></label>
  <div class="col-md-4">
    <button id="signup" name="signup" class="btn btn-success">Sing up</button>
  </div>
</div>

</fieldset>
</form>
</div>

</body>
</html>




