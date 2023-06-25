<%@page import="com.klr.cc.Entity.Trip"%>
<%@page import="java.util.List"%>
<%@page import="com.klr.cc.Entity.RideInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="c" uri="http:/java.sun.com/jsp/jstl/core" %> --%>
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

	<div class="row">
		<div class="col-5 offset-3  " style="background-color: lightblue; border-radius: 10px; padding: 20px">
	<h2>Trip Registration Form</h2>
<%-- 					<% if(request.getParameter("userExist") != null){ %> --%>

<!-- 						<i style="color: red">An User existed with this user name...!</i> -->

<%-- 				<%} %> --%>
	<form:form action="/Process-RegisterNewTrip/${ProviderID}" modelAttribute="Trip-Registration-dto">
		
		<form:input path="tripId" cssStyle="display:none"/>
		<form:input path="creatorUserId" cssStyle="display:none"/>
		<form:input path="seatsFilled" cssStyle="display:none"/>

	
	<div class="form-group">
			<label >Select Vehicle :</label>
			<form:select path="VechileId" class="form-control" required="required">
				<%  List<RideInfo> rideInfoList = (List<RideInfo>) request.getAttribute("Vehicles");
	 				for (RideInfo ride : rideInfoList) {%>
					<form:option value="<%= ride.getVehicleNo()%>"><%=ride.getCarName() %></form:option>
				<%} %>
			</form:select>
		</div><br>
	<div class="form-group">
			<label >From Location :</label>
			<form:input path="fromLoc"  class="form-control" required="required"/><br>
		</div>
	<div class="form-group">
			<label >To Location :</label>
			<form:input path="toLoc"  class="form-control" required="required"/><br>
		</div>
	<div class="form-group">
			<label >Trip status :</label>
			<form:select path="rideStatus"  class="form-control" required="required">
				<form:option value="Planed">Planed</form:option>
				<form:option value="Started">Started</form:option>
				<form:option value="Completed">Completed</form:option>
				<form:option value="Canceled">Canceled</form:option>
			</form:select>
			<br>
		</div>

<%if(( (Trip)request.getAttribute("Trip-Registration-dto") ).getTripId()==null ){ %>
	<div class="form-group">
			<label >Ride Date :</label>
			<input  name="rideDate" type="date"  class="form-control" required="required"/><br>
	</div>	
	<div class="form-group">
		<label >Ride Time :</label>
	 	 <input  name="rideTime" type="time"  class="form-control" required="required"/>
	</div><br>
	<button type="submit" class="btn btn-primary">Register</button>
	<%}		  

else{ %>
		<div class="form-group">
			<label >Total No.of seats :</label>
			<form:input path="noOfSeats"  class="form-control" required="required"/>		
	</div><br>
		<div class="form-group">
		<label >Ride Date :</label>
			<form:input path="rideDate" class="form-control" required="required"/>
		</div><br>
		<div class="form-group">
			<label >Ride Time :</label>
			<form:input path="rideTime" class="form-control" required="required"/>
		</div><br>
		<button type="submit" class="btn btn-primary">Update Data</button>
<%} %>
				
		
		
	
		
<!-- 					<i>Existing User: <a href="/customLogin">Login </a></i> -->
	</form:form>
		</div>
	</div>
            <!-- Content for the right section goes here -->
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
	
	
	