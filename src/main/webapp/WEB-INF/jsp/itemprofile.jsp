<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<%@ include file="../layout/itemsbuttoninclude.jsp"%>

<%@ include file="../layout/deletetriger.jsp"%>

<h1>${item.name}</h1>

<img src="${item.image}">

<h4>${item.price}</h4>
<security:authorize access="isAuthenticated()">
	<p>
		<a href='<spring:url value="/addtocart/${item.id}.html"></spring:url>'
			class="btn btn-lg btn-warning btn-left">Add to <span
			class="glyphicon glyphicon-shopping-cart"></span>
		</a>
		<security:authorize access="hasRole('ROLE_ADMIN')">
			<a
				href='<spring:url value="/item/remove/${item.id}.html"></spring:url>'
				class="btn btn-xs btn-danger triggerRemove btn-right">Delete
				Item <span class="glyphicon glyphicon-trash"></span>
			</a>
		</security:authorize>
	</p>
</security:authorize>