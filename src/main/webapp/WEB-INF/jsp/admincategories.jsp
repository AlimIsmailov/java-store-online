<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<%@ include file="../layout/itemsbuttoninclude.jsp"%>

<%@ include file="../layout/deletetriger.jsp"%>

<br />
<security:authorize access="hasRole('ROLE_ADMIN')">
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#myModal">Create new Category</button>
</security:authorize>

<form:form commandName="category"
	cssClass="form-horizontal categoryForm">
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New category</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name:</label>
						<div class="col-sm-10">
							<form:input path="name" cssClass="form-control" />
							<form:errors path="name" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="Submit" value="Save" class="btn btn-primary" />
				</div>
			</div>
		</div>
	</div>
</form:form>

<script type="text/javascript">
	$(document).ready(
			function() {
				$(".categoryForm").validate(
						{
							rules : {
								name : {
									required : true,
									minlength : 3
								}
							},
							highlight : function(element) {
								$(element).closest('.form-group').removeClass(
										'has-success').addClass('has-error');
							},
							unhighlight : function(element) {
								$(element).closest('.form-group').removeClass(
										'has-error').addClass('has-success');
							}
						});
			});
</script>

<br />

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Category</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${categories}" var="categories">
			<tr>
				<td><a
					href='<spring:url value="/category/${categories.id}.html" />'>${categories.name}</a></td>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<td><p>
							<a
								href='<spring:url value="/category/remove/${categories.id}.html"></spring:url>'
								class="btn btn-xs btn-danger triggerRemove btn-right">Delete
								Category <span class="glyphicon glyphicon-trash"></span>
							</a>
						</p></td>
				</security:authorize>
			</tr>
		</c:forEach>
	</tbody>
</table>
