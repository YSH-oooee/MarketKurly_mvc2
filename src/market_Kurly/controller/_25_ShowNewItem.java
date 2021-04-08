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

import market_Kurly.dao.itemDAO;
import market_Kurly.dto.itemDTO;

@WebServlet("/showNewItem.do")
public class _25_ShowNewItem extends HttpServlet {
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
		
		String mng_id = (String)session.getAttribute("mng_id");
		
		int check = -1;
		
		if (mng_id != null) {
			check = 1;
		}
		
		ArrayList<itemDTO> newItemList = itemDAO.getInstance().getNewItem();
		
		request.setAttribute("check", check);
		request.setAttribute("newItemList", newItemList);
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=25_showNewItem.jsp");
		dis.forward(request, response);
		
	}

}
