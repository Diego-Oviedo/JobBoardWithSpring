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

	 message : ${success}
    <br/>
    <br/>
    Go back to <a href="<c:url value='/All-Applicants' />">List of All Applicants</a>

</body>
</html>