<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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
<form action="activatecard" method = "POST">
  Card Number:<br>
  <input type="text" name="creditCardNumber" value="">
  <br>

 <button class="btn btn-lg btn-success btn-block btn-signin" type="submit">Activate</button>
</form> 
</body>
</html>