<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=CreateRequest" method="post">
    <fieldset>

    <!-- Form Name -->
    <legend>Create request</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Contact">Contact</label>
      <div class="col-md-4">
      <input id="Contact" name="Contact" value="+ 375 29 345 58 37" type="text"  placeholder="telephone" class="form-control input-md" required="">
      <span class="help-block">please, enter your telephone in format(+375 XX XXX XX XX)</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Delivery address">Delivery address</label>
      <div class="col-md-4">
      <input id="Delivery address" name="Delivery address" value="Pr.Mira d27, f12" type="text" placeholder="your address" class="form-control input-md" required="">
      <span class="help-block">please, enter your address</span>
      </div>
    </div>

    <!-- Select Basic -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Coffemachine">Coffemachine</label>
      <div class="col-md-4">
        <select id="Coffemachine" name="Coffemachine" class="form-control">
         <c:forEach var="coffemachine" items="${coffemachines}" >
            <option value="${coffemachine.name}">${coffemachine.name}</option>
         </c:forEach>
        </select>
      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="singlebutton"></label>
      <div class="col-md-4">
        <button id="singlebutton" name="singlebutton" class="btn btn-primary">request</button>
      </div>
    </div>

    </fieldset>
    </form>

</div>
</body>
</html>