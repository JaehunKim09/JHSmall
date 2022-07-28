<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script>
function login_check(){
	var frmm = document.frm;
	if(frmm.id.value.length == 0){
		alert("아이디를 입력해 주세요.");
		frmm.id.focus();
		return false;
	}else if(frmm.pw.value.length == 0){
		alert("비밀번호를 입력해 주세요.");
		frmm.id.focus();
		return false;
	}else{
		return true;
	}
}
</script>

<style>
#p_container {
	position: relative;
	width: 1500px;
	height: 100%;
	margin: 0 auto;
}

#loginbox {
	width: 100%;
	height: 100%;
	position: absolute;
	left: 0;
	top: 30px;
}

#login1 {
	font-size: 25px;
	position: absolute;
	left: 420px;
	text-align: center;
}

#login2 {
	font-size: 15px;
	position: absolute;
	left: 420px;
	top: 40px;
}

#login4 {
	font-size: 25px;
	position: absolute;
	left: 420px;
	top: 20px;
}

#id {
	display: inline-block;
	position: absolute;
	left: 550px;
	top: 170px;
	height: 35px;
	width: 350px;
	border: 1px solid #1b5ac2;
	background: #ffffff;
}

#pw {
	display: inline-block;
	position: absolute;
	left: 550px;
	top: 220px;
	height: 35px;
	width: 350px;
	border: 1px solid #1b5ac2;
	background: #ffffff;
}

#loginbut {
	left: 550px;
	width: 350px;
	height: 35px;
	border: 0px;
	background: #1b5ac2;
	outline: none;
	float: right;
	color: #ffffff;
}

#register {
	left: 550px;
	width: 350px;
	height: 35px;
	border: 0px;
	background: #1b5ac2;
	outline: none;
	float: right;
	color: #ffffff;
}

#welcome {
	width: 400px;
	height: 200px;
	margin-left: 180px;
}
</style>
</head>
<jsp:include page="../include/header.jsp"></jsp:include>
<body>

<form name="frm" method="post" action="ShopServlet?command=log_in">

	<!-- login -->
	<div id="p_container">

		<div id="loginbox">
			<div id="login1">
				<b>로그인</b>
			</div>
			<div id="login2">
				로그인을 하시면 다양한 서비스와 혜택을 받으실 수 있습니다.
				<hr>
				<br>

				<div id="welcome">
					<span><b>1조 쇼핑몰</b>에 오신것을 환영합니다.</span>
				</div>
			</div>
		</div>
		
		<div id="id">
			<input id="input" type="text" name="id" placeholder="아이디"><br>
			<br>
		</div>
		<div id="pw">
			<input id="input" type="password" name="pw" placeholder="비밀번호"><br><br>
			<input type="submit" id="loginbut" value="로그인" onclick="return login_check()"><br><br>
			<input type="button" id="register" value="회원가입" onclick="location='ShopServlet?command=join_contract'">
		</div>

	</div>
</form>
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>