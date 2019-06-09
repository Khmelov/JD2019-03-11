<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
 <body>
    <div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=SignUp" method="post">
<fieldset>

<!-- Form Name -->
<legend>Sign Up</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Login</label>
  <div class="col-md-4">
  <input id="Login" name="Login" value="khlystunova" type="text" placeholder="khlystunova" class="form-control input-md" required="">
  <span class="help-block">your login</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Password">Password</label>
  <div class="col-md-4">
    <input id="Password" name="Password" value="lisa21031997" type="password" placeholder="qwerty" class="form-control input-md" required="">
    <span class="help-block">enter a password of at least 4 characters</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Email">Email</label>
  <div class="col-md-4">
  <input id="Email" name="Email" value="lisa.epee@gmail.com" type="text" placeholder="lisa.epee@gmail.com" class="form-control input-md" required="">
  <span class="help-block">enter your email</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <div class="col-md-4">
    <button id="Sign up" name="Sign up" class="btn btn-success">sign up</button>
  </div>
</div>


</fieldset>
</form>
    </div>
 </body>
</html>




