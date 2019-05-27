<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=CreateGrade" method="post">
<fieldset>

<!-- Form Name -->
<legend>Create grade</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="grade">Grade name</label>
  <div class="col-md-4">
  <input id="grade" name="grade" type="text" placeholder="Write grade name" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="categories_ID">Category number</label>
  <div class="col-md-4">
  <input id="categories_ID" name="categories_ID" type="text" placeholder="Write category number" class="form-control input-md" required="">

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


