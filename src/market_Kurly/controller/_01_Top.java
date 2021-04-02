package market_Kurly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import market_Kurly.dao.buyDAO;
import market_Kurly.dao.managerDAO;
import market_Kurly.dto.customerDTO;
import market_Kurly.dto.managerDTO;

@WebServlet("/top.do")
public class _01_Top extends HttpServlet {
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
		String mng_id = (String)session.getAttribute("mng_id");
		
		String name = "";
		
		if (mng_id != null) {
			managerDTO mdto = managerDAO.getInstance().getManagetInfo(id);
			name = mdto.getName();
		} else if (id != null) {
			customerDTO cdto = buyDAO.getInstance().getCustomerInfo(id);
			name = cdto.getName();
		}
		
		session.setAttribute("id", id);
		request.setAttribute("name", name);
		
		RequestDispatcher dis = request.getRequestDispatcher("marketKurly/01_top.jsp");
		dis.include(request, response);
		
	}

}
