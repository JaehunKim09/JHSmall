<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인페이지</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
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


#banner {
	position: absolute;
	left : 200px;
	margin: 0;
	width: 80%;
	height: 300px;
	top: 210px;
}


#product {
	position: absolute;
	top: 540px;
	left: 220px;
	font-family: 'Poor Story', cursive;
	font-size : 40px;
	font-weight : bold;
	color : gray;
}
#a_container {
	padding-top: 400px;
	margin-left: 11%;
}
.a_tag2{
text-decoration:none;
color:black;
}
.a_tag2:hover{
color:red;
}
</style>
</head>
<body>

	<div id="big">
		<div id="small">
			<jsp:include page="../include/admin_header.jsp"/>
			<br><br><br><br><br><br><br><br><br><br><br><br>
			<div id="banner">
				<img src="https://i.imgur.com/dL3KmVD.png">
			</div>


		</div>
		<!-- small -->
		<div id="footer">
			<jsp:include page="../include/footer.jsp"></jsp:include></div>
	</div>
	<!-- big -->
</body>
</html>