<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 및 삭제</title>
<style>
html,body{
margin:0;
padding:0;
height:100%;
}
#big{
position:relative;
min-height:100%;
}
#small{
padding-bottom:200px;
padding-top: 100px;
}
.product_img{
padding-left:670px;
width:300px;
height:270px;
}
#product_detail{
margin-left:650px;
}
#p_info{
margin-left:650px;
}
.but{
margin-left:720px;
}
</style>
</head>
<body>
<div id="big">
<jsp:include page="../include/admin_header.jsp"></jsp:include>
<div id="small">
<form name="frm" method="post" action="ShopServlet">
	<input type="hidden" name="command" value="admin_pUpdate">
	<input type="hidden" name="pNum" value="${product.pNum}">
	
		<img class="product_img" src="${product.pImg}"><br>
	
	<br><br>
		<div class="but">
			<input id="purchase_button" type="submit" value="상품정보 수정"/>
			<input id="purchase_button" type="button" value="상품정보 삭제"
			onclick="location.href='ShopServlet?command=admin_pDelete&pNum=${product.pNum}'"/>
		</div>
	<br><br>
	<div id="product_detail">
	상품명 : <input type="text" name="pName" value="${product.pName}">
	가격  : <input type="text" name="pPrice" value="${product.pPrice}">
	
	</div>
	<br>
	<span style="margin-left:610px;">상세정보</span>
	<br><br>		
		<textarea id="p_info" name="pDetailInfo" style="width:500px; height:300px;">${product.pDetailInfo}</textarea>
	</form>
	</div>
		<jsp:include page = "../include/footer.jsp"></jsp:include>
	</div>
</body>
</html>