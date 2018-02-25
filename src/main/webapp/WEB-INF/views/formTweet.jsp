<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>
<body >
<jsp:include page="header.jsp" />

<div style="padding:10px">
	<h2>Add Tweet</h2>
	<form:form modelAttribute="tweet" method="post">
		<form:hidden path="id" />

		<label>Text</label>
		<form:errors path="text" />
		<form:input path="text" />
		
		<form:hidden path="created" />
		
		<form:button type="submit">Save</form:button>
	</form:form>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>