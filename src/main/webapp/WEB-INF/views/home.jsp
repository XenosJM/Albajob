<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--시큐리티 태그를 사용하귀 위해 입력. --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>알바 주선 사이트 알바잡</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<!-- csrf 토큰 설정 -->
    <sec:csrfMetaTags/>
    <%-- 위 태그립을 사용하면 아래와 같이 자동 생성해줌 --%>
    <%-- <meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/> --%>
</head>
<body>

 <div class="login-container" id="loginContainer">
	<sec:authorize access="isAuthenticated()">
		<h2>로그인된 사용자 정보</h2>
		<p>아이디: <sec:authentication property="name"/></p>
      	<button id="detail">내 정보 보기</button>
        <button id="friendList">친구목록보기</button>
        <button id="checkout" >로그아웃</button>
        
		<%-- <form id="logoutForm" name="logoutForm" method="post" action="logout" style="display: none;">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form> --%>
	</sec:authorize>
		
		<sec:authorize access="!isAuthenticated()">
		<h2>로그인되지 않은 사용자</h2>
		<input type="text" id="memberId" name="memberId" placeholder="아이디">
		      <input type="password" id="memberPassword" name="memberPassword" placeholder="비밀번호"><br>
		<button id="check">로그인</button>
	      <button id="joinMember">회원가입</button>
	      <button id="findIdPw">ID/PW찾기</button>
	</sec:authorize>
</div>

<div>
	<h2>로그인되지 않은 사용자</h2>
	<button id="check">로그인</button>
</div>

<script type="text/javascript">
	$(function() {
		
		$(document).on('click', '#check', function(){
			window.location.href="login"
		}); // end 로그인으로 이동
		
	});
</script>
</body>
</html>
