package ex09_this;

public class Student {

	// This
	// 1. 현재 객체의 참조값
	// 2. 현재 객체의 멤버(필드, 메소드)를 호출할 때 사용
	// 3. 생성자 내부에서 다른 생성자를 호출할 때 this() 형태로 사용
	
	// 필드
	private String stuNo;  // this.stuNo
	private String name;   // this.name
	
	// 생성자
	public Student() {
		
	}
	
	public Student(String stuNo, String name) {
		this.stuNo = stuNo;
		this.name = name;
	}
	
	
	// 메소드 
	// getter, setter는 이름을 바꾸면 안 된다. 그래서 손으로 쓰지 않는다.
	// Source - Generate getter and setter
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
