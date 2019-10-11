<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify</title>
</head>
<body>
<h1><a href="/songs/new">Add New</a> | <a href="/search/topTen">Top Songs</a>

<form action="/search" method="post">
<input type="text" name="artist">
<input type="submit" value="Search Artist">
</form>

</h1>
	<table>
    <thead>
        <tr>
        	
            <th scope="col">Name</th>
            <th scope="col">rating</th>
            <th scope="col">Action</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
        	<th><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></th>
            <td><c:out value="${song.rating}"/></td>
            <td>
            <form:form action="/songs/${song.id}" method="post" modelAttribute="song">
    		<input type="hidden" name="_method" value="delete">
    		<input type="submit" value="Delete"/>
    		</form:form>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>