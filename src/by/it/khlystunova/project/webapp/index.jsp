<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
      <div class="row">
            <div class="col-md-1">Photo</div>
            <div class="col-md-1">Name</div>
            <div class="col-md-1">Firm</div>
            <div class="col-md-2">Power</div>
            <div class="col-md-2">Size</div>
            <div class="col-md-1">Weight</div>
            <div class="col-md-1">WaterC</div>
            <div class="col-md-1">BeansC</div>
            <div class="col-md-1">Color</div>
            <div class="col-md-1">Price</div>
        </div>

           <c:forEach items="${coffemachines}" var="coffemachine">
                  <div class="row">
                      <div class="col-md-1"><img src="images/${coffemachine.id}.jpg" height="70"> </div>
                      <div class="col-md-1">${coffemachine.name}</div>
                      <div class="col-md-1">${coffemachine.firm}</div>
                      <div class="col-md-2">${coffemachine.power}</div>
                      <div class="col-md-2">${coffemachine.size}</div>
                      <div class="col-md-1">${coffemachine.weight}</div>
                      <div class="col-md-1">${coffemachine.waterContainer}</div>
                      <div class="col-md-1">${coffemachine.beansContainer}</div>
                      <div class="col-md-1">${coffemachine.color}</div>
                      <div class="col-md-1">${coffemachine.price}</div>
                  </div>
              </c:forEach>

              <hr>
              <my:paginator count="${coffemachinesSize}" step="5" urlprefix="do?command=index&start="/>

</div>
</body>
</html>
