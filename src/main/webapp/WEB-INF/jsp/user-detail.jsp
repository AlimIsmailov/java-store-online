<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h1>${user.name}</h1>
<br />

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>email</th>
			<th>phone number</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${user.email}</td>
			<td>${user.phoneNumber}</td>
		</tr>
	</tbody>
</table>