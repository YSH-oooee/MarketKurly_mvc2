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

	<form action="insertCart.do" method="post">
	
		<table>
			<tr height="80">
				<td rowspan="6" width="350" align="center">
					<img alt="" src="marketKurly/img/${ idto.item_image }" height="350">
				</td>
				<td width="400" colspan="2">
					<font size="5"><b>${ idto.item_name }</b></font> <br>
					<font size="2">${ idto.item_info }</font>
				</td>
			</tr>
			
			<tr height="70">
				<td width="400" colspan="2">
					<c:set var="price" value="${ idto.item_price }" />
					<c:set var="rate" value="${ idto.discount_rate }" />
								
						<c:if test="${ price eq price*((100.0-rate)/100) }">
							<p><font size="4"><fmt:formatNumber value="${ price }" type="number" pattern="#,##0" />원</font></p>
						</c:if>
						
						<c:if test="${ price > price*((100.0-rate)/100) }">
							<p><font size="3"><del><fmt:formatNumber value="${ price }" type="number" pattern="#,##0" />원</del></font>
							→
							<font size="4" color="purple"><b><fmt:formatNumber value="${ price*((100.0-rate)/100) }" type="number" pattern="#,##0" />원</b></font></p>
						</c:if>
					<font size="2" color="purple">로그인 후 적립혜택이 적용됩니다.</font>
				</td>
			</tr>
			
			<tr height="50">
				<td width="100">
					<font size="2"><b>판매단위</b></font>
				</td>
				<td width="300">
					<font size="2">1개</font>
				</td>
			</tr>
			
			<tr height="50">
				<td width="100">
					<font size="2"><b>배송방법</b></font>
				</td>
				<td width="300">
					<font size="2">샛별배송/택배배송</font>
				</td>
			</tr>
			
			<tr height="50">
				<td width="100">
					<font size="2"><b>포장타입</b></font>
				</td>
				<td width="300">
					<font size="2">상온/종이포장</font> <br>
					<font size="1">택배배송은 에코포장이 스티로폼으로 대체됩니다.</font>
				</td>
			</tr>
			
			<tr height="50">
				<td width="100">
					<font size="2"><b>구매수량</b></font>
				</td>
				<td width="300">
					<input type="number" name="buycnt" min="0" max="100" size="100" value="1">
				</td>
			</tr>
			
			<tr height="35">
				<td></td>
				<td colspan="2" align="center">
					<c:if test="${ idto.item_stock eq 0 }">
						<p><font size="3" color="red"><b>품절된 상품입니다.</b></font></p>
					</c:if>
					<c:if test="${ idto.item_stock ne 0 }">
						<input type="image" src="marketKurly/img/sendcart.PNG" name="submit" value="submit" style="height: 50px">
						<input type="hidden" name="item_number" value="${ idto.item_number }">
					</c:if>
				</td>
			</tr>
		</table>
	
	</form>

</body>
</html>