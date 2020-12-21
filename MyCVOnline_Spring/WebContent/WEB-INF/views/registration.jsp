<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
  
    .error {
        color: #ff0000;
    }
</style>

<title>Applicant | Registration</title>
</head>
<body>

 <h2>Registration Form</h2>
   
   <br>${error_adding_applicant}<br>
   
    <form:form method="POST" modelAttribute="applicant">
        <form:input type="hidden" path="applicantID" id="applicantID"/>
        <table>
            <tr>
                <td><label for="firstName">First Name: </label> </td>
                <td><form:input path="firstName" id="firstName"/></td>
                <td><form:errors path="firstName" cssClass="error"/></td>
            </tr>
            
             <tr>
                <td><label for="lastName">Last Name: </label> </td>
                <td><form:input path="lastName" id="lastName"/></td>
                <td><form:errors path="lastName" cssClass="error"/></td>
            </tr>
          
            <tr>
                <td><label for="username">Username: </label> </td>
                <td><form:input path="username" id="username"/></td>
                <td><form:errors path="username" cssClass="error"/></td>
            </tr>
            
           	<tr>
                <td><label for="password">Password: </label> </td>
                <td><form:input path="password" id="password" placeholder="${applicant.password}"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="profession">Profession: </label> </td>
                <td><form:input path="profession" id="profession"/></td>
                <td><form:errors path="profession" cssClass="error"/></td>
            </tr>
      
            <tr>
                <td><label for="phoneNumber">Phone Number: </label> </td>
                <td><form:input path="phoneNumber" id="phoneNumber"/></td>
                <td><form:errors path="phoneNumber" cssClass="error"/></td>
            </tr>
            
             <tr>
                <td><label for="email">E-mail: </label> </td>
                <td><form:input path="email" id="email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="streetAddress">Address : </label> </td>
                <td><form:input path="streetAddress" id="streetAddress"/></td>
                <td><form:errors path="streetAddress" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="postalCode">Postal Code: </label> </td>
                <td><form:input path="postalCode" id="postalCode"/></td>
                <td><form:errors path="postalCode" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="city">City: </label> </td>
                <td><form:input path="city" id="city"/></td>
                <td><form:errors path="city" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="province">Province: </label> </td>
                <td><form:input path="province" id="province"/></td>
                <td><form:errors path="province" cssClass="error"/></td>
            </tr>
            
            
            <tr>
                <td><label for="country">Country: </label> </td>
                <td><form:input path="country" id="country"/></td>
                <td><form:errors path="country" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="aboutYou">About you: </label> </td>
                <td><form:input path="aboutYou" id="aboutYou"/></td>
                <td><form:errors path="aboutYou" cssClass="error"/></td>
            </tr>
            
      
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="${pageContext.request.contextPath}/Applicants/All-Applicants">List of All Applicants</a>

</body>
</html>