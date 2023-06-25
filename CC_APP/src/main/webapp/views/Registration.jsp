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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous">
	</script>
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
            width: 15%;
            height:100%;
            background-color: #f2f2f2;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
            position: fixed;
        }

        .right-section {
            width: 85%;
            height:100%;
            margin-left:15%;
           
            padding: 20px;
        }

        .button {
            margin-bottom: 30px;
            width: 80%;
        }
    </style>
</head>
<!-- <body style="background-color: lightgray"> -->

<jsp:include page="header.jsp"></jsp:include>



<body onload="fun()" >
    <div class="containerr"> 

        <div class="right-section">
		<div class="row">
			<div class="col-5 offset-3 " style="background-color: lightblue; border-radius: 10px; padding: 20px">
				<h2 id="demo">Registration Form</h2><i>Existing User: <a href="/login">Login </a></i>
<%-- 					<% if(request.getParameter("userExist") != null){ %> --%>
		
<!-- 						<i style="color: red">An User existed with this user name...!</i> -->
		
<%-- 				<%} %> --%>
				
				<form:form action="/process-registration" modelAttribute="reg_dto" >
					
				<div class="form-group">
						<label>User Name:</label>
						<form:input path="username"  class="form-control" required="required"/><br>
					</div>
				<div class="form-group">
						<label>Password:</label>
						<form:password path="password"  class="form-control" required="required"/><br>
					</div>

				<div class="form-group">
						<label>Register As:</label>
						<form:select path="who" id="as" onchange="fun()" class="form-control" required="required">
							<form:option value="provider" >Ride Provider</form:option>
							<form:option value="seeker"  >Ride Seeker</form:option>
						</form:select><br>
					</div>

					
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
						<form:input path="email"  class="form-control" required="required"/><br>
					</div>
				<div class="form-group">
						<label >Mobile No:</label>
						<form:input path="phone"  class="form-control" required="required"/><br>
					</div>
				<div class="form-group">
						<label >Aadhar card No :</label>
						<form:input path="aadhar"  class="form-control" required="required"/><br>
					</div>
				<div class="form-group" id="add" style="display:none;">
						<label >Address:</label>
						<form:input path="address"  class="form-control"/><br>
					</div>
				<div class="form-group" id="lic" style="display:none;">
						<label >Driving Licence No:</label>
						<form:input path="drivingLicenceNo"  class="form-control" /><br>
					</div>
				<div class="form-group" id="vd" style="display:none;">
						<label >Valid Up To :</label>
						 <input  name="validUpto" type="date"  class="form-control" /><br>
					</div>
					
					

					<button type="submit" class="btn btn-primary">Register</button>
<!-- 					<i>Existing User: <a href="/customLogin">Login </a></i> -->
				</form:form>
			</div>
		</div>

        </div>
    </div>
    					<script type="text/javascript">
						
						function fun(){
							var who = document.getElementById("as").value;
							if(who==="provider"){
								document.getElementById("vd").style.display = "";
								document.getElementById("lic").style.display = "";
								document.getElementById("lic").required=true;
								document.getElementById("add").style.display = "none";
								
							}
							else{
								document.getElementById("vd").style.display = "none";
								document.getElementById("lic").style.display = "none";
								document.getElementById("add").style.display = "";
							}
							
						}
						
					
					</script>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
	
	
	