<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
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
		
		$('#btn_delete').click(function(){
			if(confirm('정말 삭제하시겠습니까?')){
				location.href='${contextPath}/board/delete.do?boardNo=${board.boardNo}';
			}
		});
		
	});
</script>
</head>
<body>
	<div>
		<form action="${contextPath}/board/modify.do" method="post">
			<table border="1">
				<thead>
					<tr>
						<td>순번</td>
						<td><input type="text" name="boardNo" value="${board.boardNo}" readonly></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${board.writer}</td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" value="${board.title}"></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>내용</td>
						<td><textarea name="content" rows="5" cols="30">${board.content}</textarea></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<button>수정</button>
							<input type="button" value="목록" id="btn_list">
							<input type="button" value="삭제" id="btn_delete">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>