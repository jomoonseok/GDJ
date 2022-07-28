package ex07_constructor;

public class Computer {

	// 생성자(Constructor)
	// 1. 객체 생성할 때 사용되는 특별한 메소드
	// 2. 특징
	//    1) 메소드 이름이 클래스 이름과 같다.
	//    2) 반환타입이 존재하지 않는다.
	// 3. 생성자는 필드 초기화 용도로 사용
	
	// 디폴트 생성자(Default Constructor)
	// 1. 개발자가 생성자를 만들지 않으면 자바가 자동으로 생성하는 생성자
	// 2. 아무 일도 안 하는 형태
	//    Computer(){ } → new Computer() 지금 까지 생성자가 없었어도 객체를 만들 수 있었던 이유는 디폴트 생성자 덕분이다.
	
	// 필드
	String model;
	int price;
	
	// 생성자 (적극적으로 사용하지는 않는다.)
	//                    ┌>  매개변수 인수(인자)를 받음
	Computer(String pModel, int pPrice ) {
		model = pModel;
		price = pPrice;
	}
	
	Computer() {
		
	}
	
	// 메소드
	void printComputerStatus() {
		System.out.println("모델 : " + model);
		System.out.println("가격 : " + price);
	}
	
	
}
