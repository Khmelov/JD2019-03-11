<%@ page contentType="text/html;
    charset=UTF-8"
    language="java"
    pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<br>

<form class="form-horizontal" action="do?command=CreateTag" method="post">
<fieldset>

<!-- Form Name -->
<legend>Создание элемента для вашей коллекции</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="trademark">Торговая марка</label>
  <div class="col-md-4">
  <input id="trademark" name="trademark" type="text" value="Wisotzky tea" placeholder="" class="form-control input-md">
  <span class="help-block">enter trademark here if it is not listed</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="subtitle">Подзаголовок</label>
  <div class="col-md-4">
  <input id="subtitle" name="subtitle" type="text" value="Very taste tea" placeholder="" class="form-control input-md">
  <span class="help-block">what is writing on tag else</span>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="material">Материал</label>
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
  <label class="col-md-4 control-label" for="width">Ширина, мм</label>
  <div class="col-md-4">
  <input id="width" name="width" type="text" value="25" placeholder="" class="form-control input-md">
  <span class="help-block">Width in mm of your tag</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="height">Высота, мм</label>
  <div class="col-md-4">
  <input id="height" name="Height, mm" type="text" value="28" placeholder="" class="form-control input-md">
  <span class="help-block">Height in mm of your tag</span>
  </div>
</div>

<!-- Date input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="in collection">В коллекции с</label>
  <div class="col-md-4">
  <input id="in collection" name="in collection" type="text" value="2005-07-04" placeholder="" class="form-control input-md">
    <span class="help-block">Date in format yyyy-mm-dd</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="number in catalog">Номер в каталоге</label>
  <div class="col-md-4">
  <input id="number in catalog" name="number in catalog" type="text" value="02-05-4" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- File Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="picture">Изображение</label>
  <div class="col-md-4">
    <input id="picture" name="picture" class="input-file" type="file">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="create"></label>
  <div class="col-md-4">
    <button id="create" name="create" class="btn btn-primary">Создать элемент</button>
  </div>
</div>

</fieldset>
</form>

</div>
</body>
</html>