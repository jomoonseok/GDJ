package ex05.String;

public class Ex01 {

	public static void main(String[] args) {
		// 문자열 연결 연산자
		// 문자열이 포함된 + 연산은 연결
		
		String str1 = "구디" + "아카데미";
		String str2 = 100 + "번지";
		String str3 = 1 + 1 + "행사";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		// + 연산을 이용한 문자열 만들기
		// 빈 문자열("")을 + 해주면 된다. 
		String str4 = 100 + ""; // String.valueOf(100)과 동일 / 빈 문자열을 더해주는 걸 더 많이 사용한다.
		System.out.println(str4); 
		

	}

}
