<%@page import="market_Kurly.dao.managerDAO"%>
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
	
	<h3>전체 주문 내역</h3>
	<hr size="1" color="purple" width="300"> <br><br>
	
		<table border="1" style="border-collapse: collapse;">
			<tr height="50" align="center">
				<td width="50"><font size="3" color="purple">번호</font></td>
				<td width="100"><font size="3" color="purple">아이디</font></td>
				<td width="100"><font size="3" color="purple">주문자명</font></td>
				<td width="100"><font size="3" color="purple">상품명</font></td>
				<td width="100"><font size="3" color="purple">가격</font></td>
				<td width="100"><font size="3" color="purple">구매수량</font></td>
				<td width="50"><font size="3" color="purple">이미지</font></td>
				<td width="200"><font size="3" color="purple">구매일자</font></td>
				<td width="100"><font size="3" color="purple">결제수단</font></td>
				<td width="300"><font size="3" color="purple">주소</font></td>
				<td width="100"><font size="3" color="purple">배송현황</font></td>
			</tr>
		
	<%
		for(int i = 0; i < buylist.size(); i++) {
			buyDTO bdto = buylist.get(i);
	%>		
			<tr height="30" align="center">
				<td width="50"><%=i + 1 %></td>
				<td width="100"><%=bdto.getCustomer_id() %></td>
				<td width="100"><%=bdto.getCustomer_name() %></td>
				<td width="100"><%=bdto.getItem_name() %></td>
				<td width="100"><%=bdto.getBuy_price() %>원</td>
				<td width="100"><%=bdto.getBuy_count() %>개</td>
				<td width="50">
					<img alt="" src="marketKurly/img/<%=bdto.getItem_image() %>" height="50">
				</td>
				<td width="200"><%=bdto.getBuy_date() %></td>
				<td width="100"><%=bdto.getHowpay() %></td>
				<td width="300"><%=bdto.getAddress() %></td>
				<td width="200">
				<form action="checkAllOrder.do" method="post">
					<select name="delivery_status">
						<option value="0" <c:if test="${delivery_status eq 0}">selected</c:if>>주문확인중</option>
						<option value="1" <c:if test="${delivery_status eq 1}">selected</c:if>>배송준비중</option>
						<option value="2" <c:if test="${delivery_status eq 2}">selected</c:if>>배송중</option>
						<option value="3" <c:if test="${delivery_status eq 3}">selected</c:if>>배송완료</option>
					</select>
					<input type="submit" value="수정">
					<input type="hidden" value="<%=bdto.getCustomer_id() %>" name="id">
					<input type="hidden" value="1" name="check">
				</form>
				</td>
			</tr>		
	<%
		}
	%>
		</table>
	
</body>
</html>