package market_Kurly.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market_Kurly.dao.customerDAO;

@WebServlet("/findMemberPwPro.do")
public class _13_findMemberPwPro extends HttpServlet {
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
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		
		String pw = customerDAO.getInstance().findPW(name, id, email);
		
		if (pw != null) {
			out.println("<script>alert('회원님의 비밀번호는 ' + pw + '입니다.'); location.href='shopMain.do';</script>");
			out.flush();
		} else {
			out.println("<script>alert('해당하는 회원정보가 존재하지 않습니다.'); location.href='shopMain.do';</script>");
			out.flush();
		}
	
	}

}
