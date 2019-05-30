<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="do?command=Index">BORITORG</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <c:if test="${user==null}">
            <li class="nav-item">
                <a class="nav-link" href="do?command=Login">Вход</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=SignUp">Регистрация</a>
            </li>
            </c:if>
            <c:if test="${user.roles_ID==1}">
            <li class="nav-item">
                <a class="nav-link" href="do?command=CreateMat">Изменить материал</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=CreateGrade">Изменить класс</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=CreateCategory">Изменить категорию</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=EditUsers">Админка</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=ResetDB">ResetDB</a>
            </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link" href="do?command=Index">Index</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="do?command=Search">Поиск</a>
            </li>
            <c:if test="${user!=null}">
            <li class="nav-item">
                <a class="nav-link" href="do?command=Profile">Аккаунт</a>
            </li>
            </c:if>
        </ul>
    </div>
</nav>
