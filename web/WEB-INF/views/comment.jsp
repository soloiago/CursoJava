<%@ include file="/WEB-INF/views/header.jsp"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="heading" />
	</h1>
	<p>
		<fmt:message key="greeting" />
	</p>
	<h3>Comments</h3>
	<c:forEach items="${model.commentList}" var="comment">
		<c:out value="${comment.comentario}" />
		<br>
	</c:forEach>

	<br>
</body>
</html>