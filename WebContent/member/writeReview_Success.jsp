<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
  alert("후기는 저희에게 큰 힘이 됩니다\n감사합니다!");
  location.href="ShopServlet?command=mypage_1&id=${sessionScope.loginUser.id}";
</script>