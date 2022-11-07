<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<a href="${contextPath}/write.do">작성하러 가기</a>

	<table border="1">
		<thead>
			<tr>
				<td>게시글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>삭제</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${frees}" var="free">
				<tr>
					<td>${free.freeNo}</td>
					<td><a href="${contextPath}/detail.do?freeNo=${free.freeNo}">${free.title}</a></td>
					<td>${free.writer}</td>
					<td>${free.hit}</td>
					<td><a href="${contextPath}/delete.do?freeNo=${free.freeNo}"><i class="fa-solid fa-x"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>