<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		
		<h1 class="text-danger" style="display: inline-block;">Welcome, <c:out value="${user.name} !"/></h1><a href="/logout" style="display: inline-block; vertical-align: top; margin-left: 130px; margin-top: 10px">Logout</a><br><br>
		
		<h2 class="text-success" style="margin-right: 145px;">Courses</h2><br>
		<table class="table">
    	<thead class="thead-dark">
        <tr>
        	
            <th scope="col">Course</th>
            <th scope="col">Instructor</th>
            <th scope="col">Signups</th>
            <th scope="col">Action</th>
            
        </tr>
    </thead>
   <tbody>
        <c:forEach items="${courses}" var="course">
        <tr>
        	<th class="bg-primary"><a href="/courses/${course.id}"><span class="text-warning"><c:out value="${course.name}"/></span></a></th>
            
            <td class="bg-warning"><c:out value="${course.instructor}"/></td>
            <td class="bg-danger"><c:out value= "${course.attendees.size()}/"/><c:out value="${course.capacity}"></c:out></td>
            
            <td class="bg-info">
                       
             <a href="/courses/${course.id}/add"><span class="text-warning">Add </span></a>
            
           </td>
        </tr>
        </c:forEach>
    </tbody>
</table><br><br>
<a href="/courses/new"><button class="btn btn-primary">Add a course</button></a>
</div>
</body>
</html>