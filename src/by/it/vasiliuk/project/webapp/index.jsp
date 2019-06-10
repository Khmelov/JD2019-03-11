<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="include/menu.jsp" %>

    <h2>All tasks: </h2>
    <div class="row">
        <div class="col-md-2">Task type</div>
        <div class="col-md-1">Subtask type</div>
        <div class="col-md-2">Tags</div>
        <div class="col-md-2">Group project</div>
        <div class="col-md-1">Sallary</div>
        <div class="col-md-1">Task year</div>
    </div>

    <c:forEach items="${tasks}" var="task">
        <div class="row">
            <div class="col-md-2">${task.task_type}</div>
            <div class="col-md-1">${task.stask_type}</div>
            <div class="col-md-2">${task.tag}</div>
            <div class="col-md-2">${task.grp_project}</div>
            <div class="col-md-1">${task.sallary}</div>
            <div class="col-md-1">${task.date_year}</div>
        </div>
    </c:forEach>

    <hr>
    <my:paginator count="$(taskSize)" step="15" urlprefix="?start="/>
    <hr>

</div>
</body>
</html>