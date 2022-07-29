package prac1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Watch {

	// 필드
	int hour;
	int minute;
	int second;
	
	// 생성자
	Watch(int h, int m, int s){
		this.hour = h;
		this.minute = m;
		this.second = s;
	}

	// 메소드
	public void addHour(int h) {
		System.out.println(h + "시간 후" + "(" + (h/24) + "시간)");
	}
	
	public void addMinute(int m) {
		System.out.println(m + "분 후" + "(" + (m/60) + "시간 " + (m % 60) + "분)");
	}
	public void addSecond(int s) {
		System.out.println(s + "초 후" + "(" + (s/3600) + "시간 " + ((s%3600)/60) + "분 " + (s%60) + "초)");
	}
	
	public void see() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		String date = dtf.format(now);
		System.out.println(date);
	}
}
