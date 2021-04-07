<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="insertNewItemPro.do" method="post" enctype="multipart/form-data">
		
		<table border="1" style="border-collapse: collapse;">
			<tr height="30">
				<td width="150" align="center">상품 카테고리</td>
				<td width="300">
					<select name="category">
						<option value="채소">채소</option>
						<option value="해산물">해산물</option>
						<option value="육류">육류</option>
						<option value="전자제품">전자제품</option>
					</select>
				</td>
			</tr>
			
			<tr height="30">
				<td width="150" align="center">상품명</td>
				<td width="300">
					<input type="text" name="name">
				</td>
			</tr>
			
			<tr height="30">
				<td width="150" align="center">가격</td>
				<td width="300">
					<input type="text" name="price">
				</td>
			</tr>
			
			<tr height="30">
				<td width="150" align="center">재고</td>
				<td width="300">
					<input type="text" name="stock" size="3">
				</td>
			</tr>
			
			<tr height="30">
				<td width="150" align="center">이미지</td>
				<td width="300">
					<input type="file" name="image">
				</td>
			</tr>
			
			<tr height="30">
				<td width="150" align="center">상품정보</td>
				<td width="300">
					<input type="text" name="info">
				</td>
			</tr>
			
			<tr height="30">
				<td width="150" align="center">할인율</td>
				<td width="300">
					<input type="text" name="discount_rate" size="3">%
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="상품 추가하기"></td>
			</tr>
		</table>
		
	</form>

</body>
</html>