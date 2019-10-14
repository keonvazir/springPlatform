<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="container">
<h1><c:out value="${dorm.name}"/></h1><h2>Test</h2>
<form:form action="dorms/add" method="POST" modelAttribute="studentObj">
 <form:select path="student" class="form-control col-6 mb-2">
 			<c:forEach items="${dorm.students}" var="student">
 			
 			<form:option value="${student.id}">
 			<c:out value="${student.firstname}"/><c:out value="${student.lastname}"/>
 			</form:option>
 			
 			</c:forEach>
 			</form:select>
 			<input type="submit" class="btn btn-secondary" value="Add"/>
 		</form:form>
 		<br>
	<table class="table">
    <thead class="thead-dark">
        <tr>
        	
            <th scope="col">Name</th>
            <th scope="col">Action</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach items="${students}" var="student">
        <tr>
        	<th class="bg-primary"><c:out value="${student.firstname} ${student.lastname}"/></th>
            <td class="bg-success"><a href="#">Remove</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table><br>
 	</div>
</body>
</html>