package market_Kurly.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import market_Kurly.dao.cartDAO;
import market_Kurly.dto.cartDTO;

@WebServlet("/cartInfo.do")
public class _19_CartInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		if (id == null) {
			RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=04_customerLogin.jsp");
			dis.forward(request, response);
		}
		
		ArrayList<cartDTO> cartlist = cartDAO.getInstance().getCartList(id);
		
		int number = 0;
		int count = cartDAO.getInstance().countCartItem(id);
		int total = 0;
		int deliveryfee = 3000;
		
		request.setAttribute("cartlist", cartlist);
		request.setAttribute("number", new Integer(number));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("total", new Integer(total));
		request.setAttribute("deliveryfee", new Integer(deliveryfee));
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=19_cartInfo.jsp");
		dis.forward(request, response);
		
	}

}
