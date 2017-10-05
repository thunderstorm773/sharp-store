<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <main>
        <table class="table table-responsive table-bordered table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Sender</th>
                <th>Subject</th>
                <th>Content</th>
                <th>Reply</th>
            </tr>
            </thead>
            <c:set var="messages" value="${messages}"/>
            <tbody>
            <c:forEach var="message" items="${messages}">
                <tr>
                    <td>${message.id}</td>
                    <td>${message.sender}</td>
                    <td>${message.subject}</td>
                    <td>${message.content}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/home/messages/reply/${message.id}">Reply</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</div>