<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="mainContent">

<form:form method="post" commandName="uploadForm" enctype="multipart/form-data">
	<label for="name">Nombre: </label><form:input path="name"/><br />
	<label for="shopList">Tienda: </label><form:select path="shopList" items="${uploadForm.shopList}" ></form:select><br />
	<label for="precio">Precio: </label><form:input path="precio"/><br />
	<label for="imageFile">Imagen: </label><form:input path="imageFile" type="file"/><br />
	<label for="fecha">Fecha: </label><br />
	<input type="submit" />
</form:form>

</div>