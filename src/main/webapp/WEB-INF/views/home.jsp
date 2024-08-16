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
    
    .input-box {
	    width: 100%;
	    max-width: 500px; /* 최대 너비 설정 */
	    height: 40px;
	}
	
	/* GNB 기본 스타일 */
	.header-gnb-base {
	    background-color: white;
	    padding: 10px;
	}
	
	/* 메뉴 리스트 스타일 */
	.header-gnb-base_menu {
	    list-style-type: none;
	    margin: 0;
	    padding: 0;
	    display: flex;
	}
	
	/* 개별 메뉴 아이템 스타일 */
	.header-gnb-base_menu .menu-item {
	    margin-right: 20px;
	}
	
	/* 링크 스타일 */
	.header-gnb-base_menu .menu-item a {
	    text-decoration: none;
	    color: black;
	    padding: 10px;
	    display: block;
	}

	/* 메뉴 아이템에 마우스를 올렸을 때 */
	.header-gnb-base_menu .menu-item a:hover {
	    background-color: orange;	
	}
	
	.menu-item {
	  position: relative;
	  margin-right: 1rem;
	  color: white;
	  cursor: pointer;
	}
	
	.menu-item .dropdown-menu {
	  display: none;
	  position: absolute;
	  top: 100%;
	  left: 0;
	  background-color: white;
	  padding: 0.5rem;
	  min-width: 150px;
	  box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
	}
	
	.menu-item .dropdown-menu a {
	  color: black;
	  text-decoration: none;
	  display: block;
	  padding: 0.5rem;
	}
	
	.menu-item .dropdown-menu a:hover {
	  background-color: orange;
	}
	
	.menu-item:hover .dropdown-menu {
	  display: block;
	}
    
	</style>  
</head>  
	<body>
		<header class="bg-primary text-white text-center py-1">
			<p>최고의 일자리를 찾아보세요!</p>
		    <!-- 현재 상황으로선 정적으로 이루어진 상태 추후에는 js를 이용해 데이터 변경과 입력 및 삭제가 가능하도록 변경 해볼 것. -->
			<section class="main">
				<div class="container left">
		           	<input class="input-box" type="text" size="20" maxlength="20" placeholder="검색어를 입력하세요...">
		            <div class="dropdown-menu" id="dropdownMenu"></div>
		        </div>
				<nav class="header-gnb-base">
					<div class="left">
						<ul class="header-gnb-base_menu">
							<li class="menu-item">
								<a id="job-info" href="job/info">
									<span>
										채용정보
									</span>
								</a>
								<div class="dropdown-menu">
									<a href="#">추가 메뉴1</a>
									<a href="#">추가 메뉴2</a>
									<a href="#">추가 메뉴3</a>
								</div>
							</li>
							
							<li class="menu-item">
								<a id="job-info" href="job/brand">
									<span>
										브랜드 알바
									</span>
								</a>
							</li>
							
							<li class="menu-item">
								<a id="job-info" href="user-service">
									<span>
										회원 서비스
									</span>
								</a>
							</li>
							
							<li class="menu-item">
								<a id="job-info" href="human-resource">
									<span>
										인재정보
									</span>
								</a>
							</li>
							
							<li class="menu-item">
								<a id="job-info" href="alba-talk/home">
									<span>
										채용정보
									</span>
								</a>
							</li>
							
							<li class="menu-item">
								<a id="job-info" href="service-center/register">
									<span>
										고객센터
									</span>
								</a>
							</li>
							
						</ul>
					</div>
					<div class="right">
				        <button class="btn btn-primary right" id="memberLogin">로그인</button>
				        <button class="btn btn-success right" id="memberRegist">회원가입</button>
					</div>
				</nav>
				<div id="additional-gnb">
					
				</div>
			</section>
		</header>
		
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
		
		<section class="container" id="platinum">
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
		
		<section class="container" id="gold">
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
		
		<section class="container" id="silver">
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
		 	
		 	$(document).on('mouseover', '#additional-nav', function(){
		 		
		 	});
		 	
		 	
		})
		</script>
	</body>
</html>
