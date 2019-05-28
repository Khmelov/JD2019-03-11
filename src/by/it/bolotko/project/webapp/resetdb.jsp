<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=ResetDB" method="post">
        <fieldset>
            <!-- Form Name -->
            <legend>Reset DB</legend>

            <!-- Button (Double) -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="resetdba">Are you sure you want to delete the database?</label>
                <div class="col-md-8">
                    <button id="resetdba" name="resetdba" class="btn btn-success">Agree</button>
                    <button id="resetdbd" name="resetdbd" class="btn btn-danger">Disagree</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
