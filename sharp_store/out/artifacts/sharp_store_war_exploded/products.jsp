<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <main>
        <div class="row">
            <div class="col-sm-4">
                <form class="form-inline">
                    <div class="input-group">
                        <input type="text" class="form-control" name="search" placeholder="Search..."/>
                        <div class="input-group-btn">
                            <input type="submit" class="btn btn-default" value="Find"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <c:set var="knifes" value="${knives}"/>
        <c:set var="loginModel" value="${sessionScope.loginModel}"/>
        <div class="row">
            <c:forEach var="knife" items="${knifes}">
                <div class="col-sm-4">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <img src="${knife.imageURL}"
                                 class="img-responsive" alt="Knife" width="300px" height="150px"/>
                            <h3>${knife.name}</h3>
                            <p class="panel-info">&#36;${knife.price}</p>
                            <c:if test="${loginModel != null}">
                                <a href="${pageContext.request.contextPath}/home/products/buy/${knife.id}"
                                   class="btn btn-primary" role="button">Buy Now</a>
                            </c:if>
                            <c:if test="${loginModel != null && loginModel.role == \"ADMIN\"}">
                                <a href="${pageContext.request.contextPath}/home/products/edit/${knife.id}"
                                   class="btn btn-warning" role="button">Edit</a>
                                <a href="${pageContext.request.contextPath}/home/products/delete/${knife.id}"
                                   class="btn btn-danger" role="button">Delete</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </main>
</div>
