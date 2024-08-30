<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아력서 리스트</title>
</head>
<body>
	<% 
    // 세션에 저장된 데이터 가져오기
    String userName = (String) session.getAttribute("userName");
    %>
    
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
	<button onclick="location.href='../resume/detail?userName=${userName}'">이력서 등록</button>
	
	<div id="resume"></div>
	<script type="text/javascript">
		let userName = "${userName}"; // 나중에 시큐리티 적용시 세션 정보 가져오게 수정

		$(document).ready(function() {
			resumeMap.show();// 비동기로 이력서 전부 불려오기
			
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
						    form += "<li class='table'>" +
						        "<tb>" + data[i].resumeId + "</tb>" +
						        "<tb>" + data[i].resumeTitle + "</tb>" +
						        "<tb>" + data[i].resumeDateCreate + "</tb>" +
						        `<button onclick="location.href='../resume/update?resumeId=${data[i].resumeId}&userName=${userName}';">수정</button>` +
						        `<button class='btn btn-delete' data-productid='${data[i].resumeId}'>삭제</button>` +
						        "</li>";
						}
						$('#resume').html(form);
					}
				});// end ajax
			}// end resumeMap()
			
			$(document).on('click', '.btn-delete', function() {
	            let resumeId = $(this).data('resumeId');

	            let obj = {
	                'resumeId': resumeId,
	                'userName': userName
	            };

	            $.ajax({
	                type : 'DELETE',
	                url : '../resumeRest/delete',
	                headers : {
	                    'Content-Type' : 'application/json',
	                    'X-CSRF-TOKEN' : $('meta[name="${_csrf.parameterName}"]').attr('content')
	                },
	                data : JSON.stringify(obj),
	                success : function(result) {
	                    if(result == 1) {
	                        alert('이력서 삭제 성공!');
	                        window.location.href = '../resume/list?userName=' + userName;
	                    } else {
	                        alert('이력서 삭제 실패!');
	                    }
	                }
	            });
	        });// end (document).on
			
		});// end document
	</script>

</body>
</html>