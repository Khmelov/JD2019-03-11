<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <form class="form-horizontal" action="do?command=SignUp" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Sign up</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" value="testUser" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">[a-z],[A-Z],[0-9], not less than 4 symbols (ex: Dmitryi)</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" value="test@mail.com" placeholder="login@mail.com" class="form-control input-md" required="">
                    <span class="help-block">e-mail (ex: dmitryi@gmail.com)</span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" value="testpassword" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">not les than 4 symbols (ex: DmitryiCool)</span>
                </div>
            </div>

            <!-- Phone input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="phone">Phone</label>
                <div class="col-md-4">
                    <input id="phone" name="phone" type="text" value="+375296748271" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">enter phone (ex: +375xxxxxxxxx)</span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signup"></label>
                <div class="col-md-4">
                    <button id="signup" name="signup" class="btn btn-success">Sing up</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>




