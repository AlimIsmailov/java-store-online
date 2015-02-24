<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<%@ include file="../layout/itemsbuttoninclude.jsp"%>

<%@ include file="../layout/deletetriger.jsp"%>
<br />
<security:authorize access="hasRole('ROLE_ADMIN')">
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#myModal">Create new Item</button>
</security:authorize>

<form:form commandName="item" cssClass="form-horizontal itemForm">
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
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Attache
							Photo:</label>
						<div class="col-sm-10">
							<form:input type="file" path="image" id="image" />
						</div>
					</div>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Price <span
							class="glyphicon glyphicon-usd"></span>:
						</label>
						<div class="col-sm-10">
							<form:input path="price" cssClass="form-control" id="file" />
							<form:errors path="price" />
						</div>
					</div>
				</div>
				<h3>Choose one category!!!</h3>
				<c:forEach items="${categories}" var="categories">
					<p>
						<input type="radio" name="choosencategory"
							value="${categories.id}" />${categories.name}
					</p>
				</c:forEach>
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
				$(".itemForm").validate(
						{
							rules : {
								name : {
									required : true,
									minlength : 3
								},
								price : {
									required : true,
									number : true
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
			<th>Name</th>
			<th>Image</th>
			<th>Category</th>
			<th>Price<span class="glyphicon glyphicon-usd"></span></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${items}" var="items">
			<tr>
				<td><a href="<spring:url value="/${items.id}.html" />">${items.name}</a></td>
				<td>${items.image}</td>
				<td>${items.category.name}</td>
				<td>${items.price}</td>
				<security:authorize access="isAuthenticated()">
					<td>
						<p>
							<a
								href='<spring:url value="/addtocart/${items.id}.html"></spring:url>'
								class="btn btn-xs btn-warning btn-left">Add to <span
								class="glyphicon glyphicon-shopping-cart"></span>
							</a>
						</p>
					</td>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<td>
							<p>
								<a
									href='<spring:url value="/item/remove/${items.id}.html"></spring:url>'
									class="btn btn-xs btn-danger triggerRemove btn-right">Delete
									Item <span class="glyphicon glyphicon-trash"></span>
								</a>
							</p>
						</td>
					</security:authorize>
				</security:authorize>
			</tr>
		</c:forEach>
	</tbody>
</table>