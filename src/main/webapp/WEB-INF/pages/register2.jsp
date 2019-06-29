<%@page import="javax.servlet.jsp.tagext.Tag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <h1>Book App</h1>

<form:form method="POST"  modelAttribute="bookCmd">

<table border="1">
<tr>
	<td>EntER Book Name :- </td>
	<td><form:input path="bname"/></td>
</tr>

<tr>
	<td>EntER Book Author :- </td>
	<td><form:input path="bauthor"/></td>
</tr>

<tr>
	<td>EntER Book Price :- </td>
	<td><form:input path="bprice"/></td>
</tr>



<tr align="center">
	<td><input type="submit" value="Submit"/></td> &nbsp;&nbsp;&nbsp;&nbsp;
	<td><input type="reset" value="Reset"/></td>
</tr>
	
</table>
</form:form>

<%-- <hr>
<c:forEach var="book" items="${books }">
<h6><br>  ${book.bookid } </h6>
<h6><br>  ${book.bookname } </h6>
<h6><br>  ${book.author } </h6>
<h6><br>  ${book.bookprice } </h6>
</c:forEach> --%>
<%-- <c:if test="${!empty books }">
	<c:forEach var="book" items="${books }">
		<p align="center">book.bookid</p>&nbsp;&nbsp;&nbsp;&nbsp;
		<p align="center">book.bookname</p>&nbsp;&nbsp;&nbsp;&nbsp;
		<p align="center">book.author</p>&nbsp;&nbsp;&nbsp;&nbsp;
		<p align="center">book.bookprice</p>&nbsp;&nbsp;&nbsp;&nbsp;
	</c:forEach>	
</c:if> 
 --%>


<br>
<hr>

<c:choose>
	<c:when test="${!empty listmodel }">
<table border="1">
	<tr>
		
		<th>Book Name</th>
		<th>Book Author</th>
		<th>Book Price</th>
	</tr>
	
	<c:forEach var="bdata" items="${listmodel}">
		<tr  style="color:green">
			
			<td>${bdata.bname }</td>
			<td>${bdata.bauthor }</td>
			<td>${bdata.bprice }</td>
		</tr>
	</c:forEach>
	</table>
</c:when>
</c:choose>