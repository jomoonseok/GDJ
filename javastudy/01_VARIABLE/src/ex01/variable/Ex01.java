package ex01.variable;

public class Ex01 {

	public static void main(String[] args) {
		//single comment - 한 줄짜리 주석(설명)
		/*
		   multiple comment 
		   여러 줄의 주석
		 */
		
		// 키워드 이름 규칙 
		// 1. 패키지 : 모두 소문자 실제로는 회사 도메인을 거꾸로 작성.( com.samsung.galaxy)
		// 2. 클래스 : 각 단어의 첫 글자만 대문자 나머지는 소문자. (Upper Camel Case)
		// 3. 변수/메소드 : 첫 글자는 소문자 이후 단어는 첫 글자 대문자 나머지 소문자 (Lower Camel Case)
		// 4. 상수 : 모두 대문자 밑줄(_)로 연결 (Snake Case)
		
		// main 메소드
		// 1. 자바 프로젝트를 실행할 때는 반드시 필요하다.
		// 2. JVM (Java Virtual Machine)은 열려 있는 main 메소드를 실행한다.
		// 3. 열려 있는 main 메소드가 없으면 최근에 실행한 main 메소드를 실행한다.
		
		// 변수 선언
		// 사용할 변수의 데이터타입과 이름을 미리 결정해야한다.
		// 형식
		// 데이터타입 변수명 = 초기값 (가급적이면 초기값은 바로 주자)
		
		// 논리 타입
		boolean isGood = true; // is로 시작하면 대부분 boolean 타입 규칙은 아니고 관습이다.
		boolean isAlive = false; // ;은 문장 끝나면 찍어주는 마침표 같은 것
		System.out.println(isGood);
		System.out.println(isAlive);
		
		// 문자(character) 타입
		char ch1 = 'A'; // 문자는 한 글자를 말함 두 글자 이상은 안 됨 , 한 글자는 작은 따옴표로 묶어줘야 한다.
		char ch2 = '홍'; // 한글도 한 글자라면 저장할 수 있다.
		char ch3 = '\n'; // \는 이스케이프 문자 \n 라인 피드 - 줄 바꿈
		char ch4 = '\t'; // tab 키
		char ch5 = '\''; // 작은 따옴표를 출력할 때도 이스케이프 문자 
		char ch6 = '\"'; // 큰 따옴표도 마찬가지
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);
		System.out.println(ch6);
		
		// 정수 타입
		int score = 100;
		long view = 10000000000L;  // long 타입의 값은 마지막에 L, l을 추가해야 한다. 0을 보내더라도 L을 붙여줘야 한다.
		System.out.println(score);
		System.out.println(view);
		
		// 실수 타입
		double discount = 0.5;
		double pi = 3.1415926535;
		System.out.println(discount);
		System.out.println(pi);
		
	}

}
