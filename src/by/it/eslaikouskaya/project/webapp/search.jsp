<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

   <form class="form-horizontal-${material.ID}" action="do?command=Search" method="post">
      <fieldset>

   <!-- Form Name -->
   <legend>Поиск</legend>

   <!-- Text input-->
   <div class="form-group">
     <label class="col-md-4 control-label" for="name">Наименование материала</label>
     <div class="col-md-4">
     <input id="name" name="name" value="муфта" type="text" placeholder="" class="form-control input-md" required="">

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

   <p>Результаты поиска:</p>
   <p>${notfound}</p>
   <c:forEach items="${materials}" var="material">
   <form class="form-horizontal-${material.ID}" action="do?command=Search" method="post">
           <div class="row">
           <input id="ID" name="ID" type="hidden" placeholder="" class="form-control input-md"
                                  required="" value="${material.ID}">
               <div class="col-md-3">${material.name}</div>
               <c:forEach items="${grades}" var="grade">
                   <c:if test="${material.grades_ID==grade.ID}">
                       <div class="col-md-4">${grade.grade}</div>
                           <c:forEach items="${categories}" var="category">
                               <c:if test="${grade.categories_ID==category.ID}">
                                   <div class="col-md-2">${category.category}</div>
                               </c:if>
                           </c:forEach>
                   </c:if>
               </c:forEach>
               <div class="col-md-1">${material.price}</div>
               <c:if test="${user!=null}">
               <!-- Text input-->
                    <div class="col-md-1">
                    <input id="number" name="number" type="text" placeholder="" class="form-control input-md">
                    </div>
                    <div class="col-md-1">
                        <button id="tobasket" name="tobasket" class="btn btn-light">Добавить</button>
                    </div>
               </c:if>
           </div>
   </form>
   </c:forEach>
</div>
</body>
</html>
