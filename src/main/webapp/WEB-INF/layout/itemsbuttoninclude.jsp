<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<ul class="nav nav-tabs">
	<li role="presentation" class="active"><a
		href='<spring:url value="/admincategories.html" />'>All Categories</a></li>
	<li role="presentation" class="active"><a
		href='<spring:url value="/adminitems.html" />'>All Items</a></li>
	<c:forEach items="${categories}" var="categories">
		<li role="presentation" class="active"><a
			href='<spring:url value="/category/${categories.id}.html" />'>${categories.name}</a></li>
	</c:forEach>
</ul>