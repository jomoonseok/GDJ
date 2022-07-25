package ex02_datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex05_LocalDateTime {

	public static void main(String[] args) {
		// java.time.LocalDateTime 클래스
		// JDK 1.8부터 사용이 가능한 클래스
		// 특정 날짜 요소 사용이 가능
		// 날짜의 패턴 지정이 가능
		
		LocalDateTime now = LocalDateTime.now(); // 현재 날짜와 시간
		System.out.println(now);
		// 특정 날짜 요소 사용
		int year = now.getYear();
		int month = now.getMonthValue();  // 1 ~ 12
		int day = now.getDayOfMonth();    // 1 ~ 31
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		// 코드는 가능하면 복사하자 코드를 틀리지 않기 위해서
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);
		
		// 패턴
		// 패턴의 적용 결과는 String이다.
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("a h:mm yyyy-MM-dd");
		String date = dtf.format(now);
		System.out.println(date);
		
		// 1.8 이전 SimpleDateFormat 사용

	}

}
