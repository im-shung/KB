<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberVO vo = (MemberVO)session.getAttribute("vo");
	if (vo == null) {
%>
	<h2><a href="login.jsp">로그인 하기</a></h2>
<%	
	} else {
		session.invalidate();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function logout() {
		alert("Log out~");
	}
</script>

</head>
<body onload = logout()>
<b>로그아웃 되셨습니다</b>
<a href="index.html">INDEX</a>
</body>
</html>