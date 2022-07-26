package ex04.condition;

public class Ex03 {

	public static void main(String[] args) {
		// 조건 연산자
		// 조건을 만족하는 경우와 그렇지 않은 경우 모두를 처리하는 연산
		// 형식
		//     조건 ? 만족하는 경우 결과 : 만족하지 않는 경우
		
		int score = 50;
		String result = (score >= 60) ? "합격" : "불합격";
		System.out.println(result);
		
		// 연습
		// 순위가 1이면 "금메달" 순위가 2이면 "은메달" 순위가 3이면 "동메달"
		// 나머지 순위는 "없음"
		int rank = 4;
		String medal = (rank == 1) ? "금메달" : (rank == 2) ? "은메달" : (rank == 3) ? "동메달" : "없음";
		System.out.println(medal);
		
		// 연습
		// 홀수는 "홀수", 짝수는 "짝수"
		// 힌트
		// 홀수 2로 나눈 나머지가 1인 수 ┐ 홀수 짝수 구할 때 필요하니까 기억해두기
		// 짝수 2로 나눈 나머지가 0인 수 ┘
		int n = 1;
		String type1 = (n % 2 == 1) ? "홀수" : "짝수";
		System.out.println(type1);
		
		// 연습
		// 홀수는 "홀수", 짝수는 "짝수", 3의배수는 "3의 배수"
		// 힌트
		// 3의배수 3으로 나눈 나머지가 0인 수(단, 0은 고려하지 않는다.)
		int x = 3;
		String type2 = (x % 3 == 0) ? "3의배수" : (x % 2 == 1) ? "홀수" : "짝수";
		System.out.println(type2);
		
		// 연습
		// 주민등록번호 뒷 7자리 중 첫 번째 숫자가 1, 3, 5이면 "남자", 2, 4, 6이면 "여자" 
		// 7자리의 첫 번째 자리만 사용할 방법 1000000으로 나누면 첫 번째 자리의 숫자만 남는다.
		int serial = 1234567;
		String gender = ((serial / 1000000) % 2 == 1 ) ? "남자" : ((serial / 1000000) % 2 == 0) ? "여자" : "";
		System.out.println(gender);

	}

}
