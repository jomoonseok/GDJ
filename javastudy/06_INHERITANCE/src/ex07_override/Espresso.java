package ex07_override;

public class Espresso extends Coffee {
	
	/*
	메소드 오버라이딩
	슈퍼가 가지고 있는 메소드를 쓰지 않고 다시 재정의 하는 것을 오버라이딩이라고 한다.

	유일한 규칙 - 반드시 슈퍼클래스의 메소드와 동일한 원형(반환타입, 메소드명, 매개변수)으로 만들어야 한다.

	권장 규칙 - @Override(오버라이드 애너테이션) java한테 다시 만들었다고 알려준다.

	애너테이션이 필수는 아니지만 넣어주면 좋다. 왜냐면 java 뿐만 아니라 사람들에게도 알려줄 수 있다.
	*/
	
	// 오버라이드 할 때 자동완성 단축키를 누르면 오버라이드가 있다.
	// Source에도 있다.
	
	@Override // 애너테이션이 없으면 이름이 달라도 오류가 나지 않는다.
	public void taste() { 
		System.out.println("쓰다");
	}

}
