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
            </c:if>
        </ul>
        <form class="navbar-nav my-2 my-lg-0">
            <c:if test="${user!=null}">
                <my:menu command="Logout" text="Выход"/>
            </c:if>
        </form>
        <form class="navbar-nav my-2 my-lg-0">
            <c:if test="${user.roles_id==1}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Администрирование
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="do?command=DataBase">База данных</a>
                        <a class="dropdown-item" href="do?command=EditUsers">Управление пользователями</a>
                        <a class="dropdown-item" href="do?command=EditCars">Управление объявлениями</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="do?command=ResetDB">Сброс базы данных</a>
                    </div>
                </li>
            </c:if>
            <c:if test="${user.roles_id==3}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Администрирование
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="do?command=DataBase">База данных</a>
                        <a class="dropdown-item" href="do?command=EditCars">Управление объявлениями</a>
                    </div>
                </li>
            </c:if>
        </form>
    </div>
</nav>
