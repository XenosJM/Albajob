<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록한 공고 목록</title>
</head>
<body>
	<div class="announcement-list">
		<c:forEach var="announcementVO" items="${announcementList }">
			<div class="announcement-item">
				<p>공고 번호 : ${announcementVO.announcementId }</p>
				공고 이름 : <a href="../announcement/detail?announcementId=
				${announcementVO.announcementId }">${announcementVO.announcementName }</a>
			</div>
		</c:forEach>
	</div>
</body>
</html>