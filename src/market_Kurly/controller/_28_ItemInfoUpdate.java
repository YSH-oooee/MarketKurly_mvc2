package market_Kurly.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market_Kurly.dao.itemDAO;
import market_Kurly.dto.itemDTO;

@WebServlet("/itemInfoUpdate.do")
public class _28_ItemInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<itemDTO> allItemList = itemDAO.getInstance().getAllItem();
		
		request.setAttribute("allItemList", allItemList);
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=28_itemInfoUpdate.jsp");
		dis.forward(request, response);
	
	}

}
