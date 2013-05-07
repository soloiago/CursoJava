<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="itemContent">
	<div id="itemImagen">

		<div id="extraImage"></div>
	</div>
	<div class="item">
		<span class="fecha">Fecha de subida: <c:out
				value="${model.item.fecha}" /></span>
		<div class="title">
			Nombre del artículo:
			<c:out value="${model.item.name}" />
		</div>
		<div class="tienda">
			Nombre de la tienda:
			<c:out value="${model.item.shops.nombre}" />
		</div>
		<div class="precio">
			Precio:
			<c:if test="${model.logged}">
				<c:out value="${item.price}" />	€
			</c:if>
			<c:if test="${!model.logged}">
				Regístrese
			</c:if>
		</div>
		<div class="user">
			Usuario:
			<c:out value="${model.item.users.nickname}" />
		</div>
	</div>

	<c:forEach items="${model.item.imageses}" var="imagen">
		<div class="imagenItem">
			<img src="../images/<c:out value="${imagen.path}" />">
		</div>
	</c:forEach>

	<div class="comentarios">
		<c:forEach items="${model.commentList}" var="comment">
			<div
				style="margin-left:<c:out value="${comment.marginReply * 20}" />px">
				<c:out value="${comment.id}" />
				-
				<c:out value="${comment.comentario}" />
				(
				<c:out value="${comment.users.nickname}" />
				) -
				<c:out value="${comment.fecha}" />
				<br />
			</div>
		</c:forEach>
	</div>
</div>