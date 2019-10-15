<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<br>
	<h1>All Students</h1>
	<br>
	<table class="table">
    <thead class="thead-dark">
        <tr>
        	
            <th scope="col">Name</th>
            <th scope="col">Age</th>
            <th scope="col">Address</th>
            <th scope="col">City</th>
            <th scope="col">State</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach items="${students}" var="student">
        <tr>
        	<th class="bg-primary"><c:out value="${student.firstname} ${student.lastname}"/></th>
            <td class="bg-success"><c:out value="${student.age}"/></td>
            <td class="bg-warning"><c:out value="${student.contact.address}"/></td>
            <td class="bg-danger"><c:out value="${student.contact.city}"/></td>
            <td class="bg-info"><c:out value="${student.contact.state}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table><br>
<div class="bottom" style="display:inline-block; text-align:center; width:300px; height:200px; margin-left:500px;">
<a href="/students/new">New Student</a><br><br>
<a href="/contact/new">Create Contact Info here...</a><br><br>
<a href="/dorms/new">Dorm page!</a><br><br>
<a href="/classes/new">New Class!</a>
</div>
</body>
</html>