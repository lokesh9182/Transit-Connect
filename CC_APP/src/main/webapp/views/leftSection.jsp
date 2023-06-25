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
        width: auto;
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
      width: 100%;
    }
    .button {
      margin-bottom: 30px;
    }
    .link-item {
      margin-bottom: 30px;
      font-size: x-large;
    }
    .link-item a {
      display: block;
      padding: 10px;
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
<a href="http://localhost:8080/updateProvider" class="btn btn-secondary button"> Update My details</a>
  </div>
  
  <div class="link-item active">
<a href="http://localhost:8080/Register-ride/RPLo58" class="btn btn-secondary button"> Add New Vehicle</a>
  </div>
  <div class="link-item active">
<a href="http://localhost:8080/RegisterNewTrip/RPLo58" class="btn btn-secondary button">Create New Trip</a>
  </div>
  
  <div class="link-item active">
<a href="http://localhost:8080/getAllTrips/Planed,Started/RPLo58" class="btn btn-secondary button">Current Available Trips</a>
  </div>
  
  <div class="link-item active">
<a href="http://localhost:8080/getAllTrips/Completed/RPLo58" class="btn btn-secondary button">Completed Trips</a>
  </div>
  
  <div class="link-item active">
<a href="http://localhost:8080/getAllTrips/Canceled/RPLo58" class="btn btn-secondary button">Cancelled Trips</a>
  </div>
 
  <div class="link-item active">
<a href="http://localhost:8080/getAllTrips/All/RPLo58" class="btn btn-secondary button">All Trips</a>
  </div>
 
 
</body>
</html>