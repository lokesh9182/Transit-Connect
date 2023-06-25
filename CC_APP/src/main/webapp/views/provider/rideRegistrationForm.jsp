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
        <div class="left-section">
                <jsp:include page="leftSection.jsp"></jsp:include> </div>
       
       
       
        <div class="right-section">
          		<div class="row ">
			<div class="col-5 offset-3 " style="background-color:lightblue; border-radius: 10px; padding: 20px">
				<h2>Ride Registration Form</h2><br>
<%-- 					<% if(request.getParameter("userExist") != null){ %> --%>
		
<!-- 						<i style="color: red">An User existed with this user name...!</i> -->
		
<%-- 				<%} %> --%>
				
				<form:form action="/process-Register-ride/${RiderId}" modelAttribute="Ride-Registration-dto">
			
				<div class="form-group">
						<label>Vehicle No:</label>
						<form:input path="vehicleNo"  class="form-control" required="required"/><br>
					</div>
				
				<div class="form-group">
						<label >Vehicle Type:</label>
						<form:input path="carType"  class="form-control" required="required"/><br>
					</div>
				<div class="form-group">
						<label >Vehicle Name:</label>
						<form:input path="carName"  class="form-control" required="required"/><br>
					</div>
				<div class="form-group">
						<label >Fuel Type:</label>
						<form:input path="fuelType"  class="form-control" required="required"/><br>
					</div>
				<div class="form-group">
						<label >No Of Seats :</label>
						<form:input path="noOfSeats"  class="form-control" required="required"/><br>
					</div>
					
					<button type="submit" class="btn btn-primary">Register</button>
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
