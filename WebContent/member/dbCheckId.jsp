<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복확인</title>
<script>
function sendCheckValue(){
	var openJoinfrm = opener.document.joinForm;
	
	if(document.checkIdForm.chResult.value=="N"){
		alert("다른 아이디를 입력해주세요.");
		window.close();
	}else{
		//중복체크 결과인 idCheck 값을 전달
		//hidden값이 Y일 경우 회원가입 창의 아이디 중복체크시 hidden값이었던
		//"idUnCheck"를 "idCheck"로 변경해줌.(중복체크 되었음을 확인)
		openJoinfrm.idDuplication.value="idCheck";
		//중복체크 완료 시 중복체크버튼 비활성화
		openJoinfrm.dbCheckId.disabled=true;
		openJoinfrm.dbCheckId.style.opacity=0.6;
		openJoinfrm.dbCheckId.style.cursor="default";
		window.close();
	}
}
</script>
</head>
<body>
	<b><font size="4" color="gray">ID 중복 확인</font></b>
	<br>
	
	<form name="checkIdForm">
		<input type="text" name="id" value="${userId}" id="userId" disabled>
		
		<c:choose>
			<c:when test="${result==1}">
				<p style="color:red">이미 사용중인 아이디입니다.</p>
				<input type="hidden" name="chResult" value="N"/>
			</c:when>
			<c:when test="${result==0}">
				<p style="color:blue">사용 가능한 아이디입니다.</p>
				<input type="hidden" name="chResult" value="Y"/>
			</c:when>
			<c:otherwise>
				<p>오류 발생(-1)</p>
				<input type="hidden" name="chResult" value="N"/>
			</c:otherwise>
		</c:choose>
		<input type="button" onclick="sendCheckValue()" value="사용하기"/>&nbsp;&nbsp;
		<input type="button" onclick="window.close()" value="취소"/>	
	</form>
</body>
</html>