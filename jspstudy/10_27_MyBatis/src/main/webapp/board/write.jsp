<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('#btn_list').click(function(){
			location.href='${contextPath}/board/list.do';
		});
		
	});
</script>
</head>
<body>
	<div>
		<form method="post" action="${contextPath}/board/add.do">
			<table border="1">
				<thead>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title"></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>내용</td>
						<td><textarea rows="10" cols="50" name="content"></textarea></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<button>등록</button>
							<input type="button" value="목록" id="btn_list">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>