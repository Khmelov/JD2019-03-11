<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=CreateGrade" method="post">
<fieldset>

<!-- Form Name -->
<legend>Создать класс</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="grade">Имя класса</label>
  <div class="col-md-4">
  <input id="grade" name="grade" value="вентили" type="text" placeholder="Напишите имя класса" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="categories_ID">Номер категории</label>
  <div class="col-md-4">
  <input id="categories_ID" name="categories_ID" value="2" type="text" placeholder="Напишите соответствующий номер категории" class="form-control input-md" required="">

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
<c:forEach items="${grades}" var="grade">
<p>${grade.grade}</p>
</c:forEach>
</div>
</body>
</html>


