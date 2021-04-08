package market_Kurly.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import market_Kurly.dao.cartDAO;

@WebServlet("/deleteCart.do")
public class _21_DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		int cart_number = Integer.parseInt(request.getParameter("cart_number"));
		String buyer = (String)session.getAttribute("id");
		
		if (buyer == null) {
			out.println("<script>alert('로그인 후, 이용 가능합니다.'); location.href='customerLogin.do';</script>");
			out.flush();
		} else {
			cartDAO.getInstance().deleteCartItem(cart_number);
			
			RequestDispatcher dis = request.getRequestDispatcher("cartInfo.do");
			dis.forward(request, response);
		}
	
	}

}
