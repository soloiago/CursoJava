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
		<c:out value="${model.now}" />
	</p>
	<h3>Products</h3>
	<c:forEach items="${model.stockList}" var="stock">
		<c:out value="${stock.STOCK_ID}" />
		<i><c:out value="${stock.STOCK_NAME}" /></i> - <c:out
			value="${stock.STOCK_CODE}" />
		<br>
		<br>
	</c:forEach>
	<br>
	<c:out value="${model.total}" />
	<br>
	<br>
	<br>
	<a href="<c:url value="codeincrease.htm"/>">Increase Code</a>
	<br>
</body>
</html>