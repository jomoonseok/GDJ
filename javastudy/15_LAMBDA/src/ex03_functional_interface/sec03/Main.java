package ex03_functional_interface.sec03;

public class Main {

	public static void main(String[] args) {
		
		MyInterface3 my = () -> {return 10;};
		System.out.println(my.method());
		
		MyInterface3 my2 = () -> 20; // return이 하나면 
		System.out.println(my2.method());

	}

}
