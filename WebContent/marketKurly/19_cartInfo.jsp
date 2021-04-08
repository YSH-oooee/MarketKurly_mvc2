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

	<h2>장바구니</h2>
	
	<hr size="2" color="purple" width="300"> <br>
	
	<c:choose>
		
		<c:when test="${ count eq 0 }">
			<h3>장바구니에 담겨있는 상품이 없습니다.</h3>
		</c:when>
		
		<c:otherwise>
			<c:forEach var="list" items="${ cartlist }">
				<table>
				<c:set var="total" value="${ total = total + (list.buy_price * list.buy_count) }" />
					<tr height="40">
						<td width="50" align="center">
							<font size="2">${ number = number + 1 }</font>
						</td>
						<td width="100" align="center">
							<img alt="" src="marketKurly/img/${ list.item_image }" height="40">
						</td>
						<td width="300">
							<font size="3"><b>${ list.item_name }</b></font>
						</td>
						<td width="100" align="center">
							<font size="3"><b>${ list.buy_count }</b></font>
						</td>
						<td width="100">
							<font size="3"><b><fmt:formatNumber value="${ list.buy_price * list.buy_count }" type="number" pattern="#,##0" />원</b></font>
						</td>
						<td width="40" align="center">
							<input type="image" src="marketKurly/img/delete.png" onclick="location.href='deleteCart.do?cart_number=${ list.cart_number }'">
						</td>
					</tr>
				</table>
				
				<hr size="1" color="gray" width="680">				
				
			</c:forEach>
			
			<form action="order.do" method="post">
				<table>
					<tr height="30" align="right">
						<td width="480">
							<h4>총 상품금액</h4>
						</td>
						<td width="200">
							<h4><fmt:formatNumber value="${ total }" type="number" pattern="#,##0" />원</h4>
						</td>
					</tr>
					
					<tr height="30" align="right">
						<td width="480"><h4>배송비</h4></td>
						<td width="200">
							<c:if test="${ total < 40000 }">
								<h4><fmt:formatNumber value="${ deliveryfee }" type="number" pattern="#,##0" />원</h4>
								<font size="2" color="purple">
									<fmt:formatNumber value="${ 40000 - total }" type="number" pattern="#,##0" />원 추가주문 시, 무료배송
								</font>
							</c:if>
							
							<c:if test="${ total >= 40000 }">
								<h4>0원</h4>
							</c:if>
						</td>
					</tr>
					
					<tr height="40" align="right">
						<td width="480">
							<h3>총 결제금액</h3>
						</td>
						<td width="200">
							<c:if test="${ total < 40000 }">
								<h3><b><fmt:formatNumber value="${ total + deliveryfee }" type="number" pattern="#,##0" />원</b></h3>
							</c:if>
							
							<c:if test="${ total >= 40000 }">
								<h3><b><fmt:formatNumber value="${ total }" type="number" pattern="#,##0" />원</b></h3>
							</c:if>
						</td>
					</tr>
					
					<tr height="30" align="right">
						<td colspan="2">
							<input type="image" src="marketKurly/img/order.PNG" name="submit" value="submit" style="height:50px">
							<input type="hidden" name="total" value="${ total }">
						</td>
					</tr>
				</table>
			</form>
		</c:otherwise>
		
	</c:choose>

</body>
</html>