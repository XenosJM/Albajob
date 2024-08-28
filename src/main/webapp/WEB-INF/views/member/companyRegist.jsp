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
    <h2>회사 회원 가입</h2>
    <form action="registerCompanyMember" method="post">
        <div class="form-group">
            <label for="userName">User Name (ID)</label>
            <input type="text" id="userName" name="userName" required>
        </div>
        <div class="form-group">
            <label for="userPassword">Password (비밀번호)</label>
            <input type="password" id="userPassword" name="userPassword" required>
        </div>
        <div class="form-group">
            <label for="userPhone">Phone Number (전화번호)</label>
            <input type="text" id="userPhone" name="userPhone" required>
        </div>
        <div class="form-group">
            <label for="userMail">Email (이메일)</label>
            <input type="email" id="userMail" name="userMail" required>
        </div>
        <div class="form-group">
            <label for="companyNumber">Company Number (사업자등록번호)</label>
            <input type="text" id="companyNumber" name="companyNumber" required>
        </div>
        <div class="form-group">
            <label for="companyName">Company Name (회사/점포 이름)</label>
            <input type="text" id="companyName" name="companyName" required>
        </div>
        <div class="form-group">
            <label for="path">Sign-up Path (가입경로)</label>
            <input type="text" id="path" name="path">
        </div>
        <div class="form-group">
            <label for="membership">Membership (멤버쉽)</label>
            <input type="text" id="membership" name="membership">
        </div>

        <button type="submit" class="button btn-blue">가입하기</button>
        <button type="reset" class="button btn-green">초기화</button>
    </form>
</div>

</body>
</html>
