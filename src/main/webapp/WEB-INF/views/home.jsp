<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--시큐리티 태그를 사용하귀 위해 입력. --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
	.main {
		background-color: #f8f9fa;
		padding: 10px 0;
		text-align: center;
	}
	
	.job {
		border: 1px solid #ddd;
		border-radius: 5px;
		padding: 20px;
		margin: 20px 0;
	}
	
	.right {
		text-align: right;
	}
	
	.left {
		text-align: left;
	}
	
	.dropdown-menu {
        max-height: 200px;
        overflow-y: auto;
    } /* 검색창 css */
    
    
	</style>  
</head>  
	<body>
		<header class="bg-primary text-white text-center py-1">
			<h1> </h1><p>최고의 일자리를 찾아보세요!</p>
		</header>
		<section class="main">
			<div class="container left">
            	<input class="left" type="text" maxlength="20" autocomplete="off" placeholder="검색어를 입력하세요...">
	            <div class="dropdown-menu" id="dropdownMenu">
	                <!-- 드롭다운 항목들이 동적으로 추가됩니다 -->
	            </div>
	        </div>
			<div class="container right">
		        <button class="btn btn-primary" id="memberLogin">로그인</button>
		        <button class="btn btn-success" id="memberRegist">회원가입</button>
			</div>
		</section>
		
		<section class="container" id="vip">
			<h2> VIP </h2>
			<div class="job">
				<h3>웹 개발자</h3>
				<p>회사: ABC </p>
				<p>위치: 서울</p>
				<p>상세: 웹사이트 개발 및 유지	보수</p>
				<button class="btn btn-secondary">지원하기</button>
			</div>
			<div class="job">
				<h3>UX/UI 디자이너</h3>
				<p>회사: XYZ </p><p>위치: 부산</p>
				<p>상세: 사용자 경험 및 인터페이스 디자인</p>
				<button class="btn btn-secondary">지원하기</button>
			</div>
		</section>
		
		<section class="container">
			<h2> 플래티넘 </h2>
			<div class="job">
				<h3>웹 개발자</h3>
				<p>회사: ABC </p>
				<p>위치: 서울</p>
				<p>상세: 웹사이트 개발 및 유지	보수</p>
				<button class="btn btn-secondary">지원하기</button>
			</div>
			<div class="job">
				<h3>UX/UI 디자이너</h3>
				<p>회사: XYZ </p><p>위치: 부산</p>
				<p>상세: 사용자 경험 및 인터페이스 디자인</p>
				<button class="btn btn-secondary">지원하기</button>
			</div>
		</section>
		
		<section class="container">
			<h2> 골드 </h2>
			<div class="job">
				<h3>웹 개발자</h3>
				<p>회사: ABC </p>
				<p>위치: 서울</p>
				<p>상세: 웹사이트 개발 및 유지	보수</p>
				<button class="btn btn-secondary">지원하기</button>
			</div>
			<div class="job">
				<h3>UX/UI 디자이너</h3>
				<p>회사: XYZ </p><p>위치: 부산</p>
				<p>상세: 사용자 경험 및 인터페이스 디자인</p>
				<button class="btn btn-secondary">지원하기</button>
			</div>
		</section>
		
		<section class="container">
			<h2> 실버 </h2>
			<div class="job">
				<h3>웹 개발자</h3>
				<p>회사: ABC </p>
				<p>위치: 서울</p>
				<p>상세: 웹사이트 개발 및 유지	보수</p>
				<button class="btn btn-secondary">지원하기</button>
			</div>
			<div class="job">
				<h3>UX/UI 디자이너</h3>
				<p>회사: XYZ </p><p>위치: 부산</p>
				<p>상세: 사용자 경험 및 인터페이스 디자인</p>
				<button class="btn btn-secondary">지원하기</button>
			</div>
		</section>
	
		<footer class="bg-light text-center py-2">
			<p>© 2023 구인/구직 사이트. 목쌤이 모든 권리 보유.</p>
		</footer>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		
		<script type="text/javascript">
		$(function(){
			
			/* const token = $("meta[name='_csrf']").attr("content");
        	const header = $("meta[name='_csrf_header']").attr("content");
        	const name = $("#userName").val();
        	
        	$.ajaxSetup({
                beforeSend: function(xhr) {
                    xhr.setRequestHeader(header, token);
                }
            }); */
            
            $(document).on('click', '#memberLogin', function () {
                window.location.href = "login";
            });
            
		 	$(document).on('click', '#memberRegist', function () {
                window.location.href = "regist";
            });
		})
		</script>
	</body>
</html>
