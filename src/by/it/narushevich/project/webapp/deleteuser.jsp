<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<br>

<p>Are you really want to delete your account?</p>

<form class="form-horizontal" action="do?command=DeleteUser" method="post">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="button1id"></label>
  <div class="col-md-8">
    <button id="button1id" name="button1id" class="btn btn-success">No, I don&#39t want</button>
    <button id="button2id" name="button2id" class="btn btn-danger">Yes, I want</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>