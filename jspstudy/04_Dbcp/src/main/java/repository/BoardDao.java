package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Board;

public class BoardDao { // 실행 흐름 list -> controller -> service -> dao / 코드구현은 역순으로 하는 게 빠르다.

	// field
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	// Connection Pool 관리
	private DataSource dataSource;
	
	
	// singleton - pattern
	private static BoardDao dao = new BoardDao();
	private BoardDao() {
		try {
			// DataSource 객체 생성
			// context.xml에서 name="jdbc/oracle11g"인 Resource를 찾아서 생성(JNDI)
			Context ctx = new InitialContext();
			Context envCtx = (Context)ctx.lookup("java:comp/env");
			dataSource = (DataSource)envCtx.lookup("jdbc/oracle11g"); 
			// dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle11g"); 위에 두 줄을 한 줄로 쓸 수 있다.
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}

	public static BoardDao getInstance() {
		return dao;
	}
	
	// method
	
	// 1. 접속/자원 해제
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) { rs.close(); }
			if(ps != null) { ps.close(); }
			if(con != null) { con.close(); } // connection Pool의 close()는 Connection 종료가 아닌 Connection 변환으로 동작
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 2. 목록 반환하기
	public List<Board> selectAllBoard() {
		List<Board> boards = new ArrayList<Board>();
		try {
			con = dataSource.getConnection(); // CP로부터 Connection 대여
			sql = "SELECT BOARD_NO, TITLE, CONTENT, CREATE_DATE FROM BOARD ORDER BY BOARD_NO DESC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); // SELECT문은 executeQuery() 사용
			while(rs.next()) { // 목록보기는 while문
				Board board = new Board();
				board.setBoard_no(rs.getInt(1));      // rs.getInt("BOARD_NO")
				board.setTitle(rs.getString(2));      // rs.getString("TITLE")
				board.setContent(rs.getString(3));    // rs.getSting("CONTENT")
				board.setCreate_date(rs.getDate(4));  // rs.getDate("CREATE_DATE")
				// 가져온 게시글을 리스트에 추가함
				boards.add(board);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return boards;
	}
	
	// 3. 상세보기
	public Board selectBoardByNo(int board_no) {
		Board board = null;
		try {
			con = dataSource.getConnection(); // dataSource에서 connection을 하나 가져온다.
			sql = "SELECT BOARD_NO, TITLE, CONTENT, CREATE_DATE FROM BOARD WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, board_no); // 1번째 물음표(?)에 board_no 전달하기
			rs = ps.executeQuery(); // SELECT문은 executeQuery() 사용
			if(rs.next()) { // rs는 1 아니면 0이라 여기서는 while이 아닌 if를 사용
				board = new Board();
				board.setBoard_no(rs.getInt(1));      // rs.getInt("BOARD_NO")
				board.setTitle(rs.getString(2));      // rs.getString("TITLE")
				board.setContent(rs.getString(3));    // rs.getSting("CONTENT")
				board.setCreate_date(rs.getDate(4));  // rs.getDate("CREATE_DATE")
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return board;
	}
	
	// 4. 게시글 삽입
	public int insertBoard(Board board) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			result = ps.executeUpdate(); // INSERT문은 executeUpdate() 메소드 사용
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	// 5. 게시글 수정
	public int updateBoard(Board board) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setInt(3, board.getBoard_no());
			ps.executeUpdate(); // UPDATE문은 executeUpdate() 메소드 사용
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	

}