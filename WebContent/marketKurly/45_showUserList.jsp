<%@page import="market_Kurly.dto.customerDTO"%>
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
		ArrayList<customerDTO> userList = (ArrayList<customerDTO>)request.getAttribute("userlist");
	%>
	
	<h3>전체 회원 목록</h3>
	<hr size="1" color="purple" width="300"> <br><br>
	
		<table border="1" style="border-collapse: collapse;">
			<tr height="50" align="center">
				<td width="50"><font size="3" color="purple">번호</font></td>
				<td width="100"><font size="3" color="purple">아이디</font></td>
				<td width="100"><font size="3" color="purple">이름</font></td>
				<td width="200"><font size="3" color="purple">가입일</font></td>
				<td width="200"><font size="3" color="purple">연락처</font></td>
				<td width="400"><font size="3" color="purple">주소</font></td>
				<td width="200"><font size="3" color="purple">이메일</font></td>
			</tr>
	<%
		for(int i = 0; i < userList.size(); i++) {
			customerDTO cdto = userList.get(i);
	%>
			<tr height="30" align="center">
				<td><%=i + 1 %></td>
				<td><%=cdto.getId() %></td>
				<td><%=cdto.getName() %></td>
				<td><%=cdto.getReg_date() %></td>
				<td><%=cdto.getTel() %></td>
				<td><%=cdto.getAddress() %></td>
				<td><%=cdto.getEmail() %></td>
			</tr>
	<%
		}
	%>
		</table>

</body>
</html>