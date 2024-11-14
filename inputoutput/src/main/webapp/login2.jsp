<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹 폼</title>
<style>
label{
font-size:14px;
line-height:25px;
}
</style>
</head>
<body>
<form method = "get" action = "login" encType="UTF-8">
<fieldset>
<label>아이디: <input type= "text" size="10" name="user_id"></label>
<label>비밀번호: <input type="password" size="10" name="user_pw"></label>
<input type="submit" value="로그인">
</fieldset>
</form>
</body>
</html>