<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아력서 리스트/title>
</head>
<body>

	<h1>이력서 관리</h1>
	<p>이력서는 최대 6개까지 등록할 수 있습니다.</p>
	<p>지원 후 수정한 이력서 내용(회원정보 제외)은 지원한 이력서에는 반영 되지 않습니다.</p>
	<table class="table">
	<thead>
		<tr>
			<th style="width: 10%;">이력서 제목</th>
			<th style="width: 15%;">최종 수정일</th>
			<th style="width: 15%;">관리</th>
		</tr>
	</thead>
	</table>
	

	<script type="text/javascript">
		let userName; // 나중에 시큐리티 적용시 세션 정보 가져오게 수정

		$(document).ready(function() {
			resumeMap.show = function() {
				console.log("userName : " + userName);

				let resumeUrl = "../resumeREST" + "/" + userName;

				$.ajax({
					method : 'GET',
					url : resumeUrl,
					success : function(data) {
						console.log("data : " + data);

						let form = '';

						for (let i = 0; i < data.length; i++) {
							form += "<li>" +
							"<tb>'#'</td>"
							"</li>"
						}
					}
				});// end ajax

			}
		});// end document
	</script>

</body>
</html>