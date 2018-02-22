<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>header page</h1>
<a href="${pageContext.request.contextPath}/home">HOME</a></br>
<a href="${pageContext.request.contextPath}/tweet/add">Add new Tweet</a></br>
<a href="${pageContext.request.contextPath}/messages">Messages</a></br>
Welcome ${user.username}!
	<a href="${pageContext.request.contextPath}/logout">Logout</a>
	</br>

</body>
</html>