<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function check(){
	var frmm = document.frm;
	if(frmm.pw.value.length == 0){
		alert("비밀번호를 입력해 주세요.");
		frmm.id.focus();
		return false;
	}else{
		return true;
	}
}
</script>
<Style>
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
#loginbox{
margin-left:800px;
}
#login1 {
	font-size: 25px;
	text-align: center;
}
#login2 {
	text-align:center;
	font-size: 15px;
}
#name {
	height: 35px;
	width: 350px;
	border: 1px solid #1b5ac2;
	background: #ffffff;
}
#pw {
	height: 35px;
	width: 350px;
	border: 1px solid #1b5ac2;
	background: #ffffff;
}
span{
	font-size: 12px;
}
#loginbut {
	width: 352px;
	height: 35px;
	border: 0px;
	background: #1b5ac2;
	outline: none;
	color: #ffffff;
}
.a_tag2{
text-decoration:none;
color:black;
}
.a_tag2:hover{
background:black;
color:white;
}
</Style>
</head>
<body>

	<div id="big">
		<div id="small">
			<div id="header">
				<jsp:include page="../include/header.jsp"></jsp:include>
			</div><!-- header -->
			
			<jsp:include page="../include/nav_mypage.jsp"/>
			
	<%-- <div id="mypage_div">
			<hr size="2" style="color:lightgray">
		<br><span id="mypage_span">마이페이지
		</span>&nbsp;&nbsp;&nbsp;
		<b>${sessionScope.loginUser.id}(${sessionScope.loginUser.name})</b>회원님을 위한 마이페이지 입니다.
		</div><!-- mypage div -->
		
		<div id="mypage_table_div">
		<table id="mypage_table">
			<tr>
				<th><a href="ShopServlet?command=mypage_1" class="a_tag2">구매내역</a></th>
				<th><a href="ShopServlet?command=mypage3_1_moveAction" class="a_tag2">회원정보</a></th>
				<th><a href="ShopServlet?command=mypage_5" class="a_tag2">내 구매후기</a></th>
				<th><a href="ShopServlet?command=mypage_6" class="a_tag2">내 문의내역</a></th>
		</table>
		</div> --%>
			<br><br><br><br>
			<div id="login1">
				<b>본인확인</b><br><br>
			</div>
			<div id="login2">
				회원님의 정보를 안전하게 보호하기 위해 비밀번호를 한번 더 입력해주세요.
				<hr align="center" style= width:520px>
			</div>
		<form name="frm" method="post" action="ShopServlet?command=mypage3_2_checkAction">
		<div id="loginbox">
		<div id="name">
			<input id="input" type="text" value="${sessionScope.loginUser.id}" readonly name="id"><br>
			<br>
		</div>
		<div id="pw">
			<input id="input" type="password" placeholder="비밀번호" name="pw"><br>	
			<br>
			<span>*비밀번호는 타인에게 노출되지 않도록 주의하시기 바랍니다.</span>
			<br>
			<br>
		</div>
			<input type="submit" id="loginbut" value="로그인" onclick="return check()">
		</div>
		</form>	
				
		</div><!-- small -->
		<jsp:include page="../include/footer.jsp"></jsp:include>
		</div><!-- big -->			
</body>
</html>