<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 로그인 성공 시 session에 id, pwd 저장된 상태임 --%>
	<% 
		Object id = session.getAttribute("id");   // session은 서버에 저장된다.
		Object pwd = session.getAttribute("pwd");
	%>
	
	<% if(id != null && pwd != null) { %>
		${id}님 환영합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="로그아웃" id="btn_logout">
	<% } else { %>
		<div>
			<form method="post" action="02_login.jsp">
				<div>
					<input type="text" name="id" placeholder="아이디">
				</div>
				<div>
					<input type="password" name="pwd" placeholder="비밀번호">
				</div>
				<div>
					<button>로그인</button>
				</div>
			</form>
		</div>
	<% } %>
	
	<script>
		document.getElementById('btn_logout').onclick = function() {
			location.href = '03_logout.jsp'
		}
	</script>

</body>
</html>