<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('#frm_edit').submit(function(event){
			if($('#name').val() == '' || $('#addr').val() == ''){
				alert('이름과 주소는 필수입니다.');
				event.preventDefault();
				return;
			}
		});
		
		$('#btn_remove').click(function(){
			if(confirm('삭제할까요?')){
				location.href='${contextPath}/remove?no=' ${contact.no}
			}
		});
		
		$('#btn_list').click(function(){
			location.href='${contextPath}';
		});
		
	});
</script>
</head>
<body>

	<h3>연락처 보기</h3>
	
	<div>
		<form id="frm_edit" action="${contextPath}/modify" method="get">
			<div>
				<label for="name">이름</label><br>
				<input type="text" name="name" id="name" value="${contact.name}">
			</div>
			<br>
			<div>
				<label for="tel">전화</label><br>
				<input type="text" name="tel" id="tel" value="${contact.tel}">
			</div>
			<br>
			<div>
				<label for="addr">주소</label><br>
				<input type="text" name="addr" id="addr" value="${contact.addr}">
			</div>
			<br>
			<div>
				<label for="email">이메일</label><br>
				<input type="text" name="email" id="email" value="${contact.email}">
			</div>
			<br>
			<div>
				<label for="note">비고</label><br>
				<input type="text" name="note" id="note" value="${contact.note}">
			</div>
			<br>
			<div>
				<button>수정하기</button>
				<input type="button" value="삭제하기" id="btn_remove">
				<input type="button" value="전체연락처" id="btn_list">
			</div>
		</form>
	</div>

</body>
</html>