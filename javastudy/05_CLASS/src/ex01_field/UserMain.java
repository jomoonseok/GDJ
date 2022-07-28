package ex01_field;

public class UserMain {
	
	//static int a; → 필드 (클래스 안에서 생성)
	
	public static void main(String[] args) {
		
		// int b; → 변수 (메인 매소드 안에서 생성)
		
		// 클래스 (데이터타입)        : User
		// 객체 (변수 개념, 인스턴스) : user 객체이름으로 클래스와 똑같은 이름을 많이 사용한다.(대소문자만 바꿔서)
		//                              모든 객체는 참조값을 갖는다.
		
		// 객체는 객체가 가지고 있는 기능을 꺼낼 수 있다.
		// String s = "hi";
		// s.equals("hi"); / String 클래스 객체 s가 가지고 있는 .equals() 기능
		
		// 동일 패키지에 있으면 import 없이도 클래스를 사용할 수 있다.
		// User도 UserMain도 ex01_field 패키지에 있다.
		
		// 객체 선언
		// User user = null;
		
		// 객체 생성
		// user = new User();
		
		// 객체 선언과 생성을 한 번에 - 대부분 이 방법으로 생성한다.
		User user = new User();
		
		// 모든 User 객체는 동일한 필드값을 가지고 있다. 
		// 마침표(.)를 이용해서 필드값을 호출한다.
		System.out.println(user.id);
		System.out.println(user.password);
		System.out.println(user.email);
		System.out.println(user.point);
		System.out.println(user.isVip);
		
		// 필드값 변경
		user.id = "admin";
		user.password = "123456";
		user.email = "admin@web.com";
		user.point = 1000;
		user.isVip = (user.point >= 10000);
		
		System.out.println(user.id);
		System.out.println(user.password);
		System.out.println(user.email);
		System.out.println(user.point);
		System.out.println(user.isVip);
		

	}

}
