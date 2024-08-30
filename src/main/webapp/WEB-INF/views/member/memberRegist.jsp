<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회사 회원 가입</title>
<style>
    body {
        text-align: center;
        padding: 50px;
        font-family: Arial, sans-serif;
    }

    .form-container {
        max-width: 500px;
        margin: 0 auto;
        text-align: left;
    }

    .form-group {
        margin-bottom: 15px;
    }

    .form-group label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }

    .form-group input {
        width: 100%;
        padding: 10px;
        font-size: 14px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }

    .button {
        display: inline-block;
        padding: 15px 30px;
        font-size: 16px;
        font-weight: bold;
        color: white;
        text-align: center;
        text-decoration: none;
        margin: 20px;
        border-radius: 5px;
        cursor: pointer;
        border: none;
    }

    .btn-blue {
        background-color: blue;
    }

    .btn-green {
        background-color: green;
    }

    .btn-blue:hover {
        background-color: darkblue;
    }

    .btn-green:hover {
        background-color: darkgreen;
    }
</style>
</head>
<body>

<div class="form-container">
    <h2>회원 가입</h2>
    <form action="registerMember" method="post" class ="memberInfo">
        <div class="form-group">
            <label for="userName">아이디</label>
            <input type="text" id="userName" name="userName" required>
            <span id = "idMsg"></span>
        </div>
        <div class="form-group">
            <label for="userPassword">비밀번호</label>
            <input type="password" id="userPassword" name="userPassword" required>
            <span id = "pwMsg"></span>
        </div>
        
        <div class="form-group">
            <label for="userPassword">비밀번호확인</label>
            <input type="password" id="passwordConfirm"required>
            <span id = "pwConfirmMsg"></span>
        </div>
        
        <div class="form-group">
            <label for="userPhone">전화번호</label>
            <input type="text" id="userPhone" name="userPhone" required>
            <span id = "phoneMsg"></span>
        </div>
        <div class="form-group">
            <label for="userMail">이메일</label>
            <input type="email" id="userMail" name="userMail" required>
            <span id = "emailMsg"></span>
        </div>
        <div class="form-group">
            <label for="path">가입경로</label>
            <input type="text" id="path" name="path">
        </div>
        

        <button type="submit" class="button btn-blue">가입하기</button>
        <button type="reset" class="button btn-green">초기화</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
  	$(document).ready(function(){

  		let idFlag = false; // memberName 유효성 변수 
  		let pwFlag = false; // memberPassword 유효성 변수 
  		let pwConfirmFlag = false; // pwConfirm 유효성 변수 
  		let emailFlag = false; // memberEmail 유효성 변수
  		let emailAuthFlag = false; // 실제 있는 이메일인지 확인하는 변수
  		let checkAuthCode; // 전역변수로 선언

		// memberInfo 클래스를 가진 요소 찾기	  		
	  	$('.memberInfo').each(function(){
	  		// 각 요소 id값 가져옴
	  		let elementId = $(this).attr('id');
	  		// blur() : input 태그에서 탭 키나 마우스로 다른 곳을 클릭할 때 이벤트 발생
	  		// 아이디 유효성 검사	 
	  		$('#' + elementId).blur(function(){
	  			
	  			if(elementId == 'memberId') {
	  				let userName = $('#' + elementId).val();
	  				
	  			  	// 7 ~ 20자 사이의 소문자나 숫자로 시작하고, 소문자, 숫자을 포함하는 정규표현식
	  				let idRegExp = /^[a-z0-9][a-zA-Z0-9]{6,19}$/;
	  				if(userName === ""){
	  					$('#idMsg').html("아이디는 비어둘 수 없습니다.");
	  					$('#idMsg').css("color", "red");
	  					idFlag = false;
	  					return;
	  				}
	  				
	  				if(!idRegExp.test(userName)){
	  					$('#idMsg').html("아이디는 7-20자 사이로 영어, 숫자만 입력이 가능 합니다.");
	  					$('#idMsg').css("color", "red");
	  					idFlag = false;
	  				} else {
	  					checkId(userName);
	  				}
	  				
	  			} // end 아이디 요소 유효성 검사
	  			else if (elementId == 'userPassword') {
	  				let memberPw = $('#' + elementId).val();
	  				let pwRegExp = /^(?=.*?[A-Z])(?=.?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*]).{8,16}$/;
	  				
	  				if(memberPw === ""){
	  					$('#pwMsg').html("비밀번호는 필수에오. 필수!");
	  					$('#pwMsg').css("color", "red");
	  					pwFlag = false;
	  					return;
	  				}
	  				if(!pwRegExp.test(memberPw)){
	  					$('#pwMsg').html("소문자, 대문자, 숫자, 특수문자(!@#$%^&*)중 최소 하나씩을 포함한 8 에서 16 자리만 가능합니다.");
	  					$('#pwMsg').css("color", "red");
	  					pwFlag = false;
	  				} else {
	  					$('#pwMsg').html("사용가능한 비밀번호 임미다.");
	  					$('#pwMsg').css("color", "green");
	  					pwFlag = true;
	  				}
	  			} // end 비밀번호 유효성 검사
	  			else if (elementId == 'passwordConfirm') {
	  				let pwConfirm = $('#' + elementId).val();
	  				let memberPw = $('#userPassword').val();
	  				
	  				if(pwConfirm === ""){
	  					$('#pwConfirmMsg').html("비밀번호 확인은 필수에오.");
	  					$('#pwConfirmMsg').css("color", "red");
	  					pwConfirmFlag = false;
	  					return;
	  				}		
	  				if(memberPw === pwConfirm){
	  					$('#pwConfirmMsg').html("비밀번호 확인을 통과했습니다.");
	  					$('#pwConfirmMsg').css("color", "green");
	  					pwConfirmFlag = true;
	  				} else {
	  					$('#pwConfirmMsg').html("저런! 비밀번호를 다시 한번확인해 주세요");
	  					$('#pwConfirmMsg').css("color", "red");
	  					pwConfirmFlag = false;
	  				}
	  			} // end 비밀번호 확인 유효성 검사
	  			else if (elementId == "userMail"){
	  				let memberEmail = $('#' + elementId).val();
	  				let emailRegExp = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,}$/;
	  				// let emailRegExp = /(?:[a-zA-Z0-9._%+-]+@(?:naver\.com|daum\.net|kakao\.com|gmail\.com))/i;
	  				console.log(memberEmail);
	  				if(memberEmail === ""){
	  					$('#emailMsg').html("이메일도 필수에오. 필수!");
	  					$('#emailMsg').css("color", "red");
	  					$('#authSpan').html('');
	  					$('#btnEmailAuth').css("display", "none");
	  					emailFlag = false;
	  					return;
	  				}
	  				if(!emailRegExp.test(memberEmail)){
	  					$('#emailMsg').html("유효한 형식의 이메일이 아니에오");
	  					$('#authSpan').html('');
	  					/* $('#emailMsg').html("유효한 형식의 이메일이 아니에오, naver.com, daum.net, kakao.com, gmail.com <br> 이 4개의 이메일만 사용 가능합니다 "); */
	  					$('#emailMsg').css("color", "red");
	  					$('#btnEmailAuth').css("display", "none");
	  					emailFlag = false;
	  				} else {
			  			checkMail(memberEmail);
		  		  	}
	  			} // end email 체크
	  			
	  		}); // end blur(function);	  		
	  	}); // end each()
	  	
	  	
	  	function checkId(userName){
	  		
	  		$.ajax({
	  			type : "GET",
	  			url : "../util/companyMemberCheck/" + userName,
	  			success : function(result){
	  				if(result == 1){
	  					$('#idMsg').html('이미 누군가가 사용중인 아이디입니다.');
	  					$('#idMsg').css('color', 'red');
	  					idFlag = false;
	  				} else {
	  					$('#idMsg').html('사용가능한 아이디입니다.');
	  					$('#idMsg').css('color', 'green');
	  					idFlag = true;
	  				}
	  			}
	  		}); // end ajax
	  	} // end checkId
	  	
	  	function checkMail(memberEmail){
	  	
	  		$.ajax({
	  			type : "GET",
	  			url : "../util/checkEmail/",
	  			data: { memberEmail : memberEmail },
	  			success : function(result){
	  				if(result == 1){
	  					$('#emailMsg').html("누군가 벌써 사용중인 이메일입니다.");
	  					$('#emailMsg').css("color", "red");
	  					$('#authSpan').html("");
	  					$('#btnEmailAuth').css("display", "none");
	  					emailFlag = false;
	  				} else {
	  					if($('#btnSendCode').length > 0){
	  						
	  					} else{
		  					$('#emailMsg').html("사용가능한 이메일입니당.");
		  					$('#emailMsg').css("color", "green");
		  					$('#authSpan').html("<span><button id='btnSendCode'>이메일 인증하기</button><br></span><span id='emailAuthMsg'></span>");
		  					// $('#btnEmailAuth').css("display", "block")
		  					emailFlag = true;
	  					}
	  				}
	  			}
	  		});	// end ajax
	  	} // end checkMail
	  	
		$(document).on('click', '#btnSendCode', function(){
			authCodeSend($('#memberEmail').val());
		}); // end btnSendCode
		
		let countdown;
		let timerInterval;
		let sendMailFlag = true;
		function authCodeSend(memberEmail) {
			if(sendMailFlag){
			    $.ajax({
			        type: "GET", // GET 요청 타입
			        url: "../util/authCodeSend/", // 요청을 보낼 URL
			        data: { memberEmail: memberEmail }, // 요청에 포함할 데이터
			        success: function(response) { // 요청이 성공적으로 완료되었을 때 실행할 함수
			            if (response.result === 1) { // 서버로부터 성공 응답을 받았을 때
			                alert("작성하신 이메일로 확인 코드가 발송되었습니다.");
			                $('#emailAuthMsg').html(
			                    "<input id='authCode' type='number' placeholder='코드를 입력해 주세요.'>" +
			                    "<button id='btnCodeCheck'>인증확인</button><br>" +
			                    "<span id='checkAuthMsg'></span><br>" +
			                    '<span id="timer"></span>'
			                );
			                sendMailFlag = false;
			                checkAuthCode = response.authCode; // 인증코드
					   		let count = 30; // 타이머 지속 시간 (초)
					   		countdown = function(){
				               if (count > 0) {
				                   count--; // 지속 시간 감소
				                   let min = Math.floor(count / 60); // 남은 분 계산
				                   let sec = count % 60; // 남은 초 계산
				                   sec = sec < 10 ? '0' + sec : sec;
				                 $('#timer').text(
				               		  '0' + min + ':' + sec
				                 );
				               } else {
				                   checkAuthCode = null; // 인증 코드를 무효화
				                   clearInterval(timerInterval); // 타이머 정지
				                   alert('코드 인증시간이 만료되었습니다.'); // 사용자에게 알림
				                   sendMailFlag = true;
				               }
				           } // end countdown
					        // 매 초마다 countdown 함수 호출        	
					        timerInterval = setInterval(countdown, 1000);
			            } else {
			                alert("잠시후 다시 눌러주세요."); // 서버로부터 실패 응답을 받았을 때
			            }
			        }
			    }); // end ajax
			} else{
				alert('인증을 이미 하셨거나, 이메일이 보내졌습니다. 인증시간 만료후 다시 눌러주세요.');
			}
		} // end authCodeSend()
        
		$(document).on('click', '#btnCodeCheck', function(){
			codeCheck($('#authCode').val());
		});
		
		$(document).on('blur', '#authCode', function(){
  				let authCode = $('#authCode').val();
  				if(authCode == ""){
  					$('#checkAuthMsg').html('인증코드는 비어있을 수 없어용.');
  					$('#checkAuthMsg').css('color', 'red');
  					emailAuthFlag = false;
  				} else {
  					$('#checkAuthMsg').html('인증코드 확인 버튼을 눌러주세요');
  					$('#checkAuthMsg').css('color', 'blue');
  					emailAuthFlag = false;
  				}
		});
		
		// TODO: 나중에 비동기로 처리를 하던, 하는방식으로 바꿔야함 이대로면 사용자가 많아질경우 값이 계속 바뀔 가능성이 있음.
		// 정확히는 테스트를 해봐야 알거같음.
		function codeCheck(authCode){
			if(authCode == checkAuthCode){
				alert("인증에 성공하셨습니다.");
				$('#checkAuthMsg').html('인증코드가 확인되었습니다.');
				clearInterval(timerInterval);
				sendMailFlag = false;
				$('#checkAuthMsg').css('color', 'green');
				emailAuthFlag = true;
			} else{
				alert("인증코드를 다시 확인해 주세요.");
				$('#checkAuthMsg').html('인증코드를 확인해 주세요.');
				$('#checkAuthMsg').css('color', 'red');
				emailAuthFlag = false;
			}
		};
		
		let timeout = function(){
			
		}
		
	  	
	  	$('#btnJoin').click(function(){
	  		let memberId = $('#memberId').val();
	  		let memberPassword = $('#memberPassword').val();
	  		let memberEmail = $('#memberEmail').val();
	  		setTimeout(function(){
	  			if(idFlag && pwFlag && pwConfirmFlag && emailFlag && emailAuthFlag){
	  				$.ajax({
	  					type : 'POST',
	  					url : 'regist',
	  					contentType: 'application/json; charset=UTF-8',
	  					data : JSON.stringify({
	  						memberId : memberId,
	  						memberPassword : memberPassword,
	  						memberEmail : memberEmail
	  					}),
	  					success : function(result){
	  						if(result === 1){
				  				alert($('#memberId').val() + "님의 회원가입을 환영합니다.");
				  				window.location.href = 'http://192.168.0.120:9090/ex01/';
	  						} else {
	  							alert('서버에 문제가 있는거 같습니다 잠시후 다시 시도해주세요');
	  						}
	  					}
	  				});
	  			} else {
	  				alert("뭔갈 안하셧어요");
	  			}
	  		}, 500); // 500초 후에 실행
	  	}); // end btnJoin
	  	
  }); // end document

  </script>
</body>
</html>
