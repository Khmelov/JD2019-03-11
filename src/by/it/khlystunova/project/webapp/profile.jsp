<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
   <form class="form-horizontal" action="do?command=Profile" method="post">
   <fieldset>
    <!-- Form Name -->
                <legend>My information</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="login">Login</label>
                    <div class="col-md-4">
                        <input id="login" name="login" value="${user.login}" type="text" placeholder="" class="form-control input-md" required="">
                        <span class="help-block">your login</span>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="email">E-mail</label>
                    <div class="col-md-4">
                        <input id="email" name="email" value="${user.email}" type="text" placeholder="login@postserver.com" class="form-control input-md" required="">
                        <span class="help-block">Your e-mail</span>
                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="password">Password</label>
                    <div class="col-md-4">
                        <input id="password" name="password" value="${user.password}" type="password" placeholder="" class="form-control input-md" required="">
                        <span class="help-block">enter a password of at least 4 characters</span>
                    </div>
                </div>
    <!-- Button (Double) -->
               <div class="form-group">
                   <div class="col-md-8">
                       <button id="update" name="update"  class="btn btn-success">update</button>
                       <button id="logout" name="logout"  class="btn btn-danger">logout</button>
                   </div>
               </div>
   </fieldset>
   </form>

 <h4>My requests</h4>
    <div class="row">
        <div class="col-md-3">Coffemachine</div>
        <div class="col-md-3">Contact</div>
        <div class="col-md-3">DeliveryAddress</div>
    </div>

    <c:forEach items="${requests}" var="request">
        <div class="row">
            <div class="col-md-3">${request.coffemachines_ID}</div>
            <div class="col-md-3">${request.contact}</div>
            <div class="col-md-3">${request.deliveryAddress}</div>
        </div>
    </c:forEach>
    <hr>
    <my:paginator count="${adsSize}" step="5" urlprefix="do?command=profile&start="/>
    <hr>
</div>
</body>
</html>