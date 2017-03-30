<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Project</title>
</head>
<body>
	<h3>Password Change Form</h3>
	<FONT color="blue"> User Name="UserName" and old password="password" and new password="password"
	</FONT>
	<h3>
		Welcome : 
		<c:out value="${userName}" />
		<a href="loginsuccess.html">Back</a>
	</h3>
	<form:form action="passwordchangeform.html" commandName="passwordChangeForm">
		<table>
			<tr>
				<td>User Name:<FONT color="red"><form:errors
							path="userName" /></FONT></td>
			</tr>
			<tr>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>Old Password:<FONT color="red"><form:errors
							path="password" /></FONT></td>
			</tr>
			<tr>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>New Password:<FONT color="red"><form:errors
							path="newPassword" /></FONT></td>
			</tr>
			<tr>
				<td><form:input path="newPassword" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>