<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" /> 
                           <%-- <%=request.getcontextPath%> --%>
<!-- index.jsp는 webapp에 있어야 웰컴파일로 동작할 수 있다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3><a href="${contextPath}/today.do">오늘은 며칠입니까?</a></h3>
	<%-- jsp가 jsp를 부르는 것이 model1 --%>
	<h3><a href="${contextPath}/now.do">지금은 몇시입니까?</a></h3>
	<%-- .do가 확장명처럼 들어간다. --%>
	<h3><a href="${contextPath}/input.do">입력화면으로 이동하기</a></h3>
	
</body>
</html>