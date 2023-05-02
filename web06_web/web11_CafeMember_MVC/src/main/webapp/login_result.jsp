<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberVO vo = (MemberVO)session.getAttribute("vo");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login Information</h2>
ID <%= vo.getId()%>
NAME <%= vo.getName() %>
ADDRESS <%= vo.getAddress() %>
<p></p><hr><p></p>
<a href="logout.jsp">Log Out</a>
<a href="index.html">INDEX</a>
</body>
</html>