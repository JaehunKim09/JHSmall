package team.shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import team.shop.DTO.cartVO;
import team.util.DBManager;

public class cartDAO {

	private cartDAO() {
	}
	
	private static cartDAO instance = new cartDAO();
	
	public static cartDAO getInstance() {
		return instance;
	}

	public void cartInsert(cartVO cartVo) {
		String sql = "insert into cart values(cNum_seq.nextval, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cartVo.getId());
			pstmt.setInt(2, cartVo.getpNum());
			pstmt.setInt(3, cartVo.getCnt());
			
			pstmt.executeUpdate();//쿼리문 실행
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}

	public ArrayList<cartVO> cartList(String id){
		ArrayList<cartVO> cartList = new ArrayList<cartVO>();
		String sql = "select * from cart_view where id = ? order by cNum desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				cartVO cartVo = new cartVO();
				
				cartVo.setcNum(rs.getInt("cNum"));
				cartVo.setId(rs.getString("id"));
				cartVo.setpNum(rs.getInt("pNum"));
				cartVo.setCnt(rs.getInt("cnt"));
				cartVo.setpImg(rs.getString("pImg"));
				cartVo.setpPrice(rs.getInt("pPrice"));
				cartVo.setpName(rs.getString("pName"));

				cartList.add(cartVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cartList;
	}

	public void cartDelete(int cNum) {
		String sql = "delete from cart where cNum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cNum);
			
			pstmt.executeUpdate();//쿼리문 실행
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void cartDeleteAfterPayment(String id) {
		String sql = "delete from cart where id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();//쿼리문 실행
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}
