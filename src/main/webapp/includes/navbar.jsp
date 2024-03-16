<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 12/03/2024
  Time: 10:13 am
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <div class="header__logo">
            <a href="index.jsp"><img src="img/logo.png" alt=""></a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                <%
                    if (auth != null) {
                %>
                <li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
                <li class="nav-item"><a class="nav-link" href="log-out">Logout</a></li>
                <li class="nav-item"><a class="nav-link" href="cart.jsp">Cart <span class="badge badge-danger">${cart_list.size()}</span> </a></li>
                <%
                } else {
                %>


<%--                <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>--%>
<%--                <li class="nav-item"><a class="nav-link" href="signup.jsp">Sign UP</a></li>--%>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>
