package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVo;

public class DeptDao {

	//Mybatis���ó�� ��ü
	SqlSessionFactory factory;
	
	//single-ton : ��ü 1���������ؼ� ���(����)����
	static DeptDao single = null;

	public static DeptDao getInstance() {

		if (single == null)
			single = new DeptDao();
		return single;
	}

	public DeptDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//�μ����
	public List<DeptVo> selectList(){
		
		List<DeptVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("dept.dept_list");
		
		sqlSession.close();
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
}
