package ex01_is_a;

// 서브클래스
// extends 키워드를 사용
// 슈퍼클래스 Person의 모든 필드와 메소드를 자기것처럼 사용

//                     ┌> is a를 넣어서 말이 되면 가능 
public class Student extends Person {
	              // extends의 뜻은 확장이지만 상속이라고 해석한다.
	public void study() {
		System.out.println("공부한다.");
	}
}
