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
			<div id="itemImagen">

				<div id="extraImage"></div>
			</div>
			<div class="item">
				<span class="fecha"><c:out value="${model.item.fecha}" /></span>
				<div class="title">
					<c:out value="${model.item.name}" />
				</div>
				<div class="tienda">
					<c:out value="${model.item.shops.nombre}" />
				</div>
				<div class="precio">
					<c:out value="${model.item.price}" />
				</div>
				<div class="user">
					<c:out value="${model.item.users.nick}" />
				</div>
			</div>
			<div class="comentarios">
				<c:forEach items="${model.commentList}" var="comment">
					<div style="margin-left:<c:out value="${comment.marginReply * 20}" />px">
						<c:out value="${comment.id}" /> - <c:out value="${comment.comentario}" /> (<c:out value="${comment.users.nick}" />) - <c:out value="${comment.fecha}" /><br />
					</div>
				</c:forEach>
			</div>
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