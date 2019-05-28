<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <p>User: ${user}</p>
    <p>Ads: ${ads}</p>

    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>
            <!-- Form Name -->
            <legend>Logout</legend>
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" value="ok" name="logout" class="btn btn-warning">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>

</div>
</body>
</html>
