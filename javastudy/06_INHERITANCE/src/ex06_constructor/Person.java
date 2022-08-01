package ex06_constructor;

public class Person {
	
	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	// 프라이빗 멤버의 정보를 설정하거나 가져오기위해 getter/setter가 필요하다.
	public String getName() { 
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
