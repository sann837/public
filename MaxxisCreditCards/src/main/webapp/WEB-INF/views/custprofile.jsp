<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isELIgnored="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
<head>
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


<body  background="https://www.mysmartmove.com/sites/SmartMove/img/slider/secure.jpg">

    <div align="left",style = margin-top:100px;>
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2></h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center" style="color:#F7F9F9">
                    <h3>${message}</h3>
                </td>
            </tr>
            <tr>
                <td style="color:#F7F9F9">Name on card:</td>
                <td style="color:#F2D7D5">${profile.nameOnCard}</td>
            </tr>
            <tr>
                <td style="color:#F7F9F9">Card Number:</td>
                <td style="color:#F7F9F9">${profile.creditCardNumber}</td>
            </tr>
            <tr>
                <td style="color:#F7F9F9">Card Status:</td>
                <td style="color:#F7F9F9">${profile.cardStatus}</td>
            </tr>
            <tr>
                <td style="color:#F7F9F9"> Card Limit:</td>
                <td style="color:#F7F9F9">${profile.cardLimit}</td>
            </tr>
 
        </table><br><br>
     
    </div>
    <div align="left">
       <h3><a href="cardactivation" class="Activate-card">
               Activate card
            </a></h3><br><br>
     </div>
   
</body>
</html>