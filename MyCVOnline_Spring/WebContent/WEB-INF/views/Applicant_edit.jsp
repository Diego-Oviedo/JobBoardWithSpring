<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link href="${pageContext.request.contextPath}/resources/CSS/styles_applicants.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/JavaScript/popups.js"></script>
<title>Applicant | Edit Profile</title>
</head>
<body>


	<div class="header">
		<h1>My CV Online</h1>
		<p>
			A <b>resume-generator</b> webapp.
		</p>
	</div>

	<div class="navbar">
		<a href="#" class="active">Home</a> <a
			href="${pageContext.request.contextPath}/Applicants/New-Applicant">Add
			New Applicant</a> <a
			href="${pageContext.request.contextPath}/Applicants/All-Applicants">List
			of All Applicants</a>


		<div class="chip">
			<img src="/All-Applicants_Pictures?applicantID=${applicant.applicantID}" />
			${applicant.firstName} ${applicant.lastName} | ${applicant.username}
		</div>

	</div>


	<div class="main">

		<div class="row">

			<div class="aside_box_left">

				<h2>EDIT APPLICANT</h2>

				<div class="alert ${alert_status_edit_applicant}">
					<span class="closebtn"
						onclick="this.parentElement.style.display='none';">&times;</span>
					<strong>${success}</strong> 
					<strong>${error_editing_applicant}</strong>
				</div>

				<div class="aside_form">

					<form:form method="POST" modelAttribute="applicant">

						<div class="input">
							<form:input path="firstName" id="firstName"
								placeholder="First Name" />
							<br>
							<form:errors path="firstName" class="error" />
						</div>

						<div class="input">
							<form:input path="lastName" id="lastName" placeholder="Last Name" />
							<br>
							<form:errors path="lastName" class="error" />
						</div>

						<div class="input">
							<form:input path="username" id="username" placeholder="Username" />
							<br>
							<form:errors path="username" class="error" />
						</div>

						<div class="input">
							<form:input path="password" id="password" placeholder="Password" />
							<br>
							<form:errors path="password" class="error" />
						</div>

						<div class="input">
							<form:input path="profession" id="profession"
								placeholder="Profession" />
							<br>
							<form:errors path="profession" class="error" />
						</div>

						<div class="input">
							<form:input path="phoneNumber" id="phoneNumber"
								placeholder="Phone Number" />
							<br>
							<form:errors path="phoneNumber" class="error" />
						</div>

						<div class="input">
							<form:input path="email" id="email" placeholder="E-mail" />
							<br>
							<form:errors path="email" class="error" />
						</div>

						<div class="input">
							<form:input path="streetAddress" id="streetAddress"
								placeholder="Address" />
							<br>
							<form:errors path="streetAddress" class="error" />
						</div>

						<div class="input">
							<form:input path="postalCode" id="postalCode"
								placeholder="Postal Code" />
							<br>
							<form:errors path="postalCode" class="error" />
						</div>

						<div class="input">
							<form:input path="city" id="city" placeholder="City" />
							<br>
							<form:errors path="city" class="error" />
						</div>

						<div class="input">
							<form:input path="province" id="province" placeholder="Province" />
							<br>
							<form:errors path="province" class="error" />
						</div>

						<div class="input">
							<form:input path="country" id="country" placeholder="Country" />
							<br>
							<form:errors path="country" class="error" />
						</div>

						<div class="input">
							<form:textarea path="aboutYou" id="aboutYou"
								placeholder="About you" />
							<br>
							<form:errors path="aboutYou" class="error" />
						</div>

						<input class="update_button" type="submit" value="Update" />


					</form:form>

					<button class="delete_button"
						onclick="document.getElementById('id01').style.display='block'">Delete</button>

					<div id="id01" class="modal">
						<span
							onclick="document.getElementById('id01').style.display='none'"
							class="close" title="Close Modal">×</span>
						<form class="modal-content" action="/action_page.php">
							<div class="container">
								<h1>Delete Account</h1>
								<p>Are you sure you want to delete your account?</p>

								<div class="clearfix">
									<button type="button"
										onclick="document.getElementById('id01').style.display='none'"
										class="cancelbtn">Cancel</button>
									<button type="button"
										onclick="document.getElementById('id01').style.display='none'"
										class="deletebtn">
										<a href="${pageContext.request.contextPath}/Applicants/delete-${applicant.applicantID}-applicant">Delete</a>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<br>

				<div class="aside_box">
					<h3>My Skills</h3>
					<div class="fakeimg" style="height: 60px;">Image</div>
					<br>
					<div class="fakeimg" style="height: 60px;">Image</div>
					<br>
					<div class="fakeimg" style="height: 60px;">Image</div>
				</div>

			</div>

			<div class="aside_right">

				<div class="aside_box">

					<div class="aside_box">
						<h2>Experience</h2>

						<div class="alert ${alert_status_edit_applicant_experience}">
							<span class="closebtn"
								onclick="this.parentElement.style.display='none';">&times;</span>
							<strong>${success_deleting_applicant_experience}</strong> 
							<strong>${success_adding_applicant_experience}</strong>
						</div>

						<c:forEach items="${applicant_experiences}" var="experience">
							<h3>${experience.experienceTitle}</h3>
							${experience.companyName}
							<br>
							${experience.startDate} - ${experience.endDate}
							<p>${experience.description}</p>
							<br>

							<a class="delete_button"
								href="${pageContext.request.contextPath}/Applicants/delete_applicant_${experience.experienceTitle}_experience-${applicant.applicantID}">Delete</a>

							<br>
							<br>
						</c:forEach>
						
					</div>

					<div class="aside_form">

						<div class="alert ${alert_status_add_applicant_experience}">
							<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
							<strong>${error_adding_applicant_experience}</strong> 
							<strong>${success_adding_applicant_experience}</strong>
						</div>


						<form:form method="POST" modelAttribute="experience"
							action="add_applicant_experience-${applicant.applicantID}">

							<div class="input">
								<form:input path="experienceTitle" placeholder="Title" />
								<br>
								<form:errors path="experienceTitle" class="error" />
							</div>

							<div class="input">
								<form:input path="companyName" placeholder="Company Name" />
								<br>
								<form:errors path="companyName" class="error" />
							</div>

							<div class="input">
								<form:input type="date" path="startDate"
									placeholder="Start Date" />
								<br>
								<form:errors path="startDate" class="error" />
							</div>

							<div class="input">
								<form:input type="date" path="endDate" placeholder="End date" />
								<br>
								<form:errors path="endDate" class="error" />
							</div>

							<div class="input">
								<form:input path="description" placeholder="Description" />
								<br>
								<form:errors path="description" class="error" />
							</div>

							<input class="update_button" type="submit" />

						</form:form>

					</div>
					
				</div>
				
				
				<div class="aside_box">

					<div class="aside_box">
						<h2>Education</h2>

						<div class="alert ${alert_status_edit_applicant_education}">
							<span class="closebtn"
								onclick="this.parentElement.style.display='none';">&times;</span>
							<strong>${success_deleting_applicant_education}</strong> 
							<strong>${success_adding_applicant_education}</strong>
						</div>

						<c:forEach items="${applicant_educations}" var="education">
							<h3>${education.educationTitle}</h3>
							${education.schoolName}
							<br>
							${education.startDate} - ${education.endDate}
							<p>${education.description}</p>
							<br>

							<a class="delete_button"
								href="${pageContext.request.contextPath}/Applicants/delete_applicant_${education.educationTitle}_education-${applicant.applicantID}">Delete</a>

							<br>
							<br>
						</c:forEach>
						
					</div>

					<div class="aside_form">

						<div class="alert ${alert_status_add_applicant_education}">
							<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
							<strong>${error_adding_applicant_education}</strong> 
							<strong>${success_adding_applicant_education}</strong>
						</div>


						<form:form method="POST" modelAttribute="education"
							action="add_applicant_education-${applicant.applicantID}">

							<div class="input">
								<form:input path="educationTitle" placeholder="Title" />
								<br>
								<form:errors path="educationTitle" class="error" />
							</div>

							<div class="input">
								<form:input path="schoolName" placeholder="School Name" />
								<br>
								<form:errors path="schoolName" class="error" />
							</div>

							<div class="input">
								<form:input type="date" path="startDate"
									placeholder="Start Date" />
								<br>
								<form:errors path="startDate" class="error" />
							</div>

							<div class="input">
								<form:input type="date" path="endDate" placeholder="End date" />
								<br>
								<form:errors path="endDate" class="error" />
							</div>

							<div class="input">
								<form:input path="description" placeholder="Description" />
								<br>
								<form:errors path="description" class="error" />
							</div>

							<input class="update_button" type="submit" />

						</form:form>

					</div>
					
				</div>
				
			</div>

		</div>
	</div>



</body>
</html>