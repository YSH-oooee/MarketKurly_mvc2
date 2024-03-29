package market_Kurly.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import market_Kurly.dto.buyDTO;
import market_Kurly.dto.customerDTO;
import market_Kurly.dto.itemDTO;
import market_Kurly.dto.managerDTO;

public class managerDAO {
	
	private managerDAO() {}
	private static managerDAO instance = new managerDAO();
	public static managerDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//DB연동
	public Connection getConnection() {
		
		String dbURL = "jdbc:mysql://localhost:3306/marketkurlydb01?serverTimezone=UTC";
		String dbID = "root";
		String dbPassword = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	//관리자 인증
	public int checkManager(String id, String pw) {
		
		int check = -1;
				
		try {
			
			conn = getConnection();
			
			String sql = "select * from manager where id=? and pw=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				check = 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
			if(rs != null) { try { rs.close(); } catch (SQLException sqle) {} }
		}
		
		return check;
		
	}
	
	//관리자 정보
	public managerDTO getManagetInfo(String id) {
		
		managerDTO dto = new managerDTO();
		
		try {
			
			conn = getConnection();
			
			String sql = "select * from manager where id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
			if(rs != null) { try { rs.close(); } catch (SQLException sqle) {} }
		}
		
		return dto;
		
	}
	
	//상품 삭제
	public void deleteItem(int item_number) {
		
		try {
			
			conn = getConnection();
			
			String sql = "delete from item where item_number=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_number);
			pstmt.executeUpdate();
			
			System.out.println(item_number + "번 상품이 삭제되었습니다.");
			
			pstmt = conn.prepareStatement("SELECT * FROM ITEM WHERE ITEM_NUMBER > ?");
			pstmt.setInt(1, item_number);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				pstmt = conn.prepareStatement("update item set item_number = item_number-1 where item_number > ?");
				pstmt.setInt(1, item_number);
				pstmt.executeUpdate();
				
				System.out.println("상품번호가 수정되었습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
		}
		
	}
	
	//상품정보 수정
	public void updateItemInfo(itemDTO dto, int item_number) {
		
		try {
			
			conn = getConnection();
			
			String sql = "update item set item_category=?, item_name=?, item_price=?, item_stock=?, item_image=?, item_info=?, discount_rate=?";
			sql += " where item_number=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getItem_category());
			pstmt.setString(2, dto.getItem_name());
			pstmt.setInt(3, dto.getItem_price());
			pstmt.setInt(4, dto.getItem_stock());
			pstmt.setString(5, dto.getItem_image());
			pstmt.setString(6, dto.getItem_info());
			pstmt.setInt(7, dto.getDiscount_rate());
			pstmt.setInt(8, item_number);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
		}
		
	}
	
	//상품 등록
	public void insertNewItem(itemDTO dto) {
		
		try {
			
			conn = getConnection();
			
			int num=0;
			
			String sql = "select max(item_number) from item";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1);
			}
			
			sql = "insert into item(item_number, item_category,item_name,item_price,item_stock,item_image,item_info,discount_rate,reg_date,sold)"
				+ " values(?,?,?,?,?,?,?,?,now(),0)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num + 1);
			pstmt.setString(2, dto.getItem_category());
			pstmt.setString(3, dto.getItem_name());
			pstmt.setInt(4, dto.getItem_price());
			pstmt.setInt(5, dto.getItem_stock());
			pstmt.setString(6, dto.getItem_image());
			pstmt.setString(7, dto.getItem_info());
			pstmt.setInt(8, dto.getDiscount_rate());
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
			if(rs != null) { try { rs.close(); } catch (SQLException sqle) {} }
		}
		
	}
	
	//상품 상세보기
	public itemDTO getOneItem(int item_number) {
		
		itemDTO dto = new itemDTO();
		
		try {
			
			conn = getConnection();
			
			String sql = "select * from item where item_number=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_number);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				dto.setItem_number(rs.getInt("item_number"));
				dto.setItem_category(rs.getString("item_category"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setItem_price(rs.getInt("item_price"));
				dto.setItem_stock(rs.getInt("item_stock"));
				dto.setItem_image(rs.getString("item_image"));
				dto.setItem_info(rs.getString("item_info"));
				dto.setDiscount_rate(rs.getInt("discount_rate"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setSold(rs.getInt("sold"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
			if(rs != null) { try { rs.close(); } catch (SQLException sqle) {} }
		}
		
		return dto;
		
	}
	
	//전체 주문 목록
	public ArrayList<buyDTO> getAllOrderList() {
		
		ArrayList<buyDTO> orderlist = new ArrayList<buyDTO>();
		
		try {
			
			conn = getConnection();
			
			String sql = "select * from buy_user";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				buyDTO dto = new buyDTO();
				
				dto.setBuy_code(rs.getString("buy_code"));
				dto.setCustomer_id(rs.getString("customer_id"));
				dto.setCustomer_name(rs.getString("customer_name"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setBuy_price(rs.getInt("buy_total"));
				dto.setBuy_count(rs.getInt("buy_count"));
				dto.setItem_image(rs.getString("item_image"));
				dto.setBuy_date(rs.getString("buy_date"));
				dto.setHowpay(rs.getString("howpay"));
				dto.setAddress(rs.getString("address"));
				dto.setDelivery_status(rs.getInt("delivery_status"));
				
				orderlist.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
			if(rs != null) { try { rs.close(); } catch (SQLException sqle) {} }
		}
		
		return orderlist;
		
	}
	
	//주문 상세보기
	public ArrayList<buyDTO> getDetailOrderList(String buy_code) {
		
		ArrayList<buyDTO> orderlist = new ArrayList<buyDTO>();
		
		try {
			
			conn = getConnection();
			
			String sql = "select * from buy where buy_code=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buy_code);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				buyDTO dto = new buyDTO();
				
				dto.setBuy_code(rs.getString("buy_code"));
				dto.setCustomer_id(rs.getString("customer_id"));
				dto.setCustomer_name(rs.getString("customer_name"));
				dto.setCart_number(rs.getInt("cart_number"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setBuy_price(rs.getInt("buy_price"));
				dto.setBuy_count(rs.getInt("buy_count"));
				dto.setItem_image(rs.getString("item_image"));
				dto.setBuy_date(rs.getString("buy_date"));
				dto.setHowpay(rs.getString("howpay"));
				dto.setAddress(rs.getString("address"));
				dto.setDelivery_status(rs.getInt("delivery_status"));
				
				orderlist.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
			if(rs != null) { try { rs.close(); } catch (SQLException sqle) {} }
		}
		
		return orderlist;
		
	} 
	
	//배송현황 변경
	public void updateDeliveryStatus(int status, String id) {
		
		try {
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from buy where customer_id=?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				pstmt = conn.prepareStatement("update buy set delivery_status=? where customer_id=?");
				pstmt.setInt(1, status);
				pstmt.setString(2, id);
				
				pstmt.executeUpdate();
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
			if(rs != null) { try { rs.close(); } catch (SQLException sqle) {} }
		}
		
	}
	
	//전체 회원 목록
	public ArrayList<customerDTO> getAllUserList() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<customerDTO> userList = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from customer");
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				customerDTO cdto = new customerDTO();
				
				String id = rs.getString("id");
				String name = rs.getString("name");
				String reg_date = rs.getString("reg_date").substring(0, 10);
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				String email = rs.getString("email");
				
				cdto.setId(id);
				cdto.setName(name);
				cdto.setReg_date(reg_date);
				cdto.setTel(tel);
				cdto.setAddress(address);
				cdto.setEmail(email);
				
				userList.add(cdto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
			if(rs != null) { try { rs.close(); } catch (SQLException sqle) {} }
		}
		
		return userList;
		
	}

}
