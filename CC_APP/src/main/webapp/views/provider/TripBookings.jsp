
<%@page import="com.klr.cc.Entity.Trip"%>
<%@page import="com.klr.cc.Entity.Booking"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trip Bookings</title>

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>


    <div class="containerr">
        <div class="left-section">
        <jsp:include page="leftSection.jsp"></jsp:include>
       </div>
        <div class="right-section">
    
       
            <!-- Content for the right section goes here -->
            <div align="center" style="margin: 40px">
		<br>
		<table class="table table-hover table-bordered border-primary">
			<thead class="table-dark">
				<tr><td align="center">Sl.No
					<td align="center">Booking Id
					<td align="center">Vehicle Id
					<td align="center">Trip Date
					<td align="center">Trip Time
					<td align="center">No of Seats
					<td align="center">Location(From - To)
					<td align="center">Current Status
				</tr>
			 
			<tbody style="cursor: pointer;">
			<% int i=1;
			for(Booking booking: (List<Booking>)request.getAttribute("tripBookings")){ 
					Trip trip =booking.getTrip();%>
			 
			  	<tr>
					<td align="center"><%=i++ %>
					<td align="center"><%=booking.getBookingId() %></td>
					<td align="center"><%=trip.getVechileId() %></td>
					<td align="center"><%=trip.getRideDate() %></td>
					<td align="center"><%=trip.getRideTime() %></td>
					<td align="center"><%=booking.getNumberOfSeat() %></td>
					<td align="center"><%=trip.getFromLoc()+" - "+trip.getToLoc() %></td>
					<td align="center"><%=booking.getStatus() %>
	
				</tr>
			  <%} %>
			</tbody>
		</table>
			<% if(i==1){ %>
			<i>No Records found.......!</i>
			<%} %>

	</div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

</body>
</html>