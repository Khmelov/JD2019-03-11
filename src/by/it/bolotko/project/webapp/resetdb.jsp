<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=ResetDB" method="post">
        <fieldset>
            <!-- Form Name -->
            <legend>ResetDB</legend>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="resetdb">Are you sure you want to Reset DB?</label>
                <div class="col-md-4">
                    <button id="resetdb" value="agree" name="resetdb" class="btn btn-warning">Agree</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
