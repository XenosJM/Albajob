<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--시큐리티 태그를 사용하귀 위해 입력. --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<!-- 메인페이지 css -->
<link rel="stylesheet" href="resources/css/mainPage.css">
</head>  
	<body>
		<header class="bg-primary text-white text-center py-1">
			<p>최고의 일자리를 찾아보세요!</p>
		    <!-- 현재 상황으로선 정적으로 이루어진 상태 추후에는 js를 이용해 데이터 변경과 입력 및 삭제가 가능하도록 변경 해볼 것. -->
			<section class="main">
				<div class="container left">
					<form action="search/searchList/" method="get">
			           	<input class="input-box" id="searchKeyword" type="text" size="20" maxlength="20" placeholder="검색어를 입력하세요...">
			            <div class="dropdown-menu" id="dropdownMenu"></div>
					</form>
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
		<div id="contents field">
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
		</div>
		<footer class="bg-light text-center py-2">
			<p>© 2023 구인/구직 사이트. 목쌤이 모든 권리 보유.</p>
		</footer>
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<!--  메인페이지 js 코드 -->
		<script src="resources/javascript/mainPage.js"></script>
	</body>
</html>
