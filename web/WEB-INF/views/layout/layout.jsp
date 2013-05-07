<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ include file="/WEB-INF/views/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styleLogin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/styleLogout.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
<script src="${pageContext.request.contextPath}/js/login.js"></script>
<script src="${pageContext.request.contextPath}/js/logout.js"></script>
<script lang="javascript" type="text/javascript">
	window.onload = function() {
		var lis = document.getElementById("mainContent").getElementsByTagName(
				'li');

		for ( var i = 0; i < lis.length; i++) {
			lis[i].onmouseover = function() {
				this.style.backgroundColor = "#DDD";
			};
			lis[i].onmouseout = function() {
				this.style.backgroundColor = "white";
			};
		}
	};
</script>
</head>
<body>
	<header>
		<div id="navigation">

			<div id="title">
				<p>Encuentra lo que te gusta</p>
				<p>Otro</p>
			</div>

			<c:if test="${model.logged == false}">
				<!-- Login Starts Here -->
				<div id="loginContainer">
					<a href="#" id="loginButton"><span>Login</span><em></em></a>
					<div style="clear: both"></div>
					<div id="loginBox">
						<form id="loginForm"
							action="${pageContext.request.contextPath}/login" method="post">
							<fieldset id="body">
								<fieldset>
									<label for="nickname">Nickname</label> <input type="text"
										name="nickname"" id=""nickname" />
								</fieldset>
								<fieldset>
									<label for="password">Password</label> <input type="password"
										name="password" id="password" />
								</fieldset>
								<input type="submit" id="login" value="Sign in" /> <label
									for="checkbox"><input type="checkbox" id="rememberMe" name="rememberMe" />Remember
									me</label>
							</fieldset>

							<span><a href="#">Forgot your password?</a></span> <span><a
								href="${pageContext.request.contextPath}/signup.do">Are you
									a new user? Sign Up!</a></span>
						</form>
					</div>
				</div>
				<!-- Login Ends Here -->
			</c:if>

			<c:if test="${model.logged == true}">
				<!-- Logout Starts Here -->
				<div id="logoutContainer">
					<a href="#" id="logoutButton"><span>Logout</span><em></em></a>
					<div style="clear: both"></div>
					<div id="logoutBox">
						<form id="logoutForm"
							action="${pageContext.request.contextPath}/logout">
							<fieldset id="body">
								<input type="submit" id="logout" value="Logout" />
							</fieldset>
						</form>
					</div>
				</div>
				<!-- Logout Ends Here -->
			</c:if>

			<div id="userSearch">
				<form method="POST" action="search">
					<input type="text" /> <input type="button" value="buscar" />
				</form>
			</div>

			<ul>
				<li><a class="option" href="vista1.html">Vista 1</a></li>
				<li><a class="option" href="vista2.html">Vista 2</a></li>
				<li><a class="option" href="uploadImage">Subir Imagen</a></li>
			</ul>

		</div>
	</header>

	<div id="content">

		<div id="leftPanel">Izquierda</div>

		<tiles:insertAttribute name="body" />

		<tiles:insertAttribute name="rightPanel" />

	</div>

</body>
</html>