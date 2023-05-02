<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ArrayList를 cForEach 로 다뤄보기</h2>
<%
	ArrayList<String> list = new ArrayList<>();
	list.add("Apple");
	list.add("Graphe");
	list.add("Banana");
	list.add("Orange");
	
	request.setAttribute("list", list);
%>
<jsp:forward page="cForEach4_view.jsp"/>
</body>
</html>