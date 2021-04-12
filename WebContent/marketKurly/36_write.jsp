<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
	
		<h1>문의하기</h1>
		
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
										<td width="20%">작성자</td>
										<td width="30%">${id}</td>
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
											<input type="button" value="답글쓰기" onclick="location.href='writeAnswer.do?num=${bdto.number}'">
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
	
	<form action="37_writePro.jsp" method="post">
	
		<table border="1" style="border-collapse: collapse;">
			<tr height="50">
				<td width="200" align="center"><b>작성자</b></td>
				<td width="400">
					<input type="text" name="writer" size="20">
				</td>
			</tr>
			
			<tr height="50">
				<td width="200" align="center"><b>제목</b></td>
				<td width="400">
					<input type="text" name="title" size="50">
				</td>
			</tr>
			
			<tr height="50">
				<td width="200" align="center"><b>비밀번호</b></td>
				<td width="400">
					<input type="password" name="pw" size="20">
				</td>
			</tr>
			
			<tr height="150">
				<td width="200" align="center"><b>글내용</b></td>
				<td width="400">
					<textarea rows="10" cols="50" name="content"></textarea>
				</td>
			</tr>
		</table> <br>
		
		<input type="submit" value="글쓰기"> &nbsp;
		<input type="reset" value="다시작성">
	
	</form>

</body>
</html>