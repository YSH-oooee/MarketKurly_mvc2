package market_Kurly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import market_Kurly.dao.boardDAO;
import market_Kurly.dto.boardDTO;

@WebServlet("/showBoardContent.do")
public class _35_ShowBoardContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int number = Integer.parseInt(request.getParameter("number"));
		
		boardDTO bdto = boardDAO.getInstance().getOneBoard(number);
		
		request.setAttribute("bdto", bdto);
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=35_showBoardContent.jsp");
		dis.forward(request, response);
	
	}

}
