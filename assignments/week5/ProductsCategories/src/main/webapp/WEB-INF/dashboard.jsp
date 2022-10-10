<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" type="text/css">

</head>
<body>
	<h1>Home Page</h1>
	<div>
		
		<a href="/create/category">New category</a>
		<a href="/create/product">New Product</a>
	</div>
	<div>
		<table>
			<thead class="justify-content-evenly">
				<tr>
					<th>Products</th>
					<th>Categories</th>
				</tr>
			</thead>
			<tbody class="d-flex flex-row vertical-align-middle">
				<tr class="d-flex flex-column justify-content-evenly">
					<c:forEach var="singleProduct" items="${products}">
		                <td class="col"><a href="/one/category/${singleProduct.id}"><c:out value = "${singleProduct.productName}"/></a>
		            </c:forEach>
		       </tr>
		       <tr class=" d-flex flex-column justify-content-evenly">
		           <c:forEach var="singleCategory" items="${categories}">
						<td class="col"><a href="/one/product/${singleCategory.id}"><c:out value = "${singleCategory.categoryName}"/></a> </td>     
					</c:forEach>
					
	            </tr>
			</tbody>
		</table>
	</div>
	
</body>
</html>