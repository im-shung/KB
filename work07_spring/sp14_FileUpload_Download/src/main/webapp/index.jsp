<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 
���� ���ε� �ۼ��� �����ؾ� �� ��Ģ
1. method ="post"
2. enctype ="multipart/form-data"
3. <input type="file" name="uploadFile">
4. pom.xml ::  (8��) commons-fileupload ���̺귯�� �߰� 
5. !!! �߿�. ��������
   MultipartFile �� ���� ���� �߰� :: multipartResolver

 -->
</head>
<body>
<h2 align="center">File upload Form...</h2>
<form action="fileupload.do" method="post" enctype="multipart/form-data">
	����ڸ� <input type="text" name="userName">
	<input type="file" name="uploadFile">
	<input type="submit" value="���Ͼ��ε�">
</form>
</body>
</html>

