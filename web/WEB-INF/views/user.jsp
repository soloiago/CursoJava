<%@ include file="/WEB-INF/views/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Template</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
	<header>
		<div id="navigation">

			<div id="title">
				<p>Encuentra lo que te gusta</p>
				<p>Otro</p>
			</div>

			<div id="userSearch">
				Hola Iago
				<form method="POST" action="search">
					<input type="text" /> <input type="button" value="buscar" />
				</form>
			</div>

			<ul>
				<li><a href="vista1.html">Vista 1</a></li>
				<li><a href="vista2.html">Vista 2</a></li>
				<li><a href="uploadImage.html">Subir Imagen</a></li>
			</ul>

		</div>
	</header>

	<div id="content">

		<div id="leftPanel">Izquierda</div>

		<div id="itemContent">
			<c:out value="${model.user.nick}" /> - <c:out value="${model.user.profile.name}" />
		</div>

		<div id="rightPanel">
			Derecha
			<ul>
				<li>¿Qué me voy a comprar?</li>
				<li>Ultimas incorporaciones</li>
				<ul>
					<li>¿Qué me voy a comprar?</li>
					<li>Ultimas incorporaciones</li>
					<li>Ultimas incorporaciones</li>
				</ul>
			</ul>
			<ul>
				<li>Mis favoritos</li>
				<li>Gente que sigo</li>
			</ul>
		</div>

	</div>



</body>
</html>