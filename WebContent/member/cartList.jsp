<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
	margin-left:350px;
	padding-bottom: 200px; /* footer의 높이 */
}

.cart_img{
width:250px;
height:120px;
}
#cartlist td{
width:400px;
}
.td{
text-align:center;
width:300px;
}
.cnt{
font-weight:bold;
color:blue;
}
.a_tag2{
text-decoration:none;
color:black;
}
.a_tag2:hover{
color:red;
}
#order_btn{
width:300px;
height:40px;
background:darkblue;
color:white;
margin-left:450px;
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
	background-color: black;
	color:white;
}
.top {
	border: 1px solid;
	}
#wid {
	
	width: 100px;
}
</style>
</head>
<body>
	<div id="big">
	<jsp:include page="../include/header.jsp"/>
	<hr>
		<div id="small">	
<article>
	
	<h2>장바구니</h2>
	<form name="formm" method="post" action="ShopServlet">
	<input type="hidden" name="command" value="cart_payment"/>
	
		<c:choose>
			<c:when test="${cartList.size() == 0}">
				<div id="cart_null">장바구니가 비었습니다.</div>
			</c:when>
			<c:otherwise>
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
				
				<br><br><br>
				<table id="cartList">
					<tr>
						<th>상품명</th><th>수 량</th><th>가 격</th><th>삭 제</th>
					</tr>

					<c:forEach items="${cartList}" var="cartVO">
						<tr>
							<td><a href="ShopServlet?command=product_detail&pNum=${cartVO.pNum}" class="a_tag2"><img class="cart_img" src="${cartVO.pImg}">
							<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cartVO.pName}</a></td>
							<td class="td cnt">${cartVO.cnt}</td>
							<td class="td"><fmt:formatNumber value="${cartVO.pPrice*cartVO.cnt}" type="currency" /></td>
							<td class="td"><a href="ShopServlet?command=cart_delete&cNum=${cartVO.cNum}" class="a_tag2">삭제</a>
							</td>
						</tr>
					</c:forEach>
					<tr style="background-color:lightgray">
						<th colspan="2">상품 결제금액</th>
						<th colspan="2"><fmt:formatNumber value="${totalPrice}" type="currency" /><br></th>
					</tr>
					<tr style="background-color:lightgray">
						<th colspan="2">배송비</th>
						<th colspan="2"><fmt:formatNumber value="3000" type="currency"/></th>
					</tr>
					<tr style="background-color:black">
						<th style="color:white" colspan="2">총 결제금액</th>
						<th style="color:white" colspan="2"><fmt:formatNumber value="${totalPrice+3000}" type="currency"/><br></th>
					</tr>
				</table>
							<c:if test="${cartList.size() != 0}">
			<br><br>
				<input type="submit" value="결제하기" id="order_btn" style="font-weight:bold">
					
			</c:if>
			</c:otherwise>
			
		</c:choose>
</form>
		<div class="clear"></div>
	
</article>
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</div>
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