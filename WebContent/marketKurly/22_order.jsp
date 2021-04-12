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

	<div>
		<h2>주문서</h2>
		<hr size="2" color="purple" width="300"> <br><br>
		
		<form action="insertOrderList.do" method="post">
		
			<table>
				<tr height="50">
					<td colspan="4" align="left">
						<h3>구매상품확인</h3>
					</td>
				</tr>
				
				<tr height="5">
					<td colspan="4">
						<hr size="1" color="purple" width="800">
					</td>
				</tr>
			<c:forEach var="list" items="${ itemlist }">
				<tr height="50" align="center">
					<td width="200">
						<font size="2"><b>${ number = number + 1 }</b></font>
					</td>
					<td width="100">
						<img alt="" src="marketKurly/img/${ list.item_image }" height="50">
					</td>
					<td width="400">
						<font size="3">${ list.item_name }</font>
					</td>
					<td width="100">
						<font size="3">${ list.buy_count }</font>
					</td>
				</tr>
			</c:forEach>
			</table>
			
			<table>
				<tr height="40">
					<td colspan="2">
						<h3 align="left">구매자 정보</h3>
					</td>
				</tr>
				
				<tr height="5">
					<td colspan="2">
						<hr size="1" color="gray" width="800">
					</td>
				</tr>
				
				<tr height="50">
					<td width="200" align="center">
						<font size="2"><b>이름</b></font>
					</td>
					<td width="600">
						<input type="text" name="buyername" value="${ cdto.name }" style="width:200px; height:30px;">
					</td>
				</tr>
				
				<tr height="50">
					<td width="200" align="center">
						<font size="2"><b>연락처</b></font>
					</td>
					<td width="600">
						<input type="text" name="buyertel" value="${ cdto.tel }" style="width:200px; height:30px;">
					</td>
				</tr>
				
				<tr height="50">
					<td width="200" align="center">
						<font size="2"><b>주소</b></font>
					</td>
					<td width="600">
						<input type="text" name="buyeraddress" value="${ cdto.address }" style="width:200px; height:30px;">
					</td>
				</tr>
			</table> <br>
			
			<table>
				<tr height="50">
					<td colspan="2">
						<h3 align="left">결제방법</h3>
					</td>
				</tr>
				
				<tr height="5">
					<td colspan="2">
						<hr size="1" color="gray" width="800">
					</td>
				</tr>
				
				<tr height="50">
					<td width="200" align="center">
						<font size="2"><b>결제수단</b></font>
					</td>
					<td width="600">
						<select name="howpay">
							<option value="1">계좌이체</option>
							<option value="2">신용카드</option>
						</select>
					</td>
				</tr>
			</table>
			
			<table>
				<tr height="50">
					<td width="800">
						<h3 align="left">결제금액</h3>
					</td>
				</tr>
				
				<tr height="5">
					<td width="800">
						<hr size="1" color="gray" width="800">
					</td>
				</tr>
				
				<tr height="50">
					<td align="right" width="800">
						<h3><fmt:formatNumber value="${ total }" type="number" pattern="#,##0" />원</h3>
					</td>
				</tr>
				
				<tr height="50">
					<td align="center" width="800">
						<input type="image" src="marketKurly/img/pay.PNG" name="submit" value="submit" style="height:50px;">
						<input type="hidden" name="total" value=${ total }>
					</td>
				</tr>
			</table>
		
		</form>
	</div>

</body>
</html>