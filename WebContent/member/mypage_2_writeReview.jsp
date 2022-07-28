<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
function review_check(){
	if(document.frm.content.value == 0){
		alert("내용을 입력하세요.");
		return false;
	}else
		return true;
}
</script>
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
#product_info_table td {
	height: 200px;
	text-align: center;
	border: 1px solid gray;
}
#product_Info {
	width: 1010px;
	padding-top: 50px;
	margin: 0 auto;
}
.img {
	width: 150px;
	height: 150px;
}
b1{
	font-size : 30px;
	font-weight : bold;
}
</style>
</head>
<body>
	<div id="big">
		<div id="small">
		<div id="header">
				<jsp:include page="../include/header.jsp"></jsp:include>
			</div>
			<!-- header -->
			<hr size="2" style="color: lightgray">
			<div id="product_Info">
			<b style="font-size:30px;">구매후기 작성</b>
			<hr size="2" style="color: black">
	<!-- form -->
	<form method="post" action="ShopServlet" name="frm">
	<!-- hidden태그로 회원 id 보내기 -->
	<input type="hidden" name="command" value="insert_review">
	<input type="hidden" name="id" value="${sessionScope.loginUser.id}">
	<input type="hidden" name="pNum" value="${product.pNum}">
			<table>
				<tr>
					<td><input type="text" name="pName" value="${product.pName}" readonly="readonly"
							style="border:0; font-weight:bold;"></td>
				</tr>
				<tr>
					<td>
						<img src="${product.pImg}" class="img img_buy" name="pImg"></td>
				</tr>
			</table>
				<br>
				<tr>
					<td><textarea placeholder="내용을 입력하세요.(최소 10자 최대 250자)" 
					style="width: 610px; height:200px; font-size: 15px;
					vertical-align:top;" name="content"></textarea> </td>
				</tr>
				<br><br>

				<table text-align="center";>
					<td><input type="submit" value="등록" class="button" onclick="return review_check()">
						<input type="reset" value="취소" class="button"></td>
				</table>
	</form>
			</div>
		</div><!-- small -->
		<div id="footer">
			<jsp:include page="../include/footer.jsp"></jsp:include></div>
	</div><!-- big -->

</body>
</html>