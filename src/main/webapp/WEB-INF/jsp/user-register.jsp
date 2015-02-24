<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="user"
	cssClass="form-horizontal registrationForm">

	<c:if test="${param.success eq true}">
		<div class="alert alert-info">YOUR registration successfull!</div>
	</c:if>

	<div class="form-group">
		<label for="login" class="col-sm-2 control-label">Login:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" placeholder="Login" />
			<form:errors path="name" />
		</div>
	</div>

	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control"
				placeholder="example@mail.com" />
			<form:errors path="email" />
		</div>
	</div>

	<div class="form-group">
		<label for="phoneNumber" class="col-sm-2 control-label">Phone
			Number:</label>
		<div class="col-sm-10">
			<form:input path="phoneNumber" cssClass="form-control"
				placeholder="+38(050)007-07-07" />
		</div>
	</div>

	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<form:password path="password" cssClass="form-control"
				placeholder="Password" />
			<form:errors path="password" />
		</div>
	</div>

	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password
			again:</label>
		<div class="col-sm-10">
			<input type="password" name="password_again" id="password_again"
				class="form-control" placeholder="Repeat password" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-10">
			<input type="submit" value="Registrate"
				class="btn btn-lg btn-primary btn-success">
		</div>
	</div>

</form:form>

<script type="text/javascript">
	$(document).ready(function() {
		$(".registrationForm").validate({
			rules : {
				name : {
					required : true,
					minlength : 3
				},
				email : {
					required : true,
					email : true
				},
				phoneNumber : {
					required : true,
					minlength : 10,
					maxlength : 17
				},
				password : {
					required : true,
					minlength : 5
				},
				password_again : {
					required : true,
					minlength : 5,
					equalTo : "#password"
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			}
		});
	});
</script>