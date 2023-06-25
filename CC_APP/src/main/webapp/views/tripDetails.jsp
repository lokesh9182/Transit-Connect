<%@page import="com.klr.cc.Entity.Trip"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

	<div class="containerr ">
		<div class="left-section">
		<%if( request.getAttribute("role").equals("Seeker")){ %>	
			<jsp:include page="userleftSection.jsp"></jsp:include>
			<%}else{ %>
			<jsp:include page="leftSection.jsp"></jsp:include>
			<%} %>
		</div>

		<div class="right-section ">
			<!-- Content for the right section goes here -->
			<%Trip trip = (Trip)request.getAttribute("Trip"); %>

			<div class="row" style="margin: 25px 100px 2px 110px; z-index:-1">
				<div class="card">
					<div class="card-header">
						<h1 align="center"><%=trip.getFromLoc()+" - "+trip.getToLoc() %></h1>
					</div>
					<div class="card-body">
						<h5 align="center">Trip Details</h5>
						<h4>
							<div class="row">
								<div class="row pb-4 offset-3">
									<div class="col-3">Trip Id</div>
									<div class="col-1">:</div>
									<div class="col-5"><%=trip.getTripId() %></div>
								</div>
								<div class="row pb-4 offset-3">
									<div class="col-3">Vehicle Id</div>
									<div class="col-1">:</div>
									<div class="col-5"><%=trip.getVechileId() %></div>
								</div>
								<div class="row pb-4 offset-3">
									<div class="col-3">Ride Date</div>
									<div class="col-1">:</div>
									<div class="col-5"><%=trip.getRideDate() %></div>
								</div>
								<div class="row pb-4 offset-3">
									<div class="col-3">Ride Time</div>
									<div class="col-1">:</div>
									<div class="col-5"><%=trip.getRideTime() %></div>
								</div>
								<div class="row pb-4 offset-3">
									<div class="col-3">Location</div>
									<div class="col-1">:</div>
									<div class="col-5"><%=trip.getFromLoc()+" - "+trip.getToLoc() %></div>
								</div>
								<div class="row pb-4 offset-3">
									<div class="col-3">Current Status</div>
									<div class="col-1">:</div>
									<div class="col-5"><%=trip.getRideStatus() %></div>
								</div>
								<div class="row pb-4 offset-3">
									<div class="col-3">Seats Filled</div>
									<div class="col-1">:</div>
									<div class="col-5"><%=trip.getSeatsFilled()+"/"+trip.getNoOfSeats()%></div>
								</div>
							</div>
						</h4>
					</div>
				<%if( request.getAttribute("role").equals("Seeker")){ %>	
<!-- 		This is for Ride seeker********************************************* -->
					<div class="card-footer text-muted">
						<div class="row offset-4">
<!-- 			Hide this button if it is booked -->
							<div class="col-3">
								<a href="http://localhost:8080/bookTrip/<%=trip.getTripId()%>" class="btn btn-primary">Book this Trip</a>
							</div>
						</div>
					</div>
					<%}else{ %>
					
					
<!-- 					Below is for Ride provider ************************************* -->
					<div class="card-footer text-muted">
						<div class="row offset-2">
							<div class="col-3">
								<a href="/updateTrip/<%=trip.getCreatorUserId()%>/<%=trip.getTripId()%>"
									class="btn btn-primary">Edit Details</a>
							</div>
							<div class="col-3">
								<a href="http://localhost:8080/cancelTrip/<%=trip.getCreatorUserId()%>/<%=trip.getTripId()%>"
									class="btn btn-primary">Cancel Trip</a>
							</div>
							<div class="col-3">
								<a href="/getTripBookings/<%=trip.getTripId()%>" class="btn btn-primary">Show Bookings</a>
							</div>
							<div class="col-3">
								<a class="btn btn-primary">Generated Bill</a>
							</div>
						</div>
					</div>
					<%} %>
				</div>
			</div>

		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
