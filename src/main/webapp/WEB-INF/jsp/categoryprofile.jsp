<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<%@ include file="../layout/itemsbuttoninclude.jsp"%>

<%@ include file="../layout/deletetriger.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Image</th>
			<th>Price<span class="glyphicon glyphicon-usd"></span></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${categorywithitems}" var="categorywithitems">
			<tr>
				<td><a
					href="<spring:url value="/${categorywithitems.id}.html" />">${categorywithitems.name}</a></td>
				<td></td>
				<td>${categorywithitems.price}</td>
				<security:authorize access="isAuthenticated()">
					<td>
						<p>
							<a
								href='<spring:url value="/addtocart/${categorywithitems.id}.html"></spring:url>'
								class="btn btn-xs btn-warning btn-left">Add to <span
								class="glyphicon glyphicon-shopping-cart"></span>
							</a>
						</p> <security:authorize access="hasRole('ROLE_ADMIN')">
							<td><p>
									<a
										href='<spring:url value="/item/remove/${categorywithitems.id}.html"></spring:url>'
										class="btn btn-xs btn-danger triggerRemove btn-right">Delete
										Item <span class="glyphicon glyphicon-trash"></span>
									</a>
								</p></td>
						</security:authorize>

					</td>
				</security:authorize>
			</tr>
		</c:forEach>
	</tbody>
</table>
