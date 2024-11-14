<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String user_id=request.getParameter("user-id");
	String user_pwd1=request.getParameter("pwd1");
	String user_pwd2=request.getParameter("pwd2");
	String user_name=request.getParameter("user-name");
	String user_mail=request.getParameter("mail");
	String user_phone=request.getParameter("phone");
	String user_bloghome=request.getParameter("homep");
%>
<fieldset>
<legend>회원 정보</legend>
<h3> 아이디: <%= user_id %></h3>
<h3> 비밀번호: <%= user_pwd1 %></h3>
<h3> 비밀번호 확인: 
<%
if (user_pwd1.equals(user_pwd2)) { 
%>
<%= "비밀번호가 일치합니다." %>
<%
} else { 
%>
<%= "비밀번호가 일치하지 않습니다." %>
<% }; %>
</h3>
<h3> 이름: <%= user_name %></h3>
<h3> 메일 주소: <%= user_mail %></h3>
<h3> 연락처: <%= user_phone %></h3>
<h3> 블로그/홈페이지: <%= user_bloghome %></h3>
</fieldset>

</body>
</html>