<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <p>All coffemachines: ${coffemachines}</p>
    <form class="form-horizontal" action="do?command=addcoffemachine" method="post" enctype="multipart/form-data">
    <fieldset>

    <!-- Form Name -->
    <legend>addcoffemachine</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Name">Name</label>
      <div class="col-md-4">
      <input id="Name" name="Name" value="DELONGHI EN 80 CW" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Firm">Firm</label>
      <div class="col-md-4">
      <input id="Firm" name="Firm" value="NESPRESSO" type="text" placeholder="" class="form-control input-md" required="">
      <span class="help-block">coffemachine company</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Power">Power</label>
      <div class="col-md-4">
      <input id="Power" name="Power" value="1260 Bt" type="text" placeholder="" class="form-control input-md" required="">
      <span class="help-block">the capacity of the machine</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Size">Size</label>
      <div class="col-md-4">
      <input id="Size" name="Size" value="118x230x315" type="text" placeholder="" class="form-control input-md" required="">
      <span class="help-block"> please, enter in format 999x999x999</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Weight">Weight</label>
      <div class="col-md-4">
      <input id="Weight" name="Weight" value="2.4" type="text" placeholder="" class="form-control input-md" required="">
      <span class="help-block"> please, enter in kilograms</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="WaterContainer">WaterContainer</label>
      <div class="col-md-4">
      <input id="WaterContainer" name="WaterContainer"  value="-" type="text" placeholder="" class="form-control input-md">
      <span class="help-block"> please, enter in liters</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="BeansContainer">BeansContainer</label>
      <div class="col-md-4">
      <input id="BeansContainer" name="BeansContainer" value="-" type="text" placeholder="" class="form-control input-md">
      <span class="help-block"> please, enter in liters</span>
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Color">Color</label>
      <div class="col-md-4">
      <input id="Color" name="Color" value = "White" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Price">Price</label>
      <div class="col-md-4">
      <input id="Price" name="Price" value="20" type="text" placeholder="" class="form-control input-md" required="">
      <span class="help-block"> please, enter in dollars</span>
      </div>
    </div>

     <!-- File Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="photo">Photo</label>
                    <div class="col-md-4">
                        <input id="photo" name="photo" class="input-file" type="file">
                    </div>
                </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="request"></label>
      <div class="col-md-4">
        <button id="request" name="request" class="btn btn-primary">add</button>
      </div>
    </div>

    </fieldset>
    </form>

</div>
</body>
</html>