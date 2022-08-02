package ex10_downcasting;

public class Main {

	public static void main(String[] args) {
		
		// 클래스 타입 : Person
		// 객체(인스턴스) : p
		
		Person p = new Alba(); // 업캐스팅
		
		// instanceof 연산자
		// 특정 인스턴스가 어떤 클래스타입인지 점검하는 연산자
		// 해당 클래스타입이면 true 반환, 아니면 false 반환
		
		System.out.println(p instanceof Person);
		System.out.println(p instanceof Student);
		System.out.println(p instanceof Alba);
		
		// p. / 여기서 자동완성 확인해보면 study() 메소드는 보이지 않는다.
		
		// p가 Student타입의 인스턴스이면 study() 메소드를 호출할 수 있다.
		if(p instanceof Student) {
			((Student) p).study(); // p. 여기서 자동완성 확인해보면 study() 메소드가 보인다. 
			                       // 그 이유는 instanceof가 실행됐기 때문이다.
			                       // 캐스팅은 조심히 사용해야해서 조건문과 같이 사용하는 걸 권장
		}
		
		// p가 Alba타입의 인스턴스이면 work() 메소드를 호출할 수 있다.
		if(p instanceof Alba) {
			((Alba) p).work();  // 다운캐스팅 적용된 모습
		}

	}

}
