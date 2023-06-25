<%@page import="java.util.Arrays"%>
<%@page import="com.klr.cc.Entity.Trip"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Trips</title>
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
					<td align="center">Trip Id
					<td align="center">Vehicle Id
					<td align="center">Trip Date
					<td align="center">Trip Time
					<td align="center">No of Seats Filled/Total
					<td align="center">Location(From - To)
					<td align="center">Current Status
				</tr>
			 
			<tbody style="cursor: pointer;">
			<% int i=1;
			String status=(String)request.getAttribute("status");
			for(Trip trip: (List<Trip>)request.getAttribute("TripData")){ 
					if(Arrays.asList(status.split(",")).contains(trip.getRideStatus()) || status.equals("All") ){%>
			 
			 
			  	<tr  onclick='window.location.href="http://localhost:8080/tripDetails/<%=trip.getCreatorUserId()%>/<%=trip.getTripId()%>/Provider"'>
					<td align="center"><%=i++ %>
					<td align="center"><%=trip.getTripId() %></td>
					<td align="center"><%=trip.getVechileId() %></td>
					<td align="center"><%=trip.getRideDate() %></td>
					<td align="center"><%=trip.getRideTime() %></td>
					<td align="center"><%=trip.getSeatsFilled() %>/<%=trip.getNoOfSeats() %></td>
					<td align="center"><%=trip.getFromLoc()+" - "+trip.getToLoc() %></td>
					<td align="center"><%=trip.getRideStatus() %>
				
<%-- 					<td align="center"><a class="btn btn-primary" href="/updateTrip/<%=trip.getCreatorUserId()%>/<%=trip.getTripId()%>" role="button">Update</a> --%>
<%-- 						<a class="btn btn-primary" href="http://localhost:8080/cancelTrip/<%=trip.getCreatorUserId()%>/<%=trip.getTripId()%>" role="button">Cancel</a> --%>
<!-- 					</td> -->
				</tr>
			  <%} }%>
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