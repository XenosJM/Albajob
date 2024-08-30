<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고 등록</title>
</head>
<body>
	<form id="insertAnnouncement" action="../insert" method="post">
		이름 : <input type="text" name="announcementName" required>
		급여 : <input type="text" name="pay" required>
		업직종 : <input type="text" name="jobName" required>
		근무기간 : <input type="text" name="workPeriod" required>
		근무요일 : <input type="text" name="workDay" required>
		근무시간 : <input type="text" name="workTime" required>
		모집인원 : <input type="text" name="recruitNumber" required>
		근무지역 : <input type="text" name="cityName" required>
		담당자 이름 : <input type="text" name="managerName" required>
		담당자 전화 : <input type="text" name="managerPhone" required>
	</form>
</body>
</html>