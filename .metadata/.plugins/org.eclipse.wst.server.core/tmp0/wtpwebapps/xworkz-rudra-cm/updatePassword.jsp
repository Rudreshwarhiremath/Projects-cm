<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
						<div>
			<a href="index.jsp" class="btn btn-primary">Home</a>
			<a href="signUp.jsp" class="btn btn-primary"> Sign Up</a>
			 <a href="SignIn.jsp" class="btn btn-primary">Login</a>
		</div> 
		</div>

	</nav>

	<div align="center">User Name:${userID}</div>
	<div align="center">
		<form action="passwordUpdate" method="post">
			<table>
				<tr>
					<td>User ID</td>

					<td><input type="text" name="userId" value="${userID}"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>New Password</td>
					<td><input type="password" name="password" id="userPassword">
						<span id="passwordError" style="color: red"></span> <input
						type="checkbox" onclick="myFunction1()">Show Password</td>
				</tr>
				<tr>
					<td>ConfirmPassword</td>
					<td><input type="password" name="confirmPassword"
						id="userConfirmPassword" onblur="ValidePassword()"> <span
						id="passwordCompare" style="color: red"></span> <input
						type="checkbox" onclick="myFunction2()">Show Confirm
						Password</td>
				</tr>
			</table>
			<button type="submit" class="btn btn-success">Update</button>
		</form>
	</div>
	<script>
		function myFunction1() {
			var x = document.getElementById("userPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
		function myFunction2() {
			var x = document.getElementById("userConfirmPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
		function ValidePassword() {
			var userPassword = document.getElementById('userPassword');
			var userConfirmPassword = document
					.getElementById('userConfirmPassword');
			var userPasswordvalue = userPassword.value;
			var userConfirmPasswordvalue = userConfirmPassword.value;
			console.log(userPasswordvalue);
			if (userPasswordvalue != null && userPasswordvalue != ""
					&& userPasswordvalue.length > 4
					&& userPasswordvalue.length < 12) {
				if (userPasswordvalue == userConfirmPasswordvalue) {
					console.log('valide both password are same');
					document.getElementById('passwordCompare').innerHTML = '';

				} else {
					console.log('valide both password are not same');
					document.getElementById('passwordCompare').innerHTML = 'Password and ConfirmPassword are not matching';
				}
				console.log('valide password');
				document.getElementById('passwordError').innerHTML = '';
			} else {
				console.log('invalide password');
				document.getElementById('passwordError').innerHTML = 'Plese enter valide password length must be greater then 4 and less then 12';
			}

		}
	</script>
</body>
</html>