<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "${pageContext.request.contextPath}/"> 
		<img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzA3MDVfODYg%2FMDAxNjg4NTQ1MDI3ODMw.A2fJ1QMSdgIs0x72f_ELjZ84R5jkESa2jPlZb_iG_Ukg.79RJuN7Psj4mrphOdMVE9EvM0yvIovezyv_rwkLg-rUg.JPEG.gursoa%2F6.jpg&type=a340">
	</a>
	<a href="${pageContext.request.contextPath}/board">게시판</a>
	<a href="${pageContext.request.contextPath}/board/new"> 새글쓰기 </a>
	
	<c:if test = "${empty currentUser }">
		<a href="${pageContext.request.contextPath}/login"> 로그인 </a>
		<a href="${pageContext.request.contextPath}/register">회원가입 </a>
	</c:if>
	<c:if test = "${not empty currentUser }">
		${currentUser.name }님 안녕하세요.
		<a href="${pageContext.request.contextPath}/logout"> 로그아웃 </a>
	</c:if>
글쓰기
	<div>
		<form:form action="${pageContext.request.contextPath}/board/new" method="POST" modelAttribute="boardVO">
			<table>
				<tr>
					<th>제목</th>
					<td><form:input path="title" />  <form:errors path="title"/></td>
				</tr>
				<tr>
					<th>글쓴이</th>
					<td><form:input path="writer" /> <form:errors path="writer"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><form:input path="content" /> <form:errors path="content"/></td>
				</tr>
			
			</table>
			<input type="submit" value="새글 쓰기">
		</form:form>
	</div>
</body>
</html>