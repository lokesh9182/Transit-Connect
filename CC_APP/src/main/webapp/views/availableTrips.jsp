<%@page import="java.util.HashSet"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.klr.cc.Entity.Trip"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        <jsp:include page="userleftSection.jsp"></jsp:include>
       </div>
       
       
       
        <div class="right-section" style="width: 100%">
		<h3 align="center">Available Trips to Book</h3>
		<form action="/filterBySDDT" method="post" style=" border:2px solid blue;border-radius:10px; padding:2px 15px 10px 15px">
		<div class="row border-3">
					<div class="col">
						<label>Source Loc:</label>
<!-- 						<input name="source" value="default" class="form-control"/> -->
						<select name="source" value="default" class="form-control">
						<option value="default" >default</option>
						<% Map<String,HashSet<String>> map =(HashMap)request.getAttribute("map");
						for(String val:map.get("source")){ %>
							<option value="<%=val%>"><%=val%></option>
							<%} %>
						</select>
					</div>
					<div class="col ">
						<label>Destination Loc :</label>
						<select name="destination" value="default" class="form-control">
						<option value="default" >default</option>
						<% for(String val:map.get("destination")){ %>
							<option value="<%=val%>"><%=val%></option>
							<%} %>
						</select>
					</div>
					<div class="col ">
						<label>Ride Date :</label>
						<input type="date" name="date" value="2023-01-01"  class="form-control" required />
					</div>
					<div class="col">
						<label>Ride Time :</label>
						<input type="time" name="time" value="00:00" class="form-control" />
					</div>
					<div class="col">
						<label>Filter Here :</label>
						<input type="submit" class="form-control btn btn-primary" />
					</div>
		</div>
		</form>
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
			for(Trip trip: (List<Trip>)request.getAttribute("AvailableTrips")){ 
					if(trip.getRideStatus().equals("Planed") ){%>
			 
			 
			  	<tr  onclick='window.location.href="http://localhost:8080/tripDetails/<%=trip.getCreatorUserId()%>/<%=trip.getTripId()%>/Seeker"'>
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
		
		<%if(i==1){ %>
			<div align="center"> 
				<i style="color: red"> No Records Found...!
				</i></div>
		<%} %>

	</div>
        </div>


    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

</body>
</html>