package ex02_loop;

public class Ex05_nested_for {

	public static void main(String[] args) {
		// 1일차 1교시
		// 1일차 2교시
		// ...
		// 1일차 8교시
		// 2일차 1교시
		// ...
		// 3일차 8교시
		// 일차 1 ~ 3  /  교시 1 ~ 8 
		
		for(int day = 1; day <= 3; day++) {
			
			for(int hour = 1; hour <= 8; hour++) {
				System.out.println(day + "일차 " + hour + "교시");
			}
			
		}
		
		// 연습
		// 2x1=2
		// 2x2=4
		// ...
		// 9x9=81
		
		for(int n = 2; n <= 9; n++) {
			
			for(int m = 1; m <= 9; m++) {
				System.out.println(n + "x" + m + " = " + (n*m));
				if(m == 9) {
					System.out.println("---------------------------");
				}
			}
			
		}
		
		// 연습
		// 2x1=2
		// 2x1=4
		// ...
		// 5x5=25
		
		for(int n = 2; n <= 9; n++) {
			for(int m = 1; m <= 9; m++) {
				System.out.println(n + "x" + m + " = " + (n*m));
				if(n == 5 && m == 5) {
					n = 10;
					break;
				}
			}
		}
		
		System.out.println("---------------------------");
		
		// 라벨(label)을 이용한 풀이
		outter: for(int n = 2; n <= 9; n++) { // 이 위치를 outter라고 한 것이다.
			for(int m = 1; m <= 9; m++) {
				System.out.println(n + "x" + m + " = " + (n*m));
				if(n == 5 && m == 5) {
					break outter;
				}
			}
		}
		
		System.out.println("---------------------------");
		
		// 연습
		// 2x1=2		3x1=3		...		9x1=9
		// 2x2=4		3x2=6		...		9x2=18
		// ...
		for(int n = 2; n <= 2; n++) {
			for(int m = 1; m <= 9; m++) {
				System.out.print(n + "x" + m + " = " + (n*m) + "  ");
				System.out.print((n+1) + "x" + m + " = " + ((n+1)*m) + "  ");
				System.out.print((n+2) + "x" + m + " = " + ((n+2)*m) + "  ");
				System.out.print((n+3) + "x" + m + " = " + ((n+3)*m) + "  ");
				System.out.print((n+4) + "x" + m + " = " + ((n+4)*m) + "  ");
				System.out.print((n+5) + "x" + m + " = " + ((n+5)*m) + "  ");
				System.out.print((n+6) + "x" + m + " = " + ((n+6)*m) + "  ");
				System.out.println((n+7) + "x" + m + " = " + ((n+7)*m) + "  ");
			}
		}
		
		System.out.println("---------------------------");
		
		for(int m = 1; m <= 9; m++ ) {
			for(int n = 2; n <= 9; n++) {
				System.out.print(n + "x" + m + " = " + (n*m) + " ");
				if(n == 9) {
					System.out.println();
				}
			}
		}
		
		
	}

}
