<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="<c:url value="/resources/login.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
</style>
</head>
	<body>
	<header>
   <h1 id="top" style  = text-align:top;font-size:40px;><cite style= margin-left:500px;>MAXXIS Credit Cards</cite></h1>
</header>
<nav class="navbar navbar-inverse" >
  <div class="container-fluid">
    <ul class="nav navbar-nav" style = margin-left:500px;>
      <li class="active"><a href="#">Banking</a></li>
      <li><a href="#">Credit Crads</a></li>
      <li><a href="#">Lending</a></li>
      <li><a href="#">Investing</a></li>
	   <li><a href="#">Business</a></li>
      <li><a href="#">Rewards & Offers</a></li>
    </ul>
	<form class="navbar-form navbar-right">
  <div class="input-group">
    <input type="text" class="form-control" placeholder="Search">
    <div class="input-group-btn">
      <button class="btn btn-default" type="submit">
        <i class="glyphicon glyphicon-search"></i>
      </button>
    </div>
  </div>
</form>
  </div>
</nav>
	<form action="apply" method="POST">
<div class="container" style= margin-top:150px;>
 
  <div class="panel-group" id="accordion">
    
      <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Name</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse in">
        <div class="panel-body">
        <div class="form-inline">
        
       
     
      <input type="input" class="form-control"  name="firstName"  placeholder="firstName" required><br><br>
   
     
     
      <input type="input" class="form-control" name = "middle"  placeholder="middle" ><br><br>
    
   
     
      <input type="input" class="form-control" name="lastName" placeholder="lastName" required>
   
   
     
     
        
        </div>
      </div>
      </div>
    </div>
   
  
  <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">Date-of-Birth</a>
        </h4>
      </div>
      <div id="collapse5" class="panel-collapse collapse">
        <div class="panel-body">
        
        <div class="form-group">
     
      <input type="date" class="form-control" name="dateOfBirth" placeholder="MM/DD/YYY " required>
    </div>
        
        </div>
      </div>
    </div>
 
  
  <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse6">SSN</a>
        </h4>
      </div>
      <div id="collapse6" class="panel-collapse collapse">
        <div class="panel-body">
        
        
        <div class="form-group">
     
      <input type="password" class="form-control" name="SSN" placeholder="SSN " required>
    </div>
        
        
        </div>
      </div>
    </div>
      <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">Email</a>
        </h4>
      </div>
      <div id="collapse4" class="panel-collapse collapse">
        <div class="panel-body">
        
        
        <div class="form-group">
     
      <input type="email" class="form-control" name="email" placeholder="Email " required>
    </div>
        
        </div>
      </div>
    </div>
     <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Telephone </a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">
        
         <div class="form-group">
     
      <input type="telephone" class="form-control" name="telephone" placeholder="Primary Number" required>
    </div>
        
        
        
        </div>
      </div>
    </div>
    
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Home Address</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">
        <div class="form-inline">
        
        <span class="form-group">
     
      <input type="input" class="form-control" name="address.addressLine1" placeholder="addressLine1" required>
    </span><br><br>
     <span class="form-group">
     
      <input type="input" class="form-control" name="address.addressLine2" placeholder="addressLine2" required>
    </span><br><br>
     <span class="form-group">
     
      <input type="input" class="form-control" name="address.city" placeholder="City" required>
    </span><br><br>
    <span class="form-group">
     
      <input type="input" class="form-control" name="address.state" placeholder="State" required>
    </span><br><br>
    <span class="form-group">
     
      <input type="input" class="form-control" name="address.zip" placeholder="Zip" required>
    </span>
    
        
        </div>
      </div>
      </div>
    </div>
 
  

      <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse7">Employer Details</a>
        </h4>
      </div>
      <div id="collapse7" class="panel-collapse collapse">
        <div class="panel-body">
        <div class="form-inline">
          <span class="form-group">
     
      <input type="input" class="form-control" name="CompanyName" placeholder="Company Name" required>
    </span><br><br>
        <span class="form-group">
     
      <input type="input" class="form-control" name="annualIncome" placeholder="Annual Income" required>
    </span><br><br>
     <span class="form-group">
     
      <input type="input" class="form-control" name="houseMortage" placeholder="House Mortage" >
    </span>
     
     
     
        
        </div>
      </div>
      </div>
    </div>
  <br>

     <input type = "submit"  class="btn btn-primary btn-block" ></button>

</form>
 </div>
	</body>
</html>