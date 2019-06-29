<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 





	

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src='https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js'></script>


<script type="text/javascript">
$(function() {

  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='register']").validate({
	  
    // Specify validation rules
    rules: {
    	
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      bookName: "required",
      bookAuthor: "required",
      emailId: {
        required: true,
        // Specify that email should be validated
        // by the built-in "email" rule
        email: true
      },
      phoneNo: {
        required: true,
        minlength: 10
        
      }
      },
      
    // Specify validation error messages
    messages: {
      firstName: "Please enter your firstname",
      lastName: "Please enter your lastname",

      phoneNo: {
        required: "Please provide a phone no",
        minlength: "Your phone no  must be at 10 digit"
      },
      email: {
        required: "Please provide a valid user name",
        email: "Please enter a valid email address"
      }
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
    
      form.submit();
    }
  });
});
</script>
<head>
<meta charset="ISO-8859-1">
<title>RegisterForm</title>

<style type="text/css">
		body{
			
						/* background: #C0C0C0; */
						/* background-image: url("C:/Users/vipinsingh/Desktop/s.jpg"); */
						<link rel="stylesheet" type="text/css" href="s.jpg">

		}
	</style>
</head>
<body>

	<h1 style="color: red;text-align: center;">Registration Form</h1>
	
 <h2 style="color: red;"> ${msg}</h2>
  <h2 style="color: red;"> ${msg1}</h2>

	<form:form action="register"  modelAttribute="bookCmd">
	
		
	
		<table align="center" border="2"  width=200 style="color: blue;column-span: all; border-color: red; " >
			<tr >
				<td><b>Book Id::</b></td>
				<td width=400 ><form:input path="bookid" disabled="false" placeholder="Enter BookId" /></td>
			</tr>
			<br>
			<tr>
				<td><b>Book Name::</b></td>
				<td><form:input path="bname" placeholder="Enter Book Name"/></td>
			</tr>
			<br>
			
			<tr>
				<td><b>Author Name::</b></td>
				<td><form:input path="bauthor" placeholder="Enter Book Author"/></td>
			</tr>
			<br>
			<tr>
				<td><b>Price::</b></td>
				<td><form:input path="bprice" placeholder="Enter Book Price"/></td>
			</tr>
			<br>

			<td><input type="reset"  value="Reset"><br>
			<td><input type="submit" name="submit" value="Register">
		</table>
<hr/>	</form:form>




<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:choose>
	<c:when test="${!empty listmodel }">
<table align="center" border="2"  width=200 style="color: blue;column-span: all; border-color: red; " >
	<tr>
		<th>Book No</th>
		<th>Book Name</th>
		<th>Book Author</th>
		<th>Book Price</th>
		<th>Opration</th>
	</tr>
	
	<c:forEach var="bdata" items="${listmodel}">
		<tr  style="color:green">
			<td>${bdata.bookid }</td>
			<td>${bdata.bname }</td>
			<td>${bdata.bauthor }</td>
			<td>${bdata.bprice }</td>
			<td><a href="update?bookid=${bdata.bookid }" onclick="return confirm ('Are u sure!! u want to edit?')" onclick=" edit ">edit</a>
				<a href="delete?bookid=${bdata.bookid }" onclick="return confirm ('Are u sure!! u want to delete?')">delete</a></td>
				
		</tr>
	</c:forEach>
	</table>
</c:when>
</c:choose>
