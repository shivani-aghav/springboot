<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
	String errMsg = (String) request.getAttribute("errMsg");
	%>

	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<%=msg%>
	<%
	}
	%>

	<%
	if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<%=errMsg%>
	<%
	}
	%>
	<fieldset>
		<legend> Registration form </legend>
		<form action="./registerbutton" method="post">
			<table>
				<tr>
					<td><label>Employee name:</label></td>
					<td><input type="text" name="empName"></td>
					<!-- 	 entered data come in name attribute -->
				</tr>
				<tr>
					<td><label>Employee Id</label></td>
					<td><input type="text" name="empId"></td>
				</tr>
				<tr>
					<td><label>Employee email:</label></td>
					<td><input type="email" name="emailId"></td>
				</tr>
				<tr>
					<td><label>Employee password:</label></td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register"></td>
					<td><input type="reset" value="Reset"></td>
				</tr>

			</table>
		</form>
	</fieldset>
	<h5>
		Already have an account? <a href="./login">login</a>
	</h5>
</body>
</html>