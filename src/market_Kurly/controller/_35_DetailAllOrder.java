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

@WebServlet("/detailAllOrder.do")
public class _35_DetailAllOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		String buy_code = request.getParameter("buy_code");
		
		ArrayList<buyDTO> detailList = managerDAO.getInstance().getDetailOrderList(buy_code);
		
		int listSize = detailList.size();
		
		request.setAttribute("detailList", detailList);
		request.setAttribute("listSize", listSize);
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=35_detailAllOrder");
		dis.forward(request, response);
	
	}

}
