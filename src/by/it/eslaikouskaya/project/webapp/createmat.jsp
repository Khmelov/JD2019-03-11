<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=CreateMat" method="post">
<fieldset>

<!-- Form Name -->
<legend>Создать материал</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Имя материала</label>
  <div class="col-md-4">
  <input id="name" name="name" value="Кирпич" type="text" placeholder="Введите название материала" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="grade">Номер класса</label>
  <div class="col-md-4">
  <input id="grades_ID" name="grades_ID" value="20" type="text" placeholder="Введите номер класса" class="form-control input-md" required="">
  <span class="help-block">Номер должен соответствовать категории</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Цена</label>
  <div class="col-md-4">
  <input id="price" name="price" value="20" type="text" placeholder="Введите стоимость материала" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="button"></label>
  <div class="col-md-4">
    <button id="button" name="button" class="btn btn-primary">Создать</button>
  </div>
</div>

</fieldset>
</form>
<p>${success}</p>
<br>
<c:forEach items="${materials}" var="material">
<div class="row">
        <div class="col-md-3">${material.name}</div>
        <div class="col-md-1">${material.price}</div>
</div>
</c:forEach>
</div>
</body>
</html>


