<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <div class="row">
        <div class="col-md-3">Наименование</div>
        <div class="col-md-4">Класс</div>
        <div class="col-md-2">Категория</div>
        <div class="col-md-1">Цена</div>
        <c:if test="${user!=null}">
            <div class="col-md-1">Кол-во</div>
            <div class="col-md-1">В корзину</div>
        </c:if>
    </div>

    <c:forEach items="${materials}" var="material">
       <form class="form-horizontal-${material.ID}" action="do?command=Index" method="post">
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