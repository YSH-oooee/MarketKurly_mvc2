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
import market_Kurly.dao.itemDAO;
import market_Kurly.dto.cartDTO;
import market_Kurly.dto.itemDTO;

@WebServlet("/insertCart.do")
public class _20_InsertCart extends HttpServlet {
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
		
		String buyer = (String)session.getAttribute("id");
		int item_number = Integer.parseInt(request.getParameter("item_number"));
		
		itemDTO idto = itemDAO.getInstance().getOneItem(item_number);
		
		int buy_price = idto.getItem_price() - idto.getItem_price() * idto.getDiscount_rate() / 100;
		int buy_count = Integer.parseInt(request.getParameter("buycnt"));
		String item_image = idto.getItem_image();
		String item_name = idto.getItem_name();
		
		cartDTO dto = new cartDTO();
		
		dto.setBuyer(buyer);
		dto.setItem_name(item_name);
		dto.setBuy_price(buy_price);
		dto.setBuy_count(buy_count);
		dto.setItem_image(item_image);
		
		cartDAO.getInstance().insertCart(dto);
		
		request.setAttribute("item_number", new Integer(item_number));
		
		out.println("<script>alert('상품을 장바구니에 담았습니다.'); location.href='showOneItem.do';</script>");
		out.flush();
		
	}

}
