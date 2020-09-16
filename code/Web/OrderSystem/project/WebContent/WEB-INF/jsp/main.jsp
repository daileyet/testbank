<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<title>主页</title>
<link rel="stylesheet" href="/OrderWeb/static/style.css">
</head>
<body>
	<div>Main Page</div>
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<label>商品列表:</label>
		<table class="table_prod">
		<tr><th>Product Name</th><th>Product Count</th><th>Action</th></tr>
		<c:forEach var="prod" items="${requestScope.prods }">
			<tr>
				<td>${prod.prodName }</td>
				<td>${prod.prodCount }</td>
				<td><a href="${pageContext.request.contextPath }/main/index?act=add&pid=${prod.ID}">Add to Cart</a></td>
			</tr>
		</c:forEach>
		</table>
	</div>
	
	<div>
		<label>My Cart</label>
		<table>
			<tr>
				<th>Product Name</th>
				<th>Buy Count</th>
				<th>Action</th>
			</tr>
			<c:forEach var="cp" items="${requestScope.cart.prods}">
				<tr>
					<td>${cp.prod.prodName }</td>
					<td>${cp.count }</td>
					<td>
						<a class="add_cart" href="${pageContext.request.contextPath }/main/index?act=add&pid=${cp.prod.ID}"> + </a>
						<a class="remove_cart" href="${pageContext.request.contextPath }/main/index?act=remove&pid=${cp.prod.ID}"> - </a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3"><a href="${pageContext.request.contextPath }/main/index?act=submit-order">submit</a></td>
			</tr>
		</table>
	</div>
</body>
</html>