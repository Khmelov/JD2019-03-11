<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=CreateMat" method="post">
<fieldset>

<!-- Form Name -->
<legend>Create material</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Material name</label>
  <div class="col-md-4">
  <input id="name" name="name" value="Brick" type="text" placeholder="Введите название материала" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="grade">Grade number</label>
  <div class="col-md-4">
  <input id="grades_ID" name="grades_ID" value="20" type="text" placeholder="Введите номер класса" class="form-control input-md" required="">
  <span class="help-block">Should match categories</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Price</label>
  <div class="col-md-4">
  <input id="price" name="price" value="20" type="text" placeholder="Введите стоимость материала" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="button"></label>
  <div class="col-md-4">
    <button id="button" name="button" class="btn btn-primary">Create</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>


