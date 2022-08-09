package prac3;

public class Main {

	public static void main(String[] args) {

		Bakery paris = new Bakery(500, 100, 10000); // 빵1개 500원, 빵100개, 자본금 10000
		Bakery tour = new Bakery(1000, 50, 10000); // 빵1개 1000원, 빵50개, 자본금 10000

		Customer customer = new Customer(20000);

		try {
			//customer.buy(paris, 30000); // 구매 불가
			//customer.buy(tour, 500);    // 판매 불가
			customer.buy(paris, 10000); // 구매한빵 20개, 남은돈 10000
			customer.buy(tour, 5000);   // 구매한빵 25개, 남은돈 5000
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		paris.info(); // 빵 80개, 자본금 20000원
		tour.info(); // 빵 45개, 자본금 15000원

	}

}
