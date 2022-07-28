<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

aside {
	width: 20%;
	height: 80%;
	float: left;
}

h1 {
	text-align: center;
}

#a_container {
	padding-top: 50px;
	margin-left: 10%;
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
					<h2>주문/결제</h2>
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
							<b>Q : </b>결제하는 수단에 따라 할인 이벤트가 있나요?
						</summary>
						<p>
							<b>A : </b>모바일(앱/웹)에서 확인 가능합니다.
						</p>
					</details>
					<details>
						<summary>
							<b>Q : </b>사은품은 어떻게 받을 수 있나요?
						</summary>
						<p>
							<b>A : </b>사은품이 있는 상품은 주문서 작성 시 체크 박스를 선택해 주셔야
							사은품과 함께 상품이 발송됩니다.
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