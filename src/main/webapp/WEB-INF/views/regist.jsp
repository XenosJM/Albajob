<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 선택</title>
<style>
    body {
        text-align: center;
        padding: 50px;
        font-family: Arial, sans-serif;
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

    <button class="button btn-blue" id="individualMember">개인회원으로 가입하기</button>
    <button class="button btn-green" id="companyMember">기업회원으로 가입하기</button>

    <script type="text/javascript">
        document.getElementById('individualMember').onclick = function() {
            window.location.href = "member/memberRegist";
        };

        document.getElementById('companyMember').onclick = function() {
            window.location.href = "member/companyRegist";
        };
    </script>

</body>
</html>
