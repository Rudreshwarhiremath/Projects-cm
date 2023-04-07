<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-Workz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg-navbar-Light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src=" https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="80" height="48" class="d-inline-block align text-top">
				<a href="index.jsp">HOME</a>
				<a class="navbar-brand" href="#"></a> <img
				src=" https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="80" height="48" class="d-inline-block align text-top">
		</div>

	</nav>
<div align="center">
<h5 style="color: red">${match}</h5>
<h5 style="color: red">${msg}</h5>

<form action="signin" method="post">
	<table>
		<tr>
			<td>User ID</td>

		<td><input type="text" name="userId" id="userName"onchange="ValideName()">
			 <span id="nameError" style="color: red"></span> 
			 <span id="displayUserName" style="color: red"></span>
		</td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" id="userPassword" onblur="ValidePassword()">
				<span id="passwordError" style="color: red"></span> 
				<input type="checkbox" onclick="myFunction()">Show Password
	       </td>
		</tr>


	</table>
	<div>
	<button type="submit" class="btn btn-success">SignIN</button>
	</div>
	</form>
	<a href="signUp.jsp">Register as New User</a> 
	<br>
	<a href="resetpassword.jsp">Forgot Password</a> 
</div>	
<script>
function ValideName() {
	var user = document.getElementById('userName');
	var uservalue = user.value;
	console.log(uservalue);
	if (uservalue != null && uservalue != "" && uservalue.length > 3
			&& uservalue.length < 30) {
		console.log('valide name');
		document.getElementById('nameError').innerHTML = '';
	} else {
		console.log('invalide name');
		document.getElementById('nameError').innerHTML = 'Plese enter valide name min 4 and max 30 character';
	}
}

function myFunction() {
	var x = document.getElementById("userPassword");
	if (x.type === "password") {
		x.type = "text";
	} else {
		x.type = "password";
	}
}

</script>
</body>
</html>