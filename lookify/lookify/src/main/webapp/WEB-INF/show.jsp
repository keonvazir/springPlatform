<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><a href="/dashboard">Dashboard</a></h1>

	<h3>Title</h3><br>
	<p> <c:out value="${song.title}"/> </p>
	<h3>Artist</h3><br>
	<p> <c:out value="${song.artist}"/></p>
	<h3>Rating(1-10)</h3>
	<h3><c:out value="${song.rating}"/></h3>
	<h3><a href="">Delete</a></h3>
	
</body>
</html>