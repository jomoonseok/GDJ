package ex02_loop;

public class Ex01_for {

	public static void main(String[] args) {
		// for문
		// 연속된 숫자를 생성할 때 주로 사용한다.
		// 배열과 함께 자주 사용된다.
		// for(초기문; 조건문; 증감문) {
		//     실행문
		// }
		
		// 1 ~ 10 
		for(int n = 1; n <= 10; n++) {
			System.out.print(n);
		}
		// 초기문 -> 조건문 -> 실행문 -> 증감문 -> 조건문 -> 실행문 -> 증감문 ...
		//                                         여기서 반복
		
		System.out.println(); // 줄 바꿈하려고 사용하기도 한다.
		
		// 연습 
		// 10 ~ 1
		for(int n = 10; n >= 1; n--) {
			System.out.print(n);
		}
		
		System.out.println();
		
		// 연습
		// 구구단 7단 출력
		for(int n = 1; n <= 9; n++) {
			System.out.println("7 x " + n + " = " + (7*n));
		}
		
		// 연습
		// 1 ~ 100 사이의 모든 3의 배수만 출력하기
		for(int n=1; n<=100; n++) {
			if(n % 3 == 0) {
				System.out.print(n + ",");
			}
		}
		System.out.println();
		
		int wallet = 0;
		wallet += 1000;
		wallet += 2000;
		wallet += 3000;
		System.out.println(wallet);
		// 연습 (위에 참고)         
		// 1 ~ 100 모든 정수 더하기
		int total = 0;
		for(int n = 1; n<=100; n++) {
			total += n;
		}
		System.out.println("전체 합: " + total);
		
		// 연습
		// begin ~ end 모든 정수 더하기
		// begin ~ end중 누가 큰 지 모르는 상황
		// begin을 end보다 항상 작은 값으로 바꾼 뒤 begin ~ end 모두 더하기 진행
		int begin = 100;
		int end = 0;
		int temp;
		int sum = 0;
		if(begin > end) {
			temp = begin;
			begin = end;
			end = temp;
			System.out.println(begin);
			System.out.println(end);
		}
		for(int n = begin; n <= end; n++ ) {
			sum += n;
		}
		System.out.println(sum);
		
		// 연습
		// 평점(1~5)에 따른 별(★) 출력하기
		int point = 3;
		String star = "";
		for(int i = 0; i < point; i++) {
			star += "★";
		}
		System.out.println(star);

	}

}
