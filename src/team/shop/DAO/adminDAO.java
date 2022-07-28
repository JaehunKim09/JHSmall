package team.shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import team.shop.DTO.adminVO;
import team.util.DBManager;

public class adminDAO {

	private adminDAO() {
	}
	
	private static adminDAO instance = new adminDAO();
	
	public static adminDAO getInstance() {
		return instance;
	}
	public adminVO getUser(String id){
		String sql = "select * from admin where id=?";
		
		adminVO adminVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				adminVo = new adminVO();
				//bVo의 setter에 값세팅 (rs가 타입변환 시켜줌)
				adminVo.setId(rs.getString("id"));
				adminVo.setPw(rs.getString("pw"));
				adminVo.setName(rs.getString("name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return adminVo;
	}
}
