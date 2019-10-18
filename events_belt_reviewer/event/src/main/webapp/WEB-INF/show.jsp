<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<h1 class="text-danger"><c:out value="${event.name}"/></h1><br>
		<p>Host: <span class="text-primary"><c:out value="${event.planner.firstname}"/></span></p>
		<p>Date: <span class="text-info"><fmt:formatDate pattern="MMMM dd, yyyy" value="${event.date}"/></span></p>
		<p>Location: <span class="text-warning"><c:out value="${event.location}"/></span></p>
		<p>People who are attending this event: <span class="text-success"><c:out value="${event.attendees.size()}"/></span></p><br><br>
		
	<table class="table">
    <thead class="thead-dark">
        <tr>
        	
            <th scope="col">Name</th>
            <th scope="col">Location</th>
   
        </tr>
    </thead>
   <tbody>
        <c:forEach items="${event.attendees}" var="attendee">
        <tr>
        	<th class="bg-primary"><a href="#"><span class="text-warning"><c:out value="${attendee.firstname}"/></span></a></th>
            <td class="bg-success"><c:out value="${attendee.location}"/></td>
            
        </tr>
        </c:forEach>
    </tbody>
</table><br><br>
</div>
</body>
</html>