<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %> 
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
	<h1>New Student</h1>
	<br>
	<form:form action="/students/new" method="post" modelAttribute="studentObj">
	<div class="form-group">
    <p>
        <form:label path="firstname">First Name</form:label> 
        <form:errors path="firstname"/>
        <form:input path="firstname" placeholder="First Name"/>
    </p>
    </div>
    <div class="form-group">
    <p>
        <form:label path="lastname">Last Name</form:label>
        <form:errors path="lastname"/>
        <form:input path="lastname" placeholder="Last Name"/>
    </p>
    </div>
    <div class="form-group">
    <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>
        <form:input path="age" placeholder="Age"/>
    </p>
    </div>
    <input type="submit" class="btn btn-primary" value="Create"/>
</form:form> <br><br>
<a href="/students"><i>Back...</i></a>
</div>
</body>
</html>