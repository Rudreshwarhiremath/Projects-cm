<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
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
				<div>
				<a href="LoginSucess.jsp" class="btn btn-info">Home</a>
			<span style="color: white;">Welcome:${userID}</span> <img
				src="download?fileName=${dtoPic}" height="90" width="80">
				</div>
		</div>
	</nav>
<div align="center">
	<form action="addTechnology" method="post">
	<input type="hidden" value="${userID}" name="userId" readonly="readonly" >
	<table>	
    <tr><td>Technology Name </td> <td> <input type="text" name="teName" value="${tech.teName}"></td></tr>
	<tr> <td>	Technology Language  </td> <td> <input type="text" name="teLangauge" value="${tech.teLangauge}"> </td></tr>
	<tr> <td>	Technology version  </td> <td> <input type="text" name="teVersion" value="${tech.teVersion}"></td>    </tr> 
	<tr> <td>	Technology Owner </td> <td>  <input type="text" name="teOwner" value="${tech.teOwner}"></td>       </tr>
	<tr> <td>	Support From  </td> <td>   <input type="date" name="teSupportFrom" value="${tech.teSupportFrom}"></td>            </tr>
	<tr> <td>	Support to  </td> <td> <input type="date" name="teSupportTo" value="${tech.teSupportTo}"></td>               </tr>
	<tr> <td>	License  </td> <td>  <input type="text" name="teLicense" value="${tech.teLicense}"></td>               </tr>
	<tr> <td>	Open source </td> <td>Yes <input type="radio" name="teOpenSource" value="true" >
	                                   No <input type="radio" name="teOpenSource" value="false">  </td>            </tr>
	<tr> <td>	OS Type </td> <td> 
	<select name="teOsType">
	<option value="${tech.teOsType}">SELECT</option>
	<c:forEach items="${type}" var="p">
				<option value="${p}">${p}</option>
			</c:forEach>
	</select>  </td>           </tr>
	 </table>
		<input type="submit" value="Add To Profile" class="btn btn-success">
	</form>
	<span style="color: red">${msgtech}</span>
<span style="color: green;">${techmsg}</span>
</div>
</body>
</html>