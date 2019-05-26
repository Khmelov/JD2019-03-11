<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" action="do?command=CreateCar" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Create Car</legend>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="car_type">Car type</label>
                <div class="col-md-4">
                    <select id="car_type" name="car_type" class="form-control">
                        <option value="passenger">passenger</option>
                        <option value="truck">truck</option>
                    </select>
                    <span class="help-block"> select car type </span>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="fuel_type">Fuel type</label>
                <div class="col-md-4">
                    <select id="fuel_type" name="fuel_type" class="form-control">
                        <option value="gasoline">gasoline</option>
                        <option value="diesel">diesel</option>
                        <option value="electricity">electricity</option>
                    </select>
                    <span class="help-block"> select fuel type </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="mark">Car Mark</label>
                <div class="col-md-4">
                    <input id="mark" name="mark" type="text" value="Audi" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> enter car mark (for example: Audi, BMW, Lada...) </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="model">Car Model</label>
                <div class="col-md-4">
                    <input id="model" name="model" type="text" value="Q3" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> enter car model </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="price">Car Price</label>
                <div class="col-md-4">
                    <input id="price" name="price" type="text" value="34500" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> enter the cost of the car </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="year_of_issue">Year of issue</label>
                <div class="col-md-4">
                    <input id="year_of_issue" name="year_of_issue" type="text" value="2012" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> enter year of issue (for example: 1997)</span>
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
