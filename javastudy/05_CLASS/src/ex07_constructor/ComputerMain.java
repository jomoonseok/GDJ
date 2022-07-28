package ex07_constructor;

public class ComputerMain {

	public static void main(String[] args) {
		                                  //┌> 인수(인자) 매개변수로 전달 되는 값.
		Computer myCom = new Computer("gram", 150); // 만들지 않았지만 Computer 메소드(디폴트 생성자)가 있다.
		myCom.printComputerStatus();
		
		Computer yourCom = new Computer(); // 인수가 없는 생성자를 사용하려면 매개변수를 받지 않는 생성자가 있어야 한다.
		yourCom.printComputerStatus();

	}

}
