<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
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


#banner {
	position: absolute;
	left : 200px;
	margin: 0;
	width: 80%;
	height: 300px;
	top: 210px;
}

.product {
	display: inline-block;
	width: 300px;
	height: 300px;
	border: 2px solid lightgray;
	top: 500px;
	left: 60px;
	bottom: 500px;
	margin-right: 100px;
	border-radius : 20%;
	font-family: 'Poor Story', cursive;
	font-size : 20px;
	font-weight : bold;
	color : gray;
}

#product {
	position: absolute;
	top: 540px;
	left: 220px;
	font-family: 'Poor Story', cursive;
	font-size : 40px;
	font-weight : bold;
	color : gray;
}
#a_container {
	padding-top: 400px;
	margin-left: 11%;
}
.a_tag2{
text-decoration:none;
color:black;
}
.a_tag2:hover{
color:red;
}
</style>
</head>
<body>
	<div id="big">
		<div id="small">
			<div id="header">
				<jsp:include page="include/header.jsp"></jsp:include>
			</div>

			<div id="banner">
				<img src="https://i.imgur.com/dL3KmVD.png">
			</div>

			<div id="product">*추천 상품</div>

			<div id="a_container">
				<div class="product">
				<a href="ShopServlet?command=product_detail&pNum=3" class="a_tag2">
					<img class="product"
						src="https://image.msscdn.net/images/goods_img/20220105/2293208/2293208_2_125.jpg">
					가디건
					</a>
				</div>

				<div class="product">
				<a href="ShopServlet?command=product_detail&pNum=4" class="a_tag2">
					<img class="product"
						src="https://image.msscdn.net/images/goods_img/20210817/2066200/2066200_4_125.jpg">
						후드집업</a>
						  
						
						
				</div>
				<div class="product">
				<a href="ShopServlet?command=product_detail&pNum=44" class="a_tag2">
					<img class="product"
						src="https://image.msscdn.net/images/goods_img/20210401/1875010/1875010_1_500.jpg?t=20210401143848">
					킹받는 열쇠고리
					</a>
				</div>
				<div class="product">
				<a href="ShopServlet?command=product_detail&pNum=42" class="a_tag2">
					<img class="product"
						src="https://image.msscdn.net/images/goods_img/20220126/2330146/2330146_2_500.jpg?t=20220213195344">
					썬구리
					</a>
				</div>
			</div>
		</div>
		<!-- small -->
		<div id="footer">
			<jsp:include page="include/footer.jsp"></jsp:include></div>
	</div>
	<!-- big -->
</body>
</html>