<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h2>Show all requests</h2>
    <div class="row">
        <div class=col-md-2>users_ID</div>
        <div class=col-md-2>Contact</div>
        <div class=col-md-2>DeliveryAddress</div>
        <div class=col-md-2>coffemachines_ID</div>
    </div>
    <c:forEach items="${requests}" var="request">
        <form class="form-horizontal-${request.id}" action="do?command=showallrequests" method="get">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${request.id}">

              <div class="col-md-2">
                    <input id="users_ID" name="users_ID" type="text" placeholder="" class="form-control input-md"
                           required="" value="${request.users_ID}">

                </div>

                <div class="col-md-2">
                    <input id="Contact" name="Contact" type="text" placeholder="" class="form-control input-md"
                           required="" value="${request.contact}">

                </div>

                <div class="col-md-2">
                    <input id="DeliveryAddress" name="DeliveryAddress" type="text" placeholder="" class="form-control input-md"
                           required="" value="${request.deliveryAddress}">
                </div>

             <div class="col-md-2">
                    <input id="coffemachines_ID" name="coffemachines_ID" type="text" placeholder="" class="form-control input-md"
                           required="" value="${request.coffemachines_ID}">
                </div>

            </div>
        </form>
    </c:forEach>


</div>
</body>
</html>