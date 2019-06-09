<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=EditMat" method="post">
<fieldset>

<!-- Form Name -->
<legend>Изменить материал</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Имя материала</label>
  <div class="col-md-4">
  <input id="name" name="name" value="Кирпич" type="text" placeholder="Введите название материала" class="form-control input-md" required="">

  </div>
</div>

<div class="form-group">
<label class="col-md-4 control-label" for="name">Имя класса</label>
<div class="col-md-4">
<select id="grades_ID" name="grades_ID" class="form-control">
<c:forEach items="${grades}" var="grade">
<option value="${grade.ID}">${grade.grade}</option>
</c:forEach>
</select>
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
    <button id="create" name="create" class="btn btn-light">Создать</button>
    <button id="delete" name="delete" class="btn btn-dark">Удалить</button>
  </div>
</div>

</fieldset>
</form>
<h3>${success}</h3>
<hr>
<div class="row">
<div class="col-md-3">Наименование</div>
<div class="col-md-3">Класс</div>
<div class="col-md-3">Наименование</div>
<div class="col-md-3">Класс</div>
</div>
<hr>
<div class="row">
<c:forEach items="${materials}" var="material">
         <div class="col-md-3">${material.name}</div>
         <c:forEach items="${grades}" var="grade">
            <c:if test="${material.grades_ID==grade.ID}">
                <div class="col-md-3">${grade.grade}</div>
            </c:if>
         </c:forEach>
</c:forEach>
</div>
<hr>
</div>
</body>
</html>


