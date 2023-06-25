
<%@page import="com.klr.cc.Entity.Trip"%>
<%@page import="com.klr.cc.Entity.Booking"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
      <jsp:include page="userleftSection.jsp"></jsp:include>
    </div>
    <div class="right-section">
 
    
        <br>
  
        <table class="table table-hover table-bordered border-primary">
          <thead class="table-dark">
            <tr>
              <td align="center">Sl.No</td>
              <td align="center">Booking Id</td>
              <td align="center">Vehicle Id</td>
              <td align="center">Trip Date</td>
              <td align="center">Trip Time</td>
              <td align="center">No of Seats</td>
              <td align="center">Location(From - To)</td>
              <td align="center">Current Status</td>
            </tr>
          </thead>
          <tbody style="cursor: pointer;">
            <% int i = 1;
               for(Booking booking: (List<Booking>)request.getAttribute("bookings")){
                 Trip trip = booking.getTrip(); %>
            <tr onclick='window.location.href="/getBookingDetails/<%=booking.getBookingId()%>/<%=trip.getTripId()%>"'>
              <td align="center"><%=i++ %></td>
              <td align="center"><%=booking.getBookingId() %></td>
              <td align="center"><%=trip.getVechileId() %></td>
              <td align="center"><%=trip.getRideDate() %></td>
              <td align="center"><%=trip.getRideTime() %></td>
              <td align="center"><%=booking.getNumberOfSeat() %></td>
              <td align="center"><%=trip.getFromLoc()+" - "+trip.getToLoc() %></td>
              <td align="center"><%=booking.getStatus() %></td>
            </tr>
            <% } %>
          </tbody>
        </table>
        			<% if(i==1){ %>
			<i>No Records found.......!</i>
			<%} %>
       </div>
      </div>

  <!-- Bootstrap JS -->


 
</body>
</html>
