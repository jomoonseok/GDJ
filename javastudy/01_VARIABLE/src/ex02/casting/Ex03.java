package ex02.casting;

public class Ex03 {

	public static void main(String[] args) {
		// 사용자가 웹에서 입력한 모든 데이터는 문자열이다. 
		// 문자열을 기본 타입으로 바꿔줘야 한다.
		
		String strScore = "100";
		String strMoney = "10000000000";
		String strGrade = "4.5";
		
		// 문자열을 숫자데이터로 변환하기 (자주 사용)
		// 아래 변환은 매우 중요하다.
		int score = Integer.parseInt(strScore);  // 첫 번째 문자 대문자면 무조건 클래스 int의 기능을 모아놓은 클래스
		long money = Long.parseLong(strMoney);
		double grade = Double.parseDouble(strGrade);
		
		System.out.println(score);
		System.out.println(money);
		System.out.println(grade);
		
		// 숫자 데이터를 문자열로 변환하기 (가끔 사용)
		// 100 → "100", 4.5 → "4.5"
		int age = 100;
		String strAge = String.valueOf(age);
		System.out.println(strAge);
		
		
		
	}

}
