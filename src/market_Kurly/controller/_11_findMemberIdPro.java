package market_Kurly.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market_Kurly.dao.customerDAO;

@WebServlet("/findMemberIdPro.do")
public class _11_findMemberIdPro extends HttpServlet {
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
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		String id = customerDAO.getInstance().findID(name, email);
		
		if (id != null) {
			out.println("<script>alert('회원님의 아이디는 ' + id + '입니다.'); location.href='shopMain.do';</script>");
			out.flush();
		} else {
			out.println("<script>alert('해당하는 회원정보가 존재하지 않습니다.'); location.href='shopMain.do';</script>");
			out.flush();
		}
		
	}

}
