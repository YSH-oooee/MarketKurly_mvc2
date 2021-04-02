package market_Kurly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import market_Kurly.dao.customerDAO;

@WebServlet("/join.do")
public class _08_Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		//회원가입을 하지않고 넘어왔다면, 회원가입 페이지로 이동
		if (id == null) {
			System.out.println("회원가입폼 호출");
			
			RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=08_join.jsp");
			dis.forward(request, response);
		} else {
			System.out.println("id=" + id);
			int check = -1;
			
			if (check == -1) {		//ID 중복확인
				
				check = customerDAO.getInstance().checkOverlapID(id);
				System.out.println("check=" + check);
				if (check == 1) {	//ID가 중복이라면, 메세지 창
					request.setAttribute("check", check);
					
					RequestDispatcher dis = request.getRequestDispatcher("marketKurly/09_joinPro.jsp");
					dis.forward(request, response);
				} else {			//ID가 중복이 아니라면, 이메일 중복확인
					
					check = customerDAO.getInstance().checkOverlapEmail(email);
					
					if (check == 2) {	//이메일이 중복이라면, 메세지 창
						request.setAttribute("check", check);
						
						RequestDispatcher dis = request.getRequestDispatcher("marketKurly/09_joinPro.jsp");
						dis.forward(request, response);
					} else {			//ID, 이메일 둘 다 중복이 아니라면, 메세지 창
						//회원정보 DB에 저장
						customerDAO.getInstance().insertMember(id, pw, name, tel, address, email);
						request.setAttribute("check", check);
						
						RequestDispatcher dis = request.getRequestDispatcher("marketKurly/09_joinPro.jsp");
						dis.forward(request, response);					
					}
					
				}
				
			}
			
		}
		
	}

}
