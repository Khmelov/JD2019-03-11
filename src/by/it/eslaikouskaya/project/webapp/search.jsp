<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<form class="form-horizontal" action="do?command=Search" method="post">
   <fieldset>

   <!-- Form Name -->
   <legend>Поиск</legend>

   <!-- Text input-->
   <div class="form-group">
     <label class="col-md-4 control-label" for="name">Наименование материала</label>
     <div class="col-md-4">
     <input id="name" name="name" value="Кирпич" type="text" placeholder="" class="form-control input-md" required="">

     </div>
   </div>

   <!-- Button -->
   <div class="form-group">
     <label class="col-md-4 control-label" for="button"></label>
     <div class="col-md-4">
       <button id="search" name="search" class="btn btn-primary">Поиск</button>
     </div>
   </div>

   </fieldset>
   </form>
   <p>Результаты поиска: ${materials}</p>
</div>
</body>
</html>
