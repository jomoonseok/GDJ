package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Free;

public class FreeDao {
	
	// field - SqlSessionFactory
	private SqlSessionFactory factory;

	// singleton pattern
	private static FreeDao dao = new FreeDao();
	private FreeDao() {
		try {
			// SqlSessionFactory 빌드 
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static FreeDao getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.free.";
	
	// 목록
	public List<Free> list() {
		SqlSession ss = factory.openSession();
		List<Free> frees = ss.selectList(mapper + "list");
		ss.close();
		return frees;
	}
	
	// 삽입
	public int insert(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insert", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 삭제
	public int delete(int freeNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "delete", freeNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 상세보기
		public Free detail(int freeNo) {
			SqlSession ss = factory.openSession();
			Free free = ss.selectOne(mapper + "detail", freeNo);
			ss.close();
			return free;
		}
		
	// 수정
	public int update(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update(mapper + "update", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// freeTOP
	public Free freeTop(){
		SqlSession ss = factory.openSession();
		Free top3 = ss.selectOne(mapper + "freeTop");
		ss.close();
		return top3;
	}
	
	
}
