<%@ include file="/WEB-INF/views/header.jsp"%>

<div id="mainContent">
	Nickname: <c:out value="${userFlow.nickname}" default="-"></c:out>
	Password: <c:out value="${userFlow.password}" default="-"></c:out>
	
	<form:form id="order" action="${flowExecutionUrl}" method="post">
		Name: <input type="text" id="name" name="name" /><br />
		Surname: <input type="text" id="surname" name="surname" /><br />
		Email: <input type="text" id="email" name="email" /><br />
		Avatar: <input type="file" id="avatar" name="avatar" /><br />
		<input type="submit" name="_eventId_next" value="Seguir" />
	</form:form>
</div>