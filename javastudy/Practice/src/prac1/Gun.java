package prac1;

public class Gun {

	// 필드
	String model;
	int bullet;
	
	// 생성자
	Gun(String model,int bullet) {
		this.model = model;
		this.bullet = bullet;
	}
	
	// 메소드
	
	// 장전
	public void reload(int bullet) {
		this.bullet += bullet;
		if(this.bullet > 10) {
			this.bullet = 9;
			System.out.println("0발이 장전 되었다. 현재 " + this.bullet + "발");
			return;
		}
		System.out.println(bullet + "발이 장전 되었다. 현재 " + this.bullet + "발");
	}
	
	// 발사
	public void shoot() {
		if(bullet == 0) {
			System.out.println("헛빵!");
			return;
		}
		bullet--;
		System.out.println("빵야! " + bullet + "발 남았다.");
	}
	
	// 조회
		public void info() {
			System.out.println(model + "(" + bullet + ")");
		}
	
	
}
