<%@page import="com.klr.cc.Entity.RideProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration Form</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <div class="containerr">
     
        <div class="left-section"> <jsp:include page="leftSection.jsp"></jsp:include> </div>
        
        <div class="right-section">
		<div class="row">
			<div class="col-5 offset-3 " style="background-color: lightblue; border-radius: 10px; padding: 20px">
				<h2>Registration Form</h2>
<%-- 					<% if(request.getParameter("userExist") != null){ %> --%>
		
<!-- 						<i style="color: red">An User existed with this user name...!</i> -->
		
<%-- 				<%} %> --%>
				
				<form:form action="/Process-RideProvider-Registration" modelAttribute="Registration-dto">
					<form:input path="rpId" cssStyle="display:none"/>
					<div class="form-group">
						<label>First Name:</label>
						<form:input path="firstName"  class="form-control" required="required"/><br>
					</div>
				
				<div class="form-group">
						<label >Last Name :</label>
						<form:input path="lastName"  class="form-control" required="required"/><br>
					</div>
				<div class="form-group">
						<label >Email:</label>
						<form:input path="emailId"  class="form-control" required="required"/><br>
					</div>
				<div class="form-group">
						<label >Mobile No:</label>
						<form:input path="phone"  class="form-control" required="required"/><br>
					</div>
				<div class="form-group">
						<label >Aadhar card No :</label>
						<form:input path="adharCard"  class="form-control" required="required"/><br>
					</div>
				<div class="form-group">
						<label >Driving Licence No:</label>
						<form:input path="dlNo"  class="form-control" required="required"/><br>
					</div>
					
					<%if(( (RideProvider)request.getAttribute("Registration-dto") ).getRpId()==null ){ %>
					<div class="form-group">
						<label >Valid Up To :</label>
						 <input  name="validUpto" type="date"  class="form-control" required="required"/><br>
					</div>
					
					<button type="submit" class="btn btn-primary">Register</button>
	<%}		  

else{ %>
					<div class="form-group">
						<label >Valid Up To :</label>
						 <form:input  path="validUpto" class="form-control" required="required"/><br>
					</div>
					
					
					<button type="submit" class="btn btn-primary">Update Details</button>
<%} %>
				
					
				
<!-- 					<i>Existing User: <a href="/customLogin">Login </a></i> -->
				</form:form>
			</div>
		</div>

        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
	
	
	