package prac1;

public class Soldier {

	// 필드
	private String name;
	private Gun gun;
	
	// 생성자
	public Soldier(String name, Gun gun) {
		this.name = name;
		this.gun = gun;
	}
	
	// 메소드
	
	// 장전
	public void reload(int bul) {
		gun.reload(bul);
	}
	
	// 발사
	public void shoot() {
		gun.shoot();
	}
	
	public void info() {
		System.out.println("군인이름: " + name);
		gun.info();
	}
}
