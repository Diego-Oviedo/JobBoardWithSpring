<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Confirmation Page</title>
</head>
<body>

	 <h2>message : ${success}</h2>

	<script>
	  setTimeout(function() {
	      document.location = "${pageContext.request.contextPath}/Applicants/All-Applicants";
	  }, 1000); // <-- this is the delay in milliseconds
	</script>



</body>
</html>