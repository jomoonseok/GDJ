package ex04.condition;

public class Ex02 {

	public static void main(String[] args) {
		// 논리 연산자
		// 논리 AND : &&, 모두 true 이면 true / 하나라도 false 이면 false
		// 논리 OR  : ||, 하나라도 true이면 true / 모두 false이면 false
		// 논리 NOT : !, true는 false로 바꿔주고 false는 true로 바뀐다.
		
		int a = 10;
		int b = 10;
		boolean result1 = (a == 10) && (b == 10); // true 괄호는 권장 사항
		boolean result2 = (a == 10) || (b == 10); // true
		boolean result3 = (a == 10) && (b == 20); // false
		boolean result4 = (a == 10) || (b == 20); // true
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		
		int c = 10;
		
		boolean result5 = !(c == 10); // false
		boolean result6 = !(c == 20); // true
		
		System.out.println(result5);
		System.out.println(result6);
		
		// 연습
		// 변수 n을 10증가시킨 뒤 n이 100보다 크다면 true, 아니면 false
		int n = 95;
		boolean result7 = (n += 10) > 100 ; 
		System.out.println(n);              // 105
		System.out.println(result7);        // true
		
		// 연습
		// 변수 x를 1 증가시킨 뒤 x가 10과 같으면 true, 아니면 false
		int x = 9;
		boolean result8 = ++x == 10;
		System.out.println(x);
		System.out.println(result8);
		
		// short Circuit Evaluation
		// 논리 AND : false가 발생하면 더 이상 진행하지 않는다. 최종 결과는 false이므로.
		// 논리 OR  : true가 발생하면 더 이상 진행하지 않는다. 최종 결과는 true이므로.
		int i = 10;
		int j = 10;
		boolean result9 = (i == 20) && (++j == 11);
		System.out.println(result9); // false
		System.out.println(j); // 11이 아니다. 10이 나온다.
		
		boolean result10 = (i == 10) || (++j == 11);
		System.out.println(result10); // true
		System.out.println(j); // 11이 아니다. 10이 나온다.

		// 비교와 연산이 같이 있으면 연산은 뒤쪽으로
		// a == 1 && b == 2 && c == 3 && (a + b + c) == 6; 
		// (a + b + c) == 6 && a == 1 && b == 2 && c == 3;  
	}

}
