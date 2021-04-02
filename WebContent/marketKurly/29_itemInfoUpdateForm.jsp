<%@page import="market_Kurly.dao.managerDAO"%>
<%@page import="market_Kurly.dto.itemDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="itemInfoupdateFormPro.do" enctype="multipart/form-data" method="post">
	
		<table border="1" style="border-collapse: collapse;">
			<tr height="30" align="center">
				<td width="150">
					번호
				</td>
				<td width="300">
					${ item_number }
				</td>
			</tr>
			
			<tr height="30" align="center">
				<td width="150">
					카테고리
				</td>
				<td width="300">
					<select name="category">
						<option value="채소" <c:if test="${item_category eq '채소'}">selected</c:if>>채소</option>
						<option value="해산물" <c:if test="${item_category eq '해산물'}">selected</c:if>>해산물</option>
						<option value="육류" <c:if test="${item_category eq '육류'}">selected</c:if>>육류</option>
						<option value="전자제품" <c:if test="${item_category eq '전자제품'}">selected</c:if>>전자제품</option>
					</select>
				</td>
			</tr>
			
			<tr height="30" align="center">
				<td width="150">
					상품명
				</td>
				<td width="300">
					<input type="text" name="name" value="${ item_name }">
				</td>
			</tr>
			
			<tr height="30" align="center">
				<td width="150">
					가격
				</td>
				<td width="300">
					<input type="text" name="price" value="${ item_price }">
				</td>
			</tr>
			
			<tr height="30" align="center">
				<td width="150">
					재고
				</td>
				<td width="300">
					<input type="text" name="stock" size="3" value="${ item_stock }">
				</td>
			</tr>
			
			<tr height="30" align="center">
				<td width="150">
					이미지
				</td>
				<td width="300">
					<img alt="" src="marketKurly/img/${ item_image }" height="30">
					<input type="file" name="image" value="업로드">
				</td>
			</tr>
			
			<tr height="30" align="center">
				<td width="150">
					상품정보
				</td>
				<td width="300">
					<input type="text" name="info" value="${ item_info }">
				</td>
			</tr>
			
			<tr height="30" align="center">
				<td width="150">
					할인율
				</td>
				<td width="300">
					<input type="text" name="discount_rate" size="3" value="${ discount_rate }">%
				</td>
			</tr>
			
			<tr height="30" align="center">
				<td width="150">
					등록일
				</td>
				<td width="300">
					${ reg_date }
				</td>
			</tr>
			
			<tr height="30" align="center">
				<td width="150">
					판매량
				</td>
				<td width="300">
					${ sold }
				</td>
			</tr>
			
			<tr height="30" align="center">
				<td width="450" colspan="2">
					<input type="submit" value="수정하기"> &nbsp;
					<input type="hidden" name="item_number" value="${ item_number }">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	
	</form>

</body>
</html>