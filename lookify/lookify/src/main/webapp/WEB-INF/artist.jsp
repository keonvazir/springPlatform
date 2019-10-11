<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
<p>Songs by <c:out value="${artist}"/> </p><a href="/dashboard">Dashboard</a>

<form action="/search" method="post">
<input type="text" name="_method" value="artist">
<input type="submit" value="Search Artist">
</form>

	<table>
    <thead>
        <tr>
        	
            <th scope="col">Name</th>
            <th scope="col">rating</th>
            <th scope="col">Action</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach items="${artistSongs}" var="song">
        <tr>
        	<th><c:out value="${song.title}"/></th>
            <td><c:out value="${song.rating}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>