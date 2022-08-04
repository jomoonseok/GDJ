package ex01_exception;

import java.util.Scanner;

public class Main {
	/*
	자바 에러
	 
	부모 Throwable
	자식 Error / Exception
	Error 개발자가 해결하지 못함
	Exception 개발자가 해결해야 함(코드 수정)

	상속관계
	Exception 부모
	RuntimeException 자식
	*/
	
	public static void m1() {
		// NullPointerException : null 값이 어떤 메소드를 호출할 때 발생
		String[] hobbies = new String[5];
		
		hobbies[1] = "수영";
		hobbies[2] = "골프";
		hobbies[3] = "영화";
		hobbies[4] = "집콕";
		
		for(int i=0; i<hobbies.length; i++) {
			if(hobbies[i].equals("수영")) { // hobbies[0] 때문에 NullPointerException이 발생한다.
				System.out.println("취미가 나와 같군요");
			}
		}
	}
	
	public static void m2() {
		// NullPointerException 회피
		String[] hobbies = new String[5];
		
		hobbies[1] = "수영";
		hobbies[2] = "골프";
		hobbies[3] = "영화";
		hobbies[4] = "집콕";
		
		for(int i=0; i<hobbies.length; i++) {
			if(hobbies[i] != null && hobbies[i].equals("수영")) {
		//  if(hobbies[i].equals("수영") && hobbies[i] != null) 이 코드와 위에 코드는 다른 코드다.
				System.out.println("취미가 나와 같군요");
			}
		}
	}
	
	public static void m3() {
		// NumberFormatException : String을 Number타입으로 바꿀 때 발생(바꿀 수 없는 게 전달되었을 때)
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력(필수) >>> ");
		String name = sc.nextLine(); // Enter도 입력 받는다.
		System.out.print("나이 입력(선택) >>> ");
		String strAge = sc.nextLine(); // 입력 없이 Enter만 누르면 strAge는 빈 문자열을 가짐
		int age = Integer.parseInt(strAge);
		
		System.out.println("이름 : " + name + ", 나이 : " + age + "살");
	}
	
	public static void m4() {
		// NumberFormatException 회피
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력(필수) >>> ");
		String name = sc.nextLine(); // Enter도 입력 받는다.
		System.out.print("나이 입력(선택) >>> ");
		String strAge = sc.nextLine(); // 입력 없이 Enter만 누르면 strAge는 빈 문자열을 가짐
		int age;
		if(strAge.isEmpty()) {
			age = 0;
		} else {
			age = Integer.parseInt(strAge);
		}
		
		System.out.println("이름 : " + name + ", 나이 : " + age + "살");
	}

	public static void main(String[] args) {
		
		m4(); // static은 static만 부를 수 있다. 
		// static이 아닌 멤버가 부를 수 없는 이유는 static이 먼저 만들어져서 그렇다.
		// 에러는 밑에서부터 위로 확인한다.

	}

}
