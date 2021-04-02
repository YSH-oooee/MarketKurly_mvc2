package market_Kurly.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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

@WebServlet("/itemInfoupdateFormPro.do")
public class _30_ItemInfoupdateFormPro extends HttpServlet {
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
		
		PrintWriter out = response.getWriter();		

		String realFolder="";
		String filename="";
		MultipartRequest imageup = null;

		String saveFolder="marketKurly/img";
		String encType = "utf-8";
		int max_size=2 * 1024 * 1024;	

		ServletContext context = getServletContext();
		realFolder = context.getRealPath(saveFolder);
		System.out.println("realFolder = " + realFolder);
		
		try{
			imageup = new MultipartRequest(request, realFolder, max_size,encType, new DefaultFileRenamePolicy());
			Enumeration files = imageup.getFileNames();
			
			while(files.hasMoreElements()){
				String name =(String)files.nextElement();
				filename = imageup.getFilesystemName(name);
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		int item_number = Integer.parseInt(imageup.getParameter("item_number"));
		
		String item_name = imageup.getParameter("name");
		String item_category = imageup.getParameter("category");
		String item_price = imageup.getParameter("price");
		String item_stock = imageup.getParameter("stock");
		String item_info = imageup.getParameter("info");
		String discount_rate = imageup.getParameter("discount_rate");
					
		System.out.println("상품명 = " + item_name);
		System.out.println("카테고리 = " + item_category);
		System.out.println("가격 = " + item_price);
		System.out.println("수량 = " + item_stock);
		System.out.println("상품정보 = " + item_info);
		System.out.println("할인율 = " + discount_rate);
		
		itemDTO idto = new itemDTO();

		idto.setItem_name(item_name);
		idto.setItem_category(item_category);
		idto.setItem_price(Integer.parseInt(item_price));
		idto.setItem_stock(Integer.parseInt(item_stock));
		idto.setItem_info(item_info);
		idto.setDiscount_rate(Integer.parseInt(discount_rate));
		
		if(filename != null) {
			idto.setItem_image(filename);
		} else {
			idto.setItem_image("error.jpg");
		}
		
		managerDAO.getInstance().updateItemInfo(idto, item_number);
		
		out.println("<script>alert('상품정보가 수정되었습니다.'); location.href='itemInfoUpdate.do';</script>");
		
	}
	
}
