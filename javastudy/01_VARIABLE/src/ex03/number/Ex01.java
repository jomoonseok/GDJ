package ex03.number;

public class Ex01 {

	public static void main(String[] args) {
		// 산술 연산
		int a = 7;
		int b = 2;
		int result1 = a + b;
		int result2 = a - b;
		int result3 = a * b;
		int result4 = a / b; // 몫을 구할 때 사용
		int result5 = a % b; // 나머지를 구할 때 % 사용
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		
		// 연습
		// 25를 2와 5로 나눠보기
		int n = 25;
		int ten = n / 10; // 2
		int one = n % 10; // 5
		System.out.println(ten);
		System.out.println(one);
		
		// 연습
		// 90초를 1분 30초로 나눠보기
		int second = 90;
		int m = second / 60; // 1
		int s = second % 60; // 30
		System.out.println(m);
		System.out.println(s);
		
		// 연습
		// a = 7 b = 2
		// a / b = 3.5
		double result = (double) a / b; 
		// b를 강제 형 변환해서 실수로 바꿔준다. 정수와 실수가 섞여 있으면 무조건 실수가 된다.
		System.out.println(result);
	}

}
