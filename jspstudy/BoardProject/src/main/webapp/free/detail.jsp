<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('#btn_list').click(function(){
			location.href='${contextPath}/list.do';
		});
		
	});
</script>
</head>
<body>

	<h1>자유게시판 게시글 상세보기 화면</h1>
	
	<form action="${contextPath}/modify.do?freeNo=${free.freeNo}" method="post">
		<div>
			게시글번호 ${free.freeNo}
		</div>
		<div>
			작성자 ${free.writer}
		</div>
		<div>
			작성IP ${free.ip}
		</div>
		<div>
			조회수 ${free.hit}
		</div>
		<div>
			<label for="title">제목</label>
			<input type="text" id="title" name="title" value="${free.title}">
		</div>
		<div>
			<label for="content">내용</label>
			<textarea id="content" name="content">${free.content}</textarea>
		</div>
		<div>
			<button>수정</button>
			<input type="button" id="btn_list" value="목록">
		</div>
	</form>
</body>
</html>