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

import market_Kurly.dao.boardDAO;
import market_Kurly.dto.boardDTO;

@WebServlet("/customerCenter.do")
public class _07_CustomerCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("id");
		
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int count = 0;
		int number = 0;
		
		int curPage = Integer.parseInt(pageNum);
		count = boardDAO.getInstance().getAllCount();
		
		int startRow = (curPage - 1) * pageSize;
		int endRow = curPage * pageSize;
		
		ArrayList<boardDTO> boardList = boardDAO.getInstance().getAllBoardList(startRow, endRow);
		
		number = count - (curPage - 1) * pageSize;
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=07_customerCenter.jsp");
		dis.forward(request, response);
		
	}

}
