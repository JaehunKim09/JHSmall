<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
#span{
font-size: 25px;
}
#product_Info {
	margin-left: 500px;
}
#btn {
	margin-left: 600px;
	height: 50px;
	width: 200px;
	border: 0;
}
#question_table1{
width:900px;
height:130px;
}
#question_table2{
width:700px;
height:50px;
}
.a_tag2{
text-decoration:none;
color:black;
}
.a_tag2:hover{
background:black;
color:white;
}

</style>
</head>
<body>
<form name="formm" method="post">
<div id="big">
<div id="header">
				<jsp:include page="../include/header.jsp"></jsp:include>
			</div>
					<!-- header -->
		<div id="small">
		<jsp:include page="../include/nav_mypage.jsp"/>

		<hr>
			<div id="product_Info">
			<span id="span">문의내역&nbsp;&nbsp;&nbsp; </span>
				<input type='button' class='btn' name='btn' value='자주하는질문' onclick="location.href='ShopServlet?command=question_main'">
				<input type='button' class='btn' name='btn' value='1:1문의하기' onclick="location.href='ShopServlet?command=ask'">
			<br><br>
			
			<table id="question_table1">
		<tr style="background:black; color:white">
			<th colspan="2">번호</th>
			<th colspan="2">일자</th>
			<th colspan="2">제목</th>
			
		</tr>
		<c:forEach items="${mtmVO}" var="mtmVo">
		<tr>	
			<th colspan="2">${mtmVo.mNum}</th>
			<th colspan="2"><fmt:formatDate value="${mtmVo.mDate}" type="date"/></th>
			<th colspan="2"><a href="ShopServlet?command=mypage_7&mNum=${mtmVo.mNum}">${mtmVo.title}</a></th>
			
		</tr>
		</c:forEach>
		</table>
		<br><br>
			</div>
</div><!-- small -->

</div><!-- big -->
<div id="footer">
			<jsp:include page="../include/footer.jsp"></jsp:include></div>
</form>
</body>
</html>