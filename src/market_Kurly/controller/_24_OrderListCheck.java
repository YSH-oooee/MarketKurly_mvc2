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
import market_Kurly.dto.buyDTO;

@WebServlet("/orderListCheck.do")
public class _24_OrderListCheck extends HttpServlet {
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
		System.out.println("id=" + id);
		ArrayList<buyDTO> buylist = buyDAO.getInstance().getBuyList(id);
		
		request.setAttribute("buylist", buylist);
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=24_orderListCheck.jsp");
		dis.forward(request, response);
		
	}

}
