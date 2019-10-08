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

<div class="form-control form-control-lg">
	<h1><c:out value="${book.title}"/></h1>
<p>Description: <c:out value="${book.description}"/></p>
<p>Language: <c:out value="${book.language}"/></p>
<p>Number of pages: <c:out value="${book.numberOfPages}"/></p>
</div>

<a href="/books/${book.id}/edit">Edit Book</a>
<form action="/books/${book.id}/destroy" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</body>
</html>