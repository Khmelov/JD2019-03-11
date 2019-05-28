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
<form method="GET">
  <div class="row">
    <div class="col-md-4">
		<input id="searchinput" name="searchinput" type="search" placeholder="Что вы ищете?" class="form-control input-md">
    </div>
    <div class="col-md-4">
    <button id="search" name="search" class="btn btn-primary">Искать</button>
  </div>
  </div>
</form>

</div>
</body>
</html>