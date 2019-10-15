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
	<h1>Classes</h1>
	<br>
		<form:form action="/classes/create" method="POST" modelAttribute="courseObj">
		<div class="form-group">
			<p>
				<form:label path="name">Name: </form:label>
				<form:errors path="name"/>
				<form:input path="name" placeholder="Name"/>
			</p>
		</div>
		<input type="submit" class="btn btn-primary" value="Create"/>
		</form:form>
		
</div>
</body>
</html>