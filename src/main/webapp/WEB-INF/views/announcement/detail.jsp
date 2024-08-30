<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고 세부사항</title>
</head>
<body>
	<form id="insertAnnouncement">
		공고 이름 : <input type="text" name="announcementName" value="${announcementVO.announcementName }">
		급여 : <input type="text" name="pay" value="${announcementVO.pay }">
		업직종 : <input type="text" name="jobName" value="${announcementVO.jobName }">
		근무기간 : <input type="text" name="workPeriod" value="${announcementVO.workPeriod }">
		근무요일 : <input type="text" name="workDay" value="${announcementVO.workDay }">
		근무시간 : <input type="text" name="workTime" value="${announcementVO.workTime }">
		모집인원 : <input type="text" name="recruitNumber" value="${announcementVO.recruitNumber }">
		근무지역 : <input type="text" name="cityName" value="${announcementVO.cityName }">
		담당자 이름 : <input type="text" name="managerName" value="${announcementVO.managerName }">
		담당자 전화 : <input type="text" name="managerPhone" value="${announcementVO.managerPhone }">
	</form>
</body>
</html>