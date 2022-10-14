<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<form method="get" action="02_parameter2.jsp">
			<div>
				<input type="text" name="a"> <!-- name으로 보내면 request에 parameter, EL 사용이 가능한 4개 영역으로 보내면 request에 attribute -->
			</div>
			<div>
				<input type="text" name="b">
			</div>
			<div>
				<input type="submit" value="전송">
			</div>
		</form>
	</div>

</body>
</html>