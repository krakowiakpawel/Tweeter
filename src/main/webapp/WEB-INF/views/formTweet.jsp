<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>


<body>
	<h1>Add Tweet</h1>
	<form:form modelAttribute="tweet" method="post">
		<form:hidden path="id" />


		<label>title</label>
		<form:errors path="title" />
		<form:input path="title" />

		<label>tweetText</label>
		<form:errors path="tweetText" />
		<form:input path="tweetText" />
		
		<form:hidden path="created" />
		
		
		<label>User</label>
		<form:errors path="user" />
		<form:select itemValue="id" itemLabel="firstName" path="user" items="${Users}" />

		<form:button type="submit">Save</form:button>
	</form:form>
</body>
</html>