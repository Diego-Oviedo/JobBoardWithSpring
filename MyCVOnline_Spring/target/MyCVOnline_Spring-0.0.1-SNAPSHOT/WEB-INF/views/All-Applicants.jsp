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

<title>Applicant | Applicants List</title>
</head>
<body>


Applicants:  <br>

	<div class="alert ${alert_status}">
		<span class="closebtn"
			onclick="this.parentElement.style.display='none';">&times;</span> <strong>${success}</strong>
		<strong>${error_editing_applicant}</strong>
	</div>

	<table>

<thead>
	<tr>
			<th colspan="14">APPLICANTS</th>
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
	<th>PROVINCE</th>
	<th>COUNTRY</th>
	<th>ABOUT_YOU</th>
	<th>PROFILE_PICTURE</th>
	<th>ACTION</th>

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
		<td>${applicant.postalCode}</td>
		<td>${applicant.city}</td>
		<td>${applicant.province}</td>
		<td>${applicant.country}</td>
		<td>${applicant.aboutYou}</td>
		<td><img width="200" alt="No picture in record" src="/All-Applicants_Pictures?applicantID=${applicant.applicantID}"/>"/></td>
		<td><a href="${pageContext.request.contextPath}/Applicants/view-${applicant.applicantID}-applicant">Edit Applicant</a></td>
	
	</tbody>
	</c:forEach>


	<a href="${pageContext.request.contextPath}/Applicants/New-Applicant">Add New Applicant</a> 


		<script>
			var close = document.getElementsByClassName("closebtn");
			var i;

			for (i = 0; i < close.length; i++) {
				close[i].onclick = function() {
					var div = this.parentElement;
					div.style.opacity = "0";
					setTimeout(function() {
						div.style.display = "none";
					}, 600);
				}
			}
		</script>
</body>
</html>