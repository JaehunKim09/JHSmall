<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
#small {
	padding-bottom: 200px; 
	margin-left:30%;
	padding-top : 100px;
}
</style>
</head>
<body>
<jsp:include page="../include/admin_header.jsp"/>
<div id = small>
<form name="frm" method="post" action="ShopServlet?command=admin_pInsert">
	
	<div id="product_detail">
	상품명 : <input type="text" name="pName"><br>
	가격 : <input type="text" name="pPrice"><br>
	이미지 : <input type="text" name="pImg"><br>
	정보 : <input type="text" name="pShortInfo"><br>
	<span>상세정보</span>
	<textarea id="p_info" name="pDetailInfo" style="width:300px; height:150px;"></textarea>
	<br>
	카테고리 : <input type="text" name="pCategory"><br>
	
	<input id="purchase_button" type="submit" value="상품 등록"/>
	</div>
</form>
</div>
</body>
</html>