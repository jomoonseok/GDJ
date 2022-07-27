package ex06_method_overload;

public class Calculator {
	
	// 메소드 오버로딩
	// 1. 같은 이름의 메소드가 두 개 이상 존재한다. add 메소드가 오버로딩 되어있다.
	// 2. 같은 이름과 다른 매개변수를 가져야 오버로딩 할 수 있다.
	// 3. 반환타입은 오버로딩과 상관 없다.
	
	int add(int a, int b) {
		return a + b;
	}
	
	int add(int a, int b, int c) {
		return a + b + c;
	}
	
	int add(int a, int b, int c, int d) {
		return a + b + c + d;
	}
	
	int add(int[] arr) {
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		return sum;
	}
	

}
