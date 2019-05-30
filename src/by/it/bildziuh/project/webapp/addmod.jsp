<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>

    <form class="form-horizontal"action="do?command=AddMod" method="post">
    <fieldset>

    <!-- Form Name -->
    <legend>Add mod</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="game">Game</label>
      <div class="col-md-4">
      <input id="game" name="game" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="group">Group</label>
      <div class="col-md-4">
      <input id="group" name="group" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="name">Name</label>
      <div class="col-md-4">
      <input id="name" name="name" type="text" placeholder="" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Textarea -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="description">Description</label>
      <div class="col-md-4">
        <textarea class="form-control" id="description" name="description"></textarea>
      </div>
    </div>

    <!-- File Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="filebutton">Upload file</label>
      <div class="col-md-4">
        <input id="filebutton" name="filebutton" class="input-file" type="file">
      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="size">Size</label>
      <div class="col-md-4">
      <input id="size" name="size" type="text" placeholder="Megabytes" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="link">Link</label>
      <div class="col-md-4">
      <input id="link" name="link" type="text" placeholder="http://" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="singlebutton"></label>
      <div class="col-md-4">
        <button id="singlebutton" name="singlebutton" class="btn btn-success">Create mod page</button>
      </div>
    </div>

    </fieldset>
    </form>
</div>
</body>
</html>



