<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
<style>
*{
	font-family: 'Poor Story', cursive;
}
#p_container_footer {
	border-top:1px solid black;
	width: 100%;
	height: 130px; /* footer의 높이 */
	position: absolute;
    bottom: 0;
    left: 0;
}
#group1{
text-align:top;
display:inline-block;
padding-left:100px;
width:465px;
text-align:left;
color:gray;
}
#group2{
display:inline-block;
top:10px;
left:800px;
color:gray;
width:400px;
font-size:10px;
text-align:top;
}
.a_tag3{
text-decoration:none;
color:black;
}
.a_tag3:hover{
color:red;
}
</style>
</head>
<body>
<div id="p_container_footer">
	<div id="container">
		<div id="group1">
		<span style="font-size:30px"><b><a href="ShopServlet?command=index" class="a_tag3">JHS Mall</a></b></span>
		<hr>
		<span style="font-size:15px">BRANDHISTORY AS안내 FAQ 이용약관
		개인정보취급방침 SITEMAP</span>
		<a href="ShopServlet?command=admin_main">AdministratorPage</a>
		</div>
		
		<div id="group2">
		<br>
		<span style="font-size:20px;"><b>사업자 관련 내용</b></span><br><br>
		<span style="font-size:15px">
		대표자 : 아무개<br>
		대표번호 : 070-865-9912<br>
		주소 : 서울시 송파구 가락시장 1층 어묵수산</span>
		</div>
	</div>	
</div>
</body>
</html>