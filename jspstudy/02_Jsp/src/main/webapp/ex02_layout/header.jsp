<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	if(title == null) {
		title = "환영합니다.";
	}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title%></title>
</head>
<body>
	<header>
		<h1>홈페이지</h1>
		<nav>
			<ul>
				<li><a href="body_economic.jsp">메뉴1</a></li>
				<li><a href="body_society.jsp">메뉴2</a></li>
				<li>메뉴3</li>
				<li>메뉴4</li>
			</ul>
		</nav>
	</header>