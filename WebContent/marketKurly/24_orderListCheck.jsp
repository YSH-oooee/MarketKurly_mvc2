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

	<h3>주문내역 확인</h3>
	
		<hr size="1" color="purple" width="300"> <br><br>
		
		<table border="1">
			<tr height="50" align="center">
				<td width="50">
					<font size="3" color="purple">번호</font>
				</td>
				<td width="50">
					<font size="3" color="purple"></font>
				</td>
				<td width="100">
					<font size="3" color="purple">상품명</font>
				</td>
				<td width="50">
					<font size="3" color="purple">수량</font>
				</td>
				<td width="100">
					<font size="3" color="purple">가격</font>
				</td>
				<td width="200">
					<font size="3" color="purple">주문일</font>
				</td>
				<td width="150">
					<font size="3" color="purple">결제수단</font>
				</td>
				<td width="300">
					<font size="3" color="purple">주소</font>
				</td>
				<td width="100">
					<font size="3" color="purple">배송현황</font>
				</td>
			</tr>
			
			<c:forEach var="list" items="${ buylist }">
				<tr height="50" align="center">
					<td width="50">
						<font size="2">${ number = number + 1 }</font>
					</td>
					<td width="50">
						<img alt="" src="marketKurly/img/${ list.item_image }" height="50">
					</td>
					<td width="100">
						<font size="2">${ list.item_name }</font>
					</td>
					<td width="50">
						<font size="2">${ list.buy_count }</font>
					</td>
					<td width="100">
						<font size="2"><fmt:formatNumber value="${ list.buy_price * list.buy_count }" type="number" pattern="#,##0" />원</font>
					</td>
					<td width="200">
						<font size="2">${ list.buy_date }</font>
					</td>
					<td width="150">
						<font size="2">${ list.howpay }</font>
					</td>
					<td width="300">
						<font size="2">${ list.address }</font>
					</td>
					<td width="100">
						<font size="2">
							<c:if test="${ list.delivery_status eq 0 }">
								<c:out value="주문확인중" />
							</c:if>
							<c:if test="${ list.delivery_status eq 1 }">
								<c:out value="배송준비중" />
							</c:if>
							<c:if test="${ list.delivery_status eq 2 }">
								<c:out value="배송중" />
							</c:if>
							<c:if test="${ list.delivery_status eq 3 }">
								<c:out value="배송완료" />
							</c:if>
						</font>
					</td>
				</tr>
			</c:forEach>
		</table>

</body>
</html>