<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script type="text/javascript">
	function showReplyList(){
		// 1. ajax reply list select
		// 2. 화면에 보여줘!
		
		$.ajax({
			url 	: '${pageContext.request.contextPath}/reply/${boardVO.no}',
			method 	: 'get',
			success : function(data){
				console.log(data)
				console.log(typeof data)
				$('#replyList').empty();
				
				$(data).each(function(){
					str = '<hr>';
					str += '<strong>' + this.content + '</strong>';
					str += '&nbsp;' + this.writer +'&nbsp;';
					str += '&nbsp;' + this.regDate + '&nbsp;';
					str += '<button type class = "delBtn" id = ' + this.no + '>삭제 </button>';
					
					$('#replyList').append(str)
				})
				// 보여줄 것
			},
			error 	: function(){
				alert('showReplyList 실패')
			}
		})
		
	}
	$(document).ready(function(){
		showReplyList();
		
		
		$(document).on('click', '.delBtn', function(){
			alert('삭제할까말까~?~?~??~~?~~?~?~?~')
			let replyNo = $(this).attr('id');
			$.ajax({
				url		: '${pageContext.request.contextPath}/reply/'+ replyNo,
				method	: 'delete',
				success : function(){
					showReplyList();
					alert('delete 성공')
				},
				error	: function(){
					
					alert('delete 실패')
				}
			})
		})
		$('#replyAddButton').click(function(){
			
			let replyContent = document.reply.content.value;
			let replyWriter = document.reply.writer.value;

			$.ajax({
				url 	: '${pageContext.request.contextPath}/reply',
				method 	: 'post',
				data 	: {
					boardNo : ${boardVO.no},
					content	: replyContent,
					writer	: replyWriter,
					
				},
				success	: function(){

					document.reply.content.value = "";
					document.reply.writer.value = "";
					showReplyList();
				},
				error 	: function(){
					
					alert('메롱~ 실패')
				}
			})
		})
	})
</script>
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
게시판 상세페이지
	<div align="center">
		<table border = "1" width = "60%">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>지은이</th>
				<th>내용</th>
				<th>작성일</th>
				<th>댓글수</th>
			</tr>
			<tr>
				<td>${boardVO.no}</td>
				<td>${boardVO.title}</td>
				<td>${boardVO.writer}</td>
				<td>${boardVO.content}</td>
				<td>${boardVO.regDate}</td>
				<td>${boardVO.count}</td>
			</tr>
		</table>
		
		<input type="button" value="Home" onclick="location.href='${pageContext.request.contextPath}/'">
		<input type="button" value="목록으로" onclick="location.href='${pageContext.request.contextPath}/board'">
		<input type="button" value="삭제" onclick="location.href='${pageContext.request.contextPath}/'">
	</div>
	<div>
	<form name ="reply">

		댓글: <input type="text" size="100" name="content">
		작성자: <input type="text" size="20" name="writer">
		<input type="button" value="댓글쓰기" id = "replyAddButton">
	</form>
		
	</div>
	<div id="replyList">
		
	</div>
</body>
</html>