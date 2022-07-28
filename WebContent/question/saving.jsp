<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>적립문의</title>
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
</style>
<style type="text/css">
aside {
	width: 20%;
	height: 80%;
	float: left;
}

h1 {
	text-align: center;
}

#aside {
	margin-right: 50px;
}

th {
	width: 80px;
}

p {
	margin: auto;
}

#a_container {
	padding-top: 50px;
	margin-left: 10%;
}
</style>
</head>
<body>
	<div id="big">
		<div id="small">
			<div id="header">
				<jsp:include page="../include/header.jsp"></jsp:include>
			</div>
			<div id="a_container">
				<aside id="aside">
					<h1>고객센터</h1>
					<hr size="5px" color="black">
					<b><a href="ShopServlet?command=question_main"
						style="color: black; text-decoration: none"><li>자주하는 질문</li></a></b>
					<hr>
					<b><a href="ShopServlet?command=ask"
						style="color: black; text-decoration: none"><li>1:1 문의하기</li></a></b>
					 <br><br><br><br>
					<table style="border-collapse: collapse; width: 100%" border="1px">
						<td style="text-align: center">
							<h3>상담 전화</h3> <b style="color: orange;">1234 - 5678</b> <br>
							평일 09:00 ~ 18:00 <br> 주말/ 공휴일 휴무 <br> <br>
						</td>
					</table>
				</aside>

				<article>
					<br>
					<h2>적립/혜택</h2>
					<hr style="width:1210px; float:left">
					<table style="border-collapse: collapse; width: 70%; height: 90px;"
						border="1px">
						<td style="margin: auto; text-align: center;"><select
							style="width: 100px; height: 25px;">
								<option>전체</option>
								<option>전체1</option>
								<option>전체2</option>
						</select> <input type="search" style="height: 26px; width: 60%"> <input
							type="submit" value="검색" style="width: 100px; height: 26px;">
						</td>
					</table>
					<br>
					<table style="border-collapse: collapse; width: 70%; height: 40px;"
						border="1px">
						<th><a href="ShopServlet?command=question_main">전체</a></th>
						<th><a href="ShopServlet?command=product_inquiry">상품문의</a></th>
						<th><a href="ShopServlet?command=order_payment">주문/결제</a></th>
						<th><a href="ShopServlet?command=delivery">배송</a></th>
						<th><a href="ShopServlet?command=return">반품/교환/환불</a></th>
						<th><a href="ShopServlet?command=saving">적립/혜택</a></th>
						<th><a href="ShopServlet?command=etc">회원/기타</a></th>
					</table>
					<hr style="width:1210px; float:left"><br>
					<details>
						<summary>
							<b>Q : </b>적립금에 유효기간이 있나요?
						</summary>
						<p>
							<b>A : </b>일반 적립금의 유효기간은 5년입니다.
						</p>
					</details>
					<details>
						<summary>
							<b>Q : </b>쿠폰은 어떻게 사용하나요?
						</summary>
						<p>
							<b>A : </b>>보유한 쿠폰은 주문 결제 시 적용 가능 상품 확인 및 사용이 가능합니다.
							주문 완료 후에는 쿠폰 적용이 가능하지 않습니다.
						</p>
					</details>
				</article>
			</div>

		</div>
		<!-- small -->
		<div id="footer">
			<jsp:include page="../include/footer.jsp"></jsp:include></div>
	</div>
	<!-- big -->
</body>
</html>