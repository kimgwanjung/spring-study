<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</body>
</html>