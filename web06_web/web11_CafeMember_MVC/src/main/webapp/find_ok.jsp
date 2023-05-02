<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	MemberVO vo = (MemberVO) request.getAttribute("vo");
%>
<h2> 회원 결과 조회</h2>
ID : <%= vo.getId() %> <br>
NAME : <%= vo.getName() %> <br>
ADDRESS : <%= vo.getAddress() %> <br>
</body>
</html>