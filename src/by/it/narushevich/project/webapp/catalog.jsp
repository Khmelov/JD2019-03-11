<%@ page contentType="text/html;
    charset=UTF-8"
    language="java"
    pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
<%@ include file="include/menu.jsp" %>
<br>
<h4>Все ярлычки на сайте</h4>
<br>

<div class="row">
        <div class="col-md-2 text-center">Торговая марка</div>
        <div class="col-md-3 text-center">Подзаголовок</div>
        <div class="col-md-1 text-center">Материал</div>
        <div class="col-md-1 text-center">Ширина, мм</div>
        <div class="col-md-1 text-center">Высота, мм</div>
        <div class="col-md-2 text-center">В коллекции с</div>
        <div class="col-md-1 text-center">Номер в каталоге</div>
        <div class="col-md-1 text-center">Имя пользователя</div>
    </div>
<br>
    <c:forEach items="${teatags}" var="teatag">
        <div class="row">
            <div class="col-md-2">${teatag.trademark}</div>
            <div class="col-md-3">${teatag.subtitle}</div>
            <div class="col-md-1">${teatag.material}</div>
            <div class="col-md-1 text-center">${teatag.width}</div>
            <div class="col-md-1 text-center">${teatag.height}</div>
            <div class="col-md-2 text-center">${teatag.inCollectionSince}</div>
            <div class="col-md-1">${teatag.numInCatalog}</div>
            <div class="col-md-1 text-center">${teatag.userName}</div>
        </div>
    </c:forEach>
    <br><br>

</div>
</body>
</html>