package market_Kurly.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import market_Kurly.dao.customerDAO;
import market_Kurly.dao.managerDAO;

@WebServlet("/customerLogin.do")
public class _04_CustomerLogin extends HttpServlet {
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
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int check = -1;
		
		//로그인을 하지않고 넘어왔다면, 로그인 페이지로 이동
		if (id == null) {
			System.out.println("로그인폼 호출");
			
			RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=04_customerLogin.jsp");
			dis.forward(request, response);
		} else {
			//로그인폼에서 넘어왔다면,			
			if (id.equals("admin")) {	//관리자 ID인지 확인
				
				check = managerDAO.getInstance().checkManager(id, pw);
				
				if(check == 1) {	//관리자 ID가 맞다면, 세션에 저장(로그인)			
					session.setAttribute("mng_id", id);
					
					RequestDispatcher dis = request.getRequestDispatcher("shopMain.do");
					dis.forward(request, response);
				} else {
					out.println("<script>alert('아이디와 비밀번호를 확인하세요.'); location.href='customerLogin.do';</script>");
					out.flush();
				}
				
			} else {		//관리자 ID가 아니라면, 회원 ID인지 확인
				
				check = customerDAO.getInstance().checkUser(id, pw);
				
				if(check == 1) {	//회원 ID가 맞다면, 세션에 저장(로그인)
					session.setAttribute("id", id);
					
					RequestDispatcher dis = request.getRequestDispatcher("shopMain.do");
					dis.forward(request, response);
				} else {
					out.println("<script>alert('아이디와 비밀번호를 확인하세요.'); location.href='customerLogin.do';</script>");
					out.flush();
				}

			}
			System.out.println("check=" + check);
		}
		
	}

}
