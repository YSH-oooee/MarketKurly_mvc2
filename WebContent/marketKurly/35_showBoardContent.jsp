<%@page import="market_Kurly.dao.boardDAO"%>
<%@page import="market_Kurly.dto.boardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="marketKurly/css/styles.css" rel="stylesheet" />
<script src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
</head>
<body>
	
	<div align="center">
	
		<h1>고객센터</h1>
		
		<hr color="purple" width="300" size="1"> <br>
				
	<div class="container mt-n10">		
		<div class="card-body">
			<div class="datatable">
				<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">				
					<div class="row">
						<div class="col-sm-12">							
							<table class="table table-bordered table-hover dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
								<tbody>	
									<tr height="40" align="center">
										<td width="20%">글번호</td>
										<td width="30%">${bdto.number}</td>
										<td width="20%">조회수</td>
										<td width="30%">${bdto.readcount}</td>
									</tr>
									
									<tr height="40" align="center">
										<td width="20%">작성자</td>
										<td>${bdto.writer}</td>
										<td width="20%">작성일</td>
										<td>${bdto.reg_date}</td>
									</tr>
									
									<tr height="40" align="center">
										<td>제목</td>
										<td colspan="3">${bdto.title}</td>			
									</tr>
									
									<tr height="40" align="center">
										<td>글내용</td>
										<td colspan="3">${bdto.content}</td>
									</tr>
									
									<tr height="40" align="center">
										<td colspan="4">
										<c:if test="${ !empty mng_id }">
											<input type="button" value="답글쓰기" onclick="location.href='writeAnswer.do?num=${bdto.number}'">
										</c:if>
											<input type="button" value="수정하기" onclick="location.href='update.do?num=${bdto.number}'">
											<input type="button" value="삭제하기" onclick="location.href='delete.do?num=${bdto.number}'">
											<input type="button" value="목록보기" onclick="location.href='customerCenter.do'">
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>	
				</div>
			</div>		
		</div>		
	</div>

	</div>
	
</body>
</html>