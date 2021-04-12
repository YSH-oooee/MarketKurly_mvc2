<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
	
		<h2>로그인</h2>
	
		<table>
			<tr align="right" height="50">
					<td width="300">
						<font size="2" color="gray">
							<a href="findMemberId.do" style="text-decoration: none">
								아이디찾기
							</a>
						</font>
						<img alt="" src="marketKurly/img/top1.jpg">
						<font size="2" color="gray">
							<a href="findMemberPw.do" style="text-decoration: none">
								비밀번호찾기
							</a>
						</font>
					</td>
				</tr>
		</table>
	
		<form action="customerLoginPro.do" method="post">
		
			<table>
				<tr align="center" height="50">
					<td width="300">
						<input type="text" name="id" placeholder="아이디를 입력하세요"
								style="width:300px; height:30px; color:gray;" onfocus="this.style.color='black';">
					</td>
				</tr>
				
				<tr align="center" height="50">
					<td width="300">
						<input type="password" name="pw" placeholder="비밀번호를 입력하세요"
								style="width:300px; height:30px; color:gray;" onfocus="this.style.color='black';">
					</td>
				</tr>
				
				<tr height="50" align="center">
					<td width="300">
						<input type="image" src="marketKurly/img/login.PNG" name="submit" value="submit">
					</td>
				</tr>
				
			</table>
			
		</form>
		
		<table>
			<tr height="50" align="center">
					<td width="300">
						<input type="image" src="marketKurly/img/join.PNG" onclick="location.href='join.do'">
					</td>
				</tr>
		</table>
	</div>

</body>
</html>