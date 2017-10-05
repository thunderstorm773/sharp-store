<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <main>
        <form method="post" class="form-horizontal">
            <c:set var="order" value="${order}"/>
            <div class="form-group">
                <label for="personName" class="control-label col-sm-3">Person Name:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="personName"
                          value="${order.personName}" disabled/>
                </div>
            </div>
            <div class="form-group">
                <label for="phoneNumber" class="control-label col-sm-3">Phone Number:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="phoneNumber"
                           value="${order.phoneNumber}" disabled/>
                </div>
            </div>
            <div class="form-group">
                <label for="address" class="control-label col-sm-3">Address:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="address"
                           value="${order.address}" disabled/>
                </div>
            </div>
            <div class="form-group">
                <label for="deliveryType" class="control-label col-sm-3">Delivery Type:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="deliveryType"
                           value="${order.deliveryType}" disabled/>
                </div>
            </div>
            <div class="form-group">
                <label for="orderStatus" class="control-label col-sm-3">Order Status:</label>
                <div class="col-sm-4">
                    <select class="form-control" id="orderStatus" name="orderStatus">
                        <c:forEach var="orderStatus" items="${ordersStatus}">
                            <c:choose>
                                <c:when test="${order.status == orderStatus}">
                                    <option value="${orderStatus}" selected>${orderStatus.statusName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${orderStatus}">${orderStatus.statusName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="knifeName" class="control-label col-sm-3">Knife Name:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="knifeName"
                           value="${order.knifeName}" disabled/>
                </div>
            </div>
            <div class="form-group">
                <label for="customerUsername" class="control-label col-sm-3">Customer Username:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="customerUsername"
                           value="${order.customerUsername}" disabled/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-4 col-sm-offset-3">
                    <input type="submit" class="btn btn-warning" value="Edit"/>
                </div>
            </div>
        </form>
    </main>
</div>
