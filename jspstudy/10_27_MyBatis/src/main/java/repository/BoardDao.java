package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Board;

public class BoardDao {
	
	// field - SqlSessionFactory
	private SqlSessionFactory factory;

	// singleton pattern
	private static BoardDao dao = new BoardDao();
	private BoardDao() {
		try {
			// SqlSessionFactory 빌드 
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static BoardDao getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.board.";
	
	// 목록
	public List<Board> list() {
		SqlSession ss = factory.openSession();
		List<Board> boards = ss.selectList(mapper + "list");
		ss.close();
		return boards;
	}
	
	// 게시글 수
	public int count() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "count");
		ss.close();
		return count;
	}
	
	// 게시글 삽입
	public int insert(Board board) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insert", board);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 게시글 상세보기
	public Board detail(int boardNo) {
		SqlSession ss = factory.openSession();
		Board board = ss.selectOne(mapper + "detail", boardNo);
		ss.close();
		return board;
	}
	
	// 게시글 수정
	public int update(Board board) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update(mapper + "update", board);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 게시글 삭제
	public int delete(int boardNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "delete", boardNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	
}
