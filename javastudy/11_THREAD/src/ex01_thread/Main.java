package ex01_thread;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Main 시작"); // Main은 시작하라고 알려주고 자신의 일 수행
		
		Process process1 = new Process("연산");
		process1.start(); // Process 클래스의 오버라이드된 run() 메소드가 호출
		// Main이 한 게 아니라 Process에서 처리
		
		Process process2 = new Process("제어");
		process2.start(); // 제어가 먼저 실행될 수도 있다.
		// 실행을 늦게 할 수도 있다.
		
		System.out.println("Main 종료");

	}

}
