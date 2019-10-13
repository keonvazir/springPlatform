<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page isErrorPage="true" %> 
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<br>
	<div class="container" style="text-align: center">
	<h1>Contact Info</h1>
	<br>
	<form:form action="/contact/new" method="post" modelAttribute="contactObj">
	<div class="form-group">
 		<p>
 			<form:select path="student">
 			<c:forEach items="${students}" var="student">
 			
 			<form:option value="${student.id}">
 			<c:out value="${student.firstname}"/><c:out value="${student.lastname}"/>
 			</form:option>
 			
 			</c:forEach>
 			</form:select>
 		</p>
    </div>
    <div class="form-group">
    <p>
        <form:label path="address">Address</form:label>
        <form:errors path="address"/>
        <form:input path="address" placeholder="Address"/>
    </p>
    </div>
    <div class="form-group">
    <p>
        <form:label path="city">City</form:label>
        <form:errors path="city"/>
        <form:input path="city" placeholder="City"/>
    </p>
    </div>
    <div class="form-group">
    <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input path="state" placeholder="State"/>
    </p>
    </div>
    <input type="submit" class="btn btn-primary" value="Create"/>
</form:form> <br>
<a href="/students"><i>Back...</i></a>
</div>
</body>
</html>