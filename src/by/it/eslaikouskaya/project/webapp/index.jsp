<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<h3>${added}</h3>

<div class="row">
     <c:forEach items="${materials}" var="material">
     <div class="col-md-4">
           <form class="form-horizontal-${material.ID}" action="do?command=Index" method="post">
                <input id="ID" name="ID" type="hidden" placeholder="" class="form-control input-md" required="" value="${material.ID}">
                <div><strong>${material.name}</strong></div>
                <c:forEach items="${grades}" var="grade">
                     <c:if test="${material.grades_ID==grade.ID}">
                     <div><img src="images/img${grade.ID}.png" height="200"></div>
                     <div><small>Класс: ${grade.grade}</small></div>
                     <c:forEach items="${categories}" var="category">
                         <c:if test="${grade.categories_ID==category.ID}">
                             <div><small>Категория: ${category.category}</small></div>
                         </c:if>
                     </c:forEach>
                     </c:if>
                </c:forEach>
                <div >Цена: ${material.price}</div>
                <div class="row">
                <c:if test="${user.roles_ID!=1}">
                <c:if test="${user!=null}">

                <div class="col-md-4">
                <input id="number" name="number" type="text" placeholder="Кол-во" class="form-control input-md">
                </div>

                </c:if>
                <div class="col-md-1">
                    <button id="tobasket" name="tobasket" class="btn btn-light">Добавить</button>
                </div>
                </c:if>
                </div>
                </div>
           </form>
     </c:forEach>
     </div>

    <hr>
    <my:paginator count="${matSize}" step="12" urlprefix="?start="/>
<hr>
  <p>+375 (177) 742777  +375 (177) 931777  +375 (29) 6872793  +375 (33) 6740370</p>
</div>
</body>
</html>