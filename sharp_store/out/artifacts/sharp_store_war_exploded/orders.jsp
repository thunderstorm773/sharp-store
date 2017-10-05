<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <main>
        <table class="table table-responsive table-bordered table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Delivery Type</th>
                <th>Order Status</th>
                <th>Details</th>
            </tr>
            </thead>
            <c:set var="orders" value="${orders}"/>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <c:choose>
                    <c:when test="${order.status == 'DELIVERED'}">
                        <c:set var="rowColor" value="success"/>
                    </c:when>
                    <c:when test="${order.status == 'SHIPPED'}">
                        <c:set var="rowColor" value="warning"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="rowColor" value="active"/>
                    </c:otherwise>
                </c:choose>
                <tr class="${rowColor}">
                    <td>${order.id}</td>
                    <td>${order.deliveryType}</td>
                    <td>${order.status.statusName}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/home/orders/details/${order.id}">Details</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</div>
