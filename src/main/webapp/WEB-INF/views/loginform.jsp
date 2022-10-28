<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Login form</legend>
		<form action="./login1">
			<table>
				<tr>
					<td><label>Employee email:</label></td>
					<td><input type="email" name="empEmail"></td>
				</tr>
				<tr>
					<td><label>Employee password:</label></td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="button" value="Submit"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<h5>
		Don't have an account? <a href="./register">sign up</a>
	</h5>
</body>
</html>