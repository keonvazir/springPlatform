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
<p>Songs by artist</p><a href="/dashboard">Dashboard</a>

<form action="/" method="post">
<input type="text" name="_method" value="artist">
<input type="submit" value="Search Artist">
</form>

</p>
	<table>
    <thead>
        <tr>
        	
            <th scope="col">Name</th>
            <th scope="col">rating</th>
            <th scope="col">Action</th>
        </tr>
    </thead>
   <%--  <tbody>
        <c:forEach items="" var="">
        <tr>
        	<th><c:out value=""/></th>
            <td><c:out value=""/></td>
            <td><c:out value=""/></td>
            <td><c:out value=""/></td>
            <td><c:out value=""/></td>
            <td><a href="">| Show |</a>
            <a href="">| Edit |</a>
            <form:form action="/books/${book.id}/destroy" method="post" modelAttribute="book">
    		<input type="hidden" name="_method" value="delete">
    		<input type="submit" value="Delete"/>
			</form:form>
            </td>
        </tr>
        </c:forEach>
    </tbody> --%>
</table>
</body>
</html>