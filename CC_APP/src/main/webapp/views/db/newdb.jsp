<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Dashboard</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="views/style.css">
 
</head>
<body>
  <div id="navbar" style="padding-right:3%">
 
      <div class="row">
        <div class="col-md-4 text-center">
          
        </div>
        <div class="col-md-4 ">
          <h4 class="text-center">Planning Journey management ( PJM )</h4>
        </div>
        <div class="col text-end ">
          <button class="btn "style="color:white">Logout</button>
          
        </div>
    </div>
  </div>
  
  <div id="left-section">
  <h1 style="font-weight: bold; padding: 10px 0 20px 80px;">Dashboard</h1>
  
    <div class="link-item active">
      <a href="#">Link 1</a>
    </div>
    <div class="link-item">
      <a href="#">Link 2</a>
    </div>
    <div class="link-item">
      <a href="#">Link 3</a>
    </div>
    <div class="link-item">
      <a href="#">Link 4</a>
    </div>
    <div class="link-item">
      <a href="#">Link 5</a>
    </div>
  </div>

  <div id="right-section">
    <h2>Content Area</h2>
    <div class="line"></div>
    <p>This is the content of the right section. You can scroll through it.</p>
    
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
  <script>
    // Add active class to clicked link
    const links = document.querySelectorAll('.link-item');
    links.forEach(link => {
      link.addEventListener('click', function() {
        links.forEach(item => item.classList.remove('active'));
        this.classList.add('active');
      });
    });
  </script>
</body>
</html>
    