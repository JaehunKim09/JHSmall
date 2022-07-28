package team.shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.shop.DTO.mtmVO;
import team.shop.DTO.productVO;
import team.util.DBManager;

//DAO : DB와 어떻게 일 할 것인가? 에 대한 코드
public class productDAO {

	private productDAO() {
	}
	
	private static productDAO instance = new productDAO();
	
	public static productDAO getInstance() {
		return instance;
	}
	
	//1. SELECT : 모든 게시글을 불러와 최근 순서로 리스트에 정렬되도록 하는 DAO
		public List<productVO> selectCategoryProducts(String categoryName){
			String sql = "select * from product where pCategory = ? order by pNum";
			
			List<productVO> list = new ArrayList<productVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, categoryName);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					productVO pVo = new productVO();
					//bVo의 setter에 값세팅 (rs가 타입변환 시켜줌)
					pVo.setpNum(rs.getInt("pNum"));
					pVo.setpName(rs.getString("pName"));
					pVo.setpPrice(rs.getInt("pPrice"));
					pVo.setpImg(rs.getString("pImg"));
					pVo.setpShortInfo(rs.getString("pShortInfo"));
					pVo.setpDetailInfo(rs.getString("pDetailInfo"));
					pVo.setpCategory(rs.getString("pCategory"));
					
					list.add(pVo);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}

		public productVO selectOneProductBypNum(String pNum) {
			String sql = "select * from product where pNum=?";
			
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// try/catch문 밖에서 선언 해 주어야 return 가능
			productVO pVo = null; 
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pNum);
				
				rs = pstmt.executeQuery(); //데이터 rs에 저장
				
				while(rs.next()) { // rs에 들어있는 정보를 bVo에 세팅
					pVo = new productVO();
					//VO의 setter의 매개변수 타입과 일치되게 저장할 것
					pVo.setpNum(rs.getInt("pNum"));
					pVo.setpName(rs.getString("pName"));
					pVo.setpPrice(rs.getInt("pPrice"));
					pVo.setpImg(rs.getString("pImg"));
					pVo.setpShortInfo(rs.getString("pShortInfo"));
					pVo.setpDetailInfo(rs.getString("pDetailInfo"));
					pVo.setpCategory(rs.getString("pCategory"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			return pVo;
		}
		//모든 상품을 DB에서 가져오는 메소드
		public List<productVO> selectAllProducts() {
			String sql = "select * from product";
			
			List<productVO> list = new ArrayList<productVO>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// try/catch문 밖에서 선언 해 주어야 return 가능
			productVO pVo = null; 
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);				
				rs = pstmt.executeQuery(); //데이터 rs에 저장
				
				while(rs.next()) { // rs에 들어있는 정보를 bVo에 세팅
					pVo = new productVO();
					//VO의 setter의 매개변수 타입과 일치되게 저장할 것
					pVo.setpNum(rs.getInt("pNum"));
					pVo.setpName(rs.getString("pName"));
					pVo.setpPrice(rs.getInt("pPrice"));
					pVo.setpImg(rs.getString("pImg"));
					pVo.setpShortInfo(rs.getString("pShortInfo"));
					pVo.setpDetailInfo(rs.getString("pDetailInfo"));
					pVo.setpCategory(rs.getString("pCategory"));
					
					list.add(pVo);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}

		public ArrayList<productVO> searchProduct(String pName){
			ArrayList<productVO> list = new ArrayList<productVO>();
			String sql = "select * from product where pName like '%'||?||'%'";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pName);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					productVO pVo = new productVO();
					pVo.setpNum(rs.getInt("pNum"));
					pVo.setpName(rs.getString("pName"));
					pVo.setpPrice(rs.getInt("pPrice"));
					pVo.setpImg(rs.getString("pImg"));
					pVo.setpShortInfo(rs.getString("pShortInfo"));
					pVo.setpDetailInfo(rs.getString("pDetailInfo"));
					pVo.setpCategory(rs.getString("pCategory"));
					
					list.add(pVo);
				}

			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}

		public void productUpdate(productVO pVo, String pNum) {
				String sql = "update product set pName=?, pPrice=?, pDetailInfo=? where pNum=?";
				
				Connection conn = null;
				PreparedStatement pstmt = null;
							
				 try {
					 
					 conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, pVo.getpName());
					pstmt.setInt(2, pVo.getpPrice());
					pstmt.setString(3, pVo.getpDetailInfo());
					pstmt.setString(4, pNum);
					
					pstmt.executeUpdate();
					
				 }catch (Exception e) {
					e.printStackTrace();
				}finally {
					DBManager.close(conn, pstmt);
				}

		}

		public void productDelete(String pNum) {
			String sql = "delete from product where pNum=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, pNum);
				
				pstmt.executeUpdate();//쿼리문 실행
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
	}
		public void productInsert(productVO pVo) {
			
			String sql = "insert into product values(pNum_seq.nextval,?,?,?,?,?,?)";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, pVo.getpName());
				pstmt.setInt(2, pVo.getpPrice());
				pstmt.setString(3, pVo.getpImg());
				pstmt.setString(4, pVo.getpShortInfo());
				pstmt.setString(5, pVo.getpDetailInfo());
				pstmt.setString(6, pVo.getpCategory());
				
				pstmt.executeUpdate();
		
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}

}
}
