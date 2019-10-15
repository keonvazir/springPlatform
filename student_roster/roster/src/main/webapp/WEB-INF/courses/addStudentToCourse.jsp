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
	<div class="container"><br>
		<h1><span class="text-danger"><c:out value="${student.firstname} " /><c:out value="${student.lastname}"/></span></h1><br><br>
		<form:form action="/students/${student.id}/add" method="post" modelAttribute="middleTableObj">
			<form:input type="hidden" path="student" value="${student_id}"/>
			<label><span class="text-info">Classes:</span></label>
			<form:select path="course">
			<c:forEach items="${courses}" var="course">
			<form:option value="${course.id}">${course.name}</form:option>
			</c:forEach>
			</form:select>
			<input class="btn btn-dark mb-2 mt-2" type="submit" value="Add">
		</form:form><br><br>
		
		<h4><span class="text-warning">Your Schedule</span></h4>
		<table class="table">
    		<thead class="thead-dark">
        		<tr>
		            <th scope="col">Class Name</th>
		            <th scope="col">Action</th>
       			</tr>
    		</thead>
   			<tbody>
        		<c:forEach items="${student.courses}" var="course">
        			<tr>
        				<th class="bg-primary"><c:out value="${course.name}"/></th>
           				<td class="bg-success"><a href="/students/${student.id}/destroy/${course.id}"><span style="color:yellow"><i>Drop</i></span></a></td>
        			</tr>
        		</c:forEach>
    		</tbody>
		</table><br><br>
		<p class="btn btn-warning" style="margin-left:500px;"><a href="/students">Home</a></p>
	</div>
</body>
</html>