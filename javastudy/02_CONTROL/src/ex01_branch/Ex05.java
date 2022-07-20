package ex01_branch;

public class Ex05 {

	public static void main(String[] args) {
		//switch

		// 연습
		// 각 층별 관리자를 출력
		// 1 ~ 2  : 전지현
		// 3 ~ 4  : 한지민
		// 5 ~ 6  : 박은빈
		// 나머지 : 박보검 
		int floor = 16;
		String manager;
		switch(floor) {
		case 1 :
		case 2 : manager = "전지현"; break;
		case 3 : 
		case 4 : manager = "한지민"; break;
		case 5 :
		case 6 : manager = "박은빈"; break;
			default : manager = "박보검";
		}
		System.out.println(floor + "층의 관리자는 " + manager);

		// 연습
		// 짝수, 홀수
		int n = 55;
		switch(n % 2) {
		case 0 : System.out.println("짝수"); break;
		case 1 : System.out.println("홀수"); 
		}

		// 연습
		// 분기 출력하기
		// 1~3 1분기
		// 4~6 2분기
		// 7~9 3분기
		// 10~12 4분기
		int month = 3;
		switch((month-1) / 3) {
		case 0 : System.out.println("1분기"); break;
		case 1 : System.out.println("2분기"); break;
		case 2 : System.out.println("3분기"); break;
		case 3 : System.out.println("4분기"); break;
		}
		// 연습
		// 점수에 따른 학점
		int score = 25;
		String grade;
		switch(score / 10) {          //          score를 10으로 나누면 몫으로 공통된 값을 가질 수 있다.
		case 10 :
		case 9 : grade = "A"; break;  // 100~ 90  100~90 여기가 문제 그러면 100만 따로 분리
		case 8 : grade = "B"; break;  // 89 ~ 80
		case 7 : grade = "C"; break;  // 79 ~ 70
		case 6 : grade = "D"; break;  // 69 ~ 60
		default : grade = "F";        // 59 ~ 0
		}
		System.out.println(score + "점은 " + grade + "학점");

		// 연습
		// 등급(1, 2, 3)에 따른 권한 출력
		// 1등급 : 쓰기 실행 읽기
		// 2등급 : 실행 읽기
		// 3등급 : 읽기
		// 나머지 : 없음
		
		int level = 5;
		String right = ""; // 권한
		
		switch(level) {
		case 1 : right += "쓰기, ";
		case 2 : right += "실행, ";
		case 3 : right += "읽기 "; break;
		default : right += "없음";
		}
		System.out.println(level + "등급의 권한은 " + right);
		

	}

}
