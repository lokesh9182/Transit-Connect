<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign Up</title>
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
				<h2>SignUp Form</h2>
<%-- 					<% if(request.getParameter("userExist") != null){ %> --%>
		
<!-- 						<i style="color: red">An User existed with this user name...!</i> -->
		
<%-- 				<%} %> --%>
				
				<form:form action="/Process-signup" modelAttribute="logindto">

					<div class="form-group">
						<label for="userName">Username:</label>
						<form:input path="username" id="userName" class="form-control" required="required"/><br>
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<form:password path="password" id="password" class="form-control" required="required" /><br>
					</div>
					<button type="submit" class="btn btn-primary">Sign Up</button>
					<i>Existing User: <a href="/login">Login </a></i>
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