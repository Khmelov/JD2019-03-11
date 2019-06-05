<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=ResetDB" method="post">
        <fieldset>
            <!-- Form Name -->
            <legend>Сброс Базы Данных</legend>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-6 control-label" for="resetdb">Вы уверены что хотите выполнить сброс базы данных?</label>
                <div class="col-md-4">
                    <button id="resetdb" value="yes" name="resetdb" class="btn btn-warning">Да!</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
