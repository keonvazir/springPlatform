<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="container" style="text-align: center; display:inline-block;"><br>
		
		<h1 class="text-danger" style="display: inline-block;"><c:out value="${user.firstname}"/></h1><a href="/logout" style="display: inline-block; vertical-align: top; margin-left: 130px; margin-top: 10px">Logout</a><br><br>
		
		<p class="text-success" style="margin-right: 145px;">Here are some of the events in your state:</p><br>
		<table class="table">
    	<thead class="thead-dark">
        <tr>
        	
            <th scope="col">Name</th>
            <th scope="col">Date</th>
            <th scope="col">Location</th>
            <th scope="col">Host</th>
            <th scope="col">Action/Status</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach items="${eventsIn}" var="event">
        <tr>
        	<th class="bg-primary"><a href="/events/${event.id}"><span class="text-warning"><c:out value="${event.name}"/></span></a></th>
            <td class="bg-success"><c:out value="${event.date}"/></td>
            <td class="bg-warning"><c:out value="${event.location}"/></td>
            <td class="bg-danger"><c:out value= "${event.planner.firstname}"/></td>
            
            <td class="bg-info">
             
             <c:if test ="${event.planner.id == user.id}">
             <a href="#"><span class="text-warning">Edit</span></a><span class="text-danger"> | </span>
             <a href="#"><span class="text-warning">Delete</span></a></c:if>
             <c:if test = "${event.planner.id != user.id}">
            <a href="#"><span class="text-warning">Join </span></a></c:if></td>
            
           
        </tr>
        </c:forEach>
    </tbody>
</table><br><br>
<p class="text-info" style="margin-right: 145px;">Here are some of the events in other states:</p><br>
<table class="table">
    <thead class="thead-dark">
        <tr>
        	
            <th scope="col">Name</th>
            <th scope="col">Date</th>
            <th scope="col">Location</th>
            <th scope="col">State</th>
            <th scope="col">Host</th>
            <th scope="col">Action</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach items="${eventsOut}" var="event">
        <tr>
        	<th class="bg-primary"><a href="#"><span class="text-warning"><c:out value="${event.name}"/></span></a></th>
            <td class="bg-success"><c:out value="${event.date}"/></td>
            <td class="bg-warning"><c:out value="${event.location}"/></td>
            <td class="bg-success"><c:out value="${event.state}"/></td>
            <td class="bg-danger"><c:out value="${event.planner.firstname}"/></td>
            <td class="bg-info"><a href="#"><span class="text-warning">Join</span></a>
        </tr>
        </c:forEach>
    </tbody>
</table><br><br>
<div class="create" style="display: inline-block; margin-right: 230px;">
<h3 class="text-primary" style="margin-right: 0px;">Create an Event</h3><br>

 <form:form action="/events/create" method="post" modelAttribute="event">
	<div class="form-group">
    <p>
        <form:label path="name">Name</form:label> 
        <form:errors path="name"/>
        <form:input path="name" placeholder="name of event"/>
    </p>
    </div>
    <div class="form-group">
    <p>
        <form:label path="date">Date</form:label>
        <form:errors path="date"/>
        <form:input path="date" type="date"/>
    </p>
    </div>
    <div class="form-group">
    <p>
        <form:label path="location">Location:</form:label>
        <form:input type="text" path="location"/>
       <form:select path="state">
        	<c:forEach items="${states}" var="state">
            <form:option value="${state}">${state}</form:option>
        </c:forEach>
        </form:select>
    </p> 
    </div>
    <input type="submit" class="btn btn-primary" value="Create"/>
</form:form> 
</div>
</div>
</body>
</html>