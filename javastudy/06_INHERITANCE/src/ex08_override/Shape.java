package ex08_override;

public class Shape {
	
	private String type; // 도형의 종류

	public Shape(String type) {
		// super(); object 클래스 상속중이다. 
		// object - java 클래스의 뿌리
		// 신경쓰지 않아도 된다.
		
		this.type = type;
	}
	
	public double getArea() {
		return 0;
	}
	public void info() {
		System.out.println("도형의 종류 : " + type);
	}
	

}
