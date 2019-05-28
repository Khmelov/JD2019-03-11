<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<form class="form-horizontal" action="do?command=CreateCategory" method="post">
<fieldset>

<!-- Form Name -->
<legend>Create category</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="category">Category name</label>
  <div class="col-md-4">
  <input id="category" name="category" type="text" placeholder="Write category name" class="form-control input-md" required="">

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


