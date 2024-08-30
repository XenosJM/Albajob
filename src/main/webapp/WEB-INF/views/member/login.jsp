<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--시큐리티 태그를 사용하귀 위해 입력. --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <sec:csrfMetaTags/>
    <title>Login</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
   
</head>
<body>
    <h2>로그인</h2>
    <form id="loginForm" method="post" action="../member/memberCheck">
        <label for="memberId">아이디:</label>
        <input type="text" id="userName" name="userName" required><br><br>
        
        <label for="memberPassword">비밀번호:</label>
        <input type="password" id="userPassword" name="userPassword" required><br><br>
        <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
        <input type="submit" value="로그인">
    </form>
</body>
</html>
