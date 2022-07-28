package ex05_method;

public class Car {
	
	// 필드
	int oil;
	int speed;
	
	// 메소드
	
	// 1. 기름 넣기
	// 반환타입  : void(반환값이 없다)
	// 메소드명  : addOil
	// 매개변수  : int o
	void addOil(int o) {
		oil += o;
		// oil <= 60
		if(oil > 60) {
			oil = 60;
		}
	}
	
	
	// 2. 달리기
	// 반환타입 : void
	// 메소드명 : pushAccel
	// 매개변수 : x
	void pushAccel() {
		if(oil == 0) {
			return; // 반환 타입이 void일때만 사용 가능한 코드
		}
		if(speed == 120) {
			oil--;
			return; // 반환 타입이 void일때만 사용 가능한 코드
		}
		// 속도는 25씩 증가, 최대 속도 120
		// 기름은 1씩 사용
		speed += 25;
		
		if(speed > 120) {
			speed = 120;
		}
		
		oil--;
		
	}
	
	// 3. 멈추기
	// 반환타입 : void
	// 메소드명 : pushBrake
	// 매개변수 : x
	
	void pushBrake() {
		if(speed < 25) {
			speed = 0;
			return;
		}
		speed -= 25;
	}
	/*
	void pushBrake() {
		if(speed == 0) {
			return;
		}
		speed -= 25;
		if(speed < 0) {
			speed = 0;
		}
	}
	*/
	
	// 3. 계기판(기름, 속도) 확인
	// 반환타입 : void
	// 메소드명 : panel
	// 매개변수 : x
	
	void panel() {
		System.out.println("현재 속도 : " + speed);
		System.out.println("보유 기름 : " + oil);
	}
	

}
