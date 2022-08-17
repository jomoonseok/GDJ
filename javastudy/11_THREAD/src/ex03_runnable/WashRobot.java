package ex03_runnable;

// 스레드 생성 방법
// 1. Runnable 인터페이스 구현
// 2. public void run() 오버라이드 - run() 메소드만 있다.
// start() 메소드는 Thread 클래스에 있다.
public class WashRobot extends Robot implements Runnable{
	private String name;
	
	public WashRobot(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " 빨래중");
		
	}
}
