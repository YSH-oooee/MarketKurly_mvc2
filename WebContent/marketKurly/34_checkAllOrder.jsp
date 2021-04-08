<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>전체 주문 내역</h3>
	
	<hr size="1" color="purple" width="300"> <br><br>
	
		<table border="1" style="border-collapse: collapse;">
			<tr height="50" align="center">
				<td width="50"><font size="3" color="purple">주문번호</font></td>
				<td width="100"><font size="3" color="purple">아이디</font></td>
				<td width="100"><font size="3" color="purple">주문자명</font></td>
				<td width="100"><font size="3" color="purple">상품명</font></td>
				<td width="100"><font size="3" color="purple">구매수량</font></td>
				<td width="100"><font size="3" color="purple">배송현황</font></td>
			</tr>
		
			<c:forEach var="buylist" items="${ buylist }">
				<tr height="30" align="center">
					<td width="200" rowspan="${ listSize }">${ buylist.buy_code }</td>
					<td width="100">${ buylist.customer_id }</td>
					<td width="100">${ buylist.customer_name }</td>
					<td width="100">${ listSize }개</td>
					<td width="200">					
					<form action="deliveryStatus.do" method="post">
						<select name="delivery_status">
							<option value="0" <c:if test="${buylist.delivery_status eq 0}">selected</c:if>>주문확인중</option>
							<option value="1" <c:if test="${buylist.delivery_status eq 1}">selected</c:if>>배송준비중</option>
							<option value="2" <c:if test="${buylist.delivery_status eq 2}">selected</c:if>>배송중</option>
							<option value="3" <c:if test="${buylist.delivery_status eq 3}">selected</c:if>>배송완료</option>
						</select>
						<input type="submit" value="수정">
						<input type="hidden" value="${ buylist.customer_id }" name="id">
					</form>
					</td>
					<td>
						<input type="button" value="상세보기" onclick="location.href='detailAllOrder.do?buy_code=${buylist.buy_code}'">
					</td>
				</tr>	
			</c:forEach>
		</table>
	
</body>
</html>