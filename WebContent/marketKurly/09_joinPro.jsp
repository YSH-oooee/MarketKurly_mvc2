<%@page import="market_Kurly.dao.customerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${ check eq 1 }">
		<script type="text/javascript">
			alert("이미 사용중인 아이디입니다.");
			history.go(-1);
		</script>
	</c:if>
	
	<c:if test="${ check eq 2 }">
		<script type="text/javascript">
			alert("이미 사용중인 이메일입니다.");
			history.go(-1);
		</script>
	</c:if>
	
	<c:if test="${ check eq -1 }">
		<script type="text/javascript">
			alert("회원가입이 완료되었습니다.");
			location.href="shopMain.do";
		</script>
	</c:if>
	
</body>
</html>