<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<br>

<form class="form-horizontal" action="do?command=CreateTag" method="post">
<fieldset>

<!-- Form Name -->
<legend>Create new item in your collection</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Trademark</label>
  <div class="col-md-4">
  <input id="trademark" name="Trademark" type="text" value="Wisotzky tea" placeholder="" class="form-control input-md">
  <span class="help-block">enter trademark here if it is not listed</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Subtitle</label>
  <div class="col-md-4">
  <input id="textinput" name="Subtitle" type="text" value="Very taste tea" placeholder="" class="form-control input-md">
  <span class="help-block">what is writing on tag else</span>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Material</label>
  <div class="col-md-4">
    <select id="material" name="material" class="form-control">
      <option value="1">cardboard</option>
      <option value="2">paper</option>
      <option value="3">plastic</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Width, mm</label>
  <div class="col-md-4">
  <input id="textinput" name="Width, mm" type="text" value="25" placeholder="" class="form-control input-md">
  <span class="help-block">Width in mm of your tag</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Height, mm</label>
  <div class="col-md-4">
  <input id="textinput" name="Height, mm" type="text" value="28" placeholder="" class="form-control input-md">
  <span class="help-block">Height in mm of your tag</span>
  </div>
</div>

<!-- Date input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">In collection since</label>
  <div class="col-md-4">
  <input id="textinput" name="In collection since" type="text" value="2005-07-04" placeholder="" class="form-control input-md">
    <span class="help-block">Date in format yyyy-mm-dd</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Number in catalog</label>
  <div class="col-md-4">
  <input id="textinput" name="Number in catalog" type="text" value="02-05-4" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- File Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="filebutton">Picture</label>
  <div class="col-md-4">
    <input id="filebutton" name="filebutton" class="input-file" type="file">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Create</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>