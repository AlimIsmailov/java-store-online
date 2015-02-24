<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

	<tilesx:useAttribute name="current" />

	<div class="container">

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Heroes Store</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="${current == 'index' ? 'active' : ''}"><a
							href='<spring:url value="/index.html"></spring:url>'>Home</a></li>
						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'users' ? 'active' : ''}"><a
								href="<spring:url value="/users.html"/>">Users</a></li>
						</security:authorize>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false">Shop
								<span class="caret"></span>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li class="${current == 'admincategories' ? 'active' : ''}"><a
									href="<spring:url value="/admincategories.html"/>">All
										Categories</a></li>
								<li class="${current == 'adminitems' ? 'active' : ''}"><a
									href="<spring:url value="/adminitems.html"/>">All Items</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">GO</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<security:authorize access="isAuthenticated()">
							<li class="${current == 'cart' ? 'active' : ''}"><a
								href='<spring:url value="/cart.html"></spring:url>'><span
									class="glyphicon glyphicon-shopping-cart"></span></a></li>
						</security:authorize>
						<li class="${current == 'user-register' ? 'active' : ''}"><a
							href='<spring:url value="/register.html"></spring:url>'>Sign
								Up</a></li>
						<security:authorize access="! isAuthenticated()">
							<li class="${current == 'login' ? 'active' : ''}"><a
								href='<spring:url value="/login.html"></spring:url>'>Sign In</a></li>
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							<li class="${current == 'account' ? 'active' : ''}"><a
								href="<spring:url value="/account.html"/>">Profile</a></li>
							<li><a href='<spring:url value="/logout" />'>Logout</a></li>
						</security:authorize>
					</ul>
				</div>
			</div>
		</nav>

		<tiles:insertAttribute name="body" />

		<br> <br>

		<div align="center">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>
</html>

