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
				<div align="right" style="margin-bottom: 10px; margin-right: 20px;">
					<input type="button" value="글쓰기" onclick="location.href='write.do'" style="backgound-color: #fff;">
				</div>
				
				<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">				
					<div class="row">
						<div class="col-sm-12">							
							<table class="table table-bordered table-hover dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
								<thead>
									<tr role="row">
										<th width="70">번호</th>
										<th width="">제목</th>
										<th width="150">작성자</th>
										<th width="200">작성일</th>
										<th width="80">조회수</th>
									</tr>
								</thead>								
								<tbody>	
								<c:forEach var="board" items="${ boardlist }">							
									<tr role="row" class="odd">
										<td align="center"><c:out value="${ number-i }" /></td>
										<td>
											<c:if test="${ board.re_step > 1 }">
												<c:forEach var="j" begin="0" end="${ (board.re_step - 1) *3 }" step="${ j = j+1 }">
													&nbsp;
												</c:forEach>
											</c:if>
											<c:if test="${ sessionScope.mng_id ne null }">
												<a href="showBoardContent.do?number=${ board.number }">${ board.title }</a>
											</c:if>
											<c:if test="${ sessionScope.id ne null }">
												<a href="checkPwForRead.do?number=${ board.number }">${ board.title }</a>
											</c:if>
										</td>
										<td align="center">${ board.writer }</td>
										<td align="center">${ board.reg_date }</td>
										<td align="center">${ board.readcount }</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
						
				<c:if test="${ pageCount ne 0 }">
					<div class="row">
						<div class="col-sm-12 col-md-7">
							<div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
								<ul class="pagination">
									<li class="paginate_button page-item previous disabled" id="dataTable_previous">
										<a href="customerCenter.do?pageNum=${startPage-10}" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">이전</a>
									</li>
									<c:forEach var="i" begin="${ startPage }" end="${ endPage }" step="${ i = i+1 }">
									<li class="paginate_button page-item active">
										<a href="customerCenter.do?pageNum=${ i }" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link">${ i }</a>
									</li>
									</c:forEach>
									<li class="paginate_button page-item next disabled" id="dataTable_next">
										<a href="customerCenter.do?pageNum=${startPage+10}" aria-controls="dataTable" data-dt-idx="2" tabindex="0" class="page-link">다음</a>
									</li>
								</ul>
							</div>
						</div>
					</div>		
				</c:if>		
				</div>
			</div>		
		</div>		
	</div>

	</div>	
	
</body>
</html>