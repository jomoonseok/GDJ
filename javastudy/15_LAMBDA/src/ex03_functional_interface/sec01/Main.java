package ex03_functional_interface.sec01;

public class Main {

	public static void main(String[] args) {
		
		MyInterface1 my = () -> System.out.println("집에 가고 싶다.");
		my.method();
		
		MyInterface1 my2 = () -> System.out.println("진짜 집에 가고 싶다.");
		my2.method();
		
		MyInterface1 my3 = () -> System.out.println("집에 갔으면 좋겠다.");
		my3.method();

	}

}
