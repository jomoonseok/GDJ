package ex02_create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTableMain {

	public static void main(String[] args) {
		// create는 db에서 하면 된다.
		
		// Connection 생성
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
			String user = "SCOTT"; 
			String password = "TIGER"; 
			con = DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException e) {
			System.out.println("OracleDriver 로드 실패");
		} catch(SQLException e){
			System.out.println("DB접속정보 오류");
		}
		
		// Create Table 실행
		PreparedStatement ps = null;
		try {
			
			// String 타입의 쿼리문 작성
			// 쿼리문의 마지막 세미콜론(;) JDBC에서 사용하지 않는다.		
			StringBuilder sb = new StringBuilder();
			sb.append("CREATE TABLE BOARD(");
			sb.append("BOARD_NO NUMBER NOT NULL CONSTRAINT PK_BOARD PRIMARY KEY,"); // ctrl + shift + x 대문자 변경, ctrl + shift + y 소문자 변경
			sb.append("TITLE VARCHAR2(100 BYTE) NOT NULL,");
			sb.append("CONTENT VARCHAR2(100 BYTE) NULL,");
			sb.append("HIT NUMBER NOT NULL,");
			sb.append("CREATE_DATE DATE NOT NULL)");
			String sql =  sb.toString();			
			
			// preparedStatement 객체 생성
			// Prepared : 미리 준비하라.
			// Statement : 쿼리문
			// 역할 : 쿼리문 실행을 담당
			ps = con.prepareStatement(sql);
			//ps = con.prepareStatement("ALTER TABLE BOARD RENAME COLUMN GIT TO HIT");
			
			// 쿼리문 실행
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		// Connection 닫기, PreparedStatement 닫기
		try {
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		// 실행이 완료됐는지 확인하기 위해서 developer열어서 SCOTT계정 확인하기
		
	}

}
