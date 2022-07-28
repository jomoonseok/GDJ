package ex08_access_modifier;

public class UserMain {

	public static void main(String[] args) {
		
		User user = new User();
		
		// System.out.println(user.id); 이런 식의 접근은 허락하지 않는다.
		System.out.println(user.getId()); // 메소드를 통한 우회 작업
		
		user.setId("admin");
		System.out.println(user.getId());
		
		user.setPassword("123456");
		System.out.println(user.getPassword());
		
		user.setEmail("admin@naver.com");
		System.out.println(user.getEmail());
		
		user.setPoint(10000);
		System.out.println(user.getPoint());
		
		//user.setVip(false);  // 메소드를 공개하면 곤란한 상황 private로 막아버림
		System.out.println(user.getVip());

	}

}
