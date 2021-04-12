package market_Kurly.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market_Kurly.dao.managerDAO;
import market_Kurly.dto.buyDTO;

@WebServlet("/checkAllOrder.do")
public class _34_CheckAllOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<buyDTO> buylist = managerDAO.getInstance().getAllOrderList();
		
		int listSize = buylist.size();
		int number = 0;
		
		
		
		request.setAttribute("buylist", buylist);
		request.setAttribute("listSize", listSize);
		request.setAttribute("number", number);
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=34_checkAllOrder.jsp");
		dis.forward(request, response);
		
	}

}
