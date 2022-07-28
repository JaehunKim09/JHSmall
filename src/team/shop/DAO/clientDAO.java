package team.shop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import team.shop.DTO.clientVO;
import team.util.DBManager;

//DAO : DB와 어떻게 일 할 것인가? 에 대한 코드
public class clientDAO {

	private clientDAO() {
	}

	private static clientDAO instance = new clientDAO();

	public static clientDAO getInstance() {
		return instance;
	}
	
	public int getUserIdCheck(String id2) {
		String sql = "select * from client where id=?";

		clientVO cVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id2);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cVo = new clientVO();

				cVo.setId(rs.getString("id"));
			}
			if(cVo.getId() != null) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	public clientVO getUser(String id2) {
		String sql = "select * from client where id=?";

		clientVO cVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id2);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cVo = new clientVO();

				cVo.setId(rs.getString("id"));
				cVo.setPw(rs.getString("pw"));
				cVo.setName(rs.getString("name"));
				cVo.setEmail(rs.getString("email"));
				cVo.setAddress1(rs.getString("address1"));
				cVo.setAddress2(rs.getString("address2"));
				cVo.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cVo;
	}

	public void insertClient(clientVO cVo) {

		String sql = "insert into client values(?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo.getId());
			pstmt.setString(2, cVo.getPw());
			pstmt.setString(3, cVo.getName());
			pstmt.setString(4, cVo.getEmail());
			pstmt.setString(5, cVo.getAddress1());
			pstmt.setString(6, cVo.getAddress2());
			pstmt.setString(7, cVo.getPhone());

			pstmt.executeUpdate();// 쿼리문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public void updateClient(String id, clientVO cVo2) {

		String sql = "update client set pw=?, email=?, address1=?, address2=?, phone=? where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cVo2.getPw());
			pstmt.setString(2, cVo2.getEmail());
			pstmt.setString(3, cVo2.getAddress1());
			pstmt.setString(4, cVo2.getAddress2());
			pstmt.setString(5, cVo2.getPhone());
			pstmt.setString(6, id);

			pstmt.executeUpdate();// 쿼리문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public List<clientVO> selectAllclients() {
		String sql = "select * from client";

		List<clientVO> list = new ArrayList<clientVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				clientVO cVo = new clientVO();
				// bVo의 setter에 값세팅 (rs가 타입변환 시켜줌)
				cVo.setId(rs.getString("id"));
				cVo.setName(rs.getString("name"));

				list.add(cVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public clientVO selectOneclient(String id) {

		String sql = "select * from client where id=?";
		
		clientVO cVO= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				 cVO = new clientVO();

				cVO.setId(rs.getString("id"));
				cVO.setPw(rs.getString("pw"));
				cVO.setName(rs.getString("name"));
				cVO.setEmail(rs.getString("email"));
				cVO.setAddress1(rs.getString("address1"));
				cVO.setAddress2(rs.getString("address2"));
				cVO.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cVO;
	

	}

public void DeleteUser(String id) {
	
	String sql = "delete from client where id=?";

	
	Connection conn = null;
	PreparedStatement pstmt = null;

	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);

		
		pstmt.setString(1, id);	 

		pstmt.executeUpdate();// 쿼리문 실행

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBManager.close(conn, pstmt);
	}
	

}

 public ArrayList<clientVO> searchClient(String id){
	 
	ArrayList<clientVO> list = new ArrayList<clientVO>();
	String sql = "select * from client where id like '%'||?||'%'";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();

		while(rs.next()) {
			clientVO cVO = new clientVO();

				cVO.setId(rs.getString("id"));
				cVO.setPw(rs.getString("pw"));
				cVO.setName(rs.getString("name"));
				cVO.setEmail(rs.getString("email"));
				cVO.setAddress1(rs.getString("address1"));
				cVO.setAddress2(rs.getString("address2"));
				cVO.setPhone(rs.getString("phone"));
			list.add(cVO);
		}

	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBManager.close(conn, pstmt, rs);
	}
	return list;
}
}
