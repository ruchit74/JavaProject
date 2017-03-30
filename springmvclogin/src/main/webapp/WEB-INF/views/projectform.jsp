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
	<h3>Project Form</h3>
	<FONT color="blue"> User Name="UserName" and project deails </FONT>
	<form:form action="projectform.html" commandName="projectForm">
		<table>
			<tr>
				<td>User Name:<FONT color="red"><form:errors
							path="userName" /></FONT></td>
			</tr>
			<tr>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>Project Name:<FONT color="red"><form:errors
							path="projName" /></FONT></td>
			</tr>
			<tr>
				<td><form:input path="projName" /></td>
			</tr>
			<tr>
				<td>Project Date:<FONT color="red"><form:errors
							path="projDate" /></FONT></td>
			</tr>
			<tr>
				<td>
				<%-- <form:input path="projDate" /> --%>
				
		<fmt:formatDate value="${projDate}" 
                pattern="MM-dd-yyyy" 
                var="formattedDate"/>
<form:input path="projDate" value ="${formattedDate}" type="projDate"/>		
				
				</td>
			</tr>
			
			
			
			<tr>
				<td>Project Desc:<FONT color="red"><form:errors
							path="projDesc" /></FONT></td>
			</tr>
			<tr>
				<td><form:input path="projDesc" /></td>
			</tr>

			<tr>
				<td>Project Status:<FONT color="red"><form:errors
							path="projStatus" /></FONT></td>
			</tr>
			<tr>
				<td><form:input path="projStatus" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>