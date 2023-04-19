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
      <a href="SignIn.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a>
      <a href="LoginSucess.jsp">Home</a>
     <span style="color: white;">Welcome:${userID}</span>
       <img src="download?fileName=${dtoPic}" height="50" width="80">
		</div>
	</nav>
	<div align="center">
				<form action="upload" method="post" enctype="multipart/form-data">
		<table>
	<tr>
		<td> Email </td>    <td><input type="email" name="email" id="emailId" onchange="valideEmail()" value="${udto.email}" readonly="readonly">
		 <span id="emailError" style="color: red"></span>
		<span id="display" style="color: red"></span></td> </tr>
		<tr> <td>	User ID </td>
		
	 <td>	<input type="text" name="userId" id="userName" onchange="ValideName()" value="${udto.userId}"> 
		<span id="nameError" style="color: red"></span>
		<span id="displayUserName" style="color: red"></span> </td>
		</tr>
	<tr><td>	 Mobile Number </td>  <td><input type="number" name="mobile" id="userMobile" onchange="ValideMobile()" value="${udto.mobile}">
		<span id="mobileError" style="color: red"></span>
		<span id="displayUserMobile" style="color: red"></span></td>  </tr>
	
	
	<tr> <td> Set Profile Pic:</td><td> <input type="file" name="chitra" > <span style="color: red">${error}</span>  </td> </tr>
	 
	 </table>
	<div> <button type="submit" class="btn btn-success">Update</button> </div>
	
	
		</form>

</div>
	<script>

		function ValideName() {
			var user = document.getElementById('userName');
			var uservalue = user.value;
			console.log(uservalue);
			if (uservalue != null && uservalue != "" && uservalue.length > 3
					&& uservalue.length < 30) {
				console.log('valide name');
				const xhttp = new XMLHttpRequest();
				console.log('Running in ajax');
				console.log(user);
				console.log(uservalue);
				
				xhttp.open("GET", "http://localhost:8088/xworkz-rudra-cm/userName/"+ uservalue);
				xhttp.send();

				xhttp.onload = function() {
					console.log(this);

					document.getElementById("displayUserName").innerHTML = this.responseText

				}
				var agree = document.getElementById('agreementConfirm');
				console.log(agree.checked);
				document.getElementById('nameError').innerHTML = '';
			} else {
				console.log('invalide name');
				document.getElementById('submitId').disabled = 'disabled';
				document.getElementById('nameError').innerHTML = 'Plese enter valide name min 4 and max 30 character';
			}

		}
		function valideEmail() {
			var userEmail = document.getElementById('emailId');
			var userEmailvalue = userEmail.value;
			console.log(userEmailvalue);
			if (userEmailvalue != null && userEmailvalue != ""
					&& userEmailvalue.length > 4 && userEmailvalue.length < 40) {
				console.log('valide email');
				const xhttp = new XMLHttpRequest();
				console.log('Running in ajax');
				console.log(userEmailvalue);
				xhttp.open("GET", "http://localhost:8088/xworkz-rudra-cm/email/"
						+ userEmailvalue);
				xhttp.send();

				xhttp.onload = function() {
					console.log(this);

					document.getElementById("display").innerHTML = this.responseText
				}
				document.getElementById('emailError').innerHTML = '';
			} else {
				console.log('invalide email');
				document.getElementById('emailError').innerHTML = 'Plese enter valide email min 4 and max 40 charactes ';
			}

		}
		function ValideMobile() {
			var userMobile = document.getElementById('userMobile');
			var userMobilevalue = userMobile.value;
			console.log(userMobilevalue);
			if (userMobilevalue != null && userMobilevalue != ""
					&& userMobilevalue.length == 10) {
				console.log('valide mobile');
				const xhttp = new XMLHttpRequest();
				console.log('Running in ajax');
				console.log(userMobilevalue);
				xhttp.open("GET", "http://localhost:8088/xworkz-rudra-cm/mobile/"
						+ userMobilevalue);
				xhttp.send();

				xhttp.onload = function() {
					console.log(this);

					document.getElementById("displayUserMobile").innerHTML = this.responseText

				}
				document.getElementById('mobileError').innerHTML = '';
			} else {
				console.log('invalide mobile');
				document.getElementById('mobileError').innerHTML = 'Plese enter valide Mobile Number digits must be 10';
			}

		}
	</script>
	
	
	
</body>
</html>