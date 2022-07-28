package team.shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import team.shop.DTO.p_orderVO;
import team.util.DBManager;

//DAO : DB와 어떻게 일 할 것인가? 에 대한 코드
public class p_orderDAO {

	private p_orderDAO() {
	}
	
	private static p_orderDAO instance = new p_orderDAO();
	
	public static p_orderDAO getInstance() {
		return instance;
	}
	
	//1. Insert : 결제하기 -> product_order 테이블에 주문 저장
		public int InsertOrder(p_orderVO oVo){
			int result = 1;
			
			String sql = "insert into product_order(pNum,id,oNum,oPrice,cnt,oName,oAddress,oPhone) values(?,?,oNum_seq.nextval,?,?,?,?,?)";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, oVo.getpNum());
				pstmt.setString(2, oVo.getId());
				pstmt.setInt(3, oVo.getoPrice());
				pstmt.setInt(4, oVo.getCnt());
				pstmt.setString(5, oVo.getoName());
				pstmt.setString(6, oVo.getoAddress());
				pstmt.setString(7, oVo.getoPhone());
				
				pstmt.executeUpdate();//쿼리문 실행
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
			return result;
			
		}

}
