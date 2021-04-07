package market_Kurly.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import market_Kurly.dao.managerDAO;
import market_Kurly.dto.itemDTO;

@WebServlet("/insertNewItemPro.do")
public class _33_insertNewItemPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		try {
			
			String saveFolder = "C:\\Users\\또잉\\Desktop\\Web\\04_jsp\\workspace_2\\marketKurly_mvc2\\WebContent\\marketKurly\\upload_img";
			String encType = "utf-8"; 
			int maxSize = 15*1024*1024;  
			
			MultipartRequest imageup = new MultipartRequest(request, saveFolder, maxSize,encType , new DefaultFileRenamePolicy());
			 
			Enumeration<?> files = imageup.getFileNames();
			
			while (files.hasMoreElements()){
				
				String name =(String)files.nextElement();
				String filename = imageup.getFilesystemName(name);
				
				String item_name = imageup.getParameter("name");
				String item_category = imageup.getParameter("category");
				String item_price = imageup.getParameter("price");
				String item_stock = imageup.getParameter("stock");
				String item_info = imageup.getParameter("info");
				String discount_rate = imageup.getParameter("discount_rate");
				
				itemDTO idto = new itemDTO();
				
				idto.setItem_category(item_category);
				idto.setItem_name(item_name);
				idto.setItem_price(Integer.parseInt(item_price));
				idto.setItem_stock(Integer.parseInt(item_stock));
				idto.setItem_info(item_info);
				idto.setDiscount_rate(Integer.parseInt(discount_rate));
				
				if(filename != null){
					idto.setItem_image(filename);
				}else{
					idto.setItem_image("error.jpg");
				}
				
				managerDAO.getInstance().insertNewItem(idto);
				
			 }
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("itemInfoUpdate.do");
		dis.forward(request, response);
		
	}

}
