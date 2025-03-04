<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form:form action="insertData" method="post" modelAttribute="logindata">
		<table>
			<tr>
				<td> Username: </td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><form:input path="password" type="password"/></td>
			</tr>
			
			<tr>
			<td></td>
			<td><input type="submit" value="Click here"/></td>
		</table>
		</form:form>
</body>
</html>