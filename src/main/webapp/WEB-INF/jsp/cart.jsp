<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<c:if test="${param.success eq true}">
	<div class="alert alert-info">Your order is accepted and in
		process.</div>
</c:if>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Price<span class="glyphicon glyphicon-usd"></span></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cart}" var="cart">
			<tr>
				<td><input type="checkbox" name="choosenitem"
					value="${cart.id}" /></td>
				<td><a href="<spring:url value="/${cart.id}.html" />">${cart.name}</a></td>
				<td>${cart.price}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<p>
	<a href='<spring:url value="/removefromcart.html"></spring:url>'
		class="btn btn-lg btn-danger triggerRemove btn-right">Clear Cart </a>
	<a href='<spring:url value="/acceptpurchase.html"></spring:url>'
		class="btn btn-lg btn-success btn-right">Accept Purchase </a>
</p>