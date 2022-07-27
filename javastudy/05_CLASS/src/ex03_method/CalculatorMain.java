package ex03_method;

public class CalculatorMain {

	public static void main(String[] args) {
		
		// 객체 생성
		Calculator calculator = new Calculator();
		
		// calculator 객체의 add() 메소드 호출
		// 1. 2, 3 : 인수(add메소드로 전달하는 값), 인수는 매개변수에 저장된다.
		// 2. answer = add 메소드의 반환값(return result)이 저장된다.
		int answer = calculator.add(2, 3);
		
		System.out.println(answer);
		
		// 프로그램 해석할 때는 메인부터 해석한다.
		
		// sub() 메소드 호출
		System.out.println(calculator.sub(7, 2));
		
		// mul() 메소드 호출
		System.out.println(calculator.mul(7, 2));
		
		// div() 메소드 호출
		System.out.println(calculator.div(7, 2));

	}

}
