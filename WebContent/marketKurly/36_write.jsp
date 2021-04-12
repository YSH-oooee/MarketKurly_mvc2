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
	
		<h1>문의하기</h1>
		
		<hr color="purple" width="300" size="1"> <br>
				
	<div class="container mt-n10">		
		<div class="card-body">
			<div class="datatable">
				<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">				
					<div class="row">
						<div class="col-sm-12">							
						<form action="writePro.do" method="post">
							<table class="table table-bordered table-hover dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
								<tbody>	
									<tr height="40">
										<td width="20%" style="text-align: center;">제목</td>
										<td colspan="3" style="text-align: left">
											<input type="text" name="title" size="80" style="border: none;">
										</td>
									</tr>
									
									<tr height="40">
										<td style="text-align: center;" width="20%">작성자</td>
										<td style="text-align: center;" width="30%">${id}</td>
										<td style="text-align: center;" width="20%">비밀번호</td>
										<td style="text-align: left" width="30%">
											<input type="password" name="pw" style="border: none;">
										</td>
									</tr>
									
									<tr height="40">
										<td style="text-align: center; vertical-align: middle;">내용</td>
										<td colspan="3" style="text-align: left">
											<textarea rows="10" cols="80" style="border: none;"></textarea>
										</td>			
									</tr>
									
									<tr height="40" align="center">
										<td colspan="4">
											<input type="submit" value="작성하기">
											<input type="button" value="목록보기" onclick="location.href='customerCenter.do'">
										</td>
									</tr>
								</tbody>
							</table>
						</form>
						</div>
					</div>	
				</div>
			</div>		
		</div>		
	</div>

	</div>
	
</body>
</html>