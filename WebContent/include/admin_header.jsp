<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
#p_container_header{
position:relative;
width:1500px;
height:200px;
margin:0 auto;
}
#logo{
position:absolute;
width:140px;
height:140px;
left:150px;
top:30px;
}
#login{
position:absolute;
right:50px;
top:0;
font-size:15px;
}
#input{
font-size: 16px;
width:325px;
padding:5px;
border:0px;
outline:none;
float:left;
}
#input_but{
width:50px;
height:32px;
border:0px;
background:gray;
outline:none;
float:right;
color:#ffffff;
}
#search{
position:absolute;
border: 1px solid lightgray;
background:#ffffff;
left:600px;
top:40px;
}
#category_container{
position:absolute;
right:300px;
top:100px;
}
.mypage{
position:absolute;
width:100px;
height:50px;
}
.my{
left:1250px;
top:30px;
}
.jang{
left:1370px;
top:30px;
}
#category_table{
margin-left:570px;
border-spacing:10px;
text-align:center;
width:800px;
}
#category_table td{
width:100px;
height:50px;
margin-right:20px;
border:1px solid lightgray;

}
#category_table th{
border:1px solid lightgray;
}
img{
width:100%;
height:100%;
}
}
#circle{
width:100%;
height:100%;
border-radius : 70%;
}
.a_tag3{
text-decoration:none;
color:black;
}
.a_tag3:hover{
color:red;
}
ul li{
font-size:30px;
}
</style>
</head>
<body>
<form method="post" action="ShopServlet">
<input type="hidden" name="command" value="admin_search">

<div id="p_container_header">
	<a href="ShopServlet?command=admin_main" class="a_tag3" style="font-size:40px;"><b>관리자 홈으로</b></a>
	
	<div id="login">
	<c:choose>
			<c:when test="${empty sessionScope.loginAdmin}">
				<a href="ShopServlet?command=admin_loginForm" class="a_tag a_tag3">관리자 로그인</a>
			</c:when>
	<c:otherwise>
			 	<b>${sessionScope.loginAdmin.name}님</b>(${sessionScope.loginAdmin.id})반갑습니다.<br>
	<ul style="float:right;">
		<li><a href="ShopServlet?command=admin_memberList" class="a_tag3">회원정보 관리</a>
		<li><a href="ShopServlet?command=admin_mtmList" class="a_tag3">1:1문의 관리</a>
		<li><a href="ShopServlet?command=admin_pInsertForm" class="a_tag3">상품 등록</a>
		<li><a href="ShopServlet?command=admin_review_call" class="a_tag3">리뷰 관리</a>
	</ul>
	</c:otherwise>
	</c:choose>
	</div>
	
	<div id="search">
		<input id="input" type="search" placeholder="검색어 입력" name="search">
		<button id="input_but" type="submit">검색</button>
	</div>
	

	
	<div id="category_container">
		<table id="category_table">
			<tr><!-- 이미지와 카테코리명에 동일한 주소 줄 것! -->
				<td><a href="ShopServlet?command=admin_category_list&categoryName=outer1" class="a_tag"><img src="https://image.msscdn.net/images/goods_img/20200123/1280017/1280017_2_500.jpg?t=20200820161743"></a></td>
				<td><a href="ShopServlet?command=admin_category_list&categoryName=top2" class="a_tag"><img src="https://image.msscdn.net/images/goods_img/20210907/2113554/2113554_3_500.jpg?t=20220405095359"></a></td>
				<td><a href="ShopServlet?command=admin_category_list&categoryName=pants3" class="a_tag"><img src="https://image.msscdn.net/images/prd_img/20220314/2417216/detail_2417216_11_500.jpg"></a></td>
				<td><a href="ShopServlet?command=admin_category_list&categoryName=training4" class="a_tag"><img src="https://image.msscdn.net/images/goods_img/20190828/1133891/1133891_2_500.jpg?t=20190904173725"></a></td>
				<td><a href="ShopServlet?command=admin_category_list&categoryName=shoes5" class="a_tag"><img src="https://image.msscdn.net/images/goods_img/20160224/311052/311052_3_500.jpg?t=20200416114434"></a></td>
				<td><a href="ShopServlet?command=admin_category_list&categoryName=acc6" class="a_tag"><img src="https://image.msscdn.net/images/goods_img/20190511/1042191/1042191_1_500.jpg?t=20220628145624"></a></td>
			</tr>
			<tr>
				<th><a href="ShopServlet?command=admin_category_list&categoryName=outer1" class="a_tag a_tag3">아우터</a></th>
				<th><a href="ShopServlet?command=admin_category_list&categoryName=top2" class="a_tag a_tag3">상의</a></th>
				<th><a href="ShopServlet?command=admin_category_list&categoryName=pants3" class="a_tag a_tag3">바지</a></th>
				<th><a href="ShopServlet?command=admin_category_list&categoryName=training4" class="a_tag a_tag3">트레이닝</a></th>
				<th><a href="ShopServlet?command=admin_category_list&categoryName=shoes5" class="a_tag a_tag3">신발</a></th>
				<th><a href="ShopServlet?command=admin_category_list&categoryName=acc6" class="a_tag a_tag3">패션소품</a></th>
			</tr>
		</table>
	</div>
	</div>
</form>
</body>
</html>