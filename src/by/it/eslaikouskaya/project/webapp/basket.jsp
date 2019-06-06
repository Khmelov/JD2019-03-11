<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
   <p>${success}</p>
    <c:if test="${user.roles_ID!=1}">
    <h4>Мои покупки</h4>

    <div class="row">
            <div class="col-md-3">Наименование</div>
            <div class="col-md-4">Класс</div>
            <div class="col-md-1">Цена</div>
            <div class="col-md-1">Кол-во</div>
            <div class="col-md-3">Изменить</div>
    </div>
    <hr>

<form class="form-horizontal-${purchase.ID}" action="do?command=Basket" method="post">
    <c:forEach items="${purchases}" var="purchase">

        <div class="row">
        <input id="purchase.ID" name="purchase.ID" type="hidden" placeholder="" class="form-control input-md" required="" value="${purchase.ID}">
        <c:forEach items="${materials}" var="material">
            <c:if test="${material.ID==purchase.materials_ID}">
                <input id="material.ID" name="material.ID" type="hidden" placeholder="" class="form-control input-md" required="" value="${material.ID}">
                <div class="col-md-3" >${material.name}</div>
                <c:forEach items="${grades}" var="grade">
                     <c:if test="${material.grades_ID==grade.ID}">
                          <div class="col-md-4">${grade.grade}</div>
                     </c:if>
                </c:forEach>
            <div class="col-md-1">${material.price}</div>
            <div class="col-md-1">
                <input id="number" name="number" type="text" placeholder="" value="${purchase.number}" class="form-control input-md">
            </div>
            </c:if>
            </c:forEach>
            <div class="col-md-3">
                <button id="change" name="change" class="btn btn-info">Обновить</button>
                <button id="delete" name="delete" class="btn btn-danger">Удалить</button>
            </div>
        </div>


    </c:forEach>
               <!-- Button -->
               <div class="form-group">
               <div class="col-md-4">
               <button id="send" name="send" class="btn btn-warning">Заказать</button>
               </div>
               </div>
</form>
    <h3>${sent}</h3>
    </c:if>
<br><hr>
     <p>+375 (177) 742777  +375 (177) 931777  +375 (29) 6872793  +375 (33) 6740370</p>
</div>
</body>
</html>


