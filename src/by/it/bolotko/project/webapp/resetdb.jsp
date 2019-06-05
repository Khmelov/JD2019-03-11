<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body style="background-image:url(images/fon2.jpg)">
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <br>
    <form class="form-horizontal" align="center" action="do?command=ResetDB" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Сброс Базы Данных</legend>
            <!-- Button -->
            <div class="form-group" align="center">
                <label class="col-md-6 control-label" for="resetdb">Вы уверены что хотите выполнить сброс базы данных?</label>
                <div class="col-md-4">
                    <button id="resetdb" value="agree" name="resetdb" class="btn btn-warning">Да!</button>
                </div>
            </div>

        </fieldset>
    </form>
    <p align="center"><img src="images/reset.jpg"></p>
</div>
</body>
</html>
