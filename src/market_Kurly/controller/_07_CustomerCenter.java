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
	
		request.setCharacterEncoding("utf-8");
		
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int totalBoardCount = 0;
		int number = 0;
		
		int curPage = Integer.parseInt(pageNum);
		totalBoardCount = boardDAO.getInstance().getAllCount();
		
		int startRow = (curPage - 1) * pageSize;
		int endRow = curPage * pageSize;
		
		ArrayList<boardDTO> boardList = boardDAO.getInstance().getAllBoardList(startRow, endRow);
		
		number = totalBoardCount - (curPage - 1) * pageSize;
		
		if(totalBoardCount > 0) {
			
			int pageCount = totalBoardCount / pageSize + (totalBoardCount % pageSize == 0 ? 0 : 1);	
			
			int startPage = 1;		
			
			if(curPage % 10 == 0) {
				startPage = (curPage / 10 - 1) * 10 + 1;
			} else {
				startPage = (curPage / 10) * 10 + 1;
			}
			
			int endPage = startPage + 9;
			
			if(endPage > pageCount) {
				endPage = pageCount;
			}
			
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("startPage", startPage);
			
		}
		
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("number", number);
		request.setAttribute("totalBoardCount", totalBoardCount);
		request.setAttribute("curPage", curPage);
		request.setAttribute("boardlist", boardList);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=07_customerCenter.jsp");
		dis.forward(request, response);
		
	}

}
