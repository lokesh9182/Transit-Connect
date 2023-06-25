<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
        crossorigin="anonymous">
  <style>
    body, html {
      height: 100%;
      margin: 0;
    }
    .containerr {
      display: flex;
      height: 100%;
      width: 96%;
      margin-left: 2%;
      margin-top: 10px;
    }
    .left-section {
      background-color: #f8f9fa;
      width: 25%;
      height: 100vh;
      position: fixed;
      top: 50px;
      left: 0;
      overflow-y: scroll;
      padding: 20px;
    }
    .right-section {
      margin-left: 25%;
      top: 50px;
      padding: 20px;
      padding-top: 60px;
    }
    .button {
      margin-bottom: 30px;
      width: 80%;
    }
    .link-item {
      margin-bottom: 30px;
      font-size: x-large;
    }
    .link-item a {
      display: block;
      padding: 5px;
      padding-left: 80px;
      color: #000;
      border-radius: 10px;
      text-decoration: none;
    }
    .link-item a:hover {
      background-color: #f1f1f1;
    }
    .link-item.active a {
      background-color: #343a40;
      color: #fff;
    }
  </style>
</head>
<body>
  <h2 align="center">Services</h2><br>
  <div class="link-item active">
    <a href="/filterBySDDT?destination=default&&source=default&&date=2023-01-01&&time=00:00:00">Book New Trip</a>
  </div>
  <div class="link-item active">
    <a href="/MyBookings">My Bookings</a>
  </div>
  <div class="link-item active">
    <a href="#">Link 3</a>
  </div>
  <div class="link-item active">
    <a href="#">Link 4</a>
  </div>
  <div class="link-item active">
    <a href="/MyBookings">Link 5</a>
  </div>

</body>
</html>
<!--        <a href="http://localhost:8080/register-rideseeker" class="btn btn-secondary button"> Register Ride Seeker</a> --> -->
<!--             <a href="http://localhost:8080/Register-ride/RPLo58" class="btn btn-secondary button"> Add New Vehicle</a> -->
<!--             <a href="/filterBySDDT?destination=default&&source=default&&date=2023-01-01&&time=00:00:00" class="btn btn-secondary button">Book New Trip</a> -->
<!--             <a href="http://localhost:8080/getAvalilableTrips" class="btn btn-secondary button">Current Available Trips</a> -->
<!--             <a href="/MyBookings" class="btn btn-secondary button">My Bookings</a> -->
<!--             <a href="http://localhost:8080/getAllTrips/Canceled/RPLo58" class="btn btn-secondary button">Cancelled Trips</a> -->
<!--             <a href="http://localhost:8080/getAllTrips/All/RPLo58" class="btn btn-secondary button">All Trips</a> -->
       
