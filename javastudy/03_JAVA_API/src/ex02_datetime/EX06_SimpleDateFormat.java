package ex02_datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EX06_SimpleDateFormat {

	public static void main(String[] args) {
		// java.text.SimpleDateFormat 클래스
		// 패턴이 적용된 String 타입의 날짜 변환 
		
		Date date1 = new Date();
		java.sql.Date date2 = new java.sql.Date(System.currentTimeMillis());
		// java.sql.Date가 import 됐다면 어떤 패키지의 Date 클래스를 사용하는지 모르기 때문에 import가 되지 않았다.
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 
		
		String result1 = sdf.format(date1);
		String result2 = sdf.format(date2);
		
		System.out.println(result1);
		System.out.println(result2);

	}

}
