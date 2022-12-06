package ex03_functional_interface.sec04;

public class Main {

	public static void main(String[] args) {
		
		Calculator cal1 = (a, b) -> a+b;
		System.out.println(cal1.add(1, 1));
		
		Calculator cal2 = (a, b) -> a+b;
		System.out.println(cal2.add(2, 3));
		
		Calculator cal3 = (a, b) -> a+b;
		System.out.println(cal3.add(316874626, 542357468));
		
	}

}
