<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="web.product.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Product> list = (ArrayList) request.getAttribute("list");
%>

<div class="container">
<h2>OPTI-FREE Book Register!! </h2> <br>
<h2>전체 책 리스트 보기</h2>
<table class="table table-dark table-hover">
	<%
		for(Product vo : list){
	%>
		
	<tr>
		<td><%= vo.getName() %></td>
		<td><%= vo.getPrice() %></td>
		<td><%= vo.getDescription() %></td>
	</tr>
	<%
		}
	%>
</table>
<h4 align = "center"><a href="register.html">상품 등록</a></h4>
</div>
</body>
</html>