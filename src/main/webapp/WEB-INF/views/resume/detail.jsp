<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이력서 작성 페이지</title>
</head>
<body>
	
	<% 
    // 세션에 저장된 데이터 가져오기
    String userName = (String) session.getAttribute("userName");
    %>
    
	<!-- 비동기로 회원 정보 가져오기 -->
	<div id="member"></div>
	
	<form action="../resume/update?${_csrf.parameterName }=${_csrf.token }" method="POST" id="formProduct">
		<div class="input-group mb-3">
		
			<span class="input-group-text">회원id</span>
			<input type="text" class="form-control" value="${userName}"readonly>
			
			<span class="input-group-text">이력서 제목</span>
			<input type="text" class="form-control" value="${vo.resumeTitle}" readonly>
			
			<h3>학력 사항</h3>
			<div class="input-group mb-3">
			<label class="input-group-text">학력</label>
        	<select id="category" class="form-select editable" name="category">
        		<option value="${vo.education}" selected hidden="hidden">${vo.education }</option>
				<option value="초등학교">초등학교</option>
				<option value="중학교">중학교</option>
				<option value="고등학교">고등학교</option>
				<option value="대학교(2,3년제)">대학교(2,3년제)</option>
				<option value="대학교(4년제)">대학교(4년제)</option>
				<option value="대학원">대학원</option>
			</select> 
			</div>
			
			<div class="input-group mb-3">
			<label class="input-group-text">상태</label>
        	<select id="category" class="form-select editable" name="category">
        		<option value="${vo.educationForm}" selected hidden="hidden">${vo.educationForm }</option>
				<option value="졸업">졸업</option>
				<option value="재학">재학</option>
				<option value="휴학">휴학</option>
				<option value="중퇴">중퇴</option>
				<option value="수료">수료</option>
			</select> 
			</div>
			
			<h3>경력 사항</h3>
			<div class="input-group mb-3">
			<label class="input-group-text">상태</label>
        	<select id="category" class="form-select editable" name="category">
        		<option value="${vo.experience}" selected hidden="hidden">${vo.experience }</option>
				<option value="신입">신입</option>
				<option value="경력">경력</option>
			</select> 
			</div>
			
			<h3>희망 근무지</h3>
			<div class="input-group mb-3">
			<label class="input-group-text">상태</label>
        	<select id="category" class="form-select editable" name="category">
        		<option value="${vo.townName}" selected hidden="hidden">${vo.townName }</option>
				<option value="전국">전국</option>
				<option value="서울특별시">서울특별시</option>
				<option value="경기도">경기도</option>
				<option value="인천광역시">인천광역시</option>
				<option value="강원특별자치도">강원특별자치도</option>
				<option value="대전광역시 ">대전광역시 </option>
				<option value="세종특별자치시">세종특별자치시</option>
				<option value="총청남도">총청남도</option>
				<option value="부산광역시">부산광역시</option>
				<option value="울산광역시">울산광역시</option>
				<option value="경상남도">경상남도</option>
				<option value="경상북도">경상북도</option>
				<option value="대구광역시">대구광역시</option>
				<option value="광주광역시">전라남도</option>
				<option value="전북특별자치도">제주특별자치도</option>
				<option value="제주특별자치도">제주특별자치도</option>
			</select> 
			</div>
			
			<span class="input-group-text">상세 도시</span>
			<input type="text" class="form-control" value="${vo.cityName}" readonly>
			
			<span class="input-group-text">희망직무 작성</span>
			<input type="text" class="form-control" value="${vo.jobName}" readonly>
			
			<div class="input-group mb-3">
			<label class="input-group-text">근무 형태</label>
        	<select id="category" class="form-select editable" name="category">
        		<option value="${vo.workForm}" selected hidden="hidden">${vo.workForm }</option>
				<option value="알바">알바</option>
				<option value="정규직">정규직</option>
				<option value="계약직">계약직</option>
				<option value="파견직">파견직</option>
				<option value="인턴">인턴</option>
			</select> 
			</div>
			
			<div class="input-group mb-3">
			<label class="input-group-text">근무 형태</label>
        	<select id="category" class="form-select editable" name="category">
        		<option value="${vo.periodName}" selected hidden="hidden">${vo.periodName }</option>
				<option value="무관">무관</option>
				<option value="하루">하루</option>
				<option value="1주일 이하">1주일 이하</option>
				<option value="1개월 이하">1개월 이하</option>
				<option value="3개월 이하">3개월 이하</option>
				<option value="6개월 이하">6개월 이하</option>				
				<option value="1년 이하">1년 이하</option>
				<option value="1년 이상">1년 이상</option>
			</select> 
			</div>
			
			<div class="input-group mb-3">
			<label class="input-group-text">근무 형태</label>
        	<select id="category" class="form-select editable" name="category">
        		<option value="${vo.dayName}" selected hidden="hidden">${vo.dayName}</option>
				<option value="월~금">월~금</option>
				<option value="토,일">토,일"</option>
				<option value="주 5일">주 5일</option>
				<option value="주 4일">주 4일</option>
				<option value="주 3일">주 3일</option>
				<option value="주 2일">주 2일</option>
				<option value="주 1일">주 1일</option>
			</select> 
			</div>
			
			<div class="input-group mb-3">
			<label class="input-group-text">근무 형태</label>
        	<select id="category" class="form-select editable" name="category">
        		<option value="${vo.parttimeName}" selected hidden="hidden">${vo.parttimeName}</option>
				<option value="풀타임(8시간 이상)">풀타임(8시간 이상)</option>
				<option value="오전~오후">오전~오후</option>
				<option value="오후~저녁">오후~저녁</option>
				<option value="저녁~새벽">저녁~새벽</option>
				<option value="새벽~오전">새벽~오전</option>
			</select> 
			</div>
			
			<div class="input-group mb-3">
			<label class="input-group-text">근무 형태</label>
        	<select id="category" class="form-select editable" name="category">
        		<option value="${vo.salaryForm}" selected hidden="hidden">${vo.salaryForm}</option>
				<option value="시급">시급</option>
				<option value="일급">일급</option>
				<option value="주급">주급</option>
				<option value="월급">월급</option>
				<option value="연봉">연봉</option>
			</select> 
			</div>
			
			<span class="input-group-text">급여 작성</span>
			<input type="text" class="form-control" value="${vo.salary}" readonly>
			
			<span class="input-group-text">스킬 작성</span>
			<input type="text" class="form-control" value="${vo.skill}" readonly>
			
			<span class="input-group-text">자기소개 작성</span>
			<input type="text" class="form-control" value="${vo.intro}" readonly>
			
			<div>
         	<input type="submit" value="이력서 등록">
      		</div>
		</div>
	</form>
		

	
	<script type="text/javascript">
	
	let userName = "${userName}"; // 나중에 시큐리티 적용시 세션 정보 가져오게 수정
	
	$(document).ready(function() {
		memberMap.show = function() {
			console.log("userName : " + userName);
			
			let memberUrl = "../resumeREST" + "/" + userName;
			
			$.ajax({
				method : 'GET',
				url : memberUrl,
				success : function(data) {
					console.log("data : " + data);

					let form = '';
					
					for (let i = 0; i < data.length; i++) {
					    form += "<li class='table'>" +
					        "<tb>" + data[i].userName + "</tb>" +
					        "<tb>" + data[i].userPhone + "</tb>" +
					        "<tb>" + data[i].userMail + "</tb>" +
					        "</li>";
					}
					$('#member').html(form);
				}
			});// end ajax
			
		});// end memberMap
	});// end document
	
	</script>

</body>
</html>