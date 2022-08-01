package ex06_constructor;

public class AlbaMain {

	public static void main(String[] args) {
		
		Alba alba = new Alba("jessica", "seoul univ", "library");
		
		System.out.println(alba.getName());
		System.out.println(alba.getSchool());
		System.out.println(alba.getCompany());

	}

}
