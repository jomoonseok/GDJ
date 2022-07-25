package ex02_datetime;

import java.util.Calendar;

public class Ex04_Calendar {

	public static void main(String[] args) {
		// java.util Calendar 클래스
		// 현재 날짜 또는 특정 날짜를 나타낼 때 사용   현재 날짜 며칠 후를 구하는 식으로 많이 사용
		// 날짜의 특정 요소(년, 월, 일, 시, 분, 초, ...)를 쉽게 사용
		
		Calendar cal = Calendar.getInstance();  // 객체 cal은 현재 날짜와 시간으로 구성 / 자동 완성을 해야하는 이유 import를 자동으로 해줘서
		// ↑Class ↖Object (변수 같은 얘들)        int a;
		//  (type 같은 느낌)                        type variable
		
		// 년, 월, 일, 요일
		int year = cal.get(Calendar.YEAR); // int year = cal.get(1); / ctrl + Calendar 클릭하면 Calendar 클래스로 이동
		//                 Calendar 클래스에 있는 YEAR 상수값을 가져와라
		int month = cal.get(Calendar.MONTH) + 1; // 7월인데 6이 나옴 / 월 : 0~11 (주의가 필요함)
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int weekNo = cal.get(Calendar.DAY_OF_WEEK); //일주일에 몇번째 날짜인지 / 일요일 1, 월요일 2, 화요일 3 ... 토요일 7
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		switch(weekNo) {
		case 1 : System.out.println("일요일"); break;
		case 2 : System.out.println("월요일"); break;
		case 3 : System.out.println("화요일"); break;
		case 4 : System.out.println("수요일"); break;
		case 5 : System.out.println("목요일"); break;
		case 6 : System.out.println("금요일"); break;
		default : System.out.println("토요일");
		}
		
		// 오전/오후, 시, 분, 초
		int ampm = cal.get(Calendar.AM_PM); // 오전(0) 오후(1)
		int hour12 = cal.get(Calendar.HOUR); // 시(1~12)
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); // 시(0~23)
		int minute = cal.get(Calendar.MINUTE); // 분(0~59)
		int second = cal.get(Calendar.SECOND); // 초(0~59)
		
		switch(ampm) {
		case 0 : System.out.println("오전"); break;
		case 1 : System.out.println("오후"); break;
		}
		System.out.println(hour12);
		System.out.println(hour24);
		System.out.println(minute);
		System.out.println(second);
		
		// timestamp
		long timestamp = cal.getTimeInMillis();
		System.out.println(timestamp);
		

	}

}
