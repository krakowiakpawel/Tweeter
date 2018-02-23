<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>
<jsp:include page="header.jsp" />
<body bgcolor="#E6E6FA">
	<h1>Add Tweet</h1>
	<form:form modelAttribute="tweet" method="post">
		<form:hidden path="id" />

		<label>text</label>
		<form:errors path="text" />
		<form:input path="text" />
		
		<form:hidden path="created" />
		
		<form:button type="submit">Save</form:button>
	</form:form>
<jsp:include page="footer.jsp" />
</body>
</html>