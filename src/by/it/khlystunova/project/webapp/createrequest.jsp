<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
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
      <label class="col-md-4 control-label" for="Coffemashine">Coffemashine</label>
      <div class="col-md-4">
        <select id="Coffemashine" name="Coffemashine" class="form-control">
          <option value="1">Option one</option>
          <option value="2">Option two</option>
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