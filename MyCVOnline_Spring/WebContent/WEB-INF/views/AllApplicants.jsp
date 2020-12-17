<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style>
        th{
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
	<tr>
			<th colspan="12">APPLICANTS</th>
	</tr>
	<th>APPLICANT ID</th>
	<th>USERNAME</th>
	<th>NAME</th>
	<th>PROFESSION</th>
	<th>PHONE_NUMBER</th>
	<th>EMAIL</th>
	<th>STREET_ADDRESS</th>
	<th>POSTAL_CODE</th>
	<th>CITY</th>
	<th>COUNTRY</th>
	<th>ABOUT_YOU</th>
	<th>PROFILE_PICTURE</th>

</thead>

	<c:forEach var="applicant" items="${applicants}">
	<tbody>
		<td>${applicant.applicantID}</td>
		<td>${applicant.username}</td>
		<td>${applicant.firstName} ${applicant.lastName}</td>
		<td>${applicant.profession}</td>
		<td>${applicant.phoneNumber}</td>
		<td>${applicant.email}</td>
		<td>${applicant.streetAddress}</td>
		<td>${applicant.city}</td>
		<td>${applicant.province}</td>
		<td>${applicant.country}</td>
		<td>${applicant.aboutYou}</td>
		<td><img width="200" alt="No picture in record" src="/All-Applicants_Pictures?applicantID=${applicant.applicantID}"/>"/></td>
	
	</tbody>
	</c:forEach>


	<a href="<c:url value='New-Applicant' />">Add New Applicant</a>

</body>
</html>