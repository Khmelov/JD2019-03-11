<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>

<h3>${added}</h3>
    <div class="row">
        <div class="col-md-1">Фото</div>
        <div class="col-md-3">Наименование</div>
        <div class="col-md-3">Класс</div>
        <div class="col-md-2">Категория</div>
        <div class="col-md-1">Цена</div>
        <c:if test="${user!=null}">
            <div class="col-md-1">Кол-во</div>
        </c:if>
    </div>
    <hr>

    <c:forEach items="${materials}" var="material">
       <form class="form-horizontal-${material.ID}" action="do?command=Index" method="post">
        <div class="row">
        <input id="ID" name="ID" type="hidden" placeholder="" class="form-control input-md" required="" value="${material.ID}">
        <c:forEach items="${grades}" var="grade">
        <c:if test="${material.grades_ID==grade.ID}">
        <div class="col-md-1"><img src="images/img${grade.ID}" height="80"></div>
            <div class="col-md-3">${material.name}</div>
                    <div class="col-md-3">${grade.grade}</div>
                        <c:forEach items="${categories}" var="category">
                            <c:if test="${grade.categories_ID==category.ID}">
                                <div class="col-md-2">${category.category}</div>
                            </c:if>
                        </c:forEach>
                </c:if>
        </c:forEach>
            <div class="col-md-1">${material.price}</div>
            <c:if test="${user.roles_ID!=1}">
            <c:if test="${user!=null}">
            <!-- Text input-->
                 <div class="col-md-1">
                 <input id="number" name="number" type="text" placeholder="" class="form-control input-md">
                 </div>
                 </c:if>
                 <div class="col-md-1">
                     <button id="tobasket" name="tobasket" class="btn btn-light">Добавить</button>
                 </div>
            </c:if>
        </div>
        </form>
    </c:forEach>

    <hr>
    <my:paginator count="${matSize}" step="10" urlprefix="?start="/>
<hr>
  <p>+375 (177) 742777  +375 (177) 931777  +375 (29) 6872793  +375 (33) 6740370</p>
</div>
</body>
</html>