<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=EditGrade" method="post">
<fieldset>

<!-- Form Name -->
<legend>Изменить класс</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="grade">Имя класса</label>
  <div class="col-md-4">
  <input id="grade" name="grade" value="вентили" type="text" placeholder="Напишите имя класса" class="form-control input-md" required="">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
<label class="col-md-4 control-label" for="name">Имя категории</label>
<div class="col-md-4">
<select id="categories_ID" name="categories_ID" class="form-control">
<c:forEach items="${categories}" var="category">
<option value="${category.ID}">${category.category}</option>
</c:forEach>
</select>
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
<div class="col-md-4">Класс</div>
<div class="col-md-2">Категория</div>
<div class="col-md-4">Класс</div>
<div class="col-md-2">Категория</div>
</div>
<hr>
<div class="row">
<c:forEach items="${grades}" var="grade">
         <div class="col-md-4">${grade.grade}</div>
         <c:forEach items="${categories}" var="category">
            <c:if test="${grade.categories_ID==category.ID}">
                <div class="col-md-2">${category.category}</div>
            </c:if>
         </c:forEach>
</c:forEach>
</div>
<hr>


</div>
</body>
</html>


