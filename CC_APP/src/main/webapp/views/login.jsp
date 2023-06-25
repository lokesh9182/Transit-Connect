<%@page import="org.springframework.data.repository.query.Param"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %> --%>
<%-- <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> --%>
							   
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-5 offset-3 mt-3 " style="background-color: lightgrey; border-radius: 10px; padding: 20px">
				<h2>Login Form</h2>

<%-- 				<% if(request.getParameter("error") != null){ %> --%>
		
<!-- 						<i style="color: red">Invalid user..!</i> -->
		
<%-- 				<%} %> --%>
				<form:form action="/process-login" modelAttribute="loginForm">
					<div class="form-group">
						<label for="username">Username:</label>
						<form:input path="username" id="username" class="form-control" /><br>
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<form:password path="password" id="password" class="form-control" /><br>
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
					<i>New User: <a href="/registration">Sign Up here </a></i>
				</form:form>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>