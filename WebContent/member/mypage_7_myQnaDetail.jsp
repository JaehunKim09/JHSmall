<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<!-- ���������� �� ���ǳ��� -->
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
	padding-bottom: 200px; /* footer�� ���� */
}
#but{
	margin: auto;
	width: 100px;
	background-color: darkblue;
	color: white;
}
.a_tag2{
text-decoration:none;
color:black;
}
.a_tag2:hover{
background:black;
color:white;
}
.p_tag{
margin-left:510px;
}
#p_but{
margin-top:50px;
margin-left:800px;
}
</style>
</head>
<body>
	<div id="big">
		<div id="small">
		
		<!-- header -->
		<jsp:include page="../include/header.jsp"/>
		
		<!-- mypage_nav -->
		<jsp:include page="../include/nav_mypage.jsp"/>

		<hr style="width: 900px;">
		<p class="p_tag">�з�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mtm.mKind}</p>
		<hr style="width: 900px;">
		<p class="p_tag">����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mtm.mDate}</p>
		<hr style="width: 900px;">
		<p class="p_tag">����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mtm.title}</p>
		<hr style="width: 900px;">
		<p class="p_tag">���ǳ���&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mtm.content}</p>
		<hr style="width: 900px;">
		<p class="p_tag">�亯����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${mtm.reply}</p>
		
		<div id="p_but">
		<input type="button" value="�����ϱ�" id="but" onclick="location.href='ShopServlet?command=mtmUpdateForm&mNum=${mtm.mNum}'">
		<input type="button" value="�����ϱ�" id="but" onclick="location.href='ShopServlet?command=mtmDelete&mNum=${mtm.mNum}'">
		</div> 
		
	</div><!-- mypage_div -->
	</div><!-- small -->
</div><!-- big -->
	<div id="footer">
		<jsp:include page="../include/footer.jsp"></jsp:include>
	</div>
</body>
</html>