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
	<h1>check</h1>
	<form:form action="insertProduct" method="post" modelAttribute="proddata">
	<table>
			<tr>
				<td>Product Code</td>
				<td><form:input path="productcode"/></td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><form:input path="productname"/></td>
			</tr>
			<tr>
				<td>Product Price</td>
				<td><form:input path="price"/></td>
			</tr>
			<tr>
				<td>Product Quantity</td>
				<td><form:input path="quantity"/></td>
			<tr>
			<td></td>
			<td><input type="submit" value="Click here"/></td>
	</table>
	</form:form>
</body>
</html>