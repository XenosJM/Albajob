<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>검색</title>
</head>
<body>
	<div class="container">
		<h1>검색 페이지</h1>
		<br> <br>
		<div>
			<div>
				<form action="" method="get">
					<p>시·도</p>
					<select id="selectCity" name="selectCity">
						
					</select>
					<input type="submit" value="검색">
					<select class="pageSize" id="pageSize" name="pageSize" onChange="pageChange()">
						<option value="20"
							<c:if test="${spagination.pageSize == 20 }">selected</c:if>>20개	보기
						</option>
						<option value="30"
							<c:if test="${spagination.pageSize == 30 }">selected</c:if>>30개	보기
						</option>
						<option value="40"
							<c:if test="${spagination.pageSize == 40 }">selected</c:if>>40개	보기
						</option>
						<option value="50"
							<c:if test="${spagination.pageSize == 50 }">selected</c:if>>50개	보기
						</option>
					</select>
				</form>
				<br>
				<ul>
					<c:if test="${sPageMaker.isPrev() }">
						<li>
						<a href="list?startDate=${sPagination.startDate }&endDate=${sPagination.endDate }&pageNum=${sPageMaker.startNum - 1 }&pageSize=${sPagination.pageSize}">이전</a></li>
					</c:if>
					<c:forEach begin="${sPageMaker.startNum }" end="${sPageMaker.endNum }" var="num">
						<li>
						<a href="list?startDate=${sPagination.startDate }&endDate=${sPagination.endDate }&pageNum=${num }&pageSize=${sPagination.pageSize}">${num }</a></li>
					</c:forEach>
					<c:if test="${sPageMaker.isNext() }">
						<li>
						<a href="list?startDate=${sPagination.startDate }&endDate=${sPagination.endDate }&pageNum=${sPageMaker.endNum + 1 }&pageSize=${sPagination.pageSize}">다음</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			getAllCity();
			
			function getAllCity() {
				let url = '../location/city';
				console.log('url' + url);
				$.getJSON(
					url,
					function(data) {
						let citylist = '';
						console.log(data);
						
						$(data).each(function(){
							console.log(this);
							citylist += '<option value="' + this.cityId + '">'
							+ this.cityName
							+ '</option>';
						}); // end each
						
						$('#selectCity').html(list);
					} // end data					
				); // end JSON
				
			} // end getAllCity()
			
		}); // end document
	</script>
</body>
</html>