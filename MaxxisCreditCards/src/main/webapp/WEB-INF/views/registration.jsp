<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>registration</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/registration.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

<body  background="https://www.priceless.com/travel/images/dream/Module4.jpg">
<h3>${regstatus}</h3><br><br>
<div class="registration" style= margin-left:100px;>
   <form:form action="register" method="POST" modelAttribute="Customer"><br><br>
        CardNumber:<br>
        <input type="text" name="CardNumber" placeholder="1234 5678 9101 1213">
        <br><br> UserID:
        <br>
        <input type="text" name="UserID">
        <br><br> Password:
        <br>
        <input type="password" name="Password">
        <br><br> Confirm Password:<br>
        <input type="password" name="Confirm Password"><br><br>
          <input type = "submit"  class="btn btn-primary btn-block" ></button>
     </form:form>

</div>
</body>

</html>
