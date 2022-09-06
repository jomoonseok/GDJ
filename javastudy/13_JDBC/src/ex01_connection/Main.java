package ex01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		// OracleDriver 열기(메모리에 로드하기) / 둘 중 하나 사용
		// 1. oracle.jdbc.OracleDriver
		// 2. oracle.jdbc.driver.OracleDriver
		
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 클래스를 열어주는 클래스
		} catch(ClassNotFoundException e) {
			System.out.println("OracleDriver 로드 실패");
		}
		
		// DriverManager로부터 Connection(DB접속) 받아오기
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB마다 url은 달라짐(Oracle XE 버전 기준)
			String user = "SCOTT"; // 대소문자 구분할 필요없다.
			String password = "TIGER"; // 계정 만들 때 사용한 대소문자를 지켜야 한다. 
			// 실제 프로젝트를 만들 때는 보안상의 이유로 이렇게 처리하면 안 된다.
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB접속 성공");
		} catch(SQLException e) {
			System.out.println("DB접속정보 오류");
		}
		try {
			if(con != null) {
				con.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		// Connection 종료
		// JDBC에서는 Connection을 닫는 것이 굉장히 중요! / 1. 접속 | 2. 작업 | 3. 종료
		
		
	}

}
