<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1 class="text-danger">Edit <c:out value="${course.name}"/></h1><br>
		
		
	<form:form action="/edit/${course.id}" method="post" modelAttribute="course">
	<input type="hidden" name="_method" value="put">
	<div class="form-group">
    <p>
        <form:label path="name">Name</form:label> 
        <form:errors path="name"/>
        <form:input path="name" placeholder="name of event"/>
    </p>
    </div>
    <div class="form-group">
    <p>
        <form:label path="instructor">Date</form:label>
        <form:errors path="instructor"/>
        <form:input path="instructor" type="text"/>
    </p>
    </div>
    <div class="form-group">
    <p>
        <form:label path="capacity">Capacity:</form:label>
        <form:input type="text" path="capacity"/>
    </p> 
    </div>
    <%-- <form:hidden path="planner" value="${user.id}"/> --%>
    <input type="submit" class="btn btn-primary" value="Update"/>
</form:form> 
</div>
	
</body>
</html>