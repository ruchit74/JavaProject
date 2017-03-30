<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Project</title>
</head>
<body>
	<h3>
		Welcome : 
		<c:out value="${loginForm.userName}" />
		<a href="loginform.html">Back</a>
	</h3>
	<table>
		<tr>
			<c:if test="${loginForm.userFirstTime == '0'}">
			<td>
				<a href="passwordchange1.html?userName=${loginForm.userName}">Password Change</a>
				</td>
			</c:if>
		</tr>

		<tr>
		<td>
				<a href="addProjectchange1.html?userName=${loginForm.userName}">Add Project</a>
				</td>			
		</tr>


	</table>
</body>
</html>