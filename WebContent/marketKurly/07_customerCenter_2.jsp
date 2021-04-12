<%@page import="market_Kurly.dto.boardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="market_Kurly.dao.boardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a:link { color: black; text-decoration: none;}
	a:visited { color: black; text-decoration: none;}
</style>
</head>
<body>

	<h1>고객센터</h1>
	<hr color="purple" width="300" size="1"> <br>
	
	<table border="1" style="border-collapse: collapse;">
		<tr height="30" align="center">
			<td width="50">번호</td>
			<td width="400">제목</td>
			<td width="200">작성자</td>
			<td width="200">작성일</td>
			<td width="50">조회수</td>
		</tr>
		
	<c:forEach var="board" items="${ boardlist }">
		<tr>
			<td align="center"><c:out value="${ number-i }" /></td>
			<td>
				<c:if test="${ board.re_step > 1 }">
					<c:forEach var="j" begin="0" end="${ (board.re_step - 1) *3 }" step="${ j = j+1 }">
						&nbsp;
					</c:forEach>
				</c:if>
				<c:if test="${ sessionScope.mng_id ne null }">
					<a href="showBoardContent.do?num=${ board.number }">${ board.title }</a>
				</c:if>
				<c:if test="${ sessionScope.id ne null }">
					<a href="checkPwForRead.do?num=${ board.number }">${ board.title }</a>
				</c:if>
			</td>
			<td align="center">${ board.writer }</td>
			<td align="center">${ board.reg_date }</td>
			<td align="center">${ board.readcount }</td>
		</tr>
	</c:forEach>
	</table>
	
	<table>
		<tr height="30">
			<td width="910" align="right">
				<input type="button" value="글쓰기" onclick="location.href='00_shopMain.jsp?center=36_write.jsp'">
			</td>
		</tr>
	</table>
	
	<p>
	<c:if test="${ startPage > 10 }">
		<a href="customerCenter.do?pageNum=${startPage - 10}">[이전]</a>
	</c:if>
	
	<c:forEach var="i" begin="${ startPage }" end="${ endPage }" step="${ i = i+1 }">
		<a href="customerCenter.do?pageNum=${ i }"> [${ i }] </a>
	</c:forEach>
	
	<c:if test="${ endPage <= pageCount && endPage >= 10 }">
		<a href="customerCenter.do?pageNum=${startPage + 10}">[다음]</a>
	</c:if>
	
</body>
</html>