<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Project</title>
</head>
<body background="../images/backGround1.jpg">
	<h3><center>Login Form</center></h3>
	<FONT color="blue">
	</FONT>
	<form:form action="loginform.html" commandName="loginForm">
		<table align="center">
			<tr>
				<td>User Name:<FONT color="red"><form:errors
							path="userName" /></FONT></td>
			</tr>
			<tr>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>Password:<FONT color="red"><form:errors
							path="password" /></FONT></td>
			</tr>
			<tr>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>User Type:<FONT color="red"><form:errors
							path="userType" /></FONT>
							</td>
			</tr>
			<tr>
				<td><select name="userType" path="userType" /> 
				<option value="user">user</option>
   				 <option value="admin">admin</option>

				</select></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>