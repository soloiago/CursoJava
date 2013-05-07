<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="mainContent">

	<h1><c:out value="${model.shop.nombre}" /></h1>
	<h3><c:out value="${model.shop.direccion}" /></h3>
	<c:forEach items="${model.shop.itemses}" var="item">
		<li>
			<div class="ficha">
				<div class="imagenItem">
					<c:if test="${item.imageses.size()>0}">
						<img src="images/<c:out value="${item.imageses.get(0).path}" />">
					</c:if>
				</div>
				<div class="item">
					<span class="fecha"><c:out value="${item.fecha}" /></span>
					<div class="title">
						<a href="../item/<c:out value="${item.id}" />"><c:out
								value="${item.name}" /></a>
					</div>
					<div class="tienda">
						<p>Tienda: <a href="shop/<c:out value="${item.shops.id}" />"><c:out value="${item.shops.nombre}" /></a></p>
					</div>
					<div class="precio">
						<c:out value="${item.price}" />
						€
					</div>
					<div class="user">
						<p>
							Usuario:
							<c:out value="${item.users.nickname}" />
						</p>
					</div>
					Número de comentarios:
					<c:out value="${item.commentses.size()}" />
				</div>
			</div>
		</li>
	</c:forEach>
</div>