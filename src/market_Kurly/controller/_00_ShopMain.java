package market_Kurly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import market_Kurly.dao.buyDAO;
import market_Kurly.dao.managerDAO;

@WebServlet("/shopMain.do")
public class _00_ShopMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String center = request.getParameter("center");
		String mng_id = request.getParameter("mng_id");
		String id = request.getParameter("id");
		
		if (id != null) {
			
			//로그인 상태 = 세션에 id 저장
			if (id.equals("admin")) {
				mng_id = id;
				id = null;
				session.setAttribute("mng_id", mng_id);
			} else {
				session.setAttribute("id", id);
			}
			
		}
		
		if (center == null) {
			center = "03_center.jsp";
		}
		
		System.out.println("center=" + center);
		System.out.println("mng_id=" + mng_id);
		System.out.println("id=" + id);
		
		request.setAttribute("center", center);
		
		RequestDispatcher dis = request.getRequestDispatcher("marketKurly/00_shopMain.jsp");
		dis.forward(request, response);
		
	}

}
