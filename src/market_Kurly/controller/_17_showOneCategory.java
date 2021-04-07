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

@WebServlet("/showOneCategory.do")
public class _17_showOneCategory extends HttpServlet {
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
		
		if(mng_id != null) {
			check = 1;
		}
		
		request.setAttribute("check", check);
		
		int cate_num = Integer.parseInt(request.getParameter("category"));
		String category = "";
		
		if(cate_num == 1) {
			category = "채소";
		} else if(cate_num == 2) {
			category = "해산물";
		} else if(cate_num == 3) {
			category = "육류";
		} else if(cate_num == 4) {
			category = "전자제품";
		}
		
		ArrayList<itemDTO> oneCategoryList = itemDAO.getInstance().getOneCategory(category);
				
		request.setAttribute("category", category);
		request.setAttribute("oneCategoryList", oneCategoryList);
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=17_showOneCategory.jsp");
		dis.forward(request, response);
		
	}

}
