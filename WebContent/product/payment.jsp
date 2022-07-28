<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>결제페이지</title>
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

table {
	border-collapse: collapse;
	padding: 5px;
	text-align: center;
}

tr {
	text-align: center;
}

td {
	padding: 10px;
	text-align: left;
}

/* class */
.co {
	text-align:center;
	background-color:black;
	color:white;
}
.co2 {
	text-align:center;
	background-color:lightgray;
}
.button {
	background-color:darkblue;
	color:white;
	width: 200px;
	margin: auto;
	display: inline-block;
}

.top {
	width:400px;
	border: 1px solid;
}

/* id */
#info_tab {
	width: 407px;
	height: 100px;
	/* text-align:center; */
}

#wid {
	width: 100px;
}

#p_container {
	margin-left:600px;
}
</style>
</head>
<body>
	<div id="big">
		<div id="small">
			<div id="header">
				<jsp:include page="../include/header.jsp"></jsp:include>
			</div>
			<hr>
			<div id="p_container">
			<form method="post" action="ShopServlet">
			<input type="hidden" name="command" value="insert_order">
			<input type="hidden" name="oPrice" value="${param.pPrice*order.cnt+3000}">
			<input type="hidden" name="id" value="${sessionScope.loginUser.id}">
			<input type="hidden" name="pNum" value="${order.pNum}">
			<input type="hidden" name="cnt" value="${order.cnt}">
				<table class="top">
					<h3>주문자 정보</h3>
					<tr>
						<td class="co" id="wid">보내는 분</td>
						<td>${sessionScope.loginUser.name}</td>
					</tr>
					<tr>
						<td class="co">연락처</td>
						<td>${sessionScope.loginUser.phone}</td>
					</tr>
				</table>
				<h3>배송지 정보</h3>
				<table class="top">
					<tr>
						<td class="co" id="wid">받으시는 분</td>
						<td><input type="text" id="receiver" name="rec_name" value="${sessionScope.loginUser.name}"></td>
					</tr>
					<tr>
						<td class="co">휴대폰 번호</td>
						<td><input type="text" name="rec_phone" value="${sessionScope.loginUser.phone}"></td>
					</tr>
					<tr>
						<td class="co">주&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소</td>
						<td><input type="text" id="address_kakao" name="rec_address1"
							readonly /></td>
					</tr>
					<tr>
						<td class="co">상세 주소</td>
						<td><input type="text" id="address_detail" name="rec_address2"></td>
					</tr>
					<tr>
						<td class="co">배송 메시지</td>
						<td><input type="text" size="50" name="rec_message"></td>
					</tr>
				</table>
				<h3>결제정보</h3>
				<table id="info_tab" class="top">
					<thead>
						<tr>
							<th class="co2">상품가격</th>
							<th class="co2">수 &nbsp;&nbsp;&nbsp;량</th>
							<th class="co2">결제금액</th>
							<th class="co2">배송비</th>
							<th class="co2">총 결제금액</th>
						</tr>
						<tr>
							<td style="text-align: center"><fmt:formatNumber value="${param.pPrice}" type="currency"/></td>
							<td style="text-align: center">${order.cnt}</td>
							<td style="text-align: center"><fmt:formatNumber value="${param.pPrice*order.cnt}" type="currency"/></td>
							<td style="text-align: center"><fmt:formatNumber value="3000" type="currency"/></td>
							<td style="text-align: center"><fmt:formatNumber value="${param.pPrice*order.cnt+3000}" type="currency"/></td>
						</tr>

					<table>
						<td style="padding-left:0"><input type="submit" value="결제하기" class="button">
							<input type="reset" value="취소하기" class="button"></td>
					</table>
				</table>
				</form>
			</div>
		</div>
		<!-- small -->
		<div id="footer">
			<jsp:include page="../include/footer.jsp"></jsp:include></div>
	</div>
	<!-- big -->
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	window.onload = function() {
		document
				.getElementById("address_kakao")
				.addEventListener(
						"click",
						function() { //주소입력칸을 클릭하면
							//카카오 지도 발생
							new daum.Postcode(
									{
										oncomplete : function(data) { //선택시 입력값 세팅
											document
													.getElementById("address_kakao").value = data.address; // 주소 넣기
											document
													.querySelector(
															"input[name=address_detail]")
													.focus(); //상세입력 포커싱
										}
									}).open();
						});
	}
</script>
</html>