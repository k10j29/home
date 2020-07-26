package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SawonVo;

public class SawonDao {

	//single-ton : ��ü 1���������ؼ� ���(����)����
	static SawonDao single = null;

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();
		return single;
	}

	public SawonDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<SawonVo> selectList() {

		List<SawonVo> list = new ArrayList<SawonVo>();
		String sql = "select * from sawon";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			//2.PreparedStatment��ü ������
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet������
			rs = pstmt.executeQuery();

			//��ü���ڵ带 vo�� ������ ArrayList�� �߰�
			while (rs.next()) {
				//record�� ���� ��ü ����
				SawonVo vo = new SawonVo();

				//record->vo�� �ű��
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSahire(rs.getString("sahire"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));
				
				//ArrayList�߰�
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
	
	
	
}
