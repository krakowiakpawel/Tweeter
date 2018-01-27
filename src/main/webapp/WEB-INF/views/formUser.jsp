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
	<h1>Add User</h1>
	<form:form modelAttribute="user" method="post">
		<form:hidden path="id" />

		<label>firstName</label>
		<form:errors path="firstName" />
		<form:input path="firstName" />

		<label>lastName</label>
		<form:errors path="lastName" />
		<form:input path="lastName" />

		<label>email</label>
		<form:errors path="email" />
<form:input path="email" />


		<form:button type="submit">Save</form:button>
	</form:form>
</body>
</html>