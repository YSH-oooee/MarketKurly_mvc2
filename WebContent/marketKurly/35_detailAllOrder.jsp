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
				<td width="100"><font size="3" color="purple">상품명</font></td>
				<td width="100"><font size="3" color="purple">가격</font></td>
				<td width="100"><font size="3" color="purple">구매수량</font></td>
				<td width="50"><font size="3" color="purple">이미지</font></td>
				<td width="200"><font size="3" color="purple">구매일자</font></td>
				<td width="100"><font size="3" color="purple">결제수단</font></td>
				<td width="300"><font size="3" color="purple">주소</font></td>
				<td width="100"><font size="3" color="purple">배송현황</font></td>
			</tr>
		
			<c:forEach var="detailList" items="${ detailList }">
				<tr height="30" align="center">
					<td width="200" rowspan="${ listSize }">${ detailList.buy_code }</td>
					<td width="100">${ detailList.item_name }</td>
					<td width="100"><fmt:formatNumber value="${ detailList.buy_price }" type="number" pattern="#,##0" />원</td>
					<td width="100">${ detailList.buy_count }개</td>
					<td width="50">
						<img alt="" src="marketKurly/img/${ detailList.item_image }" height="50">
					</td>
					<td width="200">${ detailList.buy_date }</td>
					<td width="100">${ detailList.howpay }</td>
					<td width="300">${ detailList.address }</td>
					<td width="200">
						<c:if test="${detailList.delivery_status eq 0}">주문확인중</c:if>
						<c:if test="${detailList.delivery_status eq 1}">배송준비중</c:if>
						<c:if test="${detailList.delivery_status eq 2}">배송중</c:if>
						<c:if test="${detailList.delivery_status eq 3}">배송완료</c:if>
					</td>
				</tr>	
			</c:forEach>
		</table>
	
</body>
</html>