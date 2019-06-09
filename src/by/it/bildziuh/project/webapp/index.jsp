<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <div class="row">
        <div class="col-md-1">Логотип</div>
        <div class="col-md-2">Название игры</div>
        <div class="col-md-2">Категория модификации</div>
        <div class="col-md-2">Название</div>
        <div class="col-md-3">Описание</div>
        <div class="col-md-1">Размер (Мб)</div>
        <div class="col-md-1">Ссылка</div>
    </div>

    <c:forEach items="${mods}" var="mod">
        <div class="row">
            <div class="col-md-1"><img src="images/img${mod.id}" height="80"> </div>
            <div class="col-md-2">${mod.game}</div>
            <div class="col-md-2">${mod.group}</div>
            <div class="col-md-2">${mod.name}</div>
            <div class="col-md-3">${mod.description}</div>
            <div class="col-md-1">${mod.size}</div>
            <div class="col-md-1">${mod.link}</div>
        </div>
    </c:forEach>

    <hr>
    <my:paginator count="${modsSize}" step="10" urlprefix="?start="/>

</div>
</body>
</html>