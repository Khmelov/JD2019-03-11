<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=EditCategory" method="post">
<fieldset>

<!-- Form Name -->
<legend>Изменить категорию</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="category">Имя категории</label>
  <div class="col-md-4">
  <input id="category" name="category" value="дерево" type="text" placeholder="Напишите имя категории" class="form-control input-md" required="">

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
<br>
<c:forEach items="${categories}" var="category">
<p>${category.category}</p>
</c:forEach>
<hr>
</div>
</body>
</html>


