package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.VisitVo;

public class VisitDao {

	
	//Mybatisó����ü
	SqlSessionFactory factory;
	//single-ton : ��ü 1���������ؼ� ���(����)����
	static VisitDao single = null;

	public static VisitDao getInstance() {

		if (single == null)
			single = new VisitDao();
		return single;
	}

	public VisitDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		
	}
	
	//���� ��ȸ
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		//�۾�(��û)����
		list = sqlSession.selectList("visit.visit_list");
		
		sqlSession.close();

		return list;
	}
	
	public List<VisitVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<VisitVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		//�۾�(��û)����
		list = sqlSession.selectList("visit.visit_list_condition",map);
		
		sqlSession.close();

		return list;
	}

	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//DML��ɿ����� Ʈ����� �ɼ� ���� ����
		
		//�۾����� ���   true: auto commit  false:�⺻��
		SqlSession sqlSession = factory.openSession(true);
		
		//�۾�����
		res = sqlSession.insert("visit.visit_insert",vo);
		
		//Ʈ����� : commit():����  or rollback():���
		//sqlSession.commit();//����
		
		//�ݳ�
		sqlSession.close();
		
		
		return res;
	}

	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//  true : auto commit
		SqlSession sqlSession = factory.openSession(true);
		
		//2.�۾�����
		res = sqlSession.delete("visit.visit_delete",idx);
		
		//3.��ȯ
		sqlSession.close();
		
		return res;
	}

	public VisitVo selectOne(int idx) {

		VisitVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("visit.visit_one", idx);
		
		sqlSession.close();
			

		return vo;
	}

	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
	    //  true : auto commit
		SqlSession sqlSession = factory.openSession(true);
		
		//2.�۾�����
		res = sqlSession.update("visit.visit_update",vo);
		
		//3.��ȯ
		sqlSession.close();
		
		
		return res;
	}

	
	
	
}







