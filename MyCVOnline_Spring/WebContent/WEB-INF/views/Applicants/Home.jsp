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
<title>Applicant | Profile</title>
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
      href="${pageContext.request.contextPath}/Applicants/New-Applicant">Add New Applicant</a> <a
      href="${pageContext.request.contextPath}/Applicants/All-Applicants">List
      of All Applicants</a> 
      

    <div class="chip">
      <img src="/All-Applicants_Pictures?applicantID=${applicant.applicantID}"/>
      ${applicant.firstName} ${applicant.lastName} | ${applicant.username}
    </div>
  </div>


  <div class="main">

  </div>


</body>
</html>