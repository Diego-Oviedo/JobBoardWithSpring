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
<link
  href="${pageContext.request.contextPath}/resources/CSS/styles_companies.css"
  rel="stylesheet" type="text/css">
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

    <div class="row">

      <div class="aside_box_left">
          
          <div class="aside_box">
            <p>
            ${applicant.firstName} ${applicant.lastName} <br>
            <i>${applicant.phoneNumber}<br>
            ${applicant.email}<br>
            ${applicant.streetAddress},${applicant.postalCode} <br> 
            ${applicant.city}, ${applicant.province},
            ${applicant.country}.<br> 
            ${applicant.profession}</i>
          </p>

          <h3>About Me:</h3>
          <p>${applicant.aboutYou}</p>
		  <br>
		  <a href="${pageContext.request.contextPath}/Applicants/edit-${applicant.applicantID}-applicant">Edit Applicant</a>
          </div>
        
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
          <h2>Experience</h2>
          
				<div class="experience_module">
				<c:forEach items="${applicant_experiences}" var="experience">
					<h3>${experience.experienceTitle}</h3>
					<samp>${experience.companyName}</samp>
					<br>
					<span>${experience.startDate} - ${experience.endDate}</span>
					<p>${experience.description}</p>
					<br><br>
				</c:forEach>
				</div>
        </div>    
        
        <br>  

       <div class="aside_box">
          <h2>Education</h2>
          
				<div class="experience_module">
				<c:forEach items="${applicant_educations}" var="education">
					<h3>${education.educationTitle}</h3>
					<samp>${education.schoolName}</samp>
					<br>
					<span>${education.startDate} - ${education.endDate}</span>
					<p>${education.description}</p>
					<br><br>
				</c:forEach>
				</div>
        </div> 


    </div>
  </div>


  <script>
  
  // Get the X buttom from the alert
   // When the user clicks in the X of the alert, close it
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
      
      
    // Get the modal
      var modal = document.getElementById('id01');

      // When the user clicks anywhere outside of the modal, close it
      window.onclick = function(event) {
        if (event.target == modal) {
          modal.style.display = "none";
        }
      }
    </script>

</body>
</html>