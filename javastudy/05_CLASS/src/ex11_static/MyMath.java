package ex11_static;

public class MyMath {
	
	// static
	// 1. 정적 요소
	// 2. 객체 생성 이전에 메모리에 미리 만들어 지는 공유 요소
	// 3. 클래스에서 1개만 만들어 짐
	// 4. 클래스를 이용해서 호출하기 때문에 클래스 변수, 클래스 메소드라고 부른다.
	
	// 필드        ┌> 공개(public)해도 되는 이유 final로 인해 값이 바뀌지 않아서 
	public static final double PI = 3.141592; // 클래스 변수
	
	// 메소드
	public static int abs(int n) {  // 클래스 메소드
		return (n >= 0) ? n : -n;
	}
	
	public static int pow(int a, int b) {
		int result = 1;
		for(int cnt=0; cnt<b; cnt++) {
			result *= a;
		}
		return result;
	}

}
