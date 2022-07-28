<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#small {
	padding-bottom: 200px; 
	margin-left:30%;
	padding-top:100px;
}
#big {
	min-height: 100%;
	position: relative;
}
/* #search{
height: 100%;
} */
</style>
</head>
<body>
<jsp:include page="../include/admin_header.jsp"/>
<div id="big">
<div id = small>
<h1>관리자 1:1문의 관리</h1>
<form name="formm" method="post" action="ShopServlet">
<input type="hidden" name="command" value="Admin_mtmList">
<table border="1px" style="border-collapse: collapse;">
	<tr>
		<th>아이디</th><th>제목</th><th>내용</th><th>리플</th><th>일자</th>
	</tr>
	<br><br><br><br>
		<div id="search">
			<input id="input" type="search" placeholder="검색ID 입력" name="search2">
			<button id="input_but" type="submit">검색</button>
		</div>
	<c:forEach items="${mtm}" var="mtmList">
	<tr>
		<td>${mtmList.id}</td>
		<td><a href="ShopServlet?command=Admin_mtm_one_list&mNum=${mtmList.mNum}">${mtmList.title}</a></td>
		<td>${mtmList.content}</td>
		<td>${mtmList.reply}</td>
		<td>${mtmList.mDate}</td>
	</tr>
</c:forEach>
<%-- <a href="ShopServlet?command=mypage_7&mNum=${mtmVo.mNum}">${mtmVo.title}</a> --%>

</table>
</form>
</div><!-- small -->
</div><!--big  -->

</body>
</html>