<%@ page contentType="text/html;
    charset=UTF-8"
    language="java"
    pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<br>

<p>Логин: ${Login}</p>
<p>Эл. почта: ${Email}</p>
<p>Коллекция: ${Teatags}</p>

<div class="list-group">
  <a href="do?command=CreateTag" class="list-group-item list-group-item-action">Создать элемент коллекции</a>
  <a href="deleteuser.jsp" class="list-group-item list-group-item-action">Удалить аккаунт</a>
</div>

</div>
</body>
</html>