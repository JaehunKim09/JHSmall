<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function join_check(){	
	var frmm = document.joinForm;
	
	if(frmm.name.value.length == 0){
		alert("이름을 입력하세요.");
		frmm.name.focus();
		return false;
	}else if(frmm.id.value.length == 0){
		alert("아이디를 입력하세요.");
		frmm.id.focus();
		return false;
	}else if(frmm.idDuplication.value != "idCheck"){
		alert("아이디 중복체크를 해주세요.");
		frmm.id.focus();
		return false;	
	}else if(frmm.pw.value.length == 0){
		alert("비밀번호를 입력하세요.");
		frmm.pw.focus();
		return false;
	}else if(frmm.name.value.length == 0){
		alert("이름을 입력하세요.");
		frmm.name.focus();
		return false;
	}else if(frmm.pw.value != frmm.pwCheck.value){
		alert("비밀번호가 다릅니다.");
		frmm.pwCheck.focus();
		return false;
	}else if(frmm.phone.value.length == 0){
		alert("연락처를 입력하세요.");
		frmm.phone.focus();
		return false;
	}else if(frmm.email.value.length == 0){
		alert("이메일을 입력하세요.");
		frmm.email.focus();
		return false;
	}else if(frmm.address.value.length == 0){
		alert("주소를 입력하세요.");
		frmm.address.focus();
		return false;
	}else
		return true;
}
function fn_dbCheckId(){
	var frmm = document.joinForm;
	var id = frmm.id.value;
	if(id.length==0 || id==""){
		alert("아이디를 입력해주세요.");
		frmm.id.focus();
	}else{
		window.open("ShopServlet?command=id_check&id="+id,"","width=500, height=300");
	}
}
function inputIdChk(){
	var joinForm = document.joinForm;
	var dbCheckId = document.joinForm.dbCheckId;
	
	joinForm.idDuplication.value = "idUncheck";
	dbCheckId.disabled=false; //비활성화를 활성화로...
	dbCheckId.style.opacity=1; //투명도
	dbCheckId.style.cursor="pointer";
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

#registerbut {
	left: 550px;
	width: 200px;
	height: 35px;
	border: 0px;
	background: #1b5ac2;
	outline: none;
	color: #ffffff;
}

#id, #pw, #pwcheck, #name, #phone, #join, #address, #address_detail {
	width: 150px;
	height: 45px;
	margin: auto;
}
#address{
margin-top:35px;
}
#address_detail{

}

#email {
	display:inline-block;
	position:absolute;
	bottom:425px;
	left:877px;
}

hr {
	width: 50%;
	background-color: black;
}
</style>
</head>

<body>
	<div id="big">
		<div id="small">
			<div id="header">
				<jsp:include page="../include/header.jsp"></jsp:include>
			</div>
			<br> <br> <br> <br> <br>
			<div id="join">
				<span style="font-size: 25px">회원가입</span>
			</div>
			<hr>
	<form name="joinForm" method="post" action="ShopServlet?command=join">
			<div id="name">
				이름 <input type="text" name="name">
			</div>
			<br>
			<div id="id">                        <!-- 중복체크 후 다른아이디로 변경하여 입력하였을 때 다시 중복체크 하기위해 onkeydown함수 사용 -->
				아이디 <input type="text" name="id" onkeydown="inputIdChk()"/>
				<button type="button" onclick="fn_dbCheckId()" name="dbCheckId">중복확인</button>
				
				<!-- 아이디 중복 체크 여부 : 안했으면 회원가입 불가 -->
				<input type="hidden" name="idDuplication" value="idUncheck"/>
			</div>
			<br>
			<div id="pw">
				비밀번호 <input type="password" name="pw">
			</div>
			<br>
			<div id="pwcheck">
				비밀번호 확인 <input type="password" name="pwCheck">
			</div>
			<br>
			<div id="phone">
				휴대전화 <br> <input type="text" name="phone">
			</div>
			<br>
			<div id="email">
			이메일<br>
			<input type="text" placeholder="이메일 주소 입력" name="emailId"/> @ 
			<input type="text" title="이메일 도메인 입력" name="emailDomain">
				<select title="이메일 도메인 주소 선택" onchange="this.form.emailDomain.value=this[this.selectedIndex].value;">
   					<option value="" selected="selected">-선택-</option>
    				<option value="naver.com">naver.com</option>
				    <option value="gmail.com">gmail.com</option>
				    <option value="hanmail.net">hanmail.net</option>
				    <option value="hotmail.com">hotmail.com</option>
				    <option value="korea.com">korea.com</option>
				    <option value="nate.com">nate.com</option>
				    <option value="yahoo.com">yahoo.com</option>
				    <option value="">직접입력</option>
				</select>
			</div>		
			<div id="address">
				주소 <input type="text" id="address_kakao" readonly name="address1">
			</div>
			<br>
			<div id="address_detail">
				상세주소 <input type="text" id="address_detail" name="address2">
			</div>
			<br><br>
			<div id="join">
				<input type="submit" id="registerbut" value="가입하기" onclick="return join_check()">
			</div>
	</form>
			<br>
			<!-- footer -->
		</div>
		<div id="footer">
			<jsp:include page="../include/footer.jsp"></jsp:include>
		</div>
	</div>
</body>

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