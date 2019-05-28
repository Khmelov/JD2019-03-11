<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal" action="do?command=SignUp" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Sign Up</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" value="testUser" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">[a-z],[A-Z],[0-9], min 4 symbols (for example: Aleksei)</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" value="test@mail.com" placeholder="login@mail.com" class="form-control input-md" required="">
                    <span class="help-block">you email (for example: aleksei@gmail.com)</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" value="testpassword" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">min 4 symbols (for example: AlekseiDA1975)</span>
                </div>
            </div>

            <!-- Phone input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="phone">Phone</label>
                <div class="col-md-4">
                    <input id="phone" name="phone" type="text" value="+375296748271" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">phone +375xxxxxxxxx</span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signup"></label>
                <div class="col-md-4">
                    <button id="signup" name="signup" class="btn btn-success">Sign Up</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>




