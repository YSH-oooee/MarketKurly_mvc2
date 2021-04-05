<%@page import="market_Kurly.dao.buyDAO"%>
<%@page import="market_Kurly.dto.buyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		ArrayList<buyDTO> buylist = (ArrayList<buyDTO>)request.getAttribute("buylist");
	%>
	
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
	<%
		for(int i = 0; i < buylist.size(); i++) {
			buyDTO bdto = buylist.get(i);
	%>
			<tr height="50" align="center">
				<td width="50">
					<font size="2"><%=i + 1%></font>
				</td>
				<td width="50">
					<img alt="" src="marketKurly/img/<%=bdto.getItem_image()%>" height="50">
				</td>
				<td width="100">
					<font size="2"><%=bdto.getItem_name() %></font>
				</td>
				<td width="50">
					<font size="2"><%=bdto.getBuy_count() %></font>
				</td>
				<td width="100">
					<font size="2"><%=bdto.getBuy_price() * bdto.getBuy_count() %></font>
				</td>
				<td width="200">
					<font size="2"><%=bdto.getBuy_date() %></font>
				</td>
				<td width="150">
					<font size="2"><%=bdto.getHowpay() %></font>
				</td>
				<td width="300">
					<font size="2"><%=bdto.getAddress() %></font>
				</td>
				<td width="100">
					<font size="2">
						<%=bdto.getDelivery_status() %>
					</font>
				</td>
			</tr>
	<%
		}
	%>
		</table>

</body>
</html>