<%@page import="market_Kurly.dao.itemDAO"%>
<%@page import="market_Kurly.dto.itemDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	$().ready(function() {
		$("#btn").click(function() {
			location.href = 'insertNewItem.do';
		});
	});
</script>
</head>
<body>

	<table>
		<tr>
			<td width="1000" align="left">
				<button id="btn">신상품 추가하기</button>
			</td>
		</tr>
	</table>
	
	<table border="1" style="border-collapse: collapse;">
		<tr height="50" align="center">
			<td width="50"><b>번호</b></td>
			<td width="100"><b>카테고리</b></td>
			<td width="100"><b>상품명</b></td>
			<td width="100"><b>가격</b></td>
			<td width="50"><b>재고</b></td>
			<td width="50"><b>이미지</b></td>
			<td width="200"><b>상품정보</b></td>
			<td width="50"><b>할인율</b></td>
			<td width="100"><b>등록일</b></td>
			<td width="50"><b>판매량</b></td>
			<td width="100" colspan="2"><b>수정/삭제</b></td>		
		</tr>
	<c:forEach var="list" items="${ allItemList }">
		<tr height="50" align="center">
			<td width="50">${ list.item_number }</td>
			<td width="100">${ list.item_category }</td>
			<td width="100">${ list.item_name }</td>
			<td width="100">${ list.item_price }</td>
			<td width="50">${ list.item_stock }</td>
			<td width="50">
				<img alt="" src="marketKurly/img/${ list.item_image }" height="50">
			</td>
			<td width="200">${ list.item_info }</td>
			<td width="50">${ list.discount_rate }%</td>
			<td width="100">${ list.reg_date }</td>
			<td width="50">${ list.sold }</td>
			<td width="50">
				<a href="itemInfoUpdateForm.do?item_number=${ list.item_number }">수정</a>
			</td>
			<td width="50">
				<a href="deleteItem.do?item_number=${ list.item_number }">삭제</a>
			</td>		
		</tr>
	</c:forEach>
	</table>

</body>
</html>