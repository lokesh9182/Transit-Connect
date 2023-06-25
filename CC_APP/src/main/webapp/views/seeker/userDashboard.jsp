<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dash Board</title>
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
            width: 25%;
            height:100%;
            background-color: #f2f2f2;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
            position: fixed;
        }

        .right-section {
            width: 75%;
            margin-left:25%;
            background-color: lightgray;
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



<body>
    <div class="containerr">
        <div class="left-section">
        <jsp:include page="userleftSection.jsp"></jsp:include>
        </div>
        <div class="right-section">
            <!-- Content for the right section goes here -->
            <br>
            <br>
            <br><br>
            <br><br>
            <br><br>
            <br>
            <br>
            <br>
            <h1 align="center">User DashBoard</h1>
            
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>