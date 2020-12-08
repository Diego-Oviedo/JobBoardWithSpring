<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

<title>Applicant | Applicant List</title>
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
		<td>${applicant.username}</td>
		<td>${applicant.firstName} ${applicant.lastName}</td>
		<td>${applicant.profession}</td>
		<td><img width="200" alt="No picture in record" src="/All-Applicants_Pictures?applicantID=${applicant.applicantID}"/>"/></td>
	
	</tbody>
	</c:forEach>

</table>

	<a href="<c:url value='New-Applicant' />">Add New Applicant</a>

</body>
</html>