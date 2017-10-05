<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="container">
        <c:set var="navColorCookie" value="${cookie.navColor}"/>
        <c:choose>
            <c:when test="${navColorCookie != null && navColorCookie.value.equals(\"light\")}">
                <c:set var="navColorClass" value="navbar-default"/>
            </c:when>
            <c:otherwise>
                <c:set var="navColorClass" value="navbar-inverse"/>
            </c:otherwise>
        </c:choose>
        <nav class="navbar ${navColorClass} navbar-fixed-top">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/home/index">Sharp Store</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class=""><a href="${pageContext.request.contextPath}/home/products">Products</a></li>
                    <li><a href="${pageContext.request.contextPath}/home/about">About Us</a></li>
                    <li><a href="${pageContext.request.contextPath}/home/contacts">Contacts</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">Theme <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/home/index/dark">Dark</a></li>
                            <li><a href="${pageContext.request.contextPath}/home/index/light">Light</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:set var="loginModel" value="${sessionScope.loginModel}"/>
                    <c:choose>
                        <c:when test="${loginModel != null}">
                            <c:set var="username" value="${loginModel.username}"/>
                            <c:set var="role" value="${loginModel.role}"/>
                            <c:if test="${role == 'ADMIN'}">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                       aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="${pageContext.request.contextPath}/home/products/add">Add Knife</a></li>
                                        <li><a href="${pageContext.request.contextPath}/home/messages">All Messages</a></li>
                                        <li><a href="${pageContext.request.contextPath}/home/orders">All Orders</a></li>
                                    </ul>
                                </li>
                            </c:if>
                            <li>
                                <a href="${pageContext.request.contextPath}/home/logout">Log Out(${username})</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <a href="${pageContext.request.contextPath}/home/register">Register</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/home/login">Login</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </nav>
    </div>
</header>
