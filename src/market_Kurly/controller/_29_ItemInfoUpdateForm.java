package market_Kurly.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import market_Kurly.dao.managerDAO;
import market_Kurly.dto.itemDTO;

@WebServlet("/itemInfoUpdateForm.do")
public class _29_ItemInfoUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		int item_number = Integer.parseInt(request.getParameter("item_number"));
				
		itemDTO idto = managerDAO.getInstance().getOneItem(item_number);
		
		String item_category = idto.getItem_category();		
		String item_name = idto.getItem_name();
		int item_price = idto.getItem_price();
		int item_stock = idto.getItem_stock();
		String item_image = idto.getItem_image();
		String item_info = idto.getItem_info();
		int discount_rate = idto.getDiscount_rate();
		String reg_date = idto.getReg_date();
		int sold = idto.getSold();
		
		request.setAttribute("item_number", item_number);
		request.setAttribute("item_category", item_category);
		request.setAttribute("item_name", item_name);
		request.setAttribute("item_price", item_price);
		request.setAttribute("item_stock", item_stock);
		request.setAttribute("item_image", item_image);
		request.setAttribute("item_info", item_info);
		request.setAttribute("discount_rate", discount_rate);
		request.setAttribute("reg_date", reg_date);
		request.setAttribute("sold", sold);
		
		RequestDispatcher dis = request.getRequestDispatcher("shopMain.do?center=29_itemInfoUpdateForm.jsp");
		dis.forward(request, response);
		
	}

}
