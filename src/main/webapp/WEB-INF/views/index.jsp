<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exam6</title>
</head>
<body>
<div align="center">
<img  height="320px" width="210px"   src="https://data2.cupsell.pl/upload/generator/57322/640x420/1294228_print-trimmed-1.png?resize=max_sizes&key=55f9a22768eed085006592c1174c0235"></img>
<h2>
</br>

<jsp:include page="header.jsp" />
<a href="${pageContext.request.contextPath}/home">HOME</a></br>
<a href="${pageContext.request.contextPath}/user/add">Add new User</a></br>
<a href="${pageContext.request.contextPath}/tweet/add">Add new Tweet</a></br>
<a href="${pageContext.request.contextPath}/user/search-tweets">Search-tweets (Trzeba dodać param "toSearch")</a></br>
<a href="${pageContext.request.contextPath}/user/all">Show all users</a></br>
<jsp:include page="footer.jsp" />
</h2>
</div>
</body>
</html>