<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String domain = request.getParameter("domain");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(domain);
		requestDispatcher.forward(request, response);
	%>
	<form action="">
		사이트명 :
		<select name="domain">
			<option value="https://google.com">구글</option>
			<option value="naver">네이버</option>
			<option value="daum">다음</option>
			<option value="nate">네이트</option>
		</select>
		<button>확인</button>
	</form>
</body>
</html>