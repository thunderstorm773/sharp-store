<html>
<jsp:include page="${pageContext.request.contextPath}/fragments/head.jsp"/>
<body>
<jsp:include page="${pageContext.request.contextPath}/fragments/header.jsp"/>

<jsp:include page="${pageContext.request.contextPath}/${view}"/>

<jsp:include page="${pageContext.request.contextPath}/fragments/footer.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/fragments/script-bundles.jsp"/>
</body>
</html>
