package ex11_static;

public class MyMathMain {

	public static void main(String[] args) {
		
		System.out.println(MyMath.PI); // 자동완성 했을 때 S가 붙어있으면 static F는 final
		System.out.println(MyMath.abs(-5));
		
		// Math 클래스는 객체를 만들지 못한다.
		
		System.out.println(MyMath.pow(2, 5));  // 2의 5제곱(32)

	}

}
