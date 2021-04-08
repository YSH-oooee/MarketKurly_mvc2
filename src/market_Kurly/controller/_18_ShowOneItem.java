package market_Kurly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import market_Kurly.dao.itemDAO;
import market_Kurly.dto.itemDTO;

@WebServlet("/showOneItem.do")
public class _18_ShowOneItem extends HttpServlet {
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
		int item_number = Integer.parseInt(request.getParameter("item_number"));
		
		itemDTO idto = itemDAO.getInstance().getOneItem(item_number);
		
		request.setAttribute("idto", idto);
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=18_showOneItem.jsp");
		dis.forward(request, response);
	
	}

}
