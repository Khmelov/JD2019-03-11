<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body style="background-image:url(images/fon2.jpg); background-repeat:repeat-x; background-attachment:fixed">
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <br>

    <p align="center" style="color:#284755; font-size:35px"><b><i>Все объявления о продаже автомобилей:</i></b></p>
    <c:if test="${user==null}">
        <p align="center" style="color:darkred; font-size:20px"><b><i>Для просмотра дополнительной информации об
            объявлении требуется
            ЗАРЕГЕСТРИРОВАТЬСЯ или совершить ВХОД в свой аккаунт!</i></b></p>
    </c:if>

    <div class="row">
        <%--        <div class="col-md-2">Фото</div> --%>
        <div class="col-md-2" align="center" style="color:#284755; font-size:18px"><b><i>Тип автомобиля:</i></b></div>
        <div class="col-md-1" align="center" style="color:#284755; font-size:18px"><b><i>Тип топлива:</i></b></div>
        <div class="col-md-2" align="center" style="color:#284755; font-size:18px"><b><i>Марка авто:</i></b></div>
        <div class="col-md-1" align="center" style="color:#284755; font-size:18px"><b><i>Модель авто:</i></b>
        </div>
        <div class="col-md-1" align="center" style="color:#284755; font-size:18px"><b><i>Цена (USD):</i></b></div>
        <div class="col-md-1" align="center" style="color:#284755; font-size:18px"><b><i>Год выпуска:</i></b></div>
        <c:if test="${user==null}">
            <div class="col-md-4" align="center" style="color:darkred; font-size:18px"><b>Доступ запрещён!</b></div>
        </c:if>
        <c:if test="${user!=null}">
            <div class="col-md-2" align="center" style="font-size:18px"><b><i>Email продовца:</i></b>
            </div>
            <div class="col-md-2" align="center" style="font-size:18px"><b><i>Телефон продовца:</i></b>
            </div>
        </c:if>
    </div>
    <br>

    <c:forEach items="${cars}" var="car">
        <div class="row">
                <%--            <div class="col-md-2"><img src="images/img${car.id}" height="90"> </div>--%>
            <div class="col-md-2" align="center" style="color:#295361; font-size:18px"><b>${car.car_type}</b></div>
            <div class="col-md-1" align="center" style="color:#295361; font-size:18px"><b>${car.fuel_type}</b></div>
            <div class="col-md-2" align="center" style="color:#295361; font-size:18px"><b>${car.mark}</b></div>
            <div class="col-md-1" align="center" style="color:#295361; font-size:18px"><b>${car.model}</b></div>
            <div class="col-md-1" align="center" style="color:#295361; font-size:18px"><b>${car.price}</b></div>
            <div class="col-md-1" align="center" style="color:#295361; font-size:18px"><b>${car.year_of_issue}</b></div>
            <input id="users_id" name="users_id" type="hidden" placeholder="" class="form-control input-md"
                   required="" value="${car.users_id}">
            <c:if test="${user!=null}">
                <c:choose>
                    <c:when test="${car.users_id==1}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>kostja100@gmail.com</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375297326543</b></div>
                    </c:when>
                    <c:when test="${car.users_id==2}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>nikolajab@mail.ru</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375335897326</b></div>
                    </c:when>
                    <c:when test="${car.users_id==3}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>dinis228@gmail.com</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375442417438</b></div>
                    </c:when>
                    <c:when test="${car.users_id==4}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>moderator1@gmail.com</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375297634920</b></div>
                    </c:when>
                    <c:when test="${car.users_id==5}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>moderator2@gmail.com</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375297634921</b></div>
                    </c:when>
                    <c:when test="${car.users_id==6}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>test1@yandex.ru</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375297634900</b></div>
                    </c:when>
                    <c:when test="${car.users_id==7}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>test2@yandex.ru</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375297634900</b></div>
                    </c:when>
                    <c:when test="${car.users_id==8}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>maksim1997@mail.ru</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375335356226</b></div>
                    </c:when>
                    <c:when test="${car.users_id==9}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>test@mail.com</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375296748271</b></div>
                    </c:when>
                    <c:when test="${car.users_id==10}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>asrail@yandex.ru</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375334289132</b></div>
                    </c:when>
                    <c:when test="${car.users_id==11}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>kolish@mail.ru</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375292230547</b></div>
                    </c:when>
                    <c:when test="${car.users_id==12}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>grandy@mail.com</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375255564278</b></div>
                    </c:when>
                    <c:when test="${car.users_id==13}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>yarik@gmail.com</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375297879121</b></div>
                    </c:when>
                    <c:when test="${car.users_id==14}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>archer@gmail.com</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375337778102</b></div>
                    </c:when>
                    <c:when test="${car.users_id==15}">
                        <div class="col-md-2" align="center" style="font-size:17px"><b>liran@mail.com</b></div>
                        <div class="col-md-2" align="center" style="font-size:17px"><b>+375259290567</b></div>
                    </c:when>
                    <c:otherwise> Что-то пошло не так:) </c:otherwise>
                </c:choose>
            </c:if>
        </div>
    </c:forEach>

    <hr>
    <my:paginator count="${carsSize}" step="15" urlprefix="?start="/>

    <hr>
    <p align="center"><img src="images/auto.jpg"></p>

</div>
</body>
</html>