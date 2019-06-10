<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>
    <form class="form-horizontal" action="do?command=Profile" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>My data</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" value="${user.login}" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block">[a-z],[A-Z],[0-9], not less than 4 symbols (ex: Dmitriy)</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" value="${user.email}" placeholder="login@mail.com"
                           class="form-control input-md" required="">
                    <span class="help-block"> enter e-mail </span>
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" value="${user.password}" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block"> not less than 4 symbols </span>
                </div>
            </div>

            <!-- Phone input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="phone">Phone</label>
                <div class="col-md-4">
                    <input id="phone" name="phone" type="text" value="${user.phone}" placeholder=""
                           class="form-control input-md" required="">
                    <span class="help-block"> enter phone number </span>
                </div>
            </div>


            <!-- Button (Double) -->
            <div class="form-group">
                <div class="col-md-8">
                    <button id="update" name="update" class="btn btn-success">Change</button>
                    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
                </div>
            </div>

        </fieldset>
    </form>


    <h4>My tasks</h4>

    <div class="row">
        <div class="col-md-2">Task type</div>
        <div class="col-md-2">Subtask type</div>
        <div class="col-md-1">Tags</div>
        <div class="col-md-1">Group project</div>
        <div class="col-md-2">Sallary</div>
        <div class="col-md-1">Task year</div>
    </div>

    <c:forEach items="${tasks}" var="task">
        <form class="form-horizontal-${task.id}" action="do?command=Profile" method="post">
            <div class="row">
                <input id="id" name="id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${task.id}">

                <div class="col-md-2">
                    <input id="task_type" name="task_type" type="text" placeholder="" class="form-control input-md"
                           required="" value="${task.task_type}">
                </div>

                <div class="col-md-2">
                    <input id="stask_type" name="stask_type" type="text" placeholder="" class="form-control input-md"
                           required="" value="${task.stask_type}">
                </div>

                <div class="col-md-1">
                    <input id="tag" name="tag" type="text" placeholder="" class="form-control input-md"
                           required="" value="${task.tag}">
                </div>

                <div class="col-md-1">
                    <input id="grp_project" name="grp_project" type="text" placeholder="" class="form-control input-md"
                           required="" value="${task.grp_project}">
                </div>

                <div class="col-md-2">
                    <input id="sallary" name="sallary" type="text" placeholder="" class="form-control input-md"
                           required="" value="${task.sallary}">
                </div>

                <div class="col-md-1">
                    <input id="date_year" name="date_year" type="text" placeholder=""
                           class="form-control input-md"
                           required="" value="${task.date_year}">
                </div>

                <input id="users_id" name="users_id" type="hidden" placeholder="" class="form-control input-md"
                       required="" value="${task.users_id}">

                <!-- Button -->
                <div class="col-md-3">
                    <button id="edit" name="edit" class="btn btn-warning">Change</button>
                    <button id="deletetask" name="deletetask" class="btn btn-danger">Delete</button>
                </div>
            </div>
        </form>
    </c:forEach>

    <br><br><br>
    <hr>
</div>
</body>
</html>
