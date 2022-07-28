<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
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
	padding-bottom: 200px; 
	margin-left:30%;/* footer의 높이 */
}
#product_Info {
	padding-top: 50px;
	margin-left: 28%;
}
#client_info_table {
	width: 900px;
	height: 130px;
	left: 600px;
}
#client_info_table td {
	height: 200px;
	text-align: center;
}
#input{
font-size: 16px;
width:325px;
padding:5px;
border:0px;
outline:none;
float:left;
}
</style>
</head>
<body>
<jsp:include page="../include/admin_header.jsp"/>
	<form method="post" action="ShopServlet">
		<input type="hidden" name="command" value="admin_memberListsearch">
		
		<div id="big">
			<div id="small">
				<!-- header -->
				<hr size="2" style="color: lightgray">

				<br> <br> <br> <br> <br> <br>
				<div id="client_Info">
				<div id="search">
			<input id="input" type="search" placeholder="검색ID 입력" name="search">
			<button id="input_but" type="submit">검색</button>
		</div>
					<table id="client_info_table">
						<tr style="background: skyblue">
							<th>ID</th>
							<th>이름</th>
							<th>관리</th>
						</tr>
						<c:forEach items="${clientList}" var="client">
							<tr>
								<td>${client.name}</td>
								<td><a
									href="ShopServlet?command=admin_memberDetail&id=${client.id}">${client.id}</a></td>
								<td><a
									href="ShopServlet?command=admin_memberDelete&id=${client.id}">삭제</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<a href="ShopServlet?command=admin_memberList">회원전체보기</a>
			</div>
			<!-- small -->

			<!-- big -->

		</div>
	</form>
</body>
</html>