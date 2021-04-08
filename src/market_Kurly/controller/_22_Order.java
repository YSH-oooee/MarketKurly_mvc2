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

import market_Kurly.dao.buyDAO;
import market_Kurly.dto.cartDTO;
import market_Kurly.dto.customerDTO;

@WebServlet("/order.do")
public class _22_Order extends HttpServlet {
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
		
		customerDTO cdto = buyDAO.getInstance().getCustomerInfo(id);
		ArrayList<cartDTO> itemlist = buyDAO.getInstance().getCartItemList(id);
		
		int number = 0;
		int total = Integer.parseInt(request.getParameter("total"));

		request.setAttribute("cdto", cdto);
		request.setAttribute("itemlist", itemlist);
		request.setAttribute("number", new Integer(number));
		request.setAttribute("total", new Integer(total));
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=22_order.jsp");
		dis.forward(request, response);
		
	}

}
