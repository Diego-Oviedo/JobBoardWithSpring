<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Applicant List</title>
</head>
<body>


Applicants:  <br> 

<table>

<thead>

	<th>APPLICANT ID</th>
	<th>NAME</th>
	<th>PROFESSION</th>

</thead>

	<c:forEach var="applicant" items="${applicants}">
	<tbody>
		<td>${applicant.nombre}</td>
		<td>${applicant.appellido} ${applicant.lastName}</td>
		<td>${applicant.profession}</td>
	
	
	</tbody>
	</c:forEach>


</table>

</body>
</html>