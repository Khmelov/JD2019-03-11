<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="do?command=Index">БОРИТОРГ</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <div class="navbar-nav">
                <div>
                  <form class="form-inline" action="do?command=Search" method="post">
                    <input class="form-control mr-sm-2" id="name" name="name" value="муфта" type="search" placeholder="Поиск" aria-label="Search">
                    <button class="btn btn-secondary btn-sm" id="search" name="search" type="submit">Искать</button>
                  </form>
                  </div>
        </div>
        <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
            <c:choose>
                <c:when test="${user!=null}">
                    <my:menu command="Profile" text="Профиль"/>
                    <c:if test="${user.roles_ID!=1}">
                                        <my:menu command="Basket" text="Корзина"/>
                                        </c:if>
                    <form class="form-horizontal" action="do?command=LogOut" method="post">
                         <button id="logout" name="logout" class="btn btn-link">Выйти</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <my:menu command="Login" text="Войти"/>
                    <my:menu command="SignUp" text="Регистрация"/>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>

<div>
<nav class="nav">
  <a class="nav-link active" href="do?command=Index">Каталог</a>
  <a class="nav-link" href="do?command=AboutUs">О нас</a>
  <a class="nav-link" href="do?command=Contacts">Контакты</a>
  <c:if test="${user.roles_ID==1}">
  <a class="nav-link" href="do?command=EditUsers">Администрирование</a>
  <a class="nav-link" href="do?command=EditMat">Изменить материал</a>
  <a class="nav-link" href="do?command=EditGrade">Изменить класс</a>
  <a class="nav-link" href="do?command=EditCategory">Изменить категорию</a>
  <a class="nav-link" href="do?command=ResetDB">Сброс базы данных</a>
  </c:if>
</nav>
</div>

