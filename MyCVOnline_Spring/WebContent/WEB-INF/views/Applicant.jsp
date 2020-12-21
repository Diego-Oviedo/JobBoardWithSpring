<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Applicant | Applicant profile</title>
</head>
<body>

Applicant ID: ${applicant.applicantID} <br>
USERNAME: ${applicant.username} <br>
PASSWORD: ${applicant.password} <br>
FULL NAME: ${applicant.firstName} ${applicant.lastName} <br>
PHONE NUMBER: ${applicant.phoneNumber}<br>
EMAIL: ${applicant.email}<br>
ADDRESS: ${applicant.streetAddress} ${applicant.postalCode} ${applicant.city}, ${applicant.province}, ${applicant.country}.<br>

PROFESSION: ${applicant.profession} <br>


<br>${error_editing_applicant}<br>

<br><br>


 	<form:form method="POST" modelAttribute="applicant">
       
        <table>
            <tr>
                <td><label for="firstName">First Name: </label> </td>
                <td><form:input path="firstName" id="firstName" placeholder="${applicant.firstName}"/></td>
                <td><form:errors path="firstName" cssClass="error"/></td>
            </tr>
            
             <tr>
                <td><label for="lastName">Last Name: </label> </td>
                <td><form:input path="lastName" id="lastName" placeholder="${applicant.lastName}"/></td>
                <td><form:errors path="lastName" cssClass="error"/></td>
            </tr>
          
            <tr>
                <td><label for="username">Username: </label> </td>
                <td><form:input path="username" id="username" placeholder="${applicant.username}"/></td>
                <td><form:errors path="username" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="password">Password: </label> </td>
                <td><form:input path="password" id="password" placeholder="${applicant.password}"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="profession">Profession: </label> </td>
                <td><form:input path="profession" id="profession" placeholder="${applicant.profession}"/></td>
                <td><form:errors path="profession" cssClass="error"/></td>
            </tr>
      
            <tr>
                <td><label for="phoneNumber">Phone Number: </label> </td>
                <td><form:input path="phoneNumber" id="phoneNumber" placeholder="${applicant.phoneNumber}"/></td>
                <td><form:errors path="phoneNumber" cssClass="error"/></td>
            </tr>
            
             <tr>
                <td><label for="email">E-mail: </label> </td>
                <td><form:input path="email" id="email" placeholder="${applicant.email}"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="streetAddress">Address : </label> </td>
                <td><form:input path="streetAddress" id="streetAddress" placeholder="${applicant.streetAddress}"/></td>
                <td><form:errors path="streetAddress" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="postalCode">Postal Code: </label> </td>
                <td><form:input path="postalCode" id="postalCode" placeholder="${applicant.postalCode}"/></td>
                <td><form:errors path="postalCode" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="city">City: </label> </td>
                <td><form:input path="city" id="city" placeholder="${applicant.city}"/></td>
                <td><form:errors path="city" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="province">Province: </label> </td>
                <td><form:input path="province" id="province" placeholder="${applicant.province}"/></td>
                <td><form:errors path="province" cssClass="error"/></td>
            </tr>
            
            
            <tr>
                <td><label for="country">Country: </label> </td>
                <td><form:input path="country" id="country" placeholder="${applicant.country}"/></td>
                <td><form:errors path="country" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="aboutYou">About you: </label> </td>
                <td><form:input path="aboutYou" id="aboutYou" placeholder="${applicant.aboutYou}"/></td>
                <td><form:errors path="aboutYou" cssClass="error"/></td>
            </tr>
            
      
            <tr>
                <td colspan="3">
                            <input type="submit" value="Update"/>
                </td>
                
                <td colspan="3">
                            <a href="${pageContext.request.contextPath}/Applicants/delete-${applicant.applicantID}-applicant">Delete Applicant</a>
                </td>
            </tr>
        </table>
    </form:form>
    
    
    
<a href="${pageContext.request.contextPath}/Applicants/All-Applicants">List of All Applicants</a>

</body>
</html>