package prac3;

public class Customer {
	// 필드
	private int money;
	private int cnt; // 구매한 빵개수

	// 생성자
	public Customer(int money) {
		this.money = money;
	}

	// 구매 (구매 후 출력)
	// Bakery에서 판매한 빵을 가질 수 있다.(Bakery의 sell() 메소드 사용)
	public void buy(Bakery bakery, int buyMoney) {
		if (money - buyMoney < 0) {
			throw new RuntimeException("구매 불가");
		}
		BreadAndChange bnc = bakery.sell(buyMoney);
		money += bnc.getChange();
		money -= buyMoney;
		cnt += bnc.getBread();
		System.out.println("구매한 빵 " + cnt + "개, 남은돈" + money + "원");
	}

}
