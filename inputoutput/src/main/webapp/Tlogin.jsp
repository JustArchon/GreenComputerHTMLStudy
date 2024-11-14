<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<legend>로그인 정보</legend>
<h3> 아이디 : ${user_id }</h3>
<h3> 비밀번호 : ${user_pw }</h3>
<h3> 로그인 결과 : ${message }</h3>
<a href="javascript:history.back();">뒤로가기</a>
</body>
</html>