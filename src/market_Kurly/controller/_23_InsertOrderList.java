package market_Kurly.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import market_Kurly.dao.buyDAO;
import market_Kurly.dao.cartDAO;
import market_Kurly.dto.buyDTO;
import market_Kurly.dto.cartDTO;
import market_Kurly.dto.customerDTO;

@WebServlet("/insertOrderList.do")
public class _23_InsertOrderList extends HttpServlet {
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
		
		String customer_id = (String)session.getAttribute("id");
		
		customerDTO cbean = buyDAO.getInstance().getCustomerInfo(customer_id);
		ArrayList<cartDTO> cartlist = cartDAO.getInstance().getCartList(customer_id);
		
		int how = Integer.parseInt(request.getParameter("howpay"));
		String pay = "";
		
		if(how == 1) {
			pay = "계좌이체";
		} else if(how == 2) {
			pay = "신용카드";
		}
		
		for(int i = 0; i < cartlist.size(); i++) {
			
			cartDTO cdto = cartlist.get(i);
			
			String customer_name = cbean.getName();
			int cart_number = cdto.getCart_number();
			String item_name = cdto.getItem_name();
			int buy_price = cdto.getBuy_price();
			int buy_count = cdto.getBuy_count();
			String item_image = cdto.getItem_image();
			String howpay = pay;
			String address = cbean.getAddress();
			
			buyDTO bdto = new buyDTO();
			
			bdto.setCustomer_id(customer_id);
			bdto.setCustomer_name(customer_name);
			bdto.setCart_number(cart_number);
			bdto.setItem_name(item_name);
			bdto.setBuy_price(buy_price);
			bdto.setBuy_count(buy_count);
			bdto.setItem_image(item_image);
			bdto.setHowpay(howpay);
			bdto.setAddress(address);
			
			buyDAO.getInstance().insertOrderList(bdto);
			buyDAO.getInstance().updateSold(item_name, buy_count);			
			
		}
		
		buyDAO.getInstance().deleteCartList(customer_id);
		
		out.println("<script>alert('주문이 완료되었습니다.'); location.href='shopMain.do';</script>");
		out.flush();
	
	}

}
