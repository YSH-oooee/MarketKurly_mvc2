package market_Kurly.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market_Kurly.dao.boardDAO;
import market_Kurly.dto.boardDTO;

@WebServlet("/writePro.do")
public class _37_WritePro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String pw = request.getParameter("pw");
		String content = request.getParameter("content");
		
		boardDTO bdto = new boardDTO();
		
		bdto.setWriter(writer);
		bdto.setTitle(title);
		bdto.setPw(pw);
		bdto.setContent(content);
		
		boardDAO.getInstance().insertBoard(bdto);
		
		out.println("<script>alert('게시글이 등록되었습니다.'); location.href='customerCenter.do';</script>");
		out.flush();
		
	}

}
