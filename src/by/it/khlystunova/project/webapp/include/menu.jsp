<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
     <br>
    <h3>Rent of coffee machines</h3>
    <br>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="do?command=index">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <c:if test="${user==null}">

                <li class="nav-item">
                    <a class="nav-link" href="do?command=Login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="do?command=SignUp">SignUp</a>
                </li>
            </c:if>
  <c:if test="${user!= null}">

                            <li class="nav-item">
                                <a class="nav-link" href="do?command=CreateRequest">CreateRequest</a>
                            </li>

                            <li class="nav-item">
                                <a class="nav-link" align="right"  href="do?command=Profile">Profile</a>
                            </li>


                        </c:if>
              <c:if test="${user.roles_ID==1}">

                <li class="nav-item">
                    <a class="nav-link" href="do?command=addcoffemachine">addcoffemachine</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="do?command=ResetDB">ResetDB</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="do?command=aditusers">EditUsers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="do?command=editcoffemachines">EditCoffemachines</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="do?command=showallrequests">ShowAllRequests</a>
                </li>
            </c:if>

        </ul>
    </div>
</nav>
