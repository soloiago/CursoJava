<%@ include file="/WEB-INF/views/header.jsp"%>

<div id="mainContent">
	Nickname:
	<c:out value="${userFlow.nickname}" default="-"></c:out>
	Password:
	<c:out value="${userFlow.password}" default="-"></c:out>
	Name
	<c:out value="${userFlow.name}" default="-"></c:out>
	Surname:
	<c:out value="${userFlow.surname}" default="-"></c:out>
	Email:
	<c:out value="${userFlow.email}" default="-"></c:out>
	<h2>Fin Flujo!</h2>
</div>