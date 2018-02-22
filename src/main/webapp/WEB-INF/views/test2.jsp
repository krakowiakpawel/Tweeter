<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	</br>
	</br>
	<h1>TEST PAGE</h1>
	<p class="myClass">TEST PAGE</p>
</br>
</br>
</br>

	<table>
		<tr>
			<td class="myClass">Element</td>
		</tr>
	</table>
</br>
</br>
</br>
	<script type="text/javascript">
		$(".myClass").notify("I'm to the right of this box")
	</script>
</body>
</html>