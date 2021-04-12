package market_Kurly.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import market_Kurly.dto.buyDTO;
import market_Kurly.dto.cartDTO;
import market_Kurly.dto.customerDTO;

public class buyDAO {
	
	private buyDAO() {}
	private static buyDAO instance = new buyDAO();
	public static buyDAO getInstance() {
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
	
	//회원 정보
	public customerDTO getCustomerInfo(String id) {
		
		customerDTO dto = new customerDTO();
		
		try {
			
			conn = getConnection();
			
			String sql = "select * from customer where id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setEmail(rs.getString("email"));
				
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
	
	//장바구니 목록
	public ArrayList<cartDTO> getCartItemList(String id) {
		
		ArrayList<cartDTO> cartlist = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			
			String sql = "select * from cart where buyer=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				cartDTO dto = new cartDTO();
				
				dto.setCart_number(rs.getInt("cart_number"));
				dto.setBuyer(rs.getString("buyer"));
				dto.setItem_name(rs.getString("item_name"));
				dto.setBuy_price(rs.getInt("buy_price"));
				dto.setBuy_count(rs.getInt("buy_count"));
				dto.setItem_image(rs.getString("item_image"));
				
				cartlist.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
			if(rs != null) { try { rs.close(); } catch (SQLException sqle) {} }
		}
		
		return cartlist;
		
	}
	
	//주문 목록 정보 추가
	public void insertOrderList(buyDTO dto) {
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		
		String buy_code = sdf.format(now);
		
		try {
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement("insert into buy values(?, ?, ?, ?, ?, ?, ?, ?, now(), ?, ?, 0)");
			pstmt.setString(1, buy_code);
			pstmt.setString(2, dto.getCustomer_id());
			pstmt.setString(3, dto.getCustomer_name());
			pstmt.setInt(4, dto.getCart_number());
			pstmt.setString(5, dto.getItem_name());
			pstmt.setInt(6, dto.getBuy_price());
			pstmt.setInt(7, dto.getBuy_count());
			pstmt.setString(8, dto.getItem_image());
			pstmt.setString(9, dto.getHowpay());
			pstmt.setString(10, dto.getAddress());
			
			pstmt.executeUpdate();
						
			pstmt = conn.prepareStatement("SELECT * FROM BUY WHERE buy_code=?");
			pstmt.setString(1, buy_code);
			
			rs = pstmt.executeQuery();
			
			int total_price = 0;
			int total_count = 0;
			String item_name = null;
			
			while (rs.next()) {
				total_price += rs.getInt("buy_price");
				item_name = rs.getString("item_name");
			}
			
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM BUY WHERE buy_code=?");
			pstmt.setString(1, buy_code);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				total_count = rs.getInt(1);
			}
			
			if (total_count > 1) {
				item_name = item_name + " 외 " + (total_count -1) + "개";
			}
			
			pstmt = conn.prepareStatement("insert into buy_user values(?, ?, ?, ?, ?, ?, 0)");
			pstmt.setString(1, buy_code);
			pstmt.setString(2, dto.getCustomer_id());
			pstmt.setString(3, dto.getCustomer_name());
			pstmt.setString(4, item_name);
			pstmt.setInt(5, total_price);
			pstmt.setInt(6, total_count);
			
			pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
		}
		
	}
	
	//장바구니 전체 비우기
	public void deleteCartList(String id) {
		
		try {
			
			conn = getConnection();
			
			String sql = "delete from cart where buyer=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
		}
		
	}
	
	//판매량 수정
	public void updateSold(String item_name, int buy_count) {
		
		int soldcount = 0;
		
		try {
			
			conn = getConnection();
			
			String sql = "select sold from item where item_name=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_name);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				soldcount = rs.getInt(1);
			}
			
			sql = "update item set sold=? where item_name=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, soldcount + buy_count);
			pstmt.setString(2, item_name);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
			if(rs != null) { try { rs.close(); } catch (SQLException sqle) {} }
		}
		
	}
	
	//주문 목록
	public ArrayList<buyDTO> getBuyList(String id) {
		
		ArrayList<buyDTO> buylist = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			
			String sql = "select * from buy where customer_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
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
				
				buylist.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) { try { conn.close(); } catch (SQLException sqle) {} }
			if(pstmt != null) { try { pstmt.close(); } catch (SQLException sqle) {} }
			if(rs != null) { try { rs.close(); } catch (SQLException sqle) {} }
		}
		
		return buylist;
		
	}

}
