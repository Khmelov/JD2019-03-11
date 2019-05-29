<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href=".">Главная</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <c:if test="${user!=null}">
                <li class="nav-item">
                    <a class="nav-link" href="do?command=CreateAd">Создать объявление</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="do?command=EditUsers">Админка</a>
                </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link" href="do?command=ResetDB">Сброс</a>
            </li>
            <c:if test="${user==null}">
                <li class="nav-item">
                    <a class="nav-link" href="do?command=Login">Авторизация</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="do?command=SignUp">Регистрация</a>
                </li>
            </c:if>

            <c:if test="${user!=null}">
                <li class="nav-item">
                    <a class="nav-link" href="do?command=Profile">Профиль</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
