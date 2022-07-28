<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
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
#input{
font-size: 16px;
width:325px;
padding:5px;
border:0px;
outline:none;
float:left;
}
#input_but{
width:50px;
height:28px;
border:0px;
background:gray;
outline:none;
float:right;
color:#ffffff;
}
</style>
</head>
<body>
<jsp:include page="../include/admin_header.jsp"/>
<form name="frm" method="post" action="ShopServlet?command=admin_login">

	<!-- login -->
	<div id="p_container">

		<div id="loginbox">
			<div id="login1">
				<b>로그인</b>
			</div>
			<div id="login2">
				<hr>
				<br>

				<div id="welcome">
					<span><b>JHS Shop [관리자 페이지]</b>에 오신것을 환영합니다.</span>
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
		</div>

	</div>
</form>
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>