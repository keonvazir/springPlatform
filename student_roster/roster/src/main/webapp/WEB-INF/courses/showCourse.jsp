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
	<h1 class="header" style="text-align:center"><span class="text-danger"><c:out value="${course.name}"/></span></h1>
	<br>
	<h4 class="subheader" style="text-align:center"><span class="text-info">Students taking this class:</span></h4><br>
	<table class="table">
    	<thead class="thead-dark">
        	<tr>
	            <th scope="col">Name</th>
       		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${course.students}" var="student">
    		<tr>
	        	<th class="bg-warning"><c:out value="${student.firstname} ${student.lastname}"/></th>
        	</tr>
    		</c:forEach>
    	</tbody>
    </table><br><br>
  <div class="bottom" style="display:inline-block; text-align:center; width:300px; height:200px; margin-left:550px;"> 
<a href="/students">Home</a><br><br>
<a href="/classes/new">Back..</a>
</div> 
</body>
</html>