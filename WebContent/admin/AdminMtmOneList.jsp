<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#small {
	padding-bottom: 200px; 
	margin-left:30%;
	padding-top : 100px;
}
</style>
</head>
<body>
<jsp:include page="../include/admin_header.jsp"/>
<div id = small>
<form method="post" action="ShopServlet?command=Admin_mtm_reply_update&mNum=${admtm.mNum}">


		<p>분류&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${admtm.mKind}</p>
		<hr style="width: 900px;">
		<p>일자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${admtm.mDate}</p>
		<hr style="width: 900px;">
		<p>제목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${admtm.title}</p>
		<hr style="width: 900px;">
		<p>문의내용&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${admtm.content}</p>
		<hr style="width: 900px;">
		<p>답변내용<input type="text" name="reply" value="${admtm.reply}"></p>
		
		<input type="submit" value="답변달기">
		
</form>
</div>
</body>
</html>