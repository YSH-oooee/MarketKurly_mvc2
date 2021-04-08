package market_Kurly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market_Kurly.dao.managerDAO;

@WebServlet("/deliveryStatus.do")
public class _99_DeliveryStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		int delivery_status = Integer.parseInt(request.getParameter("delivery_status"));
		String id = request.getParameter("id");
		
		managerDAO.getInstance().updateDeliveryStatus(delivery_status, id);
				
		RequestDispatcher dis = request.getRequestDispatcher("checkAllOrder.do");
		dis.forward(request, response);
	
	}

}
