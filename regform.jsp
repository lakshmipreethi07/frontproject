<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<center>
<style>
#header
{
position:fixed;
top:0px;
left:0px;
height:80px;
width:100%;
color:#CCC;
background:#333;
}
</style>
<script>
function form()
{
	if(document.reg.firstname.value=="")
	{
		alert("enter your first name");
		return false;
	}
	if(document.reg.lastname.value=="")	
	{
		alert("enter your last name");
		return false;
	}
	if(document.reg.Username.value=="")
	{
		alert("enter your username");
		return false;
	}
	if(document.reg.pwd.value=="")
	{
		alert("please give ur password");
		return false;

	}
	if(document.reg.pwd.value.length<6||document.reg.pwd.value.length>8)
		{
			alert("ur password must contain 7 letters");
			return false;
		}	
	if(document.reg.password.value=="")
	{
		alert("please confirm password");
		return false;
	}
		if(document.reg.pwd.value!=document.reg.password.value)
		{
			alert("password does not match");
			return false;
		}
	if(document.reg.num.value=="")
	{
		alert("please give ur number");
		return false;
	}

		if(document.reg.num.value.length<10||document.reg.num.value.length>10)
		{
			alert("give proper 10digit number");
			return false;
		}
		else
		{
			alert("registration successfull");
			return true;
		}


}
</script>
</head>
<body>
<body background="icon.png">
<form name="reg" method="post" action="loginpage.jsp" onsubmit="return form()"><br><br><br>
<h1>Register here!!</h1>
<table>
	<tr>
<td>First Name:</td> 
<td><input type="text" name="firstname" ><br></td>
	</tr>
	<tr>
<td>Last Name :</td>
<td><input type="text" name="lastname" ><br></td>
	</tr>
	<tr>
<td>Username:</td>
<td><input type="text" name="Username" ><br></td>
</tr>
<tr>
	<td>Password:</td>
<td><input type="password" name="pwd"><br></td>
</tr>
<tr>
	<td>Confirm password:</td>
<td><input type="password" name="password" ><br></td>
<tr>
	<td>Phone number:</td>
<td><input type="number" name="num" ><br></td>
</tr>
<tr>
	<td><input type="submit" value="submit" style="background-color:blue; color:white; " ><br><br></td>
	</tr>
</table>
<div id="header"><font face="cursive" color="white" ><h1>Stylish handbags</h1> </font>
</div>
</form>
</body>
</table>
</html>