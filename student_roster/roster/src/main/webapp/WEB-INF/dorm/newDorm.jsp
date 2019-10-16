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
<div class="wrapper" style="background: linear-gradient(to top left, #33cccc 0%, #0099ff 100%); width:900px; height:800px; display:inline-block;">

<div class="container" style="background: linear-gradient(to top left, #33cccc 0%, #0099ff 100%); display:inline-block; width:800px; height:800px;
"><br>

<h1 class="text-danger">Dormitories</h1><br>
<form:form action="/dorms/create" method="POST" modelAttribute="dormObj">
<form:errors path="name"/>
<form:input path="name" class="form-control col-6 mb-2" placeholder="Name"/><br>
<input type="submit" class="btn btn-warning"/>
</form:form>
</div>
</div>
</body>
</html>