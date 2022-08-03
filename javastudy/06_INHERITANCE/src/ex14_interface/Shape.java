package ex14_interface;

public interface Shape {
	
	// final 상수
	public final static double PI = 3.141592; // static 생략 가능
	
	// 추상메소드
	public abstract double getArea(); // abstract 생략 가능  
	                                  // public 생략가능하지만 그냥 쓴다.
	// default 메소드 - 본문이 있는 메소드
	public default void message() {
		System.out.println("나는 도형이다.");
	}

}
/*
인터페이스                                                        
public class
public interface  둘 다 자바 파일

1번 public abstract void a();
2번 public void a();         // abstract를 빼도 1번처럼 구현
3번 void a();                // public abstract를 빼도 1번처럼 구현

public abstract class A {                          인터페이스화 ->      public interface A {
	public abstract void a();                                           	public void a();
	public abstract void b();                                           	public void b();
	public void c() {  };                                               	default void  c() {  };  // -> 본문이 있는 메소드는 1.8 이전에는 지원하지 않음 
}                                                                                                //      public void c() {  };와 같은 코드이다.
                                                                            					 //      여전히 본문이 없는 메소드를 많이 사용한다.
public class B extends A {                                              }
	@Override
	public void a();                                                    public class B implements A {
	@Override                                                           	@Override
	public void b();                                                    	public void a();
}                                                                       	@Override
                                                                        	public void b();
A obj = new B();                                                        }
obj.a();                                                                                   
A 클래스의 a() 메소드를 실행하면 정적바인딩                             A obj = new B(); 
B 클래스의 a() 메소드를 실행하면 동적바인딩                             obj.a();
obj.b();                                                                obj.b();
obj.c();                                                                obj.c();
인터페이스의 뿌리는 추상클래스이다.
*/