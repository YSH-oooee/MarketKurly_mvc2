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

	<h2>${ category } 카테고리</h2>
	
	<div>	
		
		<form action="showOneCategory.do" method="post">
			<select name="category">
				<option value="1" <c:if test="${ cate_num eq 1 }">selected</c:if>>채소</option>
				<option value="2" <c:if test="${ cate_num eq 2 }">selected</c:if>>해산물</option>
				<option value="3" <c:if test="${ cate_num eq 3 }">selected</c:if>>육류</option>
				<option value="4" <c:if test="${ cate_num eq 4 }">selected</c:if>>전자제품</option>
			</select>
			
			<input type="image" src="marketKurly/img/findcate.png" name="submit" value="submit" style="width:25px;">	
		</form>
	
	</div>
	
	<hr size="1" color="purple" width="300"> <br>
	
	<c:set var="j" value="0" />
	<table>
		<c:forEach var="categorylist" items="${ oneCategoryList }">
			<c:if test="j % 3 == 0">
				<tr height="250">
			</c:if>
					<td width="400" align="center">
						<c:if test="${ check == 1 }">
							<a href="itemInfoUpdateForm.do?item_number=${ categorylist.item_number }">
								<c:choose>
									<c:when test="${ categorylist.item_stock > 0 }">
										<img alt="" src="marketKurly/img/${ categorylist.item_image }" width="250">
									</c:when>
									<c:otherwise>
										<img alt="" src="marketKurly/img/${ categorylist.item_image }" width="250" style="opacity: 40%">
									</c:otherwise>
								</c:choose>
							</a>
						</c:if>
						<c:if test="${ check == -1 }">
							<a href="showOneItem.do?item_number=${ categorylist.item_number }">
								<c:choose>
									<c:when test="${ categorylist.item_stock > 0 }">
										<img alt="" src="marketKurly/img/${ categorylist.item_image }" width="250">
									</c:when>
									<c:otherwise>
										<img alt="" src="marketKurly/img/${ categorylist.item_image }" width="250" style="opacity: 40%">
									</c:otherwise>
								</c:choose>
							</a>
						</c:if>
						
						<p><font size="5"><b>${ categorylist.item_name }</b></font></p>
						
						<c:choose>
							<c:when test="${ categorylist.item_stock > 0 }">
							
								<c:set var="price" value="${ categorylist.item_price }" />
								<c:set var="rate" value="${ categorylist.discount_rate }" />
								
								<c:if test="${ price eq price*((100.0-rate)/100) }">
									<p><font size="4"><fmt:formatNumber value="${ price }" type="number" pattern="#,##0" />원</font></p>
								</c:if>
								
								<c:if test="${ price > price*((100.0-rate)/100) }">
									<p><font size="3"><del><fmt:formatNumber value="${ price }" type="number" pattern="#,##0" />원</del></font>
									→
									<font size="4" color="purple"><b><fmt:formatNumber value="${ price*((100.0-rate)/100) }" type="number" pattern="#,##0" />원</b></font></p>
								</c:if>
								
							</c:when>
							<c:otherwise>
								<p><font size="3" color="red"><b>품절</b></font></p>
							</c:otherwise>
						</c:choose>
					</td>
			<c:if test="${ j % 3 == 2 }">
				</tr>
			</c:if>
			<c:set var="j" value="${ j + 1 }" />
		</c:forEach>		
	</table>

</body>
</html>