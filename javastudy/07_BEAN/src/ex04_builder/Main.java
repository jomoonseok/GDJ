package ex04_builder;

public class Main {

	public static void main(String[] args) {
		
		User user = User.builder()
				.userNo(1)
				.userId("admin")
				.userEmail("admin@naver.com")
				.build(); // 마지막에 build 메소드
		
		System.out.println(user);

	}

}
