package ex01_branch;

public class Ex01_if {

	public static void main(String[] args) {
		// if
		// 조건을 만족하는 경우에만 실행
		// if(조건) {
		//		실행문
		// }
		// 들여쓰기 지켜주기 특히 다른 사람 코드를 가져왔을 때 
		// 코드를 정리할 줄 알아야 한다. tab, shift + tab 활용
		// 다른 사람이 봤을 때 변수의 이름으로 어떤 코드인지 알 수 있게 해야한다.

		int score = 100;
		
		if(score >= 60) {
			System.out.println("합격");
			System.out.println("축하합니다.");
		}
		
		if(score < 60) {
			System.out.println("불합격");
		}
	}

}
