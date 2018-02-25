<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">	
		<script	src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous">	</script>
		<script	src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.js"></script>
		<script src="js/app.js"></script>
		<script src="js/comments.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Tweeter</title>
	</head>
	<body >
		<jsp:include page="header.jsp" />
		<div style="padding:10px">
		<h1>Comments</h1>
		<h4>${tweet.text} </h4>
		<span style="font-size: 10px">${tweet.created} </span>
		<br/>
		<c:forEach var="com" items="${comList}">
			<div  style= "border: 2px solid grey; display: inline-block;">
	  			
	  			<div class="card-body">
		   			 <div class="card-text">${com.text}</div>
		   			 <h5 class="card-header" style="font-size:75%;">${com.user.username} <span style="font-size:90%;">(${com.created})</span>
		   			<a href="${pageContext.request.contextPath}/comment/like/${com.id}" class="btn-xs btn-primary" role="button">Like! (${com.likes})</a>
	  				</h5>
	  			</div>
			</div>
			<br/>
 		</c:forEach>
		</br> 
		<br/>
		<h4>Add Comment</h4>
			<form:form modelAttribute="comment" method="post">
				<form:hidden path="id" />
				<label>Text</label>
				<form:input path="text" />
				<form:hidden path="created" />
				<form:hidden path="tweet" />
				<form:hidden path="user" />
				<form:hidden path="likes" />
		<form:button type="submit">Save</form:button>
	</form:form>
		
		<br/>
		
		<a href="${pageContext.request.contextPath}/main" class="btn-xl btn-primary" role="button">Back</a>
		</div>
		<jsp:include page="footer.jsp" />
		</br>
		<script type="text/javascript">
		var	tweetID	= $('#t1').text();
		$('#c1').text("comment to input")
		
		</script>
		
		
		
		<script type="text/javascript">
			var message = getCookie("message");	
			$.notify(message, 
					{position : "top center",
				 className : "success",
					 autoHideDelay: 2000
					});
		</script>
		<script>
			$(".comButton").click(function() {
 			 $( ".comment" ).toggle();
			});
</script>
		
	
	</body>
</html>