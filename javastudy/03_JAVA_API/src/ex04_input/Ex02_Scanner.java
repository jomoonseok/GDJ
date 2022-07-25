package ex04_input;

import java.util.Scanner;

public class Ex02_Scanner {

	public static void main(String[] args) {
		// java.util.Scanner 클래스
		// 데이터타입별로 입력 받을 수 있는 메소드를 제공
		// int : nextInt()
		// long : nextLong()
		// double : nextDouble()
		// String : nextLine() - 공백 포함 입력 가능, next() - 공백 포함 입력 불가능
		
		
		Scanner sc = new Scanner(System.in); // 객체 sc는 System.in(키보드)로부터 입력을 받는다.
		/*
		System.out.print("이름을 입력하세요 >>> ");
		String name = sc.next();
		
		System.out.print("나이를 입력하세요 >>> ");
		int age = sc.nextInt();
		
		System.out.println(name);
		System.out.println(age);
		*/
		//sc.close(); // 생략 가능 / 열어놨던 통로를 닫아라.
		
		// 사용할 일이 거의 없다.
		// 내일 시험에는 나온다.
		
		
		
		// 연습. char 타입의 성별을 입력 받기
		System.out.print("성별(남/여)을 입력하세요 >>> ");
		char gender = sc.nextLine().charAt(0);
		System.out.println(gender);
		
		// 22-07-25 23:26
		
	}

}
