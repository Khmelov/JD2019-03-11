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

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Trademark list</label>
  <div class="col-md-4">
    <select id="selectbasic" name="selectbasic" class="form-control">
      <option value="0"></option>
      <option value="1">Ahmad tea</option>
      <option value="2">Akbar</option>
      <option value="3">Alattar</option>
      <option value="4">Auchan</option>
      <option value="5">Brooke Bond</option>
      <option value="6">Chelton</option>
      <option value="7">Dilmah</option>
      <option value="8">Forest of Arden</option>
      <option value="9">Golden Bowl</option>
      <option value="10">Greenfield</option>
      <option value="11">Jaf tea</option>
      <option value="12">Kakoo</option>
      <option value="13">Lipton</option>
      <option value="14">Lord Nelson</option>
      <option value="15">Mabroc</option>
      <option value="16">Maitre de The</option>
      <option value="17">Malwa</option>
      <option value="18">Messmer</option>
      <option value="19">Mistral</option>
      <option value="20">Natursan</option>
      <option value="21">Pickwick</option>
      <option value="22">Princess Java</option>
      <option value="23">Tea</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Trademark</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">enter trademark here if it is not listed</span>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Material</label>
  <div class="col-md-4">
    <select id="selectbasic" name="selectbasic" class="form-control">
      <option value="1">cardboard</option>
      <option value="2">paper</option>
      <option value="3">plastic</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Subtitle</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">what is writing on tag else</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Width, mm</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">Width in mm of your tag</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Height, mm</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">Height in mm of your tag</span>
  </div>
</div>

<!-- Date input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">In collection since</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md">
    <span class="help-block">Date in format yyyy-mm-dd</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Number in catalog</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md">

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