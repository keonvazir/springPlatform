<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-danger"><c:out value="${course.name}"/></h1><br>
		<p>Instructor: <span class="text-primary"><c:out value="${course.instructor}"/></span></p>
		<p>Sign Ups: <span class="text-warning"><c:out value="${course.attendees.size()}"/></span></p>
		
		
	<table class="table">
    <thead class="thead-dark">
        <tr>
        	
            <th scope="col">Name</th>
            <th scope="col">Sign Up Date</th>
            <th scope="col">Action</th>
   
        </tr>
    </thead>
   <tbody>
        <c:forEach items="${course.attendees}" var="attendee">
        <tr>
        	<th class="bg-primary"><a href="#"><span class="text-warning"><c:out value="${attendee.name}"/></span></a></th>
            <td class="bg-success"><fmt:formatDate pattern="MMMM dd, yyyy" value="${attendee.createdAt}"/></td>
            <td class="bg-primary"><a href="/courses/${course.id}/destroy/${attendee.id}"><span class="text-warning">Remove</span></a></td>
            
        </tr>
        </c:forEach>
    </tbody>
</table><br><br>
<a href="/courses/${course.id}/edit"><button class="btn btn-primary">Edit</button></a>
<a href="/courses/${course.id}/destroy"><button class="btn btn-secondary">Delete</button></a>
</div>
	
</body>
</html>