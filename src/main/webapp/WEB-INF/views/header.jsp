<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">	
		<script	src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous">	</script>
		<script	src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.js"></script>
		<script src="js/app.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Tweeter</title>
	</head>
	<body>
		<nav class="navbar navbar-inverse">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <a class="navbar-brand" href="${pageContext.request.contextPath}/">Home page</a>
			    </div>
			    <ul class="nav navbar-nav">
			      <li><a href="${pageContext.request.contextPath}/tweet/add">Add new Tweet</a></li>
			      <li><a href="${pageContext.request.contextPath}/messages">Messages</a></li>
			    </ul>
			    <ul class="nav navbar-nav navbar-right">
     			  <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
   				</ul>
			  </div>
		</nav>
	</body>
</html>



