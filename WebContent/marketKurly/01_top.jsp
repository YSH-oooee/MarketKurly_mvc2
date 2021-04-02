<%@page import="market_Kurly.dao.managerDAO"%>
<%@page import="market_Kurly.dto.managerDTO"%>
<%@page import="market_Kurly.dao.buyDAO"%>
<%@page import="market_Kurly.dto.customerDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a{ color: black; }
	a:hover { color: puple; }
</style>
</head>
<body>
	<%-- 로그인 및 고객센터 등 --%>
	<div align="right">
		<font size="2">
		<!-- 로그아웃 -->
		<c:if test="${ sessionScope.id eq null and sessionScope.mng_id eq null}">
			<a href="join.do" style="text-decoration: none">회원가입</a> &nbsp;
			<img alt="" src="marketKurly/img/top1.jpg"> &nbsp;
			<a href="customerLogin.do" style="text-decoration: none">로그인</a> &nbsp;
		</c:if>
		
		<!-- 관리자 로그인 -->
		<c:if test="${ sessionScope.id eq null and sessionScope.mng_id ne null }">
			${ sessionScope.mng_id }님 &nbsp;
			<img alt="" src="marketKurly/img/top1.jpg"> &nbsp;
			<a href="itemInfoUpdate.do" style="text-decoration: none">상품관리</a> &nbsp;
			<img alt="" src="marketKurly/img/top1.jpg"> &nbsp;
			<a href="checkAllOrder.do?check=0" style="text-decoration: none">주문확인</a> &nbsp;
			<img alt="" src="marketKurly/img/top1.jpg"> &nbsp;
			<a href="showUserList.do" style="text-decoration: none">회원관리</a> &nbsp;
			<img alt="" src="marketKurly/img/top1.jpg"> &nbsp;
			<a href="logout.do" style="text-decoration: none">로그아웃</a> &nbsp;		
		</c:if>
		
		<!-- 회원 로그인 -->
		<c:if test="${ sessionScope.id ne null and sessionScope.mng_id eq null }">
			${ sessionScope.id }님 &nbsp;
			<img alt="" src="marketKurly/img/top1.jpg"> &nbsp;
			<a href="orderListCheck.do" style="text-decoration: none">주문확인</a>
			<img alt="" src="marketKurly/img/top1.jpg"> &nbsp;
			<a href="logout.do" style="text-decoration: none">로그아웃</a> &nbsp;		
		</c:if>
		
		<!-- 공통 -->	
		<img alt="" src="marketKurly/img/top1.jpg"> &nbsp;
		<a href="customerCenter.do" style="text-decoration: none">고객센터</a>
		
		</font>
	</div>
	
	<%-- 상단메뉴 --%>
	<div align="center">
		
		<a href="shopMain.do"><img alt="Logo.png" src="marketKurly/img/logo.png" width="80"></a>
		
		<table>
			<tr height="50" align="center">
				<td width="180" id="dropdown">
					<font size="3" color="black">
						<a href="showAllCategory.do" style="text-decoration: none">
							<b>전체상품보기</b>
						</a>
					</font>
				</td>
				<td width="10">
					<img alt="" src="marketKurly/img/top1.jpg">
				</td>
				<td width="180">
					<font size="3" color="black">
						<a href="showNewItem.do" style="text-decoration: none">
							<b>신상품</b>
						</a>
					</font>
				</td>
				<td width="10">
					<img alt="" src="marketKurly/img/top1.jpg">
				</td>
				<td width="180">
					<font size="3" color="black">
						<a href="showBestItem.do" style="text-decoration: none">
							<b>베스트</b>
						</a>
					</font>
				</td>
				<td width="10">
					<img alt="" src="marketKurly/img/top1.jpg">
				</td>
				<td width="180">
					<font size="3" color="black">
						<a href="showDiscountedItem.do" style="text-decoration: none">
							<b>알뜰상품</b>
						</a>
					</font>
				</td>
				<td width="10">
					<img alt="" src="marketKurly/img/top1.jpg">
				</td>
				<td width="180">
					<font size="3" color="black">
						<a href="#" style="text-decoration: none"><b>이벤트</b></a>
					</font>
				</td>
				<td width="40">
					<a href="cartInfo.do">
						<img alt="" src="marketKurly/img/cart.png" width="30">
					</a>
				</td>
			</tr>
		</table>
	
	</div>

</body>
</html>