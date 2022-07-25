package ex04_input;

import javax.swing.JOptionPane;

public class Ex01_JOptionPane {

	public static void main(String[] args) {
		// java.swing.JOptionPane 클래스
		// GUI 틀을 제공하는 클래스
		// 공부할 필요 없다.
		
		String name = JOptionPane.showInputDialog("이름을 입력하세요");
		String age = JOptionPane.showInputDialog("나이를 입력하세요");
		
		System.out.println(name);
		System.out.println(age);
		
		// 입력받은 값은 전부 String 타입이다.
		

	}

}
