<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
#check{
position:fixed;
right:30px;
  width: 180px;
  height: 40px;
  background-color:yellow;
  moz-border-radius: 15px;
  -webkit-border-radius:20px;
  border: 2px solid gray;
  padding: 5px;
	color:#CCC;
}
#footer
{
position:fixed;
	bottom:0px;
	left:0px;
	width:100%;
	color:#CCC;
	background:#333;
	padding:8px;
}
#header
{
position:fixed;
top:0px;
left:0px;
width:100%;
color:#CCC;
background:#333;
}
</style>
<script>
function validate()
{
	if(document.shop.username.value=="")
	{
		alert("enter the username");
		return false;
	}

	if(document.shop.pwd.value=="")
	{
		alert("enter the password");
		return false;
	}
	if(document.shop.username.value==""||document.shop.pwd.value=="")
	{
		alert("enter both the fields");
		return false;
}
	if(document.shop.pwd.value.length<6||document.shop.pwd.value.length>8)
	{
		alert("please give proper 7character password");
		return false;
	}
	else
	{
		alert("login successfull");
		return true;
	}
}
</script>
<center>
<h1>shop here!!:))</h1>
</head>
<body>
<img src="images/icon1.png">
<form name="shop" method="post" action="welcomepage.jsp" onsubmit="return validate()">
<div style="width:300px;height:100px;padding:10px;border:5px solid gray; position:right">
<h>Shop ur new stylish bags now !!!<h><br><br>
Username:<input type="text" name="username"style="background-color:yellow; color:black; height:15px;"><br><br>
Password:<input type="password" name="pwd"style="background-color:yellow; color:black; height:15px;"><br><br>
<input type="submit" value="login" style="background-color:yellow; color:solid black;"><br><br>
<div id="footer">
<p>Conditions of use and sale privacy notice interset based-ads @1996-2016 Stylish handbags.com</p>
<div id="header">
<h1>Shopping is always a good idea::))</h1>
<b>sign up</b>
<div id="check">
<a href="regform.jsp"><h> NEW USERS CLICK HERE >>> </h> </a>
</center>
</form>
</body>
</html>
</body>
</html>