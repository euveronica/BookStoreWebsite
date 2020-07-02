<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New User</title>
</head>
<body>
<jsp:directive.include file="header.jsp" />
		
		<div align="center">
		<h2>Create New User</h2>
		</div>
		
		<div align="center">
			<form action = "create_user" method = "post" onsubmit="return validateFormInput()">
			<table>
				<tr>
					<td align="left">Email:</td>
					<td align="left"><input type = "text" id="email" name="email" size="20" /> </td>
				</tr>
				<tr>
					<td align="left">Full Name:</td>
					<td align="left"><input type = "text" id="fullname" name="fullname" size="20" /> </td>
				</tr>
				<tr>
					<td align="left">Password:</td>
					<td align="left"><input type = "password" id= "password" name="password" size="20" /> </td>
				</tr>
				<tr>
				<td>
				&nbsp;
				</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value ="Save"/>
						&nbsp;&nbsp;
						<input type="button" value ="Cancel" onclick="javascript:history.go(-1);"/>
					</td>
					
					
					
				</tr>
			</table>
			</form>
		</div>
		
		
		<jsp:directive.include file="footer.jsp" />
</body>

<script type="text/javascript">
		function validateFormInput(){
				var fieldEmail = document.getElementById("email");
				var fieldFullName = document.getElementById("fullname");
				var fieldPassword = document.getElementById("password");
				
				if (fieldEmail.value.length == 0){
					alert("Email is required");
					fieldEmail.focus();
					return false;
				}
				if ( fieldFullName.value.length == 0){
					alert("Full Name is required");
					fieldFullName.focus();
					return false;
				}
				if ( fieldPassword.value.length == 0){
					alert("Password is required");
					fieldPassword.focus();
					return false;
				}
				
				return true;
		}
</script>
</html>