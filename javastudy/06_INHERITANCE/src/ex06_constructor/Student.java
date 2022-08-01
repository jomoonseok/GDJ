package ex06_constructor;

public class Student extends Person{ 
	// 슈퍼클래스의 생성자를 호출하지 않아서 오류가 뜸
	// 생성자를 호출하지 않아도 JVM이 자동으로 호출해 주는데
	// 디폴트 생성자만 호출해준다.
	
	// getter/setter 처럼 생성자도 손으로 입력하지 않는다.
	// 뭐하는 작업인지만 알면 된다.
	// 상속관계만 잘 적어주면 된다.
	// Source - Generate Constructor Using Field... 선택
	
	private String school;
	
	/*public Student(String name, String school) { 
		// 우리가 만든 생성자는 이름이 필요한데 여기서 이름을 준다.
		
		super(name); // name은 슈퍼클래스의 생성자 매개변수로 들어간다
		             // super(); 슈퍼클래스를 나타내는 키워드
		
		this.school = school;
	}*/
	
	// 자동으로 만든 생성자
	public Student(String name, String school) {
		super(name);
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

}
