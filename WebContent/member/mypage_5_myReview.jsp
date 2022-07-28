<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
html, body {
	margin: 0;
	padding: 0;
	height: 100%;
}
#big {
	min-height: 100%;
	position: relative;
}
#small {
	padding-bottom: 200px; /* footer의 높이 */
}
#product_info_table {
	border-bottom: 1px solid black;
	width: 900px;
	height: 130px;
	margin-left: 500px;
	margin-top : 20px;
}
#product_info_table td {
	height: 200px;
	text-align: center;
}
.img_myreview {
	width: 150px;
	height: 150px;
	margin: 0;
}
.a_tag2 {
	text-decoration: none;
	color: black;
}
.a_tag2:hover {
	background: black;
	color: white;
}
</style>
</head>
<body>
	<div id="big">
		<div id="small">

		<jsp:include page="../include/header.jsp"></jsp:include>
		
		<jsp:include page="../include/nav_mypage.jsp"/>

			<br><br>
			<div id="product_Info">
		<hr>
		<table id="product_info_table">
		
			<tr style="background:black; color:white">
				<th colspan="2">상품명</th>
				<th style="width:400px">상품평</th>
				<th style="width:150px">작성일</th>
			</tr>
		<c:forEach items="${rList}" var="review">
			<tr>
				<td><img src="${review.pImg}" class="img_myreview"></td>
				<td>${review.pName}</td>
				<td>${review.content}<br>
				<details>
					<summary>댓글 확인하기</summary>
					<c:choose>
						<c:when test="${empty review.rReply}">
							<b>아직 댓글이 없습니다.</b>
						</c:when>
						<c:otherwise>
							<b>운영자 : ${review.rReply}</b>
						</c:otherwise>
					</c:choose>
				</details>
				</td>
				<td><fmt:formatDate value="${review.rDate}"></fmt:formatDate></td>
			</tr>
		</c:forEach>
		</table>
			</div>						
		</div>
		<!-- small -->
		<div id="footer">
			<jsp:include page="../include/footer.jsp"></jsp:include></div>
	</div>
	<!-- big -->
</body>
</html>