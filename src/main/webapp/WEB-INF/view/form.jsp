<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./form" method="post">
	<table>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><input type="text" name="gender"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">Address 1</td>
		</tr>
		<tr>
			<td>Address Type</td>
			<td><input type="text" name="addressBeans[0].addressType"></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><input type="text" name="addressBeans[0].address"></td>
		</tr>
		<tr>
			<td>City</td>
			<td><input type="text" name="addressBeans[0].city"></td>
		</tr>
		<tr>
			<td>State</td>
			<td><input type="text" name="addressBeans[0].state"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">Address 2</td>
		</tr>
		<tr>
			<td>Address Type</td>
			<td><input type="text" name="addressBeans[1].addressType"></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><input type="text" name="addressBeans[1].address"></td>
		</tr>
		<tr>
			<td>City</td>
			<td><input type="text" name="addressBeans[1].city"></td>
		</tr>
		<tr>
			<td>State</td>
			<td><input type="text" name="addressBeans[1].state"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Register"></td>
		</tr>
	</table>
</form>
</body>
</html>