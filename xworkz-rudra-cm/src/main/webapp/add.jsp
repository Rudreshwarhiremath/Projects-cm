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
				alt="" width="80" height="48" class="d-inline-block align text-top"></a>
				<a href="LoginSucess.jsp">Home</a>
			<span style="color: white;">Welcome:${userID}</span> <img
				src="download?fileName=${dtoPic}" height="50" width="80">
		</div>
	</nav>
<div align="center">
	<form action="addTechnology" method="post">
	<input value="${userID}" name="userId" readonly="readonly" >
	<table>	
    <tr><td>Technology Name </td> <td> <input type="text" name="t_name" value="${tech.t_name}"></td></tr>
	<tr> <td>	Technology Language  </td> <td> <input type="text" name="t_langauge" value="${tech.t_langauge}"> </td></tr>
	<tr> <td>	Technology version  </td> <td> <input type="text" name="t_version" value="${tech.t_version}"></td>    </tr> 
	<tr> <td>	Technology Owner </td> <td>  <input type="text" name="t_owner" value="${tech.t_owner}"></td>       </tr>
	<tr> <td>	Support From  </td> <td>   <input type="text" name="t_supportFrom" value="${tech.t_supportFrom}"></td>            </tr>
	<tr> <td>	Support to  </td> <td> <input type="text" name="t_supportTo" value="${tech.t_supportTo}"></td>               </tr>
	<tr> <td>	License  </td> <td>  <input type="text" name="t_license" value="${tech.t_license}"></td>               </tr>
	<tr> <td>	Open source </td> <td> <input type="text" name="t_openSource" value="${tech.t_openSource}"></td>            </tr>
	<tr> <td>	OS Type </td> <td> <input type="text" name="t_osType" value="${tech.t_osType}"></td>               </tr>
	 </table>
		<input type="submit" value="Add">
	</form>
<span style="color: green;">${techmsg}</span>
</div>
</body>
</html>