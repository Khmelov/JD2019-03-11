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

<p>Login: ${Login}</p>
<p>E-mail: ${Email}</p>

<div class="list-group">
  <a href="do?command=UserCollection" class="list-group-item list-group-item-action">Your collection</a>
  <a href="do?command=CreateTag" class="list-group-item list-group-item-action">Create new item</a>
  <a href="do?command=DeleteUser" class="list-group-item list-group-item-action">Delete account</a>
</div>

</div>
</body>
</html>