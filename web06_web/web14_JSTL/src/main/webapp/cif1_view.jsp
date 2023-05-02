<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- 
jstl을 사용하기 위해서는
1. jar 파일 2개가 필요하다. (jstl.jar, standard.jar)
2. taglib를 지정해서 사용해야 한다.
    
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if 문을 jstl로 다뤄보자</title>
</head>
<body>
<h2>jstl if</h2>
<c:if test="${param.NUM = '100'}"> <!-- true/false -->
	<b>오늘은 100만원이 입금되었습니다.</b>
</c:if>

<c:if test="${param.NUM = '200'}"> <!-- true/false -->
	<b>오늘은 200만원이 입금되었습니다.</b>
</c:if>
</body>
</html>