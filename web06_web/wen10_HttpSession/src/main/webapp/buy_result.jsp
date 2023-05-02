<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO vo = (MemberVO) session.getAttribute("vo");
	String book = (String) session.getAttribute("pname");
	if (vo == null) {
		// NOT 로그인 상태
%>
	<h3>로그인부터 하세요</h3>
	<a href="login.html"></a>
<%
	} 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Information...</h2>
Login ID: <b><%= vo.getId() %></b> <br>
Login Name: <b><%= vo.getName() %></b> <br>
Product Name: <b><%= book %></b>
</body>
</html>