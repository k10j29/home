package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.PhotoVo;

public class PhotoDao {

	// single-ton : ��ü 1���������ؼ� ���(����)����
	static PhotoDao single = null;

	public static PhotoDao getInstance() {

		if (single == null)
			single = new PhotoDao();
		return single;
	}

	public PhotoDao() {
		// TODO Auto-generated constructor stub
	}

	public List<PhotoVo> selectList() {

		List<PhotoVo> list = new ArrayList<PhotoVo>();
		String sql = "select * from photo_view";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.Connection ������
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatment��ü ������
			pstmt = conn.prepareStatement(sql);

			// 3.ResultSet������
			rs = pstmt.executeQuery();

			// ��ü���ڵ带 vo�� ������ ArrayList�� �߰�
			while (rs.next()) {
				// record�� ���� ��ü ����
				PhotoVo vo = new PhotoVo();

				// record->vo�� �ű��
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_title(rs.getString("p_title"));
				vo.setP_content(rs.getString("p_content"));
				vo.setP_filename(rs.getString("p_filename"));
				vo.setP_ip(rs.getString("p_ip"));
				vo.setP_regdate(rs.getString("p_regdate"));
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_name(rs.getString("m_name"));

				// ArrayList�߰�
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	// p_idx�� �ش�Ǵ� �Խù� 1�� ������
	public PhotoVo selectOne(int p_idx) {

		PhotoVo vo = null;
		String sql = "select * from photo_view where p_idx=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.Connection ������
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatment��ü ������
			pstmt = conn.prepareStatement(sql);

			// 2-1.pstmt parameter
			pstmt.setInt(1, p_idx);

			// 3.ResultSet������
			rs = pstmt.executeQuery();

			// ��ü���ڵ带 vo�� ������ ��ȯ
			if (rs.next()) {
				// record�� ���� ��ü ����
				vo = new PhotoVo();

				// record->vo�� �ű��
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_title(rs.getString("p_title"));
				vo.setP_content(rs.getString("p_content"));
				vo.setP_filename(rs.getString("p_filename"));
				vo.setP_ip(rs.getString("p_ip"));
				vo.setP_regdate(rs.getString("p_regdate"));
				vo.setM_idx(rs.getInt("m_idx"));
				vo.setM_name(rs.getString("m_name"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}

	// �߰�
	public int insert(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = // 1 2 3 4 5
				"insert into photo values(seq_photo_p_idx.nextVal,?,?,?,?,sysdate,?)";

		try {
			// 1.Connection ���
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement ���
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter ����
			pstmt.setString(1, vo.getP_title());
			pstmt.setString(2, vo.getP_content());
			pstmt.setString(3, vo.getP_filename());
			pstmt.setString(4, vo.getP_ip());
			pstmt.setInt(5, vo.getM_idx());

			// 4.DB ó��: insert/update/delete
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}

	public int delete(int p_idx) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from photo where p_idx=?";

		try {
			// 1.Connection ���
			conn = DBService.getInstance().getConnection();
			// 2.PreparedStatement ���
			pstmt = conn.prepareStatement(sql);
			// 3.pstmt parameter ����
			pstmt.setInt(1, p_idx);

			// 4.DB ó��: insert/update/delete
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}

}
