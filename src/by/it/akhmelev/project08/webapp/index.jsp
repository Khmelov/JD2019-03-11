<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <div class="row">
        <div class="col-md-1">Фото</div>
        <div class="col-md-1">Цена</div>
        <div class="col-md-2">Адрес</div>
        <div class="col-md-2">Описание</div>
        <div class="col-md-1">Число комнат</div>
        <div class="col-md-1">Площадь</div>
        <div class="col-md-1">Этаж</div>
        <div class="col-md-1">Этажность</div>
    </div>

    <c:forEach items="${ads}" var="ad">
        <div class="row">
            <div class="col-md-1"><img src="images/img${ad.id}" height="80"> </div>
            <div class="col-md-1">${ad.price}</div>
            <div class="col-md-2">${ad.address}</div>
            <div class="col-md-2">${ad.description}</div>
            <div class="col-md-1">${ad.rooms}</div>
            <div class="col-md-1">${ad.area}</div>
            <div class="col-md-1">${ad.floor}</div>
            <div class="col-md-1">${ad.floors}</div>
        </div>
    </c:forEach>

    <hr>
    <my:paginator count="${adsSize}" step="10" urlprefix="?start="/>

</div>
</body>
</html>