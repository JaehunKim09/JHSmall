<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의</title>
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
</style>

<style type="text/css">
aside {
	width: 20%;
	float: left;
}

h1 {
	text-align: center;
}

hr {
	size: 10px;
}

#aside {
	margin-right: 50px;
}

select {
	width: 200px;
}

#div1 {
	width: 50%;
	height: 50%;
	text-align: left;
	    margin-left: 24%
}

#but {
	margin: auto;
	width: 100px;
	background-color: darkblue;
	color: white;
}

#div_but {
	margin-left: 600px;
}

#a_container {
	padding-top: 50px;
	margin-left: 13%;
}
</style>
</head>
<body>
<form name="frm" method="post" action="ShopServlet?command=mtm">
	<div id="big">
		<div id="small">
			<div id="header">
				<jsp:include page="../include/header.jsp"></jsp:include>
			</div>
			
			<div id="a_container">
				<aside id="aside">
					<h1>고객센터</h1>
					<hr size="5px" color="black">
					<b><a href="ShopServlet?command=question_main"
						style="color: black; text-decoration: none"><li>자주하는 질문</li></a></b>
					<hr>
					<b><a href="ShopServlet?command=ask"
						style="color: black; text-decoration: none"><li>1:1 문의하기</li></a></b>
					 <br><br><br><br>
					<table style="border-collapse: collapse; width: 100%" border="1px">
						<td style="text-align: center">
							<h3>상담 전화</h3> <b style="color: orange;">1234 - 5678</b> <br>
							평일 09:00 ~ 18:00 <br> 주말/ 공휴일 휴무 <br> <br>
						</td>
					</table>
				</aside>

				<article>
					<br>
					<h2>1:1문의</h2>
					<hr style="width:745px; float:left">
					<table style="border-collapse: collapse; width: 45%" border="1px">
						<td>
							<ul>
								<li>1:1문의에서 원하는 답을 찾지 못하셨다면 자주하는 질문을 이용해주세요.</li>
								<li>이용 중 불편한 사항이나 문의사항이 있으시면 언제든지 연락 주세요.</li>
								<li>문의하신 내용에 대한 답변은 문의내역에서 확인하실수 있습니다.</li>
								<li>1:1문의내용은 본인만 확인할 수 있습니다.</li>
							</ul>
						</td>
					</table>
				</article>

				<br>
				<div id="div1">
					분류 
					<select name="mKind" onchange="this.form.kind.value=this[this.selectedIndex].value;">
						<option value="[상품]">[상품]</option>
						<option value="[배송]">[배송]</option>
						<option value="[기타]">[기타]</option>
						
					</select> <br> <br> 
					
						
					아이디&nbsp;&nbsp;&nbsp;${sessionScope.loginUser.id}<br><br>
					
					제목 <input type="text" size="50px" name="title"> <br>
					<br> 
					내용 <input type="text" size="50px" style="height: 100px;" name="content">
				</div>
				<br>
				<div id="div_but">
					<input type="submit" value="보내기" id="but" class="submit"> 
					<input type="reset" value="취소" id="but">
				</div>

			</div>
		</div>
		<!-- small -->
		<div id="footer">
			<jsp:include page="../include/footer.jsp"></jsp:include></div>
	</div>
	<!-- big -->
	</form>
</body>
</html>