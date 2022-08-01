package ex06_constructor;

public class Alba extends Student{
	
	private String company;
	
	/*public Alba(String name, String school, String company) {
		super(name, school);
		this.company = company;
	}*/
	
	// 자동으로 만든 생성자
	public Alba(String name, String school, String company) {
		super(name, school);    // ┐ 둘이 값을 바꾸면 오류난다.
		this.company = company; // ┘ 
	}

	public String getCompany() {
		return company;
	}

	

	public void setCompany(String company) {
		this.company = company;
	}
	

}
