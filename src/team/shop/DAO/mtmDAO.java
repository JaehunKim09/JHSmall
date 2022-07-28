package team.shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import team.shop.DTO.clientVO;
import team.shop.DTO.mtmVO;

import team.util.DBManager;

public class mtmDAO {
	private mtmDAO() {
	}

	private static mtmDAO instance = new mtmDAO();

	public static mtmDAO getInstance() {
		return instance;
	}
	//문의내역 입력
	public static mtmVO insertmtm(mtmVO mtmVo,String loginUser) {
		
		String sql = "insert into mtm(mNum,id,title,content,mKind) values(mNum_seq.nextVal,?,?,?,?)";
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		
		
		mtmVO mtmVO = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser);
			//pstmt.setInt(2, mtmVo.getmNum());
			pstmt.setString(2, mtmVo.getTitle());
			pstmt.setString(3, mtmVo.getContent());
			//pstmt.setString(5, mtmVo.getReply());
			//pstmt.setTimestamp(4, mtmVo.getmDate());
			pstmt.setString(4, mtmVo.getmKind());
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return mtmVO;
		
	}//insertmtm끝
	
	//내가 문의한 전체내역 조회
	public ArrayList<mtmVO> selectMtm(String id) {
		String sql="select * from mtm where id=? order by mDate desc";
		
		ArrayList<mtmVO> mtmVO = new ArrayList<mtmVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mtmVO mtmVo = new mtmVO();
				
				mtmVo.setmNum(rs.getInt("mNum"));
				mtmVo.setId(rs.getString("id"));
				mtmVo.setTitle(rs.getString("title"));
				mtmVo.setContent(rs.getString("content"));
				mtmVo.setmDate(rs.getTimestamp("mDate"));
				mtmVO.add(mtmVo);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mtmVO;
		
	}//selectMtm끝
	
	//내가 문의한 내역 조회
	public mtmVO selectOneMtm(String mNum) {
		String sql="select * from mtm where mNum=?";
		
		mtmVO mtmVo = new mtmVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				mtmVo.setmNum(rs.getInt("mNum"));
				mtmVo.setId(rs.getString("id"));
				mtmVo.setTitle(rs.getString("title"));
				mtmVo.setContent(rs.getString("content"));
				mtmVo.setmDate(rs.getTimestamp("mDate"));
				mtmVo.setmKind(rs.getString("mKind"));
				mtmVo.setReply(rs.getString("reply"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mtmVo;
	}//selectOneMtm끝
	
	//내가 문의한 내역 수정
	
	
	public static mtmVO mtmUpdate(mtmVO mtmVo) {
		String sql = "update mtm set mKind=?, title=?, content=? where mNum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		 try {
			 
			 conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mtmVo.getmKind());
			pstmt.setString(2, mtmVo.getTitle());
			pstmt.setString(3, mtmVo.getContent());
			pstmt.setInt(4, mtmVo.getmNum());
			
			pstmt.executeUpdate();
			
		 }catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return mtmVo;
	}//mtmUpdate끝
	
	public void mtmDelete(String mNum) {
		String sql="delete from mtm where mNum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mNum);
			
			pstmt.executeUpdate();
					
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}//mtmDelete끝
	
	/*
	 * public static mtmVO mtmReply(String admin_id, String content) {
	 * 
	 * String sql = "insert into mtm(mNum,admin_id,content) values(mNum_seq.nextVal,?,?)";
	 * 
	 * Connection conn=null; PreparedStatement pstmt = null;
	 * 
	 * 
	 * 
	 * mtmVO mtmVO = null;
	 * 
	 * try { conn = DBManager.getConnection(); pstmt = conn.prepareStatement(sql);
	 * 
	 * pstmt.setString(1, admin_id);
	 * 
	 * pstmt.setString(2, content);
	 * 
	 * pstmt.executeUpdate();
	 * 
	 * }catch (Exception e) { e.printStackTrace(); }finally { DBManager.close(conn,
	 * pstmt); } return mtmVO;
	 * 
	 * 
	 * }
	 */
	
	/*
	 * public static mtmVO mtmReply(mtmVO mtmVo) { String sql =
	 * "update mtm set reply=? where mNum=?";
	 * 
	 * Connection conn = null; PreparedStatement pstmt = null;
	 * 
	 * 
	 * try {
	 * 
	 * conn = DBManager.getConnection(); pstmt = conn.prepareStatement(sql);
	 * 
	 * pstmt.setString(1, mtmVo.getReply()); pstmt.setInt(2, mtmVo.getmNum());
	 * 
	 * pstmt.executeUpdate();
	 * 
	 * }catch (Exception e) { e.printStackTrace(); }finally { DBManager.close(conn,
	 * pstmt); } return mtmVo; }//mtmUpdate끝
	 */	
	
	public ArrayList<mtmVO> mtmList() {
		String sql="select * from mtm";
		
		ArrayList<mtmVO> mtmVo = new ArrayList<mtmVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//pstmt.setString(1, id);
			
			while(rs.next()) {
				mtmVO mVo = new mtmVO();
				
				mVo.setmNum(Integer.parseInt(rs.getString("mNum")));
				mVo.setId(rs.getString("id"));
				mVo.setTitle(rs.getString("title"));
				mVo.setContent(rs.getString("content"));
				mVo.setmDate(rs.getTimestamp("mDate"));
				mVo.setmKind(rs.getString("mKind"));
				mVo.setReply(rs.getString("reply"));
				
				mtmVo.add(mVo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mtmVo;
	}//mtmList끝
	
	public mtmVO adGetMtm(String mNum) {
		String sql="select * from mtm where mNum=?";
		
		mtmVO mtmVo = new mtmVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				mtmVo.setmNum(rs.getInt("mNum"));
				mtmVo.setId(rs.getString("id"));
				mtmVo.setTitle(rs.getString("title"));
				mtmVo.setContent(rs.getString("content"));
				mtmVo.setmDate(rs.getTimestamp("mDate"));
				mtmVo.setmKind(rs.getString("mKind"));
				mtmVo.setReply(rs.getString("reply"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mtmVo;
	}//adGetMtm끝
		
	public void admtmUpdate(mtmVO mtmVo) {
		String sql = "update mtm set reply=? where mNum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		 try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mtmVo.getReply());
			pstmt.setInt(2, mtmVo.getmNum());
			
			pstmt.executeUpdate();
		 }catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}

	}//admtmUpdate끝
	
	public ArrayList<mtmVO> searchMtm(String id){
		 
		ArrayList<mtmVO> list = new ArrayList<mtmVO>();
		String sql = "select * from mtm where id like '%'||?||'%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				mtmVO cVo = new mtmVO();

				cVo.setId(rs.getString("id"));
				cVo.setmNum(Integer.parseInt(rs.getString("mNum")));
				cVo.setTitle(rs.getString("title"));
				cVo.setContent(rs.getString("content"));
				cVo.setmDate(rs.getTimestamp("mDate"));
				cVo.setReply(rs.getString("reply"));
				
				list.add(cVo);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
}