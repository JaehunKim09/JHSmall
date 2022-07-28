<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#admin_review_table{
margin-left:370px;
border:1px solid black;
border-collapse:collapse;
}
#admin_review_table th,td{
width:100px;
border:1px dotted black;
}
#small {
	padding-bottom: 200px; 
	margin-left:10%;
	padding-top : 100px;
}
</style>
</head>
<body>
<jsp:include page="../include/admin_header.jsp"/>
<div id = small>

<form method="post" action="ShopServlet">
	<input type="hidden" name="command" value="insert_rReply">
	<table id="admin_review_table">
		<tr>
			<th>상품번호</th>
			<th>아이디</th>
			<th>리뷰번호</th>
			<th>내용</th>
			<th>리뷰 이미지</th>
			<th>댓글 달기</th>
			<th>작성일자</th>
			<th>비고</th>
		</tr>
		<c:forEach items="${review}" var="review">
			<tr>
				<td>${review.pNum}</td>
				<td>${review.id}</td>
				<td><input type="text" name="rNum" value="${review.rNum}" readonly="readonly" style="border:0"></td>
				<td>${review.content}</td>
				<td><img src="${review.rImg}">이미지</td>			
				<td><input type="text" name="rReply" value="${review.rReply}"><br>
					<input type="submit" value="댓글 저장">
				<td><fmt:formatDate value="${review.rDate}" /></td>
				<td class="td"><a
					href="ShopServlet?command=admin_review_delete&rNum=${review.rNum}"
					class="delete">삭제</a>
			</tr>
		</c:forEach>
	</table>
</form>
</div>
</body>
</html>