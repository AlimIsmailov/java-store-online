<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<%@ include file="../layout/deletetriger.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>user name</th>
			<th>enabled</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><a href="<spring:url value="/users/${user.id}.html" />">
						${user.name}</a></td>
				<td>${user.enable}</td>
				<td><p>
						<a
							href='<spring:url value="/user/remove/${user.id}.html"></spring:url>'
							class="btn btn-xs btn-danger triggerRemove btn-right">Delete
							User <span class="glyphicon glyphicon-trash"></span>
						</a>
					</p></td>
			</tr>
		</c:forEach>
	</tbody>
</table>