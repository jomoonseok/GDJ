package ex01_random;

public class Ex01 {
		  
	public static void main(String[] args) {
		// 난수(random number) 발생
		// Random 클래스 , Math 클래스 주로 활용한다. 
		
		System.out.println(Math.random());
		
		// 0.0 <= Math.random() < 1.0
		// 0%  <= Math.random() < 100%
		
		// 1. 확률 처리하기
		// 10% 확률로 "대박" 90% 확률로 "쪽박"
		if(Math.random() < 0.1) {
			System.out.println("대박");
		} else {
			System.out.println("쪽박");
		}
		
		// 2. 난수 값 생성
		// Math.random()                    0.0 <= n < 1.0
		// Math.random() * 5                0.0 <= n < 5.0
		// (int)(Math.random() * 5)           0 <= n < 5
		// (int)(Math.random() * 5) + 1       1 <= n < 6
		
		// 주사위 출력
		int dice1 = (int)(Math.random() * 6) + 1;
		int dice2 = (int)(Math.random() * 6) + 1;
		System.out.println(dice1 + " " + dice2);
		for(int i = 0; i < 2; i++) {
			int dice3 = (int)(Math.random() * 6) + 1;
			System.out.println("주사위 " + dice3);
		}
		
		// 연습
		// 6자리 숫자로 된 인증번호 만들기
		// String code = "501924"
		// 보안문제로 보안 코드를 이렇게 만들어서 사용하지는 않는다. (외부에서 만든 라이브러리가 있음)
		String code = "";
		for(int i = 0; i < 6; i++) {
			int j = (int)(Math.random() * 10);
			code += j;
		}
		System.out.println(code);
		
		System.out.println((char)((int)(Math.random() * 26) + 'A')); // 시작하는 유니코드 넣어줘도 된다.
		System.out.println((char)((int)(Math.random() * 26) + 'a'));
		
		// 연습
		// 6자리 영문(대문자 + 소문자) 인증번호 만들기
		
		String code2 = "";
		for(int i = 0; i < 6; i++) {
			if(Math.random() < 0.5) { 
				code2 += (char)((int)(Math.random() * 26) + 'A');
			} else {
				code2 += (char)((int)(Math.random() * 26) + 'a');
			}
		}
		System.out.println(code2);
		
	}

}
