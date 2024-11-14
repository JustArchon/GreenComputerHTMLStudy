<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
<%
	request.setCharacterEncoding("utf-8");
	String color = request.getParameter("color");
%>
div
{
	background-color:${color};
}
</style>
</head>
<body>
<div>
	<fieldset>
	<legend>색상 정보</legend>
	<h3> 선택한 색상 : <%= color %></h3>
	</fieldset>
</div>
</body>
</html>