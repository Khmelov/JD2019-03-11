<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
<p><form class="form-horizontal">
   <fieldset>

   <!-- Form Name -->
   <legend>Search</legend>

   <!-- Text input-->
   <div class="form-group">
     <label class="col-md-4 control-label" for="name">Material name</label>
     <div class="col-md-4">
     <input id="name" name="name" type="text" placeholder="Write material name" class="form-control input-md" required="">

     </div>
   </div>

   <!-- Button -->
   <div class="form-group">
     <label class="col-md-4 control-label" for="button"></label>
     <div class="col-md-4">
       <button id="button" name="button" class="btn btn-primary">Search</button>
     </div>
   </div>

   </fieldset>
   </form></p>
</div>
</body>
</html>
