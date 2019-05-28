<%@ page contentType="text/html;
    charset=UTF-8"
    language="java"
    pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<br>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Удаление аккаунта</legend>
<br>
    <p>Вы действительно хотите удалить все свои данные?</p>

<!-- Button -->
<div class="form-group" action="do?command=Profile">
  <label class="col-md-4 control-label" for="no"></label>
  <div class="col-md-4">
    <button id="no" name="no" class="btn btn-success">Нет, я передумал</button>
  </div>
</div>

<!-- Button -->
<div class="form-group" action="do?command=DeleteUser">
  <label class="col-md-4 control-label" for="yes"></label>
  <div class="col-md-4">
    <button id="yes" name="yes" class="btn btn-danger">Да, удалить аккаунт</button>
  </div>
</div>

</fieldset>
</form>


</div>
</body>
</html>