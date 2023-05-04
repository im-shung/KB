<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 
파일 업로드 작성시 유의해야 할 규칙
1. method ="post"
2. enctype ="multipart/form-data"
3. <input type="file" name="uploadFile">
4. pom.xml ::  (8번) commons-fileupload 라이브러리 추가 
5. !!! 중요. 설정문서
   MultipartFile 빈 설정 문서 추가 :: multipartResolver

 -->
</head>
<body>
<h2 align="center">File upload Form...</h2>
<form action="fileupload.do" method="post" enctype="multipart/form-data">
	사용자명 <input type="text" name="userName">
	<input type="file" name="uploadFile">
	<input type="submit" value="파일업로드">
</form>
</body>
</html>

