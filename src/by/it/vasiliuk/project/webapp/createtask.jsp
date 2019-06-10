<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=CREATETASK" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Create task</legend>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="task_type">Task type</label>
                <div class="col-md-4">
                    <select id="task_type" name="task_type" class="form-control">
                        <option value="passenger">classic(single)</option>
                        <option value="truck">repeating</option>
                    </select>
                    <span class="help-block"> Select task type </span>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="stask_type">Subtask type</label>
                <div class="col-md-4">
                    <select id="stask_type" name="stask_type" class="form-control">
                        <option value="petrol">Sooner</option>
                        <option value="diesel">Later</option>
                        <option value="electricity">Nowtime</option>
                    </select>
                    <span class="help-block"> Select subtask parameter </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="tag">Tags</label>
                <div class="col-md-4">
                    <input id="tag" name="tag" type="text" value="tag" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> Enter tag </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="grp_project">Group project</label>
                <div class="col-md-4">
                    <input id="grp_project" name="grp_project" type="text" value="group" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> Enter group project </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="sallary">Sallary</label>
                <div class="col-md-4">
                    <input id="sallary" name="sallary" type="text" value="34500" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> Enter sallary </span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="date_year">Task year</label>
                <div class="col-md-4">
                    <input id="date_year" name="date_year" type="text" value="2012" placeholder="" class="form-control input-md" required="">
                    <span class="help-block"> Enter task year</span>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signup"></label>
                <div class="col-md-4">
                    <button id="signup" name="signup" class="btn btn-success">Create</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
