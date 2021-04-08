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

	<h1>신상품</h1>
	
	<hr size="1" color="purple" width="300"> <br>
	
	<c:set var="j" value="0" />
	<table>
		<c:forEach var="newItemList" items="${ newItemList }">
			<c:if test="j % 3 == 0">
				<tr height="250">
			</c:if>
					<td width="400" align="center">
						<c:if test="${ check == 1 }">
							<a href="itemInfoUpdateForm.do?item_number=${ newItemList.item_number }">
								<c:choose>
									<c:when test="${ newItemList.item_stock > 0 }">
										<img alt="" src="marketKurly/img/${ newItemList.item_image }" width="250">
									</c:when>
									<c:otherwise>
										<img alt="" src="marketKurly/img/${ newItemList.item_image }" width="250" style="opacity: 40%">
									</c:otherwise>
								</c:choose>
							</a>
						</c:if>
						<c:if test="${ check == -1 }">
							<a href="showOneItem.do?item_number=${ newItemList.item_number }">
								<c:choose>
									<c:when test="${ newItemList.item_stock > 0 }">
										<img alt="" src="marketKurly/img/${ newItemList.item_image }" width="250">
									</c:when>
									<c:otherwise>
										<img alt="" src="marketKurly/img/${ newItemList.item_image }" width="250" style="opacity: 40%">
									</c:otherwise>
								</c:choose>
							</a>
						</c:if>
						
						<p><font size="5"><b>${ newItemList.item_name }</b></font></p>
						
						<c:choose>
							<c:when test="${ newItemList.item_stock > 0 }">
							
								<c:set var="price" value="${ newItemList.item_price }" />
								<c:set var="rate" value="${ newItemList.discount_rate }" />
								
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