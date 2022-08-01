package ex08_override;

public class Square extends Rectangle {

	
	// 필드가 없을 때 생성자 자동 호출하려면
	// Source - Generate Constructor from superclass 선택
	public Square(String type, double width) {
		super(type, width, width);
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return super.getArea();
	}
	@Override
	public void info() {
		// TODO Auto-generated method stub
		super.info();
	}

}
