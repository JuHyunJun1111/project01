<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 보기</title>
</head>
<body>
<div id="nav">
 <%@ include file="../include/nav.jsp" %>
</div>

	<form method="post">
	
		<hr>
		<div class="title" style="font-size:30px">
			${view.title}
		</div>
		<hr>
		
		<div class="writer">
			<span>작성자 : </span>${view.writer}
		</div>
		<hr>
		
		<div class="content">
			${view.content}
		</div>
		<hr>

		<div>
			<a href="/board/modify?bno=${view.bno}">수정</a>, <a href="/board/delete?bno=${view.bno}">삭제</a>
		</div>
	
	</form>


</body>
</html>