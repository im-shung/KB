<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 원래는 서블릿으로 작성해야하는데, 이것을 서블릿으로 친다. --%>
<!-- 원래는 서블릿으로 작성해야하는데, 이것을 서블릿으로 친다.  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP 기본 Element로 받아오기</b><br>
<%= request.getAttribute("RESULT1") %><br>
<%= session.getAttribute("RESULT2") %><br>

<hr>
<b>2. JSP EL로 받아오기</b><br>
1. ${RESULT1}<br>
2. ${RESULT2}<br>
3. ${RESULT1 + 10000 } <br>
</body>
</html>