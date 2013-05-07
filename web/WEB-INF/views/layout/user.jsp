<%@ include file="/WEB-INF/views/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script>
(function($,W,D)
{
    var JQUERY4U = {};

    JQUERY4U.UTIL =
    {
        setupFormValidation: function()
        {
            //form validation rules
            $("#order").validate({
                rules: {
                    nickname: "required",
                    password: {
                        required: true,
                        minlength: 5
                    },
                },
                messages: {
                    nickname: "Please enter your nickname",
                    password: {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long"
                    },
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });
        }
    }

    //when the dom has loaded setup form validation rules
    $(D).ready(function($) {
        JQUERY4U.UTIL.setupFormValidation();
    });

})(jQuery, window, document);
</script>

<div id="mainContent">
	<spring:hasBindErrors name="userFlow">
		<h2>Errors</h2>
		<div class="formerror">
			<ul>
				<c:forEach var="error" items="${errors.allErrors}">
					<li>${error.defaultMessage}</li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>

	<form:form id="order" action="${flowExecutionUrl}" method="post">
		<label for="nickname">Nick: </label>
		<input type="text" id="nickname" name="nickname" /><br />
		<label for="password">Contraseña: </label>
		<input type="password" name="password" /><br />
		<input type="submit" name="_eventId_next" value="Seguir" />
	</form:form>
</div>