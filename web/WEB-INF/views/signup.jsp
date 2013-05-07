<%@ include file="/WEB-INF/views/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<title>Template</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
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


			<form:form modelAttribute="user" method="post" enctype="multipart/form-data">
				<fieldset>
					<legend>Upload Fields</legend>

					<p>
						<form:label for="nickname" path="nickname">nickname</form:label>
						<br />
						<form:input path="nickname" />
					</p>

					<p>
						<form:label for="fileData" path="fileData">File</form:label>
						<br />
						<form:input path="fileData" type="file" />
					</p>

					<p>
						<input type="submit" />
					</p>

				</fieldset>
			</form:form>
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