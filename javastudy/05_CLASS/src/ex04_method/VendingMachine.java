package ex04_method;

public class VendingMachine {

	/*String getCoffee(String m, String b) {
		String str = "";
		if(b.equals("1")) {
			str += "아메리카노 " + (Integer.parseInt(m) / 1000) + "잔";
		} else if(b.equals("2")) {
			str += "카페라떼 " + (Integer.parseInt(m) / 1000) + "잔";
		}
		return str;
	}*/
	
	String getCoffee(int money, int button) {
		String[] menu = {"아메리카노", "카페라떼"};
		return menu[button -1] + " " + (money / 1000) + "잔";
		
		/*
		String[] menu = {"", "아메리카노", "카페라떼"};     // 인덱스 0번에 빈 문자열을 넣어서
		return menu[button] + " " + (money / 1000) + "잔";  // button과 인덱스 번호를 맞춤
		*/
	}
	
	
	
	
}
