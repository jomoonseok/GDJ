package ex03_method;

public class Calculator {

	// 메소드(Method)
	// 함수의 개념과 동일
	// 클래스 내부에 포함된 함수는 메소드라고 부름
	
	/*
	public static void q1() {              // 메소드의 생성 위치는 상관 없고 실행 순서가 중요하다.
		System.out.println("Q1");
	}
	
	public static void q2() {
		System.out.println("Q2");
	}
	
	System.out.println(q2); // q1이 먼저 만들어졌지만 호출은 q2를 먼저 불러서 Q2 Q1이 출력 된다.
	System.out.println(q1);
	*/
	
	// 계산 기능(메소드)
	
		// add 메소드 정의
		// 1. int : 반환타입 (add 메소드를 실행하면 int 타입의 결과값이 반환된다.)
		// 2. add : 메소드명 (마음대로 지으면 됨)
		// 3. int a, int b : 매개변수 (add 메소드를 호출할 때 int 타입의 값 2개가 전달되어야 한다.)
		
		// 메소드 해석 방향 ←
	
	int add(int a, int b) {
		int result = a + b;
		return result; // 반환값
	}
	
	// sub 메소드 정의
	int sub(int a, int b) {
		int result = a - b;
		return result;
	}
	
	// mul 메소드 정의
	int mul(int a, int b) {
		int result = a * b;
		return result;
	}
	
	// div 메소드 정의 ( div(7, 2) --> 3.5 )
	double div(int a, int b) {
		double result = (double)a / b;
		return result;
	}
	
	
}
