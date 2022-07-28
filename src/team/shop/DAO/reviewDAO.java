package team.shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import team.shop.DTO.clientVO;
import team.shop.DTO.reviewVO;
import team.util.DBManager;


public class reviewDAO {
	private reviewDAO() {
	}

	private static reviewDAO instance = new reviewDAO();

	public static reviewDAO getInstance() {
		return instance;
	}

	public ArrayList<reviewVO> listreview(String pNum) {
		ArrayList<reviewVO> reviewList = new ArrayList<reviewVO>();
		String sql = "select * from review where pNum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reviewVO pVo = new reviewVO();

				//pVo.setpNum(rs.getInt("pNum"));
				pVo.setId(rs.getString("id"));
				//pVo.setoNum(rs.getInt("oNum"));
				//pVo.setrNum(rs.getInt("rNum"));
				pVo.setContent(rs.getString("content"));
				pVo.setrImg(rs.getString("rImg"));
				pVo.setrReply(rs.getString("rReply"));
				pVo.setrDate(rs.getTimestamp("rDate"));
						
				reviewList.add(pVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return reviewList;
	}

	public void insertReview(reviewVO rVo) {
		
		String sql = "insert into review(pNum,id,rNum,content) values(?,?,rNum_seq.nextval,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rVo.getpNum());
			pstmt.setString(2, rVo.getId());
			pstmt.setString(3, rVo.getContent());
			
			pstmt.executeUpdate();//쿼리문 실행
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public ArrayList<reviewVO> listMyreview(String id) {
		ArrayList<reviewVO> list = new ArrayList<reviewVO>();
		String sql = "select * from mypage5_view where id = ? order by rDate desc";
		
		reviewVO rVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				rVo = new reviewVO();
				
				rVo.setpName(rs.getString("pName"));
				rVo.setpNum(rs.getInt("pNum"));
				rVo.setId(rs.getString("id"));
				rVo.setContent(rs.getString("content"));
				rVo.setpImg(rs.getString("pImg"));
				rVo.setrReply(rs.getString("rReply"));
				rVo.setrDate(rs.getTimestamp("rDate"));
							
				list.add(rVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	public void reviewDelete(int rNum) {
		String sql = "delete from review where rNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, rNum);

			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}

	public ArrayList<reviewVO> reviewList() {
		String sql="select * from review";
		
		ArrayList<reviewVO> reviewList = new ArrayList<reviewVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				reviewVO pVo = new reviewVO();

				pVo.setpNum(rs.getInt("pNum"));
				pVo.setId(rs.getString("id"));
				pVo.setoNum(rs.getInt("oNum"));
				pVo.setrNum(rs.getInt("rNum"));
				pVo.setContent(rs.getString("content"));
				pVo.setrImg(rs.getString("rImg"));
				pVo.setrReply(rs.getString("rReply"));
				pVo.setrDate(rs.getTimestamp("rDate"));
				
				reviewList.add(pVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return reviewList;
	}

	public void reviewReplyUpdate(int rNum, String rReply) {
		String sql = "update review set rReply=? where rNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, rReply);
			pstmt.setInt(2, rNum);

			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}

	
