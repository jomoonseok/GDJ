package ex01_setter;

public class Main {

	public static void main(String[] args) {
		
		//Bean - 값을 가지고 있는 객체 VO(ValueObject), DTO()라고도 불린다.
		
		User user = new User();
		user.setUserNo(1);
		user.setId("admin");
		user.setEmail("admin@naver.com");
		
		System.out.println(user);

	}

}
