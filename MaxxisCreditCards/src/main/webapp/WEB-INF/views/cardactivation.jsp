<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
.btn-block {
    display: block;
    width: 30%;
}
</style>
</head>

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


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body  background="http://il6.picdn.net/shutterstock/videos/12463673/thumb/10.jpg">

<div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2></h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>${message}</h3>
                </td>
            </tr>
        </table>
    </div>
 <div align="center">
<form action="activatecard" method = "POST">
<h3>Enter Your 16 Digit CardNumber to Activate<h3><br>
  Card Number:<br>
  <input type="text" name="creditCardNumber"  placeholder="Ex: 1234 5678 9101 1121">
  <br> <br> <br>

 <button class="btn btn-lg btn-success btn-lg btn-block " type="submit">Activate</button>
 
</form> 
</div>
</body>
</html>