<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script
	  src="https://code.jquery.com/jquery-3.3.1.min.js"
	  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	  crossorigin="anonymous"></script>
	
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Users</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/user/add">Add new User</a>
	<ul>
		<c:forEach items="${users}" var="user">
			<li>
				${user.id} - ${user.firstName} - ${user.lastName} - ${user.email}
			<a class="confirm"href="${pageContext.request.contextPath}/user/delete/${user.id}">Delete</a>
			<a href="${pageContext.request.contextPath}/user/edit/${user.id}">edit</a>
			</li>
		</c:forEach>
	</ul>

	<script>
		$(document).ready(function() {
		    $('.confirm').click(function(e) {
		        e.preventDefault();
		        if (window.confirm("Are you sure?")) {
		            location.href = this.href;
		        }
		    });
		});
	</script>
</body>
</html>