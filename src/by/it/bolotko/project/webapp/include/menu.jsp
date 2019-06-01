<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href=".">Главная</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <c:if test="${user==null}">
                <my:menu command="Login" text="Авторизация"/>
                <my:menu command="SignUp" text="Регистрация"/>
            </c:if>
            <c:if test="${user!=null}">
                <my:menu command="Profile" text="Профиль"/>
                <my:menu command="CreateCar" text="Создание объявления"/>
                <my:menu command="Logout" text="Выход"/>
            </c:if>
            <c:if test="${user.roles_id==1}">
                <my:menu command="Index" text="База данных"/>
                <my:menu command="EditUsers" text="Управление"/>
                <my:menu command="ResetDB" text="Сброс БД"/>
            </c:if>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
        </form>
    </div>
</nav>
