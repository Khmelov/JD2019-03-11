<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <h2>Edit coffemachines</h2>
    <div class="row">
        <div class=col-md-2>Name</div>
        <div class=col-md-2>Firm</div>
        <div class=col-md-2>Power</div>
        <div class=col-md-1>Size</div>
        <div class=col-md-1>Weight</div>
        <div class=col-md-1>WaterC</div>
        <div class=col-md-1>BeansC</div>
        <div class=col-md-1>Color</div>
        <div class=col-md-1>Price</div>
    </div>
    <c:forEach items="${coffemachines}" var="coffemachine">
        <form class="form-horizontal-${coffemachine.id}" action="do?command=editcoffemachines" method="post">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${coffemachine.id}">

                <div class="col-md-2">
                    <input id="name" name="name" type="text" placeholder="" class="form-control input-md"
                           required="" value="${coffemachine.name}">

                </div>

                <div class="col-md-2">
                    <input id="firm" name="firm" type="text" placeholder="" class="form-control input-md"
                           required="" value="${coffemachine.firm}">

                </div>

                <div class="col-md-2">
                    <input id="power" name="power" type="text" placeholder="" class="form-control input-md"
                           required="" value="${coffemachine.power}">
                </div>

                <div class="col-md-1">
                 <input id="size" name="size" type="text" placeholder="" class="form-control input-md"
                           required="" value="${coffemachine.size}">
                </div>
                 <div class="col-md-1">
                 <input id="weight" name="weight" type="text" placeholder="" class="form-control input-md"
                           required="" value="${coffemachine.weight}">
                </div>
                 <div class="col-md-1">
                 <input id="waterContainer" name="waterContainer" type="text" placeholder="" class="form-control input-md"
                           required="" value="${coffemachine.waterContainer}">
                </div>
                 <div class="col-md-1">
                 <input id="beansContainer" name="beansContainer" type="text" placeholder="" class="form-control input-md"
                           required="" value="${coffemachine.beansContainer}">
                </div>
                 <div class="col-md-1">
                 <input id="color" name="color" type="text" placeholder="" class="form-control input-md"
                           required="" value="${coffemachine.color}">
                </div>
                 <div class="col-md-1">
                 <input id="price" name="price" type="text" placeholder="" class="form-control input-md"
                           required="" value="${coffemachine.price}">
                </div>

            </div>

              <!-- Button (Double) -->
            <br>
                <div class="col-md-4">
                    <button id="update" name="update" class="btn btn-success">Update</button>
                    <button id="delete" name="delete" class="btn btn-danger">Delete</button>
                </div>
        </form>
    </c:forEach>


</div>
</body>
</html>