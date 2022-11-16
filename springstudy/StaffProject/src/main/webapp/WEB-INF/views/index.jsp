<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
	
	$(function(){
		fn_getList();
		fn_addStaff();
		fn_selectStaff();
	});
	
	function fn_getList(){
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType: 'json',
			success: function(resData){
				
				$('#tbl_staff').empty();
				
				$.each(resData, function(i, staff){
					var tr = '<tr>';
					tr += '<td>' + staff.sno + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					tr += '</tr>';
					$('#tbl_staff').append(tr);
				});
				
				/*  다른 방법
				$('<tr>')
				.append($('<td>').text(staff.sno) )
				.append($('<td>').text(staff.name) )
				.append($('<td>').text(staff.dept) )
				.append($('<td>').text(staff.salary) )
				.appendTo('#tbl_staff');
				*/
			}
		});
	}
	
	function fn_addStaff(){
		$('#btn_addStaff').click(function(){
			if( /^[0-9]{5}$/.test($('#sno').val()) == false){
				alert('사원번호는 5자리 숫자입니다.');
				return;
			}else if( /^[가-힣]{3,5}$/.test($('#dept').val()) == false){
				alert('부서번호는 3~5자리 한글입니다.');
				return;
			}
			$.ajax({
				type: 'post',
				url: '${contextPath}/add',
				data: $('#frm_staff').serialize(), 
				// data: 'sno=' + $('#sno').val() + '&name=' + $('#name').val() + '&dept=' + $('#dept').val(), 
				// 협업할 때는 다른 사람들이 어떤 파라미터가 있는지 모르니까 길게 적으면 좋다.
				dataType: 'text',
				//java에서 ajax success로 응답 보내는 법 try
                //              error로 응답 보내는 법 catch
				success: function(resData){
					alert(resData);
					fn_getList();
					$('#sno').val('');
					$('#name').val('');
					$('#dept').val('');
				},
				error: function(jqXHR){
					alert(jqXHR.responseText);
				}
			});
		});
	}
	
	function fn_selectStaff(){
		$('#btn_selectStaff').click(function(){
			if( /^[0-9]{5}$/.test($('#query').val()) == false){
				alert('사원번호는 5자리 숫자입니다.');
				return;
			}
			$.ajax({
				type: 'get',
				url: '${contextPath}/select',
				data: 'query=' + $('#query').val(),
				dataType: 'json',
				success: function(resData){
					$('#tbl_staff').empty();
					var tr = '<tr>';
					tr += '<td>' + resData.sno + '</td>';
					tr += '<td>' + resData.name + '</td>';
					tr += '<td>' + resData.dept + '</td>';
					tr += '<td>' + resData.salary + '</td>';
					tr += '</tr>';
					$('#tbl_staff').append(tr);
				},
				error: function(jqXHR){
					$('#query').val('');
					alert(jqXHR.responseText);
				}
			}); // ajax
		}); // click
			
	}
	
</script>
</head>
<body>

	<h3>사원등록</h3>
	<form id="frm_staff">
		<input type="text" id="sno" name="sno" placeholder="사원번호">
		<input type="text" id="name" name="name" placeholder="사원명">
		<input type="text" id="dept" name="dept" placeholder="부서명">
		<input type="button" value="등록" id="btn_addStaff">
	</form>
	
	<h3>사원검색</h3>
	<form>
		<input type="text" id="query" name="query" placeholder="사원번호">
		<input type="button" value="검색" id="btn_selectStaff">
		<input type="button" value="전체" onclick="fn_getList();">
	</form>
	
	<h3>사원목록</h3>
	<table border="1">
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>부서명</td>
				<td>연봉</td>
			</tr>
		</thead>
		<tbody id="tbl_staff"></tbody>
	</table>
	
</body>
</html>