<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top ten</title>
</head>
<body>
<h1>Top Ten Songs<a href="/dashboard">Dashboard</a>

</h1>
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