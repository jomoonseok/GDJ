package ex03_singleton;

public class Main {

	public static void main(String[] args) {
		
		// singleton 객체는 하나만 생성된다.
		// user1과 user2는 같은 객체
		// 여러 개의 객체가 만들어지면 안 될 때 사용
		// new 연산자를 사용하지 못하게 하는 방법
		
		User user1 = User.getInstance();
		System.out.println(user1);
		
		User user2 = User.getInstance();
		System.out.println(user2);
		
		// User user = new User();  오류난다.
		// 외부에서는 새로운 객체를 생성할 수 없다.

	}

}
