<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
	String subject=request.getParameter("subject");
	String[] subscribe = request.getParameterValues("mailing");
	String topics = String.join(", ", subscribe);
	
%>
<body>
	<fieldset>
		<legend>구독 정보</legend>
		<h3> 과목 :  <%= subject %></h3>
		<ul>
		<% for(String topic : subscribe) {%>
			<li> 뉴스 주제 :  <%= topic %></li>
		<% } %>
		</ul>
	</fieldset>
</body>
</html>