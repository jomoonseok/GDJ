<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />

<script>
	if (${param.result} > 0) {
		alert('게시글이 삽입되었습니다.');
		location.href = '${contextPath}/list.do';
	} else {
		alert('게시글이 삽입되지 않았습니다.');
		history.back();
	}
</script>