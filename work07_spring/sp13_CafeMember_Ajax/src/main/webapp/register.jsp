<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
form {
	width: 500px;
	margin: 0 auto;
}
</style>
<script>
	$(function() {
		$('#id').keyup(function() {
			var id = $(this).val();
			if (id.length >= 4 & id.length <= 8) { // 4자이상 8자 이하일 때만 id 값 타당
				$.ajax({
					// 요청: post, idExist.do
					type : 'post',
					url: 'idExist.do',
					data: 'id='+id,

					// 응답: 받은 데이터값이 true -- 이미 사용중인 아이디! / red 색
					//					false -- 사용 가능 아이디!  / blue 색
					success : function(data) {
						var jsonData = JSON.parse(data)
						if (jsonData.idExist == true) {
							$('#check').html('이미 사용중인 아이디!').css('color','red');
						} else {
							$('#check').html('사용 가능 아이디!').css('color','blue');
						}
	
					} // callback
				}); //ajax...마지막에 설정문서 추가
			} else { // 4자이상 8자 이하가 아닐 때
				$('#check').html('4자 이상, 8자 이하만 가능!!').css('color', 'red');
				$('#submit_btn').attr('disabled', true); // 버튼 비활성화
			}
		}); //keyup
	});
</script>
</head>
<body>
	<div class="container">
		<div class="jumbotron" align="center">
			<h2>REGISTER MEMBER FORM</h2>
		</div>
	</div>
	<hr>
	<div class="container">
		<form action="register.do" method="post">
			<div class="form-group">
				<label for="id">ID:</label> <input type="text" class="form-control"
					id="id" placeholder="Enter Id" name="id"> <span id="check"
					style="margin-left: 15px"></span>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="password">
			</div>
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" placeholder="Enter Name" name="name">
			</div>
			<div class="form-group">
				<label for="address">Address:</label> <input type="text"
					class="form-control" id="address" placeholder="Enter Address"
					name="address">
			</div>

			<button type="submit" class="btn btn-primary" id="submit_btn">Submit</button>
		</form>

	</div>

</body>
</html>